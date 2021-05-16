package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.adaming.entities.Client;
import fr.adaming.entities.Personne;
import fr.adaming.service.IPersonneService;
import fr.adaming.service.PersonneServiceImpl;

public class SupPersonneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Traduction de la relation UML en Java
		IPersonneService pService = new PersonneServiceImpl();

		// Récupérer la personne de la session
		// Recupérer la session de la personne
		HttpSession session = req.getSession(false); // Ne pas créer la session si elle n'existe pas
		Personne personne = (Personne) session.getAttribute("pSession");
		
		// Instancier une personne à partir de la personne de la session
		Personne pOut = new Personne();
		pOut.setId(personne.getId());
		int idOut = pOut.getId();
		
		int verif = pService.deletePersonne(idOut);
		
		if (verif != 0) {
			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		} 
	}
}
