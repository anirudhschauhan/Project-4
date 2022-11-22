package com.example.project4;


import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A class that stores information about pizzas in
 * a current order. This includes ways to add and
 * remove pizzas. Can set and get sales tax. Can get the
 * serial number of the order and number of pizzas in
 * the order
 * @author Anirudh Chauhan, Matthew Calora
 */


public class Order implements Customizable{

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private ArrayList<Pizza> pizzaOrders;
    protected int serial;
    private Pizza pia;
    private double taxPrice;
    public Order(){
        pizzaOrders = new ArrayList<>();
        serial = MainController.orderNumber();

    }


    protected ArrayList<Pizza>getOrders(){
        if(pizzaOrders ==null){
            pizzaOrders = new ArrayList<>();
        }
        return this.pizzaOrders;
    }

    /**
     * adds pizza to current order
     * @param obj
     * @return boolean
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Pizza) {
            Pizza newZa = (Pizza) obj;
            pizzaOrders.add(newZa);
            return true;
        }
        return false;
    }

    /**
     * removes pizza from current order
     * @param obj
     * @return boolean
     */
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

    /**
     * returns the number of pizzas in
     * the current order
     * @return
     */

    /**
     * gets serial number of current order
     * @return
     */
    public int getOrderSerial(){
        return serial;
    }

    /**
     * sets tax price for the current order
     * @param price
     */
    public void setTaxPrice(double price){
        this.taxPrice = price;
    }

    /**
     * gets tax price for the current order
     * @return
     */
    public double getTaxPrice(){
        return this.taxPrice;
    }

}
