package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;

public interface GenericDao<T> {
T add (T t);

T getById(int id);
List<T> getAll();
boolean update(T t);
boolean deleteById(int id);
}
