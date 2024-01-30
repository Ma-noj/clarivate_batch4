package edu.clarivate.basichibernate.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.clarivate.basichibernate.entity.User;

public class FindAllUser {

	public static void main(String[] args) {
		List<User> listOfUser = findAllUser();
		for (User user : listOfUser) {
			System.out.println(user);
		}
	}

	public static List<User> findAllUser() {
		String sqlQuery = "SELECT u FROM User u";

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery(sqlQuery);
		return query.getResultList();
	}
}
