package com.oc.escalade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.escalade.entities.Utilisateur;

@Repository
public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long>
{

}
