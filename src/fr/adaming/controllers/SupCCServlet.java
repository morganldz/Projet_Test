package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.CompteCourant;
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.ICompteCourantService;

public class SupCCServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICompteCourantService ccService = new CompteCourantServiceImpl();

		// Récupérer les paramètres de la requete
		int id = Integer.parseInt(req.getParameter("pId"));
		
		// Appel de la méthode service
		ccService.getCompteCourantByIdService(id);
		
		int verif = ccService.deleteCompteCourantService(id);
		
		if (verif != 0) {

			// Récupérer la liste modifiée
			List<CompteCourant> liste = ccService.getAllCompteCourantService();

			// Ajouter la liste comme attribut de la requete
			// Passer de la Servlet à la JSP
			req.setAttribute("ccs", liste);

			// Recuperer le support de délégation

			RequestDispatcher rd = req.getRequestDispatcher("/listeCC.jsp");

			// Envoyer la requete
			rd.forward(req, resp);

		} 

	}
}
