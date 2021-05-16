package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;

public interface ICompteCourantDao {
	
	// Méthodes CRUD
	public int addCompteCourantDao(CompteCourant cc);
	
	public int updateCompteCourantDao(CompteCourant cc);
	
	public int deleteCompteCourantDao(int id);
	
	public List<CompteCourant> getAllCompteCourantDao();
	
	public CompteCourant getCompteCourantByIdDao(int id);
	
	public CompteCourant getCompteCourantByProprietaireIdDao(int id);
	
	public int attributeCompteCourantToClientDao(CompteCourant cc);
	
	public int withdrawMoneyDao(CompteCourant cc, double montant);
	
	public int addMoneyDao(CompteCourant cc, double montant);
	
}
