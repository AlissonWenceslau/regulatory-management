package com.alissw.regulatory.entities;

import java.time.Instant;
import java.util.Objects;

import com.alissw.regulatory.entities.enums.Status;
import com.alissw.regulatory.entities.pk.EmployeeTrainingPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class EmployeeTraining {
	
	@EmbeddedId
	private EmployeeTrainingPK id = new EmployeeTrainingPK();
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant startDate;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant endDate;
	private Integer status;
	
	public EmployeeTraining() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeTraining(Employee employee, Training training, Instant startDate, Instant endDate, Status status) {
		super();
		id.setEmployee(employee);
		id.setTraining(training);
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status.getValue();
	}

	public void setEmployee(Employee employee) {
		id.setEmployee(employee);
	}
	
	public Employee getEmployee() {
		return id.getEmployee();
	}
	
	public void setTraining(Training training) {
		id.setTraining(training);
	}
	
	public Training getTraining() {
		return id.getTraining();
	}

	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public Instant getEndDate() {
		return endDate;
	}

	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}

	public Status getStatus() {
		return Status.toEnum(status);
	}

	public void setStatus(Status status) {
		this.status = status.getValue();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeTraining other = (EmployeeTraining) obj;
		return Objects.equals(id, other.id);
	}
}
