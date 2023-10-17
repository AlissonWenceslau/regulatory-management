package com.alissw.regulatory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissw.regulatory.entities.Site;

public interface SiteRepository extends JpaRepository<Site, Long>{

}
