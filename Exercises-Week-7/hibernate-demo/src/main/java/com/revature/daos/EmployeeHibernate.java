package com.revature.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeHibernate implements EmployeeDao{

	/**
	 * Adds an employee to the database
	 * @return the employee with the new id or null if no record is created
	 */
	@Override
	public Employee add(Employee e) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		s.save(e);
		tx.commit();
		s.close();
		return e;
	}

	/**
	 * Retrieves an employee by its id from the database
	 * @return the employee if found or null otherwise
	 */
	@Override
	public Employee getById(int id) {
		Employee e = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			e = s.get(Employee.class, id);
		}
		return e;
	}

	/**
	 * Retrieves an employee by its name from the database
	 * @return the employee if found or null otherwise
	 */
	@Override
	public Employee getByName(String name) {
		Employee e = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "from Employee where name = :name";
			TypedQuery<Employee> tq = s.createQuery(hql, Employee.class);
			tq.setParameter("name", name);
			e = tq.getSingleResult();
		}
		return e;
	}

	/**
	 * Retrieves all employees from the database
	 * @return a List of Employee objects
	 */
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			employees = s.createQuery("from Employee", Employee.class).list();
		}
		
		return employees;
	}

	/**
	 * Retrieves employees by department id from the database
	 * @return a List of Employee objects
	 */
	@Override
	public List<Employee> getEmployeesByDepartmentId(int deptId) {
		List<Employee> employees = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			Root<Employee> root = cq.from(Employee.class);
			Predicate predicateForDeptId = cb.equal(root.get("department"), deptId);
			cq.select(root).where(predicateForDeptId);
			employees = (List<Employee>) s.createQuery(cq).getResultList();
		}
		return employees;
	}

	/**
	 * Updates an employee
	 */
	@Override
	public void update(Employee e) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.update(e);
			tx.commit();
		}
		
	}
	
	/**
	 * Deletes an employee
	 */
	@Override
	public void delete(Employee e) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(e);
			tx.commit();
		}

		
	}
}
