package edu.clarivate.basichibernate.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.clarivate.basichibernate.entity.User;

public class DeleteUser {
	public static void main(String[] args) {
		int userId = 1002;
		boolean result = deleteById(userId);
		if (result) {
			System.out.println("User with the Give Id " + userId + " Removed");
		} else {
			System.out.println("User with the Give Id " + userId + " Not Found");
		}
	}

	public static boolean deleteById(int userId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User user = manager.find(User.class, userId);
		if (user != null) {
			transaction.begin();
			manager.remove(user);
			transaction.commit();
			return true;
		}
		return false;
	}
}
