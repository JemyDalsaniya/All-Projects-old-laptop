package com.inexture.springcore.Fruit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {

	private String ex1;

	public String getEx1() {
		return ex1;
	}

	public void setEx1(String ex1) {
		this.ex1 = ex1;
	}

	@Override
	public String toString() {
		return "Example [ex1=" + ex1 + "]";
	}

	public Example() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		System.out.println("annotation init");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("annotation destroy");
	}

}
