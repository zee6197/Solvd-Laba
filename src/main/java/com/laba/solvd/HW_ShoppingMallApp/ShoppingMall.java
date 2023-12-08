package com.laba.solvd.HW_ShoppingMallApp;

import com.laba.solvd.HW_ShoppingMallApp.LinkedList.CustomLinkedList;
import com.laba.solvd.HW_ShoppingMallApp.people.Customer;
import com.laba.solvd.HW_ShoppingMallApp.people.Employee;
import com.laba.solvd.HW_ShoppingMallApp.shop.Inventory;
import com.laba.solvd.HW_ShoppingMallApp.shop.Shop;
import com.laba.solvd.HW_ShoppingMallApp.shop.Product;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Objects;
import java.util.*;

public class ShoppingMall {

    private String name;
    private LocalDate establishedDate;
    private int numberOfMalls = 0;


    // hierarchy here:
    private final Set<Shop> shops;
    private final Set<Employee> employees;
    private final Set<Customer> customers;


    public ShoppingMall(String name, LocalDate date) {
        this.name = name;
        this.establishedDate = date;
        // hierarchy here:
        this.shops = new HashSet<>();
        this.employees = new HashSet<>();
        this.customers = new HashSet<>();
    }

    private void incrementMallCount() {
        numberOfMalls++;
    }

    public int getNumberOfMalls() {
        return numberOfMalls;
    }

    public void addShop(Shop shop) {
        shops.add(shop);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    // A method with some logic
    public void printWelcomeMessage() {
        System.out.println("Welcome to " + name + "!");
    }


    // Method to add stock to a shop's inventory
    public void addStockToShop(String shopName, Product product, int quantity) {
        shops.stream()
                .filter(shop -> shop.getShopName().equals(shopName))
                .findFirst()
                .ifPresent(shop -> shop.getInventory().addStock(product, quantity));
    }

    // Method to apply a discount to all products in the mall
    public void applyDiscountToAllProducts(double discountRate) {
        shops.stream()
                .flatMap(shop -> shop.getInventory().getProductStock().keySet().stream())
                .forEach(product -> product.offerDiscount(discountRate));
    }


    @Override
    public String toString() {
        return "ShoppingMall{" +
                "name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, establishedDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ShoppingMall that = (ShoppingMall) obj;
        return Objects.equals(name, that.name) &&
                Objects.equals(establishedDate, that.establishedDate);
    }
}