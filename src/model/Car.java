/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 6, 2023
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private double mileage;
    private double price;
    private List<Owner> owners;

    public Car(String make, String model, int year, String color, double mileage, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.owners = new ArrayList<>();
    }

    // Getters and setters for all fields -- dustin add these

    public void addOwner(Owner owner) {
        owners.add(owner);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", owners=" + owners +
                '}';
    }
}
