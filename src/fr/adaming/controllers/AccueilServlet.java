package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;
import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteCourantService;
import fr.adaming.service.ICompteEpargneService;

public class AccueilServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IClientService cService = new ClientServiceImpl();
		ICompteCourantService ccService = new CompteCourantServiceImpl();
		ICompteEpargneService ceService = new CompteEpargneServiceImpl();

		// Récupérer la liste des clients
		List<Client> list = cService.getAllClientService();
		List<CompteCourant> list1 = ccService.getAllCompteCourantService();
		List<CompteEpargne> list2 = ceService.getAllCompteEpargneService();

		req.setAttribute("clients", list);
		req.setAttribute("ccs", list1);
		req.setAttribute("ces", list2);

		// Récupérer le support de la délégation
		RequestDispatcher rd = req.getRequestDispatcher("/accueil.jsp");

		// Deleguer la requette http
		rd.forward(req, resp);
	}
}
