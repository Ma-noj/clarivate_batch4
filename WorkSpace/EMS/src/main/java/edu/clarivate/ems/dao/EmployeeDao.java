package edu.clarivate.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.clarivate.ems.entity.Employee;
import edu.clarivate.ems.util.EMSUtill;

public class EmployeeDao {

	public Employee saveEmployee(Employee employee) {
		EntityManager manager = EMSUtill.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(employee);
		transaction.commit();

		return employee;
	}
}
