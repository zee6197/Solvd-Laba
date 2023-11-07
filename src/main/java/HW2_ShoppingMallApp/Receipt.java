import java.time.LocalDate;
import java.util.List;

public class Receipt {
    private static int receiptCounter = 0;

    private int receiptNumber;
    private LocalDate issueDate;
    private List<CartItem> itemsPurchased;
    private double totalAmount;
    private String paymentMethod;

    // Constructor
    public Receipt(List<CartItem> itemsPurchased, double totalAmount, String paymentMethod) {
        this.receiptNumber = ++receiptCounter; // Unique receipt number
        this.issueDate = LocalDate.now(); // Current date
        this.itemsPurchased = itemsPurchased;
        this.totalAmount = totalAmount;
        this.paymentMethod = String.valueOf(paymentMethod);
    }

    // Getter and setter methods
    public int getReceiptNumber() {
        return receiptNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public List<CartItem> getItemsPurchased() {
        return itemsPurchased;
    }

    public void setItemsPurchased(List<CartItem> itemsPurchased) {
        this.itemsPurchased = itemsPurchased;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Static method to access the static counter variable
    public static int getNextReceiptNumber() {
        return receiptCounter + 1;
    }

    // Method to print the receipt details
    public void printReceipt() {
        System.out.println("Receipt Number: " + receiptNumber);
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Items Purchased:");
        for (CartItem item : itemsPurchased) {
            Product product = item.getProduct();
            if (product != null) {
                System.out.println("Product ID: " + product.getName() + ", Product Name: " + product.getName() + ", Unit Price: " + product.getPrice() + ", Quantity: " + item.getQuantity() + ", Total: " + (product.getPrice() * item.getQuantity()));
            }
        }
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Payment Method: " + paymentMethod);
    }
}
