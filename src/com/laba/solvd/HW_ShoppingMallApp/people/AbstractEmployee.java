package com.laba.solvd.HW_ShoppingMallApp.people;

public abstract class AbstractEmployee {
    protected String employeeId;
    protected String department;

    public AbstractEmployee(String employeeId, String department) {
        this.employeeId = employeeId;
        this.department = department;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Abstract method to generate report
    public abstract String generateReport();

    // Override toString method
    @Override
    public String toString() {
        return "AbstractEmployee{" +
                "employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        // Implement appropriate hashCode logic
        return super.hashCode();
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        // Implement appropriate equals logic
        return super.equals(obj);
    }
}

