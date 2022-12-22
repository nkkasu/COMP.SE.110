package fi.tuni.monitor.roadapi;

import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.data.MaintenanceTask;
import fi.tuni.monitor.roadapi.api.MaintenanceApi;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingFeatureV1;
import fi.tuni.monitor.roadapi.model.MaintenanceTrackingPropertiesV1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaintenanceTaskFetcher {

    private static final List<MaintenanceTrackingPropertiesV1.TasksEnum> allTasks = Arrays.asList(
            MaintenanceTrackingPropertiesV1.TasksEnum.values());

    public List<MaintenanceTask> getMaintenanceTasks(BoundingCoordinates coords,
                                                     LocalDateTime startTime,
                                                     LocalDateTime endTime,
                                                     List<MaintenanceTrackingPropertiesV1.TasksEnum> taskTypes) throws ApiException {
        List<MaintenanceTask> tasks = new ArrayList<>();

        while (startTime.isBefore(endTime)) {
            var results = new MaintenanceApi().findMaintenanceTrackings2(
                    startTime.atZone(ZoneId.systemDefault()).toOffsetDateTime(),
                    startTime.atZone(ZoneId.systemDefault()).toOffsetDateTime().plusDays(1),
                    null,
                    null,
                    coords.minLon(),
                    coords.minLat(),
                    coords.maxLon(),
                    coords.maxLat(),
                    taskTypes.stream().map(MaintenanceTrackingPropertiesV1.TasksEnum::toString).toList(),
                    null);
            LocalDateTime finalStartTime = startTime;
            var tempTasks = results.getFeatures()
                    .stream()
                    .map(MaintenanceTrackingFeatureV1::getProperties)
                    .filter((properties) -> properties.getStartTime().toLocalDateTime().isAfter(finalStartTime)) // API gives tasks before the start time...
                    .map(properties -> new MaintenanceTask(
                            properties.getId().toString(),
                            properties.getTasks().stream().map(MaintenanceTrackingPropertiesV1.TasksEnum::prettifiedValue).toList(),
                            properties.getStartTime().toLocalDateTime(),
                            properties.getEndTime().toLocalDateTime()
                    )).toList();
            tasks.addAll(tempTasks);

            startTime = startTime.plusHours(24);
        }

        return tasks;
    }

    /**
     * @param coords
     * @param startTime
     * @param endTime
     * @return
     * @throws ApiException
     */
    public List<MaintenanceTask> getMaintenanceTasks(BoundingCoordinates coords, LocalDateTime startTime, LocalDateTime endTime) throws ApiException {
        return this.getMaintenanceTasks(coords, startTime, endTime, allTasks);
    }
}
