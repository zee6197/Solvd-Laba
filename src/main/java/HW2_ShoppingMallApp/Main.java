
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

        // Checking if the command-line arguments are provided correctly
        if (args.length < 1) {
            System.out.println("Usage: java Main <product_name> <quantity> ... <payment_method>");
            System.out.println("Example: java Main Bread 2 Milk 1 Checkout cash");
            return;
        }

        // Processing actions based on the command-line arguments
        for (int i = 0; i < args.length - 1; i += 2) {
            String productName = args[i];
            int quantity;
            try {
                quantity = Integer.parseInt(args[i + 1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity: " + args[i + 1]);
                return;
            }

            addProductToCart(productName, quantity);
        }

        // The last argument is assumed to be the payment method
        String paymentMethod = args[args.length - 1];
        checkout(paymentMethod);
    }

    private static void populateProductCatalog() {
        // Adding some products to the product catalog
        productCatalog.put("Bread", new Product("bread", "Bread", 2.99));
        productCatalog.put("Milk", new Product("milk", "Milk", 1.49));
        // Add additional products as needed
    }

    private static void addProductToCart(String productName, int quantity) {
        // Search for the product by name
        Product product = productCatalog.values().stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);

        if (product == null) {
            System.out.println("Product not found: " + productName);
            return;
        }

        // Add the product to the cart
        CartItem cartItem = new CartItem(product, quantity);
        cart.addCartItem(cartItem);
        System.out.println("Added " + quantity + " of " + productName + " to the cart.");
    }

    private static void checkout(String paymentMethod) {
        // Process the payment and print the receipt
        double total = cart.calculateTotal();
        payment = new Payment(paymentMethod);
        payment.setAmount(total);
        payment.processPayment();

        receipt = new Receipt(cart.getCartItems(), total, paymentMethod);
        receipt.printReceipt();
    }
}
