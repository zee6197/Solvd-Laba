package com.laba.solvd.HW_ShoppingMallApp.interfaces;

import com.laba.solvd.HW_ShoppingMallApp.shop.Product;

public interface InventoryManagement {
    void addStock(Product product, int quantity);
    int checkStock(Product product);
}