/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 6, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()// database and table name
public class Owner {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
    private String name;
	@Column(name="CONTACTNUMBER")
    private String contactNumber;
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


    public Owner(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

 HEAD
    // Getters and setters for all fields 
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {



    public Owner(int id, String name, String contactNumber) {
		super();
		this.id = id;
		this.name = name;
 4ebdaddade5ac3aa0f0b8779c0b19f93090bfba7
		this.contactNumber = contactNumber;
	}

	@Override
 HEAD
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber + "]";
	}

	
 4ebdaddade5ac3aa0f0b8779c0b19f93090bfba7
}
