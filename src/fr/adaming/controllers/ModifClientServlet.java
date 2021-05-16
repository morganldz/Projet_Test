package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.Client;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

public class ModifClientServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IClientService cService = new ClientServiceImpl();
		
		// Récupérer param req
		int idCl = Integer.parseInt(req.getParameter("pIdCl"));

		Client cl = cService.getClientByIdService(idCl);

		req.setAttribute("clModif", cl);

		// Recuperer le support de délégation
		RequestDispatcher rd = req.getRequestDispatcher("/modifC.jsp");

		// Envoyer la requete
		rd.forward(req, resp);

	}

	private Email envoyerMail;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Traduction association UML en Java
		IClientService cService = new ClientServiceImpl();
		
		// Récupérer les paramètres de la requete http
		int id = Integer.parseInt(req.getParameter("pId"));
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		String adresse = req.getParameter("pAdresse");
		int codePostal = Integer.parseInt(req.getParameter("pCodePostal"));
		String ville = req.getParameter("pVille");
		String telephone = req.getParameter("pTelephone");
		
		// Envoyer un mail de modification
		String destinataire = req.getParameter("pMail");
		
		String sujet = "modification d'un client";
		String message = "la modification du client a bien été réalisée !!";
		String expediteur = "morgan.ledortz@gmail.com";
		String username = "morgan.ledortz";
		String password = "motdepasse"; // Pour des raisons de sécurité je ne mets pas mon mot de passe, je pourrai faire une démo avec lundi
		
		// Instancier un client avec ces valeurs
		Client client = new Client(id, nom, prenom, adresse, codePostal, ville, telephone);

		// Appel de la méthode service
		int verif = cService.updateClientService(client);

		if (verif != 0) {
			
			if(req.getParameter("bouton") != null)
				try {
					envoyerMail.sendEmail(expediteur, username, password, destinataire, sujet, message);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			// Récupérer la liste modifiée
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
			RequestDispatcher rd = req.getRequestDispatcher("/modifC.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		}

	}
}
