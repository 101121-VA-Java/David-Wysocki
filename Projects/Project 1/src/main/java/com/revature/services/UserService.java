package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.DaoFactory;
import com.revature.daos.UserDao;
import com.revature.models.User;

public class UserService {
	private UserDao ud;

	// Retrieving an instance of EmployeeDao
	public UserService() {
		ud = DaoFactory.getDAOFactory().getUserDao();
	}

	/**
	 * Service method to retrieve all employees, sets the employee passwords to null before returning them
	 * @return a List of Employees or an empty list if none are found
	 */
	public List<User> getEmployees(){
		/*
		 *  Java Streams, allows for quick processing of collections of objects (filter, map...)
		 *  	- here each Employee element of the employees List has their password set to null and are returned using the map method
		 *  	- the results are then collected back into a List
		 *  
		 *  for more information: https://www.baeldung.com/java-8-streams
		 */
		List<User> employees = ud.getUsers().stream()
				.map(e -> {
					e.setPassword(null); 
					return e;})
				.collect(Collectors.toList());
		
		return employees;
	}
	
	
	
	/**
	 * Service method to retrieve an employee by id, sets the employee password to null before returning
	 * @param id of the employee
	 * @return an employee or null if none is found
	 */
	public User getEmployeeById(int id){
		User u = ud.getEmployeeById(id);
		if (u != null) {
			u.setPassword(null);
		}
		
		return u;
	}
	
	/**
	 * Service method to retrieve an employee by its username, sets the employee password to null before returning
	 * @param username of the employee
	 * @return an employee or null if none is found
	 */
	public User getEmployeeByUsername(String username){
		User u = ud.getEmployeeByUsername(username);
		if (u != null) {
			u.setPassword(null);
		}
		
		return u;
	}
	
	/**
	 * Service method to create an employee, sets to a default manager and default role. The employee id assigned before returning it
	 * @param employee object, requires name, username, password 
	 * @return an employee with an id or null if none is created
	 */
	public User addEmployee(User u) {
		// assigning a default manager/role
		
		u.setRole("EMPLOYEE");

		return ud.addEmployee(u);
	}
	
	/**
	 * Service method to update an employee's info (ONLY username, password, and name) based on their id
	 * @param employee object, requires an id and valid field values
	 * @return true if an employee was updated, else false
	 */
	public boolean updateEmployeeInfo(User u) {
		
		User e_update = ud.getEmployeeById(u.getUserid());
		
		// if name isn't null or the same update the name to a new value
		if(u.getFirstname() != null && !u.getFirstname().equals(e_update.getFirstname())) {
			e_update.setFirstname(u.getFirstname());
		}
		if(u.getLastname() != null && !u.getLastname().equals(e_update.getLastname())) {
			e_update.setLastname(u.getLastname());
		}
		
		// if username isn't null or the same update the name to a new value
		if(u.getUsername() != null && !u.getUsername().equals(e_update.getUsername())) {
			e_update.setUsername(u.getUsername());
		}
		
		// if password isn't null or the same update the name to a new value
		if(u.getPassword() != null && !u.getPassword().equals(e_update.getPassword())) {
			e_update.setPassword(u.getPassword());
		}
		if(u.getEmail() != null && !u.getEmail().equals(e_update.getEmail())) {
			e_update.setEmail(u.getEmail());
		}
		return ud.updateEmployee(e_update);	
	}
	
	
}
