package com.oc.escalade.service;

import java.util.Collection;

import com.oc.escalade.entities.Topo;

public interface TopoService
{
	/**
	 * Enregistrer un topo
	 * @param topo Topo : Le topo à enregistrer
	 * @param proprietaireId Long : L'id de l'utilisateur proprietaire du topo
	 * @return Topo : Le topo nouvellement créé
	 */
	public Topo enregistrerTopo(Topo topo, Long proprietaireId); // F8
	public Collection<Topo> listerToposDisponibles(Long proprietaireId); // F9
	public void demanderReservationTopo(Long topoId, Long proprietaireId, Long demandeurId); // F9
	public void accepterReservationExemplaireTopo(Long topoId,  Long proprietaireId, Long demandeurId); // F10
}
