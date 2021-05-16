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

public class AfficherCCServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICompteCourantService ccService = new CompteCourantServiceImpl();

		// Récupérer la liste des comptes courants
		List<CompteCourant> list = ccService.getAllCompteCourantService();

		// Récupérer le support de la délégation
		RequestDispatcher rd = req.getRequestDispatcher("/listeCC.jsp");
		
		req.setAttribute("ccs", list);

		// Deleguer la requette http
		rd.forward(req, resp);
	}

}
