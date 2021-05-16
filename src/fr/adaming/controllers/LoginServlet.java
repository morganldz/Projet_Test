package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;
import fr.adaming.entities.CompteEpargne;
import fr.adaming.entities.Personne;
import fr.adaming.service.PersonneServiceImpl;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteCourantService;
import fr.adaming.service.ICompteEpargneService;
import fr.adaming.service.IPersonneService;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Traduire l'association UML en Jva
		IPersonneService pService = new PersonneServiceImpl();
		IClientService cService = new ClientServiceImpl();
		ICompteCourantService ccService = new CompteCourantServiceImpl();
		ICompteEpargneService ceService = new CompteEpargneServiceImpl();

		// Récuperer les params de la requette http
		String mail = req.getParameter("pMail");
		String mdp = req.getParameter("pMdp");

		// Instancier un formateur avec ces deux valeurs
		Personne personne = new Personne(mail, mdp);

		// Appel de la méthode service pour recuperer le formateur de la bd
		Personne pOut = pService.seConnecter(personne);

		if (pOut != null) {
			// Récupérer la liste des clients
			List<Client> list = cService.getAllClientService();
			List<CompteCourant> list1 = ccService.getAllCompteCourantService();
			List<CompteEpargne> list2 = ceService.getAllCompteEpargneService();
			
			req.setAttribute("clients", list);
			req.setAttribute("ccs", list1);
			req.setAttribute("ces", list2);
			
			// Ouvrir une session http
			HttpSession session =req.getSession();
			
			// Ajouter le formateur connecté dans la session
			session.setAttribute("pSession", pOut);

			// Récupérer le support de la délégation
			RequestDispatcher rd = req.getRequestDispatcher("/accueil.jsp");

			// Deleguer la requette http
			rd.forward(req, resp);

		} else {

			// Message d'erreur
			String message = "Erreur de connexion";

			// Ajouter le message comme un attribut de la req afin de le transférer vers la
			// jsp
			// Mettre le modèle MVC et la vue MVC en relation
			// (le message dans ce cas joue le rôle du modèle MVC)
			req.setAttribute("msg", message);

			// Récupérer le support de la délégation
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");

			// Deleguer la requette http
			rd.forward(req, resp);

		}
	}

}
