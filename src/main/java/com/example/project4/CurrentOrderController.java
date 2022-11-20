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
    private Order order;
    private static final double TAX = 0.06625;
    double total = STARTING_PRICE;
    private static final int INCREMENT = 1;
    private String currentPizza;
    private double tempNum;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public CurrentOrderController(){
        order = MainController.getOrd();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Pizza za : order.getOrders()){
            currentListView.getItems().add(toString(za));

            double temp = totalPrice(za.price());
            String priceString = df.format(temp);
            totalLabel.setText("$"+ priceString);

            String taxString = df.format(saleTaxPrice(temp));
            saleLabel.setText("$" + taxString);
            tempNum = temp + saleTaxPrice(temp);
            String orderString = df.format(tempNum);
            orderLabel.setText("$" + orderString);
        }
        int temp = MainController.getStoreOrd().getStoreOrders().size() + INCREMENT;
        numberField.setText("" + temp);
    }
    public double totalPrice(double price){

        total += price;

        return total;
    }
    public double saleTaxPrice(double total){
        return (TAX * total);
    }
    public double removeTotal(double price) {
        total -= price;
        return total;
    }
    public void removePizza(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pizzas Removed");
        alert.setHeaderText("The pizzas has been removed");
        currentPizza = currentListView.getSelectionModel().getSelectedItem();
        currentListView.getItems().remove(currentPizza);
        for(Pizza za : order.getOrders()){
            if(za.toString().equals(currentPizza)){
                order.getOrders().remove(za);
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
        for(Pizza za : order.getOrders()){
            order.getOrders().remove(za);
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
        try{
            Integer.parseInt(numberField.getText());
        }
        catch(NumberFormatException e){
            Alert bert = new Alert(Alert.AlertType.ERROR);
            bert.setTitle("Error");
            bert.setHeaderText("Please add an order number!");
            bert.setContentText("Please add an order number to continue");
            bert.show();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Order Added");
        alert.setHeaderText("Your order has been added to the Store Order!");
        alert.setContentText("You can find your order in the store order section");
        alert.show();
        MainController.addStoreOrd(order);
        order.setTaxPrice(tempNum);
        order.setOrderSerial(MainController.getStoreOrd().getStoreOrders().size());
       // Order.addToOrderList(MainController.getArrayList());
        MainController.resetOrder();

        currentListView.getItems().clear();
        String priceString = df.format(STARTING_PRICE);
        totalLabel.setText("$"+ priceString);
        String taxString = df.format(saleTaxPrice(STARTING_PRICE));
        saleLabel.setText("$" + taxString);
        String orderString = df.format(STARTING_PRICE);
        orderLabel.setText("$" + orderString);
        int temp = MainController.getStoreOrd().getStoreOrders().size() + INCREMENT;
        numberField.setText("" + temp);
    }
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