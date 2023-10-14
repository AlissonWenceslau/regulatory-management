package com.alissw.regulatory.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.alissw.regulatory.entities.Employee;
import com.alissw.regulatory.entities.Training;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EmployeeTrainingPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "training_id")
	private Training training;
	
	public EmployeeTrainingPK() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeTrainingPK(Employee employee, Training training) {
		super();
		this.employee = employee;
		this.training = training;
	}

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee, training);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeTrainingPK other = (EmployeeTrainingPK) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(training, other.training);
	}
}
