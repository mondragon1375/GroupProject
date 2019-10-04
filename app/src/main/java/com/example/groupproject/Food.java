package com.example.groupproject;

public class Food {
    private String foodName;
    private String description;
    private double price;
    //private int imageResourceID;

    public Food(String foodName, String description, double price){
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        //this.imageResourceID = imageResourceID;
    }

    public static final Food[] drinksFood = {
            new Food("Sample Food", "Sample Description", 3.99)
    };

    public String toString(){ return foodName; }

    public String getFoodName() { return foodName; }

    public String getDescription() { return description; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    //public int getImageResourceID() { return imageResourceID;}

}
