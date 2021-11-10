package com.revature.services;

import java.util.List;

import com.revature.models.Bird;
import com.revature.repositories.BirdDao;
import com.revature.repositories.BirdPostgres;

public class BirdService {
	private static BirdDao bd = new BirdPostgres();

	public static Bird addBird(Bird b) {

		return bd.add(b);
	}

	public static List<Bird> getAll() {

		return bd.getAll();

	}
	public static boolean editBird(Bird b) {
		return bd.update(b);
	}
	public static Bird getById(int id) {
		return bd.getById(id);
	}
	public static boolean delete(Bird t) {
		return bd.deleteById(t);
	}

}
