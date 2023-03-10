/*
 * Digitraffic Road API
 * [OpenAPI document](/swagger/openapi.json)   Digitraffic is a service operated by the [Fintraffic](https://www.fintraffic.fi) offering real time traffic information. Currently the service covers *road, marine and rail* traffic. More information can be found at the [Digitraffic website](https://www.digitraffic.fi/)   The service has a public Google-group [road.digitraffic.fi](https://groups.google.com/forum/#!forum/roaddigitrafficfi) for communication between developers, service administrators and Fintraffic. The discussion in the forum is mostly in Finnish, but you're welcome to communicate in English too.   ### General notes of the API * Many Digitraffic APIs use GeoJSON as data format. Definition of the GeoJSON format can be found at https://tools.ietf.org/html/rfc7946. * For dates and times [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format is used with \"Zulu\" zero offset from UTC unless otherwise specified (i.e., \"yyyy-mm-ddThh:mm:ss[.mmm]Z\"). E.g. 2019-11-01T06:30:00Z.
 *
 * The version of the OpenAPI document: 2.94.0#e017ffd@2022-10-18T07:48:28+0000
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package fi.tuni.monitor.roadapi.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import fi.tuni.monitor.roadapi.model.LineString;
import fi.tuni.monitor.roadapi.model.MultiLineString;
import fi.tuni.monitor.roadapi.model.MultiPoint;
import fi.tuni.monitor.roadapi.model.MultiPolygon;
import fi.tuni.monitor.roadapi.model.Point;
import fi.tuni.monitor.roadapi.model.Polygon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * TrafficAnnouncementFeatureOldV3Geometry
 */
@JsonPropertyOrder({
  TrafficAnnouncementFeatureOldV3Geometry.JSON_PROPERTY_TYPE,
  TrafficAnnouncementFeatureOldV3Geometry.JSON_PROPERTY_COORDINATES
})
@JsonTypeName("TrafficAnnouncementFeature_OldV3_geometry")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = LineString.class, name = "LineString"),
  @JsonSubTypes.Type(value = MultiLineString.class, name = "MultiLineString"),
  @JsonSubTypes.Type(value = MultiPoint.class, name = "MultiPoint"),
  @JsonSubTypes.Type(value = MultiPolygon.class, name = "MultiPolygon"),
  @JsonSubTypes.Type(value = Point.class, name = "Point"),
  @JsonSubTypes.Type(value = Polygon.class, name = "Polygon"),
})
public class TrafficAnnouncementFeatureOldV3Geometry {
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    POLYGON("Polygon"),
    POINT("Point");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  protected TypeEnum type;

  public static final String JSON_PROPERTY_COORDINATES = "coordinates";
  private List<List<List<Double>>> coordinates = new ArrayList<>();

  public TrafficAnnouncementFeatureOldV3Geometry() {
  }

  public TrafficAnnouncementFeatureOldV3Geometry type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
 
  @ApiModelProperty(example = "Polygon", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public TypeEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  public TrafficAnnouncementFeatureOldV3Geometry coordinates(List<List<List<Double>>> coordinates) {
    
    this.coordinates = coordinates;
    return this;
  }

  public TrafficAnnouncementFeatureOldV3Geometry addCoordinatesItem(List<List<Double>> coordinatesItem) {
    this.coordinates.add(coordinatesItem);
    return this;
  }

   /**
   * An array of LinearRing coordinates. Coordinates are in WGS84 format in decimal degrees: [LONGITUDE, LATITUDE, {ALTITUDE}]. Altitude is optional and measured in meters.
   * @return coordinates
  **/
 
  @ApiModelProperty(example = "[[[100,0],[101,1]],[[102,2],[103,3]]]", required = true, value = "An array of LinearRing coordinates. Coordinates are in WGS84 format in decimal degrees: [LONGITUDE, LATITUDE, {ALTITUDE}]. Altitude is optional and measured in meters.")
  @JsonProperty(JSON_PROPERTY_COORDINATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public List<List<List<Double>>> getCoordinates() {
    return coordinates;
  }


  @JsonProperty(JSON_PROPERTY_COORDINATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCoordinates(List<List<List<Double>>> coordinates) {
    this.coordinates = coordinates;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrafficAnnouncementFeatureOldV3Geometry trafficAnnouncementFeatureOldV3Geometry = (TrafficAnnouncementFeatureOldV3Geometry) o;
    return Objects.equals(this.type, trafficAnnouncementFeatureOldV3Geometry.type) &&
        Objects.equals(this.coordinates, trafficAnnouncementFeatureOldV3Geometry.coordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, coordinates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrafficAnnouncementFeatureOldV3Geometry {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

