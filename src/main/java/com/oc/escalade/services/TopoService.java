package com.oc.escalade.services;

import java.util.Collection;

import com.oc.escalade.entities.Topo;
import com.oc.escalade.tools.EscaladeException;

public interface TopoService
{
	/**
	 * Enregistrer un topo
	 * @param topo Topo : Le topo à enregistrer
	 * @param proprietaireId Long : L'id de l'utilisateur proprietaire du topo
	 * @return Topo : Le topo nouvellement créé
	 * @throws Exception 
	 */
	public Topo publierTopo(Topo topo, String proprietaire) throws EscaladeException; // F8
	public Collection<Topo> listerTopos();
	public Collection<Topo> listerToposDisponibles(Long proprietaireId) throws EscaladeException; // F9
	public Collection<Topo> listerToposDisponibles(String proprietaire) throws EscaladeException; // F9
	public Collection<Topo> listerToposEmprunt(String proprietaire) throws EscaladeException;
	public Topo consulterTopo(Long id) throws EscaladeException;
	public Topo demanderReservationTopo(Long topoId, String demandeur) throws EscaladeException; // F9
	public Topo accepterReservationTopo(Long topoId) throws EscaladeException; // F10
	public Topo retourTopo(Long topoId) throws EscaladeException; // F10
	public Topo accepterReservationExemplaireTopo(Long topoId,  Long proprietaireId, Long demandeurId) throws EscaladeException; // F10
	public Topo getNewTopo(String proprietaireEmail) throws EscaladeException;
}
