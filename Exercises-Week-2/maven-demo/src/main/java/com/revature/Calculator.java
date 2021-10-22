package com.revature;

import java.util.Scanner;

public class Calculator {



	/*
	 * Should be able to
	 * 	- add
	 * 	- subtract
	 * 	- multiply
	 * 	- divide
	 * 		- throw Calculator Exception (Runtime) when attempting to divide by 0
	 *	- isPrime: checks if a number is Prime
	 */
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		menu1();
	}
	public static void menu1() {
		System.out.println("Welcome to the Amazing Calculator! To whom do I have the pleasure of working with today?");
		String name = sc.nextLine();
		System.out.println("Nice to meet you " + name + ", let's get started!");
		menu2();
	}
	public static int menu2() {
		System.out.println("Please select from the list of the available options:");
		System.out.println("Option 1: Add 2 numbers");
		System.out.println("Option 2: Subtract 2 numbers");
		System.out.println("Option 3: Multiply 2 numbers");
		System.out.println("Option 4: Divide 2 numbers");
		System.out.println("Option 5: Is my number prime?");
		System.out.println("Option 6: Exit");
		
		int num = sc.nextInt();
		switch (num) {
		case 1: return add(x,y);
				break;
		case 2: return subtract(x,y)
			
		}
	}
	public static double add(double x, double y) {
		double x = sc.nextInt();
		double y = sc.nextInt();
		return (x + y);
	}
	
	public static double subtract(double x, double y) {
		return (x - y);
	}
	
	public static double multiply(double x, double y) {
		return (x * y);
	}
	
	public static double divide(double x, double y) {
		return (x / y);
	}
	
	public static boolean isPrime(double i) {
		return true;
	}
}
