
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Inventory {
    // Example of private properties
    private Map<Product, Integer> productStock;
    private LocalDate lastStockUpdate;

    // Custom constructor that initializes the product stock and sets the last stock update date
    public Inventory() {
        this.productStock = new HashMap<>();
        this.lastStockUpdate = LocalDate.now();
    }

    // A method to add a product to the inventory
    public void addProduct(Product product, int quantity) {
        int currentQuantity = productStock.getOrDefault(product, 0);
        productStock.put(product, currentQuantity + quantity);
        lastStockUpdate = LocalDate.now(); // Update the stock update date
    }

    // A method to get the quantity of a product in the inventory
    public int getProductQuantity(Product product) {
        return productStock.getOrDefault(product, 0);
    }

    // A method to check if the inventory is empty
    public boolean isEmpty() {
        return productStock.isEmpty();
    }

    // A method to remove a product from the inventory (with overload for different quantities)
    public void removeProduct(Product product) {
        removeProduct(product, 1); // Remove a single unit by default
    }

    public void removeProduct(Product product, int quantity) {
        int currentQuantity = productStock.getOrDefault(product, 0);
        int newQuantity = currentQuantity - quantity;

        if (newQuantity > 0) {
            productStock.put(product, newQuantity);
        } else {
            productStock.remove(product);
        }
        lastStockUpdate = LocalDate.now(); // Update the stock update date
    }

    // Getters and Setters
    public Map<Product, Integer> getProductStock() {
        return new HashMap<>(productStock); // Returning a copy for encapsulation
    }

    public LocalDate getLastStockUpdate() {
        return lastStockUpdate;
    }

    public void setLastStockUpdate(LocalDate lastStockUpdate) {
        this.lastStockUpdate = lastStockUpdate;
    }

    // Static method example
    public static void printInventoryStatus(Inventory inventory) {
        if (inventory.isEmpty()) {
            System.out.println("The inventory is currently empty.");
        } else {
            System.out.println("The inventory contains products.");
        }
    }
}
