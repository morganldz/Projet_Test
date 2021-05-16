package fr.adaming.entities;

public class CompteEpargne extends Compte {
	
	// Déclaration des attributs
	private double taux = 0.03;
	
	// Traduction de la relation UML en Java
	private Client cl;

	// Création des constructeurs
	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String numeroCompte, double solde, double taux) {
		super(numeroCompte, solde);
		this.taux = taux;
	}

	public CompteEpargne(int idCo, String numeroCompte, double solde, double taux) {
		super(idCo, numeroCompte, solde);
		this.taux = taux;
	}

	// Creation getters et setters
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
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
		return "CompteEpargne [taux=" + taux + ", idCo=" + idCo + ", numeroCompte=" + numeroCompte + ", solde=" + solde
				+ "]";
	}
	

}
