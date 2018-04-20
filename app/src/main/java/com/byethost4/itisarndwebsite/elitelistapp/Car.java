package com.byethost4.itisarndwebsite.elitelistapp;

public class Car
{
    private int id;
    private String data;
    private String brand;
    private String color;
    private int year;
    private String type;
    private String defect;
    //Šitas konstruktorius veikia kliento pusėje
    public Car(String brand, String color, int year, String type, String defect) {
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.type = type;
        this.defect = defect;
    }
    //Sitas konstruktorius bus specialiai skirtas dirbti su db įrašais.
    public Car(int id, String data, String brand, String color, int year, String type, String defect) {
        this.id = id;
        this.data = data;
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.type = type;
        this.defect = defect;
    }

    public String getData() {
        return data;
    }

    public int getId() {
        return id;
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
