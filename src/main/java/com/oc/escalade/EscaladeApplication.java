package com.oc.escalade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.oc.escalade.entities.RoleEnum;
import com.oc.escalade.entities.Site;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.service.SiteService;
import com.oc.escalade.service.UtilisateurService;

@SpringBootApplication
public class EscaladeApplication implements CommandLineRunner
{
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private SiteService siteService;
	
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
		
	}
}
