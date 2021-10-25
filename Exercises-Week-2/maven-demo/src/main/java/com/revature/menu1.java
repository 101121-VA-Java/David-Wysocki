package com.revature;

import java.util.Scanner;

public class menu1 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	}
	

	public static  void menuFirst() {
		System.out.println("Welcome to the Amazing Calculator! To whom do I have the pleasure of working with today?");
		String yourName = sc.nextLine();
		System.out.println("Nice to meet you " + yourName + ", let's get started!");
		menu2();
	}

	public static void menu2() {
		System.out.println("Please select from the list of the available options:");
		System.out.println("Option 1: Add 2 numbers");
		System.out.println("Option 2: Subtract 2 numbers");
		System.out.println("Option 3: Multiply 2 numbers");
		System.out.println("Option 4: Divide 2 numbers");
		System.out.println("Option 5: Is my number prime?");
		System.out.println("Option 6: Exit");

		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.println("What is the first number you would like to add?");
			Double x = sc.nextDouble();
			System.out.println("What is your 2nd number?");
			Double y = sc.nextDouble();
			add.addThem(x, y);
			break;
		case 2:
			System.out.println("What is the first number you would like to subtract?");
			Double x1 = sc.nextDouble();
			System.out.println("What is your 2nd number?");
			Double y1 = sc.nextDouble();
			subtract.subThem(x1, y1);
			break;
		case 3:
			System.out.println("What is the first number you would like to multiply?");
			Double x2 = sc.nextDouble();
			System.out.println("What is your 2nd number?");
			Double y2 = sc.nextDouble();
			multiply.multiplyThem(x2, y2);
			break;
		case 4:
			System.out.println("What is the first number you would like to divide?");
			Double x3 = sc.nextDouble();
			System.out.println("What is your 2nd number?");
			Double y3 = sc.nextDouble();
			divide.divideThem(x3, y3);
			break;
		case 5: 
			System.out.println("What number would you like to see is prime?");
			int a = sc.nextInt();
			prime.isPrime(a);
			menu2();
		case 6:
			System.out.println("Understandable, have a nice day!");
			
			break;

		default:
			System.out.println("Error, thats not a correct choice");
			menu2();
			break;
		}
		sc.close();
	}
	
}
