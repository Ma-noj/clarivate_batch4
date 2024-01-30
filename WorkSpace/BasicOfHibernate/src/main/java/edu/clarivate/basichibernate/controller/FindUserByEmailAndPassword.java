package edu.clarivate.basichibernate.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.clarivate.basichibernate.entity.User;

public class FindUserByEmailAndPassword {

	public static void main(String[] args) {
		String userEmail = "rohti@abc.in";
		String userPassword = "rohti@1234";

		User user = findUserByEmailAndPassword(userEmail, userPassword);
		if (user != null) {
			System.out.println("User Found");
			System.out.println(user);
		} else {
			System.out.println("User Not Found");
		}
	}

	public static User findUserByEmailAndPassword(String userEmail, String userPassword) {
		String jpqlQuery = "SELECT a FROM User a WHERE a.userEmail=?1  AND  a.userPassword=?2";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery(jpqlQuery);
		query.setParameter(1, userEmail);
		query.setParameter(2, userPassword);

		List listOfUser = query.getResultList();
		if (listOfUser != null && !(listOfUser.isEmpty())) {
			return (User) listOfUser.get(0);
		}

		return null;
	}

}
