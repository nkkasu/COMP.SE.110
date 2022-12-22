package fi.tuni.monitor.saveddata;

import fi.tuni.monitor.data.RoadConditionForecast;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingPropertiesV1;

import java.io.Serializable;
import java.time.LocalDate;

public record RoadDataPreferences(LocalDate dateFromValue,
                                  LocalDate dateToValue,
                                  boolean specificCheckBoxValue,
                                  MaintenanceTrackingPropertiesV1.TasksEnum taskTypeValue,
                                  int forecastHourPickerValue,
                                  RoadConditionForecast.ConditionType forecastConditionPickerValue) implements Serializable
{

}
