package com.example.project4;

import java.util.ArrayList;

/**
 * A class that stores information about a meat pizza.
 * Can add and remove the meat pizza. Can get price of
 * the meat pizza
 * @author Anirudh Chauhan, Matthew Calora
 */

public class Meatzza extends Pizza{
    /**
     * adds topping to current meat pizza
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
     * removes topping from current meat pizza
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
     * returns price of the current meat pizza
     * @return price
     */
    @Override
    public double price() {
        double price = this.getSize().getMeatzza();
        return price;
    }
}
