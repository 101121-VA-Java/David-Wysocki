package com.revature.controllers;
import com.revature.controllers.*;
import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.services.EmployeeService;

public class LoginController {

	private static EmployeeService es = new EmployeeService();
	private static Employee principal;
	static Scanner sc = new Scanner(System.in);
	
	public static void run() {
		
		
		
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		System.out.println("Checking credentials");
		try {
			principal = es.login(username, password);

			
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			EntryController.menuEntry();
		}
		System.out.println("Logged in.");
		EntryController.menuEntry();
		sc.close();
		
	}
	
	
	public static void EmployeeMenu() {
		System.out.println("Employee Menu: Please select from the list of available options");
		System.out.println("Option 1: Assigned Tasks");
		System.out.println("Option 2: Customer Assistance");
		System.out.println("Option 3: Log out and Exit");
		Scanner sc = new Scanner(System.in);
		int EmployeeIn = sc.nextInt();
		switch (EmployeeIn) {
		case 1: 
			System.out.println("Task Menu");
			//Add task functionality here
			break;
		case 2: 
			System.out.println("Customer Assistance");
			//Add financing menu path and more customer assistance functionality here.
			break;
		case 3:
			System.out.println("Logging out");
			sc.close();
			break;
			
			default: 
				System.out.println("Not a valid entry, returning to menu");
				EmployeeMenu();
				break;
			
			
		}
	}
	/*
	public static void ManagerMenu() {
		
	}
	public static void SupervisorMenu(){
	}
	
	public static void OwnerMenu() {
		
	}
*/
	}