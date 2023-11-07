
public class CashRegister {
    private static final double TAX_RATE = 0.08; // 8% Tax Rate
    private static double totalRevenue = 0;

    private int registerId;
    private double cashOnHand;

    public CashRegister(int registerId, double initialCash) {
        this.registerId = registerId;
        this.cashOnHand = initialCash;
    }

    public void processSale(double amount) {
        double totalAmount = amount + (amount * TAX_RATE);
        this.cashOnHand += totalAmount;
        CashRegister.totalRevenue += totalAmount;
        printReceipt(amount, totalAmount);
    }

    public boolean processRefund(double amount) {
        if (amount > cashOnHand) {
            System.out.println("Not enough cash available to process the refund.");
            return false;
        } else {
            double totalAmount = amount + (amount * TAX_RATE);
            this.cashOnHand -= totalAmount;
            CashRegister.totalRevenue -= totalAmount;
            System.out.println("Refund processed. Amount: " + totalAmount);
            return true;
        }
    }

    public void printReceipt(double amount, double totalAmount) {
        System.out.println("Receipt - Register ID: " + registerId);
        System.out.println("Amount: " + amount);
        System.out.println("Tax: " + (amount * TAX_RATE));
        System.out.println("Total: " + totalAmount);
    }

    // Getter and Setter methods
    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public int getRegisterId() {
        return registerId;
    }

    public double getCashOnHand() {
        return cashOnHand;
    }

    public void setCashOnHand(double cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    // Overloading method for adding cash
    public void addCash(double amount) {
        this.cashOnHand += amount;
    }

    // Static method to reset the total revenue
    public static void resetTotalRevenue() {
        totalRevenue = 0;
    }
}
