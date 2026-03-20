package com.jsfdemo.app.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phone;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

