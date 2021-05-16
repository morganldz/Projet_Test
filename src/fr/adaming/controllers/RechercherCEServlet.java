package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.ICompteEpargneService;

public class RechercherCEServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Traduction association UML en Java
		ICompteEpargneService ceService = new CompteEpargneServiceImpl();

		// Récupérer les params de la requete
		int idr = Integer.parseInt(req.getParameter("pIdCeR"));
		
		CompteEpargne ceOut = ceService.getCompteEpargneByIdService(idr);
		System.out.println(ceOut);
		
		if (ceOut != null) {

			// Passer de la Servlet à la JSP
			req.setAttribute("cerech", ceOut);

		} else {
			req.setAttribute("erreur", 0);

		}
		List<CompteEpargne> list = ceService.getAllCompteEpargneService();
		req.setAttribute("ces", list);
		
		// Recuperer le support de délégation
		RequestDispatcher rd = req.getRequestDispatcher("/listeCE.jsp");

		// Envoyer la requete
		rd.forward(req, resp);

	}

}
