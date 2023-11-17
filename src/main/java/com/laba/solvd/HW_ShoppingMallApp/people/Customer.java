package com.laba.solvd.HW_ShoppingMallApp.people;

import com.laba.solvd.HW_ShoppingMallApp.interfaces.DisplayInfo;

import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;

public class Customer extends Person implements DisplayInfo {
    private String customerId;
    private LocalDate registrationDate;
    private String email;
    private static int loyaltyPoints;
    private static final Logger logger = Logger.getLogger(Customer.class.getName());

    // Custom constructor
    public Customer(String firstName, String lastName, LocalDate birthDate,
                    String customerId, String email) {
        super(firstName, lastName, birthDate);
        this.customerId = customerId;
        this.registrationDate = LocalDate.now(); // Assume registration is today
        this.email = email;
    }

    @Override
    public void showAttributes() {
        logger.info("Customer's name: " + this.firstName + "surname " + this.lastName);
    }

    @Override
    public void showDetails() {
        logger.info("Details for Customer: \nName: " + this.firstName +
                "\nLast Name: " + this.lastName +
                "\nLoyalty Points: " + this.loyaltyPoints);
    }

    // Getters and setters for private properties
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    // A method to check if the customer is eligible for a senior discount
    public boolean isEligibleForSeniorDiscount() {
        return calculateAge() >= 65;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                '}';
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, birthDate, registrationDate, email);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(birthDate, customer.birthDate) &&
                Objects.equals(registrationDate, customer.registrationDate) &&
                Objects.equals(email, customer.email);
    }
}
