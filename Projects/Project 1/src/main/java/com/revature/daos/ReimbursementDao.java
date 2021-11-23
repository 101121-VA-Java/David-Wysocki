package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {

		List<Reimbursement> getReimbursements();
		
		Reimbursement getReimbursementById();
		
		List<Reimbursement> getReimbursementByType();
		
		List<Reimbursement> getReimbursementByStatus();
		
		Reimbursement addReimbursement();
		
		Reimbursement changeReimbursementStatus();
		
		
}
