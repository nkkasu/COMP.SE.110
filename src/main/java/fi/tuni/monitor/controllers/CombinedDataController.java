package fi.tuni.monitor.controllers;

import fi.tuni.monitor.data.*;
import fi.tuni.monitor.models.CombinedDataModel;
import fi.tuni.monitor.models.CoordinateSelectionModel;
import fi.tuni.monitor.models.MaintenanceTaskModel;
import fi.tuni.monitor.models.WeatherDataModel;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingPropertiesV1;
import fi.tuni.monitor.saveddata.CombinedDataPreferences;
import fi.tuni.monitor.saveddata.MonitorConfig;
import fi.tuni.monitor.saveddata.SaveablePreferences;
import fi.tuni.monitor.saveddata.SerializationUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.util.StringConverter;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.ChartViewer;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Controller for combined data window.<br>
 * Part of the MVC pattern
 */
public class CombinedDataController implements Initializable, SaveablePreferences {
    private static final String preferencesFile = MonitorConfig.getCombinedDataPreferencesFile();
    BoundingCoordinates coordinates = null;
    WeatherDataModel weatherDataModel = null;
    MaintenanceTaskModel maintenanceTaskModel = null;

    CombinedDataModel combinedDataModel = null;
    @FXML
    private DatePicker weatherDateFrom;
    @FXML
    private ChartViewer combinedChart;
    @FXML
    private DatePicker weatherDateTo;
    @FXML
    private ChoiceBox<MaintenanceTrackingPropertiesV1.TasksEnum> taskTypePicker;
    @FXML
    private ChoiceBox<String> weatherTypePicker;
    @FXML
    private Button fetchButton;
    private LocalDateTime getDatePickerStartOfDay(DatePicker picker) {
        return picker.getValue().atStartOfDay();
    }
    @FXML
    private ImageView questionMark;

    /**
     * Updates the CombinedDataModel according to user's selections in UI.
     * Calls updateChart() which updates the GUI.
     */
    private void asyncUpdateData() {
        var from = getDatePickerStartOfDay(weatherDateFrom);
        var to = getDatePickerStartOfDay(weatherDateTo);

        if (!from.isBefore(to)) {
            fetchButton.setDisable(false);
            return;
        }
        combinedDataModel.setStartTime(from);
        combinedDataModel.setEndTime(to);
        combinedDataModel.setCoordinates(this.coordinates);
        combinedDataModel.setTypeSelected(taskTypePicker.getValue());
        combinedDataModel.updateDatasets();

        try {
            this.combinedDataModel.getIsDataFetchComplete().get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.toString());
        }
        updateCharts(null);
    }

    /**
     * Event handler for fetch data button<br>
     * Updates the CombinedDataModel according to user's selections in UI.
     * Calls updateChart() which updates the GUI.
     */
    @FXML
    private void updateData() {
        this.coordinates = CoordinateSelectionModel.getSelectedExtent();
        fetchButton.setDisable(true);
        CompletableFuture.runAsync(this::asyncUpdateData);
    }

    /**
     * Gets updated weather data from model and updates charts.
     * @param event Ignored event
     */
    @FXML
    private void updateCharts(ActionEvent event) {
        combinedDataModel.setTypeSelected(taskTypePicker.getValue());
        String weatherType = weatherTypePicker.getValue();
        JFreeChart chart = combinedDataModel.createLineBarChart(weatherType);
        combinedChart.setChart(chart);
        fetchButton.setDisable(false);
    }
    /**
     * Sets tooltips for this view.
     */
    private void setTooltips() {
        Tooltip combinedTooltip = new Tooltip();
        combinedTooltip.setText("You can pick a specific road maintenance task type count to be shown along a specific weather type value in a time-series.");
        combinedTooltip.setMaxWidth(700);
        combinedTooltip.setWrapText(true);
        combinedTooltip.setShowDelay(Duration.ZERO);
        Tooltip.install(questionMark, combinedTooltip);
        combinedTooltip.setFont(new Font(18));
    }
    /**
     * Event handler for save preferences button.
     * Saves weather visualization preferences to a file.
     * @param actionEvent Ignored event
     */
    @FXML
    public void handleSavePreferences(ActionEvent actionEvent) {
        CombinedDataPreferences preferences = new CombinedDataPreferences(
                weatherDateFrom.getValue(),
                weatherDateTo.getValue(),
                taskTypePicker.getValue(),
                weatherTypePicker.getValue());
        try {
            SerializationUtil.serialize(preferences, preferencesFile);
        } catch (IOException e) {
            System.out.println("Error saving combined data preferences!");
        }
    }
    /**
     * Initializes the weather data page.
     * @param url URL of the view's fxml file
     * @param resourceBundle Possible bundled resources
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.coordinates = CoordinateSelectionModel.getSelectedExtent();

        CombinedDataPreferences preferences = null;
        try {
            preferences = (CombinedDataPreferences) SerializationUtil.deserialize(preferencesFile);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Combined data preferences not read!");
        }

        setTooltips();
        weatherTypePicker.setItems(FXCollections.observableArrayList(Arrays.asList("Temperature", "Clouds", "Windspeed")));
        taskTypePicker.setItems(FXCollections.observableArrayList(MaintenanceTrackingPropertiesV1.TasksEnum.values()));
        taskTypePicker.converterProperty().setValue(new StringConverter<>() {
            @Override
            public String toString(MaintenanceTrackingPropertiesV1.TasksEnum object) {
                return object.prettifiedValue();
            }

            @Override
            public MaintenanceTrackingPropertiesV1.TasksEnum fromString(String string) {
                return MaintenanceTrackingPropertiesV1.TasksEnum.fromValue(string);
            }
        });

        if (preferences != null) {
            weatherDateFrom.setValue(preferences.weatherDateFromValue());
            weatherDateTo.setValue(preferences.weatherDateToValue());
            taskTypePicker.setValue(preferences.taskTypeValue());
            weatherTypePicker.setValue(preferences.weatherType());
        }
        else {
            var now = LocalDate.now();
            weatherDateFrom.setValue(now.minusDays(7));
            weatherDateTo.setValue(now);
            taskTypePicker.setValue(MaintenanceTrackingPropertiesV1.TasksEnum.SALTING);
            weatherTypePicker.setValue("Temperature");
        }

        for (DatePicker picker : Arrays.asList(weatherDateFrom, weatherDateTo)) {
            picker.setDayCellFactory(datePicker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate lastAllowed = LocalDate.now();

                    setDisable(empty || date.compareTo(lastAllowed) > 0);
                }
            });
        }
        weatherDataModel = new WeatherDataModel(
                this.getDatePickerStartOfDay(weatherDateFrom),
                this.getDatePickerStartOfDay(weatherDateTo).plusDays(1),
                new ArrayList<>(),
                this.coordinates
        );
        this.maintenanceTaskModel = new MaintenanceTaskModel(
                this.getDatePickerStartOfDay(weatherDateFrom),
                this.getDatePickerStartOfDay(weatherDateTo).plusDays(1),
                true,
                this.coordinates);

        this.combinedDataModel = new CombinedDataModel(
                weatherDataModel,
                maintenanceTaskModel);

        CompletableFuture.runAsync(this::updateData);
        weatherTypePicker.setOnAction(this::updateCharts);
        taskTypePicker.setOnAction(this::updateCharts);
        }
}
