package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.Client;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

public class AfficherClientServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IClientService cService = new ClientServiceImpl();

		// Récupérer la liste des clients
		List<Client> list = cService.getAllClientService();

		// Récupérer le support de la délégation
		RequestDispatcher rd = req.getRequestDispatcher("/listeClient.jsp");
		
		req.setAttribute("clients", list);

		// Deleguer la requette http
		rd.forward(req, resp);
	}

}
