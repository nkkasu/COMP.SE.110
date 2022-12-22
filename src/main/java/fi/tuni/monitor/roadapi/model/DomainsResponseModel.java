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
 * Counting Site Domain
 */
@ApiModel(description = "Counting Site Domain")
@JsonPropertyOrder({
  DomainsResponseModel.JSON_PROPERTY_ADDED_TIMESTAMP,
  DomainsResponseModel.JSON_PROPERTY_NAME,
  DomainsResponseModel.JSON_PROPERTY_DESCRIPTION,
  DomainsResponseModel.JSON_PROPERTY_REMOVED_TIMESTAMP
})
public class DomainsResponseModel {
  public static final String JSON_PROPERTY_ADDED_TIMESTAMP = "addedTimestamp";
  private OffsetDateTime addedTimestamp;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_REMOVED_TIMESTAMP = "removedTimestamp";
  private OffsetDateTime removedTimestamp;

  public DomainsResponseModel() {
  }

  public DomainsResponseModel addedTimestamp(OffsetDateTime addedTimestamp) {
    
    this.addedTimestamp = addedTimestamp;
    return this;
  }

   /**
   * Domain added
   * @return addedTimestamp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Domain added")
  @JsonProperty(JSON_PROPERTY_ADDED_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getAddedTimestamp() {
    return addedTimestamp;
  }


  @JsonProperty(JSON_PROPERTY_ADDED_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddedTimestamp(OffsetDateTime addedTimestamp) {
    this.addedTimestamp = addedTimestamp;
  }


  public DomainsResponseModel name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Domain name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Domain name")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public DomainsResponseModel description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Domain description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Domain description")
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


  public DomainsResponseModel removedTimestamp(OffsetDateTime removedTimestamp) {
    
    this.removedTimestamp = removedTimestamp;
    return this;
  }

   /**
   * Domain removed
   * @return removedTimestamp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Domain removed")
  @JsonProperty(JSON_PROPERTY_REMOVED_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getRemovedTimestamp() {
    return removedTimestamp;
  }


  @JsonProperty(JSON_PROPERTY_REMOVED_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRemovedTimestamp(OffsetDateTime removedTimestamp) {
    this.removedTimestamp = removedTimestamp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DomainsResponseModel domainsResponseModel = (DomainsResponseModel) o;
    return Objects.equals(this.addedTimestamp, domainsResponseModel.addedTimestamp) &&
        Objects.equals(this.name, domainsResponseModel.name) &&
        Objects.equals(this.description, domainsResponseModel.description) &&
        Objects.equals(this.removedTimestamp, domainsResponseModel.removedTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addedTimestamp, name, description, removedTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DomainsResponseModel {\n");
    sb.append("    addedTimestamp: ").append(toIndentedString(addedTimestamp)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    removedTimestamp: ").append(toIndentedString(removedTimestamp)).append("\n");
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
