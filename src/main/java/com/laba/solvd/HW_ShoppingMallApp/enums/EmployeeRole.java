package com.laba.solvd.HW_ShoppingMallApp.enums;

public enum EmployeeRole {
    MANAGER("Manager"),
    SALES("Sales Associate"),
    DEVELOPER("Software Developer"),
    MARKETING("Marketing Specialist"),
    HR("Human Resources");

    private final String description;

    EmployeeRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static EmployeeRole fromString(String text) {
        for (EmployeeRole role : EmployeeRole.values()) {
            if (role.description.equalsIgnoreCase(text)) {
                return role;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}