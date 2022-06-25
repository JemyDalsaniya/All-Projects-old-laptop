package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NewStudent {

	@Id
	@GeneratedValue
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

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", city=" + city + ", fees=" + fees + "]";
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public NewStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewStudent(int sid, String name, String city, int fees) {
		super();
		this.sid = sid;
		this.name = name;
		this.city = city;
		this.fees = fees;
	}

}
