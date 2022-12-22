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
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Weathercam station preset&#39;s publicity changes
 */
@ApiModel(description = "Weathercam station preset's publicity changes")
@JsonPropertyOrder({
  WeathercamPresetPublicityHistoryV1.JSON_PROPERTY_ID,
  WeathercamPresetPublicityHistoryV1.JSON_PROPERTY_MEASURED_TIME,
  WeathercamPresetPublicityHistoryV1.JSON_PROPERTY_PUBLISHABLE_TO,
  WeathercamPresetPublicityHistoryV1.JSON_PROPERTY_MODIFIED_TIME
})
public class WeathercamPresetPublicityHistoryV1 {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_MEASURED_TIME = "measuredTime";
  private OffsetDateTime measuredTime;

  public static final String JSON_PROPERTY_PUBLISHABLE_TO = "publishableTo";
  private Boolean publishableTo;

  public static final String JSON_PROPERTY_MODIFIED_TIME = "modifiedTime";
  private OffsetDateTime modifiedTime;

  public WeathercamPresetPublicityHistoryV1() {
  }

  public WeathercamPresetPublicityHistoryV1 id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Id of the weathercam preset
   * @return id
  **/
 
  @ApiModelProperty(required = true, value = "Id of the weathercam preset")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public WeathercamPresetPublicityHistoryV1 measuredTime(OffsetDateTime measuredTime) {
    
    this.measuredTime = measuredTime;
    return this;
  }

   /**
   * The time when change took place. Same as the last modified date of the related image version.
   * @return measuredTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The time when change took place. Same as the last modified date of the related image version.")
  @JsonProperty(JSON_PROPERTY_MEASURED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getMeasuredTime() {
    return measuredTime;
  }


  @JsonProperty(JSON_PROPERTY_MEASURED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMeasuredTime(OffsetDateTime measuredTime) {
    this.measuredTime = measuredTime;
  }


  public WeathercamPresetPublicityHistoryV1 publishableTo(Boolean publishableTo) {
    
    this.publishableTo = publishableTo;
    return this;
  }

   /**
   * New state for publicity
   * @return publishableTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "New state for publicity")
  @JsonProperty(JSON_PROPERTY_PUBLISHABLE_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getPublishableTo() {
    return publishableTo;
  }


  @JsonProperty(JSON_PROPERTY_PUBLISHABLE_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPublishableTo(Boolean publishableTo) {
    this.publishableTo = publishableTo;
  }


  public WeathercamPresetPublicityHistoryV1 modifiedTime(OffsetDateTime modifiedTime) {
    
    this.modifiedTime = modifiedTime;
    return this;
  }

   /**
   * Modification time of the history.
   * @return modifiedTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Modification time of the history.")
  @JsonProperty(JSON_PROPERTY_MODIFIED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getModifiedTime() {
    return modifiedTime;
  }


  @JsonProperty(JSON_PROPERTY_MODIFIED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setModifiedTime(OffsetDateTime modifiedTime) {
    this.modifiedTime = modifiedTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeathercamPresetPublicityHistoryV1 weathercamPresetPublicityHistoryV1 = (WeathercamPresetPublicityHistoryV1) o;
    return Objects.equals(this.id, weathercamPresetPublicityHistoryV1.id) &&
        Objects.equals(this.measuredTime, weathercamPresetPublicityHistoryV1.measuredTime) &&
        Objects.equals(this.publishableTo, weathercamPresetPublicityHistoryV1.publishableTo) &&
        Objects.equals(this.modifiedTime, weathercamPresetPublicityHistoryV1.modifiedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, measuredTime, publishableTo, modifiedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeathercamPresetPublicityHistoryV1 {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    measuredTime: ").append(toIndentedString(measuredTime)).append("\n");
    sb.append("    publishableTo: ").append(toIndentedString(publishableTo)).append("\n");
    sb.append("    modifiedTime: ").append(toIndentedString(modifiedTime)).append("\n");
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
