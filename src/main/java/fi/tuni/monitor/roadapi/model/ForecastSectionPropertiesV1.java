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
import fi.tuni.monitor.roadapi.model.RoadSegmentDtoV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Forecast Section Properties
 */
@ApiModel(description = "Forecast Section Properties")
@JsonPropertyOrder({
  ForecastSectionPropertiesV1.JSON_PROPERTY_ID,
  ForecastSectionPropertiesV1.JSON_PROPERTY_DESCRIPTION,
  ForecastSectionPropertiesV1.JSON_PROPERTY_ROAD_SECTION_NUMBER,
  ForecastSectionPropertiesV1.JSON_PROPERTY_ROAD_NUMBER,
  ForecastSectionPropertiesV1.JSON_PROPERTY_LENGTH,
  ForecastSectionPropertiesV1.JSON_PROPERTY_ROAD_SEGMENTS,
  ForecastSectionPropertiesV1.JSON_PROPERTY_LINK_IDS,
  ForecastSectionPropertiesV1.JSON_PROPERTY_DATA_UPDATED_TIME
})
public class ForecastSectionPropertiesV1 {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_ROAD_SECTION_NUMBER = "roadSectionNumber";
  private Integer roadSectionNumber;

  public static final String JSON_PROPERTY_ROAD_NUMBER = "roadNumber";
  private Integer roadNumber;

  public static final String JSON_PROPERTY_LENGTH = "length";
  private Integer length;

  public static final String JSON_PROPERTY_ROAD_SEGMENTS = "roadSegments";
  private List<RoadSegmentDtoV1> roadSegments = null;

  public static final String JSON_PROPERTY_LINK_IDS = "linkIds";
  private List<Long> linkIds = null;

  public static final String JSON_PROPERTY_DATA_UPDATED_TIME = "dataUpdatedTime";
  private OffsetDateTime dataUpdatedTime;

  public ForecastSectionPropertiesV1() {
  }

  public ForecastSectionPropertiesV1 id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Forecast section identifier ie. 00004_342_01435_0_274.569:  1. Road number 5 characters ie. 00004,  2. Road section 3 characters ie. 342,  3. Start distance 5 characters ie. 000,  4. Carriageway 1 character,  5. Measure value of link start point. Varying number of characters ie. 274.569,  Refers to Digiroad content at https://aineistot.vayla.fi/digiroad/
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Forecast section identifier ie. 00004_342_01435_0_274.569:  1. Road number 5 characters ie. 00004,  2. Road section 3 characters ie. 342,  3. Start distance 5 characters ie. 000,  4. Carriageway 1 character,  5. Measure value of link start point. Varying number of characters ie. 274.569,  Refers to Digiroad content at https://aineistot.vayla.fi/digiroad/")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }


  public ForecastSectionPropertiesV1 description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Forecast section description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Forecast section description")
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


  public ForecastSectionPropertiesV1 roadSectionNumber(Integer roadSectionNumber) {
    
    this.roadSectionNumber = roadSectionNumber;
    return this;
  }

   /**
   * Road section number
   * @return roadSectionNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Road section number")
  @JsonProperty(JSON_PROPERTY_ROAD_SECTION_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRoadSectionNumber() {
    return roadSectionNumber;
  }


  @JsonProperty(JSON_PROPERTY_ROAD_SECTION_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoadSectionNumber(Integer roadSectionNumber) {
    this.roadSectionNumber = roadSectionNumber;
  }


  public ForecastSectionPropertiesV1 roadNumber(Integer roadNumber) {
    
    this.roadNumber = roadNumber;
    return this;
  }

   /**
   * Forecast section road number
   * @return roadNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Forecast section road number")
  @JsonProperty(JSON_PROPERTY_ROAD_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRoadNumber() {
    return roadNumber;
  }


  @JsonProperty(JSON_PROPERTY_ROAD_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoadNumber(Integer roadNumber) {
    this.roadNumber = roadNumber;
  }


  public ForecastSectionPropertiesV1 length(Integer length) {
    
    this.length = length;
    return this;
  }

   /**
   * Forecast section length in meters
   * @return length
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Forecast section length in meters")
  @JsonProperty(JSON_PROPERTY_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getLength() {
    return length;
  }


  @JsonProperty(JSON_PROPERTY_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLength(Integer length) {
    this.length = length;
  }


  public ForecastSectionPropertiesV1 roadSegments(List<RoadSegmentDtoV1> roadSegments) {
    
    this.roadSegments = roadSegments;
    return this;
  }

  public ForecastSectionPropertiesV1 addRoadSegmentsItem(RoadSegmentDtoV1 roadSegmentsItem) {
    if (this.roadSegments == null) {
      this.roadSegments = new ArrayList<>();
    }
    this.roadSegments.add(roadSegmentsItem);
    return this;
  }

   /**
   * Forecast section road segments. Refers to https://aineistot.vayla.fi/digiroad/
   * @return roadSegments
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Forecast section road segments. Refers to https://aineistot.vayla.fi/digiroad/")
  @JsonProperty(JSON_PROPERTY_ROAD_SEGMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<RoadSegmentDtoV1> getRoadSegments() {
    return roadSegments;
  }


  @JsonProperty(JSON_PROPERTY_ROAD_SEGMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoadSegments(List<RoadSegmentDtoV1> roadSegments) {
    this.roadSegments = roadSegments;
  }


  public ForecastSectionPropertiesV1 linkIds(List<Long> linkIds) {
    
    this.linkIds = linkIds;
    return this;
  }

  public ForecastSectionPropertiesV1 addLinkIdsItem(Long linkIdsItem) {
    if (this.linkIds == null) {
      this.linkIds = new ArrayList<>();
    }
    this.linkIds.add(linkIdsItem);
    return this;
  }

   /**
   * Forecast section link indices. Refers to https://aineistot.vayla.fi/digiroad/
   * @return linkIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Forecast section link indices. Refers to https://aineistot.vayla.fi/digiroad/")
  @JsonProperty(JSON_PROPERTY_LINK_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Long> getLinkIds() {
    return linkIds;
  }


  @JsonProperty(JSON_PROPERTY_LINK_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLinkIds(List<Long> linkIds) {
    this.linkIds = linkIds;
  }


  public ForecastSectionPropertiesV1 dataUpdatedTime(OffsetDateTime dataUpdatedTime) {
    
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
    ForecastSectionPropertiesV1 forecastSectionPropertiesV1 = (ForecastSectionPropertiesV1) o;
    return Objects.equals(this.id, forecastSectionPropertiesV1.id) &&
        Objects.equals(this.description, forecastSectionPropertiesV1.description) &&
        Objects.equals(this.roadSectionNumber, forecastSectionPropertiesV1.roadSectionNumber) &&
        Objects.equals(this.roadNumber, forecastSectionPropertiesV1.roadNumber) &&
        Objects.equals(this.length, forecastSectionPropertiesV1.length) &&
        Objects.equals(this.roadSegments, forecastSectionPropertiesV1.roadSegments) &&
        Objects.equals(this.linkIds, forecastSectionPropertiesV1.linkIds) &&
        Objects.equals(this.dataUpdatedTime, forecastSectionPropertiesV1.dataUpdatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, roadSectionNumber, roadNumber, length, roadSegments, linkIds, dataUpdatedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForecastSectionPropertiesV1 {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    roadSectionNumber: ").append(toIndentedString(roadSectionNumber)).append("\n");
    sb.append("    roadNumber: ").append(toIndentedString(roadNumber)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    roadSegments: ").append(toIndentedString(roadSegments)).append("\n");
    sb.append("    linkIds: ").append(toIndentedString(linkIds)).append("\n");
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

