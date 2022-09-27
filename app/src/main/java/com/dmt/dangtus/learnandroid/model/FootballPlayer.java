package com.dmt.dangtus.learnandroid.model;

import java.io.Serializable;

public class FootballPlayer implements Serializable {
    private String name, club, unit;
    private int image;
    private double price, rating;

    public FootballPlayer(int image, String name, String club, double price, String unit, double rating) {
        this.name = name;
        this.club = club;
        this.unit = unit;
        this.image = image;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
