package com.revature.services;


import com.revature.models.Task;
import com.revature.repositories.TaskDao;
import com.revature.repositories.TaskPostgres;

public class TaskService {
	private static TaskDao td = new TaskPostgres();

	public static Task getById(int t) {
		return td.getById(t);
	}
	
	public static boolean update(Task t) {
		return td.update(t);
	}

	public static Task addTask(Task t) {
		return td.add(t);
	}
	
}