package com.oc.escalade.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.oc.escalade.entities.Site;
import com.oc.escalade.service.SiteService;

@Controller
public class MainControleur
{
	@Autowired private SiteService siteService;
	
	private Collection<Site> sites;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index(Model model)
	{
		sites = siteService.listerSites();
		model.addAttribute("sites",  sites);
		
		return "index";
	}
}
