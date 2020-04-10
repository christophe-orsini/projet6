package com.oc.escalade.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.*;

/**
 * Regroupement de voies pour un site
 * @author PC_ASUS
 *
 */
@Entity
public class Secteur implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@OneToMany(mappedBy = "secteur", cascade = CascadeType.PERSIST)
	private Collection<Voie> voies;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "site_id")
	private Site site;
	
	public Secteur() {
		super();
		voies = new HashSet<Voie>();
	}

	public Secteur(String nom, Collection<Voie> voies) {
		super();
		this.nom = nom;
		this.voies = voies != null ? voies : new HashSet<Voie>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	public Collection<Voie> getVoies() {
		return voies;
	}

	public void setVoies(Collection<Voie> voies) {
		this.voies = voies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Secteur [nom=" + nom + "]";
	}
	
	// ********************* meyhods
	
	public int getNbVoies()
	{
		return voies.size();
	}

}
