package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Main Controller for pizza style selection or
 * current order or store orders
 * @author Anirudh Chauhan, Matthew Calora
 */
public class MainController {
    @FXML

    private static Order ord;
    private static StoreOrders storeOrd;
    private static ArrayList<Integer> orderNumArrayList;


    public MainController(){
        orderNumArrayList = new ArrayList<>();
        storeOrd = new StoreOrders();
        ord = new Order();

    }

    /**
     * When the Chicago Style button is clicked, changes the scene
     * to allow customization of the chicago style pizza
     * @throws IOException
     */
    @FXML
    protected void onChicagoButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("chicago-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Chicago Style");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * When the NY (New York) Style button is clicked, changes the scene
     * to allow customization of the NY style pizza
     * @throws IOException
     */
    @FXML
    protected void onNYButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("new-york-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("New York Style");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * When the Current Order button is clicked, changes the scene
     * to allow the customer to view their current order
     * @throws IOException
     */
    @FXML
    protected void onCurrentButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("current-order-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Current Order");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * When the Store order button is clicked, changes the scene
     * to view the store order
     * @throws IOException
     */
    @FXML
    protected void onStoreButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("store-order-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Store Order");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * gets order
     */
    protected static Order getOrd(){
        return ord;
    }

    /**
     * gets store order
     */
    protected static StoreOrders getStoreOrd(){
        return storeOrd;
    }

    /**
     * adds pizza to order
     */
    protected static void addToOrder(Pizza za){
        ord.add(za);
    }

    /**
     * resets order
     */
    protected static void resetOrder(){
        ord = new Order();
    }

    /**
     * adds store order
     */
    protected static void addStoreOrd(Order or){
        storeOrd.add(or);
    }

    /**
     * gets order number
     */
    public static int orderNumber(){
        int i = 1;
        while(orderNumArrayList.contains(i)){
            i++;
        }
        orderNumArrayList.add(i);
        return i;
    }
    public static ArrayList<Integer> getOrderNumArrayList(){
        return orderNumArrayList;
    }

    /**
     * removes order number
     * @author Anirudh Schauhan, Matthew Calora
     */
    public static void removeOrderNumber(int rem){

        orderNumArrayList.remove(rem);
    }
}