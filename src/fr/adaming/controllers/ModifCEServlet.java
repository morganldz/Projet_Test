package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.ICompteEpargneService;

public class ModifCEServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICompteEpargneService ceService = new CompteEpargneServiceImpl();
		
		// Récupérer param req
		int idCE = Integer.parseInt(req.getParameter("pIdCE"));

		CompteEpargne ce = ceService.getCompteEpargneByIdService(idCE);

		req.setAttribute("ceModif", ce);

		// Recuperer le support de délégation
		RequestDispatcher rd = req.getRequestDispatcher("/modifCE.jsp");

		// Envoyer la requete
		rd.forward(req, resp);

	}
	
	private Email envoyerMail;
	
	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Traduction association UML en Java
				ICompteEpargneService ceService = new CompteEpargneServiceImpl();
				
				// Récupérer les paramètres de la requete http
				int id = Integer.parseInt(req.getParameter("pId"));
				String numeroCompte = req.getParameter("pNumeroCompte");
				double solde = Double.parseDouble(req.getParameter("pSolde"));
				double taux = Double.parseDouble(req.getParameter("pTaux"));
				
				// Envoyer un mail de modification
				String destinataire = req.getParameter("pMail");

				String sujet = "modification d'un compte épargne";
				String message = "la modification du compte épargne a bien été réalisée !!";
				String expediteur = "morgan.ledortz@gmail.com";
				String username = "morgan.ledortz";
				String password = "motdepasse"; // Pour des raisons de sécurité je ne mets pas mon mot de passe, je pourrai faire une démo avec lundi

				// Instancier un client avec ces valeurs
				CompteEpargne ce1 = new CompteEpargne(id, numeroCompte, solde, taux);
				
				// Appel de la méthode service
				int verif = ceService.updateCompteEpargneService(ce1);
				
				if (verif != 0) {
					
					if (req.getParameter("bouton") != null)
						try {
							envoyerMail.sendEmail(expediteur, username, password, destinataire, sujet, message);
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					// Récupérer la liste modifiée
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
					RequestDispatcher rd = req.getRequestDispatcher("/modifCE.jsp");

					// Envoyer la requete
					rd.forward(req, resp);
				}

			}
}
