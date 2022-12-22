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
import fi.tuni.monitor.roadapi.model.ExtensionType;
import fi.tuni.monitor.roadapi.model.InternationalIdentifier;
import fi.tuni.monitor.roadapi.model.MultilingualString;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * PayloadPublication
 */
@JsonPropertyOrder({
  PayloadPublication.JSON_PROPERTY_FEED_DESCRIPTION,
  PayloadPublication.JSON_PROPERTY_FEED_TYPE,
  PayloadPublication.JSON_PROPERTY_PUBLICATION_TIME,
  PayloadPublication.JSON_PROPERTY_PUBLICATION_CREATOR,
  PayloadPublication.JSON_PROPERTY_PAYLOAD_PUBLICATION_EXTENSION,
  PayloadPublication.JSON_PROPERTY_LANG
})
public class PayloadPublication {
  public static final String JSON_PROPERTY_FEED_DESCRIPTION = "feedDescription";
  private MultilingualString feedDescription;

  public static final String JSON_PROPERTY_FEED_TYPE = "feedType";
  private String feedType;

  public static final String JSON_PROPERTY_PUBLICATION_TIME = "publicationTime";
  private OffsetDateTime publicationTime;

  public static final String JSON_PROPERTY_PUBLICATION_CREATOR = "publicationCreator";
  private InternationalIdentifier publicationCreator;

  public static final String JSON_PROPERTY_PAYLOAD_PUBLICATION_EXTENSION = "payloadPublicationExtension";
  private ExtensionType payloadPublicationExtension;

  public static final String JSON_PROPERTY_LANG = "lang";
  private String lang;

  public PayloadPublication() {
  }

  public PayloadPublication feedDescription(MultilingualString feedDescription) {
    
    this.feedDescription = feedDescription;
    return this;
  }

   /**
   * Get feedDescription
   * @return feedDescription
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FEED_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MultilingualString getFeedDescription() {
    return feedDescription;
  }


  @JsonProperty(JSON_PROPERTY_FEED_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFeedDescription(MultilingualString feedDescription) {
    this.feedDescription = feedDescription;
  }


  public PayloadPublication feedType(String feedType) {
    
    this.feedType = feedType;
    return this;
  }

   /**
   * Get feedType
   * @return feedType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FEED_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFeedType() {
    return feedType;
  }


  @JsonProperty(JSON_PROPERTY_FEED_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFeedType(String feedType) {
    this.feedType = feedType;
  }


  public PayloadPublication publicationTime(OffsetDateTime publicationTime) {
    
    this.publicationTime = publicationTime;
    return this;
  }

   /**
   * Get publicationTime
   * @return publicationTime
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PUBLICATION_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getPublicationTime() {
    return publicationTime;
  }


  @JsonProperty(JSON_PROPERTY_PUBLICATION_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPublicationTime(OffsetDateTime publicationTime) {
    this.publicationTime = publicationTime;
  }


  public PayloadPublication publicationCreator(InternationalIdentifier publicationCreator) {
    
    this.publicationCreator = publicationCreator;
    return this;
  }

   /**
   * Get publicationCreator
   * @return publicationCreator
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PUBLICATION_CREATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public InternationalIdentifier getPublicationCreator() {
    return publicationCreator;
  }


  @JsonProperty(JSON_PROPERTY_PUBLICATION_CREATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPublicationCreator(InternationalIdentifier publicationCreator) {
    this.publicationCreator = publicationCreator;
  }


  public PayloadPublication payloadPublicationExtension(ExtensionType payloadPublicationExtension) {
    
    this.payloadPublicationExtension = payloadPublicationExtension;
    return this;
  }

   /**
   * Get payloadPublicationExtension
   * @return payloadPublicationExtension
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PAYLOAD_PUBLICATION_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ExtensionType getPayloadPublicationExtension() {
    return payloadPublicationExtension;
  }


  @JsonProperty(JSON_PROPERTY_PAYLOAD_PUBLICATION_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayloadPublicationExtension(ExtensionType payloadPublicationExtension) {
    this.payloadPublicationExtension = payloadPublicationExtension;
  }


  public PayloadPublication lang(String lang) {
    
    this.lang = lang;
    return this;
  }

   /**
   * Get lang
   * @return lang
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LANG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLang() {
    return lang;
  }


  @JsonProperty(JSON_PROPERTY_LANG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLang(String lang) {
    this.lang = lang;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayloadPublication payloadPublication = (PayloadPublication) o;
    return Objects.equals(this.feedDescription, payloadPublication.feedDescription) &&
        Objects.equals(this.feedType, payloadPublication.feedType) &&
        Objects.equals(this.publicationTime, payloadPublication.publicationTime) &&
        Objects.equals(this.publicationCreator, payloadPublication.publicationCreator) &&
        Objects.equals(this.payloadPublicationExtension, payloadPublication.payloadPublicationExtension) &&
        Objects.equals(this.lang, payloadPublication.lang);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feedDescription, feedType, publicationTime, publicationCreator, payloadPublicationExtension, lang);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayloadPublication {\n");
    sb.append("    feedDescription: ").append(toIndentedString(feedDescription)).append("\n");
    sb.append("    feedType: ").append(toIndentedString(feedType)).append("\n");
    sb.append("    publicationTime: ").append(toIndentedString(publicationTime)).append("\n");
    sb.append("    publicationCreator: ").append(toIndentedString(publicationCreator)).append("\n");
    sb.append("    payloadPublicationExtension: ").append(toIndentedString(payloadPublicationExtension)).append("\n");
    sb.append("    lang: ").append(toIndentedString(lang)).append("\n");
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

