package com.laba.solvd.HW_ShoppingMallApp.people;

import java.time.LocalDate;
import java.time.Period;

public class Employee extends AbstractEmployee {
    private static int nextId = 1; // Static variable to generate unique IDs for each employee

    private int employeeId;
    private String name;
    private String position;
    private double salary;
    private LocalDate employmentDate;
    private LocalDate birthDate;

    // Custom constructor to initialize the employee details
    public Employee(String employeeId, String department /* other parameters */) {
        super(employeeId, department);
        this.employeeId = nextId++; // Increment the ID for each new employee
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.employmentDate = employmentDate;
        this.birthDate = birthDate;
    }

    // Method to calculate the age of the employee
    public int calculateAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Method to calculate years of service
    public int calculateYearsOfService() {
        return Period.between(employmentDate, LocalDate.now()).getYears();
    }

    // Method overloading: A version of raiseSalary with a default raise percentage
    public void raiseSalary() {
        raiseSalary(5.0); // Default 5% raise
    }

    // Overloaded method: raiseSalary with a specified raise percentage
    public void raiseSalary(double percentage) {
        this.salary += this.salary * percentage / 100;
    }

    // Static method to get the next available ID
    public static int getNextId() {
        return nextId;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    // employeeId does not have a setter as it should not change after being set initially

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    // employmentDate does not have a setter as it should not change after being set initially

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // birthDate does not have a setter as it should not change after being set initially

    // A method to print employee details
    public void printEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position +
                ", Salary: " + salary + ", Employment Date: " + employmentDate + ", Birth Date: " + birthDate);
    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    @Override
    public String generateReport() {
        return null;
    }
    @Override
    public String toString() {
        // Implement toString logic
        return "Employee{" +
                // Your toString implementation
                '}';
    }

    @Override
    public int hashCode() {
        // Implement hashCode logic
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // Implement equals logic
        return super.equals(obj);
    }
}
