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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingPropertiesOld;
import fi.tuni.monitor.roadapi.model.TrafficAnnouncementFeatureOldV3Geometry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * GeoJSON Feature Object.
 */
@ApiModel(description = "GeoJSON Feature Object.")
@JsonPropertyOrder({
  MaintenanceTrackingFeatureOld.JSON_PROPERTY_TYPE,
  MaintenanceTrackingFeatureOld.JSON_PROPERTY_PROPERTIES,
  MaintenanceTrackingFeatureOld.JSON_PROPERTY_GEOMETRY
})
public class MaintenanceTrackingFeatureOld {
  /**
   * GeoJSON Feature Object
   */
  public enum TypeEnum {
    FEATURE("Feature");

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
  private TypeEnum type;

  public static final String JSON_PROPERTY_PROPERTIES = "properties";
  private MaintenanceTrackingPropertiesOld properties;

  public static final String JSON_PROPERTY_GEOMETRY = "geometry";
  private TrafficAnnouncementFeatureOldV3Geometry geometry;

  public MaintenanceTrackingFeatureOld() {
  }

  public MaintenanceTrackingFeatureOld type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * GeoJSON Feature Object
   * @return type
  **/
 
  @ApiModelProperty(required = true, value = "GeoJSON Feature Object")
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


  public MaintenanceTrackingFeatureOld properties(MaintenanceTrackingPropertiesOld properties) {
    
    this.properties = properties;
    return this;
  }

   /**
   * Get properties
   * @return properties
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public MaintenanceTrackingPropertiesOld getProperties() {
    return properties;
  }


  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProperties(MaintenanceTrackingPropertiesOld properties) {
    this.properties = properties;
  }


  public MaintenanceTrackingFeatureOld geometry(TrafficAnnouncementFeatureOldV3Geometry geometry) {
    
    this.geometry = geometry;
    return this;
  }

   /**
   * Get geometry
   * @return geometry
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_GEOMETRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TrafficAnnouncementFeatureOldV3Geometry getGeometry() {
    return geometry;
  }


  @JsonProperty(JSON_PROPERTY_GEOMETRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGeometry(TrafficAnnouncementFeatureOldV3Geometry geometry) {
    this.geometry = geometry;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MaintenanceTrackingFeatureOld maintenanceTrackingFeatureOld = (MaintenanceTrackingFeatureOld) o;
    return Objects.equals(this.type, maintenanceTrackingFeatureOld.type) &&
        Objects.equals(this.properties, maintenanceTrackingFeatureOld.properties) &&
        Objects.equals(this.geometry, maintenanceTrackingFeatureOld.geometry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, properties, geometry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaintenanceTrackingFeatureOld {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    geometry: ").append(toIndentedString(geometry)).append("\n");
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

