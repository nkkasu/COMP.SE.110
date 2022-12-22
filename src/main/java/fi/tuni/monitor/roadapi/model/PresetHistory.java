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
import fi.tuni.monitor.roadapi.model.PresetHistoryData;
import fi.tuni.monitor.roadapi.model.WeathercamPresetHistoryDtoV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Weather camera preset&#39;s image history.
 */
@ApiModel(description = "Weather camera preset's image history.")
@JsonPropertyOrder({
  PresetHistory.JSON_PROPERTY_PRESET_ID,
  PresetHistory.JSON_PROPERTY_PRESET_HISTORY,
  PresetHistory.JSON_PROPERTY_ID,
  PresetHistory.JSON_PROPERTY_DATA_UPDATED_TIME,
  PresetHistory.JSON_PROPERTY_PRESETS
})
public class PresetHistory {
  public static final String JSON_PROPERTY_PRESET_ID = "presetId";
  private String presetId;

  public static final String JSON_PROPERTY_PRESET_HISTORY = "presetHistory";
  private List<PresetHistoryData> presetHistory = null;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_DATA_UPDATED_TIME = "dataUpdatedTime";
  private OffsetDateTime dataUpdatedTime;

  public static final String JSON_PROPERTY_PRESETS = "presets";
  private List<WeathercamPresetHistoryDtoV1> presets = new ArrayList<>();

  public PresetHistory() {
  }

  public PresetHistory presetId(String presetId) {
    
    this.presetId = presetId;
    return this;
  }

   /**
   * Preset id
   * @return presetId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Preset id")
  @JsonProperty(JSON_PROPERTY_PRESET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPresetId() {
    return presetId;
  }


  @JsonProperty(JSON_PROPERTY_PRESET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPresetId(String presetId) {
    this.presetId = presetId;
  }


  public PresetHistory presetHistory(List<PresetHistoryData> presetHistory) {
    
    this.presetHistory = presetHistory;
    return this;
  }

  public PresetHistory addPresetHistoryItem(PresetHistoryData presetHistoryItem) {
    if (this.presetHistory == null) {
      this.presetHistory = new ArrayList<>();
    }
    this.presetHistory.add(presetHistoryItem);
    return this;
  }

   /**
   * Preset history
   * @return presetHistory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Preset history")
  @JsonProperty(JSON_PROPERTY_PRESET_HISTORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PresetHistoryData> getPresetHistory() {
    return presetHistory;
  }


  @JsonProperty(JSON_PROPERTY_PRESET_HISTORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPresetHistory(List<PresetHistoryData> presetHistory) {
    this.presetHistory = presetHistory;
  }


  public PresetHistory id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Id of the road station
   * @return id
  **/
 
  @ApiModelProperty(required = true, value = "Id of the road station")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public PresetHistory dataUpdatedTime(OffsetDateTime dataUpdatedTime) {
    
    this.dataUpdatedTime = dataUpdatedTime;
    return this;
  }

   /**
   * Time when data was last updated
   * @return dataUpdatedTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Time when data was last updated")
  @JsonProperty(JSON_PROPERTY_DATA_UPDATED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDataUpdatedTime() {
    return dataUpdatedTime;
  }


  @JsonProperty(JSON_PROPERTY_DATA_UPDATED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDataUpdatedTime(OffsetDateTime dataUpdatedTime) {
    this.dataUpdatedTime = dataUpdatedTime;
  }


  public PresetHistory presets(List<WeathercamPresetHistoryDtoV1> presets) {
    
    this.presets = presets;
    return this;
  }

  public PresetHistory addPresetsItem(WeathercamPresetHistoryDtoV1 presetsItem) {
    this.presets.add(presetsItem);
    return this;
  }

   /**
   * Weathercam presets histories
   * @return presets
  **/
 
  @ApiModelProperty(required = true, value = "Weathercam presets histories")
  @JsonProperty(JSON_PROPERTY_PRESETS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<WeathercamPresetHistoryDtoV1> getPresets() {
    return presets;
  }


  @JsonProperty(JSON_PROPERTY_PRESETS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPresets(List<WeathercamPresetHistoryDtoV1> presets) {
    this.presets = presets;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PresetHistory presetHistory = (PresetHistory) o;
    return Objects.equals(this.presetId, presetHistory.presetId) &&
        Objects.equals(this.presetHistory, presetHistory.presetHistory) &&
        Objects.equals(this.id, presetHistory.id) &&
        Objects.equals(this.dataUpdatedTime, presetHistory.dataUpdatedTime) &&
        Objects.equals(this.presets, presetHistory.presets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(presetId, presetHistory, id, dataUpdatedTime, presets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PresetHistory {\n");
    sb.append("    presetId: ").append(toIndentedString(presetId)).append("\n");
    sb.append("    presetHistory: ").append(toIndentedString(presetHistory)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dataUpdatedTime: ").append(toIndentedString(dataUpdatedTime)).append("\n");
    sb.append("    presets: ").append(toIndentedString(presets)).append("\n");
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
