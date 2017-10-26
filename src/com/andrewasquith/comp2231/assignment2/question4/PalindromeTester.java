/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 2
 * Question 4 - Implementation of palindrome tester
 */
package com.andrewasquith.comp2231.assignment2.question4;

/**
 * Palindrome Tester class
 * provides a (static) method to determine if a string is a palindrome
 */
public class PalindromeTester {

	/**
	 * Uses a stack and a queue to determine if a given string is a palindrome
	 * @param subject the string to test
	 * @return boolean true if is palindrome, false if not
	 */
	public static boolean isPalindrome(String subject) {
		
		//lowercase and trim the subject string for consistency
		subject = subject.toLowerCase().trim();
		
		//make use of the built in classes, use the Queue interface to limit Deque operations
		LinkedQueue<Character> queue = new LinkedQueue<Character>();
		LinkedStack<Character> stack = new LinkedStack<Character>();
		
		//add the individual characters to the stack and queue
		for (int i = 0; i< subject.length(); i++) {
			Character current = (Character)subject.charAt(i);
			queue.enqueue(current);
			stack.push(current);
		}
		
		//if the string is empty we'll say that's a palindrome
		boolean matches = true;
		
		// while the next element matches and the stack and queue are not empty
		while (matches && !stack.isEmpty() && !queue.isEmpty()) {
						
			// continue if the element from the queue matches the one from the stack
			// this works nicely since the stack is FILO and the queue is FIFO
			// fulfilling the backwards and forwards requirement for a palindrome
			matches = (queue.dequeue().compareTo(stack.pop()) == 0);
		}
		
		// if method got all the way through this will be true, otherwise it will have exited
		// at the first point characters did not match each other
		return matches;
		
	}
}
