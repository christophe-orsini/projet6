package com.oc.escalade.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/**
 * Lieu de grimpe composé d'un ou plusieurs secteur(s)
 * @author PC_ASUS
 *
 */
@Entity

public class Site implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, updatable = false, nullable = false)
	@NotEmpty(message="Le nom du site est obligatoire")
	private String nom;
	private String description;
	@NotEmpty(message="La commune est obligatoire")
	private String commune;
	@NotEmpty(message="Le département est obligatoire")
	private String departement;
	private String pays = "France";
	@Range(min=-90, max=90, message="La latitude est impossible")
	private double latitude;
	@Range(min=-180, max=180, message="La longitude est impossible")
	private double longitude;
	private boolean tag;
	@Range(min=0, message="Le nombre de secteurs ne peut pas être négatif")
	private int nbreSecteurs;
	@Range(min=0, message="Le nombre de voies ne peut pas être négatif")
	private int nbreVoies;
	@Range(min=0, message="Le nombre de longueurs ne peut pas être négatif")
	private int nbreLongueurs;
	@Range(min=0, message="Le nombre de relais ne peut pas être négatif")
	private int nbreRelais;
	@Size(min=1, max=2, message="Cette cotation n'est pas valide")
	private String cotationMini;
	@Size(min=1, max=2, message="Cette cotation n'est pas valide")
	private String cotationMaxi;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePublication;
	
	@OneToMany(mappedBy="site", fetch = FetchType.EAGER)
	private Collection<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur auteur; // personne ayant déposé le site
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getNbreSecteurs()
	{
		return nbreSecteurs;
	}

	public void setNbreSecteurs(int nbreSecteurs)
	{
		this.nbreSecteurs = nbreSecteurs;
	}

	public int getNbreVoies()
	{
		return nbreVoies;
	}

	public void setNbreVoies(int nbreVoies)
	{
		this.nbreVoies = nbreVoies;
	}

	public int getNbreLongueurs()
	{
		return nbreLongueurs;
	}

	public void setNbreLongueurs(int nbreLongueurs)
	{
		this.nbreLongueurs = nbreLongueurs;
	}

	public int getNbreRelais()
	{
		return nbreRelais;
	}

	public void setNbreRelais(int nbreRelais)
	{
		this.nbreRelais = nbreRelais;
	}

	public String getCotationMini()
	{
		return cotationMini;
	}

	public void setCotationMini(String cotationMini)
	{
		this.cotationMini = cotationMini;
	}

	public String getCotationMaxi()
	{
		return cotationMaxi;
	}

	public void setCotationMaxi(String cotationMaxi)
	{
		this.cotationMaxi = cotationMaxi;
	}

	public Date getDatePublication()
	{
		return datePublication;
	}

	public void setDatePublication(Date datePublication)
	{
		this.datePublication = datePublication;
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
