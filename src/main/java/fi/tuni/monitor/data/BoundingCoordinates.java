package fi.tuni.monitor.data;

import com.sothawo.mapjfx.Extent;

/**
 * Represents a coordinate area by coordinates
 * @param minLon minimum longitude
 * @param minLat minimum latitude
 * @param maxLon maximum longitude
 * @param maxLat maximum latitude
 */
public record BoundingCoordinates(Double minLon, Double minLat, Double maxLon, Double maxLat)
{
    /**
     * Overloaded constuctor for creating a BoundingCoordinates object from an Extent object
     * @param extent Extent object from mapjfx
     */
    public BoundingCoordinates(Extent extent)
    {
        this(extent.getMin().getLongitude(), extent.getMin().getLatitude(), extent.getMax().getLongitude(), extent.getMax().getLatitude());
    }

    /**
     * Checks if a coordinate is inside the bounding area
     * @param coord Coordinate object to check
     * @return true if the coordinate is inside the bounding area, false otherwise
     */
    public boolean isInBounds(Coordinate coord)
    {
        var coordLat = coord.lat();
        var coordLon = coord.lon();
        return ((coordLat <= this.maxLat && coordLat >= this.minLat)
                && (coordLon <= this.maxLon && coordLon >= this.minLon));
    }

    /**
     * Converts the BoundingCoordinates object to an Extent object for mapjfx
     * @return Converted Extent object
     */
    public Extent getExtent() {
        return Extent.forCoordinates(
                new com.sothawo.mapjfx.Coordinate(minLat, minLon),
                new com.sothawo.mapjfx.Coordinate(maxLat, maxLon)
        );
    }
}
