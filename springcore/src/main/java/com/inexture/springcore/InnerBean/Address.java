package com.inexture.springcore.InnerBean;

public class Address {
	private String city;
	private int addId;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", addId=" + addId + "]";
	}
}
