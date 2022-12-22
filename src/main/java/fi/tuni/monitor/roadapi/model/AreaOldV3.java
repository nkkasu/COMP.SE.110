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
 * AlertC area
 */
@ApiModel(description = "AlertC area")
@JsonPropertyOrder({
  AreaOldV3.JSON_PROPERTY_NAME,
  AreaOldV3.JSON_PROPERTY_LOCATION_CODE,
  AreaOldV3.JSON_PROPERTY_TYPE
})
@JsonTypeName("Area_OldV3")
public class AreaOldV3 {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_LOCATION_CODE = "locationCode";
  private Integer locationCode;

  /**
   * Area location type
   */
  public enum TypeEnum {
    MUNICIPALITY("MUNICIPALITY"),
    
    PROVINCE("PROVINCE"),
    
    REGIONAL_STATE_ADMINISTRATIVE_AGENCY("REGIONAL_STATE_ADMINISTRATIVE_AGENCY"),
    
    WEATHER_REGION("WEATHER_REGION"),
    
    COUNTRY("COUNTRY"),
    
    CITY_REGION("CITY_REGION"),
    
    TRAVEL_REGION("TRAVEL_REGION"),
    
    UNKNOWN("UNKNOWN");

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

  public AreaOldV3() {
  }

  public AreaOldV3 name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the area
   * @return name
  **/
 
  @ApiModelProperty(required = true, value = "The name of the area")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }


  public AreaOldV3 locationCode(Integer locationCode) {
    
    this.locationCode = locationCode;
    return this;
  }

   /**
   * Location code of the area, number of the road point in AlertC location table
   * @return locationCode
  **/
 
  @ApiModelProperty(required = true, value = "Location code of the area, number of the road point in AlertC location table")
  @JsonProperty(JSON_PROPERTY_LOCATION_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getLocationCode() {
    return locationCode;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLocationCode(Integer locationCode) {
    this.locationCode = locationCode;
  }


  public AreaOldV3 type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Area location type
   * @return type
  **/
 
  @ApiModelProperty(example = "MUNICIPALITY", required = true, value = "Area location type")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypeEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AreaOldV3 areaOldV3 = (AreaOldV3) o;
    return Objects.equals(this.name, areaOldV3.name) &&
        Objects.equals(this.locationCode, areaOldV3.locationCode) &&
        Objects.equals(this.type, areaOldV3.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, locationCode, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AreaOldV3 {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    locationCode: ").append(toIndentedString(locationCode)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
