package fi.tuni.monitor.weatherapi;

import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.data.WeatherData;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A class for fetching weather data from FMI API
 */
public class WeatherFetcher {
    private static final String WEATHERNODE = "BsWfs:BsWfsElement";
    private static final String PARAMETERNAME = "BsWfs:ParameterName";
    private static final String PARAMETERVALUE = "BsWfs:ParameterValue";
    private static final String GMLPOSITION = "gml:pos";
    private static final String TIME = "BsWfs:Time";
    private static final String IDATTRIBUTE = "gml:id";
    private static final int TIMESTEP_HOUR = 60;

    LocalDateTime startTime = null;
    LocalDateTime endTime = null;
    List<WeatherData> weatherItems = new ArrayList<>();

    public SortedMap<String, String> getQueries(String url) {
        TreeMap<String, String> queryPairs = new TreeMap<>();
        String[] pairs = url.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            queryPairs.put(URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8),
                    URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8));
        }
        return queryPairs;
    }

    public void setTimes(SortedMap<String, String> tMap) {
        if (tMap.get("starttime") != null) {
            startTime = LocalDateTime
                    .parse(tMap.get("starttime"),
                            DateTimeFormatter.ISO_DATE_TIME);
        }
        if (tMap.get("endtime") != null) {
            startTime = LocalDateTime
                    .parse(tMap.get("endtime"),
                            DateTimeFormatter.ISO_DATE_TIME);
        }
    }
    public LocalDateTime getStartTime() {
        return this.startTime;
    }
    public LocalDateTime getEndTime() {
        return this.endTime;
    }
    public boolean checkIsForecast(SortedMap<String, String> tMap) {
        return tMap.get("storedquery_id").contains("fmi::forecast::harmonie");
    }

    public void setParamValues(String parameterName, String paramValue, WeatherData wd) {
        Double paramDbl = Double.parseDouble(paramValue);
        if (paramDbl.isNaN()) return;

        switch (parameterName.toLowerCase()) {
            case "t2m", "ta_pt1h_avg", "temperature", "tday" -> wd.setTemperatureAvg(paramDbl);
            case "n_man" -> wd.setCloudiness(paramDbl);
            case "ws_10min", "windspeedms" -> wd.setWindSpeed(paramDbl);

            case "tmax", "ta_pt1h_max" -> wd.setMaxTemperature(paramDbl);
            case "tmin", "ta_pt1h_min" -> wd.setMinTemperature(paramDbl);

        }
    }

    /**
     * Fetches weather data from FMI API from the given URL. Forms WeatherData objects from the fetched data.
     * @param url The URL to fetch data from
     * @return List of WeatherData objects
     */
    public List<WeatherData> getWeatherData(String url) {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);
            doc.getDocumentElement().normalize();

            SortedMap<String, String> queryPairs = getQueries(url);

            boolean isForecast = checkIsForecast(queryPairs);
            weatherItems = new ArrayList<>();

            NodeList nList = doc.getElementsByTagName(WEATHERNODE);
            int prev = 1;

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String s = eElement.getAttribute(IDATTRIBUTE);
                    String[] idValues = s.split("\\.");
                    int current = Integer.parseInt(idValues[3]);
                    if (current <= prev) {
                        WeatherData wd = new WeatherData();
                        if (isForecast) {
                            wd.setToForeCast();
                        }
                        weatherItems.add(wd);
                    }
                    WeatherData wd = weatherItems.get(weatherItems.size() - 1);
                    prev = current;

                    String parameterName = eElement
                            .getElementsByTagName(PARAMETERNAME)
                            .item(0)
                            .getTextContent();
                    String paramValue = eElement
                            .getElementsByTagName(PARAMETERVALUE)
                            .item(0)
                            .getTextContent();
                    wd.setPos(eElement
                            .getElementsByTagName(GMLPOSITION)
                            .item(0)
                            .getTextContent());
                    wd.setTime(LocalDateTime
                            .parse(eElement.getElementsByTagName(TIME)
                                            .item(0)
                                            .getTextContent(),
                                    DateTimeFormatter.ISO_DATE_TIME));
                    setParamValues(parameterName, paramValue, wd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.weatherItems;
    }

    /**
     * Fetches daily weather data from FMI API from given time period and coordinates
     * @param start Start time of the time period to fetch data from
     * @param end End time of the time period to fetch data from
     * @param coords Bounding coordinates for the area to fetch data from
     * @return List of WeatherData objects. One object for each day in the time period.
     */
    public List<WeatherData> getDailyWeatherData(LocalDateTime start, LocalDateTime end,
                                                 BoundingCoordinates coords) {
        List<WeatherData> weathers = new ArrayList<>();
        String coordsString1 = coords.minLon() + "," + coords.minLat() + ","
                + coords.maxLon() + "," + coords.maxLat();
        String coordsString2 = (coords.minLat() + coords.maxLat()) / 2 + "," +
                (coords.minLon() + coords.maxLon()) / 2;

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime observationEnd = end;
        LocalDateTime forecastStart = start;

        if (start.isBefore(now)) {
            if (end.isAfter(now))
                observationEnd = now.toLocalDate().atStartOfDay().plusDays(1).minusMinutes(1);
            weathers.addAll(getPastCloudAndWindData(start, observationEnd, coordsString1));
            weathers.addAll(getPastTemperatureData(start, observationEnd, coordsString1));
        }
        if (end.isAfter(now)) {
            if (start.isBefore(now)) {
                forecastStart = now.toLocalDate().atStartOfDay();
            }
            weathers.addAll(getForecasts(forecastStart, end, coordsString2, 6*TIMESTEP_HOUR));
        }

        weathers = calculateAverages(weathers, true);
        return weathers;
    }

    /**
     * Fetches hourly weather data from FMI API from given time period and coordinates.
     * @param start Start time of the time period to fetch data from
     * @param end End time of the time period to fetch data from
     * @param coords Bounding coordinates for the area to fetch data from
     * @return List of WeatherData objects. One object for each hour in the time period.
     */
    public List<WeatherData> getHourlyForecastWeatherData(LocalDateTime start, LocalDateTime end,
                                                          BoundingCoordinates coords) {
        String coordsString = (coords.minLat() + coords.maxLat()) / 2 + "," +
                (coords.minLon() + coords.maxLon()) / 2;

        LocalDateTime forecastStart = start.truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime forecastEnd = end.truncatedTo(ChronoUnit.SECONDS);

        List<WeatherData> weathers = getForecasts(forecastStart, forecastEnd, coordsString, TIMESTEP_HOUR);

        weathers = calculateAverages(weathers, false);
        return weathers;
    }

    /**
     * Calculates average weathers from the given WeatherData objects
     * @param weathers List of WeatherData objects to calculate averages from
     * @param daily If true forms one WeatherData object for each day in the time period.
     *              If false forms one WeatherData object for each hour in the time period.
     * @return List of average WeatherData objects
     */
    private List<WeatherData> calculateAverages(List<WeatherData> weathers, boolean daily) {
        Map<Object, List<WeatherData>> weatherMap;
        if (daily) {
            weatherMap = weathers.stream().collect(Collectors.groupingBy(
                    item -> new Day((Date.from(item.getTime().atZone(ZoneId.systemDefault()).toInstant())))));
        } else {
            weatherMap = weathers.stream().collect(Collectors.groupingBy(
                    item -> new Hour((Date.from(item.getTime().atZone(ZoneId.systemDefault()).toInstant())))));
        }

        ArrayList<WeatherData> averageWeathers = new ArrayList<>();

        for (var weatherList : weatherMap.values()) {
            ArrayList<Double> avgTempList = new ArrayList<>();
            ArrayList<Double> maxTempList = new ArrayList<>();
            ArrayList<Double> minTempList = new ArrayList<>();
            ArrayList<Double> windSpeedList = new ArrayList<>();
            ArrayList<Double> cloudinessList = new ArrayList<>();

            for (var weatherItem : weatherList) {
                Double avgTemp = weatherItem.getTemperatureAvg();
                Double maxTemp = weatherItem.getMaxTemperature();
                Double minTemp = weatherItem.getMinTemperature();
                Double windSpeed = weatherItem.getWindSpeed();
                Double cloudiness = weatherItem.getCloudiness();

                if (avgTemp != null) avgTempList.add(avgTemp);
                if (maxTemp != null) maxTempList.add(maxTemp);
                if (minTemp != null) minTempList.add(minTemp);
                if (windSpeed != null) windSpeedList.add(windSpeed);
                if (cloudiness != null) cloudinessList.add(cloudiness);
            }

            WeatherData avgWeather = new WeatherData();
            avgWeather.setTime(weatherList.get(0).getTime());
            if (weatherList.get(0).getIsObservation()) avgWeather.setToObservation();

            if (!avgTempList.isEmpty()) {
                avgWeather.setTemperatureAvg(avgTempList.stream().collect(Collectors.averagingDouble(d -> d)));
            }
            if (!maxTempList.isEmpty()) {
                avgWeather.setMaxTemperature(maxTempList.stream().collect(Collectors.averagingDouble(d -> d)));
            }
            if (!minTempList.isEmpty()) {
                avgWeather.setMinTemperature(minTempList.stream().collect(Collectors.averagingDouble(d -> d)));
            }
            if (!windSpeedList.isEmpty()) {
                avgWeather.setWindSpeed(windSpeedList.stream().collect(Collectors.averagingDouble(d -> d)));
            }
            if (!cloudinessList.isEmpty()) {
                avgWeather.setCloudiness(cloudinessList.stream().collect(Collectors.averagingDouble(d -> d)));
            }

            averageWeathers.add(avgWeather);
        }

        return averageWeathers;
    }

    /**
     * Fetches observed cloudiness and wind speed from FMI API from the given time period and coordinates
     * @param start Start time of the time period to fetch data from
     * @param end End time of the time period to fetch data from
     * @param coordsString Coordinate area as a string in the form MinLon,MinLat,MaxLon,MaxLat
     * @return List of WeatherData objects
     */
    private ArrayList<WeatherData> getPastCloudAndWindData (LocalDateTime start, LocalDateTime end,
                                                            String coordsString) {
        ArrayList<WeatherData> weathers = new ArrayList<>();
        LocalDateTime tempStartTime = start;

        String url = "https://opendata.fmi.fi/wfs?request=getFeature&version=2.0.0" +
                "&storedquery_id=fmi::observations::weather::simple" +
                "&bbox=" + coordsString +
                "&timestep=" + 6*TIMESTEP_HOUR +
                "&parameters=ws_10min,n_man";

        while (tempStartTime.isBefore(end)) {
            String startTimeStr = tempStartTime.toString();
            String endTimeStr = "";
            if (tempStartTime.plusDays(7).isBefore(end)) {
                endTimeStr = tempStartTime.plusDays(7).toString();
            } else {
                endTimeStr = end.toString();
            }
            String fullUrl = url + "&starttime=" + startTimeStr + "&endtime=" + endTimeStr;

            weathers.addAll(getWeatherData(fullUrl));

            tempStartTime = tempStartTime.plusDays(7);
        }

        return weathers;
    }

    /**
     * Fetches observed daily average, minimum and maximum temperatures from FMI API from the given
     * time period and coordinates
     * @param start Start time of the time period to fetch data from
     * @param end End time of the time period to fetch data from
     * @param coordsString Coordinate area as a string in the form MinLon,MinLat,MaxLon,MaxLat
     * @return List of WeatherData objects
     */
    private List<WeatherData> getPastTemperatureData (LocalDateTime start, LocalDateTime end,
                                                           String coordsString) {
        String url = "https://opendata.fmi.fi/wfs?request=getFeature" +
                "&version=2.0.0&storedquery_id=fmi::observations::weather::daily::simple" +
                "&bbox=" + coordsString +
                "&parameters=tday,tmin,tmax" +
                "&starttime=" + start.toString() +
                "&endtime=" + end.toString();

        return getWeatherData(url);
    }

    /**
     * Fetches forecasts for temperature and wind speed from FMI API from the given time period and coordinates
     * @param start Start time of the time period to fetch data from
     * @param end End time of the time period to fetch data from
     * @param coordsString Coordinate area as a string in the form Latitude,Longitude
     * @param timeStep The time interval at which data is fetched in minutes
     * @return List of WeatherData objects
     */
    private List<WeatherData> getForecasts (LocalDateTime start, LocalDateTime end, String coordsString, int timeStep) {
        String url = "https://opendata.fmi.fi/wfs?request=getFeature" +
                "&version=2.0.0&storedquery_id=fmi::forecast::harmonie::surface::point::simple" +
                "&latlon=" + coordsString +
                "&timestep=" + timeStep +
                "&starttime=" + start.toString() +
                "&endtime=" + end.toString() +
                "&parameters=temperature,windspeedms";

        return getWeatherData(url);
    }
}
