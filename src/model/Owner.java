/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 6, 2023
 */
package model;

public class Owner {
    private String name;
    private String contactNumber;

    public Owner(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    // Getters and setters for all fields - dustin add these

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
