package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface GenericDao<T> {
T add (T t);
T getByID(int id);
List<T> getAll();
boolean update(T t);
Employee getById(int id);
}
