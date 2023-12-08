package com.laba.solvd.HW_ShoppingMallApp.people;

import org.apache.logging.log4j.core.util.JsonUtils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.function.*;
import java.util.stream.IntStream;

public class EmployeeUtil {

    private EmployeeUtil() {
        // Private constructor to prevent instantiation
    }


    // Generic Predicate to check for non-null values
    public Predicate<Object> isNotNull = Objects::nonNull;

    // Generic Consumer to print any type of object
    public Consumer<Object> printObject = System.out::println;

    // Generic Function to get the size of a list
    public Function<List<?>, Integer> getSize = List::size;


    // Method to calculate the total salary of all employees
    // Method to calculate the total salary, including bonuses
    public static double totalSalary(List<Double> salaries, List<Double> bonuses) {
        if (salaries == null || bonuses == null || salaries.size() != bonuses.size()) {
            throw new IllegalArgumentException("Salaries and bonuses lists must be non-null and of the same size.");
        }

        double total = IntStream.range(0, salaries.size())
                .mapToDouble(i -> salaries.get(i) + bonuses.get(i))
                .sum();
        return total;
    }

    // Predicate Lambda: Used for checking a condition about an Employee
    public static boolean checkEmployeeCondition(Employee employee, Predicate<Employee> condition) {
        return condition.test(employee);
    }

    // Consumer Lambda: Performs an action on an Employee
    public static void processEmployee(Employee employee, Consumer<Employee> processor) {
        processor.accept(employee);
    }

    // Supplier Lambda: Provides an instance of Employee
    public static Employee getEmployee(Supplier<Employee> supplier) {
        return supplier.get();
    }

    // Function Lambda: Transforms an Employee into another type
    public static <R> R getEmployeeInfo(Employee employee, Function<Employee, R> function) {
        return function.apply(employee);
    }

    // BiFunction Lambda: Takes two Employee objects and produces a result
    public static <R> R compareEmployees(Employee emp1, Employee emp2, BiFunction<Employee, Employee, R> function) {
        return function.apply(emp1, emp2);
    }

    // Usage of Methods
    public static void demonstrateMethodUsage() {
        Employee.RegularEmployee employee = new Employee.RegularEmployee("John", "Doe", LocalDate.of(1990, 1, 1), "Manager", 50000, LocalDate.now());
        boolean isManager = EmployeeUtil.checkEmployeeCondition(employee, e -> "Manager".equals(e.getPosition()));
        EmployeeUtil.processEmployee(employee, e -> System.out.println("Processing Employee: " + e.getFirstName() + " " + e.getLastName()));
        Employee newEmployee = EmployeeUtil.getEmployee(() -> new Employee.RegularEmployee("Jane", "Smith", LocalDate.of(1995, 5, 15), "Developer", 60000, LocalDate.now()));
        int age = EmployeeUtil.getEmployeeInfo(employee, e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears());
        Employee.RegularEmployee emp1 = new Employee.RegularEmployee("Alice", "Johnson", LocalDate.of(1985, 3, 20), "Sales", 45000, LocalDate.of(2010, 1, 1));
        Employee.RegularEmployee emp2 = new Employee.RegularEmployee("Bob", "Wilson", LocalDate.of(1987, 7, 15), "Marketing", 48000, LocalDate.of(2012, 6, 1));
        int yearsOfServiceDifference = EmployeeUtil.compareEmployees(emp1, emp2, (e1, e2) -> e1.calculateYearsOfService() - e2.calculateYearsOfService());
    }
}

