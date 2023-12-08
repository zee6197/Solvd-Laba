package com.laba.solvd.HW_ShoppingMallApp;

import com.laba.solvd.HW_ShoppingMallApp.checkout.CartItems;
import com.laba.solvd.HW_ShoppingMallApp.checkout.Checkout;
import com.laba.solvd.HW_ShoppingMallApp.LinkedList.CustomLinkedList;
import com.laba.solvd.HW_ShoppingMallApp.enums.PaymentMethod;
import com.laba.solvd.HW_ShoppingMallApp.enums.ProductCategory;
import com.laba.solvd.HW_ShoppingMallApp.exceptions.InvalidQuantityException;
import com.laba.solvd.HW_ShoppingMallApp.exceptions.ProductNotFoundException;
import com.laba.solvd.HW_ShoppingMallApp.payments.Payment;
import com.laba.solvd.HW_ShoppingMallApp.payments.Receipt;
import com.laba.solvd.HW_ShoppingMallApp.shop.Inventory;
import com.laba.solvd.HW_ShoppingMallApp.shop.Product;

import java.io.File;
import java.io.IOException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        ShoppingMall zee_mall = new ShoppingMall("Zee Mall", LocalDate.of(2023, 12, 1));
        // Create some Product objects
        Product Shirt = new Product("1", "Shirt", 10.0, ProductCategory.APPAREL);
        Product Pants = new Product("2", "Pants", 20.0, ProductCategory.APPAREL);
        CustomLinkedList<Product> productList = new CustomLinkedList<>();
        // Initialize Inventory
        Inventory inventory = new Inventory();
        // Calling reflectClassInfo method to print class information
        inventory.reflectClassInfo();
        // After modifying the inventory, write to the file
        inventory.addStock(Shirt, 2);
        inventory.addStock(Pants, 2);
        // Read and display inventory from the file
        readInventoryFromFile();

        // Add products to the list
        productList.add(Shirt);
        productList.add(Pants);

        // Display the list
        System.out.println();
        System.out.println("Product List:");
        productList.display();

        // Example of removing a product
        productList.remove(Shirt);
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
                System.out.println("\nWelcome to " + zee_mall.getName() + "!");
                System.out.println("Established since: " + zee_mall.getEstablishedDate());
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

    static final Map<String, Product> productCatalog = new HashMap<>();
    static final Checkout cart = new Checkout();

    private static void populateProductCatalog() {
        // Adding some products to the product catalog
        productCatalog.put("shirt", new Product("001", "Shirt", 21.99, ProductCategory.APPAREL));
        productCatalog.put("pants", new Product("002", "Pants", 31.49, ProductCategory.APPAREL));
    }

    private static Optional<Product> addProductToCart(String productName, int quantity) throws ProductNotFoundException {
        Product product = productCatalog.get(productName);
        if (product == null) {
            System.out.println("Product not found: " + productName);
            return Optional.empty();
        }
        try {
            CartItems cartItem = new CartItems(product, quantity);
            cart.addCartItem(cartItem);
            System.out.println("Added " + quantity + " of " + productName + " to the cart.");
        } catch (InvalidQuantityException e) {
            System.out.println("Error adding product to cart: " + e.getMessage());
        }
        return Optional.of(product);
    }

    private static void checkout(String paymentMethod) {
        double total = cart.calculateTotal();
        PaymentMethod method = PaymentMethod.valueOf(paymentMethod.toUpperCase());
        Payment payment = new Payment(total, method);
        payment.processPayment();
        Receipt receipt = new Receipt(cart.getCartItems(), total, method);
        receipt.finalPrintReceipt();  // Using the final method to print receipt
    }

    List<Product> expensiveProducts = productCatalog.values().stream()
            .filter(product -> product.getPrice() > 100)
            .collect(Collectors.toList());

    List<String> productNames = productCatalog.values().stream()
            .map(Product::getName)
            .collect(Collectors.toList());

    Optional<Product> mostExpensiveProduct = productCatalog.values().stream()
            .max(Comparator.comparing(Product::getPrice));

    public static void readInventoryFromFile() {
        File file = new File("inventory.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}