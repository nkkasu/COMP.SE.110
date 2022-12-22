package fi.tuni.monitor.mainwindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The entry point of the application<br>
 * Loads the main window and shows it
 */
public class MainWindowApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml-views/mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 800);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/monitor-icon.png"))));
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setTitle("Monitor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}