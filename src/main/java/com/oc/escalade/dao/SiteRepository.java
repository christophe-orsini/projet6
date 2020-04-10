package com.oc.escalade.dao;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.escalade.entities.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long>
{
	@Query("SELECT t FROM #{#entityName} t WHERE (:nom is null or nom LIKE %:nom%)"
			+ " AND (:commune is null or commune LIKE %:commune%)"
			+ " AND (:departement is null or departement LIKE %:departement%)"
			+ " AND (:pays is null or pays LIKE %:pays%)"
			+ " AND (:secteurs is null or nbreSecteurs = :secteurs)"
			+ " AND (:voies is null or nbreVoies = :voies)"
			+ " AND (:cotation is null or :cotation >= cotationMini)"
			+ " AND (:cotation is null or :cotation <= cotationMaxi)"
			+ " ORDER BY pays, departement, commune, nom")
	public Collection<Site> findAllByElements(@Param("nom") String nom, @Param("commune") String commune, @Param("departement") String departement,
			@Param("pays") String pays, @Param("cotation") String cotation, @Param("secteurs") String nombreSecteurs, @Param("voies") String nombreVoies);
}
