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
 * WeatherSensorValueHistoryDto
 */
@JsonPropertyOrder({
  WeatherSensorValueHistoryDto.JSON_PROPERTY_ROAD_STATION_ID,
  WeatherSensorValueHistoryDto.JSON_PROPERTY_SENSOR_ID,
  WeatherSensorValueHistoryDto.JSON_PROPERTY_SENSOR_VALUE,
  WeatherSensorValueHistoryDto.JSON_PROPERTY_MEASURED,
  WeatherSensorValueHistoryDto.JSON_PROPERTY_MEASURED_TIME
})
public class WeatherSensorValueHistoryDto {
  public static final String JSON_PROPERTY_ROAD_STATION_ID = "roadStationId";
  private Long roadStationId;

  public static final String JSON_PROPERTY_SENSOR_ID = "sensorId";
  private Long sensorId;

  public static final String JSON_PROPERTY_SENSOR_VALUE = "sensorValue";
  private Double sensorValue;

  public static final String JSON_PROPERTY_MEASURED = "measured";
  private OffsetDateTime measured;

  public static final String JSON_PROPERTY_MEASURED_TIME = "measuredTime";
  private OffsetDateTime measuredTime;

  public WeatherSensorValueHistoryDto() {
  }

  public WeatherSensorValueHistoryDto roadStationId(Long roadStationId) {
    
    this.roadStationId = roadStationId;
    return this;
  }

   /**
   * Road station id
   * @return roadStationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Road station id")
  @JsonProperty(JSON_PROPERTY_ROAD_STATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getRoadStationId() {
    return roadStationId;
  }


  @JsonProperty(JSON_PROPERTY_ROAD_STATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoadStationId(Long roadStationId) {
    this.roadStationId = roadStationId;
  }


  public WeatherSensorValueHistoryDto sensorId(Long sensorId) {
    
    this.sensorId = sensorId;
    return this;
  }

   /**
   * Sensor id
   * @return sensorId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Sensor id")
  @JsonProperty(JSON_PROPERTY_SENSOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getSensorId() {
    return sensorId;
  }


  @JsonProperty(JSON_PROPERTY_SENSOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSensorId(Long sensorId) {
    this.sensorId = sensorId;
  }


  public WeatherSensorValueHistoryDto sensorValue(Double sensorValue) {
    
    this.sensorValue = sensorValue;
    return this;
  }

   /**
   * Sensor value
   * @return sensorValue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Sensor value")
  @JsonProperty(JSON_PROPERTY_SENSOR_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getSensorValue() {
    return sensorValue;
  }


  @JsonProperty(JSON_PROPERTY_SENSOR_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSensorValue(Double sensorValue) {
    this.sensorValue = sensorValue;
  }


  public WeatherSensorValueHistoryDto measured(OffsetDateTime measured) {
    
    this.measured = measured;
    return this;
  }

   /**
   * Get measured
   * @return measured
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MEASURED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getMeasured() {
    return measured;
  }


  @JsonProperty(JSON_PROPERTY_MEASURED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMeasured(OffsetDateTime measured) {
    this.measured = measured;
  }


  public WeatherSensorValueHistoryDto measuredTime(OffsetDateTime measuredTime) {
    
    this.measuredTime = measuredTime;
    return this;
  }

   /**
   * Value&#39;s measured date time
   * @return measuredTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Value's measured date time")
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeatherSensorValueHistoryDto weatherSensorValueHistoryDto = (WeatherSensorValueHistoryDto) o;
    return Objects.equals(this.roadStationId, weatherSensorValueHistoryDto.roadStationId) &&
        Objects.equals(this.sensorId, weatherSensorValueHistoryDto.sensorId) &&
        Objects.equals(this.sensorValue, weatherSensorValueHistoryDto.sensorValue) &&
        Objects.equals(this.measured, weatherSensorValueHistoryDto.measured) &&
        Objects.equals(this.measuredTime, weatherSensorValueHistoryDto.measuredTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roadStationId, sensorId, sensorValue, measured, measuredTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeatherSensorValueHistoryDto {\n");
    sb.append("    roadStationId: ").append(toIndentedString(roadStationId)).append("\n");
    sb.append("    sensorId: ").append(toIndentedString(sensorId)).append("\n");
    sb.append("    sensorValue: ").append(toIndentedString(sensorValue)).append("\n");
    sb.append("    measured: ").append(toIndentedString(measured)).append("\n");
    sb.append("    measuredTime: ").append(toIndentedString(measuredTime)).append("\n");
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
