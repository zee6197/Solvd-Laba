package com.laba.solvd.HW_ShoppingMallApp.people;

import com.laba.solvd.HW_ShoppingMallApp.people.AbstractEmployee;

public class EmployeeUtil {

    // Method accepting AbstractEmployee as parameter
    public static void validateEmployee(AbstractEmployee employee) {
        // Implement validation logic
        if (employee == null) {
            System.out.println("Invalid employee data.");
        } else {
            System.out.println("Employee validated: " + employee.toString());
        }
    }
}
