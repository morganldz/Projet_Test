package fr.adaming.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.ICompteEpargneService;

public class DeposerCEServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ICompteEpargneService ceService = new CompteEpargneServiceImpl();
		
		// Récupérer les paramètres de la requette http
		int id = Integer.parseInt(req.getParameter("pIdCompte"));
		CompteEpargne ce = ceService.getCompteEpargneByIdService(id);
		
		double montant = Double.parseDouble(req.getParameter("pMontant"));
		
		// Appel de la methode service
		int verif = ceService.addMoneyService(ce, montant);
		
		if (verif == 0) {
			req.setAttribute("erreurD", verif);

			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/transactionsCE.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		} 
		
		
	}
}
