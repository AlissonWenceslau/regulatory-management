package com.alissw.regulatory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissw.regulatory.entities.Training;

public interface TrainingRepository extends JpaRepository<Training, Long>{

}
