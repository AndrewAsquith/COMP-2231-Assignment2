/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 2
 * Question 3 - Implementation of Array based Deque
 */
package com.andrewasquith.comp2231.assignment2.question3;

/**
 * Driver class for the ArrayDeque
 * Exercises the functionality of the implementation with two instances
 * one resizable, one not.
 * The classs also contains a helper method for friendly printing after each operation
 * and accepts an optional debug argument from the command line that will cause
 * the Deque to print it's internal array layout after each operation
 *
 */
public class ArrayDequeDriver {

	public static void main(String[] args) {
		
		boolean printDebug = false;
		
		//see if debug output was requested and update the flag accordingly
		if (args.length > 0) {
			for(String arg:args) {
				if (arg.toLowerCase().equals("debug")) {
					printDebug = true;
				}
			}
		}
		


		//temporary storage for the returned values of peek/get operations
		Integer temp;
		//temporary storage for the returned values of the offer operations
		boolean offerResult;
		
		System.out.println("===========Non-Resizable===========");
		ArrayDeque<Integer> nonResizable = new ArrayDeque<Integer>(4, false);
		printQueueAfterOperation("Initialization, size 4, not resizable", nonResizable, printDebug);
		
		System.out.print("removeFirst from empty Queue: ");
		try {
			nonResizable.removeFirst();
		} catch (IllegalStateException e) {
			System.out.println("Got Exception: " + e.getMessage());
		}
		
		System.out.print("removeLast from empty Queue: ");
		try {
			nonResizable.removeLast();
		} catch (IllegalStateException e) {
			System.out.println("Got Exception: " + e.getMessage());
		}
		
		System.out.print("getFirst from empty Queue: ");
		try {
			nonResizable.getFirst();
		} catch (IllegalStateException e) {
			System.out.println("Got Exception: " + e.getMessage());
		}
		
		System.out.print("getLast from empty Queue: ");
		try {
			nonResizable.getLast();
		} catch (IllegalStateException e) {
			System.out.println("Got Exception: " + e.getMessage());
		}
		
		System.out.print("pollFirst from empty Queue: ");
		System.out.println("Got: " + nonResizable.pollFirst());
		
		System.out.print("pollLast from empty Queue: ");
		System.out.println("Got: " + nonResizable.pollLast());
		
		System.out.print("peekFirst from empty Queue: ");
		System.out.println("Got: " + nonResizable.pollFirst());
		
		System.out.print("peekLast from empty Queue: ");
		System.out.println("Got: " + nonResizable.pollLast());
		
		System.out.println();
		
		nonResizable.addFirst(new Integer(1));
		printQueueAfterOperation("Add 1 to front", nonResizable, printDebug);
		System.out.println();

		nonResizable.addLast(new Integer(2));
		printQueueAfterOperation("Add 2 to back", nonResizable, printDebug);
		System.out.println();

		offerResult = nonResizable.offerLast(new Integer(3));
		System.out.println("Offer result: " + offerResult);
		printQueueAfterOperation("Offer 3 to back", nonResizable, printDebug);
		System.out.println();

		
		offerResult = nonResizable.offerFirst(new Integer(4));
		System.out.println("Offer result: " + offerResult);
		printQueueAfterOperation("Offer 4 to front", nonResizable, printDebug);

		System.out.println();

		temp = nonResizable.removeFirst();
		System.out.println("Removed: " + temp);
		printQueueAfterOperation("Remove 4 from front", nonResizable, printDebug);
		System.out.println();

		temp = nonResizable.removeFirst();
		System.out.println("Removed: " + temp);
		printQueueAfterOperation("Remove 1 from front", nonResizable, printDebug);
		System.out.println();
		
		nonResizable.addLast(new Integer(5));
		printQueueAfterOperation("Add 5 to back - causes shift left", nonResizable, printDebug);
		System.out.println();
		
		nonResizable.addLast(new Integer(7));
		printQueueAfterOperation("Add 5 to back - causes shift left", nonResizable, printDebug);
		System.out.println();

		temp = nonResizable.removeLast();
		System.out.println("Removed: " + temp);
		printQueueAfterOperation("Remove 7 from back", nonResizable, printDebug);
		System.out.println();

		nonResizable.addFirst(new Integer(6));
		printQueueAfterOperation("Add 6 to front - causes shift right", nonResizable, printDebug);

		System.out.println();

		System.out.print("addFirst to full, non-resizable Queue: ");
		try {
			nonResizable.addFirst(new Integer(11));
		} catch (IllegalStateException e) {
			System.out.println("Got Exception: " + e.getMessage());
		}
		
		System.out.print("addLast to full, non-resizable Queue: ");
		try {
			nonResizable.addLast(new Integer(11));
		} catch (IllegalStateException e) {
			System.out.println("Got Exception: " + e.getMessage());
		}
		
		System.out.print("offerFirst to full, non-resizable Queue: ");
		System.out.println("Got: " + nonResizable.offerFirst(new Integer(11)));
		
		System.out.print("offerLast to full, non-resizable Queue: ");
		System.out.println("Got: " + nonResizable.offerLast(new Integer(11)));

		System.out.println();
		System.out.println("Emptying Queue:");
		
		temp = nonResizable.removeFirst();
		System.out.println("Removed: " + temp);
		printQueueAfterOperation("Remove from front", nonResizable, printDebug);
		System.out.println();

		temp = nonResizable.removeLast();
		System.out.println("Removed: " + temp);
		printQueueAfterOperation("Remove from back", nonResizable, printDebug);
		System.out.println();

		temp = nonResizable.removeFirst();
		System.out.println("Removed: " + temp);
		printQueueAfterOperation("Remove from front", nonResizable, printDebug);
		System.out.println();

		temp = nonResizable.removeLast();
		System.out.println("Removed: " + temp);
		printQueueAfterOperation("Remove from back", nonResizable, printDebug);

		System.out.println();

		System.out.println("===========Resizable===========");
		ArrayDeque<Integer> resizable = new ArrayDeque<Integer>(4, true);
		printQueueAfterOperation("Initialization, size 4, resizable", nonResizable, printDebug);
		System.out.println();

		resizable.addFirst(new Integer(1));
		printQueueAfterOperation("Add 1 to front", resizable, printDebug);
		System.out.println();

		resizable.addLast(new Integer(2));
		printQueueAfterOperation("Add 2 to back", resizable, printDebug);
		System.out.println();

		resizable.addLast(new Integer(3));
		printQueueAfterOperation("Add 3 to back", resizable, printDebug);
		System.out.println();

		resizable.addFirst(new Integer(4));
		printQueueAfterOperation("Add 4 to front", resizable, printDebug);
		System.out.println();

		temp = resizable.removeFirst();
		System.out.println("Removed: " + temp);
		printQueueAfterOperation("Remove 4 from front", resizable, printDebug);
		System.out.println();


		resizable.addLast(new Integer(5));
		printQueueAfterOperation("Add 5 to back - causes shift left", resizable, printDebug);
		System.out.println();

		temp = resizable.removeLast();
		System.out.println("Removed: " + temp);
		printQueueAfterOperation("Remove 5 from back", resizable, printDebug);
		System.out.println();

		resizable.addFirst(new Integer(6));
		printQueueAfterOperation("Add 6 to front - causes shift right", resizable, printDebug);
		System.out.println();

		offerResult = resizable.offerFirst(new Integer(10));
		System.out.println("Offer Result: " + offerResult);
		printQueueAfterOperation("Offer 10 to front - causes shift right and expansion", resizable, printDebug);
		System.out.println();
		
		offerResult = resizable.offerLast(new Integer(12));
		System.out.println("Offer Result: " + offerResult);
		printQueueAfterOperation("Offer 12 to back after expansion", resizable, printDebug);
		System.out.println();
		
		
	}

	private static void printQueueAfterOperation(String operation, ArrayDeque subject, boolean debug) {
		
		System.out.println("Operation: " + operation);
		System.out.println("Queue: " + subject);
		if (debug) {
			System.out.println("Array layout:");
			System.out.println(subject.printDebug());
		}
	}
	
}
