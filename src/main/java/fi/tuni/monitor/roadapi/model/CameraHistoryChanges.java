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
import fi.tuni.monitor.roadapi.model.PresetHistoryChange;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Weather cameras history changes.
 */
@ApiModel(description = "Weather cameras history changes.")
@JsonPropertyOrder({
  CameraHistoryChanges.JSON_PROPERTY_LATEST_CHANGE,
  CameraHistoryChanges.JSON_PROPERTY_CHANGES
})
public class CameraHistoryChanges {
  public static final String JSON_PROPERTY_LATEST_CHANGE = "latestChange";
  private OffsetDateTime latestChange;

  public static final String JSON_PROPERTY_CHANGES = "changes";
  private List<PresetHistoryChange> changes = null;

  public CameraHistoryChanges() {
  }

  public CameraHistoryChanges latestChange(OffsetDateTime latestChange) {
    
    this.latestChange = latestChange;
    return this;
  }

   /**
   * Latest history change time. Use this value as parameter for next query in api.
   * @return latestChange
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Latest history change time. Use this value as parameter for next query in api.")
  @JsonProperty(JSON_PROPERTY_LATEST_CHANGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getLatestChange() {
    return latestChange;
  }


  @JsonProperty(JSON_PROPERTY_LATEST_CHANGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLatestChange(OffsetDateTime latestChange) {
    this.latestChange = latestChange;
  }


  public CameraHistoryChanges changes(List<PresetHistoryChange> changes) {
    
    this.changes = changes;
    return this;
  }

  public CameraHistoryChanges addChangesItem(PresetHistoryChange changesItem) {
    if (this.changes == null) {
      this.changes = new ArrayList<>();
    }
    this.changes.add(changesItem);
    return this;
  }

   /**
   * Changes of weather camera history
   * @return changes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Changes of weather camera history")
  @JsonProperty(JSON_PROPERTY_CHANGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PresetHistoryChange> getChanges() {
    return changes;
  }


  @JsonProperty(JSON_PROPERTY_CHANGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChanges(List<PresetHistoryChange> changes) {
    this.changes = changes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CameraHistoryChanges cameraHistoryChanges = (CameraHistoryChanges) o;
    return Objects.equals(this.latestChange, cameraHistoryChanges.latestChange) &&
        Objects.equals(this.changes, cameraHistoryChanges.changes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latestChange, changes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CameraHistoryChanges {\n");
    sb.append("    latestChange: ").append(toIndentedString(latestChange)).append("\n");
    sb.append("    changes: ").append(toIndentedString(changes)).append("\n");
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

