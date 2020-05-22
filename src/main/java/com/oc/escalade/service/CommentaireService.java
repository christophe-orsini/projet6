package com.oc.escalade.service;

import java.util.Collection;
import com.oc.escalade.entities.Commentaire;

public interface CommentaireService
{
	/**
	 * Laisser un commentaire sur un site
	 * @param commentaire String : Le texte du commentaire
	 * @param site Site : Les site à commenter
	 * @param auteur Utilisateur : L'auteur du commentaire
	 * @retrun Commentaire : Le commentaire nouvellement créé
	 */
	public Commentaire commenter(String commentaire, Long siteId, Long auteurId);
	
	/**
	 * Modifier un commentaire
	 * @param commentaire Commentaire : Le commentaire à modifier
	 * @rerurn Commentaire : Le commentaire modifié
	 */
	public Commentaire modifierCommentaire(Long commentaireId, String texte);
	/**
	 * Retourne un commentaire
	 * @param id Long : L'id du commentaire
	 * @return Commentaire : Le commentaire
	 */
	public Commentaire lireCommentaire(Long id);

	/**
	 * Retourne la lisyte des commentaires pour un site
	 * @param siteId Long : l'id du site
	 * @return
	 */
	public Collection<Commentaire> listeCommentaire(Long siteId);
	
}
