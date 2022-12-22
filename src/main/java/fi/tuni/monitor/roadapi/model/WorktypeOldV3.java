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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Worktype
 */
@ApiModel(description = "Worktype")
@JsonPropertyOrder({
  WorktypeOldV3.JSON_PROPERTY_TYPE,
  WorktypeOldV3.JSON_PROPERTY_DESCRIPTION
})
@JsonTypeName("Worktype_OldV3")
public class WorktypeOldV3 {
  /**
   * Worktype
   */
  public enum TypeEnum {
    BRIDGE("BRIDGE"),
    
    JUNCTION("JUNCTION"),
    
    CRASH_BARRIER("CRASH_BARRIER"),
    
    BURIED_CABLES("BURIED_CABLES"),
    
    LIGHTING("LIGHTING"),
    
    ROADSIDE_EQUIPMENT("ROADSIDE_EQUIPMENT"),
    
    MEASUREMENT_EQUIPMENT("MEASUREMENT_EQUIPMENT"),
    
    LEVEL_CROSSING("LEVEL_CROSSING"),
    
    BLASTING_WORK("BLASTING_WORK"),
    
    ROAD_CONSTRUCTION("ROAD_CONSTRUCTION"),
    
    STRUCTURAL_IMPROVEMENT("STRUCTURAL_IMPROVEMENT"),
    
    UNDERPASS_CONSTRUCTION("UNDERPASS_CONSTRUCTION"),
    
    PEDESTRIAN_AND_BICYCLE_PATH("PEDESTRIAN_AND_BICYCLE_PATH"),
    
    STABILIZATION("STABILIZATION"),
    
    RESURFACING("RESURFACING"),
    
    ROAD_SURFACE_MARKING("ROAD_SURFACE_MARKING"),
    
    FINISHING_WORK("FINISHING_WORK"),
    
    MEASUREMENT("MEASUREMENT"),
    
    TREE_AND_VEGETATION_CUTTING("TREE_AND_VEGETATION_CUTTING"),
    
    GRASS_CUTTING("GRASS_CUTTING"),
    
    MAINTENANCE("MAINTENANCE"),
    
    CULVERT_REPLACEMENT("CULVERT_REPLACEMENT"),
    
    OTHER("OTHER");

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

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public WorktypeOldV3() {
  }

  public WorktypeOldV3 type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Worktype
   * @return type
  **/
 
  @ApiModelProperty(required = true, value = "Worktype")
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


  public WorktypeOldV3 description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Description
   * @return description
  **/
 
  @ApiModelProperty(required = true, value = "Description")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorktypeOldV3 worktypeOldV3 = (WorktypeOldV3) o;
    return Objects.equals(this.type, worktypeOldV3.type) &&
        Objects.equals(this.description, worktypeOldV3.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorktypeOldV3 {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

