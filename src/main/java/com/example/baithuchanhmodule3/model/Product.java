package com.example.baithuchanhmodule3.model;

public class Product {
    private  int id;
    private String name;
    private Double price;
    private int amount;
    private String color;
    private String describe;
    private Category category;

    public Product() {
    }

    public Product(int id, String name, Double price, int amount, String color, String describe, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.describe = describe;
        this.category = category;
    }

    public Product(String name, Double price, int amount, String color, String describe, Category category) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.describe = describe;
        this.category = category;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", color='" + color + '\'' +
                ", describe='" + describe + '\'' +
                ", category=" + category +
                '}';
    }
}
