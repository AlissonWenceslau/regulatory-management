package com.alissw.regulatory.entities;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
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

	public EmployeeTraining(Employee employee, Training training, Instant startDate, Instant endDate) {
		super();
		id.setEmployee(employee);
		id.setTraining(training);
		this.startDate = startDate;
		this.endDate = endDate;
		setStatus();
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

	private void setStatus() {		
		if(getDays()<0) {
			this.status = Status.DOWN.getValue();
		}else {
			this.status = Status.UP.getValue();
		}
	}

	public Long getDays() {
		return ChronoUnit.DAYS.between(Instant.now(), endDate);
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
