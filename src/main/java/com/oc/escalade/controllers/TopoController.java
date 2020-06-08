package com.oc.escalade.controllers;

import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.oc.escalade.entities.Topo;
import com.oc.escalade.services.TopoService;
import com.oc.escalade.tools.EscaladeException;

@Controller
public class TopoController
{
	@Autowired private TopoService topoService;
	

	@GetMapping("/inscrit/listeTopos")
	public String listeTopos(Model model, Principal utilisateur)
	{
		model.addAttribute("utilisateur", utilisateur.getName());
		model.addAttribute("topos", topoService.listerTopos());
		return "/topo/listeTopos";
	}
	
	@GetMapping("/inscrit/listeTopos/{id}")
	public String listeToposParUtilisateur(Model model, @PathVariable Long id)
	{
		try
		{
			model.addAttribute("topos", topoService.listerToposDisponibles(id));
			return "/topo/listeTopos";
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
	}
	
	@GetMapping("/inscrit/listeToposUtilisateur")
	public String listeToposParPersonnel(Model model, Principal utilisateur)
	{
		try
		{
			model.addAttribute("topos", topoService.listerToposDisponibles(utilisateur.getName()));
			return "/topo/listeToposUtilisateur";
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
	}
	
	@GetMapping("/inscrit/listeToposEmprunt")
	public String listeToposEmprunt(Model model, Principal utilisateur)
	{
		try
		{
			model.addAttribute("topos", topoService.listerToposEmprunt(utilisateur.getName()));
			return "/topo/listeToposEmprunt";
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}	
	}
	
	@GetMapping("/inscrit/detailTopo/{id}")
	public String consulterTopo(Model model, @PathVariable Long id)
	{
		try
		{
			model.addAttribute("topo", topoService.consulterTopo(id));
			
			return "/topo/detailTopo";
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
	}
	
	@GetMapping("/inscrit/publierTopo")
	public String enregsitrerTopo(@ModelAttribute("topo") Topo topo, Model model, Principal utilisateur)
	{
		try
		{
			topo = topoService.getNewTopo(utilisateur.getName());
			model.addAttribute("topo", topo);
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
		
		return "/topo/creerTopo";
	}
	
	@PostMapping(value="/inscrit/creerTopo")
	public String creerTopo(@ModelAttribute("topo") @Valid Topo topo, BindingResult bindingResult, Model model,	Principal utilisateur)
	{
		if (bindingResult.hasErrors())
		{
			return "/topo/creerTopo";
		}
		
		String message = "";
		// enregistrer le site
		try
		{
			topo = topoService.publierTopo(topo, utilisateur.getName());
			model.addAttribute("topo", topo);
			model.addAttribute("message", "Le topos a été créé avec succès");
			return "/topo/detailTopo";
			//return "redirect:/";
		}
		catch (EscaladeException e)
		{
			message += e.getMessage();
			model.addAttribute("exceptionMessage", message);
			
			return "/topo/creerTopo";
		}
	}
	
	@GetMapping("/inscrit/reserverTopo/{id}")
	public String reserverTopo(Model model, @PathVariable Long id, Principal utilisateur)
	{
		try
		{
			topoService.demanderReservationTopo(id, utilisateur.getName());
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
		
		model.addAttribute("topos", topoService.listerTopos());
		return "/topo/listeTopos";
	}
	
	@GetMapping("/inscrit/accepterDemandeTopo/{id}")
	public String accepterReservationTopo(Model model, @PathVariable Long id, Principal utilisateur)
	{
		try
		{
			topoService.accepterReservationTopo(id);
			model.addAttribute("topos", topoService.listerToposDisponibles(utilisateur.getName()));
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
		
		return "/topo/listeToposUtilisateur";
	}
	
	@GetMapping("/inscrit/retourTopo/{id}")
	public String changerStatutTopo(Model model, @PathVariable Long id, Principal utilisateur)
	{
		try
		{
			topoService.retourTopo(id);
			model.addAttribute("topos", topoService.listerToposDisponibles(utilisateur.getName()));
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
		
		return "/topo/listeToposUtilisateur";
	}
}
