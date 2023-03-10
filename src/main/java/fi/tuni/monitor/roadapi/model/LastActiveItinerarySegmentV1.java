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
import fi.tuni.monitor.roadapi.model.ItineraryLegV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The itinerary segment of this special transport that is or was last active.
 */
@ApiModel(description = "The itinerary segment of this special transport that is or was last active.")
@JsonPropertyOrder({
  LastActiveItinerarySegmentV1.JSON_PROPERTY_START_TIME,
  LastActiveItinerarySegmentV1.JSON_PROPERTY_END_TIME,
  LastActiveItinerarySegmentV1.JSON_PROPERTY_LEGS
})
public class LastActiveItinerarySegmentV1 {
  public static final String JSON_PROPERTY_START_TIME = "startTime";
  private OffsetDateTime startTime;

  public static final String JSON_PROPERTY_END_TIME = "endTime";
  private OffsetDateTime endTime;

  public static final String JSON_PROPERTY_LEGS = "legs";
  private List<ItineraryLegV1> legs = new ArrayList<>();

  public LastActiveItinerarySegmentV1() {
  }

  public LastActiveItinerarySegmentV1 startTime(OffsetDateTime startTime) {
    
    this.startTime = startTime;
    return this;
  }

   /**
   * The time when the transport may start this segment.
   * @return startTime
  **/
 
  @ApiModelProperty(required = true, value = "The time when the transport may start this segment.")
  @JsonProperty(JSON_PROPERTY_START_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getStartTime() {
    return startTime;
  }


  @JsonProperty(JSON_PROPERTY_START_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }


  public LastActiveItinerarySegmentV1 endTime(OffsetDateTime endTime) {
    
    this.endTime = endTime;
    return this;
  }

   /**
   * Time by which the transport has finished this segment.
   * @return endTime
  **/
 
  @ApiModelProperty(required = true, value = "Time by which the transport has finished this segment.")
  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getEndTime() {
    return endTime;
  }


  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }


  public LastActiveItinerarySegmentV1 legs(List<ItineraryLegV1> legs) {
    
    this.legs = legs;
    return this;
  }

  public LastActiveItinerarySegmentV1 addLegsItem(ItineraryLegV1 legsItem) {
    this.legs.add(legsItem);
    return this;
  }

   /**
   * Route legs.
   * @return legs
  **/
 
  @ApiModelProperty(required = true, value = "Route legs.")
  @JsonProperty(JSON_PROPERTY_LEGS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ItineraryLegV1> getLegs() {
    return legs;
  }


  @JsonProperty(JSON_PROPERTY_LEGS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLegs(List<ItineraryLegV1> legs) {
    this.legs = legs;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LastActiveItinerarySegmentV1 lastActiveItinerarySegmentV1 = (LastActiveItinerarySegmentV1) o;
    return Objects.equals(this.startTime, lastActiveItinerarySegmentV1.startTime) &&
        Objects.equals(this.endTime, lastActiveItinerarySegmentV1.endTime) &&
        Objects.equals(this.legs, lastActiveItinerarySegmentV1.legs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startTime, endTime, legs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LastActiveItinerarySegmentV1 {\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    legs: ").append(toIndentedString(legs)).append("\n");
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

