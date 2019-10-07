package com.example.groupproject;

public class Food {
    private String foodName;
    private double price;
    private double discountprice;
    private static final double DISCOUNT = 0.2;

    //private int imageResourceID;

    public Food(String foodName, double price, double discountprice){
        this.foodName = foodName;
        this.price = price;
        this.discountprice = discountprice;
    }

    public static final Food[] drinksFood = {
            new Food("Cola", 2.25, DISCOUNT * 2.25),
            new Food("Pepsi", 2.25, DISCOUNT * 2.25),
            new Food("Sprite", 2.25, DISCOUNT * 2.25),
            new Food("Root Beer", 2.25, DISCOUNT * 2.25),
            new Food("Ginger Ale", 2.25, DISCOUNT * 2.25),
            new Food("Iced Tea", 2.25, DISCOUNT * 2.25),
            new Food("Lemonade", 2.25, DISCOUNT * 2.25),

    };

    public String toString(){ return foodName; }

    public String getFoodName() { return foodName; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

}
