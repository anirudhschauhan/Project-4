package com.example.project4;

import java.util.ArrayList;

/**
 * A class that stores information about a deluxe pizza.
 * This class also includes a way to add and remove toppings
 * as well as calculate the current price of this deluxe pizza
 * @author Anirudh Chauhan, Matthew Calora
 */

public class Deluxe extends Pizza{
    public Deluxe(){

    }
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;


    /**
     * adds topping to current deluxe pizza
     * @param obj
     * @return boolean
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Topping){
            Topping newTop = (Topping) obj;
            ArrayList<Topping> newList = getToppingList();
            if(newList.contains(newTop)){ return false;}
            newList.add(newTop);
            setToppingList(newList);
            return true;
        }
        return false;
    }

    /**
     * removes topping from current deluxe pizza
     * @param obj
     * @return boolean
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Topping) {
            Topping newTop = (Topping) obj;
            ArrayList<Topping> newList = getToppingList();
            if (newList.contains(newTop)) {
                newList.remove(newTop);
                setToppingList(newList);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * returns price of current deluxe pizza
     * @return price
     */
    @Override
    public double price() {
        double price = this.getSize().getDeluxe();
        return price;
    }




}
