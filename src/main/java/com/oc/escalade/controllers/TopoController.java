package com.oc.escalade.controllers;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.oc.escalade.entities.Topo;
import com.oc.escalade.service.TopoService;

@Controller
public class TopoController
{
	@Autowired private TopoService topoService;
	
	@GetMapping("/inscrit/enregistrerTopoForm")
	public String enregistrerTopoForm(Model model)
	{
		throw new NotYetImplementedException("Enregistrer un topo");
	}
	
	@PostMapping("/inscrit/enregistrerTopo")
	public String enregsitrerTopo(@ModelAttribute("topo") Topo topo, Model model)
	{
		throw new NotYetImplementedException("Enregistrer un topo");
	}

	@GetMapping("/inscrit/consulterTopo/{id}")
	public String consulterTopo(Model model, @PathVariable Long id)
	{
		throw new NotYetImplementedException("Consulter un topo");
	}
	
	@GetMapping("/inscrit/reserverTopo/{id}")
	public String reserverTopo(Model model, @PathVariable Long id)
	{
		throw new NotYetImplementedException("Réserver un topo");
	}
	
	@GetMapping("/inscrit/accepterReservationTopo/{id}")
	public String accepterReservationTopo(Model model, @PathVariable Long id)
	{
		throw new NotYetImplementedException("Accepter la réservation d'un topo");
	}
	
	@GetMapping("/inscrit/changerStatutTopo/{id}")
	public String changerStatutTopo(Model model, @PathVariable Long id)
	{
		throw new NotYetImplementedException("Changer le statut sd'un topo");
	}
}
