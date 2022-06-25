package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Student {
	@Id
	// Indicates that the persistence provider must assignprimary keys for the
	// entity using a database identity column.
	// @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_type")
	// Indicates that the persistence provider must assignprimary keys for the
	// entity using a database sequence.
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_type")
	@SequenceGenerator(name = "auto_type", initialValue = 1, allocationSize = 3)
	private int sid;
	private String name;
	private String city;
	private int fees;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String name, String city, int fees) {
		super();
		this.sid = sid;
		this.name = name;
		this.city = city;
		this.fees = fees;
	}

}
