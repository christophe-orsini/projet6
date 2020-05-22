package com.oc.escalade.controllers;

import java.security.Principal;
import java.util.Collection;
import javax.validation.Valid;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.oc.escalade.entities.Commentaire;
import com.oc.escalade.entities.Site;
import com.oc.escalade.service.CommentaireService;
import com.oc.escalade.service.SiteService;
import com.oc.escalade.tools.EscaladeException;

@Controller
public class SiteController
{
	@Autowired private SiteService siteService;
	@Autowired private CommentaireService commentaireService;
	
	@GetMapping("/public/listeSites")
	public String listerSites(Model model)
	{
		Collection<Site> sites = siteService.lister();
		model.addAttribute("sites",  sites);
		
		return "site/listeSites";
	}
	
	@GetMapping("/inscrit/listeSitesUtilisateur")
	public String listerSitesUtilisateur(Model model, Principal utilisateurConnecte)
	{	
		Collection<Site> sites = siteService.listerParUtilisateur(utilisateurConnecte.getName());
		model.addAttribute("sites",  sites);
		model.addAttribute("utilisateur", utilisateurConnecte.getName());
		return "site/listeSites";
	}
	
	@GetMapping("/public/detailSite/{id}")
	public String consulterSite(Model model, @PathVariable Long id)
	{	
		try
		{
			Site site = siteService.consulterSite(id);
			Collection<Commentaire> commentaires = commentaireService.listeCommentaire(id);
			
			model.addAttribute("site", site);
			model.addAttribute("commentaires",  commentaires);
		}
		catch (RuntimeException e)
		{
			model.addAttribute("exceptionMessage", e.getMessage());
		}
		
		return "site/detailSite";
	}
	
	@GetMapping("/public/rechercherSiteForm")
	public String rechercherSitesForm(Model model)
	{
		throw new NotYetImplementedException("Rechercher des sites");
	} 
	
	@GetMapping("/public/rechercherSite/{id}")
	public String rechercherSites(Model model, @PathVariable Long id)
	{
		throw new NotYetImplementedException("Rechercher des sites");
	} 
	
	@GetMapping("/inscrit/publierSite")
	public String publierSite(Model model)
	{
		return "site/creerSite";
	}
	
//	@PostMapping("/inscrit/creerSite")
//	public String creerSite(@ModelAttribute("site") Site site, Model model, Principal utilisateur)
	@PostMapping("/inscrit/creerSite")
	public String creerSite(@Valid Site site, BindingResult bindingResult, Model model, Principal utilisateur)
	{
		String message = "";
		boolean error = false;
				
		// verifier si le nom n'est pas null
		String nom = site.getNom();
		if (nom == null || nom.equals(""))
		{
			message += "Le nom est obligatoire <br />";
			error = true;
		}
		// verifier si la commune n'est pas nulle
		String commune = site.getCommune();
		if (commune == null || commune.equals(""))
		{
			message += "La commune est obligatoire <br />";
			error = true;
		}
		// verifier si le departement n'est pas null
		String departement = site.getDepartement();
		if (departement == null || commune.equals(""))
		{
			message += "Le departement est obligatoire <br />";
			error = true;
		}
		// verifier si la latitude n'est pas nulle
		double latitude = site.getLatitude();
		if (latitude == 0)
		{
			message += "La latitude est obligatoire <br />";
			error = true;
		}
		// verifier si la longitude n'est pas nulle
		double longitude = site.getLongitude();
		if (longitude == 0)
		{
			message += "La latitude est obligatoire <br />";
			error = true;
		}
		
		// enregistrer le site
		if (!error)
		{
			try
			{
				siteService.publierSite(site, utilisateur.getName());
				return "redirect:/";
			}
			catch (EscaladeException e)
			{
				message += e.getMessage();
			}
		}
		
		// si erreurs
		model.addAttribute("exceptionMessage", message);
		
		return "site/creerSite";
	}
	
	@GetMapping("/membre/taguerSite/{id}")
	public String taguerSite(Model model, @PathVariable Long id)
	{
		throw new NotYetImplementedException("Taguer un site");
	}
}
