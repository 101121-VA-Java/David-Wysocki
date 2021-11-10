package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.Bird;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Offers;
import com.revature.models.Task;
import com.revature.services.BirdService;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;
import com.revature.services.TaskService;
import com.revature.services.OfferService;

public class LoginController {

	private static EmployeeService es = new EmployeeService();
	private static CustomerService cs = new CustomerService();
	private static Employee principal;
	private static Customer hold;
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

	public static void crun() {

		System.out.println("Please enter your username:");
		String username = sc.nextLine();

		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		System.out.println("Checking credentials");
		try {
			hold = cs.login(username, password);

		} catch (LoginException c) {
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
		System.out.println("Option 2: Complete Task");
		System.out.println("Option 3: Log out and Exit");
		Scanner sc = new Scanner(System.in);
		int EmployeeIn = sc.nextInt();
		switch (EmployeeIn) {
		case 1:
			System.out.println("Enter your ID#.");
			int taskid = sc.nextInt();
			TaskService.getById(taskid);
			EmployeeMenu();

			break;
		case 2:
			System.out.println("Update Task to Complete");
			TaskService.update(null);
			EmployeeMenu();
			break;
		case 3:
			System.out.println("Logging out and returning to main menu. Have a great day!");
			EntryController.main(null);

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
		case 1:
			System.out.println("Store Inventory");
			System.out.println(BirdService.getAll());
			CustomerMenu();
			break;
		case 2: System.out.println("What is your customer ID?");
		int custid = sc.nextInt();
		System.out.println("What is the item's ID you are making an offer on?");
		int itemid = sc.nextInt();
		System.out.println("What is the amount you would like to offer?");
		float offeramount = sc.nextFloat();
		Offers o = new Offers(custid, itemid, offeramount);
		OfferService.submitoffer(o);
		System.out.println("Offer has been submitted and pending approval.");
		CustomerMenu();
			break;
		case 3: 
		
		
			break;
		case 4:
			System.out.println("Have a good day! Logging off.");
			
			EntryController.menuEntry();
		default:
			System.out.println("Not a valid option returning to menu.");
			LoginController.CustomerMenu();
			break;
		}

	}

	public static void ManagerMenu() {
		System.out.println("Manager Menu - Please select from one of the available options");
		System.out.println("Option 1: View Store Inventory");
		System.out.println("Option 2: Add to inventory");
		System.out.println("Option 3: Edit Item in Inventory");
		System.out.println("Option 4: Remove from Inventory");
		System.out.println("Option 5: View Current Offers");
		System.out.println("Option 6: Assign Tasks");
		System.out.println("Option 7: View Current Task");
		System.out.println("Option 8: Mark Task as Complete");
		System.out.println("Option 9: Add Employee");
		System.out.println("Option 10: Remove Employee");
		System.out.println("Option 11: Approve Offer");
		System.out.println("Option 12: Log out and Exit");
		Scanner manscan = new Scanner(System.in);
		try {
			int manoption = manscan.nextInt();
			switch (manoption) {
			case 1:
				System.out.println("Store Inventory");
				System.out.println(BirdService.getAll());

				ManagerMenu();
				break;
			case 2:
				System.out.println("What is the bird's Band ID?");
				int band = manscan.nextInt();
				System.out.println("What breed of bird is it?");
				String type = manscan.next();
				System.out.println("What's the bird's name?");
				String name = manscan.next();
				System.out.println("What is the price of the bird?");
				float price = manscan.nextFloat();

				Bird b = new Bird(band, type, name, price);
				BirdService.addBird(b);
				System.out.println(name + " has joined the flock!");
				ManagerMenu();
				break;
			case 3: 
				System.out.println("What is the bird's ID you'd like to change?");
				int editbird = manscan.nextInt();
				Bird updatebird = BirdService.getById(editbird);
				
				BirdService.editBird(updatebird);
				System.out.println("Bird has been updated!");
				ManagerMenu();
			

				break;
			case 4: System.out.println("What is the bird's ID you'd like to remove?");
			int removebird = manscan.nextInt();
			Bird rembird = BirdService.getById(removebird);
			BirdService.delete(rembird);
			System.out.println("Bird has been removed.");
			ManagerMenu();

				break;
			case 5: System.out.println(OfferService.getAll());
			ManagerMenu();
				break;
			case 6:
				System.out.println("What is the name of the Task?");
				String taskname = manscan.next();

				System.out.println("Which Employee ID is this assigned to?");
				int taskassignedto = manscan.nextInt();
				Task t = new Task(taskname, false, taskassignedto);
				TaskService.addTask(t);
				System.out.println("Task assigned.");
				ManagerMenu();
				break;
			case 7:
				System.out.println("Enter your ID#.");
				int taskid = manscan.nextInt();
				TaskService.getById(taskid);
				ManagerMenu();
				break;
			case 8:
				System.out.println("Update Task to Complete");
				TaskService.update(null);
				ManagerMenu();
				break;
			case 9:
				EmployeeMenu.menuEmployeeLanding();

				break;
			case 10:
				es.delete(principal);
				ManagerMenu();
				break;
			case 11: OfferService.update(null);
			ManagerMenu();
				break;
			case 12:
				System.out.println("Logging out and returning to main menu. Have a great day!");
				EntryController.main(null);
			default:
				System.out.println("Not a valid option returning to menu.");
				LoginController.ManagerMenu();
				break;

			}

		} finally {
			manscan.close();
		}

	}

	public static void SupervisorMenu() {
		System.out.println("Supervisor Menu - Please select from one of the available options");
		System.out.println("Option 1: View Tasks");
		System.out.println("Option 2: Assign Tasks");
		System.out.println("Option 3: Mark Task as Complete");
		System.out.println("Option 4: Logout and Exit");
		Scanner smscan = new Scanner(System.in);

		try {
			int smoption = smscan.nextInt();
			switch (smoption) {
			case 1:
				System.out.println("Enter your ID#.");
				int taskid = smscan.nextInt();
				TaskService.getById(taskid);
				SupervisorMenu();
				break;
			case 2:
				smscan.nextLine();
				System.out.println("What is the name of the Task?");
				String taskname = smscan.nextLine();

				System.out.println("Which Employee ID is this assigned to?");
				int taskassignedto = smscan.nextInt();
				Task t = new Task(taskname, false, taskassignedto);
				TaskService.addTask(t);
				System.out.println("Task assigned.");
				SupervisorMenu();
				break;
			case 3:
				System.out.println("Update Task to Complete");
				TaskService.update(null);
				SupervisorMenu();
				break;
			case 4:
				System.out.println("Logging out and returning to start menu. Have a great day!");
				EntryController.main(null);
				break;
			default:
				System.out.println("Not a valid option returning to menu.");
				LoginController.SupervisorMenu();
				break;
			}

		} finally {
			smscan.close();
		}

	}

	public static void OwnerMenu() {
		System.out.println("Owner Menu - Please select from one of the available options");
		System.out.println("Option 1: View Store Inventory");
		System.out.println("Option 2: Add to inventory");
		System.out.println("Option 3: Edit Item in Inventory");
		System.out.println("Option 4: Remove from Inventory");
		System.out.println("Option 5: View Current Offers");
		System.out.println("Option 6: Assign Employee Task");
		System.out.println("Option 7: Add Employee");
		System.out.println("Option 8: Edit Employee Name");
		System.out.println("Option 9: Remove Employee");
		System.out.println("Option 10: Sales History");
		System.out.println("Option 11: Approve Offer");
		System.out.println("Option 12: Exit and Logout");
		int oMenu = sc.nextInt();
		sc.nextLine();
		switch (oMenu) {
		case 1:
			System.out.println("Store Inventory");
			System.out.println(BirdService.getAll());
			OwnerMenu();
			break;
		case 2:
			Scanner addb = new Scanner(System.in);
			System.out.println("What is the bird's Band ID?");
			int band = addb.nextInt();
			System.out.println("What breed of bird is it?");
			String type = addb.next();
			System.out.println("What's the bird's name?");
			String name = addb.next();
			System.out.println("What is the price of the bird?");
			float price = addb.nextFloat();

			Bird b = new Bird(band, type, name, price);
			BirdService.addBird(b);
			System.out.println(name + " has joined the flock!");

			OwnerMenu();

			break;
		case 3: System.out.println("What is the bird's ID you'd like to change?");
		int editbird = sc.nextInt();
		Bird updatebird = BirdService.getById(editbird);
		
		BirdService.editBird(updatebird);
		System.out.println("Bird has been updated!");
		OwnerMenu();
			break;
		case 4: System.out.println("What is the bird's ID you'd like to remove?");
		int removebird = sc.nextInt();
		Bird rembird = BirdService.getById(removebird);
		BirdService.delete(rembird);
		System.out.println("Bird has been removed.");
			break;
		case 5: System.out.println(OfferService.getAll());
		OwnerMenu();
			break;
		case 6:
			sc.nextLine();
			System.out.println("What is the name of the Task?");
			String taskname = sc.nextLine();

			System.out.println("Which Employee ID is this assigned to?");
			int taskassignedto = sc.nextInt();
			Task t = new Task(taskname, false, taskassignedto);
			TaskService.addTask(t);
			System.out.println("Task assigned.");
			OwnerMenu();
			break;
		case 7:
			EmployeeMenu.menuEmployeeLanding();

			break;
		case 8:
			es.update(principal);
			OwnerMenu();
			break;
		case 9:
			es.delete(principal);
			OwnerMenu();
			break;
		case 10: //
			break;
		case 11: OfferService.update(null);
		OwnerMenu();
		
			break;
		case 12:
			System.out.println("Have a great day, boss!");

			EntryController.menuEntry();
			sc.close();
			break;

		default:
			System.out.println("Not a valid option returning to menu.");
			LoginController.OwnerMenu();
			break;
		}
	}

}