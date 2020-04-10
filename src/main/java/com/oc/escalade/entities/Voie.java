package com.oc.escalade.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Chemin emprunté par le grimpeur pour aller du départ à l'arrivée et composé d'une ou plusieurs longueur(s)
 * @author PC_ASUS
 *
 */
@Entity
public class Voie implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@OneToMany(mappedBy = "voie", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Collection<Longueur> longueurs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "secteur_id")
	private Secteur secteur;
	
	public Voie() {
		super();
		longueurs = new HashSet<Longueur>();
	}

	public Voie(String nom, Collection<Longueur> longueurs) {
		super();
		this.nom = nom;
		this.longueurs = longueurs != null ? longueurs : new HashSet<Longueur>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Longueur> getLongueurs() {
		return longueurs;
	}

	public void setLongueurs(Collection<Longueur> longueurs) {
		this.longueurs = longueurs;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Voie [nom=" + nom + "]";
	}
	
}
