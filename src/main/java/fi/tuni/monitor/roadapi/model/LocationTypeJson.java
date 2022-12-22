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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * LocationTypeJson
 */
@JsonPropertyOrder({
  LocationTypeJson.JSON_PROPERTY_DESCRIPTION_EN,
  LocationTypeJson.JSON_PROPERTY_DESCRIPTION_FI,
  LocationTypeJson.JSON_PROPERTY_TYPE_CODE
})
public class LocationTypeJson {
  public static final String JSON_PROPERTY_DESCRIPTION_EN = "descriptionEn";
  private String descriptionEn;

  public static final String JSON_PROPERTY_DESCRIPTION_FI = "descriptionFi";
  private String descriptionFi;

  public static final String JSON_PROPERTY_TYPE_CODE = "typeCode";
  private String typeCode;

  public LocationTypeJson() {
  }

  public LocationTypeJson descriptionEn(String descriptionEn) {
    
    this.descriptionEn = descriptionEn;
    return this;
  }

   /**
   * Get descriptionEn
   * @return descriptionEn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION_EN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescriptionEn() {
    return descriptionEn;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION_EN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescriptionEn(String descriptionEn) {
    this.descriptionEn = descriptionEn;
  }


  public LocationTypeJson descriptionFi(String descriptionFi) {
    
    this.descriptionFi = descriptionFi;
    return this;
  }

   /**
   * Get descriptionFi
   * @return descriptionFi
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION_FI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescriptionFi() {
    return descriptionFi;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION_FI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescriptionFi(String descriptionFi) {
    this.descriptionFi = descriptionFi;
  }


  public LocationTypeJson typeCode(String typeCode) {
    
    this.typeCode = typeCode;
    return this;
  }

   /**
   * Get typeCode
   * @return typeCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TYPE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTypeCode() {
    return typeCode;
  }


  @JsonProperty(JSON_PROPERTY_TYPE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationTypeJson locationTypeJson = (LocationTypeJson) o;
    return Objects.equals(this.descriptionEn, locationTypeJson.descriptionEn) &&
        Objects.equals(this.descriptionFi, locationTypeJson.descriptionFi) &&
        Objects.equals(this.typeCode, locationTypeJson.typeCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(descriptionEn, descriptionFi, typeCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationTypeJson {\n");
    sb.append("    descriptionEn: ").append(toIndentedString(descriptionEn)).append("\n");
    sb.append("    descriptionFi: ").append(toIndentedString(descriptionFi)).append("\n");
    sb.append("    typeCode: ").append(toIndentedString(typeCode)).append("\n");
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
