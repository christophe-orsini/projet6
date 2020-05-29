package com.oc.escalade.entities;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
	@NotEmpty(message="Le titre doit être renseigné")
	private String titre;
	private String region;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePublication;
	private boolean disponible = true;
	private boolean demande;
	
	@JoinColumn(name="proprietaire_id")
	@ManyToOne
	private Utilisateur proprietaire;
	
	@JoinColumn(name="emprunteur_id")
	@ManyToOne
	private Utilisateur emprunteur;

	public Topo() {
		super();
	}

	public Topo(String titre, String region, String description) {
		super();
		this.titre = titre;
		this.region = region;
		this.description = description;
	}

	public Date getDatePublication()
	{
		return datePublication;
	}

	public void setDatePublication(Date datePublication)
	{
		this.datePublication = datePublication;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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

	public boolean isDisponible()
	{
		return disponible;
	}

	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}
	
	public Utilisateur getEmprunteur()
	{
		return emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur)
	{
		this.emprunteur = emprunteur;
	}
	
	public boolean isDemande()
	{
		return demande;
	}

	public void setDemande(boolean demande)
	{
		this.demande = demande;
	}
}
