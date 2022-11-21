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

        Pizza pia = new BBQChicken();

        pia.setCrust(Crust.valueOf("THIN"));
        pia.add(Topping.valueOf("BBQCHICKEN"));
        pia.add(Topping.valueOf("GREENPEPPER"));
        pia.add(Topping.valueOf("PROVOLONE"));
        pia.add(Topping.valueOf("CHEDDAR"));
        return pia;
    }

    /**
     * creates a BYO pizza under the NY pizza category
     * @return null
     */
    @Override
    public Pizza createBuildYourOwn() {

        Pizza pia = new BuildYourOwn();

        pia.setCrust(Crust.valueOf("HANDTOSSED"));
        return pia;
    }

    /**
     * creates deluxe pizza under the NY pizza category
     * @return null
     */
    @Override
    public Pizza createDeluxe() {


        Pizza pia = new Deluxe();

        pia.setCrust(Crust.valueOf("BROOKLYN"));
        pia.add(Topping.valueOf("SAUSAGE"));
        pia.add(Topping.valueOf("PEPPERONI"));
        pia.add(Topping.valueOf("GREENPEPPER"));
        pia.add(Topping.valueOf("ONION"));
        pia.add(Topping.valueOf("MUSHROOM"));
        return pia;
    }

    /**
     * creates meat pizza under the NY pizza category
     * @return null
     */
    @Override
    public Pizza createMeatzza() {

        Pizza pia = new Meatzza();

        pia.setCrust(Crust.valueOf("HANDTOSSED"));
        pia.add(Topping.valueOf("SAUSAGE"));
        pia.add(Topping.valueOf("PEPPERONI"));
        pia.add(Topping.valueOf("BEEF"));
        pia.add(Topping.valueOf("HAM"));
        return pia;
    }
}
