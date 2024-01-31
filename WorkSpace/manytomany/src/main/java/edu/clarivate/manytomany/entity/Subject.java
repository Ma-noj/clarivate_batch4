package edu.clarivate.manytomany.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	private int id;
	private String name;
	private int numberOfClass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfClass() {
		return numberOfClass;
	}

	public void setNumberOfClass(int numberOfClass) {
		this.numberOfClass = numberOfClass;
	}

}
