/* Author: Luigi Vincent
Simple functions for use, practice, and sharing.
*/

import java.util.*; 
import java.io.*;

// TO DO Research Functions

public class Utilities {
	/* Finds and returns Greatest Common Divisor - 
	Euclidean algorithm: http://en.wikipedia.org/wiki/Euclidean_algorithm */
  	public int computeGCD(int a, int b) {
  		return b == 0 ? a : computeGCD(b, a % b);
  	}
  	// Finds and returns Least Common Multiple
  	public int computeLCM(int a, int b) {
  		return (a * b) / computeGCD(a, b);
  	}
  	// Permutation calculators
  	public static int permutate(int p, int r) {
		int result = 1;
		for (int i = p; r > 0; r--, p--) {
			result *= p;
		}

		return result;
	}

	public static int permutate(int p) {
		return permutate(p, p);
	}
	// Combination
	private static int combine(int total, int select) {
		select = Math.min(select, total - select);
    		return permutate(total, select) / permutate(select);
	}
	// Checking if a tree is balanced.
	public boolean isBalanced(Node root){
        	return getHeight(root)!=-1;
    	}
	// getting height of nodes
	private static int getHeight(Node node) {
		if (node == null) return 0;

		int leftHeight  = getHeight(node.getLeft());
	        int rightHeight = getHeight(node.getRight());
	
		int taller  = Math.max(leftHeight, rightHeight);
	        int shorter = Math.min(leftHeight, rightHeight);
	
	    	if (shorter < 0 || taller - shorter > 1) {
	        	return -1;           // Unbalanced tree
	    	} else {
	        	return taller + 1;
	    	}
	}
	// Getting the median of 3 values
	private static <T extends Comparable<? super T>> T median3(T a, T b, T c) {
    	List<T> medianHelper = Arrays.asList(a, b, c);
    	Collections.sort(medianHelper);

    	return medianHelper.get(1);
	}
  	// Sorting a map b values
  	public static <K, V extends Comparable<? super V>> Map<K, V>  sortByValue( Map<K, V> map ) {
      		Map<K,V> result = new LinkedHashMap<>();
     		Stream <Entry<K,V>> st = map.entrySet().stream();

     		st.sorted(Comparator.comparing(e -> e.getValue()))
        		.forEach(e ->result.put(e.getKey(), e.getValue())
        	);

     		return result;
  	}
  	// Reverses a string
  	public static String reverse(String str) {  
		return new StringBuilder(str).reverse().toString();
  	}
  	// Checks if a string is a palindrome
  	public static boolean isPalindromic(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
       		if (s.charAt(i) != s.charAt(j)) {
            	return false;
            }
    	}
    	return true;
	}
	// Finds a number's digital root
  	public static int computeDigitalRoot(int n) {
		return n == 0 ? 0 : n % 9 == 0 ? 9 : n % 9;
	}
	// Checks if an integer is a palindrome
	public static boolean isPalindromic(int s) {
        return s == reverse(s);
	}
	// Reverses an integer
	public static int reverse(int p) {
    	int reverse = 0

    	while (p != 0) {
	        reverse *= 10;
	        reverse += (p % 10);
	        p /= 10;
    	}
    
		return reverse;
	}
  	/* Checks if a word is a palindrome,
  	ignores case, spaces and non-letter characters. */
  	public static boolean isPalindrome(String str) {
        String potential = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return potential.length() == 0 ? false : isPalindromic(potential);
  	}
  	// Check if a word is a pangram, ignores spaces and non-letter characters.
  	public static boolean isPangram(String s) {
		String possiblePangram = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

		if (possiblePangram.length() < 26) {
			return false;
		}

		Set<Character> alphabet = new HashSet<Character>() {
    		{
    			add('a');
    			add('b');
    			add('c');
    			add('d');
    			add('e');
    			add('f');
    			add('g');
    			add('h');
    			add('i');
    			add('j');
    			add('k');
    			add('l');
    			add('m');
    			add('n');
    			add('o');
    			add('p');
    			add('q');
    			add('r');
    			add('s');
    			add('t');
    			add('u');
    			add('v');
    			add('w');
    			add('x');
    			add('y');
    			add('z');
    		}
		};

		for (int i = 0; i < possiblePangram.length(); i++) {
			if (alphabet.contains(possiblePangram.charAt(i))) {
				alphabet.remove(possiblePangram.charAt(i));
			}
			if (alphabet.size() == 0) {
				break;
			}
		}

		return alphabet.size() == 0;
	}
  	// Matrix Search
  	public static boolean search(int[][] matrix, int target) {
		for (int[] array : matrix) {
			for (int possibleTarget : array) {
				if (target == possibleTarget) {
					return true; // target found
				}
			}
		}
		return false; // target not found
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
  	// Count the number of appearances of an item in a list
	public static <T> int countAppearances(List<T> list, T item) {
	    int count = 0;

	    for (T t : list) {
	        if (t.equals(item)) {
	            count++;
	        }
	    }

	    return count;
	}
	// Filters out non-unique members of a list
	public static <T> List<T> filterUniques(List<T> list) {
	    List<T> result = new ArrayList<>();

	    for (T t : list) {
	        if (countAppearances(list, t) == 1) {
	            result.add(t);
	        }
	    }

	    return result;
	}
	// Gets array of integers from array of strings
	public static int[] toIntArray(String[] array) {
		int[] nums = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			nums[i] = Integer.parseInt(array[i]);
		}

		return nums;
	}
  	// Check if a number is prime
  	public static boolean isPrime(int num) {
    	if (num <= 3) {
    		return num > 1;
    	}
    	if ((num & 1) == 0 || num % 3 == 0) {
    		return false;
    	}

    	int limit = (int) Math.sqrt(num);

    	for (int i = 5; i <= limit; i += 6) {
      		if (num % i == 0 || num % (i + 2) == 0) {
      			return false;
      		}
    	}

    	return true;
  	}
 	/* Get all prime numbers under a number
 	Uses Sieve of Eratosthenes
 	http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes */
 	public static List<Integer> getPrimesUnder(int limit) {
		boolean[] sieve = new boolean[limit];
		Arrays.fill(sieve, true);
		List<Integer> primes = new ArrayList<>();

		for (int prime = 2; prime < sieve.length; prime++) {
    		if (sieve[prime]) {
    			primes.add(prime);
        		for (int np = prime * 2; np < sieve.length; np += prime) {
            		sieve[np] = false;
        		}
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
  	// Counts and returns the vowels in a string
	public static int vowelCount(String str) {
    	int count = 0;
    	int len = str.length();

  		if (str.isEmpty()){
  			return count;
  		}

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
  
	public static int countOccurences(int[] array, int key) {
		int count = 0;

		for (int n : array) {
			if (n == key) {
				count++;
			}
		}
	
		return count;
	}
  
  	public static String toCapitalized(String label) {
        return label.substring(0, 1).toUpperCase()
        	+  label.substring(1).toLowerCase()
        ;
    }
}
