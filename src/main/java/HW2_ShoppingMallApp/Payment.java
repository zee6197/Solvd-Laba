
import java.time.LocalDate;

public class Payment {
    public static int nextPaymentId = 1; // Static variable to generate unique payment IDs

    public int paymentId;
    public double amount;
    public LocalDate paymentDate;
    public String paymentMethod;

    // Custom constructor that initializes a payment with an amount and method
    public Payment(String paymentMethod) {
        this.paymentId = getNextPaymentId();
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = LocalDate.now(); // Capture the current date as the payment date
    }

    // Getters and setters
    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Static method to get the next payment ID and increment the static counter
    private static int getNextPaymentId() {
        return nextPaymentId++;
    }

    // Method to process payment logic
    public void processPayment() {
        // Logic to process the payment
        System.out.println("Processing payment of " + amount + " via " + paymentMethod);
        // Further logic would follow
    }

    // Static method to reset payment IDs, for example, could be used in testing
    public static void resetPaymentIdCounter() {
        nextPaymentId = 1;
    }
}
