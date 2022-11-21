package com.example.project4;

import java.util.ArrayList;

/**
 * A class that stores information about a NY style pizza.
 * This class creates different types of pizzas under the
 * NY style pizza category
 * @author Anirudh Chauhan, Matthew Calora
 */

public class NYPizza implements PizzaFactory{
    public Crust crust;
    private ArrayList<Topping> toppings;

    /**
     * creates a BBQ Chicken pizza under the NY pizza category
     * @return null
     */
    @Override
    public Pizza createBBQChicken() {
        return null;
    }

    /**
     * creates a BYO pizza under the NY pizza category
     * @return null
     */
    @Override
    public Pizza createBuildYourOwn() {
        return null;
    }

    /**
     * creates deluxe pizza under the NY pizza category
     * @return null
     */
    @Override
    public Pizza createDeluxe() {
        return null;
    }

    /**
     * creates meat pizza under the NY pizza category
     * @return null
     */
    @Override
    public Pizza createMeatzza() {
        return null;
    }
}
