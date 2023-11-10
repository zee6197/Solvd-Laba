package com.laba.solvd.HW_ShoppingMallApp;

import com.laba.solvd.HW_ShoppingMallApp.Checkout.Cart;
import com.laba.solvd.HW_ShoppingMallApp.Checkout.CartItem;
import com.laba.solvd.HW_ShoppingMallApp.payments.Payment;
import com.laba.solvd.HW_ShoppingMallApp.payments.Receipt;
import com.laba.solvd.HW_ShoppingMallApp.shop.Product;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<String, Product> productCatalog = new HashMap<>();
    public static final Cart cart = new Cart();
    public static Payment payment;
    public static Receipt receipt;

    public static void main(String[] args) {
        // Populate the product catalog with some products for the shopping mall
        populateProductCatalog();

        // Process command-line arguments
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if ("Checkout".equalsIgnoreCase(arg) && i + 1 < args.length) {
                // Checkout command found, process payment
                String paymentMethod = args[i + 1];
                checkout(paymentMethod);
                break;
            } else if (i + 1 < args.length) {
                // Assume product name and quantity are provided
                try {
                    int quantity = Integer.parseInt(args[i + 1]);
                    addProductToCart(arg, quantity);
                    i++; // Skip next argument as it's already processed as quantity
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity: " + args[i + 1]);
                    return;
                }
            } else {
                System.out.println("Invalid input format.");
                return;
            }
        }
    }

    private static void populateProductCatalog() {
        // Adding some products to the product catalog
        productCatalog.put("Bread", new Product("bread", "Bread", 2.99));
        productCatalog.put("Milk", new Product("milk", "Milk", 1.49));
        // Add additional products as needed
    }

    private static void addProductToCart(String productName, int quantity) {
        Product product = productCatalog.get(productName);

        if (product == null) {
            System.out.println("Product not found: " + productName);
            return;
        }

        CartItem cartItem = new CartItem(product, quantity);
        cart.addCartItem(cartItem);
        System.out.println("Added " + quantity + " of " + productName + " to the cart.");
    }

    private static void checkout(String paymentMethod) {
        double total = cart.calculateTotal();
        payment = new Payment(total, paymentMethod);
        payment.processPayment();

        receipt = new Receipt(cart.getCartItems(), total, paymentMethod);
        receipt.finalPrintReceipt(); // Using the final method to print receipt
    }
}
