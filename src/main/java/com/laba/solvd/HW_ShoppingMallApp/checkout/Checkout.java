package com.laba.solvd.HW_ShoppingMallApp.checkout;

import com.laba.solvd.HW_ShoppingMallApp.interfaces.Discountable;
import com.laba.solvd.HW_ShoppingMallApp.interfaces.PaymentProcessor;
import com.laba.solvd.HW_ShoppingMallApp.payments.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Checkout implements Discountable, PaymentProcessor {
    private List<CartItems> cartItems;
    private int price = 1;

    public Checkout() {
        this.cartItems = new ArrayList<>();
    }

    public void addCartItem(CartItems item) {
        this.cartItems.add(item);
    }

    public List<CartItems> getCartItems() {
        return this.cartItems;
    }

    private final Logger logger = Logger.getLogger(Checkout.class.getName());

    public double calculateTotal() {
        return cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public void processPayment(Payment payment) {
        // Logic to process the payment
        logger.info("Processing payment of " + payment.getAmount() + " via " + payment.getPaymentMethod());
        // Further logic would follow
    }

    @Override
    public void processPayment() {

    }

    @Override
    public boolean validatePaymentMethod(String method) {
        return method != null && !method.isEmpty();
    }


    @Override
    public void offerDiscount(double discountRate) {
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

    @Override
    public String toString() {
        return "Checkout{" +
                "cartItems=" + cartItems +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItems);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Checkout cart = (Checkout) obj;
        return Objects.equals(cartItems, cart.cartItems);
    }
}
