package edu.clarivate.onetomany_example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.clarivate.onetomany_example.entity.Mobile;
import edu.clarivate.onetomany_example.entity.Sim;

public class MobileDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
		return factory.createEntityManager();
	}

	public Mobile saveMobile(Mobile mobile) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		// Write Implemation to save Mobile Entity
		List<Sim> listOfSims = mobile.getSims();
		for (Sim sim : listOfSims) {
			manager.persist(sim);
		}
		manager.persist(mobile);
		transaction.commit();
		return mobile;
	}

	public Mobile findById(int id) {
		EntityManager manager = getEntityManager();
		return manager.find(Mobile.class, id);
	}
}
