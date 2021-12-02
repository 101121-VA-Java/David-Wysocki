package com.revature.driver;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;

import io.javalin.Javalin;

public class Driver {

	private static org.apache.logging.log4j.Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		log.info("The Main Method has been called.");
		log.error("The Main Method has been called.");
		// Creating an instance of javalin and starting on port 8080
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();
			config.defaultContentType = "application/json";
		});
		app.start();

		/*
		 * Headers to tell the browser that the Authorization header that we're using
		 * for our "token" in the Response body is safe to use, otherwise the browser
		 * may not accept it
		 */
		app.before(ctx -> {
			ctx.header("Access-Control-Allow-Headers", "Authorization");
			ctx.header("Access-Control-Expose-Headers", "Authorization");
		});

		app.routes(() -> {
			// /employees
			path("user", () -> {
				get(UserController::getUsers);
				post(UserController::registerEmployee);

				// use brackets to indicate path param name
				// /employees/{id}
				path("{id}", () -> {
					get(UserController::getEmployeeById);
					put(UserController::updateEmployeeInfo);

				});
			});

			path("auth", () -> {
				post(AuthController::login);
			});
			path("reimbursement", () -> {
				get(ReimbursementController::get);
				post(ReimbursementController::add);
				path("{id}", () -> {

					put(ReimbursementController::update);

				});
				path("author", () -> {
					path("{id}", () -> {
						get(ReimbursementController::empGet);
					});

				});
				path("status", () -> {
					path("{id}", () -> {
						get(ReimbursementController::statusGet);

					});
				});
			});
		});

	}

}
