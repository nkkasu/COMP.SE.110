package fi.tuni.monitor.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Represents a traffic message
 * @param situationId id of the situation
 * @param situationType type of the situation
 * @param description description of the situation
 * @param features list of features of the situation
 * @param startTime start time of the situation
 * @param endTime end time of the situation
 */
public record TrafficMessage(String situationId, String situationType, String description, List<String> features,
                             LocalDateTime startTime, LocalDateTime endTime) implements Serializable
{
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d.M.yyyy HH.mm");

    @Override
    public String toString()
    {
        return "TrafficMessage{" +
                "situationId='" + situationId + '\'' +
                ", situationType='" + situationType + '\'' +
                ", description='" + description + '\'' +
                ", features=" + features +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
