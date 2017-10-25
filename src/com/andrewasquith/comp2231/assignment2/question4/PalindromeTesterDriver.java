/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 2
 * Question 4 - Implementation of palindrome tester
 */
package com.andrewasquith.comp2231.assignment2.question4;

/**
 * Driver class for the PalindromeTester
 * Provides several different inputs both palindromes and not
 * and ensures trimming and normalizing of casing occurs
 */
public class PalindromeTesterDriver {

	/**
	 * Runs the tests and outputs the results
	 * @param args ignored
	 */
	public static void main(String[] args) {


		// Empty string (treating this as true since a single character technically is a palindrome)
		System.out.println("Empty String (\"\"): " + PalindromeTester.isPalindrome(""));
		
		// true simple palindrome
		System.out.println("BOB: " + PalindromeTester.isPalindrome("BOB"));
		
		// mixed case palindrome, should be normalized
		System.out.println("Bob: " + PalindromeTester.isPalindrome("Bob"));
		
		// non palindrome
		System.out.println("Robert: " + PalindromeTester.isPalindrome("Robert"));
		
		//palindrome if spaces are trimmed
		System.out.println("tattarrattat: " + PalindromeTester.isPalindrome("tattarrattat "));
		
		// palindrome with spaces and mixed case
		System.out.println("Able was I ere I saw Elba: " + PalindromeTester.isPalindrome("Able was I ere I saw Elba"));
		
		// the longest palindrome in current everyday use 
		// https://en.wikipedia.org/wiki/Palindrome#cite_note-24 
		System.out.println("saippuakivikauppias: " + PalindromeTester.isPalindrome("saippuakivikauppias"));
	}

}
