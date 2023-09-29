package com.alissw.regulatory.entities;

import java.time.Instant;
import java.util.Objects;

import com.alissw.regulatory.entities.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Registration")
public class Registry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant startDate;
	private Instant endDate;
	private Status status;
	
	public Registry() {
		// TODO Auto-generated constructor stub
	}

	public Registry(Long id, Instant startDate, Instant endDate, Status status) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
