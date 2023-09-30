package com.alissw.regulatory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissw.regulatory.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
