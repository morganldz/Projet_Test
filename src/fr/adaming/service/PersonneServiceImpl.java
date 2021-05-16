package fr.adaming.service;

import fr.adaming.dao.PersonneDaoImpl;
import fr.adaming.dao.IPersonneDao;
import fr.adaming.entities.Personne;

public class PersonneServiceImpl implements IPersonneService {

	// Traduction de l'association UML en java
	private IPersonneDao pDao = new PersonneDaoImpl();
	
	@Override
	public Personne seConnecter(Personne pIn) {
		// Appel de la méthode DAO
		return pDao.seConnecter(pIn);
	}

	@Override
	public int addPersonne(Personne pIn) {
		// Appel de la méthode DAO
		return pDao.addPersonne(pIn);
	}

	@Override
	public int updatePersonne(Personne pIn) {
		// Appel de la méthode DAO
		return pDao.updatePersonne(pIn);
	}

	@Override
	public int deletePersonne(int id) {
		// Appel de la méthode DAO
		return pDao.deletePersonne(id);
	}

	@Override
	public Personne getPersonneById(int id) {
		// Appel de la méthode DAO
		return pDao.getPersonneById(id);
	}

}
