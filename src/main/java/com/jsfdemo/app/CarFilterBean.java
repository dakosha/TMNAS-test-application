package com.jsfdemo.app;

import com.jsfdemo.app.model.Car;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean demonstrating: h:selectOneMenu, h:selectManyListbox,
 * h:commandLink, h:column (h:dataTable), h:panelGroup, h:form
 */
@Named("carFilterBean")
@ViewScoped
public class CarFilterBean implements Serializable {

    private List<Car> allCars;
    private List<Car> filteredCars;

    private String selectedMake;
    private List<String> selectedYears;

    private List<String> availableMakes;
    private List<String> availableYears;

    @PostConstruct
    public void init() {
        allCars = new ArrayList<>();
        allCars.add(new Car("Toyota", "Camry", 2021));
        allCars.add(new Car("Toyota", "Corolla", 2022));
        allCars.add(new Car("Toyota", "RAV4", 2023));
        allCars.add(new Car("BMW", "X3", 2021));
        allCars.add(new Car("BMW", "X5", 2022));
        allCars.add(new Car("BMW", "3 Series", 2024));
        allCars.add(new Car("Mercedes-Benz", "C-Class", 2022));
        allCars.add(new Car("Mercedes-Benz", "E-Class", 2023));
        allCars.add(new Car("Honda", "Civic", 2021));
        allCars.add(new Car("Honda", "Accord", 2024));
        allCars.add(new Car("Hyundai", "Tucson", 2023));
        allCars.add(new Car("Hyundai", "Sonata", 2022));

        availableMakes = allCars.stream()
                .map(Car::getMake)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        availableYears = allCars.stream()
                .map(c -> String.valueOf(c.getYear()))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        selectedMake = "";
        selectedYears = new ArrayList<>();
        filteredCars = new ArrayList<>(allCars);
    }

    public void filter() {
        filteredCars = allCars.stream()
                .filter(c -> selectedMake == null || selectedMake.isEmpty() || c.getMake().equals(selectedMake))
                .filter(c -> selectedYears == null || selectedYears.isEmpty() || selectedYears.contains(String.valueOf(c.getYear())))
                .collect(Collectors.toList());
    }

    public void resetFilter() {
        selectedMake = "";
        selectedYears = new ArrayList<>();
        filteredCars = new ArrayList<>(allCars);
    }

    // --- Getters / Setters ---

    public List<Car> getFilteredCars() {
        return filteredCars;
    }

    public String getSelectedMake() {
        return selectedMake;
    }

    public void setSelectedMake(String selectedMake) {
        this.selectedMake = selectedMake;
    }

    public List<String> getSelectedYears() {
        return selectedYears;
    }

    public void setSelectedYears(List<String> selectedYears) {
        this.selectedYears = selectedYears;
    }

    public List<String> getAvailableMakes() {
        return availableMakes;
    }

    public List<String> getAvailableYears() {
        return availableYears;
    }

    public int getFilteredCount() {
        return filteredCars != null ? filteredCars.size() : 0;
    }
}

