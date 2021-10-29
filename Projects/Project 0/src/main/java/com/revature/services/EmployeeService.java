package com.revature.services;

import java.util.List;

import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeeList;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Employee;
import com.revature.models.Role;

public class EmployeeService {

	private static EmployeeDao ed = new EmployeeList();
	
	public static Employee addEmployee(Employee e) throws UsernameAlreadyExistsException {

		Employee newEmp = getEmployeeByUsername(e.getUsername());
		if(newEmp != null) {
			throw new UsernameAlreadyExistsException();
		}
		e.setRole(Role.BASIC_EMPLOYEE);
		e.setManager(ed.getById(0));
 
		return ed.add(e);
	}
	
	public static Employee getEmployeeByUsername(String username){
		List<Employee> employees = ed.getAll();
		for(Employee e : employees) {
			if (e.getUsername().equals(username)) {
				return e;
			}
		}
		return null;
	}
	
	public Employee login(String username, String password) throws LoginException {
		Employee emp = EmployeeService.getEmployeeByUsername(username);
		if(emp == null || !emp.getPassword().equals(password)) {
			throw new LoginException();
		}// LoginController.employeeMenu(); Add role check and menu path diversion here.
		return emp;
	}
}
