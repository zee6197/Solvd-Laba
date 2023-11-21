package com.laba.solvd.HW_ShoppingMallApp;

import com.laba.solvd.HW_ShoppingMallApp.Checkout.Checkout;
import com.laba.solvd.HW_ShoppingMallApp.Checkout.CartItems;
import com.laba.solvd.HW_ShoppingMallApp.LinkedList.CustomLinkedList;
import com.laba.solvd.HW_ShoppingMallApp.exceptions.InvalidQuantityException;
import com.laba.solvd.HW_ShoppingMallApp.exceptions.ProductNotFoundException;
import com.laba.solvd.HW_ShoppingMallApp.payments.Payment;
import com.laba.solvd.HW_ShoppingMallApp.payments.Receipt;
import com.laba.solvd.HW_ShoppingMallApp.shop.Product;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainWithScanner {

    public static final Map<String, Product> productCatalog = new HashMap<>();
    public static final Checkout cart = new Checkout();
    public static Payment payment;
    public static Receipt receipt;

    public static void main(String[] args) {


        CustomLinkedList<Product> productList = new CustomLinkedList<>();

        // Create some Product objects
        Product product1 = new Product("1", "Product1", 10.0);
        Product product2 = new Product("2", "Product2", 20.0);

        // Add products to the list
        productList.add(product1);
        productList.add(product2);

        // Display the list
        System.out.println();
        System.out.println("Product List:");
        productList.display();

        // Example of removing a product
        productList.remove(product1);
        System.out.println();
        System.out.println("Product List after removal:");
        productList.display();

        System.out.println("-----------------");
        System.out.println();
        System.out.println("Starting Shopping Mall Application");
        // Populate the product catalog with some products for the shopping mall
        populateProductCatalog();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nShopping Mall Menu:");
                System.out.println("1. Add Product to Cart");
                System.out.println("2. Checkout");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter product name and quantity: ");
                        String productName = scanner.next();
                        int quantity = scanner.nextInt();
                        try {
                            addProductToCart(productName, quantity);
                        } catch (ProductNotFoundException | InvalidQuantityException e) {
                            System.err.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Enter payment method: ");
                        String paymentMethod = scanner.next();
                        checkout(paymentMethod);
                        break;
                    case 3:
                        System.out.println("Exiting application...");
                        return;
                    default:
                        System.err.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            }

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        } finally {
            System.out.println("Application finished");
        }
    }

    private static void populateProductCatalog() {
        // Adding some products to the product catalog
        productCatalog.put("bread", new Product("001", "Bread", 2.99));
        productCatalog.put("milk", new Product("002", "Milk", 1.49));
        // Add additional products as needed
    }

    private static void addProductToCart(String productName, int quantity) throws ProductNotFoundException {
        try {
            Product product = productCatalog.get(productName);

            if (product == null) {
                System.out.println("Product not found: " + productName);
                return;
            }

            CartItems cartItem = new CartItems(product, quantity);
            cart.addCartItem(cartItem);
            System.out.println("Added " + quantity + " of " + productName + " to the cart.");
        } catch (InvalidQuantityException e) {
            System.out.println("Error adding product to cart: " + e.getMessage());
        }
    }

    private static void checkout(String paymentMethod) {
        double total = cart.calculateTotal();
        payment = new Payment(total, paymentMethod);
        payment.processPayment();

        receipt = new Receipt(cart.getCartItems(), total, paymentMethod);
        receipt.finalPrintReceipt(); // Using the final method to print receipt
    }
}