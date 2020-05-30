package com.oc.escalade.controllers;

import java.security.Principal;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.oc.escalade.entities.Site;
import com.oc.escalade.service.SiteService;
import com.oc.escalade.tools.EscaladeException;

@Controller
public class SiteController
{
	@Autowired private SiteService siteService;

	
	@GetMapping("/public/listeSites")
	public String listerSites(Model model)
	{
		Collection<Site> sites = siteService.lister();
		model.addAttribute("sites",  sites);
		model.addAttribute("siteCherche", new Site());
		
		return "site/listeSites";
	}
	
	@GetMapping("/inscrit/listeSitesUtilisateur")
	public String listerSitesUtilisateur(Model model, Principal utilisateurConnecte)
	{	
		Collection<Site> sites = siteService.listerParUtilisateur(utilisateurConnecte.getName());
		model.addAttribute("sites",  sites);
		model.addAttribute("utilisateur", utilisateurConnecte.getName());
		model.addAttribute("siteCherche", new Site());
		
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
		
		model.addAttribute("site", site);
		
		return "site/detailSite";
	}
	
	@GetMapping(value="/inscrit/publierSite")
	public String publierSite(Model model)
	{
		model.addAttribute("site", new Site());
		return "site/creerSite";
	}
	
	@PostMapping(value="/inscrit/creerSite")
	public String creerSite(@ModelAttribute("site") @Valid Site site, BindingResult bindingResult, Model model,	Principal utilisateur)
	{
		if (bindingResult.hasErrors())
		{
			return "site/creerSite";
		}
		
		String message = "";
		// enregistrer le site
		try
		{
			site = siteService.publierSite(site, utilisateur.getName());
			
			model.addAttribute("message", "Le site a été créé avec succès");
			model.addAttribute("site", site);
			return "/site/detailSite";
		}
		catch (EscaladeException e)
		{
			message += e.getMessage();
			model.addAttribute("exceptionMessage", message);
			
			return "site/creerSite";
		}
	}
	
	@GetMapping(value="/inscrit/modifierSite/{id}")
	public String modifierSite(@ModelAttribute("site") Site site, Model model, @PathVariable Long id)
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
	
	@PostMapping(value="/inscrit/enregistrerSite")
	public String enregistrerSite(@ModelAttribute("site") @Valid Site site, BindingResult bindingResult, Model model,
			Principal utilisateur)
	{		
		String message = "";
		model.addAttribute("update", true);
		if (bindingResult.hasErrors())
		{	
			return "site/creerSite";
		}
		
		// enregistrer le site
		try
		{
			site = siteService.modifierSite(site);
			model.addAttribute("message", "Le site a été modifié avec succès");
			model.addAttribute("site", site);
			
			return "/site/detailSite";
		}
		catch (EscaladeException e)
		{
			message += e.getMessage();
			model.addAttribute("exceptionMessage", message);
			
			return "site/creerSite";
		}
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
	
	@PostMapping(value="/public/rechercheSite")
	public String rechercherSite(@ModelAttribute("siteCherche") @Valid Site siteCherche, BindingResult bindingResult, Model model,
			Principal utilisateur, @Param("cotation") String cotation)
	{
		Collection<Site> sites = siteService.rechercherSites(siteCherche.getNom(), siteCherche.getCommune(), siteCherche.getDepartement(),
				siteCherche.getPays(), cotation, siteCherche.getNbreSecteurs(), siteCherche.getNbreVoies(), siteCherche.isTag());
		
		model.addAttribute("sites",  sites);
		
		return "/site/listeSites";
	}
}
