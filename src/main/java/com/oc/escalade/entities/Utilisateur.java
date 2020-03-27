package com.oc.escalade.entities;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Utilisateur inscrit du site WEB
 * @author PC_ASUS
 *
 */
@Entity
public class Utilisateur
{
	@Id
	@Column(unique = true, updatable = false, nullable = false)
	private String email; // login
	@NotNull
	private String password;
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	
	@OneToMany(mappedBy="proprietaire")
	private Collection<Exemplaire> exemplaires; // de topos
	@OneToMany(mappedBy="auteur")
	private Collection<Site> sites; // déposés
	@OneToMany(mappedBy="auteur")
	private Collection<Commentaire> commentaires;
	
	public Utilisateur() {
		super();
		
	}

	public Utilisateur(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(Collection<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	public Collection<Site> getSites() {
		return sites;
	}

	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
