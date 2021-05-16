package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Personne;

public interface IClientService {
	
	// Méthodes CRUD
	public int addClientService(Client cl);
	
	public int updateClientService(Client cl);
	
	public int deleteClientService(int id);
	
	public List<Client> getAllClientService();
	
	public Client getClientByIdService(int id);

}
