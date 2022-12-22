package fi.tuni.monitor.saveddata;

import javafx.event.ActionEvent;

/**
 * Interface for Classes that need to save preferences
 */
public interface SaveablePreferences {
    void handleSavePreferences(ActionEvent event);
}
