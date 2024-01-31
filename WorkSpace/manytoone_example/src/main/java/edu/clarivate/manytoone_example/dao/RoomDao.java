package edu.clarivate.manytoone_example.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.clarivate.manytoone_example.entity.Room;

public class RoomDao {

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
		return factory.createEntityManager();
	}

	public Room saveRoom(Room room) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(room);
		transaction.commit();
		return room;
	}
}
