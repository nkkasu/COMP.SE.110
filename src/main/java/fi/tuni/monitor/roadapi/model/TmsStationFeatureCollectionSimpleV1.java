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
import fi.tuni.monitor.roadapi.model.TmsStationFeatureSimpleV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * GeoJSON feature collection of TMS stations
 */
@ApiModel(description = "GeoJSON feature collection of TMS stations")
@JsonPropertyOrder({
  TmsStationFeatureCollectionSimpleV1.JSON_PROPERTY_TYPE,
  TmsStationFeatureCollectionSimpleV1.JSON_PROPERTY_DATA_UPDATED_TIME,
  TmsStationFeatureCollectionSimpleV1.JSON_PROPERTY_FEATURES
})
public class TmsStationFeatureCollectionSimpleV1 {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_DATA_UPDATED_TIME = "dataUpdatedTime";
  private OffsetDateTime dataUpdatedTime;

  public static final String JSON_PROPERTY_FEATURES = "features";
  private List<TmsStationFeatureSimpleV1> features = new ArrayList<>();

  public TmsStationFeatureCollectionSimpleV1() {
  }

  public TmsStationFeatureCollectionSimpleV1 type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * GeoJSON Object Type
   * @return type
  **/
 
  @ApiModelProperty(required = true, value = "GeoJSON Object Type")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
  }


  public TmsStationFeatureCollectionSimpleV1 dataUpdatedTime(OffsetDateTime dataUpdatedTime) {
    
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


  public TmsStationFeatureCollectionSimpleV1 features(List<TmsStationFeatureSimpleV1> features) {
    
    this.features = features;
    return this;
  }

  public TmsStationFeatureCollectionSimpleV1 addFeaturesItem(TmsStationFeatureSimpleV1 featuresItem) {
    this.features.add(featuresItem);
    return this;
  }

   /**
   * GeoJSON Feature Objects
   * @return features
  **/
 
  @ApiModelProperty(required = true, value = "GeoJSON Feature Objects")
  @JsonProperty(JSON_PROPERTY_FEATURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<TmsStationFeatureSimpleV1> getFeatures() {
    return features;
  }


  @JsonProperty(JSON_PROPERTY_FEATURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFeatures(List<TmsStationFeatureSimpleV1> features) {
    this.features = features;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TmsStationFeatureCollectionSimpleV1 tmsStationFeatureCollectionSimpleV1 = (TmsStationFeatureCollectionSimpleV1) o;
    return Objects.equals(this.type, tmsStationFeatureCollectionSimpleV1.type) &&
        Objects.equals(this.dataUpdatedTime, tmsStationFeatureCollectionSimpleV1.dataUpdatedTime) &&
        Objects.equals(this.features, tmsStationFeatureCollectionSimpleV1.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, dataUpdatedTime, features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TmsStationFeatureCollectionSimpleV1 {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    dataUpdatedTime: ").append(toIndentedString(dataUpdatedTime)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
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

