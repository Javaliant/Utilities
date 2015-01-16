/* Author: Luigi Vincent
Simple functions for use, practice, and sharing.
*/

import java.util.*; 
import java.io.*;

public class Function {
  /* Greatest Common Divisor - 
  Euclidean algorithm: http://en.wikipedia.org/wiki/Euclidean_algorithm */
  public int GCD(int a, int b) { return b == 0 ? a : GCD(b, a % b); }
  // Least Common Multiple
  public int LCM(int a, int b) { return (a * b) / GCD(a, b); }
  // Reversing a string
  public static String reverse(String str) {  
    return new StringBuilder(str).reverse().toString();
  }
  // Check if a word is a palindrome, ignores spaces and non-letter characters.
  public static boolean isPalindrome(String str) {
        String possiblePalindrome = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return possiblePalindrome.length() == 0 ? false : possiblePalindrome.equals(
            new StringBuilder(possiblePalindrome).reverse().toString()
        );
  }
  // Check if a word is a pangram, ignores spaces and non-letter characters.
  public static boolean isPangram(String s) {
		String possiblePangram = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
		if (possiblePangram.length() < 26) { return false; }

		Set<Character> alphabet = new HashSet<Character>() {
    		{
    			add('a'); add('b'); add('c');
    			add('d'); add('e'); add('f');
    			add('g'); add('h'); add('i');
    			add('j'); add('k'); add('l');
    			add('m'); add('n'); add('o');
    			add('p'); add('q'); add('r');
    			add('s'); add('t'); add('u');
    			add('v'); add('w'); add('x');
    			add('y'); add('z');
    		}
		};

		for (int i = 0; i < possiblePangram.length(); i++) {
			if (alphabet.contains(possiblePangram.charAt(i))) {
				alphabet.remove(possiblePangram.charAt(i));
			}
			if (alphabet.size() == 0) { break; }
		}

		return alphabet.size() == 0;
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
  // Check if a number is prime
  public static boolean isPrime(int num) {
    if (num <= 3) { return num > 1; }
    if ((num & 1) == 0 || num % 3 == 0) { return false; }

    int limit = (int) Math.sqrt(num);

    for (int i = 5; i <= limit; i += 6) {
      if (num % i == 0 || num % (i + 2) == 0) { return false; }
    }

    return true;
  }
 /* Get all prime numbers under a number
 Sieve of Eratosthenes - http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes */
 public static List<Integer> getPrimesUnder(int limit) {
	    int prime;
	    List<Integer> primes = new ArrayList<>(),
	    	numbers = new ArrayList<>()
	    ;

	    for (int i = 2; i < limit; i++) {
	    	numbers.add(i);
	    }

	    while (!numbers.isEmpty()) {
	    	prime = numbers.get(0);
	    	primes.add(prime);
	    	for (int i = prime; i < limit; i += prime) {
	    		numbers.remove(new Integer(i));
	    	}
	    }
	    return primes;
	}
  // Check if number is Even
  public static boolean isEven(int n) {
  	return (n & 1) == 0;
  }
  /*Get int array from String input
  ignores non-integers and words that include integers */
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
