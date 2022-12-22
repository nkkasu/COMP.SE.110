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
import fi.tuni.monitor.roadapi.model.RoadPointV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Location consisting of a single road point or a road segment between two road points
 */
@ApiModel(description = "Location consisting of a single road point or a road segment between two road points")
@JsonPropertyOrder({
  RoadAddressLocationV1.JSON_PROPERTY_PRIMARY_POINT,
  RoadAddressLocationV1.JSON_PROPERTY_SECONDARY_POINT,
  RoadAddressLocationV1.JSON_PROPERTY_DIRECTION,
  RoadAddressLocationV1.JSON_PROPERTY_DIRECTION_DESCRIPTION
})
public class RoadAddressLocationV1 {
  public static final String JSON_PROPERTY_PRIMARY_POINT = "primaryPoint";
  private RoadPointV1 primaryPoint;

  public static final String JSON_PROPERTY_SECONDARY_POINT = "secondaryPoint";
  private RoadPointV1 secondaryPoint;

  /**
   * Affected road direction
   */
  public enum DirectionEnum {
    UNKNOWN("UNKNOWN"),
    
    POS("POS"),
    
    NEG("NEG"),
    
    BOTH("BOTH");

    private String value;

    DirectionEnum(String value) {
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
    public static DirectionEnum fromValue(String value) {
      for (DirectionEnum b : DirectionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_DIRECTION = "direction";
  private DirectionEnum direction;

  public static final String JSON_PROPERTY_DIRECTION_DESCRIPTION = "directionDescription";
  private String directionDescription;

  public RoadAddressLocationV1() {
  }

  public RoadAddressLocationV1 primaryPoint(RoadPointV1 primaryPoint) {
    
    this.primaryPoint = primaryPoint;
    return this;
  }

   /**
   * Get primaryPoint
   * @return primaryPoint
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PRIMARY_POINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public RoadPointV1 getPrimaryPoint() {
    return primaryPoint;
  }


  @JsonProperty(JSON_PROPERTY_PRIMARY_POINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPrimaryPoint(RoadPointV1 primaryPoint) {
    this.primaryPoint = primaryPoint;
  }


  public RoadAddressLocationV1 secondaryPoint(RoadPointV1 secondaryPoint) {
    
    this.secondaryPoint = secondaryPoint;
    return this;
  }

   /**
   * Get secondaryPoint
   * @return secondaryPoint
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SECONDARY_POINT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RoadPointV1 getSecondaryPoint() {
    return secondaryPoint;
  }


  @JsonProperty(JSON_PROPERTY_SECONDARY_POINT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSecondaryPoint(RoadPointV1 secondaryPoint) {
    this.secondaryPoint = secondaryPoint;
  }


  public RoadAddressLocationV1 direction(DirectionEnum direction) {
    
    this.direction = direction;
    return this;
  }

   /**
   * Affected road direction
   * @return direction
  **/
 
  @ApiModelProperty(required = true, value = "Affected road direction")
  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DirectionEnum getDirection() {
    return direction;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }


  public RoadAddressLocationV1 directionDescription(String directionDescription) {
    
    this.directionDescription = directionDescription;
    return this;
  }

   /**
   * Human readable description of the affected direction
   * @return directionDescription
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Human readable description of the affected direction")
  @JsonProperty(JSON_PROPERTY_DIRECTION_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDirectionDescription() {
    return directionDescription;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTION_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDirectionDescription(String directionDescription) {
    this.directionDescription = directionDescription;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoadAddressLocationV1 roadAddressLocationV1 = (RoadAddressLocationV1) o;
    return Objects.equals(this.primaryPoint, roadAddressLocationV1.primaryPoint) &&
        Objects.equals(this.secondaryPoint, roadAddressLocationV1.secondaryPoint) &&
        Objects.equals(this.direction, roadAddressLocationV1.direction) &&
        Objects.equals(this.directionDescription, roadAddressLocationV1.directionDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(primaryPoint, secondaryPoint, direction, directionDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoadAddressLocationV1 {\n");
    sb.append("    primaryPoint: ").append(toIndentedString(primaryPoint)).append("\n");
    sb.append("    secondaryPoint: ").append(toIndentedString(secondaryPoint)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    directionDescription: ").append(toIndentedString(directionDescription)).append("\n");
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

