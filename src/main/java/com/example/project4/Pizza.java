package com.example.project4;

import java.util.ArrayList;

public abstract class Pizza implements Customizable{
    public Pizza(){

    }

    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    private String style;
    public abstract double price();
    public ArrayList<Topping> getToppingList(){
        if(toppings ==null){
            toppings = new ArrayList<>();
        }
        return toppings;
    }
    public void setToppingList(ArrayList<Topping> topping){
        topping = this.toppings;
    }
    public Size getSize(){
        return this.size;
    }
    public void setSize(Size size){
        this.size = size;
    }
    public void addToppingList(Topping top){
        toppings.add(top);
    }
    public void removeToppingList(Topping top){
        toppings.remove(top);
    }

    public Crust getCrust() {
        return this.crust;
    }
    public void setCrust(Crust crust){
        this.crust = crust;
    }
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
