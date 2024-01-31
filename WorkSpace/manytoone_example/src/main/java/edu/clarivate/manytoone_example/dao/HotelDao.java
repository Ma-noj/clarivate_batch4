package edu.clarivate.manytoone_example.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.clarivate.manytoone_example.entity.Hotel;

public class HotelDao {

	public Hotel saveHotel(Hotel hotel) {
		EntityManager manager = RoomDao.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(hotel);
		transaction.commit();

		return hotel;
	}
}
