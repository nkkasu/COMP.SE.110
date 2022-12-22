package fi.tuni.monitor.controllers;

import com.sothawo.mapjfx.*;
import com.sothawo.mapjfx.event.MapViewEvent;
import fi.tuni.monitor.models.CoordinateSelectionModel;
import fi.tuni.monitor.saveddata.CoordinateSelectionPreferences;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import static fi.tuni.monitor.models.CoordinateSelectionModel.*;

/**
 * Controller for coordinate selection window.<br>
 * A part of the MVC pattern, handles interaction with the view
 */
public class CoordinateSelectionController implements Initializable
{
    private CoordinateSelectionModel model;

    private Marker pointMarker;

    private CoordinateLine selectedExtentLine;

    // convenient little helper to get many text formatter instances without repetitive code
    private interface CoordinateFormatter { TextFormatter<String> getNewInst(); }

    private final CoordinateFormatter coordinateFormatter = () -> new TextFormatter<>(change ->
        change.getText().matches("[\\d.]*") ? change : null);

    @FXML
    private MapView mapView;

    @FXML
    private Label mouseOverCoordsLabel;

    @FXML
    private TextField latMinField;

    @FXML
    private TextField lonMinField;

    @FXML
    private TextField latMaxField;

    @FXML
    private TextField lonMaxField;

    @FXML
    private TextField latPointField;

    @FXML
    private TextField lonPointField;

    private boolean isExtentValid = false;
    private boolean isPointValid = false;

    /**
     * Initializes this controller class and the view<br>
     * Sets up all components and event handlers
     * @param url URL of the view's fxml file
     * @param resourceBundle Possible bundled resources
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        model = CoordinateSelectionModel.getInstance();

        pointMarker = Marker.createProvided(POINT_MARKER_COLOR).setVisible(true).setPosition(new Coordinate(0.0, 0.0));

        mapView.setMapType(MapType.OSM);

        mapView.addEventHandler(MapViewEvent.MAP_CLICKED, this::handleMapClicked);
        mapView.addEventHandler(MapViewEvent.MAP_POINTER_MOVED, this::handleMapPointerMoved);
        mapView.addEventHandler(MapViewEvent.MAP_EXTENT, this::handleMapExtent);

        mapView.initializedProperty().addListener(this::handleMapViewInitialized);
        mapView.initialize(Configuration.builder().projection(Projection.WEB_MERCATOR).build());

        latMinField.setTextFormatter(coordinateFormatter.getNewInst());
        lonMinField.setTextFormatter(coordinateFormatter.getNewInst());
        latMaxField.setTextFormatter(coordinateFormatter.getNewInst());
        lonMaxField.setTextFormatter(coordinateFormatter.getNewInst());
        latPointField.setTextFormatter(coordinateFormatter.getNewInst());
        lonPointField.setTextFormatter(coordinateFormatter.getNewInst());
    }

    /**
     * Loads saved preferences for coordinate selection
     */
    private void loadPreferences()
    {
        var preferences = CoordinateSelectionModel.getPreferences();

        if (preferences == null)
            return;

        var latMinFieldValue = preferences.latMinFieldValue();
        var lonMinFieldValue = preferences.lonMinFieldValue();
        var latMaxFieldValue = preferences.latMaxFieldValue();
        var lonMaxFieldValue = preferences.lonMaxFieldValue();

        var latPointFieldValue = preferences.latPointField();
        var lonPointFieldValue = preferences.lonPointField();

        latMinField.setText(latMinFieldValue);
        lonMinField.setText(lonMinFieldValue);
        latMaxField.setText(latMaxFieldValue);
        lonMaxField.setText(lonMaxFieldValue);
        latPointField.setText(latPointFieldValue);
        lonPointField.setText(lonPointFieldValue);

        Stream.of(latMinField, lonMinField, latMaxField, lonMaxField, latPointField, lonPointField)
                .forEach(this::handleTextFieldPseudoClassState);

        var extent = Extent.forCoordinates(
                new Coordinate(
                        Double.parseDouble(latMinFieldValue),
                        Double.parseDouble(lonMinFieldValue)
                ),
                new Coordinate(
                        Double.parseDouble(latMaxFieldValue),
                        Double.parseDouble(lonMaxFieldValue)
                )
        );

        model.setSelectedExtent(extent);
        model.setSelectedPoint(new Coordinate(
                Double.parseDouble(latPointFieldValue),
                Double.parseDouble(lonPointFieldValue)));
    }

    /**
     * Event handler for save preferences button<br>
     * Saves current preferences to file on disk
     */
    @FXML
    private void handleSavePreferences()
    {
        onSetExtentCoords();
        onSetPointCoords();

        if (!isExtentValid || !isPointValid)
            return;

        CoordinateSelectionPreferences preferences = new CoordinateSelectionPreferences(
                latMinField.getText(),
                lonMinField.getText(),
                latMaxField.getText(),
                lonMaxField.getText(),
                latPointField.getText(),
                lonPointField.getText()
        );

        CoordinateSelectionModel.savePreferences(preferences);
    }

    /**
     * Event handler for setting point coordinates button<br>
     * Sets the point coordinates to the values in the text fields
     */
    @FXML
    private void onSetPointCoords()
    {
        isPointValid = false;

        var latPointFieldText = latPointField.getText();
        var lonPointFieldText = lonPointField.getText();

        if (Boolean.FALSE.equals(CoordinateSelectionModel.areValidCoordinates(latPointFieldText, lonPointFieldText)))
        {
            var dialog = new Alert(Alert.AlertType.ERROR, "Please set valid coordinates first.", ButtonType.OK);
            dialog.initOwner(latPointField.getScene().getWindow());
            dialog.setTitle("Error");
            dialog.setHeaderText("Invalid coordinates");
            dialog.show();
            return;
        }

        var coord = new Coordinate(
                Double.parseDouble(latPointFieldText),
                Double.parseDouble(lonPointFieldText)
        );

        if (Boolean.FALSE.equals(CoordinateSelectionModel.isInFinland(coord)))
        {
            var dialog = new Alert(Alert.AlertType.ERROR, "Coordinate must within in Finland.", ButtonType.OK);
            dialog.initOwner(latPointField.getScene().getWindow());
            dialog.setTitle("Error");
            dialog.setHeaderText("Invalid coordinates");
            dialog.show();
            return;
        }

        pointMarker.setPosition(coord);
        mapView.setCenter(coord);
        model.setSelectedPoint(coord);
        isPointValid = true;
    }

    /**
     * Event handler for setting extent coordinates button<br>
     * Sets the extent to the values in the text fields
     */
    @FXML
    private void onSetExtentCoords()
    {
        isExtentValid = false;
        var latMinFieldText = latMinField.getText();
        var lonMinFieldText = lonMinField.getText();
        var latMaxFieldText = latMaxField.getText();
        var lonMaxFieldText = lonMaxField.getText();

        if (Boolean.FALSE.equals(CoordinateSelectionModel.areValidCoordinates(latMinFieldText, lonMinFieldText, latMaxFieldText, lonMaxFieldText)))
        {
            var dialog = new Alert(Alert.AlertType.ERROR, "Please set valid coordinates first.", ButtonType.OK);
            dialog.initOwner(latMinField.getScene().getWindow());
            dialog.setTitle("Error");
            dialog.setHeaderText("Invalid coordinates");
            dialog.show();
            return;
        }

        var extent = Extent.forCoordinates(
                new Coordinate(
                        Double.parseDouble(latMinFieldText),
                        Double.parseDouble(lonMinFieldText)
                ),
                new Coordinate(
                        Double.parseDouble(latMaxFieldText),
                        Double.parseDouble(lonMaxFieldText)
                )
        );

        if (Boolean.FALSE.equals(CoordinateSelectionModel.isInFinland(extent)))
        {
            var dialog = new Alert(Alert.AlertType.ERROR, "Extent must be within Finland.", ButtonType.OK);
            dialog.initOwner(latMinField.getScene().getWindow());
            dialog.setTitle("Error");
            dialog.setHeaderText("Invalid coordinates");
            dialog.show();
            return;
        }

        if (selectedExtentLine != null)
            mapView.removeCoordinateLine(selectedExtentLine);

        model.setSelectedExtent(extent);
        selectedExtentLine = CoordinateSelectionModel.extentToCoordinateLine(extent);
        mapView.addCoordinateLine(selectedExtentLine);
        isExtentValid = true;
    }

    /**
     * Event handler for key types into coordinate fields<br>
     * Handles the pseudo class state of the text fields, i.e. coloring the text fields red if the input is invalid
     * @param event The key event
     */
    @FXML
    private void coordinateFieldKeyTyped(KeyEvent event)
    {
        var control = (TextField) event.getSource();
        handleTextFieldPseudoClassState(control);
    }

    /**
     * Event handler for the mapview being initialized<br>
     * Sets properties of the mapview which can only be set after the mapview has been initialized
     * @param observableValue The observable boolean value of the mapview's initialized state
     * @param oldValue The old value
     * @param newValue The new value
     */
    private void handleMapViewInitialized(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue)
    {
        if (Boolean.TRUE.equals(newValue)) {
            mapView.setCenter(HERWANTA_COORDINATE);
            mapView.constrainExtent(FINLAND_EXTENT);
            mapView.addMarker(pointMarker);
        }

        loadPreferences();

        var boundingCoordinates = getSelectedExtent();
        selectedExtentLine = CoordinateSelectionModel.extentToCoordinateLine(boundingCoordinates.getExtent());
        mapView.addCoordinateLine(selectedExtentLine);

        var point = getSelectedPoint().getMapJFXCoordinate();
        pointMarker.setPosition(point);
        mapView.setCenter(point);
    }

    /**
     * Event handler for the mouse pointer being moved over the mapview<br>
     * Updates the coordinate labels to the coordinates of the mouse pointer
     * @param event The mapview mouse event
     */
    private void handleMapPointerMoved(MapViewEvent event)
    {
        mouseOverCoordsLabel.setText(CoordinateSelectionModel.stringifyMapPointerCoordinate(event.getCoordinate()));
    }

    /**
     * Event handler for an extent being drawn on the mapview<br>
     * Updates the extent text fields to the coordinates of the drawn extent and stores the extent
     * @param event The mapview extent event
     */
    private void handleMapExtent(MapViewEvent event)
    {
        var extent = event.getExtent();
        var min = extent.getMin();
        var max = extent.getMax();

        latMinField.setText(CoordinateSelectionModel.stringifyMapCoordinateDegree(min.getLatitude()));
        lonMinField.setText(CoordinateSelectionModel.stringifyMapCoordinateDegree(min.getLongitude()));
        latMaxField.setText(CoordinateSelectionModel.stringifyMapCoordinateDegree(max.getLatitude()));
        lonMaxField.setText(CoordinateSelectionModel.stringifyMapCoordinateDegree(max.getLongitude()));
        model.setSelectedExtent(extent);

        if (selectedExtentLine != null)
            mapView.removeCoordinateLine(selectedExtentLine);

        selectedExtentLine = CoordinateSelectionModel.extentToCoordinateLine(extent);
        mapView.addCoordinateLine(selectedExtentLine);
    }

    /**
     * Event handler for mouse clicks on the mapview<br>
     * Updates the point text fields to the coordinates of the clicked point and stores the point
     * @param event The mapview mouse click event
     */
    private void handleMapClicked(MapViewEvent event)
    {
        var coord = event.getCoordinate();

        latPointField.setText(CoordinateSelectionModel.stringifyMapCoordinateDegree(coord.getLatitude()));
        lonPointField.setText(CoordinateSelectionModel.stringifyMapCoordinateDegree(coord.getLongitude()));
        pointMarker.setPosition(coord);
        model.setSelectedPoint(coord);
    }

    /**
     * Helper method for handling the pseudo class state checking of a text field<br>
     * Sets the text field's pseudo class state to invalid if the text field's text is not a valid coordinate<br>
     * I.e. the text field is colored red if the text is not a valid coordinate
     * @param textField The text field to check
     */
    private void handleTextFieldPseudoClassState(TextField textField)
    {
        var text = textField.getText();
        textField.pseudoClassStateChanged(INVALID_PSEUDO_CLASS, !text.isEmpty() && !CoordinateSelectionModel.areValidCoordinates(text));
    }
}
