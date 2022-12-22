package fi.tuni.monitor.models;

import fi.tuni.monitor.data.AsyncDataFetch;
import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.data.Coordinate;
import fi.tuni.monitor.data.RoadConditionForecast;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.time.TimeSeriesCollection;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

/**
 * Model for handling combined visualization related data and operations<br>
 * A part of the MVC pattern
 */
public class CombinedForecastModel implements AsyncDataFetch {
    CompletableFuture<Void> isDataFetchComplete = null;
    WeatherDataModel weatherDataModel = null;
    RoadConditionForecastModel conditionForecastModel = null;
    public JFreeChart createPieChart() {
        JFreeChart chart = ChartFactory.createPieChart(
                "", this.conditionForecastModel.getPieChartData());
        return chart;
    }

    /**
     * Creates a line chart.
     * @param weatherType Weather type selected
     * @return JFreeChart presenting forecast of temperature
     */
    public JFreeChart createLineChart(String weatherType) {
        TimeSeriesCollection weatherDataset = switch (weatherType) {
            case "Temperature" -> weatherDataModel.getTemperatureDataset();
            case "Windspeed" -> weatherDataModel.getWindDataset();
            default -> null;
        };
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "",
                "\nDatetime",
                weatherType,
                weatherDataset,
                true,
                false,
                false);

        XYPlot plot = chart.getXYPlot();
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesVisible(1, false);
        renderer.setSeriesVisible(2, false);

        DateAxis timeAxis = (DateAxis) plot.getDomainAxis();
        timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.HOUR, 1));
        timeAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm\ndd.MM"));

        chart.getLegend().setHorizontalAlignment(HorizontalAlignment.RIGHT);
        return chart;
    }

    /**
     * Constructor for CombinedForecastModel
     * @param weatherDataModel model which used to fetch weather data for Combined model
     * @param roadConditionForecastModel model which used to fetch maintenance data for Combined model
     */
    public CombinedForecastModel(WeatherDataModel weatherDataModel, RoadConditionForecastModel roadConditionForecastModel) {
        this.weatherDataModel = weatherDataModel;
        this.conditionForecastModel = roadConditionForecastModel;
    }

    /**
     * Updates all datasets for daily FMI data
     */
    public void updateDatasets() {
        fetchData();
    }

    /**
     * @param coordinates Sets coordinate area.
     *
     */
    public void setCoordinates(BoundingCoordinates coordinates) {
        weatherDataModel.setCoordinates(coordinates);
        conditionForecastModel.setCoordinates(coordinates);
    }

    /**
     * Sets startTime.
     * @param startTime Sets start time.
     */
    public void setStartTime(LocalDateTime startTime) {
        weatherDataModel.setStartTime(startTime);
    }

    /**
     * Sets endTime for models.
     * @param endTime Sets end time.
     * @param hoursInFuture No end time for road data, so future hours instead
     */
    public void setEndTime(LocalDateTime endTime, int hoursInFuture) {
        weatherDataModel.setEndTime(endTime.plusHours(hoursInFuture));
        conditionForecastModel.setHours(hoursInFuture);
    }

    /**
     * Fetches date asynchronously for models.
     */
    private void fetchData() {
        this.isDataFetchComplete = CompletableFuture.runAsync(() -> {
            weatherDataModel.updateDatasets(false);
            conditionForecastModel.updateData();
        });
    }
    @Override
    public CompletableFuture<Void> getIsDataFetchComplete() {
        return isDataFetchComplete;
    }

    /**
     * Sets condition type
     * @param conditionType Condition type to set.
     */
    public void setConditionType(RoadConditionForecast.ConditionType conditionType) {
        conditionForecastModel.setConditionType(conditionType);
    }
}
