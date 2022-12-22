package fi.tuni.monitor.data;

import java.time.LocalDateTime;

/**
 * A class for representing weather
 */
public class WeatherData {

    private LocalDateTime time = null;
    private String gmlPos = "";

    private Double temperature = null;
    private Double maxTemperature = null;
    private Double minTemperature = null;
    private Double windSpeed = null;
    private Double cloudiness = null;

    private boolean isObservation = true;

    public WeatherData() {
    }

    public WeatherData(LocalDateTime time, Double temperatureAvg, Double windSpeed,
                       Double cloudiness, boolean isObservation) {
        this.time = time;
        this.temperature = temperatureAvg;
        this.windSpeed = windSpeed;
        this.cloudiness = cloudiness;
        this.isObservation = isObservation;
    }

    /**
     * Sets the time of the weather
     * @param time time of the weather
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * Sets the coordinates of the weather
     * @param pos coordinates of the weather
     */
    public void setPos(String pos) {
        this.gmlPos = pos;
    }

    /**
     * Sets the average temperature of the weather
     * @param temperatureAvg
     */
    public void setTemperatureAvg(Double temperatureAvg) {
        this.temperature = temperatureAvg;
    }

    /**
     * Sets the maximum temperature of the weather
     * @param maxTemperature maximum temperature of the weather
     */
    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    /**
     * Sets the minimum temperature of the weather
     * @param minTemperature minimum temperature of the weather
     */
    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    /**
     * Sets the wind speed of the weather
     * @param windSpeed wind speed of the weather
     */
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * Sets the cloud cover of the weather
     * @param cloudiness cloud cover of the weather
     */
    public void setCloudiness(Double cloudiness) {
        this.cloudiness = cloudiness;
    }

    /**
     * Sets the weather type to be observation
     */
    public void setToObservation() {
        this.isObservation = true;
    }

    /**
     * Sets the weather type to be forecast
     */
    public void setToForeCast() {
        this.isObservation = false;
    }

    /**
     * Gets the time of the weather
     * @return time of the weather
     */
    public LocalDateTime getTime(){
        return this.time;
    }

    /**
     * Gets the average temperature of the weather
     * @return average temperature of the weather
     */
    public Double getTemperatureAvg(){
        return this.temperature;
    }

    /**
     * Gets the maximum temperature of the weather
     * @return maximum temperature of the weather
     */
    public Double getMaxTemperature() {
        return this.maxTemperature;
    }

    /**
     * Gets the minimum temperature of the weather
     * @return the minimum temperature of the weather
     */
    public Double getMinTemperature() {
        return this.minTemperature;
    }

    /**
     * Gets the wind speed of the weather
     * @return wind speed of the weather
     */
    public Double getWindSpeed(){
        return this.windSpeed;
    }

    /**
     * Gets the cloud cover of the weather
     * @return cloud cover of the weather
     */
    public Double getCloudiness(){
        return this.cloudiness;
    }

    /**
     * Checks if weather type is observation
     * @return true if weather type is observation, false if weather type is forecast
     */
    public boolean getIsObservation() {
        return this.isObservation;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "Time='" + time + '\'' +
                ", gmlPos='" + gmlPos + '\'' +
                ", temperature='" + temperature + '\'' +
                ", windSpeed=" + windSpeed +
                ", cloudiness=" + cloudiness +
                ", observation=" + isObservation +
                ", maxTemp=" + maxTemperature +
                ", minTemp=" + minTemperature +
                '}';
    }
}