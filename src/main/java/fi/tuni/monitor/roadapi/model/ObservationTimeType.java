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
 * ObservationTimeType
 */
@JsonPropertyOrder({
  ObservationTimeType.JSON_PROPERTY_UTC,
  ObservationTimeType.JSON_PROPERTY_LOCALTIME
})
public class ObservationTimeType {
  public static final String JSON_PROPERTY_UTC = "utc";
  private OffsetDateTime utc;

  public static final String JSON_PROPERTY_LOCALTIME = "localtime";
  private OffsetDateTime localtime;

  public ObservationTimeType() {
  }

  public ObservationTimeType utc(OffsetDateTime utc) {
    
    this.utc = utc;
    return this;
  }

   /**
   * Get utc
   * @return utc
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_UTC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getUtc() {
    return utc;
  }


  @JsonProperty(JSON_PROPERTY_UTC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUtc(OffsetDateTime utc) {
    this.utc = utc;
  }


  public ObservationTimeType localtime(OffsetDateTime localtime) {
    
    this.localtime = localtime;
    return this;
  }

   /**
   * Get localtime
   * @return localtime
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LOCALTIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getLocaltime() {
    return localtime;
  }


  @JsonProperty(JSON_PROPERTY_LOCALTIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLocaltime(OffsetDateTime localtime) {
    this.localtime = localtime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationTimeType observationTimeType = (ObservationTimeType) o;
    return Objects.equals(this.utc, observationTimeType.utc) &&
        Objects.equals(this.localtime, observationTimeType.localtime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(utc, localtime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationTimeType {\n");
    sb.append("    utc: ").append(toIndentedString(utc)).append("\n");
    sb.append("    localtime: ").append(toIndentedString(localtime)).append("\n");
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

