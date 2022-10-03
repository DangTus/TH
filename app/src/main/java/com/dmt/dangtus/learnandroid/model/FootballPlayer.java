package com.dmt.dangtus.learnandroid.model;

import java.io.Serializable;

public class FootballPlayer implements Serializable {
    private String name, club;
    private int image, skill;
    private double price;
    private boolean like;

    public FootballPlayer(int image, String name, String club, double price, int skill, boolean like) {
        this.name = name;
        this.club = club;
        this.image = image;
        this.price = price;
        this.skill = skill;
        this.like = like;
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

    public int getSkill() {
        return skill;
    }

    public void setRating(int skill) {
        this.skill = skill;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
