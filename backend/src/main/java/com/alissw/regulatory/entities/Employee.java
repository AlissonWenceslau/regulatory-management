package com.alissw.regulatory.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.alissw.regulatory.entities.enums.Shift;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "employee_id")
	private Long employeeId;
	private String firstName;
	private String lastName;
	private Long indentification;
	private Integer codeArea;
	private Long phone;
	private Integer shift;
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "site_id")
	private Site site;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	@OneToMany(mappedBy = "id.employee", cascade = CascadeType.ALL)
	private Set<EmployeeTraining> employees = new HashSet<>();
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long employeeId, String firstName, String lastName, Long indentification, Integer codeArea, Long phone, Shift shift, Department department, Site site) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.indentification = indentification;
		this.codeArea = codeArea;
		this.phone = phone;
		this.shift = shift.getValue();
		this.department = department;
		this.site = site;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeID(Long registration) {
		this.employeeId = registration;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getIndentification() {
		return indentification;
	}

	public void setIndentification(Long indentification) {
		this.indentification = indentification;
	}

	public Integer getCodeArea() {
		return codeArea;
	}

	public void setCodeArea(Integer codeArea) {
		this.codeArea = codeArea;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Shift getShift() {
		return Shift.toEnum(shift);
	}

	public void setShift(Shift shift) {
		this.shift = shift.getValue();
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Set<EmployeeTraining> getEmployees() {
		return employees;
	}

	public Set<Training> getTrainings(){
		Set<Training> list = new HashSet<>();
		employees.forEach(x -> list.add(x.getTraining()));
		return list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId);
	}
}
