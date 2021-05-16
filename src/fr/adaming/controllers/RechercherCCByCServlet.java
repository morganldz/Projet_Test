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

public class RechercherCCByCServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Traduction association UML en Java
		ICompteCourantService ccService = new CompteCourantServiceImpl();

		// Récupérer les params de la requete
		int id = Integer.parseInt(req.getParameter("pIdCR"));
		
		CompteCourant ccOut = ccService.getCompteCourantByProprietaireIdService(id);
		
		if (ccOut != null) {

			// Passer de la Servlet à la JSP
			req.setAttribute("ccrechbc", ccOut);

		} else {
			req.setAttribute("erreur", 0);

		}
		List<CompteCourant> list = ccService.getAllCompteCourantService();
		req.setAttribute("ccs", list);
		
		// Recuperer le support de délégation
		RequestDispatcher rd = req.getRequestDispatcher("/listeCC.jsp");

		// Envoyer la requete
		rd.forward(req, resp);

	}
	

}
