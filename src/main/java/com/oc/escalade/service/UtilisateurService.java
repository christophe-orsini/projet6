package com.oc.escalade.service;

import com.oc.escalade.entities.RoleEnum;
import com.oc.escalade.entities.Utilisateur;

public interface UtilisateurService
{
	/**
	 * Inscription d'un nouvel utilisateur
	 * @param email String : le login qui doit être unique dans la base
	 * @param password String : le mot de passe qui sera chiffré
	 * @param nom String : le nom de l'utilisateur
	 * @param prenom String : le prenom de l'utilisateur
	 * @param role RoleEnum : le role de l'utilisateur {@link RoleEnum}
	 * @return Utilisateur : l'utilisateur créé
	 */
	public Utilisateur inscription(String email, String password, String nom, String prenom, RoleEnum role); // F3
	
	/**
	 * Retourne un utilisateur existant
	 * @param email String : l'email de l'utilisateur
	 * @return Utilisateur :
	 */
	public Utilisateur consulter(String email);
}
