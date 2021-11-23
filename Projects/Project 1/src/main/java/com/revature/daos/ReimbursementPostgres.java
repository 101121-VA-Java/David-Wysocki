package com.revature.daos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementPostgres implements ReimbursementDao {

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from "
		}
		return null;
	}

	@Override
	public Reimbursement getReimbursementById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement addReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement changeReimbursementStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
