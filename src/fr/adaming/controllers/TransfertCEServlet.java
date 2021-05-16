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

public class TransfertCEServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ICompteEpargneService ceService = new CompteEpargneServiceImpl();
		
		// Récupérer les paramètres de la requette http
		int idDeb = Integer.parseInt(req.getParameter("pIdCompteDeb"));
		CompteEpargne ceDeb = ceService.getCompteEpargneByIdService(idDeb);
		
		int idCred = Integer.parseInt(req.getParameter("pIdCompteCred"));
		CompteEpargne ceCred = ceService.getCompteEpargneByIdService(idCred);
		
		double montant = Double.parseDouble(req.getParameter("pMontant"));
		
		// Appel de la methode service
		int verifd = ceService.withdrawMoneyService(ceDeb, montant);
		int verifc = ceService.addMoneyService(ceCred, montant);
		
		if (verifd == 0 && verifc == 0) {
			req.setAttribute("erreurT", verifd);

			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/transactionsCE.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		} 
		
		
	}

}
