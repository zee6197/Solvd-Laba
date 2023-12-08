package com.laba.solvd.HW_ShoppingMallApp.people.employees;

import com.laba.solvd.HW_ShoppingMallApp.interfaces.DisplayInfo;
import com.laba.solvd.HW_ShoppingMallApp.people.Customer;
import com.laba.solvd.HW_ShoppingMallApp.people.Employee;
import com.laba.solvd.HW_ShoppingMallApp.shop.Inventory;
import com.laba.solvd.HW_ShoppingMallApp.shop.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

public class ShopManager extends Employee implements DisplayInfo {
    private double bonus;

    // hierarchy here:
    public List<Employee> employees;
    private Map<Product, Integer> productStock;
    private final Logger logger = Logger.getLogger(Customer.class.getName());


    // Custom constructor for ShopManager
    public ShopManager(String firstName, String lastName, LocalDate birthDate,
                       double salary, LocalDate employmentDate, double bonus) {
        super(firstName, lastName, birthDate, "Shop Manager", salary, employmentDate); // Position is set to "Shop Manager"
        this.bonus = bonus;
        this.employees = new ArrayList<>();

    }

    public void superviseEmployees() {

        // Manger supervises shop employees
    }

    // Override or add additional functionality if necessary
    @Override
    public void raiseSalary(double percentage) {
        super.raiseSalary(percentage);
    }


    // Getters and Setters
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // toString method
    @Override
    public String toString() {
        return "ShopManager{" +
                "employeeId=" + getEmployeeId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", salary=" + getSalary() +
                ", employmentDate=" + getEmploymentDate() +
                ", birthDate=" + getBirthDate() +
                ", bonus=" + bonus +
                '}';
    }



    public Optional<Map<Product, Integer>> getProductStock() {
        return Optional.ofNullable(productStock);
    }

    public Optional<List<Employee>> getEmployees() {
        return Optional.ofNullable(employees);
    }
    @Override
    public void showAttributes() {
        logger.info("Shop Manager's first name: " + this.firstName + "last name " + this.lastName);
    }

    @Override
    public void showDetails() {
        logger.info("Details for Accountant: \nName: " + this.firstName +
                "\nLast Name: " + this.lastName +
                "\nBirthDay: " + this.birthDate +
                "\nBonus: " + this.bonus);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        ShopManager other = (ShopManager) obj;
        return Double.compare(other.bonus, bonus) == 0;
    }
}
