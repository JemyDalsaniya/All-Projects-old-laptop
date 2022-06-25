package com.inexture.springcore.Inheritance;

public class Student {

	private String sub1;
	private String sub2;

	public String getSub1() {
		return sub1;
	}

	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}

	@Override
	public String toString() {
		return "Student [sub1=" + sub1 + ", sub2=" + sub2 + "]";
	}

	public String getSub2() {
		return sub2;
	}

	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
}
