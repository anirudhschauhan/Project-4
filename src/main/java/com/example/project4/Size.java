package com.example.project4;

public enum Size {
    SMALL(14.99, 13.99, 15.99, 8.99),
    MEDIUM(16.99,15.99,17.99,10.99),
    LARGE(18.99,17.99,19.99, 12.99);


    private final double deluxe;
    private final double bbqchicken;
    private final double meatzza;
    private final double byo;

    Size(double deluxe,  double bbqchicken, double meatzza, double byo) {
        this.deluxe = deluxe;
        this.bbqchicken = bbqchicken;
        this.meatzza = meatzza;
        this.byo = byo;

    }

    public double getDeluxe() {
        return this.deluxe;
    }

    public double getBBQChicken() {
        return this.bbqchicken;
    }
    public double getMeatzza(){
        return this.meatzza;
    }
    public double getBuildYourOwn(){
        return this.byo;
    }


}


