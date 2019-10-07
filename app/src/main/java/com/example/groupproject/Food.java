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
            new Food("Iced Tea", 1.75, DISCOUNT * 1.75),
            new Food("Lemonade", 2.00, DISCOUNT * 2.00),

    };

    public static final Food[] kidsMenu = {
            new Food("Calamari", 8.75, DISCOUNT * 8.75),
            new Food("Buffalo Wings", 6.35, DISCOUNT * 6.35),
            new Food("Chips and Guacomole", 5.25, DISCOUNT * 5.25),
            new Food("New York Steak", 15.75, DISCOUNT * 15.75),
            new Food("Lasagna", 8.75, DISCOUNT * 8.75),
            new Food("Sushi", 12.35, DISCOUNT * 12.35),
            new Food("Salmon", 15.00, DISCOUNT * 15.00),
            new Food("Cheeseburger", 18.00, DISCOUNT * 18.00)
    };

    public static final Food[] adultsMenu = {
            new Food("Loaded Nachos", 7.85, DISCOUNT * 7.85),
            new Food("Buffalo Chicken Bites", 6.75, DISCOUNT * 6.75),
            new Food("Chips and Guacomole", 5.25, DISCOUNT * 5.25),
            new Food("Avocado Egg Rolls", 10.25, DISCOUNT * 10.25),
            new Food("Mozarella Flat Bread", 9.45, DISCOUNT * 9.45),
            new Food("Linguine with Alfredo", 13.75, DISCOUNT * 13.75),
            new Food("Full Stack of Ribs", 23.55, DISCOUNT * 23.55),
            new Food("Impossible Burger", 16.45, DISCOUNT * 16.45),
            new Food("Filet Mignon", 19.95, DISCOUNT * 19.95),
            new Food("Deep-Dish Pizza", 16.75, DISCOUNT * 16.75),
            new Food("Taco Salad", 11.75, DISCOUNT * 11.75)
    };
    
    public String toString(){ return foodName; }

    public String getFoodName() { return foodName; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

}
