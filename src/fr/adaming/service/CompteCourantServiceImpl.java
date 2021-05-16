package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.CompteCourantDaoImpl;
import fr.adaming.dao.ICompteCourantDao;
import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;

public class CompteCourantServiceImpl implements ICompteCourantService {
	
	private ICompteCourantDao ccDao = new CompteCourantDaoImpl();

	@Override
	public int addCompteCourantService(CompteCourant cc) {
		return ccDao.addCompteCourantDao(cc);
	}

	@Override
	public int updateCompteCourantService(CompteCourant cc) {
		return ccDao.updateCompteCourantDao(cc);
	}

	@Override
	public int deleteCompteCourantService(int id) {
		return ccDao.deleteCompteCourantDao(id);
	}

	@Override
	public List<CompteCourant> getAllCompteCourantService() {
		return ccDao.getAllCompteCourantDao();
	}

	@Override
	public CompteCourant getCompteCourantByIdService(int id) {
		return ccDao.getCompteCourantByIdDao(id);
	}

	@Override
	public CompteCourant getCompteCourantByProprietaireIdService(int id) {	
		return ccDao.getCompteCourantByProprietaireIdDao(id);
	}

	@Override
	public int attributeCompteCourantToClientService(CompteCourant cc, Client c) {
		cc.setCl(c);
		return ccDao.attributeCompteCourantToClientDao(cc);
	}

	@Override
	public int withdrawMoneyService(CompteCourant cc, double montant) {
		
		if(montant >= cc.getDecouvert() + cc.getSolde()) {
			System.err.println("Vous n'avez pas assez d'argent");
			return 0;
		} else {
			return ccDao.withdrawMoneyDao(cc, montant);
		}	
	}

	@Override
	public int addMoneyService(CompteCourant cc, double montant) {
		return ccDao.addMoneyDao(cc, montant);
	}

	@Override
	public boolean transfertMoneyBetweenCompteService(CompteCourant cc1, CompteCourant cc2, double montant) {
		
		if(montant >= cc1.getDecouvert() + cc1.getSolde()) {
			System.err.println("Vous n'avez pas assez d'argent");
			return false;
		}else {
			double retrait = ccDao.withdrawMoneyDao(cc1, montant);
			double ajout = ccDao.addMoneyDao(cc2, montant);
			System.out.println("Le transfert a été effectué");
			return true;
		}	
	}
}
