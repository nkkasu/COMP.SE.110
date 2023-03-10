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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Location properties.
 */
@ApiModel(description = "Location properties.")
@JsonPropertyOrder({
  LocationProperties.JSON_PROPERTY_LOCATION_CODE,
  LocationProperties.JSON_PROPERTY_SUBTYPE_CODE,
  LocationProperties.JSON_PROPERTY_ROAD_JUNCTION,
  LocationProperties.JSON_PROPERTY_ROAD_NAME,
  LocationProperties.JSON_PROPERTY_FIRST_NAME,
  LocationProperties.JSON_PROPERTY_SECOND_NAME,
  LocationProperties.JSON_PROPERTY_AREA_REF,
  LocationProperties.JSON_PROPERTY_LINEAR_REF,
  LocationProperties.JSON_PROPERTY_NEG_OFFSET,
  LocationProperties.JSON_PROPERTY_POS_OFFSET,
  LocationProperties.JSON_PROPERTY_URBAN,
  LocationProperties.JSON_PROPERTY_COORDINATES_E_T_R_S89,
  LocationProperties.JSON_PROPERTY_NEG_DIRECTION,
  LocationProperties.JSON_PROPERTY_POS_DIRECTION,
  LocationProperties.JSON_PROPERTY_GEOCODE,
  LocationProperties.JSON_PROPERTY_ORDER_OF_POINT
})
public class LocationProperties {
  public static final String JSON_PROPERTY_LOCATION_CODE = "locationCode";
  private Integer locationCode;

  public static final String JSON_PROPERTY_SUBTYPE_CODE = "subtypeCode";
  private String subtypeCode;

  public static final String JSON_PROPERTY_ROAD_JUNCTION = "roadJunction";
  private String roadJunction;

  public static final String JSON_PROPERTY_ROAD_NAME = "roadName";
  private String roadName;

  public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
  private String firstName;

  public static final String JSON_PROPERTY_SECOND_NAME = "secondName";
  private String secondName;

  public static final String JSON_PROPERTY_AREA_REF = "areaRef";
  private Integer areaRef;

  public static final String JSON_PROPERTY_LINEAR_REF = "linearRef";
  private Integer linearRef;

  public static final String JSON_PROPERTY_NEG_OFFSET = "negOffset";
  private Integer negOffset;

  public static final String JSON_PROPERTY_POS_OFFSET = "posOffset";
  private Integer posOffset;

  public static final String JSON_PROPERTY_URBAN = "urban";
  private Boolean urban;

  public static final String JSON_PROPERTY_COORDINATES_E_T_R_S89 = "coordinatesETRS89";
  private List<Double> coordinatesETRS89 = null;

  public static final String JSON_PROPERTY_NEG_DIRECTION = "negDirection";
  private String negDirection;

  public static final String JSON_PROPERTY_POS_DIRECTION = "posDirection";
  private String posDirection;

  public static final String JSON_PROPERTY_GEOCODE = "geocode";
  private String geocode;

  public static final String JSON_PROPERTY_ORDER_OF_POINT = "orderOfPoint";
  private String orderOfPoint;

  public LocationProperties() {
  }

  public LocationProperties locationCode(Integer locationCode) {
    
    this.locationCode = locationCode;
    return this;
  }

   /**
   * Unique locationCode for this location
   * @return locationCode
  **/
 
  @ApiModelProperty(required = true, value = "Unique locationCode for this location")
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


  public LocationProperties subtypeCode(String subtypeCode) {
    
    this.subtypeCode = subtypeCode;
    return this;
  }

   /**
   * Code of location subtype
   * @return subtypeCode
  **/
 
  @ApiModelProperty(required = true, value = "Code of location subtype")
  @JsonProperty(JSON_PROPERTY_SUBTYPE_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSubtypeCode() {
    return subtypeCode;
  }


  @JsonProperty(JSON_PROPERTY_SUBTYPE_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubtypeCode(String subtypeCode) {
    this.subtypeCode = subtypeCode;
  }


  public LocationProperties roadJunction(String roadJunction) {
    
    this.roadJunction = roadJunction;
    return this;
  }

   /**
   * Roadnumber for roads. Junctionno: the numbering of exits has only just begun on the very limited Finnish motorway network. The exit numbers will be included. NOTE: the roads, segments and points are not sorted in ascending order
   * @return roadJunction
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Roadnumber for roads. Junctionno: the numbering of exits has only just begun on the very limited Finnish motorway network. The exit numbers will be included. NOTE: the roads, segments and points are not sorted in ascending order")
  @JsonProperty(JSON_PROPERTY_ROAD_JUNCTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRoadJunction() {
    return roadJunction;
  }


  @JsonProperty(JSON_PROPERTY_ROAD_JUNCTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoadJunction(String roadJunction) {
    this.roadJunction = roadJunction;
  }


  public LocationProperties roadName(String roadName) {
    
    this.roadName = roadName;
    return this;
  }

   /**
   * Roadname if exists, L5.0 always have road name
   * @return roadName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Roadname if exists, L5.0 always have road name")
  @JsonProperty(JSON_PROPERTY_ROAD_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRoadName() {
    return roadName;
  }


  @JsonProperty(JSON_PROPERTY_ROAD_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoadName(String roadName) {
    this.roadName = roadName;
  }


  public LocationProperties firstName(String firstName) {
    
    this.firstName = firstName;
    return this;
  }

   /**
   * For roads and segments this is the name of the starting point. For all other objects (linear (streets), area and point) this is the name of the object
   * @return firstName
  **/
 
  @ApiModelProperty(required = true, value = "For roads and segments this is the name of the starting point. For all other objects (linear (streets), area and point) this is the name of the object")
  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFirstName() {
    return firstName;
  }


  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public LocationProperties secondName(String secondName) {
    
    this.secondName = secondName;
    return this;
  }

   /**
   * For roads and segments this is the name of the ending point. For point locations the number of the intersecting road
   * @return secondName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "For roads and segments this is the name of the ending point. For point locations the number of the intersecting road")
  @JsonProperty(JSON_PROPERTY_SECOND_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSecondName() {
    return secondName;
  }


  @JsonProperty(JSON_PROPERTY_SECOND_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }


  public LocationProperties areaRef(Integer areaRef) {
    
    this.areaRef = areaRef;
    return this;
  }

   /**
   * Code of the upper order administrative area
   * @return areaRef
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Code of the upper order administrative area")
  @JsonProperty(JSON_PROPERTY_AREA_REF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAreaRef() {
    return areaRef;
  }


  @JsonProperty(JSON_PROPERTY_AREA_REF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAreaRef(Integer areaRef) {
    this.areaRef = areaRef;
  }


  public LocationProperties linearRef(Integer linearRef) {
    
    this.linearRef = linearRef;
    return this;
  }

   /**
   * For segments and point locations. Describes the code of the segment which these objects belong to. If there are no segments on the road the location code of the road is given instead
   * @return linearRef
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "For segments and point locations. Describes the code of the segment which these objects belong to. If there are no segments on the road the location code of the road is given instead")
  @JsonProperty(JSON_PROPERTY_LINEAR_REF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getLinearRef() {
    return linearRef;
  }


  @JsonProperty(JSON_PROPERTY_LINEAR_REF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLinearRef(Integer linearRef) {
    this.linearRef = linearRef;
  }


  public LocationProperties negOffset(Integer negOffset) {
    
    this.negOffset = negOffset;
    return this;
  }

   /**
   * For segments and point locations. Segments: describes the code of previous segment on that road. For the first segment on the road this code is 0. Points: describes the code of previous point on that road. For the starting point this code is 0
   * @return negOffset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "For segments and point locations. Segments: describes the code of previous segment on that road. For the first segment on the road this code is 0. Points: describes the code of previous point on that road. For the starting point this code is 0")
  @JsonProperty(JSON_PROPERTY_NEG_OFFSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNegOffset() {
    return negOffset;
  }


  @JsonProperty(JSON_PROPERTY_NEG_OFFSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNegOffset(Integer negOffset) {
    this.negOffset = negOffset;
  }


  public LocationProperties posOffset(Integer posOffset) {
    
    this.posOffset = posOffset;
    return this;
  }

   /**
   * For segments and point locations. Segments: describes the code of next segment on that road. For the last segment on the road this code is 0. Points: describes the code of next point on that road. For the last point this code is 0
   * @return posOffset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "For segments and point locations. Segments: describes the code of next segment on that road. For the last segment on the road this code is 0. Points: describes the code of next point on that road. For the last point this code is 0")
  @JsonProperty(JSON_PROPERTY_POS_OFFSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPosOffset() {
    return posOffset;
  }


  @JsonProperty(JSON_PROPERTY_POS_OFFSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPosOffset(Integer posOffset) {
    this.posOffset = posOffset;
  }


  public LocationProperties urban(Boolean urban) {
    
    this.urban = urban;
    return this;
  }

   /**
   * Indicates whether a point is within the city limits (1) or not (0). NOTE: Not actively entered yet
   * @return urban
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether a point is within the city limits (1) or not (0). NOTE: Not actively entered yet")
  @JsonProperty(JSON_PROPERTY_URBAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getUrban() {
    return urban;
  }


  @JsonProperty(JSON_PROPERTY_URBAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUrban(Boolean urban) {
    this.urban = urban;
  }


  public LocationProperties coordinatesETRS89(List<Double> coordinatesETRS89) {
    
    this.coordinatesETRS89 = coordinatesETRS89;
    return this;
  }

  public LocationProperties addCoordinatesETRS89Item(Double coordinatesETRS89Item) {
    if (this.coordinatesETRS89 == null) {
      this.coordinatesETRS89 = new ArrayList<>();
    }
    this.coordinatesETRS89.add(coordinatesETRS89Item);
    return this;
  }

   /**
   * Point coordinates (LONGITUDE, LATITUDE). Coordinates are in ETRS89 / ETRS-TM35FIN format.
   * @return coordinatesETRS89
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Point coordinates (LONGITUDE, LATITUDE). Coordinates are in ETRS89 / ETRS-TM35FIN format.")
  @JsonProperty(JSON_PROPERTY_COORDINATES_E_T_R_S89)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Double> getCoordinatesETRS89() {
    return coordinatesETRS89;
  }


  @JsonProperty(JSON_PROPERTY_COORDINATES_E_T_R_S89)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCoordinatesETRS89(List<Double> coordinatesETRS89) {
    this.coordinatesETRS89 = coordinatesETRS89;
  }


  public LocationProperties negDirection(String negDirection) {
    
    this.negDirection = negDirection;
    return this;
  }

   /**
   * For all L5.0 and for some roads. Text to be used when the incident has an effect only on vehicles driving in the negative direction of the road. ( e.g. Ring 1 westbound)
   * @return negDirection
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "For all L5.0 and for some roads. Text to be used when the incident has an effect only on vehicles driving in the negative direction of the road. ( e.g. Ring 1 westbound)")
  @JsonProperty(JSON_PROPERTY_NEG_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNegDirection() {
    return negDirection;
  }


  @JsonProperty(JSON_PROPERTY_NEG_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNegDirection(String negDirection) {
    this.negDirection = negDirection;
  }


  public LocationProperties posDirection(String posDirection) {
    
    this.posDirection = posDirection;
    return this;
  }

   /**
   * For all L5.0 and for some roads. Text to be used when the incident has an effect only on vehicles driving in the positive direction of the road. ( e.g. Ring 1 eastbound)
   * @return posDirection
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "For all L5.0 and for some roads. Text to be used when the incident has an effect only on vehicles driving in the positive direction of the road. ( e.g. Ring 1 eastbound)")
  @JsonProperty(JSON_PROPERTY_POS_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPosDirection() {
    return posDirection;
  }


  @JsonProperty(JSON_PROPERTY_POS_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPosDirection(String posDirection) {
    this.posDirection = posDirection;
  }


  public LocationProperties geocode(String geocode) {
    
    this.geocode = geocode;
    return this;
  }

   /**
   * Point location according to Finnish Transport Agency???s official addressing where Locations on road network are addressed as: Road number;Road part number;Carriageway; Distance from the beginning of the road part
   * @return geocode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Point location according to Finnish Transport Agency???s official addressing where Locations on road network are addressed as: Road number;Road part number;Carriageway; Distance from the beginning of the road part")
  @JsonProperty(JSON_PROPERTY_GEOCODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGeocode() {
    return geocode;
  }


  @JsonProperty(JSON_PROPERTY_GEOCODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGeocode(String geocode) {
    this.geocode = geocode;
  }


  public LocationProperties orderOfPoint(String orderOfPoint) {
    
    this.orderOfPoint = orderOfPoint;
    return this;
  }

   /**
   * The order of point within line or segment feature
   * @return orderOfPoint
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The order of point within line or segment feature")
  @JsonProperty(JSON_PROPERTY_ORDER_OF_POINT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOrderOfPoint() {
    return orderOfPoint;
  }


  @JsonProperty(JSON_PROPERTY_ORDER_OF_POINT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrderOfPoint(String orderOfPoint) {
    this.orderOfPoint = orderOfPoint;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationProperties locationProperties = (LocationProperties) o;
    return Objects.equals(this.locationCode, locationProperties.locationCode) &&
        Objects.equals(this.subtypeCode, locationProperties.subtypeCode) &&
        Objects.equals(this.roadJunction, locationProperties.roadJunction) &&
        Objects.equals(this.roadName, locationProperties.roadName) &&
        Objects.equals(this.firstName, locationProperties.firstName) &&
        Objects.equals(this.secondName, locationProperties.secondName) &&
        Objects.equals(this.areaRef, locationProperties.areaRef) &&
        Objects.equals(this.linearRef, locationProperties.linearRef) &&
        Objects.equals(this.negOffset, locationProperties.negOffset) &&
        Objects.equals(this.posOffset, locationProperties.posOffset) &&
        Objects.equals(this.urban, locationProperties.urban) &&
        Objects.equals(this.coordinatesETRS89, locationProperties.coordinatesETRS89) &&
        Objects.equals(this.negDirection, locationProperties.negDirection) &&
        Objects.equals(this.posDirection, locationProperties.posDirection) &&
        Objects.equals(this.geocode, locationProperties.geocode) &&
        Objects.equals(this.orderOfPoint, locationProperties.orderOfPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locationCode, subtypeCode, roadJunction, roadName, firstName, secondName, areaRef, linearRef, negOffset, posOffset, urban, coordinatesETRS89, negDirection, posDirection, geocode, orderOfPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationProperties {\n");
    sb.append("    locationCode: ").append(toIndentedString(locationCode)).append("\n");
    sb.append("    subtypeCode: ").append(toIndentedString(subtypeCode)).append("\n");
    sb.append("    roadJunction: ").append(toIndentedString(roadJunction)).append("\n");
    sb.append("    roadName: ").append(toIndentedString(roadName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    secondName: ").append(toIndentedString(secondName)).append("\n");
    sb.append("    areaRef: ").append(toIndentedString(areaRef)).append("\n");
    sb.append("    linearRef: ").append(toIndentedString(linearRef)).append("\n");
    sb.append("    negOffset: ").append(toIndentedString(negOffset)).append("\n");
    sb.append("    posOffset: ").append(toIndentedString(posOffset)).append("\n");
    sb.append("    urban: ").append(toIndentedString(urban)).append("\n");
    sb.append("    coordinatesETRS89: ").append(toIndentedString(coordinatesETRS89)).append("\n");
    sb.append("    negDirection: ").append(toIndentedString(negDirection)).append("\n");
    sb.append("    posDirection: ").append(toIndentedString(posDirection)).append("\n");
    sb.append("    geocode: ").append(toIndentedString(geocode)).append("\n");
    sb.append("    orderOfPoint: ").append(toIndentedString(orderOfPoint)).append("\n");
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

