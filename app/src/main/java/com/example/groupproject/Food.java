package com.example.groupproject;

public class Food {
    private String foodName;
    private double price;
    private double discountprice;
    //private int imageResourceID;

    public Food(String foodName, double price, double discountprice){
        this.foodName = foodName;
        this.price = price;
        this.discountprice = discountprice;
    }

    public static final Food[] drinksFood = {
            new Food("Cola"

    public String toString(){
        return foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

}
