package com.inexture.springcore;

import java.util.List;

public class StackImplimentation {

	private List<Integer> elements;

	public List<Integer> getElements() {
		return elements;
	}

	public void setElements(List<Integer> elements) {
		this.elements = elements;
	}

	public StackImplimentation() {
		super();
	}

	public StackImplimentation(List<Integer> elements) {
		super();
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "StackImplimentation [elements=" + elements + "]";
	}

	public List<Integer> display() {
		return elements;
	}

}
