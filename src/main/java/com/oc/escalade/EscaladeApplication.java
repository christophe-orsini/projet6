package com.oc.escalade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
	
	private void Test()
	{
		// Utilisateur
		Utilisateur utilisateur = utilisateurService.inscription("admin", "admin", "Administrateur", "", RoleEnum.ROLE_ADMINISTRATEUR);
		utilisateurService.inscription("member", "member", "Membre", "", RoleEnum.ROLE_MEMBRE);
		utilisateurService.inscription("user", "user", "Utilisateur", "Inscrit", RoleEnum.ROLE_UTILISATEUR);
				
		// Site
		for (int i = 1; i <20; i++)
		{
			String ville  = "Valence";
			String utilisateurEmail = utilisateur.getEmail();
			if (i % 2 == 0)
			{
				ville  = "Romans";
				utilisateurEmail = "user";
			}
			
			String nom = "Site " + i;
			Site site = new Site(nom, "Un jolie site", ville, "Drôme", "France", 44.5, 5.5);
			site.setNbreSecteurs(3);
			site.setNbreVoies(8);
			site.setNbreLongueurs(21);
			site.setNbreRelais(16);
			site.setCotationMini(i%3 + 3 + "b");
			site.setCotationMaxi(i%4 + 5 + "c");
			try
			{	
				siteService.publierSite(site, utilisateurEmail);
			}
			catch (EscaladeException e)
			{
				// TODO: handle exception
			}
			if (i % 3 == 0)
			{
				try
				{
					siteService.taguer(site.getId());
				}
				catch (EscaladeException e)
				{
					// TODO: handle exception
				}
			}
		}
		
		// Commentaire
		for (int i=1; i<20; i++)
		{
			String message = "Voici le commentaire N° " + i;
			try
			{
				commentaireService.commenter(message, 1L, utilisateur.getId());
			}
			catch (EscaladeException e)
			{
				// TODO: handle exception
			}
		}
		/*
		// Topo
		Topo topo = topoService.enregistrerTopo(new Topo("Le super Topo", "La région du sud", "Ce topo décrit un topo du sud"), 1L);
		System.out.println(topo.getDecription());
		*/
	}
}
