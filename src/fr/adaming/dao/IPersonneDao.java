package fr.adaming.dao;

import fr.adaming.entities.Personne;

public interface IPersonneDao {
	
	public Personne seConnecter(Personne pIn);
	
	public int addPersonne(Personne pIn);
	
	public int updatePersonne(Personne pIn);
	
	public int deletePersonne(int id);
	
	public Personne getPersonneById(int id);

}
