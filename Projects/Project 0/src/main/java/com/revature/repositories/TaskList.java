package com.revature.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Task;

public abstract class TaskList implements TaskDao {
	private List<Task> tasks;

	public TaskList() {
		tasks = new ArrayList<>();
		Task taskadmin = new Task("Stocking Shelves", LocalDate.now());

	}

//	@Override
//	public Task add(Task t) {
//		t.settId(tasks.size());
//		tasks.add(t);
//		return t;
	//}

//	@Override
//	public Task getByID(int id) {
//		for (Task t : tasks) {
//			if (t.gettId() == id) {
//				return t;
//			}
//		}
//		return null;

	//}

//	@Override
//	public List<Task> getAll() {
//		return tasks;
//	}

//	@Override
//	public boolean update(Task t) {
//	//	Task tempT = t.settId();
//		return false;
//	}

//	@Override
//	public Employee getById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
