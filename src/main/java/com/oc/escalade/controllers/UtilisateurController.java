package com.oc.escalade.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.oc.escalade.entities.RoleEnum;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.service.UtilisateurService;

@Controller
public class UtilisateurController
{
	private Collection<Utilisateur> utilisateurs;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping("/inscription")
	public String inscription(Model model)
	{
		return "utilisateur/creerUtilisateur";
	}

	@PostMapping("/public/creerUtilisateur")
	public String creerUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur, Model model)
	{
		String message = "";
		boolean error = false;
		
		//check format email
		String email = utilisateur.getEmail().toLowerCase();
		String pattern = "^[a-z]+([a-z0-9])*@([a-z0-9])*\\.([a-z]){2,4}";
		if (!email.matches(pattern))
		{
			message += "L'email n'est pas conforme<br />";
			error = true;
		}
		// check password
		String password = utilisateur.getPassword();
		if (password.length() < 4)
		{
			message += "Le mot de passe doit avoir au minimum 4 caratères<br />";
			error = true;
		}
		// check nom present
		String nom = utilisateur.getNom();
		if (nom == null || nom.trim().equals(""))
		{
			message += "Le nom est obligatoire <br />";
			error = true;
		}
		
		// enregistrer l'utilisateur
		if (!error)
		{
			try
			{
				utilisateurService.inscription(email, password, nom, utilisateur.getPrenom(), RoleEnum.ROLE_UTILISATEUR);
				return "redirect:/";
			}
			catch (RuntimeException e)
			{
				message += e.getMessage();
			}
		}
		
		// si erreurs
		model.addAttribute("exceptionMessage", message);
		// model.addAttribute("titre", "Inscription");
		// model.addAttribute("create", true);
		return "utilisateur/creerUtilisateur";
	}

	@GetMapping("/inscrit/detailUtilisateur/{id}")
	public String consulterUtilisateur(Model model, @PathVariable Long id) throws RuntimeException
	{
		try
		{
			Utilisateur utilisateur = utilisateurService.consulter(id);
			
			model.addAttribute("utilisateur", utilisateur);
		}
		catch (RuntimeException e)
		{
			model.addAttribute("exceptionMessage", e.getMessage());
		}
		
		return "utilisateur/detailUtilisateur";
	}
	
	@GetMapping("/inscrit/listeUtilisateurs")
	public String listeUtilisateurs(Model model)
	{
		utilisateurs = utilisateurService.lister();
		model.addAttribute("utilisateurs",  utilisateurs);
		
		return "utilisateur/listeUtilisateurs";
	}
}
