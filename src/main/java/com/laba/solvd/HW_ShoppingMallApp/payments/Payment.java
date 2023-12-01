package com.laba.solvd.HW_ShoppingMallApp.payments;

import com.laba.solvd.HW_ShoppingMallApp.Checkout.CartItems;
import com.laba.solvd.HW_ShoppingMallApp.Checkout.Checkout;
import com.laba.solvd.HW_ShoppingMallApp.interfaces.DisplayInfo;
import com.laba.solvd.HW_ShoppingMallApp.interfaces.PaymentProcessor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Payment implements PaymentProcessor, DisplayInfo {

    private static final Logger LOGGER = LogManager.getLogger(Payment.class);
    // Static variable to generate unique payment IDs
    private static int nextPaymentId = 1;
    private int paymentId;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;

    private List<CartItems> itemsPrice;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Checkout.class.getName());

    // Custom constructor that initializes a payment with an amount and method
    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentId = getNextPaymentId();
        this.paymentMethod = paymentMethod;
        this.paymentDate = LocalDate.now();
        //this.itemsPrice = itemsPrice;
    }

    // Static method to reset payment IDs, for example, could be used in testing
    public static void resetPaymentIdCounter() {
        nextPaymentId = 1;
    }

    // PaymentProcessor methods
    @Override
    public void processPayment(Payment payment) {
        // Logic to process the payment
        LOGGER.info("Processing payment of " + payment.amount + " via " + payment.paymentMethod);
    }

    @Override
    public boolean validatePaymentMethod(String method) {
        // Implement the logic to validate the payment method
        // This is a placeholder implementation
        return method != null && !method.isEmpty();
    }

    // Getters and setters
    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Static method to get the next payment ID and increment the static counter
    private static int getNextPaymentId() {
        return nextPaymentId++;
    }

    // Method to process payment logic
    public void processPayment() {
        // Logic to process the payment
        logger.info("Processing payment of " + amount + " via " + paymentMethod);
        // Further logic would follow
    }

    @Override
    public void showAttributes() {

    }

    @Override
    public void showDetails() {

    }


    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, amount, paymentDate, paymentMethod);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Payment payment = (Payment) obj;
        return paymentId == payment.paymentId &&
                Double.compare(payment.amount, amount) == 0 &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(paymentMethod, payment.paymentMethod);
    }
}
