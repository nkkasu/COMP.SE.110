package fi.tuni.monitor.controllers;

import fi.tuni.monitor.data.*;
import fi.tuni.monitor.models.CoordinateSelectionModel;
import fi.tuni.monitor.models.MaintenanceTaskModel;
import fi.tuni.monitor.models.RoadConditionForecastModel;
import fi.tuni.monitor.models.TrafficMessageModel;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingPropertiesV1;
import fi.tuni.monitor.saveddata.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * Controller for Road Data window<br>
 * Part of the MVC pattern
 */
public class RoadDataController implements Initializable, SaveablePreferences {

    private static final String preferencesFile = MonitorConfig.getRoadDataPreferencesFile();

    @FXML
    private CheckBox specificCheckBox;
    @FXML
    private ChoiceBox<MaintenanceTrackingPropertiesV1.TasksEnum> taskTypePicker;
    @FXML
    private ChoiceBox<RoadConditionForecast.ConditionType> forecastConditionPicker;
    @FXML
    private ChoiceBox<Integer> forecastHourPicker;
    @FXML
    private DatePicker roadMaintenanceDateFrom;
    @FXML
    private DatePicker roadMaintenanceDateTo;
    @FXML
    private ChartViewer roadMaintenanceTaskPieChart;
    @FXML
    private ChartViewer roadConditionForecastPieChart;
    @FXML
    private TreeView<?> trafficMessageTreeView;
    @FXML
    private Spinner<Integer> inactiveHoursSpinner;
    @FXML
    private CheckComboBox<TrafficMessageDataset> savedTrafficMessagesComboBox;
    @FXML
    private Button trafficMsgFetchButton;
    @FXML
    private Button forecastFetchButton;
    @FXML
    private Button maintenanceFetchButton;
    private BoundingCoordinates coordinates = null;

    private MaintenanceTaskModel maintenanceTaskModel;
    private RoadConditionForecastModel roadConditionForecastModel;
    private TrafficMessageModel trafficMessageModel;

    /**
     * Get the date picker value at start of day
     * @param picker from which the value to get
     * @return LocalDateTime of date at start of day
     */
    private LocalDateTime getDatePickerStartOfDay(DatePicker picker) {
        return picker.getValue().atStartOfDay();
    }

    /**
     * Get the chart of proportion of roam maintenance tasks values
     * @return JFreeChart of pie chart of proportion of road maintenance tasks
     */
    private JFreeChart createRoadMaintenanceTaskPieChart() {
        return ChartFactory.createPieChart(
                "", this.maintenanceTaskModel.getPieChartData());
    }

    /**
     * Handle update of road maintenance tasks visualization async
     */
    private void asyncSetRoadMaintenanceTaskPieChart() {
        this.coordinates = CoordinateSelectionModel.getSelectedExtent();

        var from = this.getDatePickerStartOfDay(roadMaintenanceDateFrom);
        var to = this.getDatePickerStartOfDay(roadMaintenanceDateTo).plusDays(1);

        this.maintenanceTaskModel.setStartTime(from);
        this.maintenanceTaskModel.setEndTime(to);
        this.maintenanceTaskModel.setCoordinates(this.coordinates);
        this.maintenanceTaskModel.updateData();

        try {
            this.maintenanceTaskModel.getIsDataFetchComplete().get(45, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e.toString());
        } catch (TimeoutException e) {
            System.err.println("Timeout on road maintenance tasks API fetch!");
        }

        JFreeChart chart = null;

        if (!specificCheckBox.isSelected()) {
            chart = this.createRoadMaintenanceTaskPieChart();
        }
        else {
            this.maintenanceTaskModel.setTypeSelected(taskTypePicker.getValue());
            chart = maintenanceTaskModel.createRoadMaintenanceTimeLineChart();
        }

        roadMaintenanceTaskPieChart.setChart(chart);
        maintenanceFetchButton.setDisable(false);
    }

    /**
     * Handle update of road maintenance task visualization
     */
    @FXML
    private void setRoadMaintenanceTaskPieChart() {
        maintenanceFetchButton.setDisable(true);
        CompletableFuture.runAsync(this::asyncSetRoadMaintenanceTaskPieChart);
    }

    /**
     * Handle update of road condition forecast visualization async
     */
    private void asyncSetRoadConditionForecastPieChart() {
        this.coordinates = CoordinateSelectionModel.getSelectedExtent();

        this.roadConditionForecastModel.setConditionType(this.forecastConditionPicker.getValue());
        this.roadConditionForecastModel.setHours(this.forecastHourPicker.getValue());
        this.roadConditionForecastModel.setCoordinates(this.coordinates);
        this.roadConditionForecastModel.updateData();

        try {
            this.roadConditionForecastModel.getIsDataFetchComplete().get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e.toString());
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "", this.roadConditionForecastModel.getPieChartData());

        roadConditionForecastPieChart.setChart(chart);
        forecastFetchButton.setDisable(false);
    }

    /**
     * Handle update of road condition forecast visualization
     */
    @FXML
    private void setRoadConditionForecastPieChart() {
        forecastFetchButton.setDisable(true);
        CompletableFuture.runAsync(this::asyncSetRoadConditionForecastPieChart);
    }

    /**
     * handle click of specific check box
     * @param actionEvent
     */
    @FXML
    private void handleSpecificCheckBox(ActionEvent actionEvent) {
        if (specificCheckBox.isSelected()) {
            taskTypePicker.setDisable(false);
            this.maintenanceTaskModel.setSpecificTypeSelected(true);
            this.maintenanceTaskModel.setTypeSelected(taskTypePicker.getValue());
        }
        else {
            taskTypePicker.setDisable(true);
        }
    }

    /**
     * Handle click on "Save Preferences" button and save preferences to disk
     * @param actionEvent
     */
    @FXML
    public void handleSavePreferences(ActionEvent actionEvent) {
        RoadDataPreferences preferences = new RoadDataPreferences(
                roadMaintenanceDateFrom.getValue(),
                roadMaintenanceDateTo.getValue(),
                specificCheckBox.isSelected(),
                taskTypePicker.getValue(),
                forecastHourPicker.getValue(),
                forecastConditionPicker.getValue()
        );
        try {
            SerializationUtil.serialize(preferences, preferencesFile);
        } catch (IOException e) {
            System.err.println("Error saving road data preferences!");;
        }
    }

    private void asyncOnFetchTrafficMessages(ActionEvent actionEvent) {

        var extent = CoordinateSelectionModel.getSelectedExtent();

        var inactiveHours = inactiveHoursSpinner.getValue();
        trafficMessageModel.setInactiveHours(inactiveHours);
        trafficMessageModel.setTrafficMessages(extent, inactiveHours);
        trafficMsgFetchButton.setDisable(false);
    }

    /**
     * Handle traffic message fetching
     * @param actionEvent
     */
    @FXML
    private void onFetchTrafficMessages(ActionEvent actionEvent)
    {
        trafficMsgFetchButton.setDisable(true);
        var extent = CoordinateSelectionModel.getSelectedExtent();
        if (extent == null)
        {
            var dialog = new Alert(Alert.AlertType.ERROR, "Please select a coordinate area first in the Coordinate Selection tab", ButtonType.OK);
            dialog.initOwner(trafficMessageTreeView.getScene().getWindow());
            dialog.setTitle("Error");
            dialog.setHeaderText("No coordinate area selected");
            dialog.show();
            return;
        }
        CompletableFuture.runAsync(() -> this.asyncOnFetchTrafficMessages(actionEvent));
    }

    /**
     * Handle saving datasets of traffic message data
     * @param actionEvent
     */
    @FXML
    private void onSaveTrafficMessageDataset(ActionEvent actionEvent)
    {
        var dataset = trafficMessageModel.saveTrafficMessageDataset(savedTrafficMessagesComboBox.getItems());
        if (dataset == null)
            return;

        savedTrafficMessagesComboBox.getItems().add(dataset);
    }

    /**
     * Load saved traffic message datasets from disk
     */
    private void loadTrafficMessageDatasets()
    {
        var datasets = trafficMessageModel.getSavedTrafficMessageDatasets();
        if (datasets == null)
            return;

        datasets.sort(Comparator.comparing(TrafficMessageDataset::fetchTime));
        savedTrafficMessagesComboBox.getItems().addAll(datasets);
    }

    /**
     * Initialize controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.coordinates = CoordinateSelectionModel.getSelectedExtent();
        this.trafficMessageModel = new TrafficMessageModel(trafficMessageTreeView);

        RoadDataPreferences preferences = null;
        try {
            preferences = (RoadDataPreferences) SerializationUtil.deserialize(preferencesFile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Road data preferences not read!");
        }

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

        forecastHourPicker.setItems(FXCollections.observableArrayList(Arrays.asList(2, 4, 6, 12)));
        forecastConditionPicker.setItems(FXCollections.observableArrayList(RoadConditionForecast.ConditionType.values()));

        inactiveHoursSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        inactiveHoursSpinner.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                inactiveHoursSpinner.getEditor().setText(newValue.replaceAll("\\D", ""));
        });
        inactiveHoursSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null)
                inactiveHoursSpinner.getValueFactory().setValue(0);
            else if (newValue > 100)
                inactiveHoursSpinner.getValueFactory().setValue(100);
        });

        savedTrafficMessagesComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(TrafficMessageDataset object) {
                return object.getComboTitle();
            }
            @Override
            public TrafficMessageDataset fromString(String string) { return null; }
        });

        savedTrafficMessagesComboBox.getCheckModel().getCheckedItems().addListener((ListChangeListener<TrafficMessageDataset>) c -> {
            while (c.next())
            {
                if (c.wasAdded())
                    trafficMessageModel.loadTrafficMessageDatasets((List<TrafficMessageDataset>) c.getAddedSubList());
                else if (c.wasRemoved())
                    trafficMessageModel.removeTrafficMessageDatasets((List<TrafficMessageDataset>) c.getRemoved());
            }
        });

        loadTrafficMessageDatasets();

        if (preferences != null) {
            roadMaintenanceDateFrom.setValue(preferences.dateFromValue());
            roadMaintenanceDateTo.setValue(preferences.dateToValue());
            taskTypePicker.setValue(preferences.taskTypeValue());
            specificCheckBox.setSelected(preferences.specificCheckBoxValue());
            taskTypePicker.setDisable(!preferences.specificCheckBoxValue());
            

            forecastHourPicker.setValue(preferences.forecastHourPickerValue());
            forecastConditionPicker.setValue(preferences.forecastConditionPickerValue());
        }
        else {
            var now = LocalDate.now();
            roadMaintenanceDateFrom.setValue(now.minusDays(1));
            roadMaintenanceDateTo.setValue(now);
            taskTypePicker.setDisable(true);
            taskTypePicker.setValue(MaintenanceTrackingPropertiesV1.TasksEnum.ROAD_INSPECTIONS);

            forecastHourPicker.setValue(2);
            forecastConditionPicker.setValue(RoadConditionForecast.ConditionType.ROADCONDITION);
        }

        // Maintenance Tasks
        this.maintenanceTaskModel = new MaintenanceTaskModel(
                this.getDatePickerStartOfDay(roadMaintenanceDateFrom),
                this.getDatePickerStartOfDay(roadMaintenanceDateTo).plusDays(1),
                false,
                this.coordinates);

        // Forecast
        this.roadConditionForecastModel = new RoadConditionForecastModel(
                this.forecastHourPicker.getValue(),
                this.forecastConditionPicker.getValue(),
                this.coordinates
        );


        CompletableFuture.runAsync(this::setRoadMaintenanceTaskPieChart);
        CompletableFuture.runAsync(this::setRoadConditionForecastPieChart);
        CompletableFuture.runAsync(() -> trafficMessageModel.setTrafficMessages(CoordinateSelectionModel.getSelectedExtent(), inactiveHoursSpinner.getValue()));

    }

}
