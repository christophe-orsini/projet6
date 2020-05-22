package com.oc.escalade.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Receuil d'informations sur les sites d'escalade d'une région
 * @author PC_ASUS
 *
 */
@Entity
public class Topo
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String titre;
	private String region;
	@NotNull
	private String decription;
	
	@JoinColumn(name="proprietaire_id")
	@ManyToOne
	private Utilisateur proprietaire;
	
	public Topo() {
		super();
		
	}

	public Topo(String titre, String region, String decription) {
		super();
		this.titre = titre;
		this.region = region;
		this.decription = decription;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Topo [titre=" + titre + "]";
	}

	public Utilisateur getProprietaire()
	{
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire)
	{
		this.proprietaire = proprietaire;
	}
	
}
