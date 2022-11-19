package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.ListView;

public class StoreOrderController implements Initializable {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @FXML
    private ListView<Order> orderListView;
    private Order order;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Order ord : MainController.getStoreOrd().getStoreOrders()) {
            orderListView.getItems().add(ord);
        }
        //public static final
    }
}
