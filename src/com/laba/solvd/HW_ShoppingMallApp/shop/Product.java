package com.laba.solvd.HW_ShoppingMallApp.shop;

import com.laba.solvd.HW_ShoppingMallApp.Checkout.AbstractItem;
import com.laba.solvd.HW_ShoppingMallApp.interfaces.Discountable;

public class Product extends AbstractItem implements Discountable {
    private String name;
    private double price;

    // Constructor that initializes a Product with a name and price
    public Product(String id, String name, double price) {
        super(id, name);
        this.price = price;
    }


    // Implementing Discountable methods
    @Override
    public void applyDiscount(double discountRate) {
        if (isEligibleForDiscount()) {
            this.price *= (1 - discountRate);
            System.out.println("Discount applied. New price: " + this.price);
        } else {
            System.out.println("Product is not eligible for discount.");
        }
    }

    @Override
    public boolean isEligibleForDiscount() {
        // All products are eligible for simplicity
        return true;
    }


    // Getter for the name
    public String getName() {
        return name;
    }

    // Setter for the name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the price
    public double getPrice() {
        return price;
    }

    // Setter for the price
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 &&
                java.util.Objects.equals(name, product.name);
    }
}
