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
 * Camera&#39;s preset data
 */
@ApiModel(description = "Camera's preset data")
@JsonPropertyOrder({
  CameraPresetData.JSON_PROPERTY_ID,
  CameraPresetData.JSON_PROPERTY_PRESENTATION_NAME,
  CameraPresetData.JSON_PROPERTY_IMAGE_URL,
  CameraPresetData.JSON_PROPERTY_MEASURED_TIME
})
public class CameraPresetData {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_PRESENTATION_NAME = "presentationName";
  private String presentationName;

  public static final String JSON_PROPERTY_IMAGE_URL = "imageUrl";
  private String imageUrl;

  public static final String JSON_PROPERTY_MEASURED_TIME = "measuredTime";
  private OffsetDateTime measuredTime;

  public CameraPresetData() {
  }

  public CameraPresetData id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Camera preset id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Camera preset id")
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


  public CameraPresetData presentationName(String presentationName) {
    
    this.presentationName = presentationName;
    return this;
  }

   /**
   * PresentationName (Preset name 1, direction)
   * @return presentationName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "PresentationName (Preset name 1, direction)")
  @JsonProperty(JSON_PROPERTY_PRESENTATION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPresentationName() {
    return presentationName;
  }


  @JsonProperty(JSON_PROPERTY_PRESENTATION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPresentationName(String presentationName) {
    this.presentationName = presentationName;
  }


  public CameraPresetData imageUrl(String imageUrl) {
    
    this.imageUrl = imageUrl;
    return this;
  }

   /**
   * Image url
   * @return imageUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Image url")
  @JsonProperty(JSON_PROPERTY_IMAGE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getImageUrl() {
    return imageUrl;
  }


  @JsonProperty(JSON_PROPERTY_IMAGE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  public CameraPresetData measuredTime(OffsetDateTime measuredTime) {
    
    this.measuredTime = measuredTime;
    return this;
  }

   /**
   * Value measured date time
   * @return measuredTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Value measured date time")
  @JsonProperty(JSON_PROPERTY_MEASURED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getMeasuredTime() {
    return measuredTime;
  }


  @JsonProperty(JSON_PROPERTY_MEASURED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMeasuredTime(OffsetDateTime measuredTime) {
    this.measuredTime = measuredTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CameraPresetData cameraPresetData = (CameraPresetData) o;
    return Objects.equals(this.id, cameraPresetData.id) &&
        Objects.equals(this.presentationName, cameraPresetData.presentationName) &&
        Objects.equals(this.imageUrl, cameraPresetData.imageUrl) &&
        Objects.equals(this.measuredTime, cameraPresetData.measuredTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, presentationName, imageUrl, measuredTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CameraPresetData {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    presentationName: ").append(toIndentedString(presentationName)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    measuredTime: ").append(toIndentedString(measuredTime)).append("\n");
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

