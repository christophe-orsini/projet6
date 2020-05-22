package com.oc.escalade.service;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oc.escalade.dao.TopoRepository;
import com.oc.escalade.dao.UtilisateurRepository;
import com.oc.escalade.entities.Topo;
import com.oc.escalade.entities.Utilisateur;

@Service
public class TopoServiceImpl implements TopoService
{
	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Topo enregistrerTopo(Topo topo, Long proprietaireId) throws Exception
	{
		// verification de l'existence de l'utilisateur
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(proprietaireId);
			
		if (!utilisateur.isPresent())
		{
			throw new Exception("L'utilisateur N° " + proprietaireId + " n'existe pas");
			
		}
		
		// enrgeistrer le proprietaire
		topo.setProprietaire(utilisateur.get());
		
		// sauvegarder et retourner le topo
		return topoRepository.save(topo);
	}

	@Override
	public Collection<Topo> listerToposDisponibles(Long proprietaireId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void demanderReservationTopo(Long topoId, Long proprietaireId, Long demandeurId)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accepterReservationExemplaireTopo(Long topoId, Long proprietaireId, Long demandeurId)
	{
		// TODO Auto-generated method stub
		
	}
}
