package fi.tuni.monitor.roadapi;

import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.data.TrafficMessage;
import fi.tuni.monitor.roadapi.api.TrafficMessageApi;
import fi.tuni.monitor.roadapi.model.*;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class TrafficMessageFetcher {

    private TrafficAnnouncementV1 extractAnnouncement(TrafficAnnouncementPropertiesV1 properties) {
        return properties.getAnnouncements().get(0); // // Always fi -> only one item
    }

    private List<TrafficMessage> convertToTrafficMessages(List<TrafficAnnouncementFeatureV1> announcements, BoundingCoordinates coords)  {
        var trafficMessages = new ArrayList<TrafficMessage>();

        for (var announcement: announcements) {
            var announcementProperties = announcement.getProperties();
            var finnishSituation = this.extractAnnouncement(announcementProperties);

            // Check that any point of announcement in bounds
            var inBoundsList = announcement.getGeometry()
                    .getFlattenedCoordinates()
                    .stream()
                    .map(coords::isInBounds)
                    .filter(val -> val).toList();

            if (!inBoundsList.isEmpty()) {
                var duration = finnishSituation.getTimeAndDuration();
                var trafficMessage = new TrafficMessage(announcementProperties.getSituationId(),
                        announcementProperties.getSituationType().prettifiedValue(),
                        finnishSituation.getTitle(),
                        finnishSituation.getFeatures().stream().map(FeatureV1::getDescription).toList(),
                        Optional.ofNullable(duration.getStartTime())
                                .map(OffsetDateTime::toLocalDateTime)
                                .orElse(null),
                        Optional.ofNullable(duration.getEndTime())
                                .map(OffsetDateTime::toLocalDateTime)
                                .orElse(null));
                trafficMessages.add(trafficMessage);
            }

        }

        return trafficMessages;
    }

    /**
     * @param coords The bounding coordinate box
     * @param hoursPast How many hours into past to get messages
     * @return list of TrafficMessages
     * @throws ApiException when an API call behaves unexpectedly
     * @throws ExecutionException when async fails
     * @throws InterruptedException when async fails
     */
    public List<TrafficMessage> getTrafficMessages(BoundingCoordinates coords, int hoursPast) throws ApiException {
        List<SituationTypeV1> situationTypes = Arrays.asList(SituationTypeV1.TRAFFIC_ANNOUNCEMENT,
                SituationTypeV1.ROAD_WORK,
                SituationTypeV1.EXEMPTED_TRANSPORT,
                SituationTypeV1.ROAD_WORK);
        var results = new TrafficMessageApi().trafficMessageSimple1(
                situationTypes,
                hoursPast,
                true).getFeatures();

        return this.convertToTrafficMessages(results, coords);
    }
}
