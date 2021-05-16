package fr.adaming.entities;

public class Client {

	// Déclaration des attributs
	private int idCl;
	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private String telephone;
	
	// Traduction de la relation UML en Java
	private CompteCourant cc;
	private CompteEpargne ce;
	
	// Création des constructeurs
	public Client() {
		super();
	}
	
	public Client(String nom, String prenom, String adresse, int codePostal, String ville, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}
	
	public Client(int idCl, String nom, String prenom, String adresse, int codePostal, String ville, String telephone) {
		super();
		this.idCl = idCl;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}
	
	// Creation getters et setters
	public int getIdCl() {
		return idCl;
	}
	public void setIdCl(int idCl) {
		this.idCl = idCl;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public CompteCourant getCc() {
		return cc;
	}

	public void setCc(CompteCourant cc) {
		this.cc = cc;
	}

	public CompteEpargne getCe() {
		return ce;
	}

	public void setCe(CompteEpargne ce) {
		this.ce = ce;
	}

	
	// Redefinition methode toString
	@Override
	public String toString() {
		return "Client [idCl=" + idCl + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", ville=" + ville + ", telephone=" + telephone + "]";
	}
	
	
}
