package com.soft.eng.product;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters, Setters, toString()
    @Override
    public String toString() {
        return id + " - " + name + " - ₹" + price + " - Qty: " + quantity;
    }
}
