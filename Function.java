/* Author: Luigi Vincent
Simple String Reversing
*/

import java.util.*; 
import java.io.*;

public class Function {  
  String Reverse(String str) {  
    return new StringBuilder(str).reverse().toString();
  } 
  
  public static void main (String[] args) {     
    Scanner input = new Scanner(System.in);

    System.out.print(new Function().Reverse(input.nextLine())); 
  }   
}
