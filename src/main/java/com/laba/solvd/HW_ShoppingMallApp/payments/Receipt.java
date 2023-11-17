package com.laba.solvd.HW_ShoppingMallApp.payments;

import com.laba.solvd.HW_ShoppingMallApp.Checkout.CartItems;
import com.laba.solvd.HW_ShoppingMallApp.shop.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class Receipt {
    // Final variable
    private final int receiptNumber;
    private final LocalDate issueDate;
    private List<CartItems> itemsPurchased;
    private static int receiptCounter = 0;
    private double totalAmount;
    private String paymentMethod;

    // Constructor
    public Receipt(List<CartItems> itemsPurchased, double totalAmount, String paymentMethod) {
        this.receiptNumber = ++receiptCounter; // Unique receipt number
        this.issueDate = LocalDate.now(); // Current date
        this.itemsPurchased = itemsPurchased;
        this.totalAmount = totalAmount;
        this.paymentMethod = String.valueOf(paymentMethod);
    }

    // Static method to access the static counter variable
    public static int getNextReceiptNumber() {
        return receiptCounter + 1;
    }

    // Final method to print the receipt details
    public final void finalPrintReceipt() {
        receiptNumber();
    }

    private void receiptNumber() {
        System.out.println("Receipt Number: " + receiptNumber);
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Items Purchased:");
        for (CartItems item : itemsPurchased) {
            Product product = item.getProduct();
            if (product != null) {
                System.out.println("Product ID: " + product.getName() + ", Product Name: " + product.getName() + ", Unit Price: " + product.getPrice() + ", Quantity: " + item.getQuantity() + ", Total: " + (product.getPrice() * item.getQuantity()));
            }
        }
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Payment Method: " + paymentMethod);
    }

    // Getter and setter methods
    public int getReceiptNumber() {
        return receiptNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public List<CartItems> getItemsPurchased() {
        return itemsPurchased;
    }

    public void setItemsPurchased(List<CartItems> itemsPurchased) {
        this.itemsPurchased = itemsPurchased;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Method to print the receipt details
    public void printReceipt() {
        receiptNumber();
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptNumber=" + receiptNumber +
                ", issueDate=" + issueDate +
                ", itemsPurchased=" + itemsPurchased +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptNumber, issueDate, itemsPurchased, totalAmount, paymentMethod);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Receipt receipt = (Receipt) obj;
        return receiptNumber == receipt.receiptNumber &&
                Double.compare(receipt.totalAmount, totalAmount) == 0 &&
                Objects.equals(issueDate, receipt.issueDate) &&
                Objects.equals(itemsPurchased, receipt.itemsPurchased) &&
                Objects.equals(paymentMethod, receipt.paymentMethod);
    }
}
