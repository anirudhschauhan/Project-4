package com.example.project4;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;




public class Order implements Customizable{

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private ArrayList<Pizza> pizzaOrders;
    protected int serial;
    public Order(){
        pizzaOrders = new ArrayList<>();
    }


/*
    protected static ArrayList<ArrayList<Pizza>> getOrderList(){
        if(storeOrders ==null){
            storeOrders = new ArrayList<>();
        }
        return storeOrders;
    }

    protected static void addToOrderList(ArrayList<Pizza> za){
            if(storeOrders ==null){
                storeOrders = new ArrayList<>();
            }
            storeOrders.add(za);
    }

    @Override
    public String toString() {
        String str;
        str = "" + "";
        return str;
    }

 */
    protected ArrayList<Pizza>getOrders(){
        if(pizzaOrders ==null){
            pizzaOrders = new ArrayList<>();
        }
        return this.pizzaOrders;
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Pizza) {
            Pizza newZa = (Pizza) obj;
            pizzaOrders.add(newZa);
            return true;
        }
        return false;
    }
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Pizza){
            Pizza newZa = (Pizza) obj;
            if(pizzaOrders.remove(newZa)){
                return true;
            }
        }
        return false;
    }
    public int getOrderSize(){
        return pizzaOrders.size();
    }
    public void setOrderSerial(int serial){
        this.serial = serial;
    }
    public int getOrderSerial(){
        return this.serial;
    }
}
