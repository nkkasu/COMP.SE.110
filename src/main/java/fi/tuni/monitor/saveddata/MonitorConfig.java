package fi.tuni.monitor.saveddata;

import java.io.File;

public final class MonitorConfig {
    private static final String BASE_PATH = "data";
    private static final String CONFIG_BASE_PATH = BASE_PATH + "/config";
    private static final String ROAD_DATA_PREFERENCES_FILE = String.format(
            "%s/%s", CONFIG_BASE_PATH, "RoadDataPreferences.ser");
    private static final String WEATHER_DATA_PREFERENCES_FILE = String.format(
            "%s/%s", CONFIG_BASE_PATH, "WeatherDataPreferences.ser");
    private static final String COORDINATE_SELECTION_PREFERENCES_FILE = String.format(
            "%s/%s", CONFIG_BASE_PATH, "CoordinateSelectionPreferences.ser");

    private static final String COMBINED_DATA_PREFERENCES_FILE = String.format(
            "%s/%s", CONFIG_BASE_PATH, "CombinedDataPreferencesFile.ser");

    private static final String COMBINED_FORECAST_PREFERENCES_FILE = String.format(
            "%s/%s", CONFIG_BASE_PATH, "CombinedForecastPreferencesFile.ser");

    private static final String TRAFFIC_MESSAGE_DATASETS_FOLDER = String.format(
            "%s/%s", BASE_PATH, "TrafficMessageDatasets");

    public static String getRoadDataPreferencesFile() {
        return ROAD_DATA_PREFERENCES_FILE;
    }

    public static String getWeatherDataPreferencesFile() {
        return WEATHER_DATA_PREFERENCES_FILE;
    }

    public static String getCoordinateSelectionPreferencesFile() {
        return COORDINATE_SELECTION_PREFERENCES_FILE;
    }
    public static void clearRoadDataPreferences() {
        if (!new File(ROAD_DATA_PREFERENCES_FILE).delete()) {
            System.err.println("Failed to clear road data preferences!");
        }
    }
    public static String getCombinedDataPreferencesFile() {
        return COMBINED_DATA_PREFERENCES_FILE;
    }
    public static String getCombinedForecastPreferencesFile() {
        return COMBINED_FORECAST_PREFERENCES_FILE;
    }
    public static String getTrafficMessageDatasetsFolder() {
        return TRAFFIC_MESSAGE_DATASETS_FOLDER;
    }
    public static void clearWeatherDataPreferences() {
        if (!new File(WEATHER_DATA_PREFERENCES_FILE).delete()) {
            System.err.println("Failed to clear weather data preferences!");
        }
    }
    public static void clearCoordinateSelectionPreferences() {
        if (!new File(COORDINATE_SELECTION_PREFERENCES_FILE).delete()) {
            System.err.println("Failed to clear coordinate selection preferences!");
        }
    }
    public static void clearCombinedDataPreferences() {
        if (!new File(COMBINED_DATA_PREFERENCES_FILE).delete()) {
            System.err.println("Failed to clear combined data preferences!");
        }
    }

    public static void clearCombinedForecastPreferences() {
        if (!new File(COMBINED_FORECAST_PREFERENCES_FILE).delete()) {
            System.err.println("Failed to clear combined forecast preferences!");
        }
    }

    /**
     * Clears the traffic message datasets folder.
     */
    public static void clearTrafficMessageDatasets() {
        File folder = new File(TRAFFIC_MESSAGE_DATASETS_FOLDER);
        if (folder.exists())
            for (File file : folder.listFiles())
                if (!file.delete())
                    System.err.println("Failed to clear traffic message dataset!");
    }
}
