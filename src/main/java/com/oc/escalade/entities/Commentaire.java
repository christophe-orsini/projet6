package com.oc.escalade.entities;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Commentaire laissé par un utilisateur au sujet d'un site
 * @author PC_ASUS
 *
 */
@Entity
public class Commentaire
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePublication;
	@NotNull
	private String contenu;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModification;
	
	@ManyToOne
	@JoinColumn(name="site_id")
	private Site site;
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur auteur;
	
	public Commentaire() {
		super();
	}

	public Commentaire(Date datePublication, String contenu, Site site, Utilisateur auteur) {
		super();
		this.datePublication = datePublication;
		this.dateModification = datePublication;
		this.contenu = contenu;
		this.site = site;
		this.auteur = auteur;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public Long getId() {
		return id;
	}

	public Date getDateModification()
	{
		return dateModification;
	}

	public void setDateModification(Date dateModification)
	{
		this.dateModification = dateModification;
	}
}
