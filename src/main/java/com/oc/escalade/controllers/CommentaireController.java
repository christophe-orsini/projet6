package com.oc.escalade.controllers;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.oc.escalade.entities.Commentaire;
import com.oc.escalade.service.CommentaireService;

@Controller
public class CommentaireController
{
	@Autowired private CommentaireService commentaireService;
	
	@GetMapping("/inscrit/commenterForm")
	public String commenterForm(Model model)
	{
		throw new NotYetImplementedException("Commenter un site");
	}
	
	@PostMapping("/inscrit/commenter")
	public String commenter(@ModelAttribute("topo") Commentaire commentaire, Model model)
	{
		throw new NotYetImplementedException("Modifier un commentaire");
	}
	
	@PostMapping("/membre/modifierCommentaire")
	public String modifierCommentaire(@ModelAttribute("topo") Commentaire commentaire, Model model)
	{
		throw new NotYetImplementedException("Modifier un commentaire");
	}
	
	@GetMapping("/membre/supprimerCommentaire/{id}")
	public String supprimerCommentaire(Model model, @PathVariable Long id)
	{
		throw new NotYetImplementedException("Supprimer un commentaire");
	}
}
