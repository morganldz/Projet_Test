package fr.adaming.entities;

public abstract class Compte {

	// Déclaration des attributs
	protected int idCo;
	protected String numeroCompte;
	protected double solde;
	
	// Création des constructeurs
	public Compte() {
		super();
	}
	public Compte(String numeroCompte, double solde) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
	}
	public Compte(int idCo, String numeroCompte, double solde) {
		super();
		this.idCo = idCo;
		this.numeroCompte = numeroCompte;
		this.solde = solde;
	} 
	
	// Creation getters et setters
	public int getIdCo() {
		return idCo;
	}
	public void setIdCo(int idCo) {
		this.idCo = idCo;
	}
	public String getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	

	
	
}
