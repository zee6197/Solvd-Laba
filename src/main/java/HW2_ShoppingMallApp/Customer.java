

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Customer {
    private String customerId;
    private String name;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private String email;
    private static int loyaltyPoints;

    // Custom constructor
    public Customer(String customerId, String name, LocalDate birthDate, String email) {
        this.customerId = customerId;
        this.name = name;
        this.birthDate = birthDate;
        this.registrationDate = LocalDate.now(); // Assume registration is today
        this.email = email;
    }

    // Getters and setters for private properties
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    // Registration date does not change once set, hence no setter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public static void setLoyaltyPoints(int points) {
        loyaltyPoints = points;
    }

    // A method to calculate the age of the customer
    public int calculateAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    // A method to check if the customer is eligible for a senior discount
    public boolean isEligibleForSeniorDiscount() {
        return calculateAge() >= 65;
    }

    // A method to print customer details
    public void printCustomerDetails() {
        System.out.println("Customer ID: " + customerId + ", Name: " + name + ", Birth Date: " + birthDate +
                ", Registration Date: " + registrationDate + ", Email: " + email);
    }

    // Overridden equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
