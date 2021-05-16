package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;
import fr.adaming.entities.Personne;



public class ClientServiceImpl implements IClientService {

	private IClientDao cDao = new ClientDaoImpl();
	
	@Override
	public int addClientService(Client cl) {
		return cDao.addClientDao(cl);
	}

	@Override
	public int updateClientService(Client cl) {
		// TODO Auto-generated method stub
		return cDao.updateClientDao(cl);
	}

	@Override
	public int deleteClientService(int id) {
		// TODO Auto-generated method stub
		return cDao.deleteClientDao(id);
	}

	@Override
	public List<Client> getAllClientService() {
		return cDao.getAllClientDao();
	}

	@Override
	public Client getClientByIdService(int id) {
		return cDao.getClientByIdDao(id);
	}
	

}
