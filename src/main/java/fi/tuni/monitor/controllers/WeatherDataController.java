package fi.tuni.monitor.controllers;

import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.models.CoordinateSelectionModel;
import fi.tuni.monitor.models.WeatherDataModel;
import fi.tuni.monitor.saveddata.MonitorConfig;
import fi.tuni.monitor.saveddata.SaveablePreferences;
import fi.tuni.monitor.saveddata.SerializationUtil;
import fi.tuni.monitor.saveddata.WeatherDataPreferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

/**
 * Controller for weather data window.<br>
 * Part of the MVC pattern
 */
public class WeatherDataController implements Initializable, SaveablePreferences {

    private static final String preferencesFile = MonitorConfig.getWeatherDataPreferencesFile();
    private XYItemRenderer temperatureRenderer = new StandardXYItemRenderer();
    private XYItemRenderer windRenderer = new StandardXYItemRenderer();
    private XYItemRenderer cloudinessRenderer = new StandardXYItemRenderer();

    @FXML
    private DatePicker weatherDateFrom;
    @FXML
    private DatePicker weatherDateTo;
    @FXML
    private CheckBox windCheckBox;
    @FXML
    private CheckBox temperatureCheckBox;
    @FXML
    private CheckBox cloudCheckBox;
    @FXML
    private CheckBox minMaxCheckBox;
    @FXML
    private ChartViewer temperatureWindChart;
    @FXML
    private ChartViewer cloudinessChart;
    @FXML
    private Label infoLabel;
    @FXML
    private Button weatherFetchButton;
    WeatherDataModel weatherDataModel = null;
    BoundingCoordinates coordinates = null;

    /**
     * Gets the start of day as a LocalDateTime from the selected date in a DatePicker
     * @param picker DatePicker to get the start of day from
     * @return start of the day as a LocalDateTime
     */
    private LocalDateTime getDatePickerStartOfDay(DatePicker picker) {
        return picker.getValue().atStartOfDay();
    }

    /**
     * Event handler for fetch data button<br>
     * Updates the WeatherDataModel according to user's selections in UI.
     * Calls methods from the model to get the updated charts and updates the UI.
     */
    @FXML
    private void updateCharts() {
        weatherFetchButton.setDisable(true);
        this.coordinates = CoordinateSelectionModel.getSelectedExtent();

        var from = getDatePickerStartOfDay(weatherDateFrom);
        var to = getDatePickerStartOfDay(weatherDateTo);

        if (!from.isBefore(to)) {
            infoLabel.setText("Date from must be before date to");
            return;
        }
        infoLabel.setText("");
        weatherDataModel.setStartTime(from);
        weatherDataModel.setEndTime(to.plusDays(1).minusMinutes(1));
        weatherDataModel.setCoordinates(this.coordinates);
        JFreeChart chart1 = weatherDataModel.createTempWindChart();
        temperatureWindChart.setChart(chart1);

        XYPlot plot = chart1.getXYPlot();
        temperatureRenderer = plot.getRenderer();
        temperatureRenderer.setSeriesPaint(0, Color.RED);
        temperatureRenderer.setSeriesPaint(1, Color.GREEN);
        temperatureRenderer.setSeriesPaint(2, Color.BLACK);

        windRenderer = new StandardXYItemRenderer();
        windRenderer.setSeriesPaint(0, Color.BLUE);
        plot.setRenderer(1, windRenderer);

        setTemperatureVisibility();
        setMinMaxVisibility();
        setWindVisibility();

        JFreeChart chart2 = weatherDataModel.createCloudinessChart();
        weatherFetchButton.setDisable(false);
        cloudinessChart.setChart(chart2);
        cloudinessRenderer = chart2.getXYPlot().getRenderer();
        cloudinessRenderer.setSeriesPaint(0, Color.MAGENTA);
        setCloudinessVisibility();
    }

    /**
     * Sets the visibility of average temperature line in Temperature/Wind chart.
     * Event handler for temperature checkbox
     */
    @FXML
    private void setTemperatureVisibility() {
        temperatureRenderer.setSeriesVisible(0, temperatureCheckBox.isSelected());
    }

    /**
     * Sets the visibility of minimum and maximum temperature lines in Temperature/Wind chart
     * Event handler for min/max checkbox
     */
    @FXML
    private void setMinMaxVisibility() {
        boolean isVisible = minMaxCheckBox.isSelected();
        temperatureRenderer.setSeriesVisible(1, isVisible);
        temperatureRenderer.setSeriesVisible(2, isVisible);
    }

    /**
     * Sets the visibility of wind speed line in Temperature/Wind chart
     * Event handler for wind checkbox
     */
    @FXML
    private void setWindVisibility() {
        windRenderer.setSeriesVisible(0, windCheckBox.isSelected());
    }

    /**
     * Sets the visibility of cloudiness line in Cloud chart
     * Event handler for clouds check box
     */
    @FXML
    private void setCloudinessVisibility() {
        cloudinessRenderer.setSeriesVisible(0, cloudCheckBox.isSelected());
    }

    /**
     * Event handler for save preferences button.
     * Saves weather visualization preferences to a file.
     * @param actionEvent Ignored event
     */
    @FXML
    public void handleSavePreferences(ActionEvent actionEvent) {
        WeatherDataPreferences preferences = new WeatherDataPreferences(
                weatherDateFrom.getValue(),
                weatherDateTo.getValue(),
                temperatureCheckBox.isSelected(),
                minMaxCheckBox.isSelected(),
                windCheckBox.isSelected(),
                cloudCheckBox.isSelected()
        );
        try {
            SerializationUtil.serialize(preferences, preferencesFile);
        } catch (IOException e) {
            System.err.println("Error saving weather data preferences!");;
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

        WeatherDataPreferences preferences = null;
        try {
            preferences = (WeatherDataPreferences) SerializationUtil.deserialize(preferencesFile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Weather data preferences not read!");
        }

        if (preferences != null) {
            weatherDateFrom.setValue(preferences.weatherDateFromValue());
            weatherDateTo.setValue(preferences.weatherDateToValue());
            temperatureCheckBox.setSelected(preferences.temperatureCheckBoxSelected());
            minMaxCheckBox.setSelected(preferences.minMaxCheckBoxSelected());
            windCheckBox.setSelected(preferences.windCheckBoxSelected());
            cloudCheckBox.setSelected(preferences.cloudCheckBoxSelected());
        }
        else {
            var now = LocalDate.now();
            weatherDateFrom.setValue(now.minusDays(7));
            weatherDateTo.setValue(now);

            temperatureCheckBox.setSelected(true);
            minMaxCheckBox.setSelected(false);
            windCheckBox.setSelected(true);
            cloudCheckBox.setSelected(true);
        }

        for (DatePicker picker : Arrays.asList(weatherDateFrom, weatherDateTo)) {
            picker.setDayCellFactory(datePicker -> new DateCell() {
                @Override
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate lastAllowed = LocalDate.now().plusDays(2);

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

        CompletableFuture.runAsync(this::updateCharts);
    }
}
