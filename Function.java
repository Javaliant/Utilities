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
