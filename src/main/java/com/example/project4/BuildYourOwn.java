package com.example.project4;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza{
    private static final double TOPPING_COST = 1.59;
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

    @Override
    public double price() {
        double price = this.getSize().getBuildYourOwn();
        return price + (getToppingList().size() * TOPPING_COST);

    }
    public double newPrice(double price){
        return (price + TOPPING_COST);
    }


}
