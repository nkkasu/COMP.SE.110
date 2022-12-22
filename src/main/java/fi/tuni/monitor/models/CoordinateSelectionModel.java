package fi.tuni.monitor.models;

import com.sothawo.mapjfx.Coordinate;
import com.sothawo.mapjfx.CoordinateLine;
import com.sothawo.mapjfx.Extent;
import com.sothawo.mapjfx.Marker;
import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.saveddata.CoordinateSelectionPreferences;
import fi.tuni.monitor.saveddata.MonitorConfig;
import fi.tuni.monitor.saveddata.SerializationUtil;
import javafx.css.PseudoClass;
import javafx.scene.paint.Color;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Model for handling coordinate selection related data and operations<br>
 * Is a part of the MVC pattern, implemented as a singleton to provide convenient access to the data from anywhere
 */
public class CoordinateSelectionModel
{
    private static CoordinateSelectionModel instance;

    public static final Extent FINLAND_EXTENT = Extent.forCoordinates(new Coordinate(59.0, 19.0), new Coordinate(70.5, 32.0));
    public static final Coordinate HERWANTA_COORDINATE = new Coordinate(61.4502995,23.8498024);
    public static final BoundingCoordinates HERWANTA_BOUNDS = new BoundingCoordinates(23.0, 61.0, 24.0, 62.0);
    public static final Marker.Provided POINT_MARKER_COLOR = Marker.Provided.BLUE;
    public static final PseudoClass INVALID_PSEUDO_CLASS = PseudoClass.getPseudoClass("invalid");
    private static final Pattern COORDINATE_PATTERN = Pattern.compile("^\\d+(\\.\\d*)?$");
    private static final String PREFERENCES_FILE = MonitorConfig.getCoordinateSelectionPreferencesFile();

    private Extent selectedExtent;
    private Coordinate selectedPoint;

    // Observer design pattern for broadcasting changes to the coordinates
    private final PropertyChangeSupport extentChangeSupport;
    private final PropertyChangeSupport pointChangeSupport;

    public static final String EXTENT_PROPERTY = "extent";
    public static final String POINT_PROPERTY = "point";

    /**
     * Private constructor for singleton pattern
     */
    private CoordinateSelectionModel()
    {
        extentChangeSupport = new PropertyChangeSupport(this);
        pointChangeSupport = new PropertyChangeSupport(this);
    }

    /**
     * Gets the singleton instance of the model
     * @return Singleton instance of the model
     */
    public static CoordinateSelectionModel getInstance()
    {
        if (instance == null)
            instance = new CoordinateSelectionModel();
        return instance;
    }

    /**
     * Gets the selected extent
     * @return Selected extent
     */
    public static BoundingCoordinates getSelectedExtent()
    {
        var extent = getInstance().selectedExtent;
        if (extent != null) {
            return new BoundingCoordinates(extent);
        }
        else {
            return HERWANTA_BOUNDS;
        }
    }

    /**
     * Gets the selected point
     * @return Selected point
     */
    public static fi.tuni.monitor.data.Coordinate getSelectedPoint()
    {
        var point = getInstance().selectedPoint;
        if (point != null)
            return new fi.tuni.monitor.data.Coordinate(point);
        else // default to Herwanta coordinates
            return new fi.tuni.monitor.data.Coordinate(HERWANTA_COORDINATE.getLongitude(), HERWANTA_COORDINATE.getLatitude());
    }

    /**
     * Observer pattern method for adding a listener for extent changes
     * @param listener Listener to add
     */
    public static void subscribeToExtentChanges(PropertyChangeListener listener)
    {
        getInstance().extentChangeSupport.addPropertyChangeListener(EXTENT_PROPERTY, listener);
    }

    /**
     * Observer pattern method for adding a listener for point changes
     * @param listener Listener to add
     */
    public static void subscribeToPointChanges(PropertyChangeListener listener)
    {
        getInstance().pointChangeSupport.addPropertyChangeListener(POINT_PROPERTY, listener);
    }

    /**
     * Gets the preferences of coordinate selection from a preferences file on disk
     * @return preferences object
     */
    public static CoordinateSelectionPreferences getPreferences()
    {
        CoordinateSelectionPreferences preferences = null;
        try
        {
            preferences = (CoordinateSelectionPreferences) SerializationUtil.deserialize(PREFERENCES_FILE);
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Coordinate selection preferences not read!");
        }

        return preferences;
    }

    /**
     * Saves the preferences of coordinate selection to a config file on disk
     * @param preferences preferences to save
     */
    public static void savePreferences(CoordinateSelectionPreferences preferences)
    {
        try
        {
            SerializationUtil.serialize(preferences, PREFERENCES_FILE);
        }
        catch (IOException e)
        {
            System.out.println("Coordinate selection preferences not saved!");
        }
    }

    /**
     * Checks whether coordinates are valid
     * @param coords Variadic array of coordinates to check
     * @return True if all coordinates are valid, false otherwise
     */
    public static Boolean areValidCoordinates(String... coords)
    {
        return Arrays.stream(coords).allMatch(COORDINATE_PATTERN.asMatchPredicate());
    }

    /**
     * Checks whether a coordinate is within the bounds of Finland
     * @param coord Coordinate to check
     * @return True if the coordinate is within the bounds of Finland, false otherwise
     */
    public static Boolean isInFinland(Coordinate coord)
    {
        return FINLAND_EXTENT.getMin().getLatitude() <= coord.getLatitude() &&
                coord.getLatitude() <= FINLAND_EXTENT.getMax().getLatitude() &&
                FINLAND_EXTENT.getMin().getLongitude() <= coord.getLongitude() &&
                coord.getLongitude() <= FINLAND_EXTENT.getMax().getLongitude();
    }

    /**
     * Overloaded method for checking whether a coordinate area is within the bounds of Finland
     * @param extent Coordinate area to check
     * @return True if the coordinate area is within the bounds of Finland, false otherwise
     */
    public static Boolean isInFinland(Extent extent)
    {
        return isInFinland(extent.getMin()) && isInFinland(extent.getMax());
    }

    /**
     * Stringifies a coordinate pair to format 23.12345, 61.12345
     * @param coords Coordinate pair to stringify
     * @return Stringified coordinate pair
     */
    public static String stringifyMapPointerCoordinate(Coordinate coords)
    {
        return String.format(Locale.US, "%.5f, %.5f", coords.getLatitude(), coords.getLongitude());
    }

    /**
     * Stringifies a coordinate (not a coordinate pair) to format 23.12345
     * @param coord Coordinate to stringify
     * @return Stringified coordinate
     */
    public static String stringifyMapCoordinateDegree(Double coord)
    {
        return String.format(Locale.US, "%.5f", coord);
    }

    /**
     * Sets the selected extent
     * @param selectedExtent Selected extent
     */
    public void setSelectedExtent(Extent selectedExtent)
    {
        // observer pattern, notify listeners of change
        extentChangeSupport.firePropertyChange(EXTENT_PROPERTY, this.selectedExtent, selectedExtent);
        this.selectedExtent = selectedExtent;
    }

    /**
     * Sets the selected point
     * @param selectedPoint Selected point
     */
    public void setSelectedPoint(Coordinate selectedPoint)
    {
        // observer pattern, notify listeners of change
        pointChangeSupport.firePropertyChange(POINT_PROPERTY, this.selectedPoint, selectedPoint);
        this.selectedPoint = selectedPoint;
    }

    /**
     * Creatres a new coordinate line from an extent
     * @param extent Extent to create a coordinate line from
     * @return Created coordinate line
     */
    public static CoordinateLine extentToCoordinateLine(Extent extent)
    {
        var min = extent.getMin();
        var max = extent.getMax();
        return new CoordinateLine(min, new Coordinate(min.getLatitude(), max.getLongitude()), max, new Coordinate(max.getLatitude(), min.getLongitude()))
            .setClosed(true)
            .setColor(Color.rgb(100, 150, 0))
            .setFillColor(Color.rgb(255, 255, 255, 0.4))
            .setVisible(true);
    }
}
