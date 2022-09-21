package model;

import java.io.Serializable;

public class FootballPlayer implements Serializable {
    private String name, club;
    private int image;
    private double price;

    public FootballPlayer(String name, String club, int image, double price) {
        this.name = name;
        this.club = club;
        this.image = image;
        this.price = price;
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
}
