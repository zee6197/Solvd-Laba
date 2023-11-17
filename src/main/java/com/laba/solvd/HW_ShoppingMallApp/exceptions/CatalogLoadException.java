package com.laba.solvd.HW_ShoppingMallApp.exceptions;

public class CatalogLoadException extends Exception {

    public CatalogLoadException(String message) {

        super(message);
    }

    public CatalogLoadException(String message, Throwable cause) {

        super(message, cause);
    }
}