package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public Employee add(Employee t) {

		String sql = "insert into employees (e_name, e_username, e_password, e_role, man_e_id) "
				+ "values (?, ?, ?, ?, ?) returning e_id;";

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getName());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getRole().toString());
			ps.setInt(5, 1);

			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<Employee> getAll() {
		String sql = "select * from employees;";
		List<Employee> employees = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String e_username = rs.getString("e_username");
				String e_password = rs.getString("e_password");
				Role e_role = Role.valueOf(rs.getString("e_role"));
				int man_id = rs.getInt("man_e_id");

				Employee newEmp = new Employee(id, name, e_username, e_password, e_role, new Employee(man_id));
				employees.add(newEmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;

	}

	@Override
	public boolean update(Employee t) {
		boolean result = false;
		Scanner epscan = new Scanner(System.in);
		System.out.println("Please input updated employee name");
		String updatename = epscan.nextLine();
		System.out.println("Please input Employee's ID.");
		int upid = epscan.nextInt();

		String sql = "Select * from employees; Update employees set e_name=? where e_id=?;";
		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, updatename);
			ps.setInt(2, upid);
			ps.execute();

			result = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;

	}

	@Override
	public boolean deleteById(Employee t) {
		boolean result = false;
		boolean edContinue = false;
		int id;
		System.out.println("Enter ID of employee you would like to remove");
		String sql = "delete from employees where e_id = ?;";
		Scanner epscan = new Scanner(System.in);
		id = epscan.nextInt();
		System.out.println("Are you sure you want to delete id#" + id + "?");
		edContinue = epscan.nextBoolean();
		if (edContinue == true) {

			try (Connection con = ConnectionUtil.getConnectionFromEnv();) {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				result = true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Operation cancelled, returning to menu.");
		}
		return result;
	}

	@Override
	public Employee getById(int id) {
		String sql = "select * from employees where e_id = ? ";
		Employee emp = null;

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int e_id = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String e_username = rs.getString("e_username");
				String e_password = rs.getString("e_password");
				Role role = Role.valueOf(rs.getString("e_role"));
				int man_id = rs.getInt("man_e_id");

				emp = new Employee(e_id, name, e_username, e_password, role, new Employee(man_id));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

}