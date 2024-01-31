package edu.clarivate.manytomany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.clarivate.manytomany.entity.Subject;

public class SubjectDao {

	public Subject saveSubject(Subject subject) {
		EntityManager manager = StudentDao.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(subject);
		transaction.commit();
		return subject;
	}
}
