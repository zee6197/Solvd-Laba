package com.laba.solvd.HW_ShoppingMallApp.Checkout;

import com.laba.solvd.HW_ShoppingMallApp.shop.Product;

public class CartItem {
    private Product product;
    private int quantity;

    // Constructor that initializes the CartItem with a Product and its quantity
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getter for the product
    public Product getProduct() {
        return product;
    }

    // Setter for the product
    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter for the quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        // Implement toString logic for CartItem
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int hashCode() {
        // Implement hashCode logic for CartItem
        return java.util.Objects.hash(product, quantity);
    }

    @Override
    public boolean equals(Object obj) {
        // Implement equals logic for CartItem
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CartItem cartItem = (CartItem) obj;
        return quantity == cartItem.quantity &&
                java.util.Objects.equals(product, cartItem.product);
    }
}
