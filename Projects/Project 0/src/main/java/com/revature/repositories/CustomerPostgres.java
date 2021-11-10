package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.util.ConnectionUtil;

public class CustomerPostgres implements CustomerDao {

	@Override
	public Customer add(Customer t) {
		String sql = "insert into customers (c_name, c_username, c_password, c_email, c_isGiveawayEligible, c_role) "
				+ "values (?, ?, ?, ?, ?, ?) returning c_id;";

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getcName());
			ps.setString(2, t.getcUserName());
			ps.setString(3, t.getcPassword());
			ps.setString(4, t.getcEmail());
			ps.setBoolean(5, true);
			ps.setString(6, t.getRole().toString());

			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Customer getById(int id) {
		String sql = "select * from customer where c_id = ? ";
		Customer cust = null;

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int cId = rs.getInt("c_id");
				String cName = rs.getString("c_name");
				String cUsername = rs.getString("c_username");
				String cPassword = rs.getString("c_password");
				String cEmail = rs.getString("c_email");
				int cCard = rs.getInt("c_card");
				boolean isGiveawayEligible = rs.getBoolean("c_isgiveawayeligible");
				Role c_role = Role.valueOf(rs.getString("c_role"));

				
				cust = new Customer(cId, cName, cUsername, cPassword, cEmail, cCard, isGiveawayEligible, c_role);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public List<Customer> getAll() {
		String sql = "select * from customers;";
		List<Customer> customers = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int cId = rs.getInt("c_id");
				String cName = rs.getString("c_name");
				String cUsername = rs.getString("c_username");
				String cPassword = rs.getString("c_password");
				String cEmail = rs.getString("c_email");
				int cCard = rs.getInt("c_card");
				boolean isGiveawayEligible = rs.getBoolean("c_isgiveawayeligible");
				Role c_role = Role.valueOf(rs.getString("c_role"));
				
				

				Customer newCust = new Customer(cId, cName, cUsername, cPassword, cEmail, cCard, isGiveawayEligible, c_role);
				customers.add(newCust);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public boolean update(Customer t) {
		boolean result = false;
	    Scanner cscan = new Scanner(System.in);
		System.out.println("Please input updated customer name");
		String updatename = cscan.nextLine();
		System.out.println("Please input Customer's ID.");
		int upid = cscan.nextInt();

		String sql = "Select * from customers; Update customers set c_name=? where c_id=?;";
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
	public boolean deleteById(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

}
