package com.oc.escalade.service;

import java.util.Collection;

import com.oc.escalade.entities.Site;

public interface SiteService
{
	/**
	 * Consulter un site correspondant à un Id
	 * @param id Long : L'id du site
	 * @return Site : Le site trouvé
	 */
	public Site consulterSite(Long id); // F1
	/**
	 * Consulter un site correspondant à un Nom
	 * @param nom String : Le nom du site
	 * @return Site : Le site trouvé
	 */
	public Site consulterSite(String nom); // F1
	public Collection<Site> rechercherSites(String champ, String valeur); // F2
	/**
	 * Création d'un nouveau site par un utilisateur	
	 * @param site Site : Le site à créer
	 * @param auteurId Long : L'id de l'utilisateur créant le site
	 * @return Site : Le site nouvellement créé
	 */
	public Site publierSite(Site site, Long auteurId); // F4
	public void taguer(Site site); // F6
}
