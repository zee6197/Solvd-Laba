package com.laba.solvd.HW_ShoppingMallApp.people;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmployeeUtil {

    private EmployeeUtil() {
        // Private constructor to prevent instantiation
    }


    // Generic Predicate to check for non-null values
    public static Predicate<Object> isNotNull = Objects::nonNull;

    // Generic Consumer to print any type of object
    public static Consumer<Object> printObject = System.out::println;

    // Generic Function to get the size of a list
    public static Function<List<?>, Integer> getSize = List::size;


    // Method to calculate the total salary of all employees
    // Method to calculate the total salary, including bonuses
    public static double totalSalary(List<Double> salaries, List<Double> bonuses) {
        if (salaries == null || bonuses == null || salaries.size() != bonuses.size()) {
            throw new IllegalArgumentException("Salaries and bonuses lists must be non-null and of the same size.");
        }

        double total = 0;
        for (int i = 0; i < salaries.size(); i++) {
            total += salaries.get(i) + bonuses.get(i);
        }
        return total;
    }
}

