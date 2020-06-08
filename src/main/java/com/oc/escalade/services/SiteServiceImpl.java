package com.oc.escalade.services;

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
	public Site consulterSite(Long id) throws EscaladeException
	{
		Optional<Site> site = siteRepository.findById(id);
		
		// vérifier que le site existe
		if (!site.isPresent())
		{
			throw new EscaladeException("Site introuvable");
		}
		
		return site.get();
	}
	
	@Override
	public Collection<Site> rechercherSites(String nom, String commune, String departement, String pays, String cotation, 
			int nombreSecteurs, int nombreVoies, boolean tagged)
	{
		String searchedName = (nom != null && nom.equals("")) ? null: nom.toLowerCase();
		String searchedCity = (commune != null && commune.equals("")) ? null: commune.toLowerCase();
		String searchedDepartement = (departement != null && departement.equals("")) ? null: departement.toLowerCase();
		String searchedCountry = (pays != null && pays.equals("")) ? null: pays.toLowerCase();
		String searchedCotation = (cotation != null && cotation.equals("")) ? null: cotation.toLowerCase();
		
		String secteurs = nombreSecteurs > 0 ? String.valueOf(nombreSecteurs) : null;
		String voies = nombreVoies > 0 ? String.valueOf(nombreVoies) : null;
		
		String isTagged = tagged ? "Oui" : null;
		
		return siteRepository.findAllByElements(searchedName, searchedCity, searchedDepartement, searchedCountry,
				searchedCotation, secteurs, voies, isTagged);
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
	public Site modifierSite(Site site) throws EscaladeException
	{
		// verification de l'existence du site
		Optional<Site> findedSite = siteRepository.findById(site.getId());
			
		if (!findedSite.isPresent())
		{
			throw new EscaladeException("Le site  " + site.getNom() + " n'existe pas");
		}
		
		// mise à jour des champs
		findedSite.get().setNom(site.getNom());
		findedSite.get().setDescription(site.getDescription());
		findedSite.get().setCommune(site.getCommune());
		findedSite.get().setDepartement(site.getDepartement());
		findedSite.get().setPays(site.getPays());
		findedSite.get().setLatitude(site.getLatitude());
		findedSite.get().setLongitude(site.getLongitude());
		findedSite.get().setNbreSecteurs(site.getNbreSecteurs());
		findedSite.get().setNbreVoies(site.getNbreVoies());
		findedSite.get().setNbreLongueurs(site.getNbreLongueurs());
		findedSite.get().setNbreRelais(site.getNbreRelais());
		findedSite.get().setCotationMini(site.getCotationMini());
		findedSite.get().setCotationMaxi(site.getCotationMaxi());
		
		// sauvegarder et retourner le site
		return siteRepository.save(findedSite.get());
	}
	
	@Override
	@Transactional
	public Site taguer(Long id) throws EscaladeException
	{
		Optional<Site> site = siteRepository.findById(id);
			
		// vérifier que le site existe
		if (!site.isPresent())
		{
			throw new EscaladeException("Site introuvable");
		}
	
		site.get().setTag(!site.get().isTag());
		siteRepository.save(site.get());
		
		return site.get();
	}
}