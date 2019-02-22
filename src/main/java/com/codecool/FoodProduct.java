package com.codecool;

import java.util.Date;

public class FoodProduct extends Product{

    private int calories;
    private Date bestBefore;

    public FoodProduct(long barcode, String name, String manufacturer, int calories, Date bestBefore) {
        super(barcode, name, manufacturer);
        this.calories = calories;
        this.bestBefore = bestBefore;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isStillConsumable() {

    }

}
