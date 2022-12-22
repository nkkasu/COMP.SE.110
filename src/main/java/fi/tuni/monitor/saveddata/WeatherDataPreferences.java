package fi.tuni.monitor.saveddata;

import java.io.Serializable;
import java.time.LocalDate;

public record WeatherDataPreferences(LocalDate weatherDateFromValue,
                                     LocalDate weatherDateToValue,
                                     boolean temperatureCheckBoxSelected,
                                     boolean minMaxCheckBoxSelected,
                                     boolean windCheckBoxSelected,
                                     boolean cloudCheckBoxSelected) implements Serializable
{

}
