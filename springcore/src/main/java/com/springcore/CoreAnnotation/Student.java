package com.springcore.CoreAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Using this we will get all the object ex -  for Student  
@Component
public class Student {

//	private int studentId;
//	private String studentName;

	@Autowired
	exampleInterface obj;

	public exampleInterface getObj() {
		return obj;
	}

	public void setObj(exampleInterface obj) {
		this.obj = obj;
	}

	public void config() {
		System.out.println("Configuration done!!");
		obj.process();
	}

}
