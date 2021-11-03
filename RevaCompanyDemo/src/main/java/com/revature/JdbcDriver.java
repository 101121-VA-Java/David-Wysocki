package com.revature;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeePostgres;
import com.revature.models.Employee;

public class JdbcDriver {

	public static void main(String[] args) {
		// jdbc:postgresql://[url]:5432/[database_name]"
		/*
		 * String url =
		 * "jdbc:postgresql://database-1.cllvqmegtmuc.us-east-1.rds.amazonaws.com:5432/postgres";
		 * String username = "postgres"; String password = "p4ssw0rd"; try (Connection
		 * con = DriverManager.getConnection( url, username, password);){
		 * System.out.println(con.getMetaData().getDriverName()); } catch (SQLException
		 * e) { e.printStackTrace(); }
		 */

		EmployeeDao ed = new EmployeePostgres();

		List<Employee> emps = ed.getEmployees();
		for (Employee e : emps) {
			System.out.println(e);
		}
		
		System.out.println("Get employeeById 4:" + ed.getEmployeeById(4));
		
		Employee newEmp = new Employee("TestName", "TestUsername", "TestPass", "TestRole", new Employee(4));
		
		System.out.println("Generated id was: " + ed.addEmployee(newEmp));
		
		System.out.println("Update test " + ed.updateEmployee(newEmp));
		
		//System.out.println("Removal Test " + ed.deleteEmployee(22) + " Employee not found."); //Manually enter test ID, make sure test is no longer in Database before running or will run into a duplicate entry error.
	}
		
}