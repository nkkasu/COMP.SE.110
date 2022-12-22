package fi.tuni.monitor.roadapi;

import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.data.RoadConditionForecast;
import fi.tuni.monitor.roadapi.api.DataV3Api;
import fi.tuni.monitor.roadapi.model.ForecastSectionWeatherData;
import fi.tuni.monitor.roadapi.model.ForecastSectionWeatherForecastDtoV1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class RoadConditionForecastFetcher {

    public List<RoadConditionForecast> getRoadConditionForecasts(BoundingCoordinates coords, int futureHours) throws ApiException {
        LocalDateTime maxFuture = LocalDateTime.now().plusHours(futureHours);

        return Objects.requireNonNull(new DataV3Api().roadConditions2(
                                coords.minLon(),
                                coords.minLat(),
                                coords.maxLon(),
                                coords.maxLat())
                                              .getWeatherData())
                .stream()
                .map(ForecastSectionWeatherData::getRoadConditions).filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(condition -> condition.getType().equalsIgnoreCase(
                        ForecastSectionWeatherForecastDtoV1.TypeEnum.FORECAST.toString()) &&
                        condition.getTime().toLocalDateTime().isBefore(maxFuture))
                .map(condition -> {
                    assert condition.getTime() != null;
                    assert condition.getOverallRoadCondition() != null;
                    assert condition.getForecastConditionReason() != null;
                    return new RoadConditionForecast(
                            condition.getTime().toLocalDateTime(),
                            condition.getForecastName(),
                            condition.getForecastConditionReason().getPrecipitationCondition().prettifiedValue(),
                            condition.getOverallRoadCondition().prettifiedValue(),
                            Boolean.TRUE.equals(condition.getForecastConditionReason().getWinterSlipperiness())
                    );
                })
                .toList();
    }
}
