package com.oc.escalade.service;

import com.oc.escalade.entities.Utilisateur;

public interface UtilisateurService
{
	/**
	 * Inscription d'un nouvel utilisateur
	 * @param email String : le login qui doit être unique dans la base
	 * @param password String : le mot de passe qui sera chiffré
	 * @return Utilisateur : l'utilisateur créé
	 */
	public Utilisateur inscription(String email, String password); // F3
	/**
	 * Inscription d'un nouvel utilisateur
	 * @param email String : le login qui doit être unique dans la base
	 * @param password String : le mot de passe qui sera chiffré
	 * @param nom String : le nom de l'utilisateur
	 * @param prenom String : le prenom de l'utilisateur
	 * @return Utilisateur : l'utilisateur créé
	 */
	public Utilisateur inscription(String email, String password, String nom, String prenom); // F3
	/**
	 * Vérifie si un utilisateur existe dèjà en rechecherchant son email dans la base
	 * @param utilisateur Utilisateur : l'utilisateur à rechercher
	 * @return boolean : true si l'utilisateur existe false sinon
	 */
	public boolean exists(Utilisateur utilisateur);
}
