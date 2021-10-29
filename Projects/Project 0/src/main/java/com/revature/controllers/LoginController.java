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
		
	}
	
	
	/*public static void EmployeeMenu() {
		
	}
	
	public static void ManagerMenu() {
		
	}
	
	public static void AdminMenu() {
		
	}
*/
	}