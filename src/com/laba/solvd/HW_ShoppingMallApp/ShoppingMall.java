package com.laba.solvd.HW_ShoppingMallApp;

import java.time.LocalDate;
import java.util.Objects;

public class ShoppingMall {

    private static int numberOfMalls;
    private String name;
    private LocalDate establishedDate;

    public ShoppingMall(String name, LocalDate date) {
        this.name = name;
        this.establishedDate = date;
    }

    public ShoppingMall(String name) {
        this.name = name;
        incrementMallCount();
    }

    // Static initialization block
    static {
        // Initial count of malls
        numberOfMalls = 0;
    }

    private static void incrementMallCount() {
        numberOfMalls++;
    }

    public static int getNumberOfMalls() {
        return numberOfMalls;
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