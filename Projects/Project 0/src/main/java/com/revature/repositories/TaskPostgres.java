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
import com.revature.models.Task;
import com.revature.util.ConnectionUtil;

public class TaskPostgres implements TaskDao {

	@Override
	public Task add(Task t) {
		String sql = "insert into tasks (t_name, t_iscomplete, t_user)" + "values (?, ?, ?) returning t_id;";

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			
			ps.setString(1, t.getName());
			ps.setBoolean(2, t.isComplete());
			ps.setInt(3, t.gettUser());

			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Task getById(int id) { 
		String sql = "select * from employees, tasks where (e_id =? and e_id = t_user and t_iscomplete = false);";
		Task assignedtask = null;

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String tName = rs.getString("t_name");
				int tId = rs.getInt("t_id");
				boolean isComplete = rs.getBoolean("t_isComplete");
				int tUser = rs.getInt("t_user");

				assignedtask = new Task(tName, tId, isComplete, tUser);
				
				if  (assignedtask != null) {
					System.out.println(assignedtask);
				}
			}else { System.out.println("No assigned task.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assignedtask;
	}

	@Override
	public List<Task> getAll() {

		String sql = "select * from tasks;";
		List<Task> tasks = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				String tName = rs.getString("t_name");
				int tId = rs.getInt("t_id");
				boolean isComplete = rs.getBoolean("t_isComplete");
				int tUser = rs.getInt("t_user");
				

				Task newTask = new Task(tName, tId, isComplete, tUser);
				tasks.add(newTask);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public boolean update(Task t) {
		boolean result = false;
		Scanner tscan = new Scanner(System.in);
		System.out.println("Please input task ID");
		int taskupdate = tscan.nextInt();
		System.out.println("Is the task complete? (true/false)");
		boolean taskcomplete = tscan.nextBoolean();

		String sql = "Select * from tasks; Update tasks set t_iscomplete=? where t_id=?;";
		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(2, taskupdate);
			ps.setBoolean(1, taskcomplete);
			ps.execute();

			result = true;

		} catch (SQLException e) {
			
			e.printStackTrace();
			tscan.close();	
		}
		return result;
	}

	@Override
	public boolean deleteById(Task t) {
		// TODO Auto-generated method stub
		return false;
	}

}
