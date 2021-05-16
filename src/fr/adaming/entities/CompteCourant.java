package fr.adaming.entities;

public class CompteCourant extends Compte {

	// Déclaration des attributs
	private double decouvert = 100;
	
	// Traduction de la relation UML en Java
	private Client cl;

	// Création des constructeurs
	public CompteCourant() {
		super();
	}

	public CompteCourant(String numeroCompte, double solde, double decouvert) {
		super(numeroCompte, solde);
		this.decouvert = decouvert;
	}

	public CompteCourant(int idCo, String numeroCompte, double solde, double decouvert) {
		super(idCo, numeroCompte, solde);
		this.decouvert = decouvert;
	}

	// Creation getters et setters
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	public Client getCl() {
		return cl;
	}

	public void setCl(Client cl) {
		this.cl = cl;
	}

	// Redefinition méthode toString
	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", idCo=" + idCo + ", numeroCompte=" + numeroCompte
				+ ", solde=" + solde + "]";
	}


	
	
}
