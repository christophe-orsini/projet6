package com.oc.escalade.entities;

import javax.persistence.*;

/**
 * Exemplaire papier d'un topo appartenant à un utilisateur du site WEB
 * @author PC_ASUS
 *
 */
@Entity
public class Exemplaire
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private boolean disponible;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topo_id")
	private Topo topo;
	@JoinColumn(name="utilisateur_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Utilisateur proprietaire;
	
	public Exemplaire() {
		super();
		
	}

	public Exemplaire(boolean disponible, Topo topo, Utilisateur proprietaire) {
		super();
		this.disponible = disponible;
		this.topo = topo;
		this.proprietaire = proprietaire;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Long getId() {
		return id;
	}
	
}
