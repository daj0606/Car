/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 6, 2023
 */
package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table()//figure out table name and database config??
public class Car {
	// set variables
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="MAKE")
    private String make;
	@Column(name="MODEL")
    private String model;
	@Column(name="YEAR")
    private int year;
	@Column(name="COLOR")
    private String color;
	@Column(name="MILEAGE")
    private double mileage;
	@Column(name="PRICE")
    private double price;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
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
