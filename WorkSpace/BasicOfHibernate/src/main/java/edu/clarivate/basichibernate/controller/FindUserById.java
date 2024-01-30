package edu.clarivate.basichibernate.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.clarivate.basichibernate.entity.User;

public class FindUserById {

	public static void main(String[] args) {
		int userId = 1001;
		User user = findUserById(userId);
		if (user != null) {
			System.out.println(user);
		} else {
			System.err.println("User with the given UserId " + userId + " Not Found");
		}
	}

	public static User findUserById(int userId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
		EntityManager manager = factory.createEntityManager();
		return manager.find(User.class, userId);
	}

}
