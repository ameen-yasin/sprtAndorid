package com.example.sport_shop.Model;

public class Item {
    private String name,price, rating,description;
    private int imageResourceId = HAS_IMAGE;
    private static final int HAS_IMAGE = -1;


    public Item(){}

    public Item(int imageResourceId, String name, String price, String rating) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Item(int imageResourceId, String name, String price) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return imageResourceId;
    }

    public void setImage(int image) {
        this.imageResourceId = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


}
