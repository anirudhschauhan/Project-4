package com.example.project4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.text.DecimalFormat;




public class ChicagoStyleController implements Initializable {

    private String[] flavor = {"DELUXE", "MEATZZA", "BBQ CHICKEN", "BUILD YOUR OWN"};

    private static final DecimalFormat df = new DecimalFormat("0.00");
    @FXML
    private ComboBox flavorComboBox;
    @FXML
    public Button addButton, removeButton;
    @FXML
    private ListView<Topping> myListView, topListView;
    private static final int MAX_TOPPINGS = 7;
    private Order order;

    @FXML
    private Label priceLabel, crustLabel;
    private PizzaFactory piza;
    private Pizza pia;
    private Topping currentTopping;
    @FXML
    private RadioButton smallSize, mediumSize, largeSize;
    public ChicagoStyleController(){
        piza = new ChicagoPizza();
        pia = piza.createDeluxe();
        pia.setSize(Size.valueOf("SMALL"));
        order = new Order();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flavorComboBox.getItems().addAll(flavor);
        addButton.setDisable(true);
        removeButton.setDisable(true);
        for (Topping top : Topping.values()) {
            myListView.getItems().add(top);
        }
        for (Topping top : pia.getToppingList()){
            topListView.getItems().add(top);
        }
        flavorComboBox.setValue("DELUXE");
        priceLabel.setText(""+ pia.price()+"");
        flavorComboBox.setOnAction(this::changeFlavor);
    }

    private void changeFlavor(Event event) {
        String flav = flavorComboBox.getValue().toString();
        if (flav.equals("DELUXE")) {
            pia = piza.createDeluxe();
            crustLabel.setText(""+ pia.getCrust());
            addButton.setDisable(true);
            removeButton.setDisable(true);
        }
        if (flav.equals("MEATZZA")) {
            pia = piza.createMeatzza();
            crustLabel.setText(""+ pia.getCrust());
            addButton.setDisable(true);
            removeButton.setDisable(true);
        }
        if (flav.equals("BBQ CHICKEN")) {
            pia = piza.createBBQChicken();
            crustLabel.setText(""+ pia.getCrust());
            addButton.setDisable(true);
            removeButton.setDisable(true);
        }
        if (flav.equals("BUILD YOUR OWN")) {
            pia = piza.createBuildYourOwn();
            crustLabel.setText(""+ pia.getCrust());
            addButton.setDisable(false);
            removeButton.setDisable(false);

        }
        topListView.getItems().clear();

        for (Topping top : pia.getToppingList()) {
            topListView.getItems().add(top);
        }
        changeSize();
    }

    public void changeSize(){
        if (smallSize.isSelected()){
            pia.setSize(Size.valueOf("SMALL"));
        }
        if (mediumSize.isSelected()){
            pia.setSize(Size.valueOf("MEDIUM"));
        }
        if (largeSize.isSelected()){
            pia.setSize(Size.valueOf("LARGE"));
        }
        changePrice();

    }
    public void changePrice(){
        String priceString = df.format(pia.price());
        priceLabel.setText(priceString);
    }
    public void addTopping(ActionEvent Event){
        currentTopping = myListView.getSelectionModel().getSelectedItem();
        if (pia.getToppingList().contains(currentTopping)){
            return;
        }
        pia.addToppingList(currentTopping);
        topListView.getItems().add(currentTopping);
        if(pia.getToppingList().size() > MAX_TOPPINGS-1){
            addButton.setDisable(true);
        }
        changePrice();


    }
    public void removeTopping(ActionEvent Event){
        currentTopping = topListView.getSelectionModel().getSelectedItem();
        if (!pia.getToppingList().contains(currentTopping)){
            return;
        }
        pia.removeToppingList(currentTopping);
        topListView.getItems().remove(currentTopping);
        if(pia.getToppingList().size() <= MAX_TOPPINGS){
            addButton.setDisable(false);
        }
        changePrice();

    }
    //not right

    public void addOrder(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pizza Added");
        alert.setHeaderText("Your pizza has been added to the order!");
        alert.setContentText("You can find your pizza in the current order section");
        alert.show();
        order.add(pia);
        MainController.addToOrder(pia);



        pia = piza.createDeluxe();
        crustLabel.setText(""+ pia.getCrust());

        addButton.setDisable(true);
        removeButton.setDisable(true);

        flavorComboBox.setValue("DELUXE");
        smallSize.setSelected(true);

        changeSize();
        priceLabel.setText(""+ pia.price()+"");


    }



}
