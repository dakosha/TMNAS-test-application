package com.jsfdemo.app;

import com.jsfdemo.app.model.Person;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;

@Named("personBean")
@ViewScoped
public class PersonBean implements Serializable {

    private Person person;

    @PostConstruct
    public void init() {
        person = new Person("John", "Doe", LocalDate.of(1990, 5, 15), "+7 (777) 123-45-67");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

