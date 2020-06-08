package com.oc.escalade.services;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oc.escalade.dao.TopoRepository;
import com.oc.escalade.dao.UtilisateurRepository;
import com.oc.escalade.entities.Topo;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.tools.EscaladeException;

@Service
public class TopoServiceImpl implements TopoService
{
	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Topo publierTopo(Topo topo, String proprietaire) throws EscaladeException
	{
		// verification de l'existence de l'utilisateur
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailIgnoreCase(proprietaire);
			
		if (!utilisateur.isPresent())
		{
			throw new EscaladeException("L'utilisateur " + proprietaire + " n'existe pas");
		}
		
		topo.setProprietaire(utilisateur.get());
		topo.setDatePublication(new Date());
		
		// sauvegarder et retourner le topo
		return topoRepository.save(topo);
	}
	
	@Override
	public Collection<Topo> listerTopos()
	{
		return topoRepository.findAll();
	}

	@Override
	public Collection<Topo> listerToposDisponibles(Long proprietaireId) throws EscaladeException
	{
		Optional<Utilisateur> proprietaire = utilisateurRepository.findById(proprietaireId);
		if (!proprietaire.isPresent())
		{
			throw new EscaladeException("L'utilisateur avec l'id  " + proprietaireId + " n'existe pas");
		}
		
		return topoRepository.findAllByProprietaire(proprietaire.get());
	}
	
	@Override
	public Collection<Topo> listerToposDisponibles(String proprietaire) throws EscaladeException
	{
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailIgnoreCase(proprietaire);
		if (!utilisateur.isPresent())
		{
			throw new EscaladeException("L'utilisateur  " + proprietaire + " n'existe pas");
		}
		
		return topoRepository.findAllByProprietaire(utilisateur.get());
	}
	
	@Override
	public Collection<Topo> listerToposEmprunt(String proprietaire) throws EscaladeException
	{
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailIgnoreCase(proprietaire);
		if (!utilisateur.isPresent())
		{
			throw new EscaladeException("L'utilisateur  " + proprietaire + " n'existe pas");
		}
		
		return topoRepository.findAllByEmprunteur(utilisateur.get());
	}
	
	@Override
	public Topo consulterTopo(Long id) throws EscaladeException
	{
		Optional<Topo> topo = topoRepository.findById(id);
		if (!topo.isPresent())
		{
			throw new EscaladeException("Le topo avec l'id  " + id + " n'existe pas");
		}
		
		return topo.get();
	}

	@Override
	public Topo demanderReservationTopo(Long topoId, String demandeur) throws EscaladeException
	{
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailIgnoreCase(demandeur);
		if (!utilisateur.isPresent())
		{
			throw new EscaladeException("L'utilisateur  " + demandeur + " n'existe pas");
		}
		
		Optional<Topo> topo = topoRepository.findById(topoId);
		if (!topo.isPresent())
		{
			throw new EscaladeException("Le topo avec l'id  " + topoId + " n'existe pas");
		}
		
		topo.get().setDisponible(false);
		topo.get().setDemande(true);
		topo.get().setEmprunteur(utilisateur.get());
		
		return topoRepository.save(topo.get());
	}
	
	@Override
	public Topo accepterReservationTopo(Long topoId) throws EscaladeException
	{	
		Optional<Topo> topo = topoRepository.findById(topoId);
		if (!topo.isPresent())
		{
			throw new EscaladeException("Le topo avec l'id  " + topoId + " n'existe pas");
		}
		
		topo.get().setDisponible(false);
		topo.get().setDemande(false);
		
		return topoRepository.save(topo.get());
	}
	
	@Override
	public Topo retourTopo(Long topoId) throws EscaladeException
	{	
		Optional<Topo> topo = topoRepository.findById(topoId);
		if (!topo.isPresent())
		{
			throw new EscaladeException("Le topo avec l'id  " + topoId + " n'existe pas");
		}
		
		topo.get().setDisponible(true);
		topo.get().setDemande(false);
		topo.get().setEmprunteur(null);
		
		return topoRepository.save(topo.get());
	}

	@Override
	public Topo accepterReservationExemplaireTopo(Long topoId, Long proprietaireId, Long demandeurId) throws EscaladeException
	{
		throw new NotYetImplementedException();
		
	}

	@Override
	public Topo getNewTopo(String proprietaireEmail) throws EscaladeException
	{
		Optional<Utilisateur> proprietaire = utilisateurRepository.findByEmailIgnoreCase(proprietaireEmail);
		if (!proprietaire.isPresent())
		{
			throw new EscaladeException("L'utilisateur " + proprietaireEmail + " n'existe pas");
		}
		
		Topo topo = new Topo();
		topo.setProprietaire(proprietaire.get());
		
		return topo;
	}

	
}
