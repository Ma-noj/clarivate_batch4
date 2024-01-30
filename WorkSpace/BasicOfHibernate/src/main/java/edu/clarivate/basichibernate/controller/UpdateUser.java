package edu.clarivate.basichibernate.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.clarivate.basichibernate.entity.User;

public class UpdateUser {
	public static void main(String[] args) {
		int userId = 1002;
		String userPassword = "6753498";
		boolean result = updateUser(userId, userPassword);
		if (result) {
			User user = FindUserById.findUserById(userId);
			System.out.println("Updated USer Info ");
			System.out.println(user);
		} else {
			System.out.println("User with the Give Id " + userId + " Not Found");
		}
	}

	public static boolean updateUser(int userId, String userPassword) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User user = FindUserById.findUserById(userId);
		if (user != null) {
//			System.out.println("Before Updating User Password ");
//			System.out.println(user);
			user.setUserPassword(userPassword);
			transaction.begin();
			manager.merge(user);
			transaction.commit();
			return true;
		}
		return false;
	}
}
