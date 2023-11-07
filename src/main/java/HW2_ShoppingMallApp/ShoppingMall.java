import java.time.LocalDate;

public class ShoppingMall {
    private String name;
    private LocalDate establishedDate;

    public ShoppingMall(String name, LocalDate date) {
        this.name = name;
        this.establishedDate = date;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    // Static variable and method
    private static int numberOfMalls = 0;

    public static void incrementMallCount() {
        numberOfMalls++;
    }

    public static int getNumberOfMalls() {
        return numberOfMalls;
    }

    // A method with some logic
    public void printWelcomeMessage() {
        System.out.println("Welcome to " + name + "!");
    }
}