package com.revature.services;

import java.util.List;

import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeePostgres;
import com.revature.controllers.EntryController;
import com.revature.controllers.LoginController;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Employee;


public class EmployeeService {

	private static EmployeeDao ed = new EmployeePostgres();
	public static Employee addEmployee(Employee e) throws UsernameAlreadyExistsException {

		Employee newEmp = getEmployeeByUsername(e.getUsername());
		if (newEmp != null) {
			throw new UsernameAlreadyExistsException();
		}


		return ed.add(e);
	}

	 static Employee getEmployeeByUsername(String username) {
		
		List<Employee> employees = ed.getAll();
		for (Employee e : employees) {
			if (e.getUsername().equals(username)) {
				
				return e;
			} else { 
		}
		
	}
		return null;
	}
	public Employee login(String username, String password) throws LoginException {
		Employee emp = EmployeeService.getEmployeeByUsername(username);
		System.out.println("ID of User " + emp.getId());
		if(emp == null || !emp.getPassword().equals(password)) {
			throw new LoginException();
			
		}switch (emp.getRole()) {
		case ADMIN:
			LoginController.EmployeeMenu();
			break;
		case BASIC_EMPLOYEE:
			LoginController.EmployeeMenu();
			break;
		case CUSTOMER:
			LoginController.CustomerMenu();
			break;
		case MANAGER:
			LoginController.ManagerMenu();
			break;
		case OWNER:
			LoginController.OwnerMenu();
			break;
		case SUPERVISOR:
			LoginController.SupervisorMenu();
			break;
		default:
			System.out.println("Not recognized by system, returning to main menu");
			EntryController.menuEntry();
			break;
		
		}
			
		return emp;
	}

	public boolean update(Employee t) {
		return ed.update(t);
	}
	public boolean delete(Employee t) {
		return ed.deleteById(t);
	}
	
}
