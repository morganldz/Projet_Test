package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.Personne;
import fr.adaming.service.PersonneServiceImpl;
import fr.adaming.service.IPersonneService;

public class AjoutPersonneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Transformation de l'aasociation UML en Java
		IPersonneService pService = new PersonneServiceImpl();

		// Récupération des parametres de la requete http
		String email = req.getParameter("pMail");
		String mdp = req.getParameter("pMdp");

		// Instancier une personne avec ces valeurs
		Personne pNew = new Personne(email, mdp);

		// Appel de la méthode service
		int verif = pService.addPersonne(pNew);

		if (verif != 0) {

			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");

			// Envoyer la requete
			rd.forward(req, resp);

		} else {
			req.setAttribute("erreur", verif);

			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/ajoutP.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		}
	}
}
