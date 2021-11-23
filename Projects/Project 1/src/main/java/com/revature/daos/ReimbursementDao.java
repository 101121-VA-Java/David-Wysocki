package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {

		List<Reimbursement> getReimbursements();
		
		List<Reimbursement> getReimbursementsByUser();
		
		List<Reimbursement> getReimbursementById(int id);
		
		List<Reimbursement> getReimbursementByType(int type);
		
		List<Reimbursement> getReimbursementByStatus(int status);
		
		Reimbursement addReimbursement(Reimbursement r);
		
		Reimbursement changeReimbursementStatus(Reimbursement r);
		
		Reimbursement getAReimbursement(int id);
}
