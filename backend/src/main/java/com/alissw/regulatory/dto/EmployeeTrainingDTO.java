package com.alissw.regulatory.dto;

import java.time.Instant;

import com.alissw.regulatory.entities.EmployeeTraining;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeTrainingDTO {

	private TrainingDTO training;
	private Instant startDate;
	private Instant endDate;
	private String status;
	
	public EmployeeTrainingDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeTrainingDTO(TrainingDTO training, Instant endDate, Instant startDate, String status) {
		super();
		this.training = training;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		
	}
	
	public EmployeeTrainingDTO(EmployeeTraining entity) {
		super();
		this.training = new TrainingDTO(entity.getTraining());
		this.startDate = entity.getStartDate();
		this.endDate = entity.getEndDate();
		this.status = entity.getStatus().getDescription();
	}

	public TrainingDTO getTraining() {
		return training;
	}
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	public Instant getStartDate() {
		return startDate;
	}
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	public Instant getEndDate() {
		return endDate;
	}

	public String getStatus() {
		return status;
	}
}
