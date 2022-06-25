package com.inexture.springcore.SetProperties;

public class Example {

	String welcomeNote;

	public String getWelcomeNote() {
		return welcomeNote;
	}

	public void setWelcomeNote(String welcomeNote) {
		this.welcomeNote = welcomeNote;
	}

	public void msg() {
		System.out.println(welcomeNote);
	}

//	@Override
//	public String toString() {
//		return "Example [welcomeNote=" + welcomeNote + "]";
//	}
}
