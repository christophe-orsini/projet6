package com.oc.escalade.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oc.escalade.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>
{
	public Optional<Utilisateur> findByEmailIgnoreCase(String email);
}
