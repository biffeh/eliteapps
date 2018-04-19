package com.byethost4.itisarndwebsite.elitelistapp;

public class Car
{
    private String brand;
    private String color;
    private int year;
    private String type;
    private String defect;

    public Car(String brand, String color, int year, String type, String defect) {
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.type = type;
        this.defect = defect;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }
}
