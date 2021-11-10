package com.revature.services;

import java.util.List;

import com.revature.controllers.EntryController;
import com.revature.controllers.LoginController;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerPostgres;

public class CustomerService {
	private static CustomerDao cd = new CustomerPostgres();

	public static Customer addCustomer(Customer c) throws UsernameAlreadyExistsException {

		Customer newCust = getCustomerByUsername(c.getcUserName());
		if (newCust != null) {
			throw new UsernameAlreadyExistsException();
		}

		return cd.add(c);
	}

	public static Customer getCustomerByUsername(String username) {
		List<Customer> customers = cd.getAll();
		for (Customer c : customers) {
			if (c.getcUserName().equals(username)) {
				return c;
			}
		}
		return null;
	}

	public Customer login(String username, String password) throws LoginException {
		Customer cust = CustomerService.getCustomerByUsername(username);
		System.out.println("Customer ID " + cust.getcId());
		if(cust == null || !cust.getcPassword().equals(password)) {
			throw new LoginException();
			
		}switch (cust.getRole()) {
		case CUSTOMER:
			LoginController.CustomerMenu();
			break;
		
		default:
			System.out.println("Not recognized by system, returning to main menu");
			EntryController.menuEntry();
			break;
		
		}
			
		return cust;
	}
	public static Customer getById(int id) {
		return cd.getById(id);
		
		
	}
}
