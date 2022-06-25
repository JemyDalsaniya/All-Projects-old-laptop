package com.hibernate.ManyToMany;

import java.util.Set;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	private Set Certificates;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set getCertificates() {
		return Certificates;
	}

	public void setCertificates(Set certificates) {
		Certificates = certificates;
	}

}
