package com.oc.escalade.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oc.escalade.dao.UtilisateurRepository;
import com.oc.escalade.entities.RoleEnum;
import com.oc.escalade.entities.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService
{
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public Utilisateur inscription(String email, String password, String nom, String prenom, RoleEnum role)
	{
		// verifier si email existe
		if (utilisateurRepository.findByEmailIgnoreCase(email).isPresent())
		{
			throw new RuntimeException("L'utilisateur " + email + " existe déjà");
		}
		
		// TODO chiffrer le mot de passe
		
		// créer l'utilisateur
		Utilisateur utilisateur = new Utilisateur(email, password, nom, prenom, role);
		
		// sauvegarder et retourner l'utilisateur
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public Utilisateur consulter(String email)
	{
		Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByEmailIgnoreCase(email);
		// verifier si email existe
		if (!utilisateurOpt.isPresent())
		{
			throw new RuntimeException("L'utilisateur " + email + " n'existe pas");
		}
		
		return utilisateurOpt.get();		
	}
	
	@Override
	public Utilisateur consulter(Long id)
	{
		Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(id);
		// verifier si email existe
		if (!utilisateurOpt.isPresent())
		{
			throw new RuntimeException("L'utilisateur N° " + id + " n'existe pas");
		}
		
		return utilisateurOpt.get();		
	}
}
