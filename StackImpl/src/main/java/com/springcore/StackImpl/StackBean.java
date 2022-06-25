package com.springcore.StackImpl;

import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

public class StackBean {

	private static Logger logger = Logger.getLogger(StackBean.class.getName());
	Scanner sc;
	private Stack<Integer> stack = new Stack<Integer>();
	Scanner val = new Scanner(System.in);
	int position, value, values, num;

	public Stack<Integer> getStack() {
		return stack;
	}

	public void setStack(Stack<Integer> stack) {
		this.stack = stack;
	}

	public void pushElement() {
		// int values, num;
		// System.out.println("How many values you want to add?");
		// num = sc.nextInt();
		// for (int i = 0; i < num; i++) {
		// System.out.println("value : [" + (i + 1) + "]");
		sc = new Scanner(System.in);
		System.out.println("Enter value:");
		values = sc.nextInt();
		stack.add(values);
		System.out.println("Value added successfully!!");
		// }
	}

	public void popElement() {
		int count = stack.size();
		if (stack.isEmpty()) {
			System.out.println("Stack is currently empty!!");
		} else {
			stack.remove(count - 1);
			logger.info("Last value removed sucessfully!!");
			// System.out.println("Value removed is:" + stack.elementAt(count));
		}
	}

	public void displayElements() {
		if (stack.isEmpty()) {
			System.out.println("No values inside stack!!");
		} else {
			System.out.println("Values in stacks are:");
			stack.stream().forEach(S -> System.out.println(S));
		}
	}

	public void addAtPosition() {
		// int position, value;
		sc = new Scanner(System.in);
		System.out.println("Enter position:");
		position = sc.nextInt();
		if (position < 0 || position - 1 > stack.size()) {
			logger.info("Enter valid Position!!");
		} else {
			System.out.println("Enter Value:");
			value = sc.nextInt();
			if (value > 0) {
				stack.add(position - 1, value);
				System.out.println("Value added sucessfully!!");
			} else {
				System.out.println("Please enter correct value!!");
			}
		}
	}

	public void removeAtPosition() {
		int position;
		sc = new Scanner(System.in);
		if (stack.isEmpty()) {
			System.out.println("Stack is Empty!!");
		} else {
			System.out.println("Enter position:");
			position = sc.nextInt();
			if (position > stack.size()) {
				logger.info("Enter valid position!!");
			} else {
				System.out.println("Value removed is:" + stack.get(position - 1));
				stack.remove(position - 1);
			}
		}
	}
}
