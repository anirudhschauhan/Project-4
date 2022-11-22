package com.example.project4;

import java.util.ArrayList;

/**
 * A class that stores information about a customizable pizza.
 * Can add and remove the customizable pizza.
 * Can set and get size of the customizable pizza.
 * Can set and get crust of the customizable pizza.
 * Can set and get topping list of the customizable pizza.
 * Can get price of the customizable pizza
 * @author Anirudh Chauhan, Matthew Calora
 */
public abstract class Pizza implements Customizable{
    public Pizza(){

    }

    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();
    public ArrayList<Topping> getToppingList(){
        if(toppings ==null){
            toppings = new ArrayList<>();
        }
        return toppings;
    }

    /**
     * sets the topping list for the pizza
     * @param topping
     */
    public void setToppingList(ArrayList<Topping> topping){
        topping = this.toppings;
    }

    /**
     * returns size of pizza
     * @return pizza size
     */
    public Size getSize(){
        return this.size;
    }

    /**
     * sets size of pizza
     * @param size
     */
    public void setSize(Size size){
        this.size = size;
    }

    /**
     * adds topping list
     * @param top
     */
    public void addToppingList(Topping top){
        toppings.add(top);
    }

    /**
     * removes topping list
     * @param top
     */
    public void removeToppingList(Topping top){
        toppings.remove(top);
    }

    /**
     * returns the crust type of the current pizza
     * @return crust of pizza
     */
    public Crust getCrust() {
        return this.crust;
    }

    /**
     * sets the crust type of the current pizza
     * @param crust
     */
    public void setCrust(Crust crust){
        this.crust = crust;
    }

    /**
     * prints the array list containing current toppings
     * @return
     */
    public String printArrayList(){
        String stri = "";
        for(int i = 0; i < getToppingList().size(); i++){
            stri += "" + getToppingList().get(i);
            if(i < getToppingList().size()){
                stri +=", ";
            }
        }
        return stri;
    }




}
