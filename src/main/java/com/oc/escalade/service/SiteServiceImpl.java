package com.oc.escalade.service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.oc.escalade.dao.SiteRepository;
import com.oc.escalade.dao.UtilisateurRepository;
import com.oc.escalade.entities.Site;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.tools.EscaladeException;

@Service
public class SiteServiceImpl implements SiteService
{
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Site consulterSite(Long id) {
		Optional<Site> site = siteRepository.findById(id);
		
		// vérifier que le site existe
		if (!site.isPresent())
		{
			throw new RuntimeException("Site introuvable");
		}
		
		return site.get();
	}
	
	@Override
	public Collection<Site> rechercherSites(String nom, String commune, String departement, String pays, String cotation, int nombreSecteurs, int nombreVoies)
	{
		String secteurs = nombreSecteurs > 0 ? String.valueOf(nombreSecteurs) : null;
		String voies = nombreVoies > 0 ? String.valueOf(nombreVoies) : null;

		return siteRepository.findAllByElements(nom, commune, departement, pays, cotation, secteurs, voies);
	}
	
	@Override
	public Collection<Site> lister()
	{
		return siteRepository.findAll();
	}
	
	@Override
	public Collection<Site> listerParUtilisateur(String nom)
	{
		Utilisateur utilisateur = utilisateurRepository.findByEmailIgnoreCase(nom).get();
		return siteRepository.findAllByAuteur(utilisateur);
	}
	
	@Override
	@Transactional
	public Site publierSite(Site site, String auteur) throws EscaladeException
	{
		// verification de l'existence de l'utilisateur
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailIgnoreCase(auteur);
			
		if (!utilisateur.isPresent())
		{
			throw new EscaladeException("L'utilisateur " + auteur + " n'existe pas");
		}
		
		// enrgeistrer l'auteur
		site.setAuteur(utilisateur.get());
		
		site.setTag(false);
		site.setDatePublication(new Date());
		
		// sauvegarder et retourner le site
		return siteRepository.save(site);
	}
	
	@Override
	@Transactional
	public Site taguer(Long id)
	{
		Optional<Site> site = siteRepository.findById(id);
			
		// vérifier que le site existe
		if (!site.isPresent())
		{
			throw new RuntimeException("Site introuvable");
		}
	
		if (!site.get().isTag())
		{
			site.get().setTag(true);
			siteRepository.save(site.get());
		}
		
		return site.get();
	}
}