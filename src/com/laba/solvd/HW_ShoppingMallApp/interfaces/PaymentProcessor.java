package com.laba.solvd.HW_ShoppingMallApp.interfaces;

import com.laba.solvd.HW_ShoppingMallApp.exceptions.PaymentProcessingException;
import com.laba.solvd.HW_ShoppingMallApp.payments.Payment;

public interface PaymentProcessor {


    // PaymentProcessor methods

    void processPayment() throws PaymentProcessingException;

    // PaymentProcessor methods
    void processPayment(Payment payment);

    boolean validatePaymentMethod(String method);
}
