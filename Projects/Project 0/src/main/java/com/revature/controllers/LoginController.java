package com.revature.controllers;

import com.revature.controllers.*;
import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.EmployeePostgres;
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
			System.out.println("Task Menu:");
			
			// Add task functionality here
			break;
		case 2:
			System.out.println("Customer Assistance");
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

	public static void CustomerMenu() {
		System.out.println("Customer Menu - Please select one of the available options");
		System.out.println("Option 1: View Store Inventory");
		System.out.println("Option 2: Create Offer");
		System.out.println("Option 3: Account Status and Payments");
		System.out.println("Option 4: Log off and Exit");
		int cmInput = sc.nextInt();
		switch (cmInput) {
		case 1: //Implement store inventory function
			break;
		case 2: //Implement offer function correlating between ID and an int value.
			break;
		case 3: //set up new menu path that has edit account feature and financing payments info.
			break;
		case 4: 
			System.out.println("Have a good day! Logging off.");
			sc.close();
			EntryController.menuEntry();
			default:
				System.out.println("That's not a valid input. ");
		}
		
		
	}
	 public static void ManagerMenu() {
		 System.out.println("Manager Menu - Please select from one of the available options");
		 System.out.println("Option 1: View Store Inventory");
		 System.out.println("Option 2: Add to inventory");
		 System.out.println("Option 3: Edit Item in Inventory");
		 System.out.println("Option 4: Remove from Inventory");
		 System.out.println("Option 5: View Current Offers");
		 System.out.println("Option 6: Employee Task Manager");
		 System.out.println("Option 7: Add Employee");
		 System.out.println("Option 8: Remove Employee");
		 System.out.println("Option 9: Sales History");
		//add switch and functionality
	  }
	 public static void SupervisorMenu(){ 
		 System.out.println("Supervisor Menu - Please select from one of the available options");
		 System.out.println("Option 1: View Tasks");
		 System.out.println("Option 2: Assign Tasks");
		 System.out.println("Option 3: Customer Assistance");
		 //add switch and functionality
		 
	 }
	 
	  public static void OwnerMenu() {
		  System.out.println("Owner Menu - Please select from one of the available options");
			 System.out.println("Option 1: View Store Inventory");
			 System.out.println("Option 2: Add to inventory");
			 System.out.println("Option 3: Edit Item in Inventory");
			 System.out.println("Option 4: Remove from Inventory");
			 System.out.println("Option 5: View Current Offers");
			 System.out.println("Option 6: Employee Task Manager");
			 System.out.println("Option 7: Add Employee");
			 System.out.println("Option 8: Edit Employee Name");
			 System.out.println("Option 9: Remove Employee");
			 System.out.println("Option 10: Sales History");
			 System.out.println("Option 11: Start Giveaway");
			 System.out.println("Option 12: Exit and Logout");
			 int oMenu = sc.nextInt();
			 switch (oMenu) {
			 case 1: System.out.println("Store Inventory");
				 break;
			 case 2: //
				 break;
			 case 3: //
				 break;
			 case 4: //
				 break;
			 case 5: //
				 break;
			 case 6: //
				 break;
			 case 7: //
				 break;
			 case 8: es.update(principal);
			 OwnerMenu();
				 break;
			 case 9: //
				 break;
			 case 10: //
				 break;
			 case 11: //
				 break;
			 case 12: //
				 System.out.println("Have a great day, boss!");
				 sc.close();
				 EntryController.menuEntry();
				 break;
				 default: System.out.println("Not a valid option returning to menu.");
				 LoginController.OwnerMenu();
				 break;
			 }
	  }
	 
}