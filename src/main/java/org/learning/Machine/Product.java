package org.learning.Machine;

public class Product {
    private final int id;
    private int price;
    private String name;

    public Product(int id, String name, int price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
