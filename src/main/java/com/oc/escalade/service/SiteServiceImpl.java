package com.oc.escalade.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.oc.escalade.entities.Site;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.repositories.SiteRepository;
import com.oc.escalade.repositories.UtilisateurRepository;

@Service
public class SiteServiceImpl implements SiteService
{
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository; // Repository
	
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
	public Site consulterSite(String nom) {
		Optional<Site> site = siteRepository.findByNom(nom);
		
		// vérifier que le site existe
		if (!site.isPresent())
		{
			throw new RuntimeException("Site introuvable");
		}
		
		return site.get();
	}
	
	@Override
	public Collection<Site> rechercherSites(String champ, String valeur) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public Site publierSite(Site site, Long auteurId) {
		// verification de l'existence de l'utilisateur
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(auteurId);
			
		if (!utilisateur.isPresent())
		{
			throw new RuntimeException("L'utilisateur N° " + auteurId + " n'existe pas");
			
		}
		
		// enrgeistrer l'auteur
		site.setAuteur(utilisateur.get());
		
		// sauvegarder et retourner le site
		return siteRepository.save(site);
	}
	
	@Override
	@Transactional
	public void taguer(Site site) {
		// TODO Auto-generated method stub
		
	}
}
