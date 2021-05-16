package fr.adaming.entities;

public class Personne {
	
	// Déclaration des attributs
	private int id;
	private String mail;
	private String mdp;
	
	// Déclaration des constructeurs
	public Personne() {
		super();
	}
	public Personne(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}
	public Personne(int id, String mail, String mdp) {
		super();
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
	}
	
	// Getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", mail=" + mail + ", mdp=" + mdp + "]";
	}


	
	

}
