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
import fi.tuni.monitor.roadapi.model.SensorConstantValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Sensor constant values of TMS Station
 */
@ApiModel(description = "Sensor constant values of TMS Station")
@JsonPropertyOrder({
  TmsSensorConstant.JSON_PROPERTY_ROAD_STATION_ID,
  TmsSensorConstant.JSON_PROPERTY_SENSOR_CONSTANT_VALUES
})
public class TmsSensorConstant {
  public static final String JSON_PROPERTY_ROAD_STATION_ID = "roadStationId";
  private Long roadStationId;

  public static final String JSON_PROPERTY_SENSOR_CONSTANT_VALUES = "sensorConstantValues";
  private List<SensorConstantValue> sensorConstantValues = new ArrayList<>();

  public TmsSensorConstant() {
  }

  public TmsSensorConstant roadStationId(Long roadStationId) {
    
    this.roadStationId = roadStationId;
    return this;
  }

   /**
   * Id of TMS station
   * @return roadStationId
  **/
 
  @ApiModelProperty(required = true, value = "Id of TMS station")
  @JsonProperty(JSON_PROPERTY_ROAD_STATION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getRoadStationId() {
    return roadStationId;
  }


  @JsonProperty(JSON_PROPERTY_ROAD_STATION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRoadStationId(Long roadStationId) {
    this.roadStationId = roadStationId;
  }


  public TmsSensorConstant sensorConstantValues(List<SensorConstantValue> sensorConstantValues) {
    
    this.sensorConstantValues = sensorConstantValues;
    return this;
  }

  public TmsSensorConstant addSensorConstantValuesItem(SensorConstantValue sensorConstantValuesItem) {
    this.sensorConstantValues.add(sensorConstantValuesItem);
    return this;
  }

   /**
   * TMS Stations sensor constant values
   * @return sensorConstantValues
  **/
 
  @ApiModelProperty(required = true, value = "TMS Stations sensor constant values")
  @JsonProperty(JSON_PROPERTY_SENSOR_CONSTANT_VALUES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<SensorConstantValue> getSensorConstantValues() {
    return sensorConstantValues;
  }


  @JsonProperty(JSON_PROPERTY_SENSOR_CONSTANT_VALUES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSensorConstantValues(List<SensorConstantValue> sensorConstantValues) {
    this.sensorConstantValues = sensorConstantValues;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TmsSensorConstant tmsSensorConstant = (TmsSensorConstant) o;
    return Objects.equals(this.roadStationId, tmsSensorConstant.roadStationId) &&
        Objects.equals(this.sensorConstantValues, tmsSensorConstant.sensorConstantValues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roadStationId, sensorConstantValues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TmsSensorConstant {\n");
    sb.append("    roadStationId: ").append(toIndentedString(roadStationId)).append("\n");
    sb.append("    sensorConstantValues: ").append(toIndentedString(sensorConstantValues)).append("\n");
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
