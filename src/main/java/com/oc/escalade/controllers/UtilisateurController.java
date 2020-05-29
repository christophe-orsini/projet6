package com.oc.escalade.controllers;

import java.security.Principal;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.oc.escalade.entities.RoleEnum;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.service.UtilisateurService;
import com.oc.escalade.tools.EscaladeException;

@Controller
public class UtilisateurController
{
	private Collection<Utilisateur> utilisateurs;
	
	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping(value="/inscription")
	public String inscription(Model model)
	{
		model.addAttribute("utilisateur", new Utilisateur());
		return "utilisateur/creerUtilisateur";
	}		

	@PostMapping(value="/public/enregistrerUtilisateur")
	public String enregistrerUtilisateur(@ModelAttribute("utilisateur") @Valid Utilisateur utilisateur, 
			BindingResult bindingResult, Model model, Principal connectedUser)
	{
		String message = "";
		// controle taille password
		if (utilisateur != null && utilisateur.getPassword().length() < 4 || utilisateur.getPassword().length() > 8)
		{
			bindingResult.rejectValue("password", "error.password", "Le mot de passe doit avoir entre 4 et 8 caractères");
		}
		
		if (bindingResult.hasErrors())
		{
			return "utilisateur/creerUtilisateur";
		}
		
		// enregistrer le site
		try
		{
			Utilisateur nouveau = utilisateurService.inscription(utilisateur.getEmail(), utilisateur.getPassword(), 
					utilisateur.getNom(), utilisateur.getPrenom(), RoleEnum.ROLE_UTILISATEUR);
			
			model.addAttribute("login", nouveau.getEmail());
			
			return "utilisateur/messageInscription";
		}
		catch (EscaladeException e)
		{
			message += e.getMessage();
			model.addAttribute("exceptionMessage", message);
			
			return "utilisateur/creerUtilisateur";
		}
	}
	
	@GetMapping("/inscrit/listeUtilisateurs")
	public String listeUtilisateurs(Model model)
	{
		utilisateurs = utilisateurService.lister();
		model.addAttribute("utilisateurs",  utilisateurs);
		
		return "utilisateur/listeUtilisateurs";
	}
}
