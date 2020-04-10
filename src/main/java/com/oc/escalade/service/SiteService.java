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
	 * Permet de retrouver une liste de sites en fonction de plusieurs citères
	 * @param nom String : Tous les sites comprenant nom dans le champ nom du site
	 * @param commune String : Tous les sites comprenant commune dans leurs champ commune
	 * @param departement String : Tous les sites dont le departement correspond à departement
	 * @param pays String : Tous les sites dont le pays correspond à pays
	 * * @param cotation String : Tous les sites ayant au moins une longueur de cotation cotation
	 * @param nombreSecteurs int : Tous les sites comprenant nombreSecteurs secteurs
	 * @param nombreVoie int : Tous les sites comprenant nombreVoie voies
	 * @return Collection<Site> : Une collection des sites trouvés
	 */
	public Collection<Site> rechercherSites(String nom, String commune, String departement, String pays, String cotation, 
			int nombreSecteurs, int nombreVoies); // F2
	/**
	 * Création d'un nouveau site par un utilisateur	
	 * @param site Site : Le site à créer
	 * @param auteurId Long : L'id de l'utilisateur créant le site
	 * @return Site : Le site nouvellement créé
	 */
	public Site publierSite(Site site, Long auteurId); // F4
	/**
	 * Permet de taguer un site comme Officiel
	 * @param id Long : L'id du site
	 */
	public Site taguer(Long id); // F6
}
