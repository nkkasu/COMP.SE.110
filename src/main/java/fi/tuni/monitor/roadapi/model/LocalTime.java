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
 * End time of the time period in ISO 8601 local time in Europe/Helsinki
 */
@ApiModel(description = "End time of the time period in ISO 8601 local time in Europe/Helsinki")
@JsonPropertyOrder({
  LocalTime.JSON_PROPERTY_HOUR,
  LocalTime.JSON_PROPERTY_MINUTE,
  LocalTime.JSON_PROPERTY_SECOND,
  LocalTime.JSON_PROPERTY_NANO
})
public class LocalTime {
  public static final String JSON_PROPERTY_HOUR = "hour";
  private Integer hour;

  public static final String JSON_PROPERTY_MINUTE = "minute";
  private Integer minute;

  public static final String JSON_PROPERTY_SECOND = "second";
  private Integer second;

  public static final String JSON_PROPERTY_NANO = "nano";
  private Integer nano;

  public LocalTime() {
  }

  public LocalTime(String date) {

  }
  public LocalTime hour(Integer hour) {
    
    this.hour = hour;
    return this;
  }

   /**
   * Get hour
   * @return hour
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HOUR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getHour() {
    return hour;
  }


  @JsonProperty(JSON_PROPERTY_HOUR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHour(Integer hour) {
    this.hour = hour;
  }


  public LocalTime minute(Integer minute) {
    
    this.minute = minute;
    return this;
  }

   /**
   * Get minute
   * @return minute
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MINUTE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMinute() {
    return minute;
  }


  @JsonProperty(JSON_PROPERTY_MINUTE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMinute(Integer minute) {
    this.minute = minute;
  }


  public LocalTime second(Integer second) {
    
    this.second = second;
    return this;
  }

   /**
   * Get second
   * @return second
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SECOND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSecond() {
    return second;
  }


  @JsonProperty(JSON_PROPERTY_SECOND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSecond(Integer second) {
    this.second = second;
  }


  public LocalTime nano(Integer nano) {
    
    this.nano = nano;
    return this;
  }

   /**
   * Get nano
   * @return nano
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NANO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNano() {
    return nano;
  }


  @JsonProperty(JSON_PROPERTY_NANO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNano(Integer nano) {
    this.nano = nano;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalTime localTime = (LocalTime) o;
    return Objects.equals(this.hour, localTime.hour) &&
        Objects.equals(this.minute, localTime.minute) &&
        Objects.equals(this.second, localTime.second) &&
        Objects.equals(this.nano, localTime.nano);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hour, minute, second, nano);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalTime {\n");
    sb.append("    hour: ").append(toIndentedString(hour)).append("\n");
    sb.append("    minute: ").append(toIndentedString(minute)).append("\n");
    sb.append("    second: ").append(toIndentedString(second)).append("\n");
    sb.append("    nano: ").append(toIndentedString(nano)).append("\n");
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
