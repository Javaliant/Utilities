/* Author: Luigi Vincent
Simple functions for use, practice, and sharing.
*/

import java.util.*; 
import java.io.*;

public class Function {
  // Reversing a string
  String reverse(String str) {  
    return new StringBuilder(str).reverse().toString();
  }
  // add up all the numbers from 1 to num
  int addTill(int num) {
    return num * (num + 1) / 2;
  } 
  
  public static void main (String[] args) {     
    Scanner input = new Scanner(System.in);
    Function function = new Function();

    // testing functionality
    System.out.println(function.reverse(input.nextLine()));
    System.out.println(function.addTill(input.nextInt())); 
  }   
}
