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
import fi.tuni.monitor.roadapi.model.ForecastSectionFeatureCollectionOldV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Weather forecast sections
 */
@ApiModel(description = "Weather forecast sections")
@JsonPropertyOrder({
  ForecastSectionsMetadata.JSON_PROPERTY_DATA_UPDATED_TIME,
  ForecastSectionsMetadata.JSON_PROPERTY_DATA_LAST_CHECKED_TIME,
  ForecastSectionsMetadata.JSON_PROPERTY_FORECAST_SECTIONS
})
public class ForecastSectionsMetadata {
  public static final String JSON_PROPERTY_DATA_UPDATED_TIME = "dataUpdatedTime";
  private OffsetDateTime dataUpdatedTime;

  public static final String JSON_PROPERTY_DATA_LAST_CHECKED_TIME = "dataLastCheckedTime";
  private OffsetDateTime dataLastCheckedTime;

  public static final String JSON_PROPERTY_FORECAST_SECTIONS = "forecastSections";
  private ForecastSectionFeatureCollectionOldV1 forecastSections;

  public ForecastSectionsMetadata() {
  }

  public ForecastSectionsMetadata dataUpdatedTime(OffsetDateTime dataUpdatedTime) {
    
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


  public ForecastSectionsMetadata dataLastCheckedTime(OffsetDateTime dataLastCheckedTime) {
    
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


  public ForecastSectionsMetadata forecastSections(ForecastSectionFeatureCollectionOldV1 forecastSections) {
    
    this.forecastSections = forecastSections;
    return this;
  }

   /**
   * Get forecastSections
   * @return forecastSections
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FORECAST_SECTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ForecastSectionFeatureCollectionOldV1 getForecastSections() {
    return forecastSections;
  }


  @JsonProperty(JSON_PROPERTY_FORECAST_SECTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setForecastSections(ForecastSectionFeatureCollectionOldV1 forecastSections) {
    this.forecastSections = forecastSections;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ForecastSectionsMetadata forecastSectionsMetadata = (ForecastSectionsMetadata) o;
    return Objects.equals(this.dataUpdatedTime, forecastSectionsMetadata.dataUpdatedTime) &&
        Objects.equals(this.dataLastCheckedTime, forecastSectionsMetadata.dataLastCheckedTime) &&
        Objects.equals(this.forecastSections, forecastSectionsMetadata.forecastSections);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataUpdatedTime, dataLastCheckedTime, forecastSections);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForecastSectionsMetadata {\n");
    sb.append("    dataUpdatedTime: ").append(toIndentedString(dataUpdatedTime)).append("\n");
    sb.append("    dataLastCheckedTime: ").append(toIndentedString(dataLastCheckedTime)).append("\n");
    sb.append("    forecastSections: ").append(toIndentedString(forecastSections)).append("\n");
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

