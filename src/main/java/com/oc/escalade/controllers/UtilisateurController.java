package com.oc.escalade.controllers;

import java.security.Principal;
import java.util.Collection;
import javax.validation.Valid;
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

	@RequestMapping(value="/inscription", method = {RequestMethod.GET, RequestMethod.POST})
	public String creerUtilisateur(@Valid Utilisateur utilisateur, BindingResult bindingResult, Model model,
			Principal connectedUser, @Param("submit") String submit)
	{
		if (submit == null) // premier appel (GET)
		{
			return "utilisateur/creerUtilisateur";
		}
		
		// traitement formulaire (POST)
		//check format email
		String email = utilisateur.getEmail().toLowerCase();
		String pattern = "^[a-z]+([a-z0-9])*@([a-z0-9])*\\.([a-z]){2,4}";
		if (!email.matches(pattern))
		{
			bindingResult.rejectValue("email", "email.format", "Le format de l'email n'est pas valide");
		}
		if (utilisateur.getPassword().length() < 4 || utilisateur.getPassword().length() > 8)
		{
			bindingResult.rejectValue("password", "password.size", "Le mot de passe de avoir entre 4 et 8 caractères");
		}
		
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
			return "utilisateur/creerUtilisateur";
		}
		else
		{
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
			}
		}
		
		// si erreurs
		model.addAttribute("exceptionMessage", message);
		
		return "utilisateur/creerUtilisateur";
	}

	@GetMapping("/inscrit/detailUtilisateur/{id}")
	public String consulterUtilisateur(Model model, @PathVariable Long id)
	{
		try
		{
			Utilisateur utilisateur = utilisateurService.consulter(id);
			
			model.addAttribute("utilisateur", utilisateur);
			return "utilisateur/detailUtilisateur";
		}
		catch (EscaladeException e)
		{
			model.addAttribute("exceptionMessage", e);
			return "/theme/error";
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
