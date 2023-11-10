package com.laba.solvd.HW_ShoppingMallApp;

import com.laba.solvd.HW_ShoppingMallApp.Checkout.Cart;
import com.laba.solvd.HW_ShoppingMallApp.Checkout.CartItem;
import com.laba.solvd.HW_ShoppingMallApp.exceptions.CatalogLoadException;
import com.laba.solvd.HW_ShoppingMallApp.exceptions.InvalidQuantityException;
import com.laba.solvd.HW_ShoppingMallApp.exceptions.ProductNotFoundException;
import com.laba.solvd.HW_ShoppingMallApp.payments.Payment;
import com.laba.solvd.HW_ShoppingMallApp.payments.Receipt;
import com.laba.solvd.HW_ShoppingMallApp.shop.Product;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static final Map<String, Product> productCatalog = new HashMap<>();
    public static final Cart cart = new Cart();
    public static Payment payment;
    public static Receipt receipt;

    static {
        setupLogger();
    }

    private static void setupLogger() {
        try {
            // File logging
            FileHandler fileHandler = new FileHandler("application.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            // Console logging
            logger.setUseParentHandlers(true);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error setting up logger", e);
        }
    }

    public static void main(String[] args) {

        logger.log(Level.INFO, "Starting Shopping Mall Application");
        // Populate the product catalog with some products for the shopping mall
        populateProductCatalog();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                logger.log(Level.INFO, "Shopping Mall Menu:");
                logger.log(Level.INFO, "1. Add Product to Cart");
                logger.log(Level.INFO, "2. Checkout");
                logger.log(Level.INFO, "3. Exit");
                logger.log(Level.INFO, "Enter your choice: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        logger.log(Level.INFO, "Enter product name and quantity: ");
                        String productName = scanner.next();
                        int quantity = scanner.nextInt();
                        try {
                            addProductToCart(productName, quantity);
                        } catch (ProductNotFoundException | InvalidQuantityException e) {
                            logger.log(Level.SEVERE, e.getMessage());
                        }
                        break;
                    case 2:
                        logger.log(Level.INFO, "Enter payment method: ");
                        String paymentMethod = scanner.next();
                        checkout(paymentMethod);
                        break;
                    case 3:
                        logger.log(Level.INFO, "Exiting application...");
                        return;
                    default:
                        logger.log(Level.WARNING, "Invalid choice. Please enter a valid option.");
                        break;
                }
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred: ", e);
        } finally {
            logger.log(Level.INFO, "Application finished");
        }
    }

    private static void loadProducts(String filePath) throws CatalogLoadException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new CatalogLoadException("Invalid line format in product catalog file.");
                }
                String id = parts[0].trim();
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                productCatalog.put(name, new Product(id, name, price));
            }
        } catch (IOException e) {
            throw new CatalogLoadException("Failed to load product catalog.", e);
        } catch (NumberFormatException e) {
            throw new CatalogLoadException("Invalid price format in product catalog file.", e);
        }
    }

    private static void populateProductCatalog() {
        // Adding some products to the product catalog
        productCatalog.put("bread", new Product("bread", "bread", 2.99));
        productCatalog.put("milk", new Product("milk", "milk", 1.49));
        // Add additional products as needed
    }

    private static void addProductToCart(String productName, int quantity) throws ProductNotFoundException {
        try {
            Product product = productCatalog.get(productName);

            if (product == null) {
                System.out.println("Product not found: " + productName);
                return;
            }

            CartItem cartItem = new CartItem(product, quantity);
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
