package fr.adaming.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.CompteCourant;
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.ICompteCourantService;

public class TransfertCCServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ICompteCourantService ccService = new CompteCourantServiceImpl();
		
		// Récupérer les paramètres de la requette http
		int idDeb = Integer.parseInt(req.getParameter("pIdCompteDeb"));
		CompteCourant ccDeb = ccService.getCompteCourantByIdService(idDeb);
		
		int idCred = Integer.parseInt(req.getParameter("pIdCompteCred"));
		CompteCourant ccCred = ccService.getCompteCourantByIdService(idCred);
		
		double montant = Double.parseDouble(req.getParameter("pMontant"));
		
		// Appel de la methode service
		int verifd = ccService.withdrawMoneyService(ccDeb, montant);
		int verifc = ccService.addMoneyService(ccCred, montant);
		
		if (verifd == 0 && verifc == 0) {
			req.setAttribute("erreurT", verifd);

		} 
		
		// Recuperer le support de délégation
		RequestDispatcher rd = req.getRequestDispatcher("/transactionsCC.jsp");

		// Envoyer la requete
		rd.forward(req, resp);
		
		
	}

}
