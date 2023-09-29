package com.alissw.regulatory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissw.regulatory.entities.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long>{

}
