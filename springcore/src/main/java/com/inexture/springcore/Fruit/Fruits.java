package com.inexture.springcore.Fruit;

public class Fruits {

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fruit [price=" + price + "]";
	}

	public Fruits() {
		super();
	}

	public void init() {
		System.out.println("inside init method");
	}

	public void destroy() {
		System.out.println("inside destroy");
	}

}
