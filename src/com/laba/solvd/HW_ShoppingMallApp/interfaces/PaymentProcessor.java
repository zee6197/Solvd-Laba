package com.laba.solvd.HW_ShoppingMallApp.interfaces;

import com.laba.solvd.HW_ShoppingMallApp.payments.Payment;

public interface PaymentProcessor {

    void processPayment(Payment payment);

    boolean validatePaymentMethod(String method);
}
