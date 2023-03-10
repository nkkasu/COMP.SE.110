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
import fi.tuni.monitor.roadapi.model.WeathercamPresetDirectionV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Weathercam preset object with detailed information
 */
@ApiModel(description = "Weathercam preset object with detailed information")
@JsonPropertyOrder({
  WeathercamPresetDetailedV1.JSON_PROPERTY_ID,
  WeathercamPresetDetailedV1.JSON_PROPERTY_PRESENTATION_NAME,
  WeathercamPresetDetailedV1.JSON_PROPERTY_IN_COLLECTION,
  WeathercamPresetDetailedV1.JSON_PROPERTY_RESOLUTION,
  WeathercamPresetDetailedV1.JSON_PROPERTY_DIRECTION_CODE,
  WeathercamPresetDetailedV1.JSON_PROPERTY_IMAGE_URL,
  WeathercamPresetDetailedV1.JSON_PROPERTY_DIRECTION
})
public class WeathercamPresetDetailedV1 {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_PRESENTATION_NAME = "presentationName";
  private String presentationName;

  public static final String JSON_PROPERTY_IN_COLLECTION = "inCollection";
  private Boolean inCollection;

  public static final String JSON_PROPERTY_RESOLUTION = "resolution";
  private String resolution;

  public static final String JSON_PROPERTY_DIRECTION_CODE = "directionCode";
  private String directionCode;

  public static final String JSON_PROPERTY_IMAGE_URL = "imageUrl";
  private String imageUrl;

  public static final String JSON_PROPERTY_DIRECTION = "direction";
  private WeathercamPresetDirectionV1 direction = WeathercamPresetDirectionV1.UNKNOWN;

  public WeathercamPresetDetailedV1() {
  }

  public WeathercamPresetDetailedV1 id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Id of preset
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Id of preset")
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


  public WeathercamPresetDetailedV1 presentationName(String presentationName) {
    
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


  public WeathercamPresetDetailedV1 inCollection(Boolean inCollection) {
    
    this.inCollection = inCollection;
    return this;
  }

   /**
   * Is preset in collection
   * @return inCollection
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Is preset in collection")
  @JsonProperty(JSON_PROPERTY_IN_COLLECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getInCollection() {
    return inCollection;
  }


  @JsonProperty(JSON_PROPERTY_IN_COLLECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInCollection(Boolean inCollection) {
    this.inCollection = inCollection;
  }


  public WeathercamPresetDetailedV1 resolution(String resolution) {
    
    this.resolution = resolution;
    return this;
  }

   /**
   * Resolution of camera [px x px]
   * @return resolution
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Resolution of camera [px x px]")
  @JsonProperty(JSON_PROPERTY_RESOLUTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getResolution() {
    return resolution;
  }


  @JsonProperty(JSON_PROPERTY_RESOLUTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }


  public WeathercamPresetDetailedV1 directionCode(String directionCode) {
    
    this.directionCode = directionCode;
    return this;
  }

   /**
   * Preset direction:&lt;br&gt; 0 &#x3D; Unknown direction.&lt;br&gt; 1 &#x3D; According to the road register address increasing direction. I.e. on the road 4 to Lahti, if we are in Korso.&lt;br&gt; 2 &#x3D; According to the road register address decreasing direction. I.e. on the road 4 to Helsinki, if we are in Korso.&lt;br&gt; 3 &#x3D; Increasing direction of the crossing road.&lt;br&gt; 4 &#x3D; Decreasing direction of the crossing road.&lt;br&gt; 5-99 &#x3D; Special directions
   * @return directionCode
  **/
 
  @ApiModelProperty(required = true, value = "Preset direction:<br> 0 = Unknown direction.<br> 1 = According to the road register address increasing direction. I.e. on the road 4 to Lahti, if we are in Korso.<br> 2 = According to the road register address decreasing direction. I.e. on the road 4 to Helsinki, if we are in Korso.<br> 3 = Increasing direction of the crossing road.<br> 4 = Decreasing direction of the crossing road.<br> 5-99 = Special directions")
  @JsonProperty(JSON_PROPERTY_DIRECTION_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDirectionCode() {
    return directionCode;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTION_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDirectionCode(String directionCode) {
    this.directionCode = directionCode;
  }


  public WeathercamPresetDetailedV1 imageUrl(String imageUrl) {
    
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


  public WeathercamPresetDetailedV1 direction(WeathercamPresetDirectionV1 direction) {
    
    this.direction = direction;
    return this;
  }

   /**
   * Get direction
   * @return direction
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public WeathercamPresetDirectionV1 getDirection() {
    return direction;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDirection(WeathercamPresetDirectionV1 direction) {
    this.direction = direction;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeathercamPresetDetailedV1 weathercamPresetDetailedV1 = (WeathercamPresetDetailedV1) o;
    return Objects.equals(this.id, weathercamPresetDetailedV1.id) &&
        Objects.equals(this.presentationName, weathercamPresetDetailedV1.presentationName) &&
        Objects.equals(this.inCollection, weathercamPresetDetailedV1.inCollection) &&
        Objects.equals(this.resolution, weathercamPresetDetailedV1.resolution) &&
        Objects.equals(this.directionCode, weathercamPresetDetailedV1.directionCode) &&
        Objects.equals(this.imageUrl, weathercamPresetDetailedV1.imageUrl) &&
        Objects.equals(this.direction, weathercamPresetDetailedV1.direction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, presentationName, inCollection, resolution, directionCode, imageUrl, direction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeathercamPresetDetailedV1 {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    presentationName: ").append(toIndentedString(presentationName)).append("\n");
    sb.append("    inCollection: ").append(toIndentedString(inCollection)).append("\n");
    sb.append("    resolution: ").append(toIndentedString(resolution)).append("\n");
    sb.append("    directionCode: ").append(toIndentedString(directionCode)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
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

