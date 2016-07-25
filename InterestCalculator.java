/* Author: Luigi Vincent
* Just a quick compound interest calculator
*/

import java.util.Scanner;

public class InterestCalculator {
	private static final String HEADER = String.format("%4s %10s %10s %10s %15s%n%4s %10s %10s %10s %15s", "Year", "Balance", "Savings", "Interest", "Ending Balance", "----", "-------", "-------", "--------", "--------------");
	private static double initialBalance;
	private static double annualSavings;
	private static int years;
	private static double percentageReturn;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		if (args.length != 4) {
			System.out.print("Enter the initial balance: ");
			initialBalance = keyboard.nextDouble();
			System.out.print("Annual savings amount: ");
			annualSavings = keyboard.nextDouble();
			System.out.print("Number of years: ");
			years = keyboard.nextInt();
			System.out.print("Rate of pre-tax return: ");
			percentageReturn = 1 + keyboard.nextDouble() * 0.01;
		} else {
			initialBalance = Double.parseDouble(args[0]);
			annualSavings = Double.parseDouble(args[1]);
			years = Integer.parseInt(args[2]);
			percentageReturn = 1 + Double.parseDouble(args[3]) * 0.01;
		}

		System.out.println(computeDisplay(initialBalance, annualSavings, years, percentageReturn));
	}

	private static String computeDisplay(double initialBalance, double annualSavings, int years, double percentageReturn) {
		StringBuilder displayBuilder = new StringBuilder(HEADER);
		for (int year = 1; year <= years; year++) {
			initialBalance += annualSavings;
			double newBalance = initialBalance * percentageReturn;
			displayBuilder.append(String.format("%n%3d %10.0f %11.0f %8.0f %12.0f", year, initialBalance, annualSavings, newBalance - initialBalance, newBalance));
			initialBalance = newBalance;
		}
		return displayBuilder.toString();
	}
}
