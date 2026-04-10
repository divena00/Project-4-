package org.example.project4_software;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Main entry point for the RU Pizza JavaFX application.
 * This class launches the GUI and loads the main view.
 */
public class Main extends Application {
    /**
     * Starts the JavaFX application.
     * Loads the main FXML file and sets up the primary stage.
     *
     * @param stage the primary stage for this application
     * @throws IOException if the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("RU Pizza");
        stage.setScene(scene);
        stage.show();
    }
}
