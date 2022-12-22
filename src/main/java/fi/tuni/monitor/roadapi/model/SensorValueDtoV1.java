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
 * Sensor value
 */
@ApiModel(description = "Sensor value")
@JsonPropertyOrder({
  SensorValueDtoV1.JSON_PROPERTY_ID,
  SensorValueDtoV1.JSON_PROPERTY_STATION_ID,
  SensorValueDtoV1.JSON_PROPERTY_NAME,
  SensorValueDtoV1.JSON_PROPERTY_SHORT_NAME,
  SensorValueDtoV1.JSON_PROPERTY_TIME_WINDOW_START,
  SensorValueDtoV1.JSON_PROPERTY_TIME_WINDOW_END,
  SensorValueDtoV1.JSON_PROPERTY_MEASURED_TIME,
  SensorValueDtoV1.JSON_PROPERTY_SENSOR_VALUE_DESCRIPTION_FI,
  SensorValueDtoV1.JSON_PROPERTY_SENSOR_VALUE_DESCRIPTION_EN,
  SensorValueDtoV1.JSON_PROPERTY_UNIT,
  SensorValueDtoV1.JSON_PROPERTY_VALUE
})
public class SensorValueDtoV1 {
  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_STATION_ID = "stationId";
  private Long stationId;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_SHORT_NAME = "shortName";
  private String shortName;

  public static final String JSON_PROPERTY_TIME_WINDOW_START = "timeWindowStart";
  private OffsetDateTime timeWindowStart;

  public static final String JSON_PROPERTY_TIME_WINDOW_END = "timeWindowEnd";
  private OffsetDateTime timeWindowEnd;

  public static final String JSON_PROPERTY_MEASURED_TIME = "measuredTime";
  private OffsetDateTime measuredTime;

  public static final String JSON_PROPERTY_SENSOR_VALUE_DESCRIPTION_FI = "sensorValueDescriptionFi";
  private String sensorValueDescriptionFi;

  public static final String JSON_PROPERTY_SENSOR_VALUE_DESCRIPTION_EN = "sensorValueDescriptionEn";
  private String sensorValueDescriptionEn;

  public static final String JSON_PROPERTY_UNIT = "unit";
  private String unit;

  public static final String JSON_PROPERTY_VALUE = "value";
  private Double value;

  public SensorValueDtoV1() {
  }

  public SensorValueDtoV1 id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * Sensor type id (naturalId)
   * @return id
  **/
 
  @ApiModelProperty(required = true, value = "Sensor type id (naturalId)")
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


  public SensorValueDtoV1 stationId(Long stationId) {
    
    this.stationId = stationId;
    return this;
  }

   /**
   * Get stationId
   * @return stationId
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getStationId() {
    return stationId;
  }


  @JsonProperty(JSON_PROPERTY_STATION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStationId(Long stationId) {
    this.stationId = stationId;
  }


  public SensorValueDtoV1 name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Sensor name
   * @return name
  **/
 
  @ApiModelProperty(required = true, value = "Sensor name")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }


  public SensorValueDtoV1 shortName(String shortName) {
    
    this.shortName = shortName;
    return this;
  }

   /**
   * Sensor short name
   * @return shortName
  **/
 
  @ApiModelProperty(required = true, value = "Sensor short name")
  @JsonProperty(JSON_PROPERTY_SHORT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getShortName() {
    return shortName;
  }


  @JsonProperty(JSON_PROPERTY_SHORT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }


  public SensorValueDtoV1 timeWindowStart(OffsetDateTime timeWindowStart) {
    
    this.timeWindowStart = timeWindowStart;
    return this;
  }

   /**
   * Measurement time window start time (only for fixed time window sensors)
   * @return timeWindowStart
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Measurement time window start time (only for fixed time window sensors)")
  @JsonProperty(JSON_PROPERTY_TIME_WINDOW_START)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getTimeWindowStart() {
    return timeWindowStart;
  }


  @JsonProperty(JSON_PROPERTY_TIME_WINDOW_START)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimeWindowStart(OffsetDateTime timeWindowStart) {
    this.timeWindowStart = timeWindowStart;
  }


  public SensorValueDtoV1 timeWindowEnd(OffsetDateTime timeWindowEnd) {
    
    this.timeWindowEnd = timeWindowEnd;
    return this;
  }

   /**
   * Measurement time window end time (only for fixed time window sensors)
   * @return timeWindowEnd
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Measurement time window end time (only for fixed time window sensors)")
  @JsonProperty(JSON_PROPERTY_TIME_WINDOW_END)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getTimeWindowEnd() {
    return timeWindowEnd;
  }


  @JsonProperty(JSON_PROPERTY_TIME_WINDOW_END)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimeWindowEnd(OffsetDateTime timeWindowEnd) {
    this.timeWindowEnd = timeWindowEnd;
  }


  public SensorValueDtoV1 measuredTime(OffsetDateTime measuredTime) {
    
    this.measuredTime = measuredTime;
    return this;
  }

   /**
   * Measurement time
   * @return measuredTime
  **/
 
  @ApiModelProperty(required = true, value = "Measurement time")
  @JsonProperty(JSON_PROPERTY_MEASURED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getMeasuredTime() {
    return measuredTime;
  }


  @JsonProperty(JSON_PROPERTY_MEASURED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMeasuredTime(OffsetDateTime measuredTime) {
    this.measuredTime = measuredTime;
  }


  public SensorValueDtoV1 sensorValueDescriptionFi(String sensorValueDescriptionFi) {
    
    this.sensorValueDescriptionFi = sensorValueDescriptionFi;
    return this;
  }

   /**
   * Additional information of sensor value [fi]
   * @return sensorValueDescriptionFi
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Additional information of sensor value [fi]")
  @JsonProperty(JSON_PROPERTY_SENSOR_VALUE_DESCRIPTION_FI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSensorValueDescriptionFi() {
    return sensorValueDescriptionFi;
  }


  @JsonProperty(JSON_PROPERTY_SENSOR_VALUE_DESCRIPTION_FI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSensorValueDescriptionFi(String sensorValueDescriptionFi) {
    this.sensorValueDescriptionFi = sensorValueDescriptionFi;
  }


  public SensorValueDtoV1 sensorValueDescriptionEn(String sensorValueDescriptionEn) {
    
    this.sensorValueDescriptionEn = sensorValueDescriptionEn;
    return this;
  }

   /**
   * Additional information of sensor value [en]
   * @return sensorValueDescriptionEn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Additional information of sensor value [en]")
  @JsonProperty(JSON_PROPERTY_SENSOR_VALUE_DESCRIPTION_EN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSensorValueDescriptionEn() {
    return sensorValueDescriptionEn;
  }


  @JsonProperty(JSON_PROPERTY_SENSOR_VALUE_DESCRIPTION_EN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSensorValueDescriptionEn(String sensorValueDescriptionEn) {
    this.sensorValueDescriptionEn = sensorValueDescriptionEn;
  }


  public SensorValueDtoV1 unit(String unit) {
    
    this.unit = unit;
    return this;
  }

   /**
   * Measured sensor value unit
   * @return unit
  **/
 
  @ApiModelProperty(required = true, value = "Measured sensor value unit")
  @JsonProperty(JSON_PROPERTY_UNIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUnit() {
    return unit;
  }


  @JsonProperty(JSON_PROPERTY_UNIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUnit(String unit) {
    this.unit = unit;
  }


  public SensorValueDtoV1 value(Double value) {
    
    this.value = value;
    return this;
  }

   /**
   * Measured sensor value
   * @return value
  **/
 
  @ApiModelProperty(required = true, value = "Measured sensor value")
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Double getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValue(Double value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SensorValueDtoV1 sensorValueDtoV1 = (SensorValueDtoV1) o;
    return Objects.equals(this.id, sensorValueDtoV1.id) &&
        Objects.equals(this.stationId, sensorValueDtoV1.stationId) &&
        Objects.equals(this.name, sensorValueDtoV1.name) &&
        Objects.equals(this.shortName, sensorValueDtoV1.shortName) &&
        Objects.equals(this.timeWindowStart, sensorValueDtoV1.timeWindowStart) &&
        Objects.equals(this.timeWindowEnd, sensorValueDtoV1.timeWindowEnd) &&
        Objects.equals(this.measuredTime, sensorValueDtoV1.measuredTime) &&
        Objects.equals(this.sensorValueDescriptionFi, sensorValueDtoV1.sensorValueDescriptionFi) &&
        Objects.equals(this.sensorValueDescriptionEn, sensorValueDtoV1.sensorValueDescriptionEn) &&
        Objects.equals(this.unit, sensorValueDtoV1.unit) &&
        Objects.equals(this.value, sensorValueDtoV1.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, stationId, name, shortName, timeWindowStart, timeWindowEnd, measuredTime, sensorValueDescriptionFi, sensorValueDescriptionEn, unit, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SensorValueDtoV1 {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    shortName: ").append(toIndentedString(shortName)).append("\n");
    sb.append("    timeWindowStart: ").append(toIndentedString(timeWindowStart)).append("\n");
    sb.append("    timeWindowEnd: ").append(toIndentedString(timeWindowEnd)).append("\n");
    sb.append("    measuredTime: ").append(toIndentedString(measuredTime)).append("\n");
    sb.append("    sensorValueDescriptionFi: ").append(toIndentedString(sensorValueDescriptionFi)).append("\n");
    sb.append("    sensorValueDescriptionEn: ").append(toIndentedString(sensorValueDescriptionEn)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

