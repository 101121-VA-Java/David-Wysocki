package com.revature.controllers;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.services.AuthService;
import com.revature.services.ReimbursementService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ReimbursementController {
	  private static ReimbursementService rs = new ReimbursementService();
		private static AuthService as = new AuthService();

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
			String token = ctx.header("Authorization");

//			if(!as.checkPermission(token, "manager")) {
//				ctx.status(HttpCode.UNAUTHORIZED);
//				return;
//			}
			int id = Integer.parseInt(ctx.pathParam("id"));
			String str = ctx.body();
			int statusId = Integer.parseInt(str);
			Reimbursement r = rs.getAReimbursement(id);
			r.setStatus(statusId);
			String[] info = token.split(":"); 
			int resolver = Integer.parseInt(info[0]);
			r.setResolverId(resolver);
			if (rs.update(r) != false) ctx.status(HttpCode.OK);
			else ctx.status(400);
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
