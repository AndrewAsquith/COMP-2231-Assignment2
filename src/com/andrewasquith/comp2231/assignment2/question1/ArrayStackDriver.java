/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 2
 * Question 1 - Implementation of ArrayStack<T> where top is actual top
 */
package com.andrewasquith.comp2231.assignment2.question1;

/**
 * Import the exception we need to catch
 */
import jsjf.exceptions.EmptyCollectionException;

/**
 * Exercises the funcionality of the ArrayStack
 * It is implemented identically to LinkedDropOutStackDriver 
 * so the output can be compared more easily 
 * The two implementations differ in the "full stack" behaviour
 *
 */
public class ArrayStackDriver {

	public static void main(String[] args) {

		// new stack of Integers with capacity of 4
		ArrayStack<Integer> theStack = new ArrayStack<Integer>(4);

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
