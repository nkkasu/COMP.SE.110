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
 * Variable Sign text row
 */
@ApiModel(description = "Variable Sign text row")
@JsonPropertyOrder({
  SignTextRow.JSON_PROPERTY_SCREEN,
  SignTextRow.JSON_PROPERTY_ROW_NUMBER,
  SignTextRow.JSON_PROPERTY_TEXT
})
public class SignTextRow {
  public static final String JSON_PROPERTY_SCREEN = "screen";
  private Integer screen;

  public static final String JSON_PROPERTY_ROW_NUMBER = "rowNumber";
  private Integer rowNumber;

  public static final String JSON_PROPERTY_TEXT = "text";
  private String text;

  public SignTextRow() {
  }

  public SignTextRow screen(Integer screen) {
    
    this.screen = screen;
    return this;
  }

   /**
   * Screen number
   * @return screen
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Screen number")
  @JsonProperty(JSON_PROPERTY_SCREEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getScreen() {
    return screen;
  }


  @JsonProperty(JSON_PROPERTY_SCREEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScreen(Integer screen) {
    this.screen = screen;
  }


  public SignTextRow rowNumber(Integer rowNumber) {
    
    this.rowNumber = rowNumber;
    return this;
  }

   /**
   * Row number
   * @return rowNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Row number")
  @JsonProperty(JSON_PROPERTY_ROW_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRowNumber() {
    return rowNumber;
  }


  @JsonProperty(JSON_PROPERTY_ROW_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRowNumber(Integer rowNumber) {
    this.rowNumber = rowNumber;
  }


  public SignTextRow text(String text) {
    
    this.text = text;
    return this;
  }

   /**
   * Text on a row
   * @return text
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Text on a row")
  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getText() {
    return text;
  }


  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignTextRow signTextRow = (SignTextRow) o;
    return Objects.equals(this.screen, signTextRow.screen) &&
        Objects.equals(this.rowNumber, signTextRow.rowNumber) &&
        Objects.equals(this.text, signTextRow.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(screen, rowNumber, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignTextRow {\n");
    sb.append("    screen: ").append(toIndentedString(screen)).append("\n");
    sb.append("    rowNumber: ").append(toIndentedString(rowNumber)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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

