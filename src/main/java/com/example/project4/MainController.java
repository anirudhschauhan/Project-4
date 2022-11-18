package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    @FXML
    private Label welcomeText;
    public static ArrayList<Pizza> pizzaOrders;

   // @FXML
   // protected void onHelloButtonClick() {
   //     welcomeText.setText("Welcome to JavaFX Application!");
  //  }
    @FXML
    protected void onChicagoButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("chicago-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Chicago Style");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onNYButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("new-york-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("New York Style");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onCurrentButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("current-order-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Current Order");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onStoreButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("store-order-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Store Order");
        stage.setScene(scene);
        stage.show();
    }
    protected static ArrayList<Pizza> getArrayList(){
        return pizzaOrders;
    }
}