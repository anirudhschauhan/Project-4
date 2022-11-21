package com.example.project4;

import java.util.ArrayList;

/**
 * A class that stores information about pizza orders under
 * store orders. Can add and remove pizzas from store orders.
 * Can return all store orders
 * @author Anirudh Chauhan, Matthew Calora
 */

public class StoreOrders implements Customizable{
    private  ArrayList<Order> storeOrders;

    public StoreOrders(){
        storeOrders = new ArrayList<>();
    }

    /**
     * adds pizza to store order
     * @param obj
     * @return boolean
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            Order newOr = (Order) obj;
            storeOrders.add(newOr);
            return true;
        }
        return false;
    }

    /**
     * removes pizza from store order
     * @param obj
     * @return
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            Order newOr = (Order) obj;
            storeOrders.remove(newOr);
            return true;
        }
        return false;
    }

    /**
     * returns entire list of store orders
     * @return storeOrders
     */
    protected ArrayList<Order> getStoreOrders(){
        if(storeOrders == null){
            storeOrders = new ArrayList<>();
        }
        return this.storeOrders;
    }

}
