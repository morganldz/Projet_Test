package fr.adaming.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.adaming.entities.Personne;
import fr.adaming.service.IPersonneService;
import fr.adaming.service.PersonneServiceImpl;

public class ModifPersonneServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IPersonneService pService = new PersonneServiceImpl();
		
		// Récupérer la personne de la session
		// Recupérer la session de la personne
		HttpSession session = req.getSession(false); // Ne pas créer la session si elle n'existe pas
		Personne personne = (Personne) session.getAttribute("pSession");
	
		req.setAttribute("pModif", personne);

		// Recuperer le support de délégation
		RequestDispatcher rd = req.getRequestDispatcher("/parametre.jsp");

		// Envoyer la requete
		rd.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Traduction de la relation UML en Java
		IPersonneService pService = new PersonneServiceImpl();

		// Récupération des parametres de la requete http
		int id = Integer.parseInt(req.getParameter("pId"));
		String email = req.getParameter("pMail");
		String mdp = req.getParameter("pMdp");

		// Instancier une personne avec ces valeurs
		Personne pModif = new Personne(id, email, mdp);

		// Appel de la méthode service
		int verif = pService.updatePersonne(pModif);
		
		if (verif == 0) {
			req.setAttribute("erreur", verif);

			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/parametre.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		}else {
			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/parametre.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		}
	}
}
