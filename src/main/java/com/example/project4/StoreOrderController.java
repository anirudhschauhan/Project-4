package com.example.project4;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrderController implements Initializable {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @FXML
    private ListView<String> orderListView;
    private Order order;
    @FXML
    private ComboBox orderCombo;
    @FXML
    private TextField taxField;
    private  ArrayList<Integer> numbers;
    private int index;

    private Pizza pia;
    private StoreOrders storeOrders;
    public StoreOrderController(){
        numbers = new ArrayList<>();
      //  order = new Order();
        storeOrders = MainController.getStoreOrd();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderCombo.setValue("1");
        for (Order ord : storeOrders.getStoreOrders()) {

            for (Pizza za : ord.getOrders()){
                order = ord;
                orderListView.getItems().add(toString(za));
            }
            break;
            //System.out.println("" + ord.getOrderSerial());
        }
        for (Order ord : storeOrders.getStoreOrders()) {
            numbers.add(ord.getOrderSerial());
        }
        orderCombo.getItems().addAll(numbers);
        String orderPrice = df.format(order.getTaxPrice());
        taxField.setText("" + orderPrice);



        orderCombo.setOnAction(this::changeOrder);
        //public static final


    }
    public void changeOrder(Event event) {
        orderListView.getItems().clear();
        String num = orderCombo.getValue().toString();
        int newNum = Integer.parseInt(num);

        if (numbers.contains(newNum)) {
            index = numbers.indexOf(newNum);
        }
        Order random = storeOrders.getStoreOrders().get(index);
        for(Pizza za : random.getOrders()){
             orderListView.getItems().add(toString(za));
        }
        String orderPrice = df.format(order.getTaxPrice());
        taxField.setText("" + orderPrice);
    }
    public void cancelOrder(){
        String num = orderCombo.getValue().toString();
        int newNum = Integer.parseInt(num);

        if (numbers.contains(newNum)) {
            index = numbers.indexOf(newNum);
        }
        Order random = storeOrders.getStoreOrders().get(index);
        storeOrders.getStoreOrders().remove(random);

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
