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
import fi.tuni.monitor.roadapi.model.FeatureV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A single phase in a larger road work
 */
@ApiModel(description = "A single phase in a larger road work")
@JsonPropertyOrder({
  RestrictionV1.JSON_PROPERTY_TYPE,
  RestrictionV1.JSON_PROPERTY_RESTRICTION
})
public class RestrictionV1 {
  /**
   * Type of the restriction.
   */
  public enum TypeEnum {
    SPEED_LIMIT("SPEED_LIMIT"),
    
    SPEED_LIMIT_LENGTH("SPEED_LIMIT_LENGTH"),
    
    TRAFFIC_LIGHTS("TRAFFIC_LIGHTS"),
    
    MULTIPLE_LANES_CLOSED("MULTIPLE_LANES_CLOSED"),
    
    SINGLE_LANE_CLOSED("SINGLE_LANE_CLOSED"),
    
    SINGLE_CARRIAGEWAY_CLOSED("SINGLE_CARRIAGEWAY_CLOSED"),
    
    ROAD_CLOSED("ROAD_CLOSED"),
    
    SINGLE_ALTERNATE_LINE_TRAFFIC("SINGLE_ALTERNATE_LINE_TRAFFIC"),
    
    CONTRA_FLOW_TRAFFIC("CONTRA_FLOW_TRAFFIC"),
    
    INTERMITTENT_SHORT_TERM_STOPS("INTERMITTENT_SHORT_TERM_STOPS"),
    
    INTERMITTENT_SHORT_TERM_CLOSURE("INTERMITTENT_SHORT_TERM_CLOSURE"),
    
    INTERMITTENT_STOPS_AND_CLOSURE_EFFECTIVE("INTERMITTENT_STOPS_AND_CLOSURE_EFFECTIVE"),
    
    NARROW_LANES("NARROW_LANES"),
    
    DETOUR("DETOUR"),
    
    DETOUR_SIGNS("DETOUR_SIGNS"),
    
    DETOUR_CURVES_STEEP("DETOUR_CURVES_STEEP"),
    
    DETOUR_CURVES_GENTLE("DETOUR_CURVES_GENTLE"),
    
    DETOUR_USING_ROADWAYS("DETOUR_USING_ROADWAYS"),
    
    DETOUR_SURFACE_PAVED("DETOUR_SURFACE_PAVED"),
    
    DETOUR_SURFACE_MILLED("DETOUR_SURFACE_MILLED"),
    
    DETOUR_SURFACE_GRAVEL("DETOUR_SURFACE_GRAVEL"),
    
    DETOUR_LENGTH("DETOUR_LENGTH"),
    
    DETOUR_GROSS_WEIGHT_LIMIT("DETOUR_GROSS_WEIGHT_LIMIT"),
    
    SLOW_MOVING_MAINTENANCE_VEHICLE("SLOW_MOVING_MAINTENANCE_VEHICLE"),
    
    ESTIMATED_DELAY("ESTIMATED_DELAY"),
    
    ESTIMATED_DELAY_DURING_RUSH_HOUR("ESTIMATED_DELAY_DURING_RUSH_HOUR"),
    
    NARROW_OR_CLOSED_PEDESTRIAN_AND_BICYLE_PATH("NARROW_OR_CLOSED_PEDESTRIAN_AND_BICYLE_PATH"),
    
    VEHICLE_HEIGHT_LIMIT("VEHICLE_HEIGHT_LIMIT"),
    
    VEHICLE_WIDTH_LIMIT("VEHICLE_WIDTH_LIMIT"),
    
    VEHICLE_LENGTH_LIMIT("VEHICLE_LENGTH_LIMIT"),
    
    VEHICLE_GROSS_WEIGHT_LIMIT("VEHICLE_GROSS_WEIGHT_LIMIT"),
    
    ROAD_SURFACE_PAVED("ROAD_SURFACE_PAVED"),
    
    ROAD_SURFACE_MILLED("ROAD_SURFACE_MILLED"),
    
    ROAD_SURFACE_GRAVEL("ROAD_SURFACE_GRAVEL"),
    
    OPEN_FIRE_HEATER_IN_USE("OPEN_FIRE_HEATER_IN_USE");

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

  public static final String JSON_PROPERTY_RESTRICTION = "restriction";
  private FeatureV1 restriction;

  public RestrictionV1() {
  }

  public RestrictionV1 type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Type of the restriction.
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Type of the restriction.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TypeEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  public RestrictionV1 restriction(FeatureV1 restriction) {
    
    this.restriction = restriction;
    return this;
  }

   /**
   * Get restriction
   * @return restriction
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESTRICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FeatureV1 getRestriction() {
    return restriction;
  }


  @JsonProperty(JSON_PROPERTY_RESTRICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRestriction(FeatureV1 restriction) {
    this.restriction = restriction;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestrictionV1 restrictionV1 = (RestrictionV1) o;
    return Objects.equals(this.type, restrictionV1.type) &&
        Objects.equals(this.restriction, restrictionV1.restriction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, restriction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestrictionV1 {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    restriction: ").append(toIndentedString(restriction)).append("\n");
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

