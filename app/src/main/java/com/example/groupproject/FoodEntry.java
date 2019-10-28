package com.example.groupproject;

public class FoodEntry {
    private String foodName;
    private String foodCost;

    public FoodEntry(String foodName, String foodCost) {
        this.foodName = foodName;
        this.foodCost = foodCost;
    }

    public String toString() {
        return foodName + ", " + foodCost;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String name) {
        this.foodName = foodName;
    }

    public String getfoodCost() {
        return foodCost;
    }

    public void setFoodCost(String foodCost) {
        this.foodCost = foodCost;
    }
}
