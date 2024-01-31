package edu.clarivate.ems.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String status;
	@CreationTimestamp
	private LocalDateTime createdDateTime;
	@UpdateTimestamp
	private LocalDateTime endedDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getEndedDateTime() {
		return endedDateTime;
	}

	public void setEndedDateTime(LocalDateTime endedDateTime) {
		this.endedDateTime = endedDateTime;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", status=" + status + ", createdDateTime="
				+ createdDateTime + ", endedDateTime=" + endedDateTime + "]";
	}

}
