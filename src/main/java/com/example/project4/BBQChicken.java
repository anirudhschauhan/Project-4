package com.example.project4;

import java.util.ArrayList;


/**
 * A class that stores information about a BBQ chicken pizza.
 * This class also includes a way to add and remove toppings
 * as well as calculate the current price of this
 * BBQ chicken pizza
 * @author Anirudh Chauhan, Matthew Calora
 */
public class BBQChicken extends Pizza{
    public BBQChicken(){

    }

    /**
     * adds topping to current BBQ chicken pizza
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
     * removes topping from current BBQ chicken pizza
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
     * returns price of the current BBQ chicken pizza
     * @return price
     */
    @Override
    public double price() {
        double price = this.getSize().getBBQChicken();
        return price;
    }
}
