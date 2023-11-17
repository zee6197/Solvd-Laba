package com.laba.solvd.HW_ShoppingMallApp.people.employees;

import com.laba.solvd.HW_ShoppingMallApp.interfaces.DisplayInfo;
import com.laba.solvd.HW_ShoppingMallApp.people.Customer;
import com.laba.solvd.HW_ShoppingMallApp.people.Employee;
import com.laba.solvd.HW_ShoppingMallApp.shop.Inventory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class ShopManager extends Employee implements DisplayInfo {
    private double bonus;

    // hierarchy here:
    private List<Inventory> inventory;
    public List<Employee> employees;
    private static final Logger logger = Logger.getLogger(Customer.class.getName());


    // Custom constructor for ShopManager
    public ShopManager(String firstName, String lastName, LocalDate birthDate,
                       double salary, LocalDate employmentDate, double bonus) {
        super(firstName, lastName, birthDate, "Shop Manager", salary, employmentDate); // Position is set to "Shop Manager"
        this.bonus = bonus;
        this.inventory = new ArrayList<>();
        this.employees = new ArrayList<>();

    }


    public void manageInventory() {

        // Manger manages shop inventory

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
