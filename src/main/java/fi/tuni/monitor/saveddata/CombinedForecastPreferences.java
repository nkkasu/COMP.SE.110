package fi.tuni.monitor.saveddata;

import fi.tuni.monitor.data.RoadConditionForecast;

import java.io.Serializable;

public class CombinedForecastPreferences implements Serializable {
    int hoursPickerValue = 0;
    RoadConditionForecast.ConditionType conditionTypeValue = null;
    String weatherTypePickerValue = "";

    public CombinedForecastPreferences(int hoursPickerValue, RoadConditionForecast.ConditionType conditionTypeValue, String weatherTypePickerValue) {
        this.hoursPickerValue = hoursPickerValue;
        this.conditionTypeValue = conditionTypeValue;
        this.weatherTypePickerValue = weatherTypePickerValue;
    }

    public int getHoursPickerValue() {
        return hoursPickerValue;
    }

    public void setHoursPickerValue(int hoursPickerValue) {
        this.hoursPickerValue = hoursPickerValue;
    }

    public RoadConditionForecast.ConditionType getConditionTypeValue() {
        return conditionTypeValue;
    }

    public void setConditionTypeValue(RoadConditionForecast.ConditionType conditionTypeValue) {
        this.conditionTypeValue = conditionTypeValue;
    }

    public String getWeatherTypePickerValue() {
        return weatherTypePickerValue;
    }

    public void setWeatherTypePickerValue(String weatherTypePickerValue) {
        this.weatherTypePickerValue = weatherTypePickerValue;
    }
}
