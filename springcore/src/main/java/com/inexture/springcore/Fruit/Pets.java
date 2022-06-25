package com.inexture.springcore.Fruit;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pets implements InitializingBean, DisposableBean {

	private String dog;

	public String getDog() {
		return dog;
	}

	public void setDog(String dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Pets [dog=" + dog + "]";
	}

	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// for init
		System.out.println("inside init: using interface");
	}

	@Override
	public void destroy() throws Exception {
		// for destroy
		System.out.println("inside destroy: using interface");

	}

}
