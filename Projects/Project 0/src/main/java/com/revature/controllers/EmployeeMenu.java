package com.revature.controllers;

import java.util.Scanner;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.exceptions.EmployeeNotFoundException;
import com.revature.exceptions.UsernameAlreadyExistsException;
public class EmployeeMenu {
	static Scanner esMenu = new Scanner(System.in);

	public static void menuEmployeeLanding() {

		System.out.println("Welcome Employee! Please select from the menu of available options");
		System.out.println("Option 1: Register as an Employee");
		System.out.println("Option 2: Login");
		System.out.println("Option 3: Return to last menu");
		System.out.println("Option 4: Exit");

		int landingInt = esMenu.nextInt();

		switch (landingInt) {
		case 1:
			System.out.println("Welcome new Employee! Let's start off with your name.");
			esMenu.nextLine();
			String EmployeeName = esMenu.nextLine();
			System.out.println("We're glad to have you " + EmployeeName + "! What would you like your username to be?");
			String EmployeeUserName = esMenu.nextLine();

			System.out.println("Great! Lastly, what password would you like?");
			String EmployeePassword = esMenu.nextLine();

			System.out.println("So just to recap, your name is " + EmployeeName + ", your username is "
					+ EmployeeUserName + ", and the password you have chosen is " + EmployeePassword
					+ ". Is this correct? (true/false)");
			if (esMenu.nextBoolean() == !true) {
				System.out.println("Oops, something has gone wrong. Let's try again.");
				menuEmployeeLanding();
			}
			Employee newEmp = new Employee(EmployeeName, EmployeeUserName, EmployeePassword);
			
			try {
				newEmp = EmployeeService.addEmployee(newEmp);
				System.out.println("Welcome " + newEmp.getName() + "!");
			} catch (UsernameAlreadyExistsException e) {
				System.out.println("Username is already in use.\nPlease try again.");
			}
			System.out.println("Congratulations! You are registered! Returning to menu.");
			menuEmployeeLanding();

		case 2: 
			LoginController.run();
			
			break;
		case 3:EntryController.menuEntry();
		break;
		case 4:
			System.out.println("Have a great day!");
			break;
		default:
			System.out.println("Oops, thats not a correct choice. Returning to menu.");
			menuEmployeeLanding();
		}
		esMenu.close();
	}
}
