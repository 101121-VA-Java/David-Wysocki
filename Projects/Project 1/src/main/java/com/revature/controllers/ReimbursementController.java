package com.revature.controllers;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.ReimbursementService;
import com.revature.daos.UserPostgres;
import org.apache.commons.mail.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.javalin.Javalin;
import static j2html.TagCreator.*;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ReimbursementController {
	  private static ReimbursementService rs = new ReimbursementService();
		private static AuthService as = new AuthService();
		private static UserPostgres up = new UserPostgres();
		private static Logger log = LogManager.getRootLogger();
	    public static void add(Context ctx) {
	    	System.out.println("We got this far");
	       Reimbursement r = rs.add(ctx.bodyAsClass(Reimbursement.class));
	       r.setStatus(1);
	       System.out.println(r);
			if (r.getStatus() != 1) ctx.status(HttpCode.BAD_REQUEST);
			else ctx.status(HttpCode.CREATED);
	    }

		public static void get(Context ctx) {
			System.out.println("Why am I being called??");
			List<Reimbursement> r = rs.getReimbursements();
			
			ctx.json(r);
			ctx.status(HttpCode.OK);
		}
		
		public static void empGet(Context ctx) {
			
			System.out.println("We're here in controller");
			int id = Integer.parseInt(ctx.pathParam("id"));
			System.out.println("We're here in controller");
			List<Reimbursement> r = rs.getReimbursementById(id);
			System.out.println(r);
			ctx.json(r);
			ctx.status(HttpCode.OK);
		}
		public static void statusGet(Context ctx) {
			
			System.out.println("Check 1");
			int id = Integer.parseInt(ctx.pathParam("id"));
			System.out.println("Check 2");
			List<Reimbursement> r = rs.getByStatus(id);
			System.out.println(r);
			ctx.json(r);
			ctx.status(HttpCode.OK);
		}
		public static void update(Context ctx) {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
	        email.setSmtpPort(465);
	        email.setAuthenticator(new DefaultAuthenticator("p1emailtest124@gmail.com", "Kevinisthebe$t"));
	        email.setSSLOnConnect(true);
	        try {
				email.setFrom("p1emailtest124@gmail.com");
				email.setSubject("Reimbursement Request Has Changed");
				email.setMsg("Your recent request for reimbursement has been changed. Please log in to see changes.");
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Approve requests email error!");
			}
			
			
			String token = ctx.header("Authorization");

//			if(!as.checkPermission(token, "manager")) {
//				ctx.status(HttpCode.UNAUTHORIZED);
//				return;
//			}
			int id = Integer.parseInt(ctx.pathParam("id")); 
			String str = ctx.body();
			int statusId = Integer.parseInt(str);
			Reimbursement r = rs.getAReimbursement(id);
			User u = up.getEmployeeById(r.getAuthorId());
			r.setStatus(statusId);
			String[] info = token.split(":"); 
			int resolver = Integer.parseInt(info[0]);
			r.setResolverId(resolver);
			if (rs.update(r) != false) ctx.status(HttpCode.OK);
			else ctx.status(400);
			System.out.println(id);
			
			 try {
				email.addTo(u.getEmail());
				email.send();
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("An Email based error has occurred.");
			}
	    }
public static void empReimbursement(Context ctx) {
			
			System.out.println("We're here in controller");
			int id = Integer.parseInt(ctx.pathParam("id"));
			int status = Integer.parseInt(ctx.pathParam("status"));
			System.out.println("???");
			List<Reimbursement> r = rs.getEmpReimByStatus(id, status);
			System.out.println(r);
			ctx.json(r);
			ctx.status(HttpCode.OK);
		}
}
