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
import fi.tuni.monitor.roadapi.model.SensorValueDescription;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Weather road station sensor
 */
@ApiModel(description = "Weather road station sensor")
@JsonPropertyOrder({
  WeatherRoadStationSensor.JSON_PROPERTY_ID,
  WeatherRoadStationSensor.JSON_PROPERTY_NAME,
  WeatherRoadStationSensor.JSON_PROPERTY_SHORT_NAME,
  WeatherRoadStationSensor.JSON_PROPERTY_UNIT,
  WeatherRoadStationSensor.JSON_PROPERTY_ACCURACY,
  WeatherRoadStationSensor.JSON_PROPERTY_NAME_OLD,
  WeatherRoadStationSensor.JSON_PROPERTY_SENSOR_VALUE_DESCRIPTIONS,
  WeatherRoadStationSensor.JSON_PROPERTY_DESCRIPTIONS,
  WeatherRoadStationSensor.JSON_PROPERTY_PRESENTATION_NAMES,
  WeatherRoadStationSensor.JSON_PROPERTY_DESCRIPTION
})
public class WeatherRoadStationSensor {
  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_SHORT_NAME = "shortName";
  private String shortName;

  public static final String JSON_PROPERTY_UNIT = "unit";
  private String unit;

  public static final String JSON_PROPERTY_ACCURACY = "accuracy";
  private Integer accuracy;

  public static final String JSON_PROPERTY_NAME_OLD = "nameOld";
  private String nameOld;

  public static final String JSON_PROPERTY_SENSOR_VALUE_DESCRIPTIONS = "sensorValueDescriptions";
  private List<SensorValueDescription> sensorValueDescriptions = null;

  public static final String JSON_PROPERTY_DESCRIPTIONS = "descriptions";
  private Map<String, String> descriptions = null;

  public static final String JSON_PROPERTY_PRESENTATION_NAMES = "presentationNames";
  private Map<String, String> presentationNames = null;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public WeatherRoadStationSensor() {
  }

  public WeatherRoadStationSensor id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * Sensor id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Sensor id")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(Long id) {
    this.id = id;
  }


  public WeatherRoadStationSensor name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Sensor name [fi]
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Sensor name [fi]")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public WeatherRoadStationSensor shortName(String shortName) {
    
    this.shortName = shortName;
    return this;
  }

   /**
   * Short name for sensor [fi]
   * @return shortName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Short name for sensor [fi]")
  @JsonProperty(JSON_PROPERTY_SHORT_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getShortName() {
    return shortName;
  }


  @JsonProperty(JSON_PROPERTY_SHORT_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }


  public WeatherRoadStationSensor unit(String unit) {
    
    this.unit = unit;
    return this;
  }

   /**
   * Unit of sensor value
   * @return unit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Unit of sensor value")
  @JsonProperty(JSON_PROPERTY_UNIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUnit() {
    return unit;
  }


  @JsonProperty(JSON_PROPERTY_UNIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUnit(String unit) {
    this.unit = unit;
  }


  public WeatherRoadStationSensor accuracy(Integer accuracy) {
    
    this.accuracy = accuracy;
    return this;
  }

   /**
   * Sensor accuracy
   * @return accuracy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Sensor accuracy")
  @JsonProperty(JSON_PROPERTY_ACCURACY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAccuracy() {
    return accuracy;
  }


  @JsonProperty(JSON_PROPERTY_ACCURACY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccuracy(Integer accuracy) {
    this.accuracy = accuracy;
  }


  public WeatherRoadStationSensor nameOld(String nameOld) {
    
    this.nameOld = nameOld;
    return this;
  }

   /**
   * Sensor old name. For new sensors will equal name. Will deprecate in future.
   * @return nameOld
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Sensor old name. For new sensors will equal name. Will deprecate in future.")
  @JsonProperty(JSON_PROPERTY_NAME_OLD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNameOld() {
    return nameOld;
  }


  @JsonProperty(JSON_PROPERTY_NAME_OLD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNameOld(String nameOld) {
    this.nameOld = nameOld;
  }


  public WeatherRoadStationSensor sensorValueDescriptions(List<SensorValueDescription> sensorValueDescriptions) {
    
    this.sensorValueDescriptions = sensorValueDescriptions;
    return this;
  }

  public WeatherRoadStationSensor addSensorValueDescriptionsItem(SensorValueDescription sensorValueDescriptionsItem) {
    if (this.sensorValueDescriptions == null) {
      this.sensorValueDescriptions = new ArrayList<>();
    }
    this.sensorValueDescriptions.add(sensorValueDescriptionsItem);
    return this;
  }

   /**
   * Possible additional descriptions for sensor values
   * @return sensorValueDescriptions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Possible additional descriptions for sensor values")
  @JsonProperty(JSON_PROPERTY_SENSOR_VALUE_DESCRIPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SensorValueDescription> getSensorValueDescriptions() {
    return sensorValueDescriptions;
  }


  @JsonProperty(JSON_PROPERTY_SENSOR_VALUE_DESCRIPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSensorValueDescriptions(List<SensorValueDescription> sensorValueDescriptions) {
    this.sensorValueDescriptions = sensorValueDescriptions;
  }


  public WeatherRoadStationSensor descriptions(Map<String, String> descriptions) {
    
    this.descriptions = descriptions;
    return this;
  }

  public WeatherRoadStationSensor putDescriptionsItem(String key, String descriptionsItem) {
    if (this.descriptions == null) {
      this.descriptions = new HashMap<>();
    }
    this.descriptions.put(key, descriptionsItem);
    return this;
  }

   /**
   * Map of descriptions [fi, sv, en]
   * @return descriptions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Map of descriptions [fi, sv, en]")
  @JsonProperty(JSON_PROPERTY_DESCRIPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getDescriptions() {
    return descriptions;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescriptions(Map<String, String> descriptions) {
    this.descriptions = descriptions;
  }


  public WeatherRoadStationSensor presentationNames(Map<String, String> presentationNames) {
    
    this.presentationNames = presentationNames;
    return this;
  }

  public WeatherRoadStationSensor putPresentationNamesItem(String key, String presentationNamesItem) {
    if (this.presentationNames == null) {
      this.presentationNames = new HashMap<>();
    }
    this.presentationNames.put(key, presentationNamesItem);
    return this;
  }

   /**
   * Map of presentation names [fi, sv, en]
   * @return presentationNames
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Map of presentation names [fi, sv, en]")
  @JsonProperty(JSON_PROPERTY_PRESENTATION_NAMES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getPresentationNames() {
    return presentationNames;
  }


  @JsonProperty(JSON_PROPERTY_PRESENTATION_NAMES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPresentationNames(Map<String, String> presentationNames) {
    this.presentationNames = presentationNames;
  }


  public WeatherRoadStationSensor description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Sensor description [fi]
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Sensor description [fi]")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeatherRoadStationSensor weatherRoadStationSensor = (WeatherRoadStationSensor) o;
    return Objects.equals(this.id, weatherRoadStationSensor.id) &&
        Objects.equals(this.name, weatherRoadStationSensor.name) &&
        Objects.equals(this.shortName, weatherRoadStationSensor.shortName) &&
        Objects.equals(this.unit, weatherRoadStationSensor.unit) &&
        Objects.equals(this.accuracy, weatherRoadStationSensor.accuracy) &&
        Objects.equals(this.nameOld, weatherRoadStationSensor.nameOld) &&
        Objects.equals(this.sensorValueDescriptions, weatherRoadStationSensor.sensorValueDescriptions) &&
        Objects.equals(this.descriptions, weatherRoadStationSensor.descriptions) &&
        Objects.equals(this.presentationNames, weatherRoadStationSensor.presentationNames) &&
        Objects.equals(this.description, weatherRoadStationSensor.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, shortName, unit, accuracy, nameOld, sensorValueDescriptions, descriptions, presentationNames, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeatherRoadStationSensor {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    shortName: ").append(toIndentedString(shortName)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    accuracy: ").append(toIndentedString(accuracy)).append("\n");
    sb.append("    nameOld: ").append(toIndentedString(nameOld)).append("\n");
    sb.append("    sensorValueDescriptions: ").append(toIndentedString(sensorValueDescriptions)).append("\n");
    sb.append("    descriptions: ").append(toIndentedString(descriptions)).append("\n");
    sb.append("    presentationNames: ").append(toIndentedString(presentationNames)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

