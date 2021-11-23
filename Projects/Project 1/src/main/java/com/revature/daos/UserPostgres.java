package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UserDao {

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id;";

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				User u = new User(rs.getInt("ers_users_id"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_email"), rs.getString("user_role"));

				users.add(u);
			}
		} catch (SQLException u) {
			u.printStackTrace();
		}

		return users;
	}

	@Override
	public User getEmployeeById(int id) {
		User user = null;

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id where ers_users_id =?;";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("ers_users_id"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_email"), rs.getString("user_role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getEmployeeByUsername(String username) {
		User user = null;

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id where ers_username=?;";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("ers_users_id"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_email"),
						rs.getString("user_role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User addEmployee(User u) {
	User newUser = null;
			
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email) values (?,?,?,?,?);"; //Check SQL statement before finishing this method.
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getEmail());
			

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				newUser = u;
				newUser.setUserid(rs.getInt("e_id"));
				newUser.setRole("user_role");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return newUser;
	}

	@Override
	public boolean updateEmployee(User e) {
		
	boolean result = false;
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "update ers_users set ers_username = ?, ers_password = ?, user_email = ?, user_first_name = ?, user_last_name = ?, user_role_id = ? WHERE ers_users_id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getUsername());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getFirstname());
            ps.setString(5, e.getLastname());
            ps.setString(6, e.getRole());
			ps.setInt(7, e.getUserid());
			 ps.executeUpdate();
			 result = true;
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} 
		return result;
	}


}
