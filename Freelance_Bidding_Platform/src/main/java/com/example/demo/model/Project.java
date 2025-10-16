package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Project {

	@Id @GeneratedValue
	private Long projectId;
	private Long clientId;
	private String title;
	private String description;
	private Double budget;
	private String skills;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.OPEN;
	public enum Status { OPEN, IN_PROGRESS, COMPLETED }
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Status getStatus() {
	    return status;
	}
	public void setStatus(Status status) {
	    this.status = status;
	}
	
}
