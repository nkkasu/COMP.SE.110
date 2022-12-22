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

import fi.tuni.monitor.roadapi.model.CameraStationFeatureCollection;
import fi.tuni.monitor.roadapi.model.ForecastSectionFeatureCollectionOldV2;
import fi.tuni.monitor.roadapi.model.LocationFeatureCollection;
import fi.tuni.monitor.roadapi.model.LocationTypesMetadata;
import fi.tuni.monitor.roadapi.model.LocationVersion;
import fi.tuni.monitor.roadapi.model.TmsRoadStationsSensorsMetadata;
import fi.tuni.monitor.roadapi.model.TmsStationFeature;
import fi.tuni.monitor.roadapi.model.TmsStationFeatureCollection;
import fi.tuni.monitor.roadapi.model.V3VariableSignDescriptions;
import fi.tuni.monitor.roadapi.model.WeatherRoadStationsSensorsMetadata;
import fi.tuni.monitor.roadapi.model.WeatherStationFeatureCollection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetadataV3Api {
  private ApiClient apiClient;

  public MetadataV3Api() {
    this(Configuration.getDefaultApiClient());
  }

  public MetadataV3Api(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * The static information of weather camera presets
   * 
   * @param lastUpdated If parameter is given result will only contain update status. (optional, default to false)
   * @return CameraStationFeatureCollection
   * @throws ApiException if fails to make API call
   */
  public CameraStationFeatureCollection cameraStations(Boolean lastUpdated) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/camera-stations";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("lastUpdated", lastUpdated));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<CameraStationFeatureCollection> localVarReturnType = new TypeReference<CameraStationFeatureCollection>() {};
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
   * The static information of weather forecast sections
   * 
   * @param lastUpdated If parameter is given result will only contain update status. (optional, default to false)
   * @param naturalIds List of forecast section indices (optional
   * @return ForecastSectionFeatureCollectionOldV2
   * @throws ApiException if fails to make API call
   */
  public ForecastSectionFeatureCollectionOldV2 forecastSections(Boolean lastUpdated, List<String> naturalIds) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/forecast-sections";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("lastUpdated", lastUpdated));
    localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "naturalIds", naturalIds));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<ForecastSectionFeatureCollectionOldV2> localVarReturnType = new TypeReference<ForecastSectionFeatureCollectionOldV2>() {};
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
   * The static information of weather forecast sections by road number
   * 
   * @param roadNumber  (required)
   * @return ForecastSectionFeatureCollectionOldV2
   * @throws ApiException if fails to make API call
   */
  public ForecastSectionFeatureCollectionOldV2 forecastSections1(Integer roadNumber) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'roadNumber' is set
    if (roadNumber == null) {
      throw new ApiException(400, "Missing the required parameter 'roadNumber' when calling forecastSections1");
    }
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/forecast-sections/{roadNumber}"
      .replaceAll("\\{" + "roadNumber" + "\\}", apiClient.escapeString(roadNumber.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<ForecastSectionFeatureCollectionOldV2> localVarReturnType = new TypeReference<ForecastSectionFeatureCollectionOldV2>() {};
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
   * The static information of weather forecast sections by bounding box
   * 
   * @param minLongitude Minimum longitude. Coordinates are in WGS84 format in decimal degrees. (required)
   * @param minLatitude Minimum latitude. Coordinates are in WGS84 format in decimal degrees. (required)
   * @param maxLongitude Maximum longitude. Coordinates are in WGS84 format in decimal degrees. (required)
   * @param maxLatitude Minimum latitude. Coordinates are in WGS84 format in decimal degrees. (required)
   * @return ForecastSectionFeatureCollectionOldV2
   * @throws ApiException if fails to make API call
   */
  public ForecastSectionFeatureCollectionOldV2 forecastSections2(Double minLongitude, Double minLatitude, Double maxLongitude, Double maxLatitude) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'minLongitude' is set
    if (minLongitude == null) {
      throw new ApiException(400, "Missing the required parameter 'minLongitude' when calling forecastSections2");
    }
    
    // verify the required parameter 'minLatitude' is set
    if (minLatitude == null) {
      throw new ApiException(400, "Missing the required parameter 'minLatitude' when calling forecastSections2");
    }
    
    // verify the required parameter 'maxLongitude' is set
    if (maxLongitude == null) {
      throw new ApiException(400, "Missing the required parameter 'maxLongitude' when calling forecastSections2");
    }
    
    // verify the required parameter 'maxLatitude' is set
    if (maxLatitude == null) {
      throw new ApiException(400, "Missing the required parameter 'maxLatitude' when calling forecastSections2");
    }
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/forecast-sections/{minLongitude}/{minLatitude}/{maxLongitude}/{maxLatitude}"
      .replaceAll("\\{" + "minLongitude" + "\\}", apiClient.escapeString(minLongitude.toString()))
      .replaceAll("\\{" + "minLatitude" + "\\}", apiClient.escapeString(minLatitude.toString()))
      .replaceAll("\\{" + "maxLongitude" + "\\}", apiClient.escapeString(maxLongitude.toString()))
      .replaceAll("\\{" + "maxLatitude" + "\\}", apiClient.escapeString(maxLatitude.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<ForecastSectionFeatureCollectionOldV2> localVarReturnType = new TypeReference<ForecastSectionFeatureCollectionOldV2>() {};
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
   * Return all code descriptions.
   * 
   * @return V3VariableSignDescriptions
   * @throws ApiException if fails to make API call
   */
  public V3VariableSignDescriptions listCodeDescriptions1() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/variable-signs/code-descriptions";

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

    TypeReference<V3VariableSignDescriptions> localVarReturnType = new TypeReference<V3VariableSignDescriptions>() {};
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
   * The static information of location types and locationsubtypes
   * 
   * @param version If parameter is given use this version. (optional, default to latest)
   * @param lastUpdated If parameter is given result will only contain update status. (optional, default to false)
   * @return LocationTypesMetadata
   * @throws ApiException if fails to make API call
   */
  public LocationTypesMetadata locationTypes(String version, Boolean lastUpdated) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/location-types";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("version", version));
    localVarQueryParams.addAll(apiClient.parameterToPair("lastUpdated", lastUpdated));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<LocationTypesMetadata> localVarReturnType = new TypeReference<LocationTypesMetadata>() {};
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
   * List available location versions
   * 
   * @return List&lt;LocationVersion&gt;
   * @throws ApiException if fails to make API call
   */
  public List<LocationVersion> locationVersions() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/location-versions";

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

    TypeReference<List<LocationVersion>> localVarReturnType = new TypeReference<List<LocationVersion>>() {};
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
   * The static information of locations
   * 
   * @param version If parameter is given use this version. (optional, default to latest)
   * @param lastUpdated If parameter is given result will only contain update status. (optional, default to false)
   * @return LocationFeatureCollection
   * @throws ApiException if fails to make API call
   */
  public LocationFeatureCollection locations(String version, Boolean lastUpdated) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/locations";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("version", version));
    localVarQueryParams.addAll(apiClient.parameterToPair("lastUpdated", lastUpdated));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<LocationFeatureCollection> localVarReturnType = new TypeReference<LocationFeatureCollection>() {};
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
   * The static information of one location
   * 
   * @param id  (required)
   * @param version If parameter is given use this version. (optional, default to latest)
   * @return LocationFeatureCollection
   * @throws ApiException if fails to make API call
   */
  public LocationFeatureCollection locationsById(Integer id, String version) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling locationsById");
    }
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/locations/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("version", version));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<LocationFeatureCollection> localVarReturnType = new TypeReference<LocationFeatureCollection>() {};
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
   * The static information of available sensors of TMS stations (Traffic Measurement System / LAM)
   * 
   * @param lastUpdated If parameter is given result will only contain update status. (optional, default to false)
   * @return TmsRoadStationsSensorsMetadata
   * @throws ApiException if fails to make API call
   */
  public TmsRoadStationsSensorsMetadata tmsSensors(Boolean lastUpdated) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/tms-sensors";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("lastUpdated", lastUpdated));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<TmsRoadStationsSensorsMetadata> localVarReturnType = new TypeReference<TmsRoadStationsSensorsMetadata>() {};
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
   * The static information of TMS stations (Traffic Measurement System / LAM)
   * 
   * @param lastUpdated If parameter is given result will only contain update status. (optional, default to false)
   * @param state Return TMS stations of given state. (optional, default to active)
   * @return TmsStationFeatureCollection
   * @throws ApiException if fails to make API call
   */
  public TmsStationFeatureCollection tmsStations(Boolean lastUpdated, String state) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/tms-stations";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("lastUpdated", lastUpdated));
    localVarQueryParams.addAll(apiClient.parameterToPair("state", state));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<TmsStationFeatureCollection> localVarReturnType = new TypeReference<TmsStationFeatureCollection>() {};
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
   * The static information of TMS stations of given road (Traffic Measurement System / LAM)
   * 
   * @param number  (required)
   * @param state Return TMS stations of given state. (optional, default to active)
   * @return TmsStationFeatureCollection
   * @throws ApiException if fails to make API call
   */
  public TmsStationFeatureCollection tmsStationsByRoadNumber(Integer number, String state) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'number' is set
    if (number == null) {
      throw new ApiException(400, "Missing the required parameter 'number' when calling tmsStationsByRoadNumber");
    }
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/tms-stations/road-number/{number}"
      .replaceAll("\\{" + "number" + "\\}", apiClient.escapeString(number.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("state", state));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<TmsStationFeatureCollection> localVarReturnType = new TypeReference<TmsStationFeatureCollection>() {};
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
   * The static information of one TMS station (Traffic Measurement System / LAM)
   * 
   * @param id  (required)
   * @return TmsStationFeature
   * @throws ApiException if fails to make API call
   */
  public TmsStationFeature tmsStationsByRoadStationId(Long id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling tmsStationsByRoadStationId");
    }
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/tms-stations/road-station-id/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<TmsStationFeature> localVarReturnType = new TypeReference<TmsStationFeature>() {};
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
   * The static information of one TMS station (Traffic Measurement System / LAM).
   * 
   * @param number  (required)
   * @return TmsStationFeature
   * @throws ApiException if fails to make API call
   */
  public TmsStationFeature tmsStationsByTmsNumber(Long number) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'number' is set
    if (number == null) {
      throw new ApiException(400, "Missing the required parameter 'number' when calling tmsStationsByTmsNumber");
    }
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/tms-stations/tms-number/{number}"
      .replaceAll("\\{" + "number" + "\\}", apiClient.escapeString(number.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<TmsStationFeature> localVarReturnType = new TypeReference<TmsStationFeature>() {};
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
   * The static information of available sensors of weather stations
   * 
   * @param lastUpdated If parameter is given result will only contain update status. (optional, default to false)
   * @return WeatherRoadStationsSensorsMetadata
   * @throws ApiException if fails to make API call
   */
  public WeatherRoadStationsSensorsMetadata weatherSensors(Boolean lastUpdated) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/weather-sensors";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("lastUpdated", lastUpdated));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<WeatherRoadStationsSensorsMetadata> localVarReturnType = new TypeReference<WeatherRoadStationsSensorsMetadata>() {};
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
   * The static information of weather stations
   * 
   * @param lastUpdated If parameter is given result will only contain update status. (optional, default to false)
   * @return WeatherStationFeatureCollection
   * @throws ApiException if fails to make API call
   */
  public WeatherStationFeatureCollection weatherStations(Boolean lastUpdated) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v3/metadata/weather-stations";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("lastUpdated", lastUpdated));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=UTF-8", "application/geo+json;charset=UTF-8", "application/vnd.geo+json;charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<WeatherStationFeatureCollection> localVarReturnType = new TypeReference<WeatherStationFeatureCollection>() {};
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
