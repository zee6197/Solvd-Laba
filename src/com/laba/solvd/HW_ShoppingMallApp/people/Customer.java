package com.laba.solvd.HW_ShoppingMallApp.people;

import com.laba.solvd.HW_ShoppingMallApp.interfaces.CustomerService;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Customer implements CustomerService {
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

    @Override
    public void registerComplaint(String complaint) {
        // Logic to handle customer complaint
        System.out.println("Customer complaint registered: " + complaint);
    }

    @Override
    public void provideFeedback(String feedback) {
        // Logic to handle customer feedback
        System.out.println("Customer feedback received: " + feedback);
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, birthDate, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(birthDate, customer.birthDate) &&
                Objects.equals(email, customer.email);
    }
}
