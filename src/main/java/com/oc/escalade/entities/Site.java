package com.oc.escalade.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Lieu de grimpe composé d'un ou plusieurs secteur(s)
 * @author PC_ASUS
 *
 */
@Entity
public class Site implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String nom;
	@NotNull
	private String commune;
	@NotNull
	private String departement;
	private String pays;
	@NotNull
	private double latitude;
	@NotNull
	private double longitude;
	private boolean tag; // marqué par l'administrateur
	
	@OneToMany(mappedBy="site", fetch = FetchType.LAZY)
	private Collection<Secteur> secteurs;
	@OneToMany(mappedBy="site")
	private Collection<Commentaire> commentaires;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="utilisateur_id")
	private Utilisateur auteur; // personne ayant déposé le site
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="topo_site", joinColumns = @JoinColumn(name="site_id"), inverseJoinColumns = @JoinColumn(name="topo_id"))
	private Collection<Topo> topos;
	
	public Site() {
		super();
		
	}

	public Site(String nom, String commune, String departement, String pays, double latitude, double longitude, boolean tag,
			Collection<Secteur> secteurs, Utilisateur auteur) {
		super();
		this.nom = nom;
		this.commune = commune;
		this.departement = departement;
		this.pays = pays;
		this.latitude = latitude;
		this.longitude = longitude;
		this.tag = tag;
		this.secteurs = secteurs;
		this.auteur = auteur;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public boolean isTag() {
		return tag;
	}

	public void setTag(boolean tag) {
		this.tag = tag;
	}

	public Collection<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(Collection<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Collection<Topo> getTopos() {
		return topos;
	}

	public void setTopos(Collection<Topo> topos) {
		this.topos = topos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Site [nom=" + nom + ", commune=" + commune + "]";
	}
	
}
