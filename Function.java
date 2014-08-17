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
  // add up all the numbers from 1 to num
  public static int addTill(int num) {
    return num * (num + 1) / 2;
  }
  // check if a word is a palindrome
  public static boolean isPalindrome(String str) {
  	return str.equals(new StringBuilder(str).reverse().toString());
  }
  
  public static void main (String[] args) {     
    Scanner input = new Scanner(System.in);
    Function function = new Function();

    // testing functionality
    System.out.print("Enter a string to reverse: ");
    String toBeReversed = input.nextLine();
    System.out.println(function.reverse(toBeReversed));

    System.out.print("Let's add up all the numbers from 1 to a number.\nChoose the number: ");
    int sumInt = input.nextInt();
    System.out.println(function.addTill(sumInt));

    System.out.print("Enter a word to check if it's a palindrome: ");
    String potentialPalindrome = input.next();
    System.out.println(function.isPalindrome(potentialPalindrome));
  }   
}
