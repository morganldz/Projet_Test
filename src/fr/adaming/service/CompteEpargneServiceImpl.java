package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.CompteEpargneDaoImpl;
import fr.adaming.dao.ICompteEpargneDao;
import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;
import fr.adaming.entities.CompteEpargne;

public class CompteEpargneServiceImpl implements ICompteEpargneService {
	
	private ICompteEpargneDao ceDao = new CompteEpargneDaoImpl();

	@Override
	public int addCompteEpargneService(CompteEpargne ce) {
		return ceDao.addCompteEpargneDao(ce);
	}

	@Override
	public int updateCompteEpargneService(CompteEpargne ce) {
		return ceDao.updateCompteEpargneDao(ce);
	}

	@Override
	public int deleteCompteEpargneService(int id) {
		return ceDao.deleteCompteEpargneDao(id);
	}

	@Override
	public List<CompteEpargne> getAllCompteEpargneService() {
		return ceDao.getAllCompteEpargneDao();
	}

	@Override
	public CompteEpargne getCompteEpargneByIdService(int id) {
		return ceDao.getCompteEpargneByIdDao(id);
	}

	@Override
	public CompteEpargne getCompteEpargneByProprietaireIdService(int id) {
		return ceDao.getCompteEpargneByProprietaireIdDao(id);
	}

	@Override
	public int attributeCompteEpargneToClientService(CompteEpargne ce, Client c) {
		ce.setCl(c);
		return ceDao.attributeCompteEpargneToClientDao(ce);
	}

	@Override
	public int withdrawMoneyService(CompteEpargne ce, double montant) {
		if(montant >= ce.getSolde()) {
			System.err.println("Vous n'avez pas assez d'argent");
			return 0;
		} else {
			return ceDao.withdrawMoneyDao(ce, montant);
		}
	}

	@Override
	public int addMoneyService(CompteEpargne ce, double montant) {
			return ceDao.addMoneyDao(ce, montant);
	}

	@Override
	public boolean transfertMoneyBetweenCompteService(CompteEpargne ce1, CompteEpargne ce2, double montant) {
		if(montant >= ce1.getSolde()) {
			System.err.println("Vous n'avez pas assez d'argent");
			return false;
		}else {
			double retrait = ceDao.withdrawMoneyDao(ce1, montant);
			double ajout = ceDao.addMoneyDao(ce2, montant);
			System.out.println("Le transfert a été effectué");
			return true;
		}
	}
}
