package com.laba.solvd.HW_ShoppingMallApp.people;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected LocalDate birthDate;

    // Constructor
    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // Common method
    public int calculateAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    // toString method
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' + "lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(birthDate, person.birthDate);
    }
}
