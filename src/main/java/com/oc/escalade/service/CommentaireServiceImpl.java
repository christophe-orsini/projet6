package com.oc.escalade.service;

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

@Service
public class CommentaireServiceImpl implements CommentaireService
{
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private SiteRepository siteRepository;
	
	@Override
	@Transactional
	public Commentaire commenter(String commentaire, Long siteId, Long auteurId) {
		// verification de l'existence de l'utilisateur
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(auteurId);
		if (!utilisateur.isPresent())
		{
			throw new RuntimeException("L'utilisateur n'existe pas");
		}
		
		// verification de l'existence du site
		Optional<Site> site = siteRepository.findById(siteId);
		if (!site.isPresent())
		{
			throw new RuntimeException("Le site n'existe pas");
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
	public Commentaire modifierCommentaire(Long commentaireId, String texte) {
		// verification de l'existence de l'utilisateur
		Optional<Commentaire> commentaireLocal = commentaireRepository.findById(commentaireId);
			
		if (!commentaireLocal.isPresent())
		{
			throw new RuntimeException("Le commentaire n'existe pas");
		}
		
		// changement du commentaire
		commentaireLocal.get().setContenu(texte);
		commentaireLocal.get().setDateModification(new Date());
		
		return commentaireRepository.save(commentaireLocal.get());
	}

	@Override
	public Commentaire lireCommentaire(Long id)
	{
		/// verification de l'existence de l'utilisateur
		Optional<Commentaire> commentaire = commentaireRepository.findById(id);
			
		if (!commentaire.isPresent())
		{
			throw new RuntimeException("Le commentaire n'existe pas");
		}
		return commentaire.get();
	}
	
}
