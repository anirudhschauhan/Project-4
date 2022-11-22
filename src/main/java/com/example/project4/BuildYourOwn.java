package com.example.project4;

import java.util.ArrayList;


/**
 * A class that stores information about a BYO pizza.
 * This class also includes a way to add and remove toppings
 * as well as calculate the current price of this BYO pizza
 * @author Anirudh Chauhan, Matthew Calora
 */
public class BuildYourOwn extends Pizza {
    private static final double TOPPING_COST = 1.59;

    /**
     * adds topping to current BYO pizza
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
     * removes topping from current BYO pizza
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
     * calculates and returns price
     * of the current BYO pizza
     * @return price
     */
    @Override
    public double price() {
        double price = this.getSize().getBuildYourOwn();
        return price + (getToppingList().size() * TOPPING_COST);

    }
    /*public double newPrice(double price){
        return (price + TOPPING_COST);
    }*/




}
