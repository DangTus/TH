package com.dmt.dangtus.learnandroid.model;

public class SinhVien {
    private String id, name;
    private double score;

    public SinhVien(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public SinhVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
