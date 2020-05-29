package com.oc.escalade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import com.oc.escalade.entities.RoleEnum;
import com.oc.escalade.entities.Site;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.service.CommentaireService;
import com.oc.escalade.service.SiteService;
import com.oc.escalade.service.UtilisateurService;
import com.oc.escalade.tools.EscaladeException;

@SpringBootApplication
public class EscaladeApplication implements CommandLineRunner
{
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private CommentaireService commentaireService;
	/*
	@Autowired
	private TopoService topoService;
	*/
	public static void main(String[] args)
	{
		SpringApplication.run(EscaladeApplication.class, args);	
		
	}

	@Override
	public void run(String... args) throws Exception
	{
		//Test();
	}
	
	private void Test() throws EscaladeException
	{
		// Utilisateur
		Utilisateur utilisateur = utilisateurService.inscription("admin@escalade.fr", "admin", "Administrateur", "", RoleEnum.ROLE_ADMINISTRATEUR);
		utilisateurService.inscription("member@escalade.fr", "member", "Membre", "", RoleEnum.ROLE_MEMBRE);
		utilisateurService.inscription("user@escalade.fr", "user", "Utilisateur", "Inscrit", RoleEnum.ROLE_UTILISATEUR);
		
		// Site
		for (int i = 1; i <8; i++)
		{
			String ville  = "Valence";
			String utilisateurEmail = utilisateur.getEmail();
			if (i % 2 == 0)
			{
				ville  = "Romans";
				utilisateurEmail = "user@escalade.fr";
			}
			
			String nom = "Site " + i;
			Site site = new Site(nom, "Un jolie site", ville, "Drôme", "France", 44.5, 5.5);
			site.setNbreSecteurs(3);
			site.setNbreVoies(8);
			site.setNbreLongueurs(21);
			site.setNbreRelais(16);
			site.setCotationMini(i%3 + 3 + "b");
			site.setCotationMaxi(i%4 + 5 + "c");
			
			siteService.publierSite(site, utilisateurEmail);
			
			if (i % 3 == 0)
			{
				siteService.taguer(site.getId());
			}
		}
		
		// Commentaire
		for (int i=1; i<4; i++)
		{
			String message = "Voici le commentaire N° " + i;
			commentaireService.commenter(message, 1L, utilisateur.getEmail());
		}
		for (int i=1; i<3; i++)
		{
			String message = "Ceci est le commentaire N° " + i;
			commentaireService.commenter(message, 2L, "user@escalade.fr");
		}
		/*
		// Topo
		Topo topo = topoService.enregistrerTopo(new Topo("Le super Topo", "La région du sud", "Ce topo décrit un topo du sud"), 1L);
		System.out.println(topo.getDecription());
		*/
	}
}
