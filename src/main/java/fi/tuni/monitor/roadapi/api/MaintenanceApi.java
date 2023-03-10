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

package fi.tuni.monitor.roadapi.api;

import com.fasterxml.jackson.core.type.TypeReference;

import fi.tuni.monitor.roadapi.*;
import fi.tuni.monitor.roadapi.model.*;

import fi.tuni.monitor.roadapi.model.MaintenanceTrackingDomainDtoV1;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingFeatureCollectionV1;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingFeatureV1;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingLatestFeatureCollectionV1;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingTaskDtoV1;
import java.time.OffsetDateTime;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaintenanceApi {
  private ApiClient apiClient;

  public MaintenanceApi() {
    this(Configuration.getDefaultApiClient());
  }

  public MaintenanceApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Road maintenance tracking routes latest points
   * 
   * @param endFrom Return routes which have completed onwards from the given time (inclusive). Default is -1h from now and maximum -24h. (optional)
   * @param xMin Minimum x coordinate (longitude) Coordinates are in WGS84 format in decimal degrees. Values between 19.0 and 32.0. (optional, default to 19)
   * @param yMin Minimum y coordinate (latitude). Coordinates are in WGS84 format in decimal degrees. Values between 59.0 and 72.0. (optional, default to 59)
   * @param xMax Maximum x coordinate (longitude). Coordinates are in WGS84 format in decimal degrees. Values between 19.0 and 32.0. (optional, default to 32)
   * @param yMax Maximum y coordinate (latitude). Coordinates are in WGS84 format in decimal degrees. Values between 59.0 and 72.0. (optional, default to 72)
   * @param taskId Task ids to include. Any route containing one of the selected tasks will be returned. (optional
   * @param domain Data domains. If domain is not given default value of \&quot;state-roads\&quot; will be used. (optional
   * @return MaintenanceTrackingLatestFeatureCollectionV1
   * @throws ApiException if fails to make API call
   */
  public MaintenanceTrackingLatestFeatureCollectionV1 findLatestMaintenanceTrackings2(OffsetDateTime endFrom, Double xMin, Double yMin, Double xMax, Double yMax, List<String> taskId, List<String> domain) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/maintenance/v1/tracking/routes/latest";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("endFrom", endFrom));
    localVarQueryParams.addAll(apiClient.parameterToPair("xMin", xMin));
    localVarQueryParams.addAll(apiClient.parameterToPair("yMin", yMin));
    localVarQueryParams.addAll(apiClient.parameterToPair("xMax", xMax));
    localVarQueryParams.addAll(apiClient.parameterToPair("yMax", yMax));
    localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "taskId", taskId));
    localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "domain", domain));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<MaintenanceTrackingLatestFeatureCollectionV1> localVarReturnType = new TypeReference<MaintenanceTrackingLatestFeatureCollectionV1>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }
  /**
   * Road maintenance tracking routes
   * 
   * @param endFrom Return routes which have completed onwards from the given time (inclusive). Default is 24h in past and maximum interval between from and to is 24h. (optional)
   * @param endBefore Return routes which have completed before the given end time (exclusive). Default is now and maximum interval between from and to is 24h. (optional)
   * @param createdAfter Return routes which have been created after the given time (exclusive). Maximum interval between createdFrom and createdTo is 24h. (optional)
   * @param createdBefore Return routes which have been created before the given time (exclusive). Maximum interval between createdFrom and createdTo is 24h. (optional)
   * @param xMin Minimum x coordinate (longitude) Coordinates are in WGS84 format in decimal degrees. Values between 19.0 and 32.0. (optional, default to 19)
   * @param yMin Minimum y coordinate (latitude). Coordinates are in WGS84 format in decimal degrees. Values between 59.0 and 72.0. (optional, default to 59)
   * @param xMax Maximum x coordinate (longitude). Coordinates are in WGS84 format in decimal degrees. Values between 19.0 and 32.0. (optional, default to 32)
   * @param yMax Maximum y coordinate (latitude). Coordinates are in WGS84 format in decimal degrees. Values between 59.0 and 72.0. (optional, default to 72)
   * @param taskId Task ids to include. Any tracking containing one of the selected tasks will be returned. (optional
   * @param domain Data domains. If domain is not given default value of \&quot;state-roads\&quot; will be used. (optional
   * @return MaintenanceTrackingFeatureCollectionV1
   * @throws ApiException if fails to make API call
   */
  public MaintenanceTrackingFeatureCollectionV1 findMaintenanceTrackings2(OffsetDateTime endFrom, OffsetDateTime endBefore, OffsetDateTime createdAfter, OffsetDateTime createdBefore, Double xMin, Double yMin, Double xMax, Double yMax, List<String> taskId, List<String> domain) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/maintenance/v1/tracking/routes";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (endFrom != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("endFrom", endFrom.toInstant()));
    }
    if (endBefore != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("endBefore", endBefore.toInstant()));
    }
    if (createdAfter != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("createdAfter", createdAfter.toInstant()));
    }
    if (createdBefore != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("createdBefore", createdBefore.toInstant()));
    }

    localVarQueryParams.addAll(apiClient.parameterToPair("xMin", xMin));
    localVarQueryParams.addAll(apiClient.parameterToPair("yMin", yMin));
    localVarQueryParams.addAll(apiClient.parameterToPair("xMax", xMax));
    localVarQueryParams.addAll(apiClient.parameterToPair("yMax", yMax));
    localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "taskId", taskId));
    localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "domain", domain));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<MaintenanceTrackingFeatureCollectionV1> localVarReturnType = new TypeReference<MaintenanceTrackingFeatureCollectionV1>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }
  /**
   * Road maintenance tracking route with tracking id
   * 
   * @param id Tracking id (required)
   * @return MaintenanceTrackingFeatureV1
   * @throws ApiException if fails to make API call
   */
  public MaintenanceTrackingFeatureV1 getMaintenanceTracking2(Long id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getMaintenanceTracking2");
    }
    
    // create path and map variables
    String localVarPath = "/api/maintenance/v1/tracking/routes/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<MaintenanceTrackingFeatureV1> localVarReturnType = new TypeReference<MaintenanceTrackingFeatureV1>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }
  /**
   * Road maintenance tracking domains
   * 
   * @return List&lt;MaintenanceTrackingDomainDtoV1&gt;
   * @throws ApiException if fails to make API call
   */
  public List<MaintenanceTrackingDomainDtoV1> getMaintenanceTrackingDomains() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/maintenance/v1/tracking/domains";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<List<MaintenanceTrackingDomainDtoV1>> localVarReturnType = new TypeReference<List<MaintenanceTrackingDomainDtoV1>>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }
  /**
   * Road maintenance tracking tasks
   * 
   * @return List&lt;MaintenanceTrackingTaskDtoV1&gt;
   * @throws ApiException if fails to make API call
   */
  public List<MaintenanceTrackingTaskDtoV1> getMaintenanceTrackingTasks2() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/maintenance/v1/tracking/tasks";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<List<MaintenanceTrackingTaskDtoV1>> localVarReturnType = new TypeReference<List<MaintenanceTrackingTaskDtoV1>>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }
}
