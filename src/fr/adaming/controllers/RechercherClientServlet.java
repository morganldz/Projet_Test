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

public class RechercherClientServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Traduction association UML en Java
		IClientService cService = new ClientServiceImpl();

		// Récupérer les params de la requete
		int idr = Integer.parseInt(req.getParameter("pIdClR"));
		
		Client cOut = cService.getClientByIdService(idr);
		System.out.println(cOut);
		
		if (cOut != null) {

			// Passer de la Servlet à la JSP
			req.setAttribute("clrech", cOut);

		} else {
			req.setAttribute("erreur", 0);

		}
		List<Client> list = cService.getAllClientService();
		req.setAttribute("clients", list);
		
		// Recuperer le support de délégation
		RequestDispatcher rd = req.getRequestDispatcher("/listeClient.jsp");

		// Envoyer la requete
		rd.forward(req, resp);

	}

}
