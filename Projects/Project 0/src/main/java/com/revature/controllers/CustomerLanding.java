package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.models.Role;
import com.revature.services.CustomerService;

public class CustomerLanding {
	static Scanner csMenu = new Scanner(System.in);
	
	public static void menuCustomerLanding() {
		System.out.println("Welcome Customer! What would you like to do?");
		System.out.println("Please select from the following options");
		System.out.println("Option 1: Registering as a new user");
		System.out.println("Option 2: Logging in as an existing user");
		System.out.println("Option 3: Return to previous menu");
		System.out.println("Option 4: Exit");
		
		int csLandingInt = csMenu.nextInt();
		
		switch (csLandingInt) {
		case 1:
			System.out.println("Welcome new customer! We are happy to have you join our flock. What is your name?");
			csMenu.nextLine();
			String csName = csMenu.nextLine();
			System.out.println("Great! What would you like your unique username to be?");
			String csUsername = csMenu.nextLine();
			System.out.println("What password would you like to have?");
			String csPassword = csMenu.nextLine();
			System.out.println("Finally, what is a good email address you would like to provide?");
			String csEmail = csMenu.nextLine();
			System.out.println("Just want to make sure everything is correct. Your name is " + csName + ",");
			System.out.println(" your username is " + csUsername + ", your password is " + csPassword + ",");
			System.out.println(" and your email is " + csEmail + ". Did I get everything right? (true/false)");
			if (csMenu.nextBoolean() == !true) {
				System.out.println("Oops, something did not go right. Let's try again!");
				menuCustomerLanding(); 
			}
			Customer newCust = new Customer(csName, csUsername, csPassword, csEmail, true, Role.CUSTOMER);
			
			try {
				newCust = CustomerService.addCustomer(newCust);
				System.out.println("Congratulations! You are registered. You may now login.");
			} catch (UsernameAlreadyExistsException c) {
				System.out.println("Username is already in use.\nPlease try again.");
				menuCustomerLanding();
			}
			
			
			menuCustomerLanding();
			break;
		case 2: LoginController.crun();
			break; 
		case 3:
			EntryController.menuEntry();
			break;
		case 4:
			System.out.println("Have a great day!");
			break;
			default: 
				System.out.println("Oops, something went wrong. Returning to menu");
				menuCustomerLanding();
		}
		csMenu.close();
	}
}
