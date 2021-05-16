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

public class AjoutCEServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Transformation de l'aasociation UML en Java
				ICompteEpargneService ceService = new CompteEpargneServiceImpl();
				
				// Récupération des parametres de la requete http
				String numeroCompte = req.getParameter("pNumeroCompte");
				double solde = Double.parseDouble(req.getParameter("pSolde"));
				double taux = Double.parseDouble(req.getParameter("pTaux"));
				
				// Instancier un compte epargne avec ces valeurs
				CompteEpargne ceNew = new CompteEpargne(numeroCompte, solde, taux);
				
				// Appel de la méthode service
				int verif = ceService.addCompteEpargneService(ceNew);
				
				if (verif != 0) {

					// Récupérer la nouvelle liste
					List<CompteEpargne> liste = ceService.getAllCompteEpargneService();

					// Ajouter la liste comme attribut de la requete
					// Passer de la Servlet à la JSP
					req.setAttribute("ces", liste);

					// Recuperer le support de délégation

					RequestDispatcher rd = req.getRequestDispatcher("/listeCE.jsp");

					// Envoyer la requete
					rd.forward(req, resp);

				} else {
					req.setAttribute("erreur", verif);

					// Recuperer le support de délégation
					RequestDispatcher rd = req.getRequestDispatcher("/ajoutCE.jsp");

					// Envoyer la requete
					rd.forward(req, resp);
				}
				
	}

}
