package edu.clarivate.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

	public Employee findEmployeeByEmailAndPassword(String email, String password) {
		String jpqlQuery = "SELECT e FROM Employee e WHERE e.email=?1 AND e.password=?2";
		EntityManager manager = EMSUtill.getEntityManager();
		Query query = manager.createQuery(jpqlQuery);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List listOfuser = query.getResultList();
		if (listOfuser != null && !(listOfuser.isEmpty())) {
			return (Employee) listOfuser.get(0);
		}
		return null;
	}

	// Find All Employee has Role SE
	public List<Employee> findAllEmployeeAsSoftwareEng() {
		String jpqlQuery = "SELECT e FROM Employee e WHERE e.role=?1";
		EntityManager manager = EMSUtill.getEntityManager();
		Query query = manager.createQuery(jpqlQuery);
		query.setParameter(1, "SE");
		return query.getResultList();

	}
}
