package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;

public interface ICompteCourantService {
	
	// Méthodes CRUD
	public int addCompteCourantService(CompteCourant cc);
	
	public int updateCompteCourantService(CompteCourant cc);
	
	public int deleteCompteCourantService(int id);
	
	public List<CompteCourant> getAllCompteCourantService();
	
	public CompteCourant getCompteCourantByIdService(int id);
	
	public CompteCourant getCompteCourantByProprietaireIdService(int id);
	
	public int attributeCompteCourantToClientService(CompteCourant cc, Client c);
	
	public int withdrawMoneyService(CompteCourant cc, double montant);

	public int addMoneyService(CompteCourant cc, double montant);
	
	public boolean transfertMoneyBetweenCompteService(CompteCourant cc1, CompteCourant cc2, double montant);
}
