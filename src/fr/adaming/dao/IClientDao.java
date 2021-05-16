package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Personne;

public interface IClientDao {

	// Méthodes CRUD
	public int addClientDao(Client cl);
	
	public int updateClientDao(Client cl);
	
	public int deleteClientDao(int id);
	
	public List<Client> getAllClientDao();
	
	public Client getClientByIdDao(int id);
	
}
