package com.alissw.regulatory.dto;

import java.time.Instant;

import com.alissw.regulatory.entities.EmployeeTraining;

public class EmployeeTrainingDTO {

	private TrainingDTO training;
	private Instant endDate;
	private String status;
	
	public EmployeeTrainingDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeTrainingDTO(TrainingDTO training, Instant endDate, String status) {
		super();
		this.training = training;
		this.endDate = endDate;
		this.status = status;
	}
	
	public EmployeeTrainingDTO(EmployeeTraining entity) {
		super();
		this.training = new TrainingDTO(entity.getTraining());
		this.endDate = entity.getEndDate();
		this.status = entity.getStatus().getDescription();
	}

	public TrainingDTO getTraining() {
		return training;
	}

	public Instant getEndDate() {
		return endDate;
	}

	public String getStatus() {
		return status;
	}
}
