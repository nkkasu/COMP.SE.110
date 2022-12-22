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
import fi.tuni.monitor.roadapi.model.TmsStationSensorConstantDtoV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Latest sensor constant values of TMS stations
 */
@ApiModel(description = "Latest sensor constant values of TMS stations")
@JsonPropertyOrder({
  TmsStationsSensorConstantsDataDtoV1.JSON_PROPERTY_DATA_UPDATED_TIME,
  TmsStationsSensorConstantsDataDtoV1.JSON_PROPERTY_STATIONS
})
public class TmsStationsSensorConstantsDataDtoV1 {
  public static final String JSON_PROPERTY_DATA_UPDATED_TIME = "dataUpdatedTime";
  private OffsetDateTime dataUpdatedTime;

  public static final String JSON_PROPERTY_STATIONS = "stations";
  private List<TmsStationSensorConstantDtoV1> stations = null;

  public TmsStationsSensorConstantsDataDtoV1() {
  }

  public TmsStationsSensorConstantsDataDtoV1 dataUpdatedTime(OffsetDateTime dataUpdatedTime) {
    
    this.dataUpdatedTime = dataUpdatedTime;
    return this;
  }

   /**
   * Time when data was last updated
   * @return dataUpdatedTime
  **/
 
  @ApiModelProperty(required = true, value = "Time when data was last updated")
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


  public TmsStationsSensorConstantsDataDtoV1 stations(List<TmsStationSensorConstantDtoV1> stations) {
    
    this.stations = stations;
    return this;
  }

  public TmsStationsSensorConstantsDataDtoV1 addStationsItem(TmsStationSensorConstantDtoV1 stationsItem) {
    if (this.stations == null) {
      this.stations = new ArrayList<>();
    }
    this.stations.add(stationsItem);
    return this;
  }

   /**
   * Stations data
   * @return stations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Stations data")
  @JsonProperty(JSON_PROPERTY_STATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<TmsStationSensorConstantDtoV1> getStations() {
    return stations;
  }


  @JsonProperty(JSON_PROPERTY_STATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStations(List<TmsStationSensorConstantDtoV1> stations) {
    this.stations = stations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TmsStationsSensorConstantsDataDtoV1 tmsStationsSensorConstantsDataDtoV1 = (TmsStationsSensorConstantsDataDtoV1) o;
    return Objects.equals(this.dataUpdatedTime, tmsStationsSensorConstantsDataDtoV1.dataUpdatedTime) &&
        Objects.equals(this.stations, tmsStationsSensorConstantsDataDtoV1.stations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataUpdatedTime, stations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TmsStationsSensorConstantsDataDtoV1 {\n");
    sb.append("    dataUpdatedTime: ").append(toIndentedString(dataUpdatedTime)).append("\n");
    sb.append("    stations: ").append(toIndentedString(stations)).append("\n");
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

