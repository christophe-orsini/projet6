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
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(unique = true, updatable = false, nullable = false)
	private String email; // login
	@NotNull
	private String password;
	private String nom;
	private String prenom;
	@NotNull
	@Enumerated(EnumType.STRING)
	private RoleEnum role = RoleEnum.ROLE_UTILISATEUR;
	
	@OneToMany(mappedBy="proprietaire")
	private Collection<Topo> topos; 
	@OneToMany(mappedBy="auteur")
	private Collection<Site> sites; // déposés
	@OneToMany(mappedBy="auteur")
	private Collection<Commentaire> commentaires;
	    
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(@NotNull String email, @NotNull String password) {
		super();
		// TODO pas de setters
		setEmail(email);
		setPassword(password);
	}
	
	public Utilisateur(@NotNull String email, @NotNull String password, String nom, String prenom, @NotNull RoleEnum role)
	{
		super();
		setEmail(email);
		setPassword(password);
		setNom(nom);
		setPrenom(prenom);
		setRole(role);
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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
	
	public RoleEnum getRole()
	{
		return role;
	}

	public void setRole(RoleEnum role)
	{
		this.role = role;
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

	public Collection<Topo> getTopos()
	{
		return topos;
	}

	public void setTopos(Collection<Topo> topos)
	{
		this.topos = topos;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + "]";
	}
}
