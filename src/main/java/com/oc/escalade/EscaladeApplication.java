package com.oc.escalade;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.oc.escalade.entities.Commentaire;
import com.oc.escalade.entities.RoleEnum;
import com.oc.escalade.entities.Site;
import com.oc.escalade.entities.Topo;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.service.CommentaireService;
import com.oc.escalade.service.SiteService;
import com.oc.escalade.service.TopoService;
import com.oc.escalade.service.UtilisateurService;

@SpringBootApplication
public class EscaladeApplication implements CommandLineRunner
{
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private CommentaireService commentaireService;
	@Autowired
	private TopoService topoService;
	
	public static void main(String[] args)
	{
		SpringApplication.run(EscaladeApplication.class, args);	
		
	}

	@Override
	public void run(String... args) throws Exception
	{
		Test();
	}
	
	private void Test()
	{
		// Utilisateur
		Utilisateur utilisateur = utilisateurService.inscription("email", "password", "Nom", "prenom", RoleEnum.MEMBRE);
		utilisateur = utilisateurService.inscription("moi", "password", "Moi", "surMoi", RoleEnum.ADMINISTRATEUR);
		
		// Site		
		Site site = siteService.publierSite(new Site("Site 1", "Un jolie site", "Valence", "Drôme", "France", 44.5, 5.5), utilisateur.getId());
				
		siteService.taguer(1L);
		
		site = new Site("Site 2", "Un autre jolie site", "Romans", "Drôme", "France", 44.7, 5.6);
		site.setNbreSecteurs(3);
		site.setNbreVoies(8);
		site.setNbreLongueurs(21);
		site.setNbreRelais(16);
		site.setCotationMini("3b");
		site.setCotationMaxi("9c");
		siteService.publierSite(site, utilisateur.getId());
		
		/*
		// Commentaire
		Commentaire commentaire = commentaireService.commenter("Voici un commentaire",  site.getId(), utilisateur.getId());
		System.out.println(commentaire.getContenu());
		
		Commentaire commentaire2 = commentaireService.lireCommentaire(1L);
		System.out.println(commentaire2.getAuteur().getEmail());
		
		commentaire = commentaireService.modifierCommentaire(1L, "Changement de commentaire");
		System.out.println(commentaire.getContenu());
		
		// Topo
		Topo topo = topoService.enregistrerTopo(new Topo("Le super Topo", "La région du sud", "Ce topo décrit un topo du sud"), 1L);
		System.out.println(topo.getDecription());
		*/
	}
}
