/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 2
 * Question 2 - Implementation of DropOut Stack with Linked List
 */
package com.andrewasquith.comp2231.assignment2.question2;

// Import and use the LinearNode class instead of creating our own
import jsjf.LinearNode;
// Import the interface and exceptions we must use
import jsjf.StackADT;
import jsjf.exceptions.EmptyCollectionException;

/**
 * 
 * Implementation of a DropOut Stack using Linked List
 *
 * @param <T>
 */
public class LinkedDropOutStack<T> implements StackADT<T> {

	/**
	 * Default capacity of the stack
	 */
	private final static int DEFAULT_CAPACITY = 10;

	/**
	 * The number of elements current in the stack
	 */
	private int count;

	/**
	 * DropOut Stack will have fixed capacity
	 */
	private int capacity;

	/**
	 * Top node of the Stack
	 */
	private LinearNode<T> top;

	/**
	 * Last node of the stack
	 */
	private LinearNode<T> bottom;

	/**
	 * Creates an empty stack using the default capacity.
	 */
	public LinkedDropOutStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates a stack of the specified capacity
	 * 
	 * @param size
	 *            the fixed capacity of the stack
	 */
	public LinkedDropOutStack(int size) {

		// set the capacity to the requested size if sane
		if (size > 1) {
			capacity = size;
		} else {
			capacity = DEFAULT_CAPACITY;
		}

		// set the counter to 0
		count = 0;

		// set the top to null
		top = null;

	}

	/**
	 * Drop out push implementation if a new element is added to a full stack
	 * the oldest element must disappear 
	 * This is O(n) when the stack is full
	 * due to the need to iterate the whole list to find the new bottom
	 */
	public void push(T element) {

		// if the stack is full we need to do the drop out
		if (size() == capacity) {

			LinearNode<T> current = top;

			// iterate through the list to the 2nd to last element
			for (int i = 2; i < count; i++) {
				current = current.getNext();
			}
			// set the 2nd last node's next pointer to null
			current.setNext(null);

			// decrement count so we can just do the add like normal
			count--;

		}

		// create a new node
		LinearNode<T> newNode = new LinearNode<T>(element);

		// set new node next to current top - works if stack is empty too
		newNode.setNext(top);

		// reassign top to new node
		top = newNode;

		// increment counter
		count++;
	
	}

	/**
	 * Removes and returns the top element from the stack
	 * @return the top element of the stack
	 * @throws EmptyCollectionException if the stack is empty
	 */
	public T pop() throws EmptyCollectionException {

		// throw if the stack is empty
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}

		// get the current top element
		T temp = top.getElement();

		// reassign top to next element
		top = top.getNext();

		// decrement the counter
		count--;

		// return the element
		return temp;

	}

	/**
	 * Returns the top element of the stack but does not remove it
	 * @return the top element of the stack
	 * @throws EmptyCollectionException if the stack is empty
	 */
	public T peek() throws EmptyCollectionException {

		// throw if the stack is empty
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}

		// return the element at top
		return top.getElement();
	}

	/**
	 * Determines if the stack is empty
	 * 
	 * @return boolean indicating if the stack is empty
	 */
	public boolean isEmpty() {

		// if count is 0 stack is empty, otherwise not
		return (count == 0);
	}

	/**
	 * Retrieve the current size of the stack
	 * 
	 */
	public int size() {

		// return the counter variable
		return count;

	}

	/**
	 * toString implementation
	 * 
	 * @return a string representation of the stack
	 */
	public String toString() {

		LinearNode<T> current = top;

		String representation = "<TOP OF STACK>" + System.lineSeparator();
		
		while (current != null) {
			representation += current.getElement() + System.lineSeparator();
			current = current.getNext();
		}

		representation += "<BOTTOM OF STACK>";
		return representation;
	}

}
