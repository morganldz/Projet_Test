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

public class AjoutClientServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Transformation de l'aasociation UML en Java
		IClientService cService = new ClientServiceImpl();
		
		// Récupération des parametres de la requete http
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		String adresse = req.getParameter("pAdresse");
		int codePostal = Integer.parseInt(req.getParameter("pCodePostal"));
		String ville = req.getParameter("pVille");
		String telephone = req.getParameter("pTelephone");
		
		// Instancier un client avec ces valeurs
		Client cNew = new Client(nom, prenom, adresse, codePostal, ville, telephone);
		
		// Appel de la méthode service
		int verif = cService.addClientService(cNew);
		
		if (verif != 0) {

			// Récupérer la nouvelle liste
			List<Client> liste = cService.getAllClientService();

			// Ajouter la liste comme attribut de la requete
			// Passer de la Servlet à la JSP
			req.setAttribute("clients", liste);

			// Recuperer le support de délégation

			RequestDispatcher rd = req.getRequestDispatcher("/listeClient.jsp");

			// Envoyer la requete
			rd.forward(req, resp);

		} else {
			req.setAttribute("erreur", verif);

			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/ajoutC.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		}
	}
}
