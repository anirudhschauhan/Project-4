package com.example.project4;

public class ChicagoPizza implements PizzaFactory{
    @Override
    public Pizza createBBQChicken() {
        Pizza pia = new BBQChicken();

        pia.setCrust(Crust.valueOf("PAN"));
        pia.add(Topping.valueOf("BBQCHICKEN"));
        pia.add(Topping.valueOf("GREENPEPPER"));
        pia.add(Topping.valueOf("PROVOLONE"));
        pia.add(Topping.valueOf("CHEDDAR"));
        return pia;

    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza pia = new BuildYourOwn();

        pia.setCrust(Crust.valueOf("PAN"));
        return pia;
    }

    @Override
    public Pizza createDeluxe() {
        Pizza pia = new Deluxe();

        pia.setCrust(Crust.valueOf("DEEPDISH"));
        pia.add(Topping.valueOf("SAUSAGE"));
        pia.add(Topping.valueOf("PEPPERONI"));
        pia.add(Topping.valueOf("GREENPEPPER"));
        pia.add(Topping.valueOf("ONION"));
        pia.add(Topping.valueOf("MUSHROOM"));
        return pia;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza pia = new Meatzza();

        pia.setCrust(Crust.valueOf("STUFFED"));
        pia.add(Topping.valueOf("SAUSAGE"));
        pia.add(Topping.valueOf("PEPPERONI"));
        pia.add(Topping.valueOf("BEEF"));
        pia.add(Topping.valueOf("HAM"));
        return pia;

    }
}
