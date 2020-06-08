package com.oc.escalade.services;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.oc.escalade.dao.CommentaireRepository;
import com.oc.escalade.dao.SiteRepository;
import com.oc.escalade.dao.UtilisateurRepository;
import com.oc.escalade.entities.Commentaire;
import com.oc.escalade.entities.Site;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.tools.EscaladeException;

@Service
public class CommentaireServiceImpl implements CommentaireService
{
	@Autowired private CommentaireRepository commentaireRepository;
	@Autowired private UtilisateurRepository utilisateurRepository;
	@Autowired private SiteRepository siteRepository;
	
	@Override
	@Transactional
	public Commentaire commenter(String commentaire, Long siteId, String auteurEmail) throws EscaladeException
	{
		// verification de l'existence de l'utilisateur
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailIgnoreCase(auteurEmail);
		if (!utilisateur.isPresent())
		{
			throw new EscaladeException("L'utilisateur " + auteurEmail + " n'existe pas");
		}
		
		// verification de l'existence du site
		Optional<Site> site = siteRepository.findById(siteId);
		if (!site.isPresent())
		{
			throw new EscaladeException("Le site avec l'Id " + siteId + " n'existe pas");
		}
		
		// création et MàJ du commentaire
		Commentaire commentaireLocal = commentaireRepository.save(new Commentaire(new Date(), commentaire, site.get(), utilisateur.get()));
		
		// MàJ de l'utilisateur
		utilisateur.get().getCommentaires().add(commentaireLocal);
		
		// MàJ du site
		site.get().getCommentaires().add(commentaireLocal);
		
		return commentaireLocal;
	}
	
	@Override
	@Transactional
	public Commentaire modifierCommentaire(Commentaire commentaire)  throws EscaladeException
	{
		// verification de l'existence de l'utilisateur
		Optional<Commentaire> ancienCommentaire = commentaireRepository.findById(commentaire.getId());
			
		if (!ancienCommentaire.isPresent())
		{
			throw new EscaladeException("Le commentaire n'existe pas");
		}
		
		// changement du commentaire
		ancienCommentaire.get().setContenu(commentaire.getContenu());
		ancienCommentaire.get().setDateModification(new Date());
		
		return commentaireRepository.save(ancienCommentaire.get());
	}

	@Override
	public Commentaire lireCommentaire(Long id) throws EscaladeException
	{
		Optional<Commentaire> commentaire = commentaireRepository.findById(id);
			
		if (!commentaire.isPresent())
		{
			throw new EscaladeException("Le commentaire avec l'id " + id + " n'existe pas");
		}
		return commentaire.get();
	}
	
	@Override
	public Collection<Commentaire> listeCommentaire(Long siteId)
	{
		Optional<Site> site = siteRepository.findById(siteId);
		return commentaireRepository.findAllBySiteOrderByDateModificationDesc(site.get());
	}

	@Override
	public Commentaire getCommentairePourSite(Long siteId) throws EscaladeException
	{
		Optional<Site> site = siteRepository.findById(siteId);
		if (!site.isPresent())
		{
			throw new EscaladeException("Le site avec l'Id " + siteId + " n'existe pas");
		}
		
		return new Commentaire(site.get());
	}

	public Commentaire supprimerCommentaire(Long id) throws EscaladeException
	{
		Optional<Commentaire> commentaire = commentaireRepository.findById(id);
		
		if (!commentaire.isPresent())
		{
			throw new EscaladeException("Le commentaire avec l'id " + id + " n'existe pas");
		}
		
		commentaireRepository.deleteById(id);
		
		return commentaire.get();
	}
}
