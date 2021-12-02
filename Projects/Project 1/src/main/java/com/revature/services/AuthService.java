package com.revature.services;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.DaoFactory;
import com.revature.daos.UserDao;
import com.revature.models.User;

public class AuthService {
	private UserDao ud;
	private static Logger log = LogManager.getRootLogger();
	// Retrieving an instance of EmployeeDao
	public AuthService() {
		ud = DaoFactory.getDAOFactory().getUserDao();
	}

	/**
	 * Service method to login an employee based on username/password
	 * @param String username, String password
	 * @return String token if credentials are valid, null otherwise
	 */
	// mimicking token behavior
	public String login(String username, String password) {
		
		String token = null;

		// retrieves a user based on username passed in
		User principal = ud.getEmployeeByUsername(username);

		if (principal != null && principal.getPassword().equals(password)) {
			/*
			 *  poor token implementation, for example's sake
			 *  	- based on this token, a user can be authenticated when making a request
			 *  	- user-id:role
			 */
			token = principal.getUserid() + ":" + principal.getRole();
		}
		log.trace("A login has occurred");
		return token;
	}
	
	/**
	 * Service method to check the permission of the user to access certain functionalities
	 * @param String token, Role... allowedRoles
	 * @return true if a user is authenticated and has permission, false otherwise
	 */
	public boolean checkPermission(String token, String role) {
		
		/*
		 * Behavior to identify user from token
		 */
		// this indicates that a user is not authenticated
		if(token == null) {
			return false;
		}
		
		String[] info = token.split(":"); 
		// retrieve user id
		int token_id = Integer.parseInt(info[0]);
		// retrieve user role
		String token_role = String.valueOf(info[1]);
		
		User principal = ud.getEmployeeById(token_id);
		
		if(principal != null && token_role.equals(principal.getRole()) 	// Authentication of user: make sure user is logged in
				&& Arrays.asList(role).contains(token_role)) {	// Authorization of user: make sure user has the permissions to use the functionality
			return true;
		}
		
		return false;
	}
}
