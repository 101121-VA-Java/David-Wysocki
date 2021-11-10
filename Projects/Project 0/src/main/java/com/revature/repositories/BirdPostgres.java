package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Bird;
import com.revature.models.Customer;
import com.revature.services.CustomerService;
import com.revature.util.ConnectionUtil;

public class BirdPostgres implements BirdDao {

	@Override
	public Bird add(Bird t) {
		String sql = "insert into birds (b_band, b_type, b_name, b_stock, b_price) "
				+ "values (?, ?, ?, ?, ?) returning b_id;";

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, t.getBandnum());
			ps.setString(2, t.getType());
			ps.setString(3, t.getName());
			ps.setBoolean(4, true);
			ps.setFloat(5, t.getPrice());

			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Bird getById(int id) {
		String sql = "select * from birds where b_id = ? ";
		Bird bird = null;

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int bid = rs.getInt("b_id");
				int bandnum = rs.getInt("b_band");
				String type = rs.getString("b_name");
				String name = rs.getString("b_name");
				boolean isinstock = rs.getBoolean("b_stock");
				Float price = rs.getFloat("b_price");
				

				bird = new Bird(bid, bandnum, type, name, isinstock, price);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bird;
		
	}

	@Override
	public List<Bird> getAll() {
		String sql = "select * from birds;";
		List<Bird> birds = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int bid = rs.getInt("b_id");
				int bandnum = rs.getInt("b_band");
				String type = rs.getString("b_type");
				String name = rs.getString("b_name");
				boolean isinstock = rs.getBoolean("b_stock");
				Float price = rs.getFloat("b_price");
				

				Bird newBird = new Bird(bid, bandnum, type, name, isinstock, price);
				birds.add(newBird);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return birds;
		
	}

	@Override
	public boolean update(Bird t) { 
		boolean result = false;
	    Scanner bscan = new Scanner(System.in);
		System.out.println("Please input updated bird name");
		String updatename = bscan.nextLine();
		int upid = t.getId();

		String sql = "Select * from birds; Update birds set b_name=? where b_id=?;";
		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, updatename);
			ps.setInt(2, upid);
			ps.execute();

			result = true;

		} catch (SQLException e) {

			e.printStackTrace();
			bscan.close();
		}
		return result;
		
	}

	@Override
	public boolean deleteById(Bird t) {
		boolean result = false;
		boolean brContinue = false;
		int id = t.getId();
		
		String sql = "delete from birds where b_id = ?;";
		Scanner brscan = new Scanner(System.in);
		
		System.out.println("Are you sure you want to delete id#" + id + "?");
		brContinue = brscan.nextBoolean();
		if (brContinue == true) {

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
	

}
