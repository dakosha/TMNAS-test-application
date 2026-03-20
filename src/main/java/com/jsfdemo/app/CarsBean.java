package com.jsfdemo.app;

import com.jsfdemo.app.model.Car;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("carsBean")
@ViewScoped
public class CarsBean implements Serializable {

    private List<Car> cars;

    @PostConstruct
    public void init() {
        cars = List.of(
                new Car("Toyota", "Camry", 2023),
                new Car("BMW", "X5", 2022),
                new Car("Mercedes-Benz", "E-Class", 2024),
                new Car("Honda", "Civic", 2021),
                new Car("Hyundai", "Tucson", 2023)
        );
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

