package com.example.btvnbuoi2;

public class FoodItem {
    private String name;
    private int currentPrice;
    private int oldPrice;
    private int imageResource;
    private int rating;

    public FoodItem(String name, int currentPrice, int oldPrice, int imageResource, int rating) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.oldPrice = oldPrice;
        this.imageResource = imageResource;
        this.rating = rating;
    }

    // Getters
    public String getName() { return name; }
    public int getCurrentPrice() { return currentPrice; }
    public int getOldPrice() { return oldPrice; }
    public int getImageResource() { return imageResource; }
    public int getRating() { return rating; }
}