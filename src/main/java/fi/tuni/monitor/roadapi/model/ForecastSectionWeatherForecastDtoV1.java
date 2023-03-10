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
import fi.tuni.monitor.roadapi.model.ForecastConditionReasonDtoV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Forecast section&#39;s weather forecast
 */
@ApiModel(description = "Forecast section's weather forecast")
@JsonPropertyOrder({
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_TIME,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_TYPE,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_FORECAST_NAME,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_DAYLIGHT,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_ROAD_TEMPERATURE,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_TEMPERATURE,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_WIND_SPEED,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_WIND_DIRECTION,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_OVERALL_ROAD_CONDITION,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_WEATHER_SYMBOL,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_RELIABILITY,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_FORECAST_CONDITION_REASON,
  ForecastSectionWeatherForecastDtoV1.JSON_PROPERTY_DATA_UPDATED_TIME
})
public class ForecastSectionWeatherForecastDtoV1 {
  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  /**
   * Tells if object is an observation or a forecast. (OBSERVATION, FORECAST)
   */
  public enum TypeEnum {
    OBSERVATION("OBSERVATION"),
    
    FORECAST("FORECAST");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public static final String JSON_PROPERTY_FORECAST_NAME = "forecastName";
  private String forecastName;

  public static final String JSON_PROPERTY_DAYLIGHT = "daylight";
  private Boolean daylight;

  public static final String JSON_PROPERTY_ROAD_TEMPERATURE = "roadTemperature";
  private Double roadTemperature;

  public static final String JSON_PROPERTY_TEMPERATURE = "temperature";
  private Double temperature;

  public static final String JSON_PROPERTY_WIND_SPEED = "windSpeed";
  private Double windSpeed;

  public static final String JSON_PROPERTY_WIND_DIRECTION = "windDirection";
  private Integer windDirection;

  /**
   * Overall road condition
   */
  public enum OverallRoadConditionEnum {
    NORMAL_CONDITION("NORMAL_CONDITION"),
    
    POOR_CONDITION("POOR_CONDITION"),
    
    EXTREMELY_POOR_CONDITION("EXTREMELY_POOR_CONDITION"),
    
    CONDITION_COULD_NOT_BE_RESOLVED("CONDITION_COULD_NOT_BE_RESOLVED");

    private String value;

    OverallRoadConditionEnum(String value) {
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
    public static OverallRoadConditionEnum fromValue(String value) {
      for (OverallRoadConditionEnum b : OverallRoadConditionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_OVERALL_ROAD_CONDITION = "overallRoadCondition";
  private OverallRoadConditionEnum overallRoadCondition;

  public static final String JSON_PROPERTY_WEATHER_SYMBOL = "weatherSymbol";
  private String weatherSymbol;

  /**
   * Forecast reliability
   */
  public enum ReliabilityEnum {
    SUCCESSFUL("SUCCESSFUL"),
    
    NO_DATA_FROM_ROADSTATION("NO_DATA_FROM_ROADSTATION"),
    
    FAILED("FAILED");

    private String value;

    ReliabilityEnum(String value) {
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
    public static ReliabilityEnum fromValue(String value) {
      for (ReliabilityEnum b : ReliabilityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_RELIABILITY = "reliability";
  private ReliabilityEnum reliability;

  public static final String JSON_PROPERTY_FORECAST_CONDITION_REASON = "forecastConditionReason";
  private ForecastConditionReasonDtoV1 forecastConditionReason;

  public static final String JSON_PROPERTY_DATA_UPDATED_TIME = "dataUpdatedTime";
  private OffsetDateTime dataUpdatedTime;

  public ForecastSectionWeatherForecastDtoV1() {
  }

  public ForecastSectionWeatherForecastDtoV1 time(OffsetDateTime time) {
    
    this.time = time;
    return this;
  }

   /**
   * Observation or forecast time depending on type
   * @return time
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Observation or forecast time depending on type")
  @JsonProperty(JSON_PROPERTY_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getTime() {
    return time;
  }


  @JsonProperty(JSON_PROPERTY_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTime(OffsetDateTime time) {
    this.time = time;
  }


  public ForecastSectionWeatherForecastDtoV1 type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Tells if object is an observation or a forecast. (OBSERVATION, FORECAST)
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Tells if object is an observation or a forecast. (OBSERVATION, FORECAST)")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TypeEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  public ForecastSectionWeatherForecastDtoV1 forecastName(String forecastName) {
    
    this.forecastName = forecastName;
    return this;
  }

   /**
   * Name of the forecast
   * @return forecastName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of the forecast")
  @JsonProperty(JSON_PROPERTY_FORECAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getForecastName() {
    return forecastName;
  }


  @JsonProperty(JSON_PROPERTY_FORECAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setForecastName(String forecastName) {
    this.forecastName = forecastName;
  }


  public ForecastSectionWeatherForecastDtoV1 daylight(Boolean daylight) {
    
    this.daylight = daylight;
    return this;
  }

   /**
   * Tells if there is daylight: true/false
   * @return daylight
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Tells if there is daylight: true/false")
  @JsonProperty(JSON_PROPERTY_DAYLIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getDaylight() {
    return daylight;
  }


  @JsonProperty(JSON_PROPERTY_DAYLIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDaylight(Boolean daylight) {
    this.daylight = daylight;
  }


  public ForecastSectionWeatherForecastDtoV1 roadTemperature(Double roadTemperature) {
    
    this.roadTemperature = roadTemperature;
    return this;
  }

   /**
   * Road temperature at given time. If not available value is not set
   * @return roadTemperature
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Road temperature at given time. If not available value is not set")
  @JsonProperty(JSON_PROPERTY_ROAD_TEMPERATURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getRoadTemperature() {
    return roadTemperature;
  }


  @JsonProperty(JSON_PROPERTY_ROAD_TEMPERATURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoadTemperature(Double roadTemperature) {
    this.roadTemperature = roadTemperature;
  }


  public ForecastSectionWeatherForecastDtoV1 temperature(Double temperature) {
    
    this.temperature = temperature;
    return this;
  }

   /**
   * Air temperature
   * @return temperature
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Air temperature")
  @JsonProperty(JSON_PROPERTY_TEMPERATURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getTemperature() {
    return temperature;
  }


  @JsonProperty(JSON_PROPERTY_TEMPERATURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }


  public ForecastSectionWeatherForecastDtoV1 windSpeed(Double windSpeed) {
    
    this.windSpeed = windSpeed;
    return this;
  }

   /**
   * Wind speed in m/s
   * @return windSpeed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Wind speed in m/s")
  @JsonProperty(JSON_PROPERTY_WIND_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getWindSpeed() {
    return windSpeed;
  }


  @JsonProperty(JSON_PROPERTY_WIND_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWindSpeed(Double windSpeed) {
    this.windSpeed = windSpeed;
  }


  public ForecastSectionWeatherForecastDtoV1 windDirection(Integer windDirection) {
    
    this.windDirection = windDirection;
    return this;
  }

   /**
   * Wind direction in degrees. 0 when there is no wind or the direction is variable. 90 degrees is arrow to the east (count clockwise)
   * @return windDirection
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Wind direction in degrees. 0 when there is no wind or the direction is variable. 90 degrees is arrow to the east (count clockwise)")
  @JsonProperty(JSON_PROPERTY_WIND_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getWindDirection() {
    return windDirection;
  }


  @JsonProperty(JSON_PROPERTY_WIND_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWindDirection(Integer windDirection) {
    this.windDirection = windDirection;
  }


  public ForecastSectionWeatherForecastDtoV1 overallRoadCondition(OverallRoadConditionEnum overallRoadCondition) {
    
    this.overallRoadCondition = overallRoadCondition;
    return this;
  }

   /**
   * Overall road condition
   * @return overallRoadCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Overall road condition")
  @JsonProperty(JSON_PROPERTY_OVERALL_ROAD_CONDITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OverallRoadConditionEnum getOverallRoadCondition() {
    return overallRoadCondition;
  }


  @JsonProperty(JSON_PROPERTY_OVERALL_ROAD_CONDITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOverallRoadCondition(OverallRoadConditionEnum overallRoadCondition) {
    this.overallRoadCondition = overallRoadCondition;
  }


  public ForecastSectionWeatherForecastDtoV1 weatherSymbol(String weatherSymbol) {
    
    this.weatherSymbol = weatherSymbol;
    return this;
  }

   /**
   * Weather symbol code. See corresponding symbols at https://www.vaisala.com/en/vaisala-weather-symbols. Symbols are allowed to be used in user&#39;s applications but any further modification and redistribution is denied.
   * @return weatherSymbol
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Weather symbol code. See corresponding symbols at https://www.vaisala.com/en/vaisala-weather-symbols. Symbols are allowed to be used in user's applications but any further modification and redistribution is denied.")
  @JsonProperty(JSON_PROPERTY_WEATHER_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getWeatherSymbol() {
    return weatherSymbol;
  }


  @JsonProperty(JSON_PROPERTY_WEATHER_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWeatherSymbol(String weatherSymbol) {
    this.weatherSymbol = weatherSymbol;
  }


  public ForecastSectionWeatherForecastDtoV1 reliability(ReliabilityEnum reliability) {
    
    this.reliability = reliability;
    return this;
  }

   /**
   * Forecast reliability
   * @return reliability
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Forecast reliability")
  @JsonProperty(JSON_PROPERTY_RELIABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ReliabilityEnum getReliability() {
    return reliability;
  }


  @JsonProperty(JSON_PROPERTY_RELIABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReliability(ReliabilityEnum reliability) {
    this.reliability = reliability;
  }


  public ForecastSectionWeatherForecastDtoV1 forecastConditionReason(ForecastConditionReasonDtoV1 forecastConditionReason) {
    
    this.forecastConditionReason = forecastConditionReason;
    return this;
  }

   /**
   * Get forecastConditionReason
   * @return forecastConditionReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FORECAST_CONDITION_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ForecastConditionReasonDtoV1 getForecastConditionReason() {
    return forecastConditionReason;
  }


  @JsonProperty(JSON_PROPERTY_FORECAST_CONDITION_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setForecastConditionReason(ForecastConditionReasonDtoV1 forecastConditionReason) {
    this.forecastConditionReason = forecastConditionReason;
  }


  public ForecastSectionWeatherForecastDtoV1 dataUpdatedTime(OffsetDateTime dataUpdatedTime) {
    
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ForecastSectionWeatherForecastDtoV1 forecastSectionWeatherForecastDtoV1 = (ForecastSectionWeatherForecastDtoV1) o;
    return Objects.equals(this.time, forecastSectionWeatherForecastDtoV1.time) &&
        Objects.equals(this.type, forecastSectionWeatherForecastDtoV1.type) &&
        Objects.equals(this.forecastName, forecastSectionWeatherForecastDtoV1.forecastName) &&
        Objects.equals(this.daylight, forecastSectionWeatherForecastDtoV1.daylight) &&
        Objects.equals(this.roadTemperature, forecastSectionWeatherForecastDtoV1.roadTemperature) &&
        Objects.equals(this.temperature, forecastSectionWeatherForecastDtoV1.temperature) &&
        Objects.equals(this.windSpeed, forecastSectionWeatherForecastDtoV1.windSpeed) &&
        Objects.equals(this.windDirection, forecastSectionWeatherForecastDtoV1.windDirection) &&
        Objects.equals(this.overallRoadCondition, forecastSectionWeatherForecastDtoV1.overallRoadCondition) &&
        Objects.equals(this.weatherSymbol, forecastSectionWeatherForecastDtoV1.weatherSymbol) &&
        Objects.equals(this.reliability, forecastSectionWeatherForecastDtoV1.reliability) &&
        Objects.equals(this.forecastConditionReason, forecastSectionWeatherForecastDtoV1.forecastConditionReason) &&
        Objects.equals(this.dataUpdatedTime, forecastSectionWeatherForecastDtoV1.dataUpdatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, type, forecastName, daylight, roadTemperature, temperature, windSpeed, windDirection, overallRoadCondition, weatherSymbol, reliability, forecastConditionReason, dataUpdatedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForecastSectionWeatherForecastDtoV1 {\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    forecastName: ").append(toIndentedString(forecastName)).append("\n");
    sb.append("    daylight: ").append(toIndentedString(daylight)).append("\n");
    sb.append("    roadTemperature: ").append(toIndentedString(roadTemperature)).append("\n");
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    windSpeed: ").append(toIndentedString(windSpeed)).append("\n");
    sb.append("    windDirection: ").append(toIndentedString(windDirection)).append("\n");
    sb.append("    overallRoadCondition: ").append(toIndentedString(overallRoadCondition)).append("\n");
    sb.append("    weatherSymbol: ").append(toIndentedString(weatherSymbol)).append("\n");
    sb.append("    reliability: ").append(toIndentedString(reliability)).append("\n");
    sb.append("    forecastConditionReason: ").append(toIndentedString(forecastConditionReason)).append("\n");
    sb.append("    dataUpdatedTime: ").append(toIndentedString(dataUpdatedTime)).append("\n");
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

