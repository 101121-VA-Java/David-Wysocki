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
	        rs.add(ctx.bodyAsClass(Reimbursement.class));																	// successful, or null otherwise
			if (rs.add(ctx.bodyAsClass(Reimbursement.class)) == null) ctx.status(HttpCode.BAD_REQUEST);
			else ctx.status(HttpCode.CREATED);
	    }

		public static void get(Context ctx) {
			List<Reimbursement> r = rs.getReimbursements();
			System.out.println(r);
			ctx.json(r);
			ctx.status(HttpCode.OK);
		}

		public static void update(Context ctx) {
			String token = ctx.header("Authorization");
			if(!as.checkPermission(token, "manager")) {
				ctx.status(HttpCode.UNAUTHORIZED);
				return;
			}
			int id = Integer.parseInt(ctx.pathParam("id"));
			String str = ctx.body();
			int statusId = Integer.parseInt(str);
			Reimbursement r = rs.getAReimbursement(id);
			r.setStatus(statusId);
			String[] info = token.split(":"); 
			int resolver = Integer.parseInt(info[0]);
			r.setResolverId(resolver);
			if (rs.update(r) != null) ctx.status(HttpCode.OK);
			else ctx.status(400);
	    }
}
