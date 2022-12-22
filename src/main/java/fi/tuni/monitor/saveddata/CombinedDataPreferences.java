package fi.tuni.monitor.saveddata;

import fi.tuni.monitor.roadapi.model.MaintenanceTrackingPropertiesV1;

import java.io.Serializable;
import java.time.LocalDate;

public record CombinedDataPreferences(LocalDate weatherDateFromValue, LocalDate weatherDateToValue,
                                      MaintenanceTrackingPropertiesV1.TasksEnum taskTypeValue, String weatherType) implements Serializable
{

}
