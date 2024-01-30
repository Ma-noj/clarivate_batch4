package edu.clarivate.onetoone_example.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserController {

	public static void main(String[] args) {
		User user = new User();
		user.setUserId(1002);
		user.setUserName("Preethi");
		user.setUserEmail("Preethi@abc.in");
		user.setUserPassword("Preethi@1234");
		user.setUserPhoneNumber(8073434839l);

		Pan pan = new Pan();
		pan.setPanId(102);
		pan.setPanNumber("AHt87UYR");
		pan.setPanName("Preethi Rani");
		pan.setFatherName("Raju Kumar");

		user.setPan(pan);
		
		user = saveUser(user);
		System.out.println("User With Pan Info Saved!!");
	}

	public static User saveUser(User user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(user.getPan());
		manager.persist(user);
		transaction.commit();

		return user;
	}

}
