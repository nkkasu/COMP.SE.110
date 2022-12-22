package fi.tuni.monitor.saveddata;

import java.io.Serializable;

/**
 * Stores the user's preferences for the coordinate selection.<br>
 * Implements Serializable so that the preferences can be saved to a file.
 * @param latMinFieldValue The minimum latitude value.
 * @param lonMinFieldValue The minimum longitude value.
 * @param latMaxFieldValue The maximum latitude value.
 * @param lonMaxFieldValue The maximum longitude value.
 * @param latPointField The latitude value of the point.
 * @param lonPointField The longitude value of the point.
 */
public record CoordinateSelectionPreferences(String latMinFieldValue, String lonMinFieldValue, String latMaxFieldValue,
                                             String lonMaxFieldValue, String latPointField,
                                             String lonPointField) implements Serializable
{

}
