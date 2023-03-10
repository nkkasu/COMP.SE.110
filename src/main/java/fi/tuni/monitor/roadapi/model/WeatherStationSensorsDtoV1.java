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
import fi.tuni.monitor.roadapi.model.WeatherStationSensorDtoV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Available sensors of weather stations
 */
@ApiModel(description = "Available sensors of weather stations")
@JsonPropertyOrder({
  WeatherStationSensorsDtoV1.JSON_PROPERTY_DATA_UPDATED_TIME,
  WeatherStationSensorsDtoV1.JSON_PROPERTY_DATA_LAST_CHECKED_TIME,
  WeatherStationSensorsDtoV1.JSON_PROPERTY_SENSORS
})
public class WeatherStationSensorsDtoV1 {
  public static final String JSON_PROPERTY_DATA_UPDATED_TIME = "dataUpdatedTime";
  private OffsetDateTime dataUpdatedTime;

  public static final String JSON_PROPERTY_DATA_LAST_CHECKED_TIME = "dataLastCheckedTime";
  private OffsetDateTime dataLastCheckedTime;

  public static final String JSON_PROPERTY_SENSORS = "sensors";
  private List<WeatherStationSensorDtoV1> sensors = new ArrayList<>();

  public WeatherStationSensorsDtoV1() {
  }

  public WeatherStationSensorsDtoV1 dataUpdatedTime(OffsetDateTime dataUpdatedTime) {
    
    this.dataUpdatedTime = dataUpdatedTime;
    return this;
  }

   /**
   * Data last updated date time
   * @return dataUpdatedTime
  **/
 
  @ApiModelProperty(required = true, value = "Data last updated date time")
  @JsonProperty(JSON_PROPERTY_DATA_UPDATED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getDataUpdatedTime() {
    return dataUpdatedTime;
  }


  @JsonProperty(JSON_PROPERTY_DATA_UPDATED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDataUpdatedTime(OffsetDateTime dataUpdatedTime) {
    this.dataUpdatedTime = dataUpdatedTime;
  }


  public WeatherStationSensorsDtoV1 dataLastCheckedTime(OffsetDateTime dataLastCheckedTime) {
    
    this.dataLastCheckedTime = dataLastCheckedTime;
    return this;
  }

   /**
   * Data last checked date time
   * @return dataLastCheckedTime
  **/
 
  @ApiModelProperty(required = true, value = "Data last checked date time")
  @JsonProperty(JSON_PROPERTY_DATA_LAST_CHECKED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getDataLastCheckedTime() {
    return dataLastCheckedTime;
  }


  @JsonProperty(JSON_PROPERTY_DATA_LAST_CHECKED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDataLastCheckedTime(OffsetDateTime dataLastCheckedTime) {
    this.dataLastCheckedTime = dataLastCheckedTime;
  }


  public WeatherStationSensorsDtoV1 sensors(List<WeatherStationSensorDtoV1> sensors) {
    
    this.sensors = sensors;
    return this;
  }

  public WeatherStationSensorsDtoV1 addSensorsItem(WeatherStationSensorDtoV1 sensorsItem) {
    this.sensors.add(sensorsItem);
    return this;
  }

   /**
   * Available sensors of road stations
   * @return sensors
  **/
 
  @ApiModelProperty(required = true, value = "Available sensors of road stations")
  @JsonProperty(JSON_PROPERTY_SENSORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<WeatherStationSensorDtoV1> getSensors() {
    return sensors;
  }


  @JsonProperty(JSON_PROPERTY_SENSORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSensors(List<WeatherStationSensorDtoV1> sensors) {
    this.sensors = sensors;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeatherStationSensorsDtoV1 weatherStationSensorsDtoV1 = (WeatherStationSensorsDtoV1) o;
    return Objects.equals(this.dataUpdatedTime, weatherStationSensorsDtoV1.dataUpdatedTime) &&
        Objects.equals(this.dataLastCheckedTime, weatherStationSensorsDtoV1.dataLastCheckedTime) &&
        Objects.equals(this.sensors, weatherStationSensorsDtoV1.sensors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataUpdatedTime, dataLastCheckedTime, sensors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeatherStationSensorsDtoV1 {\n");
    sb.append("    dataUpdatedTime: ").append(toIndentedString(dataUpdatedTime)).append("\n");
    sb.append("    dataLastCheckedTime: ").append(toIndentedString(dataLastCheckedTime)).append("\n");
    sb.append("    sensors: ").append(toIndentedString(sensors)).append("\n");
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

