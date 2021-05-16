package fr.adaming.service;

import fr.adaming.entities.Personne;

public interface IPersonneService {
	
	public Personne seConnecter(Personne pIn);

	public int addPersonne(Personne pIn);
	
	public int updatePersonne(Personne pIn);
	
	public int deletePersonne(int id);
	
	public Personne getPersonneById(int id);
}
