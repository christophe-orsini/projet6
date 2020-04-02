package com.oc.escalade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.escalade.dao.UtilisateurDAO;
import com.oc.escalade.entities.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService
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
		
		// verifier que l'email est conforme
		String pattern = "^[A-Za-z]+[A-Za-z0-9_\\-\\.]*@[A-Za-z0-9_\\-]*.[A-Za-z]{2,4}";
		if (!email.matches(pattern))
		{
			throw new RuntimeException("Le format de l'email n'est pas conforme");
		}
		
		// chiffrer le mot de passe
		
		// créer l'utilisateur
		Utilisateur utilisateur = new Utilisateur(email, password);
		utilisateur.setNom("");
		utilisateur.setPrenom("");
		
		// sauvegarder et retourner l'utilisateur
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
		
		// chiffrer le mot de passe
		
		// créer l'utilisateur
		Utilisateur utilisateur = new Utilisateur(email, password);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		
		// sauvegarder et retourner l'utilisateur
		return utilisateurDAO.save(utilisateur);
	}

	@Override
	public boolean exists(Utilisateur utilisateur)
	{
		if (utilisateurDAO.findByEmail(utilisateur.getEmail()).isPresent())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
