
package com.inexture.springcore.CI;

import java.util.List;

public class Person {

	private String pName;
	private int pId;
	private Certi certi;
	private List<String> list;

	public Person(String pName, int pId, Certi certi, List<String> list) {
		super();
		this.pName = pName;
		this.pId = pId;
		this.certi = certi;
		this.list = list;
	}

	@Override
	public String toString() {
		return this.pName + " : " + this.pId + "{" + this.certi + "}" + this.list;
	}

}