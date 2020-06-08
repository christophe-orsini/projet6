package com.oc.escalade.services;

import java.util.Collection;
import com.oc.escalade.entities.Commentaire;
import com.oc.escalade.tools.EscaladeException;

public interface CommentaireService
{
	/**
	 * Laisser un commentaire sur un site
	 * @param commentaire String : Le texte du commentaire
	 * @param site Long : L'id du site à commenter
	 * @param auteurEmail String : L'email de l'utilsateur connecté
	 * @retrun Commentaire : Le commentaire nouvellement créé
	 * @throws EscaladeException
	 */
	public Commentaire commenter(String commentaire, Long siteId, String auteurEmail) throws EscaladeException;
	
	/**
	 * Retourne un commentaire
	 * @param id Long : L'id du commentaire
	 * @return Commentaire : Le commentaire
	 * @throws EscaladeException
	 */
	public Commentaire lireCommentaire(Long id)  throws EscaladeException;
	
	/**
	 * Modifier un commentaire
	 * @param commentaire Commentaire : Le commentaire à modifier
	 * @rerurn Commentaire : Le commentaire modifié
	 * @throws EscaladeException
	 */
	public Commentaire modifierCommentaire(Commentaire commentaire) throws EscaladeException;

	/**
	 * Retourne la liste des commentaires pour un site
	 * @param siteId Long : l'id du site
	 * @return La liste des commentaires
	 */
	public Collection<Commentaire> listeCommentaire(Long siteId);
	
	/**
	 * Permet de retournet un commentaire vide avec le site renseigné
	 * @param siteId Long : L'id du site à commenter
	 * @return Commentaire : Un commentaire vide avec uniquement le champ site renseigné
	 * @throws EscaladeException
	 */
	public Commentaire getCommentairePourSite(Long siteId) throws EscaladeException;
	
	/**
	 * Supprimer un commentaire
	 * @param id Long : L'id du commentaire
	 * @return Commentaire : Le commentaire supprimé
	 * @throws EscaladeException
	 */
	public Commentaire supprimerCommentaire(Long id) throws EscaladeException;
}
