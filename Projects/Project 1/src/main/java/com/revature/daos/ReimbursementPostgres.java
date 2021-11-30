package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementPostgres implements ReimbursementDao {

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from ers_reimbursement;"; //er inner join ers_reimbursement_status ers USING(reimb_status_id) inner join ers_reimbursement_type using(reimb_type_id) order by reimb_id;
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"),
						rs.getFloat("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"),
						rs.getInt("reimb_author"));
				reimbursements.add(r);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementById(int id) {
		List<Reimbursement> rlist = null;
		
		
		return rlist;
	}

	@Override
	public List<Reimbursement> getReimbursementByType(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(int status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement changeReimbursementStatus(Reimbursement r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getAReimbursement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
