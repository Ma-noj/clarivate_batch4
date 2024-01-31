package edu.clarivate.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.clarivate.ems.entity.Addres;
import edu.clarivate.ems.entity.Employee;
import edu.clarivate.ems.util.EMSUtill;

public class EmployeeDao {

	public Employee saveEmployee(Employee employee) {
		EntityManager manager = EMSUtill.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		// Checking address Object is present
		if (employee.getAddres() != null) {
			// get the Address Object
			Addres addres = employee.getAddres();
			AddresDao addresDao = new AddresDao();
			// Save Address
			addres = addresDao.saveAddres(addres);
			// Update employee Object with saved address object
			employee.setAddres(addres);
		}
		transaction.begin();
		manager.persist(employee);
		transaction.commit();

		return employee;
	}
}
