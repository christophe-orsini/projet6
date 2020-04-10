package com.oc.escalade.entities;

import java.util.Collection;

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
	
	@OneToMany(mappedBy="topo", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Collection<Exemplaire> exemplaires;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name="topo_site", joinColumns = @JoinColumn(name="topo_id"), inverseJoinColumns = @JoinColumn(name="site_id"))
	private Collection<Site> sites;
	
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

	public Collection<Site> getSites() {
		return sites;
	}

	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}

	public Collection<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(Collection<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Topo [titre=" + titre + "]";
	}
	
}
