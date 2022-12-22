package fi.tuni.monitor.controllers;

import fi.tuni.monitor.saveddata.MonitorConfig;
import javafx.fxml.FXML;

public class SettingsController {

    @FXML
    public void onClearPreferencesClicked() {
        MonitorConfig.clearRoadDataPreferences();
        MonitorConfig.clearWeatherDataPreferences();
        MonitorConfig.clearCoordinateSelectionPreferences();
        MonitorConfig.clearCombinedDataPreferences();
        MonitorConfig.clearCombinedForecastPreferences();
    }

    @FXML
    private void onTrafficMessageDatasetsClicked()
    {
        MonitorConfig.clearTrafficMessageDatasets();
    }
}
