package com.oc.escalade.service;

import com.oc.escalade.entities.Utilisateur;

public interface IUtilisateurService
{
	public Utilisateur inscription(String email, String password); // F3
	public Utilisateur inscription(String email, String password, String nom, String prenom); // F3
}
