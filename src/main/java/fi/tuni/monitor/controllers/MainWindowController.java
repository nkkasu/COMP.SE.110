package fi.tuni.monitor.controllers;

import com.sothawo.mapjfx.Extent;
import com.sothawo.mapjfx.Coordinate;
import fi.tuni.monitor.mainwindow.RadioToggleButton;
import fi.tuni.monitor.models.CoordinateSelectionModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller for the main window<br>
 * Loads all other view and controllers<br>
 * <br>
 * Implements the PropertyChangeListener for observer design pattern to receive broadcasts from the CoordinateSelectionModel
 */
public class MainWindowController implements Initializable, PropertyChangeListener
{
    @FXML
    public RadioToggleButton coordinateSelectionButton;
    @FXML
    public RadioToggleButton roadDataButton;
    @FXML
    public RadioToggleButton weatherDataButton;
    @FXML
    public RadioToggleButton combinedDataButton;
    @FXML
    public RadioToggleButton settingsButton;
    @FXML
    public StackPane contentArea;
    @FXML
    public RadioToggleButton combinedForecastButton;
    @FXML
    private ToggleGroup sidePanelToggleGroup;
    @FXML
    private Label selectedExtentLabel;
    @FXML
    private Label selectedPointLabel;

    /**
     * Initializes the main window and all other views and controllers
     * @param url URL of the view's fxml file
     * @param resourceBundle Possible bundled resources
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            coordinateSelectionButton.setUserData(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fi/tuni/monitor/mainwindow/fxml-views/coordinate_selection.fxml"))));
            roadDataButton.setUserData(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fi/tuni/monitor/mainwindow/fxml-views/road_data.fxml"))));
            weatherDataButton.setUserData(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fi/tuni/monitor/mainwindow/fxml-views/weather_data.fxml"))));
            combinedDataButton.setUserData(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fi/tuni/monitor/mainwindow/fxml-views/combined_data.fxml"))));
            combinedForecastButton.setUserData(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fi/tuni/monitor/mainwindow/fxml-views/combined_forecast.fxml"))));
            settingsButton.setUserData(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fi/tuni/monitor/mainwindow/fxml-views/settings.fxml"))));

            // observer design pattern, subscribe to extent and coordinates changes from CoordinateSelectionModel
            CoordinateSelectionModel.subscribeToExtentChanges(this);
            CoordinateSelectionModel.subscribeToPointChanges(this);
        }
        catch (Exception E)
        {
            throw new RuntimeException(E);
        }

        contentArea.getChildren().add((Node)coordinateSelectionButton.getUserData());
    }

    /**
     * Event handler for the side bar buttons<br>
     * Changes the current tab
     */
    @FXML
    public void onSidePanelButtonClicked()
    {
        // buttons implemented as a custom RadioToggleButton
        var selected = (RadioToggleButton)sidePanelToggleGroup.getSelectedToggle();
        contentArea.getChildren().clear();
        contentArea.getChildren().add((Node)selected.getUserData());
    }

    /**
     * Observer pattern event handler, receives broadcasts from CoordinateSelectionModel<br>
     * Coordinates are set to the top bar labels
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if (evt.getPropertyName().equals(CoordinateSelectionModel.EXTENT_PROPERTY))
        {
            var extent = (Extent)evt.getNewValue();
            selectedExtentLabel.setText(String.format(Locale.US, "%.5f, %.5f → %.5f, %.5f", extent.getMin().getLatitude(), extent.getMin().getLongitude(), extent.getMax().getLatitude(), extent.getMax().getLongitude()));
        }
        else if (evt.getPropertyName().equals(CoordinateSelectionModel.POINT_PROPERTY))
        {
            var point = (Coordinate)evt.getNewValue();
            selectedPointLabel.setText(String.format(Locale.US, "%.5f, %.5f", point.getLatitude(), point.getLongitude()));
        }
    }
}

