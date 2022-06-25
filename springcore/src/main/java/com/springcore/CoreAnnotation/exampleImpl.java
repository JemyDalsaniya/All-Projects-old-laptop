package com.springcore.CoreAnnotation;

import org.springframework.stereotype.Component;

//Using this we will get all the object ex -  for exampleInterface
@Component
public class exampleImpl implements exampleInterface {

	@Override
	public void process() {
		System.out.println("inside example impl");
	}

}
