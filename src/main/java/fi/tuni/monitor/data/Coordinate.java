package fi.tuni.monitor.data;

import java.util.List;

/**
 * Represents a coordinate by longitude and latitude
 * @param lon longitude
 * @param lat latitude
 */
public record Coordinate(Double lon, Double lat)
{
    /**
     * Overloaded constructor for creating a Coordinate object from a list of doubles
     * @param coords List of doubles containing longitude and latitude
     */
    public Coordinate(List<Object> coords)
    {
        this((Double) coords.get(0), (Double) coords.get(1));
    }

    /**
     * Overloaded constructor for creating a Coordinate object from a mapjfx coordinate
     * @param coord mapjfx coordinate
     */
    public Coordinate(com.sothawo.mapjfx.Coordinate coord)
    {
        this(coord.getLongitude(), coord.getLatitude());
    }

    /**
     * Converts the Coordinate object to a mapjfx coordinate
     * @return Converted mapjfx coordinate
     */
    public com.sothawo.mapjfx.Coordinate getMapJFXCoordinate() {
        return new com.sothawo.mapjfx.Coordinate(lat, lon);
    }

    @Override
    public String toString()
    {
        return "Coordinate{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
