package fi.tuni.monitor.models;

import fi.tuni.monitor.data.AsyncDataFetch;
import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.data.MaintenanceTask;
import fi.tuni.monitor.roadapi.ApiException;
import fi.tuni.monitor.roadapi.MaintenanceTaskFetcher;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingPropertiesV1;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Model for handling maintenance task visualization related data and operations<br>
 * Is a part of the MVC pattern
 */
public class MaintenanceTaskModel implements AsyncDataFetch
{
    private List<MaintenanceTask> maintenanceTasks = new ArrayList<>();
    private LocalDateTime startTime = null;
    private LocalDateTime endTime = null;
    private boolean specificTypeSelected = false;

    private MaintenanceTrackingPropertiesV1.TasksEnum typeSelected = null;

    private BoundingCoordinates coordinates = null;
    private CompletableFuture<Void> isDataFetchComplete = null;

    /**
     * Constructor for MaintenanceTaskModel
     */
    public MaintenanceTaskModel() {
    }

    /**
     * Constructor for MaintenanceTaskModel
     * @param startTime start time of visualization time period
     * @param endTime end time of visualization time period
     * @param specificTypeSelected type selected for visualization
     * @param coordinates Bounding coordinates for the area to visualize data from
     */
    public MaintenanceTaskModel(LocalDateTime startTime,
                                LocalDateTime endTime,
                                boolean specificTypeSelected,
                                BoundingCoordinates coordinates) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.specificTypeSelected = specificTypeSelected;
        this.coordinates = coordinates;
    }
    /**
     * Format axis for the timeline view of road maintenance tasks
     * @param plot the plot to format axis for
     */
    private void formatXYAxis(XYPlot plot) {
        DateAxis timeAxis = (DateAxis) plot.getDomainAxis();
        ValueAxis valueAxis = plot.getRangeAxis();
        var time1 = timeAxis.getMaximumDate().toInstant();
        var time2 = timeAxis.getMinimumDate().toInstant();
        long daysDiff = time2.until(time1, ChronoUnit.DAYS);

        if (valueAxis.getUpperBound() < 1) {
            valueAxis.setUpperBound(10);
            valueAxis.setLowerBound(0);
        }
        if (daysDiff <= 8) {
            timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 1));
        }
        else if (daysDiff <= 16) {
            timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 2));
        }
        else if (daysDiff <= 24) {
            timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 3));
        }
        else if (daysDiff <= 31) {
            timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 4));
        }
        else {
            timeAxis.setAutoRange(true);
        }
        timeAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        timeAxis.setDateFormatOverride(new SimpleDateFormat("dd.MM"));
    }
    /**
     * Get timeline of specific road maintenance tasks
     * @return JFreeChart of timeline of specific road maintenance tasks
     */
     public JFreeChart createRoadMaintenanceTimeLineChart() {
        JFreeChart chart = ChartFactory.createXYBarChart(
                "",
                "Date",
                true,
                "Count",
                this.getTimeSeriesData(),
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        XYPlot plot = chart.getXYPlot();
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardXYBarPainter());
        formatXYAxis(plot);
        return chart;
    }

    /**
     * Fetches data from Digitraffic API
     */
    private void fetchData() {
        this.isDataFetchComplete = CompletableFuture.runAsync(() -> {
            try {
                this.maintenanceTasks = new MaintenanceTaskFetcher().getMaintenanceTasks(this.coordinates, this.startTime, this.endTime);
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Fetches data for pie chart.
     * @return Dataset to visualize pie chart data
     */
    public DefaultPieDataset<String> getPieChartData() {
        DefaultPieDataset<String> pieChartData = new DefaultPieDataset<>();
        this.maintenanceTasks
                .stream()
                .map(MaintenanceTask::tasks)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach(pieChartData::setValue);

        return pieChartData;
    }
    /**
     * Creates a new time series collection for bar chart.
     * @return time series collection for XY bar chart
     */
    public TimeSeriesCollection getTimeSeriesData() {
        TimeSeries timeSeries = new TimeSeries("Count");

        this.maintenanceTasks
                .stream()
                .collect(Collectors.groupingBy(
                        task -> new Day(Date.from(task.startTime().atZone(ZoneId.systemDefault()).toInstant())),
                        Collectors.mapping(task -> Collections.frequency(
                                        task.tasks(),
                                        this.typeSelected.prettifiedValue())
                                , Collectors.summingInt(Integer::intValue))))
                .forEach(timeSeries::add);
        return new TimeSeriesCollection(timeSeries);
    }
    public List<MaintenanceTask> getMaintenanceTasks() {
        return maintenanceTasks;
    }

    public void setMaintenanceTasks(List<MaintenanceTask> maintenanceTasks) {
        this.maintenanceTasks = maintenanceTasks;
    }

    /**
     * Gets the start time of the visualization
     * @return start time of the visualization
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }
    /**
     * Sets the start time of the visualization
     * @param startTime start time of the visualization
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    /**
     * Gets the end time of the visualization
     * @return end time of the visualization
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }
    /**
     * Sets the end time of the visualization
     * @param endTime end time of the visualization
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public boolean isSpecificTypeSelected() {
        return specificTypeSelected;
    }

    /**
     * Sets boolean to check if type of data is selected to be specific
     * @param specificTypeSelected
     */
    public void setSpecificTypeSelected(boolean specificTypeSelected) {
        this.specificTypeSelected = specificTypeSelected;
    }

    /**
     * Gets the type of maintenance task selected
     * @return
     */
    public MaintenanceTrackingPropertiesV1.TasksEnum getTypeSelected() {
        return typeSelected;
    }

    /**
     * Sets type selected
     * @param typeSelected type of data visualization selected
     */
    public void setTypeSelected(MaintenanceTrackingPropertiesV1.TasksEnum typeSelected) {
        this.typeSelected = typeSelected;
    }

    /**
     * Gets the coordinates of the visualiation
     * @return coordinates of the visualization
     */
    public BoundingCoordinates getCoordinates() {
        return coordinates;
    }
    /**
     * Sets the coordinates of the visualization
     * @param coordinates coordinates of the visualization
     */
    public void setCoordinates(BoundingCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public CompletableFuture<Void> getIsDataFetchComplete() {
        return isDataFetchComplete;
    }

    /**
     * Updates all datasets
     */
    public void updateData() {
        this.fetchData();
    }
}
