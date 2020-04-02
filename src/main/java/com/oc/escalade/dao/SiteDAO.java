package com.oc.escalade.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.escalade.entities.Site;

@Repository
public interface SiteDAO extends JpaRepository<Site, Long>
{
	public Optional<Site> findByNom(String nom);
	
}
