package com.oc.escalade.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Défini la longueur entre 2 relais dans une voie
 * @author PC_ASUS
 *
 */
@Entity
public class Longueur implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	@Column(length=3, nullable=false)
	private String cotation; // 1 chiffre, 1 lettre et eventuellemnt un +
	@NotNull
	private int hauteur; // taille de la longueur
	private int nbreSpits; // nombre de points d'accroche
	private String relais; // nom du relais final s'il existe
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "voie_id")
	private Voie voie;
	
	public Longueur() {
		super();
	}

	public Longueur(String description, String cotation, int hauteur, int nbreSpits, String relais) {
		super();
		this.description = description;
		this.cotation = cotation;
		this.hauteur = hauteur;
		this.nbreSpits = nbreSpits;
		this.relais = relais;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getNbreSpits() {
		return nbreSpits;
	}

	public void setNbreSpits(int nbreSpits) {
		this.nbreSpits = nbreSpits;
	}

	public String getRelais() {
		return relais;
	}

	public void setRelais(String relais) {
		this.relais = relais;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Longueur [cotation=" + cotation + ", hauteur=" + hauteur + "]";
	}
	
}
