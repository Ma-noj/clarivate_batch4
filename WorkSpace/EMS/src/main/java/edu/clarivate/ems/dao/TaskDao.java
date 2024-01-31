package edu.clarivate.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.clarivate.ems.entity.Task;
import edu.clarivate.ems.util.EMSUtill;

public class TaskDao {

	public Task saveTask(Task task) {
		EntityManager manager = EMSUtill.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(task);
		transaction.commit();
		return task;
	}
}
