package com.example.project4;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.shape.Path;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.shape.Path;

/**
 * Controller for store orders
 * @author Anirudh Chauhan, Matthew Calora
 */

public class StoreOrderController implements Initializable {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @FXML
    private ListView<String> orderListView;

    private static final int STARTING_ORDER_NUM = 1;
    @FXML
    private ComboBox orderCombo;
    @FXML
    private TextField taxField;


    private StoreOrders storeOrders;
    public StoreOrderController(){

        storeOrders = MainController.getStoreOrd();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderCombo.getItems().addAll(MainController.getOrderNumArrayList());
        if(!(MainController.getOrderNumArrayList().size() <= STARTING_ORDER_NUM)) {
            int numOrders = MainController.getOrderNumArrayList().size() - 1;
            orderCombo.getItems().remove(MainController.getOrderNumArrayList().get(numOrders));
        }
        orderCombo.setValue(MainController.getOrderNumArrayList().get(0));

        if(storeOrders.getStoreOrders() != null) {
            Order startingOrder = null;
            for(Order ord : storeOrders.getStoreOrders()) {
                if(ord.getOrderSerial() == MainController.getOrderNumArrayList().get(0)) {
                    startingOrder = ord;
                }
            }
            if (startingOrder != null) {
                for (Pizza za : startingOrder.getOrders()) {
                    orderListView.getItems().add(toString(za));
                }
                taxField.setText(df.format(startingOrder.getTaxPrice()));
            }
        }
    }

    /**
     * changes order from store
     * @param event
     */
    public void changeOrder(ActionEvent event) {
        if(orderCombo.getValue() == null) {
            return;
        }

        int orderNum = Integer.parseInt(orderCombo.getValue().toString());
        Order orderToDisplay = null;
        for(Order ord : storeOrders.getStoreOrders()) {
            if(ord.getOrderSerial() == orderNum) {
                orderToDisplay = ord;
            }
        }
        if(orderToDisplay != null) {
            orderListView.getItems().clear();
            for (Pizza za : orderToDisplay.getOrders()) {
                orderListView.getItems().add(toString(za));
            }
            taxField.setText(df.format(orderToDisplay.getTaxPrice()));
        }
    }

    /**
     * cancels / removes order from store
     * @param Event
     */
    public void cancelOrder(ActionEvent Event){
        try {
            int orderNum = Integer.parseInt(orderCombo.getValue().toString());
            Order orderToCancel = null;
            for(Order ord : storeOrders.getStoreOrders()) {
                if(ord.getOrderSerial() == orderNum) {
                    orderToCancel = ord;
                }
            }
            if(storeOrders.remove(orderToCancel)) {
                int removeIndex = MainController.getOrderNumArrayList().indexOf(orderNum);
                orderCombo.getItems().remove(MainController.getOrderNumArrayList().get(removeIndex));

                if(orderNum == MainController.getOrderNumArrayList().get(0)) {
                    if(MainController.getOrderNumArrayList().get(++removeIndex) != null) {
                        orderCombo.setValue(MainController.getOrderNumArrayList().get(removeIndex));
                    }
                }
                MainController.getOrderNumArrayList().remove(Integer.valueOf(orderNum));
                orderNum = Integer.parseInt(orderCombo.getValue().toString());

                Order orderToDisplay = null;
                for(Order ord : storeOrders.getStoreOrders()) {
                    if(ord.getOrderSerial() == orderNum) {
                        orderToDisplay = ord;
                    }
                }
                taxField.setText(df.format(orderToDisplay.getTaxPrice()));
                if(orderCombo.getValue().toString().equals("")){
                    orderListView.getItems().clear();
                }
            }
        }
        catch(Exception e) {
            taxField.setText("0.00");
            orderListView.getItems().clear();

        }
    }

    /**
     * exports a text file that contains
     * a list of store orders
     * @param Event
     */
    public void export(ActionEvent Event){
        try{
            File myObj = new File("output.txt");
            Alert bert = new Alert(Alert.AlertType.ERROR);

            FileWriter myWriter = new FileWriter("output.txt");

            for(Order ord : storeOrders.getStoreOrders()){
                for(Pizza za : ord.getOrders()){
                    String str = toString(za) + "\n";

                    myWriter.write(str);
                }

            }
            myWriter.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Text File Added");
            alert.setHeaderText("An Error Occurred!");
        }
        catch(Exception e){
            Alert bert = new Alert(Alert.AlertType.ERROR);
            bert.setTitle("Error");
            bert.setHeaderText("An Error Occurred!");
            bert.show();

        }

    }

    /**
     * returns the pizza, its toppings, and price as a string
     * @param pia
     * @return string
     */
    public String toString(Pizza pia) {
        String str;
        String type="";
        if(pia instanceof Deluxe){
            type = "Deluxe; ";
        }
        if(pia instanceof BuildYourOwn){
            type = "Build Your Own; ";
        }
        if(pia instanceof BBQChicken){
            type = "BBQChicken; ";
        }
        if(pia instanceof Meatzza){
            type = "Meatzza; ";
        }
        if (pia.getCrust().equals(Crust.valueOf("DEEPDISH")) || pia.getCrust().equals(Crust.valueOf("PAN")) || pia.getCrust().equals(Crust.valueOf("STUFFED"))){
            str = "" + type + "Pizza Style: CHICAGO"  + "; Crust: " + pia.getCrust()+ "; Toppings: " + pia.printArrayList() + "; Price: $" + pia.price() + "";
            return str;
        }
        else{
            str = "" + type + "Pizza Style: NEW YORK"  + "; Crust: " + pia.getCrust()+ "; Toppings: " + pia.printArrayList() + "; Price: $" + pia.price() + "";
            return (str);
        }
    }
}
