package com.example.project4;

import java.util.ArrayList;

public class NYPizza implements PizzaFactory{
    public Crust crust;
    private ArrayList<Topping> toppings;
    @Override
    public Pizza createBBQChicken() {
        return null;
    }

    @Override
    public Pizza createBuildYourOwn() {
        return null;
    }

    @Override
    public Pizza createDeluxe() {
        return null;
    }

    @Override
    public Pizza createMeatzza() {
        return null;
    }
}
