package edu.clarivate.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.clarivate.ems.entity.Addres;
import edu.clarivate.ems.util.EMSUtill;

public class AddresDao {

	public Addres saveAddres(Addres addres) {
		EntityManager manager = EMSUtill.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(addres);
		transaction.commit();
		return addres;

	}
}
