package fi.tuni.monitor.models;

import fi.tuni.monitor.data.AsyncDataFetch;
import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.data.RoadConditionForecast;
import fi.tuni.monitor.roadapi.ApiException;
import fi.tuni.monitor.roadapi.RoadConditionForecastFetcher;
import org.jfree.data.general.DefaultPieDataset;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class for handling road condition forecast visualization data
 */
public class RoadConditionForecastModel implements AsyncDataFetch
{

    private List<RoadConditionForecast> forecastList = new ArrayList<>();
    private RoadConditionForecast.ConditionType conditionType = null;
    private int hours = 0;
    private BoundingCoordinates coordinates;
    private CompletableFuture<Void> isDataFetchComplete = null;

    public RoadConditionForecastModel() {}
    public RoadConditionForecastModel(int hours, RoadConditionForecast.ConditionType conditionType, BoundingCoordinates coordinates) {
        this.conditionType = conditionType;
        this.hours = hours;
        this.coordinates = coordinates;
    }

    private void fetchData() {
        this.isDataFetchComplete = CompletableFuture.runAsync(() -> {
            try {
                this.forecastList = new RoadConditionForecastFetcher().getRoadConditionForecasts(
                        this.coordinates,
                        this.hours);
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public DefaultPieDataset<String> getPieChartData() {
        DefaultPieDataset<String> pieChartData = new DefaultPieDataset<>();

        Stream<String> valueStream = null;

        switch (this.conditionType) {
            case PRECIPITATION -> valueStream = this.forecastList.stream().map(RoadConditionForecast::getPrecipitation);
            case ROADCONDITION -> valueStream = this.forecastList.stream().map(RoadConditionForecast::getRoadCondition);
            case WINTERSLIPPERINESS -> valueStream = this.forecastList.stream().map(RoadConditionForecast::isWinterSlipperiness).map(Object::toString);
        }

        if (valueStream != null)
            valueStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach(pieChartData::setValue);

        return pieChartData;
    }

    public RoadConditionForecast.ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(RoadConditionForecast.ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public BoundingCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(BoundingCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void updateData() {
        this.fetchData();
    }

    public CompletableFuture<Void> getIsDataFetchComplete() {
        return isDataFetchComplete;
    }
}
