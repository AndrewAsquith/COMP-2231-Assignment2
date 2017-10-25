/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 2
 * Question 2 - Implementation of DropOut Stack with Linked List
 */
package com.andrewasquith.comp2231.assignment2.question2;

/**
 * Import the exception we need to catch
 */
import jsjf.exceptions.EmptyCollectionException;

/**
 * Exercises the functionality of the LinkedDropOutStack 
 * It is implemented identically to ArrayStackDriver 
 * so the output can be compared more easily 
 * The two implementations differ in the "full stack" behaviour
 */
public class LinkedDropOutStackDriver {

	/**
	 * Runs the tests and outputs the results
	 * @param args ignored
	 */
	public static void main(String[] args) {

		// new stack of Integers with capacity of 4
		LinkedDropOutStack<Integer> theStack = new LinkedDropOutStack<Integer>(4);

		System.out.println("Empty Stack:");
		System.out.println("isEmpty() = " + theStack.isEmpty());
		System.out.println("size() = " + theStack.size());
		System.out.println(theStack);
		System.out.println();

		System.out.println("Pop from empty stack");
		try {
			theStack.pop();
		} catch (EmptyCollectionException ex) {
			System.out.println("Caught Exception: " + ex.getMessage());
		}
		System.out.println();

		System.out.println("Peek empty stack");
		try {
			theStack.peek();
		} catch (EmptyCollectionException ex) {
			System.out.println("Caught Exception: " + ex.getMessage());
		}
		System.out.println();

		System.out.println("Push 1 onto stack");
		theStack.push(new Integer(1));
		System.out.println("Stack:");
		System.out.println(theStack);
		System.out.println();

		System.out.println("Push 5 then 3");
		theStack.push(new Integer(5));
		theStack.push(new Integer(3));
		System.out.println("Stack:");
		System.out.println(theStack);
		System.out.println();

		System.out.println("isEmpty() and size() with 3 elements");
		System.out.println("isEmpty() = " + theStack.isEmpty());
		System.out.println("size() = " + theStack.size());
		System.out.println();

		System.out.println("Peek should be 3");
		System.out.println("Peeked: " + theStack.peek());
		System.out.println();

		System.out.println("Push 5 onto stack");
		theStack.push(new Integer(5));
		System.out.println("Stack:");
		System.out.println(theStack);
		System.out.println();

		System.out.println("Pop from stack - should be 5");
		System.out.println("Popped: " + theStack.pop());
		System.out.println("Stack:");
		System.out.println(theStack);
		System.out.println();

		System.out.println("Exceed capacity - push 2,3,4,9");
		theStack.push(new Integer(2));
		theStack.push(new Integer(3));
		theStack.push(new Integer(4));
		theStack.push(new Integer(9));
		System.out.println("Stack:");
		System.out.println(theStack);
		System.out.println();

		System.out.println("Peek after exceeding capacity (should be 9)");
		System.out.println("Peeked - " + theStack.peek());
		System.out.println("Stack:");
		System.out.println(theStack);
		System.out.println();

		System.out.println("Pop after exceeding capacity (should be 9)");
		System.out.println("Popped - " + theStack.pop());
		System.out.println("Stack:");
		System.out.println(theStack);
		System.out.println();
	}
}
