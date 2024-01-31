package edu.clarivate.manytomany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.clarivate.manytomany.entity.Student;

public class StudentDao {

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
		return factory.createEntityManager();
	}

	public Student saveStudent(Student student) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(student);
		transaction.commit();

		return student;
	}
}
