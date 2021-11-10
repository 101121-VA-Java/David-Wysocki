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
import com.revature.models.Offers;
import com.revature.models.Role;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements OfferDao{

	@Override
	public Offers add(Offers t) {
		String sql = "insert into offers (c_id, i_id, o_amount)"
				+ "values (?, ?, ?) returning o_id;";

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, t.getCustId());
			ps.setInt(2, t.getItemId());
			ps.setFloat(3, t.getOfferAmount());
			

			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		
	}

	@Override
	public Offers getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offers> getAll() {
		String sql = "select * from offers;";
		List<Offers> offers = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int offerId = rs.getInt("o_id");
				int custId = rs.getInt("c_id");
				int itemId = rs.getInt("i_id");
				float offerAmount = rs.getFloat("o_amount");
				boolean isAccepted = rs.getBoolean("isaccepted");
				

			Offers newOffer = new Offers(offerId,custId,itemId,offerAmount,isAccepted);
			offers.add(newOffer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}


		public boolean update(Offers t) {
			boolean result = false;
			Scanner offscan = new Scanner(System.in);
			System.out.println("What is the offer ID to accept?");
			int offerid = offscan.nextInt();
			System.out.println("What is the item ID in offer?");
			int itemid = offscan.nextInt();
			System.out.println("Processing approval and removing related unapproved offers");

			String sql = "Select * from offers; Update offers set isaccepted=? where o_id=?;";
			try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setBoolean(1, true);
				ps.setInt(2, offerid);
				ps.execute();

				result = true;
				String sql2 = "delete from offers where i_id =? and isaccepted = false";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, itemid);
				ps2.execute();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return result;


		
	}

	@Override
	public boolean deleteById(Offers t) {
		// TODO Auto-generated method stub
		return false;
	}

}
