package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public Employee add(Employee t) {
		int genId;
		
		
		
		String sql = "insert into employees (e_name, e_username, e_password, e_role, man_e_id) "
				+ "values (?, ?, ?, ?, ?) returning e_id;";

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
		
			ps.setString(1, t.getName());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getRole().toString());
			ps.setInt(5, t.getManager().getId());

			ResultSet rs = ps.executeQuery();

//			if (rs.next()) {
//				genId = rs.getInt("e_id");
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
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
				Role role = Role.valueOf(rs.getString("e_role"));

				int man_id = rs.getInt("man_e_id");

				Employee newEmp = new Employee(id, name, e_username, e_password, role, man_id);
				employees.add(newEmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;

	}

	@Override
	public boolean update(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public List<Employee> getAllEmployees() {
//		String sql = "select * from employees;";
//		List<Employee> employees = new ArrayList<>();
//
//		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);
//
//			while (rs.next()) {
//				int id = rs.getInt("e_id");
//				String name = rs.getString("e_name");
//				String e_username = rs.getString("e_username");
//				String e_password = rs.getString("e_password");
//				Role role = Role.valueOf(rs.getString("e_role"));
//
//				int man_id = rs.getInt("man_e_id");
//
//				Employee newEmp = new Employee(id, name, e_username, e_password, role, new Employee(man_id));
//				employees.add(newEmp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return employees;
//	}

//	@Override
//	public Employee getEmployeeById(int id) {
//		String sql = "select * from employees where e_id = ? ";
//		Employee emp = null;
//
//		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			ps.setInt(1, id); // 1 refers to the first '?'
//
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next()) {
//				int e_id = rs.getInt("e_id");
//				String name = rs.getString("e_name");
//				String e_username = rs.getString("e_username");
//				String e_password = rs.getString("e_password");
//				Role role = Role.valueOf(rs.getString("e_role"));
//				int man_id = rs.getInt("man_e_id");
//
//				emp = new Employee(e_id, name, e_username, e_password, role, new Employee(man_id));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return emp;
//	}

//	@Override
//	public int addEmployee(Employee e) {
//		int genId = -1;
//		String sql = "insert into employees (e_name, e_username, e_password, e_role, man_e_id) "
//				+ "values (?, ?, ?, ?, ?) returning e_id;";
//
//		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			ps.setString(1, e.getName());
//			ps.setString(2, e.getUsername());
//			ps.setString(3, e.getPassword());
//			ps.setString(4, e.getRole().toString());
//			ps.setInt(5, e.getManager().getId());
//
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next()) {
//				genId = rs.getInt("e_id");
//			}
//
//		} catch (SQLException z) {
//			// TODO Auto-generated catch block
//			z.printStackTrace();
//		}
//
//		return genId;
//	}

}