package com.laba.solvd.HW_ShoppingMallApp.enums;


public enum CustomerType {
    REGULAR("Regular"),
    MEMBER("Member"),
    VIP("VIP"),
    FIRST_TIME("First Time"),
    RETURNING("Returning");

    private final String type;

    CustomerType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static CustomerType fromString(String text) {
        for (CustomerType type : CustomerType.values()) {
            if (type.type.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
