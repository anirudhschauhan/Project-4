package com.example.project4;

/**
 * Interface for the pizza factory
 * @author Anirudh Chauhan, Matthew Calora
 */

public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}