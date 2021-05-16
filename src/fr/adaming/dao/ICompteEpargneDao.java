package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.CompteEpargne;

public interface ICompteEpargneDao {
	
	// Méthodes CRUD
	public int addCompteEpargneDao(CompteEpargne ce);

	public int updateCompteEpargneDao(CompteEpargne ce);

	public int deleteCompteEpargneDao(int id);

	public List<CompteEpargne> getAllCompteEpargneDao();

	public CompteEpargne getCompteEpargneByIdDao(int id);

	public CompteEpargne getCompteEpargneByProprietaireIdDao(int id);

	public int attributeCompteEpargneToClientDao(CompteEpargne ce);

	public int withdrawMoneyDao(CompteEpargne ce, double montant);

	public int addMoneyDao(CompteEpargne ce, double montant);

}
