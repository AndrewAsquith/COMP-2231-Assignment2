/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 2
 * Question 1 - Implementation of ArrayStack<T> where top is actual top
 */
package com.andrewasquith.comp2231.assignment2.question1;

/**
 * Import the java.util.Arrays for Arrays.copyOf
 */
import java.util.Arrays;

/**
 * Import the interface the class must adhere to
 * And the exception that it should throw
 */
import jsjf.StackADT;
import jsjf.exceptions.EmptyCollectionException;

/**
 * 
 * Generic implementation of an array based stack where 
 * internally the top index is the actual top of the stack
 *
 * @param <T> element type of the stack
 */
public class ArrayStack<T> implements StackADT<T> {

	/**
	 * Default starting capacity of the stack
	 */
	private final static int DEFAULT_CAPACITY = 100;

	/**
	 * Index of the current top position
	 */
	private int top;

	/**
	 * Array containing the stack
	 */
	private T[] stack;

	/**
	 * Creates an empty stack using the default capacity.
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty stack using the specified capacity.
	 * 
	 * @param initialCapacity
	 *            the initial size of the array
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		
		// stack should point at the current top, since it's empty, use -1
		top = -1;

		// need to cast since we can't create generic type directly
		// use the suppress annotation to inform the compiler
		stack = (T[]) (new Object[initialCapacity]);
	}

	/**
	 * Pushes an element onto the stack
	 * 
	 * @param element
	 *            the element to be pushed onto the stack
	 */
	public void push(T element) {

		if (size() == stack.length) {
			expandCapacity();
		}

		// increment top and put the element in that new position on the stack
		stack[++top] = element;
	}

	/**
	 * Doubles the size of the internal array
	 */
	private void expandCapacity() {

		stack = Arrays.copyOf(stack, stack.length * 2);

	}

	/**
	 * Pops the next element off the stack
	 * 
	 * @return the element at the top of the stack
	 * @throws EmptyCollectionException
	 *             if the stack is empty
	 */
	public T pop() throws EmptyCollectionException {

		// if the stack is empty, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("Stack");
		}

		// get the element at the top
		T temp = stack[top];

		// set the top index in the array to null
		stack[top] = null;

		// decrement top index
		top--;

		// return the element from the original top position
		return temp;

	}

	/**
	 * Returns a reference to the element at the top of the stack without
	 * removing it from the stack
	 * 
	 * @return element at top of stack
	 * @throws EmptyCollectionException
	 *             if the stack is empty
	 */
	public T peek() throws EmptyCollectionException {

		// if the stack is empty, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}

		// top points to the current top, return the element at stack[top]
		return stack[top];
	}

	/**
	 * Determine if the stack is currently empty
	 * 
	 * @return boolean indicating whether stack is empty
	 */
	public boolean isEmpty() {

		// test if size == 0 (nicer for inheritance than relying on top)
		return (size() == 0);
	}

	/**
	 * Returns the current size of the stack
	 * 
	 * @return current size
	 */
	public int size() {

		// top is 0 based so add 1
		return top + 1;
	}

	/**
	 * toString implementation
	 * 
	 * @return a string representation of the stack
	 */
	public String toString() {
		
		String representation = "<TOP OF STACK>" + System.lineSeparator();
		for (int i = top; i >= 0; i--) {
			representation += stack[i] + System.lineSeparator();
		}

		representation += "<BOTTOM OF STACK>";
		return representation;
	}
}
