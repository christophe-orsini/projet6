package com.oc.escalade.service;

import com.oc.escalade.entities.Commentaire;
import com.oc.escalade.entities.Site;
import com.oc.escalade.entities.Utilisateur;

public interface CommentaireService
{
	/**
	 * Laisser un commentaire sur un site
	 * @param commentaire String : Le texte du commentaire
	 * @param site Site : Les site à commenter
	 * @param auteur Utilisateur : L'auteur du commentaire
	 * @retrun Commentaire : Le commentaire nouvellement créé
	 */
	public Commentaire commenter(String commentaire, Site site, Utilisateur auteur); // F5
	
	/**
	 * Modifier un commentaire
	 * @param commentaire Commentaire : Le commentaire à modifier
	 * @rerurn Commentaire : Le commentaire modifié
	 */
	public Commentaire modifierCommentaire(Commentaire commentaire); // F7
	/**
	 * Retourne un commentaire
	 * @param id Long : L'id du commentaire
	 * @return Commentaire : Le commentaire
	 */
	public Commentaire lireCommentaire(Long id);
	
}
