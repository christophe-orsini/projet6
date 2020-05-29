package com.oc.escalade.controllers;

import java.security.Principal;
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
import com.oc.escalade.service.CommentaireService;
import com.oc.escalade.tools.EscaladeException;

@Controller
public class CommentaireController
{
	@Autowired private CommentaireService commentaireService;
	
	@GetMapping("/inscrit/commenter/{id}")
	public String commenter(@ModelAttribute("commentaire") Commentaire commentaire, Model model, @PathVariable Long id)
	{
		try
		{
			commentaire = commentaireService.getCommentairePourSite(id);
			model.addAttribute("commentaire", commentaire);
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
		
		return "/commentaire/creerCommentaire";
	}
	
	@PostMapping("/inscrit/creerCommentaire")
	public String creerCommentaire(@ModelAttribute("commentaire") @Valid Commentaire commentaire, BindingResult bindingResult,
			Model model, Principal utilisateur)
	{
		if (bindingResult.hasErrors())
		{
			return "/commentaire/creerCommentaire";
		}
		
		// enregistrer le commentaire
		String message = "";
		try
		{
			commentaireService.commenter(commentaire.getContenu(), commentaire.getSite().getId(), utilisateur.getName());
			return "redirect:/public/detailSite/" + commentaire.getSite().getId();
		}
		catch (EscaladeException e)
		{
			message += e.getMessage();
			model.addAttribute("exceptionMessage", message);
			
			return "/commentaire/creerCommentaire";
		}
	}
	
	@GetMapping("/membre/modifierCommentaire/{id}")
	public String modifierCommentaire(@ModelAttribute("commentaire") Commentaire commentaire, Model model, @PathVariable Long id)
	{
		try
		{
			commentaire = commentaireService.lireCommentaire(id);
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
		
		model.addAttribute("update", true);
		model.addAttribute("commentaire", commentaire);
		
		return "/commentaire/creerCommentaire";
	}
	
	@PostMapping("/inscrit/enregistrerCommentaire")
	public String enregistrerCommentaire(@ModelAttribute("commentaire") @Valid Commentaire commentaire, BindingResult bindingResult,
			Model model, Principal utilisateur)
	{
		model.addAttribute("update", true);
		if (bindingResult.hasErrors())
		{
			return "/commentaire/creerCommentaire";
		}
		
		// enregistrer le commentaire
		String message = "";
		try
		{
			commentaire = commentaireService.modifierCommentaire(commentaire);
			return "redirect:/public/detailSite/" + commentaire.getSite().getId();
		}
		catch (EscaladeException e)
		{
			message += e.getMessage();
			model.addAttribute("exceptionMessage", message);
			
			return "/commentaire/creerCommentaire";
		}
	}
	
	@GetMapping("/membre/supprimerCommentaire/{id}")
	public String supprimerCommentaire(Model model, @PathVariable Long id)
	{
		Commentaire commentaire;
		try
		{
			commentaire = commentaireService.supprimerCommentaire(id);
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
		}
		
		return "redirect:/public/detailSite/" + commentaire.getSite().getId();
	}
}
