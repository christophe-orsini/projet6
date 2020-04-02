package com.oc.escalade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.escalade.dao.UtilisateurDAO;
import com.oc.escalade.entities.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateurService
{
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	@Override
	public Utilisateur inscription(String email, String password) {
		// verifier si email existe
		if (utilisateurDAO.findByEmail(email).isPresent())
		{
			throw new RuntimeException("L'utilisateur " + email + " existe déjà");
		}
		
		Utilisateur utilisateur = new Utilisateur(email, password);
		utilisateur.setNom("");
		utilisateur.setPrenom("");
		
		return utilisateurDAO.save(utilisateur);
	}

	@Override
	public Utilisateur inscription(String email, String password, String nom, String prenom)
	{
		// verifier si email existe
		if (utilisateurDAO.findByEmail(email).isPresent())
		{
			throw new RuntimeException("L'utilisateur " + email + " existe déjà");
		}
		
		Utilisateur utilisateur = new Utilisateur(email, password);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		
		return utilisateurDAO.save(utilisateur);
	}

}
