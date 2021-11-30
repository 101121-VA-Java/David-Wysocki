package com.revature.daos;

public class DaoFactory {
	private static DaoFactory df;
	private UserDao ud;
	private ReimbursementDao rd;

	private DaoFactory() {
	}


	public static synchronized DaoFactory getDAOFactory() {
		if (df == null) {
			df = new DaoFactory();
		}
		return df;
	}
	
	public UserDao getUserDao() {
		if(ud == null) {
			ud = new UserPostgres();
		}
		return ud;
	}
	public ReimbursementDao getReimbursementDao() {
		if(rd == null) {
			rd = new ReimbursementPostgres();
		}
		return rd;
	}
}
