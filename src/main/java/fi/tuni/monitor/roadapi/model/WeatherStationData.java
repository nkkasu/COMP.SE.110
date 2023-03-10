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
import fi.tuni.monitor.roadapi.model.SensorValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Weather station with sensor values
 */
@ApiModel(description = "Weather station with sensor values")
@JsonPropertyOrder({
  WeatherStationData.JSON_PROPERTY_ID,
  WeatherStationData.JSON_PROPERTY_MEASURED_TIME,
  WeatherStationData.JSON_PROPERTY_SENSOR_VALUES
})
public class WeatherStationData {
  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_MEASURED_TIME = "measuredTime";
  private OffsetDateTime measuredTime;

  public static final String JSON_PROPERTY_SENSOR_VALUES = "sensorValues";
  private List<SensorValue> sensorValues = new ArrayList<>();

  public WeatherStationData() {
  }

  public WeatherStationData id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * Road station id
   * @return id
  **/
 
  @ApiModelProperty(required = true, value = "Road station id")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(Long id) {
    this.id = id;
  }


  public WeatherStationData measuredTime(OffsetDateTime measuredTime) {
    
    this.measuredTime = measuredTime;
    return this;
  }

   /**
   * Date and time of the sensor&#39;s measurement
   * @return measuredTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date and time of the sensor's measurement")
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


  public WeatherStationData sensorValues(List<SensorValue> sensorValues) {
    
    this.sensorValues = sensorValues;
    return this;
  }

  public WeatherStationData addSensorValuesItem(SensorValue sensorValuesItem) {
    this.sensorValues.add(sensorValuesItem);
    return this;
  }

   /**
   * Measured sensor values of the Weather Station
   * @return sensorValues
  **/
 
  @ApiModelProperty(required = true, value = "Measured sensor values of the Weather Station")
  @JsonProperty(JSON_PROPERTY_SENSOR_VALUES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<SensorValue> getSensorValues() {
    return sensorValues;
  }


  @JsonProperty(JSON_PROPERTY_SENSOR_VALUES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSensorValues(List<SensorValue> sensorValues) {
    this.sensorValues = sensorValues;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeatherStationData weatherStationData = (WeatherStationData) o;
    return Objects.equals(this.id, weatherStationData.id) &&
        Objects.equals(this.measuredTime, weatherStationData.measuredTime) &&
        Objects.equals(this.sensorValues, weatherStationData.sensorValues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, measuredTime, sensorValues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeatherStationData {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    measuredTime: ").append(toIndentedString(measuredTime)).append("\n");
    sb.append("    sensorValues: ").append(toIndentedString(sensorValues)).append("\n");
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

