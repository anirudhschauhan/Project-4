package com.example.project4;


/**
 * class that stores the different sizes of pizzas and their prices
 * @author Anirudh Chauhan, Matthew Calora
 */
public enum Size {
    SMALL(14.99, 13.99, 15.99, 8.99),
    MEDIUM(16.99,15.99,17.99,10.99),
    LARGE(18.99,17.99,19.99, 12.99);


    private final double deluxe;
    private final double bbqchicken;
    private final double meatzza;
    private final double byo;

    /**
     * Price assignment depending on type of pizza
     * @param deluxe
     * @param bbqchicken
     * @param meatzza
     * @param byo
     */
    Size(double deluxe, double bbqchicken, double meatzza, double byo) {
        this.deluxe = deluxe;
        this.bbqchicken = bbqchicken;
        this.meatzza = meatzza;
        this.byo = byo;

    }

    /**
     * getter for deluxe pizza
     * @return deluxe pizza
     */
    public double getDeluxe() {
        return this.deluxe;
    }

    /**
     * getter for BBQ Chicken pizza
     * @return bbq chicken pizza
     */
    public double getBBQChicken() {
        return this.bbqchicken;
    }

    /**
     * getter for meat pizza
     * @return meat pizza
     */
    public double getMeatzza(){
        return this.meatzza;
    }

    /**
     * getter for "build your own" pizza
     * @return byo pizza
     */
    public double getBuildYourOwn(){
        return this.byo;
    }


}


