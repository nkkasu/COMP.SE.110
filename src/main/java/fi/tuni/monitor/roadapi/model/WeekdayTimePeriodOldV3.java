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
 * Working hour
 */
@ApiModel(description = "Working hour")
@JsonPropertyOrder({
  WeekdayTimePeriodOldV3.JSON_PROPERTY_WEEKDAY,
  WeekdayTimePeriodOldV3.JSON_PROPERTY_START_TIME,
  WeekdayTimePeriodOldV3.JSON_PROPERTY_END_TIME
})
@JsonTypeName("WeekdayTimePeriod_OldV3")
public class WeekdayTimePeriodOldV3 {
  /**
   * Weekday
   */
  public enum WeekdayEnum {
    MONDAY("MONDAY"),
    
    TUESDAY("TUESDAY"),
    
    WEDNESDAY("WEDNESDAY"),
    
    THURSDAY("THURSDAY"),
    
    FRIDAY("FRIDAY"),
    
    SATURDAY("SATURDAY"),
    
    SUNDAY("SUNDAY");

    private String value;

    WeekdayEnum(String value) {
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
    public static WeekdayEnum fromValue(String value) {
      for (WeekdayEnum b : WeekdayEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_WEEKDAY = "weekday";
  private WeekdayEnum weekday;

  public static final String JSON_PROPERTY_START_TIME = "startTime";
  private String startTime;

  public static final String JSON_PROPERTY_END_TIME = "endTime";
  private String endTime;

  public WeekdayTimePeriodOldV3() {
  }

  public WeekdayTimePeriodOldV3 weekday(WeekdayEnum weekday) {
    
    this.weekday = weekday;
    return this;
  }

   /**
   * Weekday
   * @return weekday
  **/
 
  @ApiModelProperty(required = true, value = "Weekday")
  @JsonProperty(JSON_PROPERTY_WEEKDAY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public WeekdayEnum getWeekday() {
    return weekday;
  }


  @JsonProperty(JSON_PROPERTY_WEEKDAY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setWeekday(WeekdayEnum weekday) {
    this.weekday = weekday;
  }


  public WeekdayTimePeriodOldV3 startTime(String startTime) {
    
    this.startTime = startTime;
    return this;
  }

   /**
   * Start time of the time period in ISO 8601 local time in Europe/Helsinki
   * @return startTime
  **/
 
  @ApiModelProperty(required = true, value = "Start time of the time period in ISO 8601 local time in Europe/Helsinki")
  @JsonProperty(JSON_PROPERTY_START_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getStartTime() {
    return startTime;
  }


  @JsonProperty(JSON_PROPERTY_START_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }


  public WeekdayTimePeriodOldV3 endTime(String endTime) {
    
    this.endTime = endTime;
    return this;
  }

   /**
   * End time of the time period in ISO 8601 local time in Europe/Helsinki
   * @return endTime
  **/
 
  @ApiModelProperty(required = true, value = "End time of the time period in ISO 8601 local time in Europe/Helsinki")
  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEndTime() {
    return endTime;
  }


  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeekdayTimePeriodOldV3 weekdayTimePeriodOldV3 = (WeekdayTimePeriodOldV3) o;
    return Objects.equals(this.weekday, weekdayTimePeriodOldV3.weekday) &&
        Objects.equals(this.startTime, weekdayTimePeriodOldV3.startTime) &&
        Objects.equals(this.endTime, weekdayTimePeriodOldV3.endTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weekday, startTime, endTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeekdayTimePeriodOldV3 {\n");
    sb.append("    weekday: ").append(toIndentedString(weekday)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
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

