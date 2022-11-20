package com.example.project4;

import java.util.ArrayList;

public class StoreOrders implements Customizable{
    private  ArrayList<Order> storeOrders;
    Order ord;
    private int serialNum;
    public StoreOrders(){
        storeOrders = new ArrayList<>();
        ord = new Order();
        serialNum = 0;
    }
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            Order newOr = (Order) obj;
            storeOrders.add(newOr);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            Order newOr = (Order) obj;
            storeOrders.remove(newOr);
            return true;
        }
        return false;
    }
    protected ArrayList<Order> getStoreOrders(){
        if(storeOrders == null){
            storeOrders = new ArrayList<>();
        }
        return this.storeOrders;
    }

}
