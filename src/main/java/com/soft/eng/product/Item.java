package com.soft.eng.product;

import com.opencsv.bean.CsvBindByName;

public class Item {
    @CsvBindByName
    private int id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private double price;

    @CsvBindByName
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - ₹" + price + " - Qty: " + quantity;
    }
}
