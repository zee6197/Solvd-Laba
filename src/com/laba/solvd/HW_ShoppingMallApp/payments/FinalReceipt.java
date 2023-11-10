package com.laba.solvd.HW_ShoppingMallApp.payments;

import com.laba.solvd.HW_ShoppingMallApp.Checkout.CartItem;
import com.laba.solvd.HW_ShoppingMallApp.shop.Product;

import java.time.LocalDate;
import java.util.List;

public final class FinalReceipt {
    private final int receiptNumber;
    private final LocalDate issueDate;
    private final List<CartItem> itemsPurchased;
    private final double totalAmount;
    private final String paymentMethod;

    public FinalReceipt(int receiptNumber, List<CartItem> itemsPurchased, double totalAmount, String paymentMethod) {
        this.receiptNumber = receiptNumber;
        this.issueDate = LocalDate.now(); // Set issue date to current date
        this.itemsPurchased = itemsPurchased;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    // Method to print the receipt details
    public void printFinalReceiptDetails() {
        System.out.println("Final Receipt Number: " + receiptNumber);
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Items Purchased:");
        for (CartItem item : itemsPurchased) {
            Product product = item.getProduct();
            if (product != null) {
                System.out.println("Product Name: " + product.getName() + ", Unit Price: " + product.getPrice() + ", Quantity: " + item.getQuantity() + ", Total: " + (product.getPrice() * item.getQuantity()));
            }
        }
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Payment Method: " + paymentMethod);
    }

    // Getters for the final attributes
    public int getReceiptNumber() {
        return receiptNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public List<CartItem> getItemsPurchased() {
        return itemsPurchased;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
