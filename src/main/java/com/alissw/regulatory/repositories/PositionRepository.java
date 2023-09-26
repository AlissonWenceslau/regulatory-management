package com.alissw.regulatory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissw.regulatory.entities.Position;

public interface PositionRepository extends JpaRepository<Position, Long>{

}
