package com.laba.solvd.HW_ShoppingMallApp.payments;

import java.util.Objects;

public class CashRegister {
    private static final double TAX_RATE = 0.08; // 8% Tax Rate
    private static double totalRevenue = 0;

    private int registerId;
    private double cashOnHand;

    public CashRegister(int registerId, double initialCash) {
        this.registerId = registerId;
        this.cashOnHand = initialCash;
    }

    public void printReceipt(double amount, double totalAmount) {
        System.out.println("Receipt - Register ID: " + registerId);
        System.out.println("Amount: " + amount);
        System.out.println("Tax: " + (amount * TAX_RATE));
        System.out.println("Total: " + totalAmount);
    }

    // Getter and Setter methods
    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public int getRegisterId() {
        return registerId;
    }

    public double getCashOnHand() {
        return cashOnHand;
    }

    public void setCashOnHand(double cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    // Overloading method for adding cash
    public void addCash(double amount) {
        this.cashOnHand += amount;
    }

    // Static method to reset the total revenue
    public static void resetTotalRevenue() {
        totalRevenue = 0;
    }

    @Override
    public String toString() {
        return "CashRegister{" +
                "registerId=" + registerId +
                ", cashOnHand=" + cashOnHand +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(registerId, cashOnHand);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CashRegister that = (CashRegister) obj;
        return registerId == that.registerId &&
                Double.compare(that.cashOnHand, cashOnHand) == 0;
    }
}
