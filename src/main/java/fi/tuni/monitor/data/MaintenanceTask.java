
package fi.tuni.monitor.data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a maintenance task
 * @param id id of the task
 * @param tasks list of task types within the task
 * @param startTime start time of the task
 * @param endTime end time of the task
 */
public record MaintenanceTask(String id, List<String> tasks, LocalDateTime startTime, LocalDateTime endTime)
{
    @Override
    public String toString()
    {
        return "MaintenanceTask{" +
                "id='" + id + '\'' +
                ", tasks=" + tasks +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}


