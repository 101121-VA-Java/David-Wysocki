package com.revature.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeeList;
import com.revature.repositories.EmployeePostgres;

public class EmployeeDaoTest {
	
	private EmployeeDao ed = new EmployeePostgres();
	
	
	@BeforeEach
	public void setUp() {
		ed = new EmployeeList();
	}

	
	@Test
	public void getAll() {
		List<Employee> expected = new ArrayList<>();
		expected.add(new Employee(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Role.ADMIN, null));
		expected.add(new Employee(1, "David", "Chibby", "acreativepassword", Role.OWNER, null));
		expected.add(new Employee(2, "Morgana", "Moogie", "bosslady", Role.MANAGER, null));
		expected.add(new Employee(3, "Jamey", "jshitliff2", "TI8WmGhx7O", Role.MANAGER, null));
		assertEquals(expected, ed.getAllEmployees());
	}
	
//	@Test
//	public void getEmployeeByIdExist() {
//		Employee expected = new Employee(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Role.ADMIN, null);
//		
//		assertEquals(expected, ed.getById(0));
//	}
//	
//	@Test
//	public void getEmployeeByIdDoesNotExist() {
//		assertEquals(null, ed.getById(10));
//	}
//	
//	@Test
//	public void addEmployee() {
//		List<Employee> expected = new ArrayList<>();
//		expected.add(new Employee(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Role.ADMIN, null));
//		expected.add(new Employee(1, "Test User", "Test User", "TestPass", Role.BASIC_EMPLOYEE, new Employee(0)));
//		
//		ed.add(new Employee(0, "Test User", "Test User", "TestPass", Role.BASIC_EMPLOYEE, new Employee(0)));
//		assertEquals(expected, ed.getAll());
//	}
//	
//	@Test
//	public void updateEmployeeValid() {
//		Employee expected = new Employee(0, "Test", "Enrollment Admin", "AdminPass", Role.ADMIN, null);
//		Employee sut = new Employee(0, "Test", "Enrollment Admin", "AdminPass", Role.ADMIN, null);
//		
//		ed.update(sut);
//		
//		assertEquals(expected, ed.getById(0));
//	}
//	
//	@Test
//	public void updateEmployeeInvalidId() {;
//		Employee sut = new Employee(10, "Test", "Enrollment Admin", "AdminPass", Role.ADMIN, null);
//		
//		
//		assertFalse(ed.update(sut));
//	}
//	
//	@Test
//	public void updateEmployeeNoChange() {;
//		Employee sut = new Employee(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Role.ADMIN, null);
//		
//		
//		assertFalse(ed.update(sut));
//	}
}