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

import fi.tuni.monitor.roadapi.ApiException;
import fi.tuni.monitor.roadapi.ApiClient;
import fi.tuni.monitor.roadapi.Configuration;
import fi.tuni.monitor.roadapi.model.*;
import fi.tuni.monitor.roadapi.Pair;

import fi.tuni.monitor.roadapi.model.D2LogicalModel;
import java.time.OffsetDateTime;
import fi.tuni.monitor.roadapi.model.RoadStationState;
import fi.tuni.monitor.roadapi.model.WeatherSensorValueHistoryDto;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BetaApi {
  private ApiClient apiClient;

  public BetaApi() {
    this(Configuration.getDefaultApiClient());
  }

  public BetaApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Current data of TMS Stations in Datex2 format (Traffic Measurement System / LAM)
   * 
   * @return D2LogicalModel
   * @throws ApiException if fails to make API call
   */
  public D2LogicalModel tmsDataDatex2() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/beta/tms-data-datex2";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/xml;charset=UTF-8", "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<D2LogicalModel> localVarReturnType = new TypeReference<D2LogicalModel>() {};
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
   * The static information of TMS stations in Datex2 format (Traffic Measurement System / LAM)
   * 
   * @param state Return TMS stations of given state. (optional, default to ACTIVE)
   * @return D2LogicalModel
   * @throws ApiException if fails to make API call
   */
  public D2LogicalModel tmsStationsDatex2(RoadStationState state) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/beta/tms-stations-datex2";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("state", state));

    
    
    
    final String[] localVarAccepts = {
      "application/xml;charset=UTF-8", "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<D2LogicalModel> localVarReturnType = new TypeReference<D2LogicalModel>() {};
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
   * List the history of sensor values from the weather road station
   * 
   * @param stationId Weather station id (required)
   * @param from Fetch history after given date time (optional)
   * @param to Limit history to given date time (optional)
   * @return List&lt;WeatherSensorValueHistoryDto&gt;
   * @throws ApiException if fails to make API call
   */
  public List<WeatherSensorValueHistoryDto> weatherDataHistory(Long stationId, OffsetDateTime from, OffsetDateTime to) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'stationId' is set
    if (stationId == null) {
      throw new ApiException(400, "Missing the required parameter 'stationId' when calling weatherDataHistory");
    }
    
    // create path and map variables
    String localVarPath = "/api/beta/weather-history-data/{stationId}"
      .replaceAll("\\{" + "stationId" + "\\}", apiClient.escapeString(stationId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("from", from));
    localVarQueryParams.addAll(apiClient.parameterToPair("to", to));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<List<WeatherSensorValueHistoryDto>> localVarReturnType = new TypeReference<List<WeatherSensorValueHistoryDto>>() {};
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
   * List the history of sensor value from the weather road station
   * 
   * @param stationId Weather Station id (required)
   * @param sensorId Sensor id (required)
   * @param from Fetch history after given time (optional)
   * @return List&lt;WeatherSensorValueHistoryDto&gt;
   * @throws ApiException if fails to make API call
   */
  public List<WeatherSensorValueHistoryDto> weatherDataHistory1(Long stationId, Long sensorId, OffsetDateTime from) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'stationId' is set
    if (stationId == null) {
      throw new ApiException(400, "Missing the required parameter 'stationId' when calling weatherDataHistory1");
    }
    
    // verify the required parameter 'sensorId' is set
    if (sensorId == null) {
      throw new ApiException(400, "Missing the required parameter 'sensorId' when calling weatherDataHistory1");
    }
    
    // create path and map variables
    String localVarPath = "/api/beta/weather-history-data/{stationId}/{sensorId}"
      .replaceAll("\\{" + "stationId" + "\\}", apiClient.escapeString(stationId.toString()))
      .replaceAll("\\{" + "sensorId" + "\\}", apiClient.escapeString(sensorId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("from", from));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<List<WeatherSensorValueHistoryDto>> localVarReturnType = new TypeReference<List<WeatherSensorValueHistoryDto>>() {};
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