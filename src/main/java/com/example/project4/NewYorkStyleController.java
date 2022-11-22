package com.example.project4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.text.DecimalFormat;



/**
 * Controller for New York style pizzas
 * @author Anirudh Chauhan, Matthew Calora
 */
public class NewYorkStyleController implements Initializable {

    private String[] flavor = {"DELUXE", "MEATZZA", "BBQ CHICKEN", "BUILD YOUR OWN"};

    private static final DecimalFormat df = new DecimalFormat("0.00");
    @FXML
    private ComboBox flavorComboBox;
    @FXML
    public Button addButton, removeButton;
    @FXML
    private ListView<Topping> myListView, topListView;
    private static final int MAX_TOPPINGS = 7;


    @FXML
    private Label priceLabel, crustLabel;
    private PizzaFactory piza;
    private Pizza pia;
    private Image piaImage;
    private ImageView piaView;
    private Topping currentTopping;
    @FXML
    private RadioButton smallSize, mediumSize, largeSize;
    public NewYorkStyleController(){
        piza = new NYPizza();
        pia = piza.createDeluxe();
        pia.setSize(Size.valueOf("SMALL"));
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

    /**
     * changes flavor of pizza
     * @param event
     */
    private void changeFlavor(Event event) {
        String flav = flavorComboBox.getValue().toString();
        if (flav.equals("DELUXE")) {
            pia = piza.createDeluxe();
            crustLabel.setText(""+ pia.getCrust());
            addButton.setDisable(true);
            removeButton.setDisable(true);
            getFlavor();
        }
        if (flav.equals("MEATZZA")) {
            pia = piza.createMeatzza();
            crustLabel.setText(""+ pia.getCrust());
            addButton.setDisable(true);
            removeButton.setDisable(true);
            getFlavor();
        }
        if (flav.equals("BBQ CHICKEN")) {
            pia = piza.createBBQChicken();
            crustLabel.setText(""+ pia.getCrust());
            addButton.setDisable(true);
            removeButton.setDisable(true);
            getFlavor();
        }
        if (flav.equals("BUILD YOUR OWN")) {
            pia = piza.createBuildYourOwn();
            crustLabel.setText(""+ pia.getCrust());
            addButton.setDisable(false);
            removeButton.setDisable(false);
            getFlavor();
        }
        topListView.getItems().clear();

        for (Topping top : pia.getToppingList()) {
            topListView.getItems().add(top);
        }
        changeSize();
    }

    /**
     * changes size of current pizza
     */
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

    /**
     * changes price of pizza
     */
    public void changePrice(){
        String priceString = df.format(pia.price());
        priceLabel.setText(priceString);
    }

    /**
     * adds topping to pizza
     * @param Event
     */
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

    /**
     * removes topping from pizza
     * @param Event
     */
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


    /**
     * adds pizza to order
     */
    public void addOrder(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pizza Added");
        alert.setHeaderText("Your pizza has been added to the order!");
        alert.setContentText("You can find your pizza in the current order section");
        alert.show();
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
    public void getFlavor(){
        String flav = flavorComboBox.getValue().toString();
        addButton.setDisable(true);
        removeButton.setDisable(true);
        if(flav.equals("DELUXE")){
            pia = piza.createDeluxe();
            piaImage = new Image(getClass().getResourceAsStream("/images/deluxeNYpizza.png"));
            piaView.setImage(piaImage);
        }
        if(flav.equals("MEATZZA")){
            pia = piza.createMeatzza();
            piaImage = new Image(getClass().getResourceAsStream("/images/meatzzaNYpizza.png"));
            piaView.setImage(piaImage);
        }
        if(flav.equals("BBQ CHICKEN")){
            pia = piza.createBBQChicken();
            piaImage = new Image(getClass().getResourceAsStream("/images/bbqchickenNYpizza.png"));
            piaView.setImage(piaImage);
        }
        if(flav.equals("BUILD YOUR OWN")){
            pia = piza.createDeluxe();
            piaImage = new Image(getClass().getResourceAsStream("/images/byoNYpizza.png"));
            piaView.setImage(piaImage);
        }
    }

}
