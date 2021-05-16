package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteEpargneService;

public class AttribuerCEServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		IClientService cService = new ClientServiceImpl();
		ICompteEpargneService ceService = new CompteEpargneServiceImpl();
		
		// Récupérer les paramètres de la requette http
		int idCl = Integer.parseInt(req.getParameter("pIdClient"));
		Client client = cService.getClientByIdService(idCl);
		
		int idCo = Integer.parseInt(req.getParameter("pIdCompte"));
		CompteEpargne compte = ceService.getCompteEpargneByIdService(idCo);
		
		// Appel de la méthode service
		int verif = ceService.attributeCompteEpargneToClientService(compte, client);
		
		if (verif != 0) {

			// Récupérer la nouvelle liste
			List<CompteEpargne> liste = ceService.getAllCompteEpargneService();

			// Ajouter la liste comme attribut de la requete
			// Passer de la Servlet à la JSP
			req.setAttribute("ces", liste);

			// Recuperer le support de délégation

			RequestDispatcher rd = req.getRequestDispatcher("/listeCE.jsp");

			// Envoyer la requete
			rd.forward(req, resp);

		} else {
			req.setAttribute("erreur", verif);

			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/ajoutCE.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		IClientService cService = new ClientServiceImpl();
		ICompteEpargneService ceService = new CompteEpargneServiceImpl();
		
		// Liste des clients et des comptes courants
		List<CompteEpargne> list = ceService.getAllCompteEpargneService();
		List<Client> listec = cService.getAllClientService();
		
		// Récupérer le support de la délégation
		RequestDispatcher rd = req.getRequestDispatcher("/ajoutCE.jsp");

		req.setAttribute("ces", list);
		req.setAttribute("cs", listec);

		// Deleguer la requette http
		rd.forward(req, resp);		
	}
	
}
