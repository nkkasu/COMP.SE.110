package fi.tuni.monitor.models;

import fi.tuni.monitor.data.AsyncDataFetch;
import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingPropertiesV1;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeriesCollection;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
/**
 * Model for handling combined visualization related data and operations<br>
 * A part of the MVC pattern
 */
public class CombinedDataModel implements AsyncDataFetch
{
    CompletableFuture<Void> isDataFetchComplete = null;
    private WeatherDataModel weatherDataModel = null;
    private MaintenanceTaskModel maintenanceTaskModel = null;
    private LocalDateTime startTime = null;
    private LocalDateTime endTime = null;
    private MaintenanceTrackingPropertiesV1.TasksEnum typeSelected = null;
    private BoundingCoordinates coordinates = null;

    /**
     * Constructor for CombinedDataModel
     * @param weatherDataModel model which used to fetch weather data for Combined model
     * @param maintenanceTaskModel model which used to fetch maintenance data for Combined model
     */
    public CombinedDataModel(WeatherDataModel weatherDataModel, MaintenanceTaskModel maintenanceTaskModel) {
        this.weatherDataModel = weatherDataModel;
        this.maintenanceTaskModel = maintenanceTaskModel;
        startTime = weatherDataModel.getStartTime();
        endTime = weatherDataModel.getEndTime();
    }

    /**
     * Set coordinate data for models
     * @param coordinates
     */
    public void setCoordinates(BoundingCoordinates coordinates) {
        this.coordinates = coordinates;
        weatherDataModel.setCoordinates(coordinates);
        maintenanceTaskModel.setCoordinates(coordinates);
    }

    /**
     * Formats the time axis of a time series chart for better user experience
     * @param plot XYPlot of the time series chart to format
     */
    private void formatXYAxis(XYPlot plot) {
        DateAxis timeAxis = (DateAxis) plot.getDomainAxis();
        timeAxis.setAutoTickUnitSelection(true);
        ValueAxis valueAxis = plot.getRangeAxis();
        var time1 = timeAxis.getMaximumDate().toInstant();
        var time2 = timeAxis.getMinimumDate().toInstant();
        long daysDiff = time2.until(time1, ChronoUnit.DAYS);
        double diff = valueAxis.getUpperBound() - valueAxis.getLowerBound();
        if (diff < 1) {
            valueAxis.setUpperBound(9);
            valueAxis.setLowerBound(0);
        }
        if (daysDiff <= 15) {
            timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 1));
        }
        else {
            timeAxis.setAutoRange(true);
        }
        timeAxis.setDateFormatOverride(new SimpleDateFormat("dd.MM"));
        timeAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
    }

    /**
     * Fetch daily data from FMI and Digitraffic api
     */
    private void fetchData() {
        this.isDataFetchComplete = CompletableFuture.runAsync(() -> {
            weatherDataModel.updateDatasets();
            maintenanceTaskModel.updateData();
        });
    }

    /**
     * Set type of Maintenance task to fetch
     * @param typeSelected type of maintentance task selected
     */
    public void setTypeSelected(MaintenanceTrackingPropertiesV1.TasksEnum typeSelected) {
        this.typeSelected = typeSelected;
        maintenanceTaskModel.setTypeSelected(typeSelected);
    }

    /**
     * Updates all datasets for daily FMI and Digitraffic data
     */
    public void updateDatasets() {
        fetchData();
    }

    /**
     * Set the start time of the visualization
     * @param startTime start time of the visualization
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        weatherDataModel.setStartTime(startTime);
        maintenanceTaskModel.setStartTime(startTime);
    }
    /**
     * Set the end time of the visualization
     * @param endTime end time of the visualization
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        weatherDataModel.setEndTime(endTime.plusDays(1).minusMinutes(1));
        maintenanceTaskModel.setEndTime(endTime);
    }
    /**
     * Creates a chart for combined line and bar chart.
     * @param weatherType weather type selected
     * @return Time series chart for combined weather and road maintenance data
     */
    public JFreeChart createLineBarChart(String weatherType) {
        TimeSeriesCollection weatherDataset = switch (weatherType) {
            case "Temperature" -> weatherDataModel.getTemperatureDataset();
            case "Clouds" -> weatherDataModel.getCloudDataSet();
            case "Windspeed" -> weatherDataModel.getWindDataset();
            default -> null;
        };
        weatherDataset.setXPosition(TimePeriodAnchor.MIDDLE);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("",
                "Date",
                weatherType,
                weatherDataset,
                true,
                false,
                false);

        XYPlot plot = chart.getXYPlot();
        formatXYAxis(plot);
        XYPlot plot1 = chart.getXYPlot();
        var weatherAxis = plot1.getRangeAxis();
        NumberAxis taskAxis = new NumberAxis("Task amount");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        taskAxis.setNumberFormatOverride(decimalFormat);
        taskAxis.setLabelFont(weatherAxis.getLabelFont());
        taskAxis.setTickLabelFont(weatherAxis.getTickLabelFont());

        plot1.setRangeAxis(1, taskAxis);
        plot1.setDataset(1, maintenanceTaskModel.getTimeSeriesData());
        plot1.mapDatasetToRangeAxis(1, 1);

        XYBarRenderer taskRenderer = new XYBarRenderer();
        taskRenderer.setBarPainter(new StandardXYBarPainter());
        taskRenderer.setSeriesPaint(0, Color.YELLOW);
        plot1.setRenderer(1, taskRenderer);

        if (weatherType.equals("Temperature")) {
            XYItemRenderer renderer = plot.getRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesPaint(1, Color.GREEN);
            renderer.setSeriesPaint(2, Color.BLACK);
        }
        return chart;
    }
    @Override
    public CompletableFuture<Void> getIsDataFetchComplete() {
        return isDataFetchComplete;
    }
}
