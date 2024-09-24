package com.rafalopez.examen.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String  description;
    private int stock;
    private double price;

    public Product(String code, String description, int stock, double price) {
        this.code = code;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public Product() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}