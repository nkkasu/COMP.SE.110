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
import fi.tuni.monitor.roadapi.model.AreaV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Location consisting of one or more areas
 */
@ApiModel(description = "Location consisting of one or more areas")
@JsonPropertyOrder({
  AreaLocationV1.JSON_PROPERTY_AREAS
})
public class AreaLocationV1 {
  public static final String JSON_PROPERTY_AREAS = "areas";
  private List<AreaV1> areas = new ArrayList<>();

  public AreaLocationV1() {
  }

  public AreaLocationV1 areas(List<AreaV1> areas) {
    
    this.areas = areas;
    return this;
  }

  public AreaLocationV1 addAreasItem(AreaV1 areasItem) {
    this.areas.add(areasItem);
    return this;
  }

   /**
   * List of areas
   * @return areas
  **/
 
  @ApiModelProperty(required = true, value = "List of areas")
  @JsonProperty(JSON_PROPERTY_AREAS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<AreaV1> getAreas() {
    return areas;
  }


  @JsonProperty(JSON_PROPERTY_AREAS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAreas(List<AreaV1> areas) {
    this.areas = areas;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AreaLocationV1 areaLocationV1 = (AreaLocationV1) o;
    return Objects.equals(this.areas, areaLocationV1.areas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(areas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AreaLocationV1 {\n");
    sb.append("    areas: ").append(toIndentedString(areas)).append("\n");
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

