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
	private String description;
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
	private int nbreSecteurs;
	private int nbreVoies;
	private int nbreLongueurs;
	private int nbreRelais;
	private String cotationMini;
	private String cotationMaxi;
	
	@OneToMany(mappedBy="site")
	private Collection<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur auteur; // personne ayant déposé le site
	
	@ManyToMany
	@JoinTable(name="topo_site", joinColumns = @JoinColumn(name="site_id"), inverseJoinColumns = @JoinColumn(name="topo_id"))
	private Collection<Topo> topos;
	
	public Site() {
		super();
	}

	public Site(String nom, String description, String commune, String departement, String pays, double latitude, double longitude)
	{
		super();
		this.nom = nom;
		this.description = description;
		this.commune = commune;
		this.departement = departement;
		this.pays = pays;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Site(String nom, String description, String commune, String departement, String pays, double latitude, double longitude, Utilisateur auteur)
	{
		super();
		this.nom = nom;
		this.description = description;
		this.commune = commune;
		this.departement = departement;
		this.pays = pays;
		this.latitude = latitude;
		this.longitude = longitude;
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

	protected String getDescription()
	{
		return description;
	}

	protected void setDescription(String description)
	{
		this.description = description;
	}

	protected int getNbreSecteurs()
	{
		return nbreSecteurs;
	}

	protected void setNbreSecteurs(int nbreSecteurs)
	{
		this.nbreSecteurs = nbreSecteurs;
	}

	protected int getNbreVoies()
	{
		return nbreVoies;
	}

	protected void setNbreVoies(int nbreVoies)
	{
		this.nbreVoies = nbreVoies;
	}

	protected int getNbreLongueurs()
	{
		return nbreLongueurs;
	}

	protected void setNbreLongueurs(int nbreLongueurs)
	{
		this.nbreLongueurs = nbreLongueurs;
	}

	protected int getNbreRelais()
	{
		return nbreRelais;
	}

	protected void setNbreRelais(int nbreRelais)
	{
		this.nbreRelais = nbreRelais;
	}

	protected String getCotationMini()
	{
		return cotationMini;
	}

	protected void setCotationMini(String cotationMini)
	{
		this.cotationMini = cotationMini;
	}

	protected String getCotationMaxi()
	{
		return cotationMaxi;
	}

	protected void setCotationMaxi(String cotationMaxi)
	{
		this.cotationMaxi = cotationMaxi;
	}

	@Override
	public String toString() {
		return "Site [nom=" + nom + ", commune=" + commune + "]";
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		
		if (obj == null || !(obj instanceof Site)) return false;
		
		Site site = (Site) obj;
		
		return (site.nom == nom && site.commune == commune);
	}

	@Override
	public int hashCode()
	{
		return (nom + commune).hashCode();
	}

}
