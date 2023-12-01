package com.laba.solvd.HW_ShoppingMallApp.people;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

public abstract class Employee extends Person {

    // Static variable to generate unique IDs for each employee
    private static int nextId = 1;

    private static final Logger logger = Logger.getLogger(Employee.class.getName());

    private int employeeId;
    private String position;
    private double salary;
    private LocalDate employmentDate;

    // Custom constructor to initialize the employee details
    public Employee(String firstName, String lastName, LocalDate birthDate,
                    String position, double salary, LocalDate employmentDate) {
        super(firstName, lastName, birthDate);
        this.employeeId = nextId++; // Increment the ID for each new employee
        this.position = position;
        this.salary = salary;
        this.employmentDate = employmentDate;
    }


    Function<Employee, Integer> calculateAge = employee -> Period.between(employee.getBirthDate(), LocalDate.now()).getYears();

    // Method to calculate years of service
    public int calculateYearsOfService() {
        return Period.between(employmentDate, LocalDate.now()).getYears();
    }

    // Methods for salary management

    public void calculateTotalPayroll() {
        // Example lists for salaries and bonuses
        List<Double> salaries = Arrays.asList(30000.0, 40000.0, 50000.0);
        List<Double> bonuses = Arrays.asList(5000.0, 6000.0, 7000.0);

        // Calculate the total salary including bonuses
        double totalSalary = EmployeeUtil.totalSalary(salaries, bonuses);

        // Log the total salary using the logger
        logger.info("Total Salary including bonuses: " + totalSalary);
    }

    public void raiseSalary() {
        raiseSalary(5.0); // Default 5% raise
    }

    public void raiseSalary(double percentage) {
        this.salary += this.salary * percentage / 100;
    }

    // Static method to get the next available ID
    public static int getNextId() {
        return nextId;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", employmentDate=" + employmentDate +
                ", birthDate=" + birthDate +
                '}';
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, position, salary, employmentDate, birthDate);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return employeeId == employee.employeeId &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(position, employee.position) &&
                Objects.equals(employmentDate, employee.employmentDate) &&
                Objects.equals(birthDate, employee.birthDate);
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
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
}
