package fi.tuni.monitor.saveddata;

import fi.tuni.monitor.data.TrafficMessage;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record TrafficMessageDataset(List<TrafficMessage> trafficMessages, LocalDateTime fetchTime,
                                    Integer inactiveHours) implements Serializable
{
    public String getComboTitle()
    {
        return String.format("%s (Count: %d)", fetchTime.format(TrafficMessage.DATE_TIME_FORMATTER), trafficMessages.size());
    }

    public String getTreeTitle()
    {
        return String.format("%s (Count: %d)", fetchTime.format(TrafficMessage.DATE_TIME_FORMATTER), trafficMessages.size());
    }
}
