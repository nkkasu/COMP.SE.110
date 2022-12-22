package fi.tuni.monitor.models;

import fi.tuni.monitor.data.AsyncDataFetch;
import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.data.WeatherData;
import fi.tuni.monitor.weatherapi.WeatherFetcher;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Model for handling weather visualization related data and operations<br>
 * Part of the MVC pattern
 */
public class WeatherDataModel implements AsyncDataFetch
{


    private List<WeatherData> weatherDataItems = new ArrayList<>();
    LocalDateTime startTime = null;
    LocalDateTime endTime = null;
    BoundingCoordinates coordinates = null;

    TimeSeriesCollection temperatureDataset = new TimeSeriesCollection();
    TimeSeriesCollection windDataset = new TimeSeriesCollection();
    TimeSeriesCollection cloudDataSet = new TimeSeriesCollection();
    CompletableFuture<Void> isDataFetchComplete = null;

    /**
     * Constructor for WeatherDataModel
     */
    public WeatherDataModel() {
    }

    /**
     * Constructor for WeatherDataModel
     * @param startTime Start time of the visualization time period
     * @param endTime End time of the visualization time period
     * @param weatherDataItems List of WeatherData objects from which visualizations are created
     * @param coordinates Bounding coordinates for the area to visualize data from
     */
    public WeatherDataModel(LocalDateTime startTime, LocalDateTime endTime,
                            List<WeatherData> weatherDataItems, BoundingCoordinates coordinates) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.weatherDataItems = weatherDataItems;
        this.coordinates = coordinates;
    }

    /**
     * Fetches daily data from FMI API
     */
    private void fetchData() {
        this.isDataFetchComplete = CompletableFuture.runAsync(() -> {
            weatherDataItems = new WeatherFetcher().getDailyWeatherData(startTime, endTime, coordinates);
        });
    }

    /**
     * Fetches hourly forecast data from FMI API
     */
    private void fetchHourlyData() {
        this.isDataFetchComplete = CompletableFuture.runAsync(() -> {
            weatherDataItems = new WeatherFetcher().getHourlyForecastWeatherData(startTime, endTime, coordinates);
        });
    }

    /**
     * Fetches daily data from FMI API and updates the datasets used in weather visualizations
     * by calling method {@link #updateDatasets(boolean dailyData) updateDatasets(boolean dailyData)}
     * with dailyData as true
     */
    public void updateDatasets() {
        this.updateDatasets(true);
    }

    /**
     * Fetches data from FMI API and updates the datasets used in weather visualizations
     * @param dailyData If true, fetches daily data. Else fetches hourly forecast data.
     */
    public void updateDatasets(boolean dailyData) {
        if (dailyData) {
            fetchData();
        }
        else {
            fetchHourlyData();
        }

        try {
            this.getIsDataFetchComplete().get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e);
        }

        temperatureDataset = new TimeSeriesCollection();
        windDataset = new TimeSeriesCollection();
        cloudDataSet = new TimeSeriesCollection();

        TimeSeries avgTempSeries = new TimeSeries("Temperature");
        TimeSeries maxTempSeries = new TimeSeries("Max temperature");
        TimeSeries minTempSeries = new TimeSeries("Min temperature");
        TimeSeries windSeries = new TimeSeries("Wind");
        TimeSeries cloudSeries = new TimeSeries(("Cloudiness"));

        for (WeatherData item : weatherDataItems) {

            Double avgTemp = item.getTemperatureAvg();
            Double maxTemp = item.getMaxTemperature();
            Double minTemp = item.getMinTemperature();
            Double windSpeed = item.getWindSpeed();
            Double cloudiness = item.getCloudiness();

            if (dailyData) {
                var day = new Day(Date.from(item.getTime().atZone(ZoneId.systemDefault()).toInstant()));
                if (avgTemp != null) avgTempSeries.add(day, avgTemp);
                if (maxTemp != null) maxTempSeries.add(day, maxTemp);
                if (minTemp != null) minTempSeries.add(day, minTemp);
                if (windSpeed != null) windSeries.add(day, windSpeed);
                if (cloudiness != null) cloudSeries.add(day, cloudiness);
            }
            else {
                var hour = new Hour(Date.from(item.getTime().atZone(ZoneId.systemDefault()).toInstant()));
                if (avgTemp != null) avgTempSeries.add(hour, avgTemp);
                if (maxTemp != null) maxTempSeries.add(hour, maxTemp);
                if (minTemp != null) minTempSeries.add(hour, minTemp);
                if (windSpeed != null) windSeries.add(hour, windSpeed);
                if (cloudiness != null) cloudSeries.add(hour, cloudiness);
            }
        }

        temperatureDataset.addSeries(avgTempSeries);
        temperatureDataset.addSeries(maxTempSeries);
        temperatureDataset.addSeries(minTempSeries);
        windDataset.addSeries(windSeries);
        cloudDataSet.addSeries(cloudSeries);
    }

    /**
     * Creates a time series chart used to visualize cloudiness
     * @return Time series chart for cloudiness
     */
    public JFreeChart createCloudinessChart() {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "",
                "Date",
                "Cloudiness",
                this.getCloudDataSet(),
                true,
                false,
                false);
        formatXYAxis(chart.getXYPlot());
        return chart;
    }

    /**
     * Creates a time series chart used to visualize temperatures and wind speed
     * @return Time series chart for temperatures and wind speed
     */
    public JFreeChart createTempWindChart() {
        this.updateDatasets();
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "",
                "Date",
                "Temperature (°C)",
                this.getTemperatureDataset(),
                true,
                false,
                false);

        XYPlot plot = chart.getXYPlot();
        DateAxis timeAxis = (DateAxis) plot.getDomainAxis();
        timeAxis.setDateFormatOverride(new SimpleDateFormat("dd.MM"));

        XYPlot plot1 = chart.getXYPlot();
        var temperatureAxis = plot1.getRangeAxis();
        NumberAxis windAxis = new NumberAxis("Wind speed (m/s)");
        windAxis.setLabelFont(temperatureAxis.getLabelFont());
        windAxis.setTickLabelFont(temperatureAxis.getTickLabelFont());

        plot1.setRangeAxis(1, windAxis);
        plot1.setDataset(1, this.getWindDataset());
        plot1.mapDatasetToRangeAxis(1, 1);
        formatXYAxis(plot1);
        return chart;
    }

    /**
     * Formats the time axis of a time series chart for better user experience
     * @param plot XYPlot of the time series chart to format
     */
    private void formatXYAxis(XYPlot plot) {
        DateAxis timeAxis = (DateAxis) plot.getDomainAxis();
        ValueAxis valueAxis = plot.getRangeAxis();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setNumberFormatOverride(decimalFormat);
        var time1 = timeAxis.getMaximumDate().toInstant();
        var time2 = timeAxis.getMinimumDate().toInstant();
        int daysDiff = (int) time2.until(time1, ChronoUnit.DAYS);
        double yRange = valueAxis.getUpperMargin() - valueAxis.getLowerBound();

        if (daysDiff <= 6) {
            timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 1));
        }
        else if (daysDiff <= 16) { timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 2));
        }
        else if (daysDiff <= 24) {
            timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 3));
        }
        else if (daysDiff <= 31) {
            timeAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 4));
        }
        else {
            timeAxis.getFixedAutoRange();
        }
        timeAxis.setDateFormatOverride(new SimpleDateFormat("dd.MM"));
    }

    /**
     * Gets the List of WeatherData objects
     * @return List of WeatherData objects
     */
    public List<WeatherData> getWeatherData() {
        return weatherDataItems;
    }

    /**
     * Sets the WeatherData objects
     * @param weatherDataItems List of WeatherData objects
     */
    public void setWeatherData(List<WeatherData> weatherDataItems) {
        this.weatherDataItems = weatherDataItems;
    }

    /**
     * Gets the start time of the visualization
     * @return start time of the visualization
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Gets the end time of the visualization
     * @return end time of the visualization
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Sets the start time of the visualization
     * @param startTime start time of the visualization
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Sets the end time of the visualization
     * @param endTime end time of the visualization
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Sets the coordinates of the visualization
     * @param coordinates coordinates of the visualization
     */
    public void setCoordinates(BoundingCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets the TimeSeriesCollection dataset used to visualize temperatures
     * @return TimeSeriesCollection dataset used to visualize temperatures
     */
    public TimeSeriesCollection getTemperatureDataset() {
        return temperatureDataset;
    }

    /**
     * Gets the TimeSeriesCollection dataset used to visualize wind speed
     * @return TimeSeriesCollection dataset used to visualize wind speed
     */
    public TimeSeriesCollection getWindDataset() {
        return windDataset;
    }

    /**
     * Gets the TimeSeriesCollection dataset used to visualize cloud cover
     * @return TimeSeriesCollection dataset used to visualize cloud cover
     */
    public TimeSeriesCollection getCloudDataSet() {
        return cloudDataSet;
    }

    public CompletableFuture<Void> getIsDataFetchComplete() {
        return isDataFetchComplete;
    }
}
