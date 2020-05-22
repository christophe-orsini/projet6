package com.oc.escalade.controllers;

import java.security.Principal;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.oc.escalade.entities.Site;
import com.oc.escalade.service.SiteService;

@Controller
public class MainController
{
	private Collection<Site> sites;
	
	@Autowired private SiteService siteService;
	
	// page d'accueil 
	@GetMapping("/")
	public String index(Model model, Principal utilisateur)
	{
		sites = siteService.lister();
		model.addAttribute("sites",  sites);
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model)
	{	
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model)
	{
		sites = siteService.lister();
		model.addAttribute("sites",  sites);
		
		return "index";
	}
}
