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

public class RetirerCCServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICompteCourantService ccService = new CompteCourantServiceImpl();

		// Récupérer les paramètres de la requette http
		int id = Integer.parseInt(req.getParameter("pIdCompte"));
		CompteCourant cc = ccService.getCompteCourantByIdService(id);

		double montant = Double.parseDouble(req.getParameter("pMontant"));

		// Appel de la methode service
		int verif = ccService.withdrawMoneyService(cc, montant);

		if (verif == 0) {
			req.setAttribute("erreurR", verif);

		}

		// Recuperer le support de délégation
		RequestDispatcher rd = req.getRequestDispatcher("/transactionsCC.jsp");

		// Envoyer la requete
		rd.forward(req, resp);

	}
}
