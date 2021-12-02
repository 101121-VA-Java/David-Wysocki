package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.DaoFactory;
import com.revature.daos.ReimbursementDao;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	
		private ReimbursementDao rd;

		public ReimbursementService() {
			rd = DaoFactory.getDAOFactory().getReimbursementDao();
		}
	    
	    public Reimbursement add(Reimbursement r) {
			return rd.addReimbursement(r);
	    }

		public List<Reimbursement> getReimbursements(){
			List<Reimbursement> rlist = rd.getReimbursements().stream().map(u -> {

				return u;
			}).collect(Collectors.toList());
			return rlist;
		}

	    public List<Reimbursement> getReimbursementById(int id) {
	        return rd.getReimbursementById(id);
		}

		public List<Reimbursement> getByStatus(int status){
			return rd.getReimbursementByStatus(status);
		}

		public boolean update(Reimbursement r) {
			return rd.changeReimbursementStatus(r);
		}
		public Reimbursement getAReimbursement(int id) {
			return rd.getAReimbursement(id);
		}
		public List<Reimbursement> getEmpReimByStatus(int id, int status){
			return rd.getEmpReimByStatus(id, status);
		}
}
