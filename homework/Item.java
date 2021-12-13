package com.galeeva.homework;

public class Item {

    private final String id;
    private String name;
    private final String price;

    public Item(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item(String id, String price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return id +
                ", " + name  +
                ", " + price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
