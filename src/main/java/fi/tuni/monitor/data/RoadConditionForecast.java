package fi.tuni.monitor.data;

import java.time.LocalDateTime;

public class RoadConditionForecast {
    private LocalDateTime time = null;
    private String forecastName = "";
    private String precipitation = "";
    private String roadCondition = "";
    private boolean winterSlipperiness = false;

    public enum ConditionType {
        PRECIPITATION("Precipitation"),
        ROADCONDITION("Road condition"),
        WINTERSLIPPERINESS("Winter slipperiness");

        private String value;

        ConditionType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public String toString() {
            return String.valueOf(value);
        }

    }

    public RoadConditionForecast() {
    }

    public RoadConditionForecast(LocalDateTime time, String forecastName,
                                 String precipitation, String roadCondition,
                                 boolean winterSlipperiness) {
        this.time = time;
        this.forecastName = forecastName;
        this.precipitation = precipitation;
        this.roadCondition = roadCondition;
        this.winterSlipperiness = winterSlipperiness;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setForecastName(String forecastName) {
        this.forecastName = forecastName;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public void setRoadCondition(String roadCondition) {
        this.roadCondition = roadCondition;
    }

    public void setWinterSlipperiness(boolean winterSlipperiness) {
        this.winterSlipperiness = winterSlipperiness;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getForecastName() {
        return forecastName;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public String getRoadCondition() {
        return roadCondition;
    }

    public boolean isWinterSlipperiness() {
        return winterSlipperiness;
    }

    public String getSpecificConditionValue(RoadConditionForecast.ConditionType type) {
        String value = "";
        switch (type) {
            case PRECIPITATION -> {
                value = this.precipitation;
                break;
            }
            case ROADCONDITION -> {
                value = this.roadCondition;
                break;
            }
            case WINTERSLIPPERINESS -> {
                value = String.valueOf(this.isWinterSlipperiness());
            }
        }
        return value;
    }
    @Override
    public String toString() {
        return "RoadConditionForecast{" +
                "time=" + time +
                ", forecastName='" + forecastName + '\'' +
                ", precipitation='" + precipitation + '\'' +
                ", roadCondition='" + roadCondition + '\'' +
                ", winterSlipperiness=" + winterSlipperiness +
                '}';
    }
}