package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;



public class CurrentOrderController implements Initializable{
    @FXML
    private ListView<String> currentListView;
    private static final double STARTING_PRICE = 0.00;
    @FXML
    private Label totalLabel, saleLabel, orderLabel;
    @FXML
    private TextField numberField;
    private PizzaFactory piza;
    private Pizza pia;
    private static final double TAX = 0.06625;
    double total = STARTING_PRICE;
    private String currentPizza;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Pizza za : MainController.getOrd().getOrders()){
           // pia = za;
            currentListView.getItems().add(za.toString());
            double temp = totalPrice(za.price());
            String priceString = df.format(temp);
            totalLabel.setText("$"+ priceString);

            String taxString = df.format(saleTaxPrice(temp));
            saleLabel.setText("$" + taxString);
            double tempOrder = temp + saleTaxPrice(temp);
            String orderString = df.format(tempOrder);
            orderLabel.setText("$" + orderString);
        }

    }
    public double totalPrice(double price){

        total += price;

        return total;
    }
    public double saleTaxPrice(double total){
        return (TAX * total);
    }
    public double removeTotal(double price){
        total-= price;
        return total;
    }
    public int getSerial(){
        int serial = Integer.parseInt(numberField.getText());

        return serial;
    }
    public void removePizza(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pizzas Removed");
        alert.setHeaderText("The pizzas has been removed");
        currentPizza = currentListView.getSelectionModel().getSelectedItem();
        currentListView.getItems().remove(currentPizza);
        for(Pizza za : MainController.getOrd().getOrders()){
            if(za.toString().equals(currentPizza)){
                MainController.getOrd().getOrders().remove(za);
                double removedPrice = za.price();
                double tempPrice = removeTotal(removedPrice);
                String priceString = df.format(tempPrice);
                totalLabel.setText("$"+ priceString);
                String taxString = df.format(saleTaxPrice(tempPrice));
                saleLabel.setText("$" + taxString);
                double tempOrder = tempPrice + saleTaxPrice(tempPrice);
                String orderString = df.format(tempOrder);
                orderLabel.setText("$" + orderString);
                break;
            }
        }

    }
    public void removeAllPizzas(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pizzas Removed");
        alert.setHeaderText("All the pizzas have been removed");
        alert.show();
        for(Pizza za : MainController.getOrd().getOrders()){
            MainController.getOrd().getOrders().remove(za);
        }
        currentListView.getItems().clear();

        String priceString = df.format(STARTING_PRICE);
        totalLabel.setText("$"+ priceString);
        String taxString = df.format(saleTaxPrice(STARTING_PRICE));
        saleLabel.setText("$" + taxString);
        String orderString = df.format(STARTING_PRICE);
        orderLabel.setText("$" + orderString);

    }
    public void placeOrders(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Order Added");
        alert.setHeaderText("Your order has been added to the Store Order!");
        alert.setContentText("You can find your order in the store order section");
        alert.show();
        MainController.addStoreOrd(MainController.getOrd());
        MainController.getOrd().setOrderSerial(getSerial());
        System.out.print("" + getSerial());
       // Order.addToOrderList(MainController.getArrayList());
        MainController.getOrd().getOrders().clear();

        currentListView.getItems().clear();
        String priceString = df.format(STARTING_PRICE);
        totalLabel.setText("$"+ priceString);
        String taxString = df.format(saleTaxPrice(STARTING_PRICE));
        saleLabel.setText("$" + taxString);
        String orderString = df.format(STARTING_PRICE);
        orderLabel.setText("$" + orderString);
        numberField.clear();
    }

}