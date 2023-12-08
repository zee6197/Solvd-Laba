package com.laba.solvd.HW_ShoppingMallApp.enums;

public enum ProductCategory {
    ELECTRONICS("Electronics"),
    APPAREL("Apparel"),
    GROCERIES("Groceries"),
    BOOKS("Books"),
    HOME_GOODS("Home Goods");

    private final String category;

    ProductCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static ProductCategory getByOption(int option) {
        switch (option) {
            case 1:
                return ELECTRONICS;
            case 2:
                return APPAREL;
            case 3:
                return GROCERIES;
            case 4:
                return BOOKS;
            case 5:
                return HOME_GOODS;
            default:
                throw new IllegalArgumentException("Invalid category option: " + option);
        }
    }
}
