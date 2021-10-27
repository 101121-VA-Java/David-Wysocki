package com.revature.controllers;

import java.util.Scanner;

import com.revature.controllers.*;

public class EntryController {
	static Scanner se = new Scanner(System.in);

	public static void main(String[] args) {
		menuEntry();
	}

	public static void menuEntry() {
		System.out.println("Welcome to Some Kind of Bird Shop! Please select from the available options (Enter 1-3)");
		System.out.println("Option 1: Employee Service");
		System.out.println("Option 2: Customer Service");
		System.out.println("Option 3: Exit");

		int seInput = se.nextInt();
		switch (seInput) {
		case 1:
			//menuEmployeeService();
			break;
		case 2:
			//menuCustomerService();
			break;
		case 3:
			System.out.println("Thank you for coming to the Some Kind of Bird Shop! Have a nice day.");
			break;
		default:
			System.out.println("Sorry, that's not a valid input. Returning to main menu");
			menuEntry();
			break;

		}
		se.close();
	}

}
