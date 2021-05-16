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

public class AfficherCEServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICompteEpargneService ceService = new CompteEpargneServiceImpl();

		// Récupérer la liste des comptes epargnes
		List<CompteEpargne> list = ceService.getAllCompteEpargneService();

		// Récupérer le support de la délégation
		RequestDispatcher rd = req.getRequestDispatcher("/listeCE.jsp");
		
		req.setAttribute("ces", list);

		// Deleguer la requette http
		rd.forward(req, resp);
	}

}
