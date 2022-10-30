package com.example.master_mechanic_app;

public class Items {
    String Name,availability,description;
    int price;

    public Items(){

    }
    public Items(String name, String availability, String description, int price) {
        Name = name;
        this.availability = availability;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
