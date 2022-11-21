package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * This class launches the GUI for the pizza program
 * @author Anirudh Schauhan, Matthew Calora
 */
public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Main Page");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This is the main method for the GUI.
     * Launches the GUI.
     * @author Anirudh Schauhan, Matthew Calora
     */
    public static void main(String[] args) {
        launch();
    }
    /*
    -add pictures
    -add order number
    -make to string in order for displaying the stuff
    -in order class display orders by order number
    - do the export method
    - do the new york class and make adjustments to the chicago code
     */
}