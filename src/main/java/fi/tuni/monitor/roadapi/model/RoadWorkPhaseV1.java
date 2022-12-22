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
import fi.tuni.monitor.roadapi.model.LocationDetailsV1;
import fi.tuni.monitor.roadapi.model.LocationV1;
import fi.tuni.monitor.roadapi.model.RestrictionV1;
import fi.tuni.monitor.roadapi.model.TimeAndDurationV1;
import fi.tuni.monitor.roadapi.model.WeekdayTimePeriodV1;
import fi.tuni.monitor.roadapi.model.WorkTypeV1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A single phase in a larger road work
 */
@ApiModel(description = "A single phase in a larger road work")
@JsonPropertyOrder({
  RoadWorkPhaseV1.JSON_PROPERTY_ID,
  RoadWorkPhaseV1.JSON_PROPERTY_LOCATION,
  RoadWorkPhaseV1.JSON_PROPERTY_LOCATION_DETAILS,
  RoadWorkPhaseV1.JSON_PROPERTY_WORKING_HOURS,
  RoadWorkPhaseV1.JSON_PROPERTY_COMMENT,
  RoadWorkPhaseV1.JSON_PROPERTY_TIME_AND_DURATION,
  RoadWorkPhaseV1.JSON_PROPERTY_WORK_TYPES,
  RoadWorkPhaseV1.JSON_PROPERTY_RESTRICTIONS,
  RoadWorkPhaseV1.JSON_PROPERTY_RESTRICTIONS_LIFTABLE,
  RoadWorkPhaseV1.JSON_PROPERTY_SEVERITY,
  RoadWorkPhaseV1.JSON_PROPERTY_SLOW_TRAFFIC_TIMES,
  RoadWorkPhaseV1.JSON_PROPERTY_QUEUING_TRAFFIC_TIMES
})
public class RoadWorkPhaseV1 {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_LOCATION = "location";
  private LocationV1 location;

  public static final String JSON_PROPERTY_LOCATION_DETAILS = "locationDetails";
  private LocationDetailsV1 locationDetails;

  public static final String JSON_PROPERTY_WORKING_HOURS = "workingHours";
  private List<WeekdayTimePeriodV1> workingHours = new ArrayList<>();

  public static final String JSON_PROPERTY_COMMENT = "comment";
  private String comment;

  public static final String JSON_PROPERTY_TIME_AND_DURATION = "timeAndDuration";
  private TimeAndDurationV1 timeAndDuration;

  public static final String JSON_PROPERTY_WORK_TYPES = "workTypes";
  private List<WorkTypeV1> workTypes = null;

  public static final String JSON_PROPERTY_RESTRICTIONS = "restrictions";
  private List<RestrictionV1> restrictions = null;

  public static final String JSON_PROPERTY_RESTRICTIONS_LIFTABLE = "restrictionsLiftable";
  private Boolean restrictionsLiftable;

  /**
   * Severity of the disruption to traffic. How severely this road work phase disrupts traffic. LOW - no disruption, HIGH - disruption, HIGHEST - significant disruption
   */
  public enum SeverityEnum {
    LOW("LOW"),
    
    HIGH("HIGH"),
    
    HIGHEST("HIGHEST");

    private String value;

    SeverityEnum(String value) {
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
    public static SeverityEnum fromValue(String value) {
      for (SeverityEnum b : SeverityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_SEVERITY = "severity";
  private SeverityEnum severity;

  public static final String JSON_PROPERTY_SLOW_TRAFFIC_TIMES = "slowTrafficTimes";
  private List<WeekdayTimePeriodV1> slowTrafficTimes = null;

  public static final String JSON_PROPERTY_QUEUING_TRAFFIC_TIMES = "queuingTrafficTimes";
  private List<WeekdayTimePeriodV1> queuingTrafficTimes = null;

  public RoadWorkPhaseV1() {
  }

  public RoadWorkPhaseV1 id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * id
   * @return id
  **/
 
  @ApiModelProperty(required = true, value = "id")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public RoadWorkPhaseV1 location(LocationV1 location) {
    
    this.location = location;
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocationV1 getLocation() {
    return location;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocation(LocationV1 location) {
    this.location = location;
  }


  public RoadWorkPhaseV1 locationDetails(LocationDetailsV1 locationDetails) {
    
    this.locationDetails = locationDetails;
    return this;
  }

   /**
   * Get locationDetails
   * @return locationDetails
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LOCATION_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocationDetailsV1 getLocationDetails() {
    return locationDetails;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocationDetails(LocationDetailsV1 locationDetails) {
    this.locationDetails = locationDetails;
  }


  public RoadWorkPhaseV1 workingHours(List<WeekdayTimePeriodV1> workingHours) {
    
    this.workingHours = workingHours;
    return this;
  }

  public RoadWorkPhaseV1 addWorkingHoursItem(WeekdayTimePeriodV1 workingHoursItem) {
    this.workingHours.add(workingHoursItem);
    return this;
  }

   /**
   * WorkingHours of an traffic situation announcement
   * @return workingHours
  **/
 
  @ApiModelProperty(required = true, value = "WorkingHours of an traffic situation announcement")
  @JsonProperty(JSON_PROPERTY_WORKING_HOURS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<WeekdayTimePeriodV1> getWorkingHours() {
    return workingHours;
  }


  @JsonProperty(JSON_PROPERTY_WORKING_HOURS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setWorkingHours(List<WeekdayTimePeriodV1> workingHours) {
    this.workingHours = workingHours;
  }


  public RoadWorkPhaseV1 comment(String comment) {
    
    this.comment = comment;
    return this;
  }

   /**
   * Free comment
   * @return comment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Free comment")
  @JsonProperty(JSON_PROPERTY_COMMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getComment() {
    return comment;
  }


  @JsonProperty(JSON_PROPERTY_COMMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setComment(String comment) {
    this.comment = comment;
  }


  public RoadWorkPhaseV1 timeAndDuration(TimeAndDurationV1 timeAndDuration) {
    
    this.timeAndDuration = timeAndDuration;
    return this;
  }

   /**
   * Get timeAndDuration
   * @return timeAndDuration
  **/
 
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TIME_AND_DURATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TimeAndDurationV1 getTimeAndDuration() {
    return timeAndDuration;
  }


  @JsonProperty(JSON_PROPERTY_TIME_AND_DURATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimeAndDuration(TimeAndDurationV1 timeAndDuration) {
    this.timeAndDuration = timeAndDuration;
  }


  public RoadWorkPhaseV1 workTypes(List<WorkTypeV1> workTypes) {
    
    this.workTypes = workTypes;
    return this;
  }

  public RoadWorkPhaseV1 addWorkTypesItem(WorkTypeV1 workTypesItem) {
    if (this.workTypes == null) {
      this.workTypes = new ArrayList<>();
    }
    this.workTypes.add(workTypesItem);
    return this;
  }

   /**
   * The types of work that are carried out
   * @return workTypes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The types of work that are carried out")
  @JsonProperty(JSON_PROPERTY_WORK_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<WorkTypeV1> getWorkTypes() {
    return workTypes;
  }


  @JsonProperty(JSON_PROPERTY_WORK_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWorkTypes(List<WorkTypeV1> workTypes) {
    this.workTypes = workTypes;
  }


  public RoadWorkPhaseV1 restrictions(List<RestrictionV1> restrictions) {
    
    this.restrictions = restrictions;
    return this;
  }

  public RoadWorkPhaseV1 addRestrictionsItem(RestrictionV1 restrictionsItem) {
    if (this.restrictions == null) {
      this.restrictions = new ArrayList<>();
    }
    this.restrictions.add(restrictionsItem);
    return this;
  }

   /**
   * Restrictions on traffic
   * @return restrictions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Restrictions on traffic")
  @JsonProperty(JSON_PROPERTY_RESTRICTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<RestrictionV1> getRestrictions() {
    return restrictions;
  }


  @JsonProperty(JSON_PROPERTY_RESTRICTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRestrictions(List<RestrictionV1> restrictions) {
    this.restrictions = restrictions;
  }


  public RoadWorkPhaseV1 restrictionsLiftable(Boolean restrictionsLiftable) {
    
    this.restrictionsLiftable = restrictionsLiftable;
    return this;
  }

   /**
   * Restrictions can be lifted for abnormal transports
   * @return restrictionsLiftable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Restrictions can be lifted for abnormal transports")
  @JsonProperty(JSON_PROPERTY_RESTRICTIONS_LIFTABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getRestrictionsLiftable() {
    return restrictionsLiftable;
  }


  @JsonProperty(JSON_PROPERTY_RESTRICTIONS_LIFTABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRestrictionsLiftable(Boolean restrictionsLiftable) {
    this.restrictionsLiftable = restrictionsLiftable;
  }


  public RoadWorkPhaseV1 severity(SeverityEnum severity) {
    
    this.severity = severity;
    return this;
  }

   /**
   * Severity of the disruption to traffic. How severely this road work phase disrupts traffic. LOW - no disruption, HIGH - disruption, HIGHEST - significant disruption
   * @return severity
  **/
 
  @ApiModelProperty(required = true, value = "Severity of the disruption to traffic. How severely this road work phase disrupts traffic. LOW - no disruption, HIGH - disruption, HIGHEST - significant disruption")
  @JsonProperty(JSON_PROPERTY_SEVERITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SeverityEnum getSeverity() {
    return severity;
  }


  @JsonProperty(JSON_PROPERTY_SEVERITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSeverity(SeverityEnum severity) {
    this.severity = severity;
  }


  public RoadWorkPhaseV1 slowTrafficTimes(List<WeekdayTimePeriodV1> slowTrafficTimes) {
    
    this.slowTrafficTimes = slowTrafficTimes;
    return this;
  }

  public RoadWorkPhaseV1 addSlowTrafficTimesItem(WeekdayTimePeriodV1 slowTrafficTimesItem) {
    if (this.slowTrafficTimes == null) {
      this.slowTrafficTimes = new ArrayList<>();
    }
    this.slowTrafficTimes.add(slowTrafficTimesItem);
    return this;
  }

   /**
   * Time periods when the road work is expected to cause slow moving traffic.
   * @return slowTrafficTimes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Time periods when the road work is expected to cause slow moving traffic.")
  @JsonProperty(JSON_PROPERTY_SLOW_TRAFFIC_TIMES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<WeekdayTimePeriodV1> getSlowTrafficTimes() {
    return slowTrafficTimes;
  }


  @JsonProperty(JSON_PROPERTY_SLOW_TRAFFIC_TIMES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSlowTrafficTimes(List<WeekdayTimePeriodV1> slowTrafficTimes) {
    this.slowTrafficTimes = slowTrafficTimes;
  }


  public RoadWorkPhaseV1 queuingTrafficTimes(List<WeekdayTimePeriodV1> queuingTrafficTimes) {
    
    this.queuingTrafficTimes = queuingTrafficTimes;
    return this;
  }

  public RoadWorkPhaseV1 addQueuingTrafficTimesItem(WeekdayTimePeriodV1 queuingTrafficTimesItem) {
    if (this.queuingTrafficTimes == null) {
      this.queuingTrafficTimes = new ArrayList<>();
    }
    this.queuingTrafficTimes.add(queuingTrafficTimesItem);
    return this;
  }

   /**
   * Time periods when the road work is expected to cause queuing of the traffic.
   * @return queuingTrafficTimes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Time periods when the road work is expected to cause queuing of the traffic.")
  @JsonProperty(JSON_PROPERTY_QUEUING_TRAFFIC_TIMES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<WeekdayTimePeriodV1> getQueuingTrafficTimes() {
    return queuingTrafficTimes;
  }


  @JsonProperty(JSON_PROPERTY_QUEUING_TRAFFIC_TIMES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQueuingTrafficTimes(List<WeekdayTimePeriodV1> queuingTrafficTimes) {
    this.queuingTrafficTimes = queuingTrafficTimes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoadWorkPhaseV1 roadWorkPhaseV1 = (RoadWorkPhaseV1) o;
    return Objects.equals(this.id, roadWorkPhaseV1.id) &&
        Objects.equals(this.location, roadWorkPhaseV1.location) &&
        Objects.equals(this.locationDetails, roadWorkPhaseV1.locationDetails) &&
        Objects.equals(this.workingHours, roadWorkPhaseV1.workingHours) &&
        Objects.equals(this.comment, roadWorkPhaseV1.comment) &&
        Objects.equals(this.timeAndDuration, roadWorkPhaseV1.timeAndDuration) &&
        Objects.equals(this.workTypes, roadWorkPhaseV1.workTypes) &&
        Objects.equals(this.restrictions, roadWorkPhaseV1.restrictions) &&
        Objects.equals(this.restrictionsLiftable, roadWorkPhaseV1.restrictionsLiftable) &&
        Objects.equals(this.severity, roadWorkPhaseV1.severity) &&
        Objects.equals(this.slowTrafficTimes, roadWorkPhaseV1.slowTrafficTimes) &&
        Objects.equals(this.queuingTrafficTimes, roadWorkPhaseV1.queuingTrafficTimes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, location, locationDetails, workingHours, comment, timeAndDuration, workTypes, restrictions, restrictionsLiftable, severity, slowTrafficTimes, queuingTrafficTimes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoadWorkPhaseV1 {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    locationDetails: ").append(toIndentedString(locationDetails)).append("\n");
    sb.append("    workingHours: ").append(toIndentedString(workingHours)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    timeAndDuration: ").append(toIndentedString(timeAndDuration)).append("\n");
    sb.append("    workTypes: ").append(toIndentedString(workTypes)).append("\n");
    sb.append("    restrictions: ").append(toIndentedString(restrictions)).append("\n");
    sb.append("    restrictionsLiftable: ").append(toIndentedString(restrictionsLiftable)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    slowTrafficTimes: ").append(toIndentedString(slowTrafficTimes)).append("\n");
    sb.append("    queuingTrafficTimes: ").append(toIndentedString(queuingTrafficTimes)).append("\n");
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

