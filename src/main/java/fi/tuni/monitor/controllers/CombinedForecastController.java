package fi.tuni.monitor.controllers;

import fi.tuni.monitor.data.*;
import fi.tuni.monitor.models.CombinedForecastModel;
import fi.tuni.monitor.models.CoordinateSelectionModel;
import fi.tuni.monitor.models.RoadConditionForecastModel;
import fi.tuni.monitor.models.WeatherDataModel;
import fi.tuni.monitor.saveddata.CombinedForecastPreferences;
import fi.tuni.monitor.saveddata.MonitorConfig;
import fi.tuni.monitor.saveddata.SaveablePreferences;
import fi.tuni.monitor.saveddata.SerializationUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.time.TimeSeriesCollection;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Controller for Forecast window<br>
 * Part of the MVC pattern
 */
public class CombinedForecastController implements Initializable, SaveablePreferences {
    private static final String preferencesFile = MonitorConfig.getCombinedForecastPreferencesFile();
    BoundingCoordinates coordinates = null;
    WeatherDataModel weatherDataModel = null;

    CombinedForecastModel combinedForecastModel = null;
    RoadConditionForecastModel conditionForecastModel = null;
    @FXML
    public ChartViewer conditionPieChart;
    @FXML
    public ChartViewer combinedChart;
    @FXML
    public ChoiceBox<String> weatherTypePicker;
    @FXML
    public ChoiceBox<Integer> hoursPicker;
    @FXML
    public ChoiceBox<RoadConditionForecast.ConditionType> conditionTypePicker;
    @FXML
    public ImageView questionMark;
    /**
     * Event handler for save preferences button.
     * Saves weather visualization preferences to a file.
     * @param actionEvent Ignored event
     */
    @FXML
    public void handleSavePreferences(ActionEvent actionEvent) {
        CombinedForecastPreferences preferences = new CombinedForecastPreferences(
                this.hoursPicker.getValue(),
                this.conditionTypePicker.getValue(),
                this.weatherTypePicker.getValue()
        );
        try {
            SerializationUtil.serialize(preferences, preferencesFile);
        } catch (IOException e) {
            System.out.println("Error saving combined forecast preferences!");
        }
    }

    /**
     * Create timeseries graph for weather data
     * @param valueAxisLabel
     * @param dataset
     * @return JFreeChart
     */
    private JFreeChart createChart(String valueAxisLabel, TimeSeriesCollection dataset) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "",
                "\nDatetime",
                valueAxisLabel,
                dataset,
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
     * Sets tooltips for this view.
     */
    private void setTooltips() {
        Tooltip combinedTooltip = new Tooltip();
        combinedTooltip.setText("With combined forecast view you can fetch forecasts of weather data choices and " +
                "view them in the same pane as different forecasts related to road conditions.");
        combinedTooltip.setMaxWidth(700);
        combinedTooltip.setWrapText(true);
        combinedTooltip.setShowDelay(Duration.ZERO);
        Tooltip.install(questionMark, combinedTooltip);
        combinedTooltip.setFont(new Font(18));
    }


    /**
     * Update the state of charts after updating data
     * @param event
     */
    @FXML
    private void updateCharts(ActionEvent event) {

        combinedChart.setChart(combinedForecastModel.createLineChart(weatherTypePicker.getValue()));
        conditionPieChart.setChart(combinedForecastModel.createPieChart());
    }

    /**
     * Async handle the update on screen after user presses "Fetch Data" button
     * @param event
     */
    private void asyncUpdateData(ActionEvent event) {

        this.coordinates = CoordinateSelectionModel.getSelectedExtent();
        LocalDateTime now = LocalDateTime.now();
        int hoursInFuture = this.hoursPicker.getValue();

        combinedForecastModel.setCoordinates(this.coordinates);
        combinedForecastModel.setConditionType(this.conditionTypePicker.getValue());
        combinedForecastModel.setStartTime(now);
        combinedForecastModel.setEndTime(now, hoursInFuture);
        combinedForecastModel.updateDatasets();

        try {
            combinedForecastModel.getIsDataFetchComplete().get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e.toString());
        }

        updateCharts(null);
    }

    /**
     * Handle the update on screen after user presses "Fetch Data" button
     * @param actionEvent
     */
    public void updateData(ActionEvent actionEvent) {
        CompletableFuture.runAsync(() -> this.asyncUpdateData(actionEvent));
    }

    /**
     * Initializes the weather data page.
     * @param url URL of the view's fxml file
     * @param resourceBundle Possible bundled resources
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.coordinates = CoordinateSelectionModel.getSelectedExtent();

        CombinedForecastPreferences preferences = null;
        try {
            preferences = (CombinedForecastPreferences) SerializationUtil.deserialize(preferencesFile);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Combined forecast preferences not read!");
        }

        setTooltips();
        weatherTypePicker.setItems(FXCollections.observableArrayList(Arrays.asList("Temperature", "Windspeed")));
        hoursPicker.setItems(FXCollections.observableArrayList(Arrays.asList(2, 4, 6, 12)));

        conditionTypePicker.setItems(FXCollections.observableArrayList(RoadConditionForecast.ConditionType.values()));

        if (preferences != null) {
            hoursPicker.setValue(preferences.getHoursPickerValue());
            conditionTypePicker.setValue(preferences.getConditionTypeValue());
            weatherTypePicker.setValue(preferences.getWeatherTypePickerValue());
        }
        else {
            hoursPicker.setValue(12);
            conditionTypePicker.setValue(RoadConditionForecast.ConditionType.ROADCONDITION);
            weatherTypePicker.setValue("Temperature");
        }

        var now = LocalDateTime.now();
        this.weatherDataModel = new WeatherDataModel(
                now,
                now.plusHours(hoursPicker.getValue()),
                new ArrayList<>(),
                this.coordinates
        );

        this.conditionForecastModel = new RoadConditionForecastModel(
                this.hoursPicker.getValue(),
                this.conditionTypePicker.getValue(),
                this.coordinates
        );

        combinedForecastModel = new CombinedForecastModel(weatherDataModel, conditionForecastModel);
        CompletableFuture.runAsync(() -> updateData(null));
    }
}
