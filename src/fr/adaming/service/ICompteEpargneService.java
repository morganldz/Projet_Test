package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteEpargne;

public interface ICompteEpargneService {
	// Méthodes CRUD
		public int addCompteEpargneService(CompteEpargne ce);
		
		public int updateCompteEpargneService(CompteEpargne ce);
		
		public int deleteCompteEpargneService(int id);
		
		public List<CompteEpargne> getAllCompteEpargneService();
		
		public CompteEpargne getCompteEpargneByIdService(int id);
		
		public CompteEpargne getCompteEpargneByProprietaireIdService(int id);
		
		public int attributeCompteEpargneToClientService(CompteEpargne ce, Client c);
		
		public int withdrawMoneyService(CompteEpargne ce, double montant);

		public int addMoneyService(CompteEpargne ce, double montant);
		
		public boolean transfertMoneyBetweenCompteService(CompteEpargne ce1, CompteEpargne ce2, double montant);
}
