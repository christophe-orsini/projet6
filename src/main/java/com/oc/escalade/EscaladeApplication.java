package com.oc.escalade;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.oc.escalade.entities.RoleEnum;
import com.oc.escalade.entities.Secteur;
import com.oc.escalade.entities.Site;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.entities.Voie;
import com.oc.escalade.repositories.SiteRepository;
import com.oc.escalade.service.SiteService;
import com.oc.escalade.service.UtilisateurService;

@SpringBootApplication
public class EscaladeApplication implements CommandLineRunner
{
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private SiteRepository siteRepository;
	
	public static void main(String[] args)
	{
		SpringApplication.run(EscaladeApplication.class, args);	
		
	}

	@Override
	public void run(String... args) throws Exception
	{
		// Utilisateur
		Utilisateur utilisateur = utilisateurService.inscription("email", "password", "Nom", "prenom", RoleEnum.MEMBRE);
		System.out.println(utilisateur.getEmail());
		
		utilisateur = utilisateurService.consulter("email");
		System.out.println(utilisateur.getEmail());
		System.out.println(utilisateur.getRole().value());
		
		// Site
		Site site = new Site("Un site", "Valence", "Drôme", "France", 44.5, 5.5);
		System.out.println(site.getNom());
		
		Site nouveauSite = siteService.publierSite(site, utilisateur.getId());
		System.out.println(nouveauSite.getNom());
		
		nouveauSite = siteService.consulterSite(1L);
		System.out.println(nouveauSite.getNom());
		
		siteService.taguer(1L);
		nouveauSite = siteService.consulterSite("Un site");
		System.out.println(nouveauSite.isTag() ? "Tagué" : "Non tagué");
		
		site = new Site("Un autre site", "Romans", "Drôme", "France", 44.7, 5.6);
		
		Voie voie = new Voie("Une voie", null);
				
		Secteur secteur = new Secteur("Un secteur", null);
		secteur.getVoies().add(voie);
		site.getSecteurs().add(secteur);
		
		secteur = new Secteur("Un deuxième", null);
		site.getSecteurs().add(secteur);
		
		site = siteService.publierSite(site, utilisateur.getId());
		System.out.println(site.getNom());
		
		int nb = siteRepository.countSecteursBySiteId(2L);
		System.out.println(nb);
		
		/*
		 * Collection<Site> sites = siteService.rechercherSites("site", null, null,
		 * null, null, 0, 0); for (Site site2 : sites) {
		 * System.out.println(site2.getNom()); if (site2.getSecteurs() != null) { for
		 * (Secteur secteur1 : site2.getSecteurs()) {
		 * System.out.println(secteur1.getNom()); } } }
		 */
	}
}
