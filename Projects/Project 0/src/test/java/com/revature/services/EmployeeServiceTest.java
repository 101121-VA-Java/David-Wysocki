package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.EmployeeDao;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeDao ed;
	
	@InjectMocks
	private EmployeeService es;
	
	@Test
	public void addEmployeeTestValid() {
		Mockito.when(ed.add(new Employee("test","test","test",Role.BASIC_EMPLOYEE))).thenReturn(emp);
		
		Employee expected = new Employee("test","test","test",Role.BASIC_EMPLOYEE);
		Employee actual = es.addEmployee(new Employee("test","test","test",Role.BASIC_EMPLOYEE));
		assertEquals(expected, actual);
	}

}
