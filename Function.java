/* Author: Luigi Vincent
Simple functions for use, practice, and sharing.
*/

import java.util.*; 
import java.io.*;

public class Function {
  //Greatest Common Divisor - Euclidean algorithm: http://en.wikipedia.org/wiki/Euclidean_algorithm
  public int GCD(int a, int b) { return b == 0 ? a : GCD(b, a % b); }
  // Least Common Multiple
  public int LCM(int a, int b) { return (a * b) / GCD(a, b); }
  // Reversing a string
  public static String reverse(String str) {  
    return new StringBuilder(str).reverse().toString();
  }
  // Check if a word is a palindrome
  public static boolean isPalindrome(String str) {
  	return str.equals(reverse(str));
  }
  // Add up all the numbers from 1 to num
  public static int addTill(int num) {
    return num * (num + 1) / 2;
  }
  // Get the largest number
  public static Double maxNum(Double... num) {
  	Double largest = num[0];
  	for (Double n : num) {
  		largest = Math.max(largest, n);
  	}
  	return largest;
  }
  // Check if a number is prime -- expects a positive int
  private static boolean isPrime(long num) {
    	if (num < 1) {
    		throw new IllegalArgumentException(
    			"Argument must be a positive integer." +
    			"\n Argument was: " + num + "."
    		);
    	}
    	if (num <= 3){ return num > 1; }
        if ((num & 1) == 0) { return false; }

        for (int i = 5; i * i <= num; i += 2) {
            if (num % i == 0) {
            	return false;
            }
        }
        return true;
}
  // Check if number is Even
  public static boolean isEven(int n) {
  	return  (n & 1) == 0 ? true : false;
  }
  // Get int array from String input, ignores non-integers and words that include integers
  public static int[] getIntegers(String s) {
    	ArrayList<Integer> helper = new ArrayList<>();
    	StringBuilder sb = new StringBuilder();

    	for (int i = 0; i <= s.length(); i++) {
        	if (i == s.length() || s.charAt(i) == ' ') { // End or Delimiter
            		try { 
                		helper.add(Integer.parseInt(sb.toString()));
            		} catch(NumberFormatException nfe) {
                	// Ignore non-integers and empty strings
            		}
            		sb.setLength(0);
        	} else {
            		sb.append(s.charAt(i)); // Possible integer
        	}
    	}

	int[] result = new int[helper.size()];
	int i = 0;
	for (Integer n : helper) {
		result[i++] = n;
	}
	return result;
}
	// Without ignoring integers in between words
	public static int[] getAllIntegers(String input) { 
		return Arrays.stream(input.split("\\D+"))
	       .filter(word -> !word.isEmpty())
	       .mapToInt(word -> Integer.parseInt(word))
	       .toArray();

	    /*Without using Java 8
	    String[] digitwords = input.split("\\D+");
		int[] result = new int[digitwords.length];
		for (int i = 0; i < result.length; i++) {
	    	result[i] = Integer.parseInt(digitwords[i]);
		}
		return result; */
   	}
  // Count the vowels in a string
  public static int vowelCount(String str) {
    int count = 0, len = str.length();
  	if (str.isEmpty()){ return count; }
  	for (int i = 0; i < len; i++){
  		switch(str.charAt(i)) {
  			case 'a':
  			case 'e':
  			case 'i':
  			case 'o':
  			case 'u':
  				count += 1;
  				break;
  		}
  	}
  	return count;
  }
  
  public static void main (String[] args) {     
  	// tests
  }
}
