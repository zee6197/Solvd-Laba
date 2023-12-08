package com.laba.solvd.HW_ShoppingMallApp.enums;


public enum PaymentMethod {
    CREDIT_CARD("Credit Card"),
    PAYPAL("PayPal"),
    CASH("Cash"),
    CHECK("Check"),
    WIRE_TRANSFER("Wire Transfer");

    private final String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public static PaymentMethod getByOption(int option) {
        switch (option) {
            case 1:
                return CREDIT_CARD;
            case 2:
                return PAYPAL;
            case 3:
                return CASH;
            case 4:
                return CHECK;
            case 5:
                return WIRE_TRANSFER;
            default:
                throw new IllegalArgumentException("Invalid payment method option: " + option);
        }
    }
}
