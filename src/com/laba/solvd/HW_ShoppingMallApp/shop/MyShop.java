package com.laba.solvd.HW_ShoppingMallApp.shop;

import java.util.Objects;

public class MyShop {
    private String shopName;
    private Inventory inventory; // Composition example

    public MyShop(String shopName) {
        this.shopName = shopName;
        this.inventory = new Inventory(); // Connecting classes in a hierarchy
    }

    // Getters and Setters
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    // A method with logic
    public void restockInventory(Product product, int quantity) {
        inventory.addProduct(product, quantity);
    }

    // Overloaded methods
    public void openShop() {
        System.out.println(shopName + " is now open.");
    }
    public void openShop(String managerName) {
        System.out.println(shopName + " is now open, managed by " + managerName + ".");
    }

    @Override
    public String toString() {
        return "MyShop{" +
                "shopName='" + shopName + '\'' +
                ", inventory=" + inventory +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopName, inventory);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyShop myShop = (MyShop) obj;
        return Objects.equals(shopName, myShop.shopName) &&
                Objects.equals(inventory, myShop.inventory);
    }
}