package edu.clarivate.basichibernate.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.clarivate.basichibernate.entity.User;

public class SaveUser {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		User user = readUserInfo(read);

		saveUser(user);
	}

	public static void saveUser(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		// Save User->helper method persist(Entity Object);
		// persist(Entity Object);-> is present in an Interface EntityManager
		// To create Object if EntityManager helper method createEntityManager();
		// createEntityManager() -> is present in the EntityManagerFactory Interface
		// To create EntityManagerFactory Object createEntityManagerFactory("Persistence
		// unit name")
		//createEntityManagerFactory("Persistence unit name")-> is Present in a class Persistence
		entityTransaction.commit();
	}

	private static User readUserInfo(Scanner read) {
		System.out.println("Enter the User id = ");
		int userId = read.nextInt();
		System.out.println("Enter the User Name = ");
		String userName = read.next();
		System.out.println("Enter the User Email = ");
		String userEmail = read.next();
		System.out.println("Enter the User Password = ");
		String userPassword = read.next();
		System.out.println("Enter the User Age = ");
		int userAge = read.nextInt();
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setUserPassword(userPassword);
		user.setAge(userAge);
		return user;
	}
}
