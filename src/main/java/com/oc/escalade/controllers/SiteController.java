package com.oc.escalade.controllers;

import java.security.Principal;
import java.util.Collection;
import javax.validation.Valid;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		Site site;
		try
		{
			 site = siteService.consulterSite(id);
			
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
		
		Collection<Commentaire> commentaires = commentaireService.listeCommentaire(id);
		
		model.addAttribute("site", site);
		model.addAttribute("commentaires",  commentaires);
		
		return "site/detailSite";
	}
	
	@RequestMapping(value="/inscrit/creerSite", method = {RequestMethod.GET, RequestMethod.POST})
	public String creerSite(@Valid Site site, BindingResult bindingResult, Model model,	Principal utilisateur, @Param("submit") String submit)
	{
		if (submit == null) // premier appel (GET)
		{
			return "site/creerSite";
		}
		
		// traitement formulaire (POST)
		String message = "";
		if (bindingResult.hasErrors())
		{
			for (ObjectError error : bindingResult.getAllErrors())
			{
				if (error.getDefaultMessage() != null)
				{
					message += error.getDefaultMessage() + "<br />";
				}
			}
			model.addAttribute("exceptionMessage", message);
			return "site/creerSite";
		}
		else
		{
			// enregistrer le site
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
	
	@RequestMapping(value="/inscrit/modifierSite/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifierSite(@Valid Site site, BindingResult bindingResult, Model model,	Principal utilisateur,
			@PathVariable Long id, @Param("submit") String submit)
	{
		if (submit == null) // premier appel (GET)
		{
			try
			{
				site = siteService.consulterSite(id);
			}
			catch (EscaladeException e)
			{
				model.addAttribute("exceptionMessage", e);
				return "/theme/error";
			}
			
			model.addAttribute("site", site);
			model.addAttribute("update", true);
			
			return "site/creerSite";
		}
		
		// traitement formulaire (POST)
		String message = "";
		if (bindingResult.hasErrors())
		{
			for (ObjectError error : bindingResult.getAllErrors())
			{
				if (error.getDefaultMessage() != null)
				{
					message += error.getDefaultMessage() + "<br />";
				}
			}
			model.addAttribute("exceptionMessage", message);
			return "site/creerSite";
		}
		else
		{
			// enregistrer le site
			try
			{
				siteService.modifierSite(site);
				return "redirect:/public/listeSites";
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
		Site site = null;
		try
		{
			site = siteService.taguer(id);
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
		
		model.addAttribute("site", site);
		
		return "redirect:/public/detailSite/" + id;
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
}
