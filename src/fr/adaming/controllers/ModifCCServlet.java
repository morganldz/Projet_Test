package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.CompteCourant;
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.ICompteCourantService;

public class ModifCCServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICompteCourantService ccService = new CompteCourantServiceImpl();

		// Récupérer param req
		int idCC = Integer.parseInt(req.getParameter("pIdCC"));

		CompteCourant cc = ccService.getCompteCourantByIdService(idCC);

		req.setAttribute("ccModif", cc);

		// Recuperer le support de délégation
		RequestDispatcher rd = req.getRequestDispatcher("/modifCC.jsp");

		// Envoyer la requete
		rd.forward(req, resp);

	}

	private Email envoyerMail;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Traduction association UML en Java
		ICompteCourantService ccService = new CompteCourantServiceImpl();

		// Récupérer les paramètres de la requete http
		int id = Integer.parseInt(req.getParameter("pId"));
		String numeroCompte = req.getParameter("pNumeroCompte");
		double solde = Double.parseDouble(req.getParameter("pSolde"));
		double decouvert = Double.parseDouble(req.getParameter("pDecouvert"));

		// Envoyer un mail de modification
		String destinataire = req.getParameter("pMail");

		String sujet = "modification d'un compte courant";
		String message = "la modification du compte courant a bien été réalisée !!";
		String expediteur = "morgan.ledortz@gmail.com";
		String username = "morgan.ledortz";
		String password = "motdepasse"; // Pour des raisons de sécurité je ne mets pas mon mot de passe, je pourrai faire une démo avec lundi

		// Instancier un client avec ces valeurs
		CompteCourant cc1 = new CompteCourant(id, numeroCompte, solde, decouvert);

		// Appel de la méthode service
		int verif = ccService.updateCompteCourantService(cc1);

		if (verif != 0) {

			if (req.getParameter("bouton") != null)
				try {
					envoyerMail.sendEmail(expediteur, username, password, destinataire, sujet, message);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			// Récupérer la liste modifiée
			List<CompteCourant> liste = ccService.getAllCompteCourantService();

			// Ajouter la liste comme attribut de la requete
			// Passer de la Servlet à la JSP
			req.setAttribute("ccs", liste);

			// Recuperer le support de délégation

			RequestDispatcher rd = req.getRequestDispatcher("/listeCC.jsp");

			// Envoyer la requete
			rd.forward(req, resp);

		} else {
			req.setAttribute("erreur", verif);

			// Recuperer le support de délégation
			RequestDispatcher rd = req.getRequestDispatcher("/modifCC.jsp");

			// Envoyer la requete
			rd.forward(req, resp);
		}

	}
}
