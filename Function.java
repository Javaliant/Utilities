/* Author: Luigi Vincent
Simple functions for use, practice, and sharing.
*/

import java.util.*; 
import java.io.*;

public class Function {
  // Reversing a string
  public static String reverse(String str) {  
    return new StringBuilder(str).reverse().toString();
  }
  // Add up all the numbers from 1 to num
  public static int addTill(int num) {
    return num * (num + 1) / 2;
  }
  // Check if a word is a palindrome
  public static boolean isPalindrome(String str) {
  	return str.equals(new StringBuilder(str).reverse().toString());
  }
  // Get int array from String input (ignores, non-integers)
  public static int[] getIntegers(String s) {
    int[] result;
    ArrayList<Integer> helper = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ' ^ i == s.length() - 1) {
            if (i == s.length() - 1) { sb.append(s.charAt(i)); }
            if (sb.toString().length() > 0) {
                try { helper.add(Integer.parseInt(sb.toString()));
                } catch(NumberFormatException nfe) {
                        // Ignore non-integers
                }
                sb.setLength(0);
                continue;
            }
        }
        sb.append(s.charAt(i));
    }

    result = new int[helper.size()];
    int i = 0;

    for (Integer n : helper) {
        result[i++] = n;
    }
    return result;
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
    Scanner input = new Scanner(System.in);
    Function function = new Function();

    // testing functionality

    System.out.print("Enter a word to check if it's a palindrome: ");
    String potentialPalindrome = input.nextLine();
    System.out.println(function.isPalindrome(potentialPalindrome));
    
    System.out.print("Enter a string to reverse: ");
    String toBeReversed = input.nextLine();
    System.out.println(function.reverse(toBeReversed));

    System.out.print("Let's add up all the numbers from 1 to a number.\nChoose the number: ");
    int sumInt = Integer.parseInt(input.nextLine());
    System.out.println(function.addTill(sumInt)); 

    System.out.print("Enter a string to count the vowels of: ");
    String toVowelCount = input.nextLine();
    System.out.println(function.vowelCount(toVowelCount));
  }   
}
