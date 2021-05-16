package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Personne;

public class ClientDaoImpl implements IClientDao {

	// Déclaration des infos de la connexion à la BD
	public static final String URL = "jdbc:mysql://localhost:3306/db_projet_jdbc";
	public static final String USER = "root";
	public static final String MDP = "root";
	
	private Connection cx = null;
	private PreparedStatement ps = null;
	
	@Override
	public int addClientDao(Client cl) {

		try {
			// Etape 1 : Chargement du pilote dans la mémoire
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Ouvrir une connexion à la BD
			cx = DriverManager.getConnection(URL, USER, MDP);
			
			// Etape 3 : Construire la requete SQL
			String req = "INSERT INTO clients (nom_cl, prenom_cl, adresse_cl, code_postal_cl, ville_cl, telephone_cl) VALUES (?,?,?,?,?,?)";
			
			// Etape 4-a) Creation d'un objet Prepared Statement
			ps = cx.prepareStatement(req);
			
			// Etape 4-b) Passage des paramètres de la requete
			ps.setString(1, cl.getNom());
			ps.setString(2, cl.getPrenom());
			ps.setString(3, cl.getAdresse());
			ps.setInt(4, cl.getCodePostal());
			ps.setString(5, cl.getVille());
			ps.setString(6, cl.getTelephone());
			
			// Etape 4-c) et 5 : Envoi de la requete et récuperation du resultat
			int verif = ps.executeUpdate();
			
			// Etape 6 : Exploitation du résultat
			return verif;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			// Fermer les flux
			try {
				// Fermer le statement
				if (ps != null) {
					ps.close();
				}

				// Fermer la connexion
				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
		
	}

	@Override
	public int updateClientDao(Client cl) {
		
		try {
			// Etape 1 : Chargement du pilote dans la mémoire
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Ouvrir une connexion à la BD
			cx = DriverManager.getConnection(URL, USER, MDP);
			
			// Etape 3 : Construction de la requete SQL
			String req = "UPDATE clients SET nom_cl=?, prenom_cl=?, adresse_cl=?, code_postal_cl=?, ville_cl=?, telephone_cl=? WHERE id_cl=?";
			
			// Etape 4-a) : Construction d'un objet de type prepared statement
			ps = cx.prepareStatement(req);
			
			// Etape 4-b) : Passage des paramètres de la requete
			ps.setString(1, cl.getNom());
			ps.setString(2, cl.getPrenom());
			ps.setString(3, cl.getAdresse());
			ps.setInt(4, cl.getCodePostal());
			ps.setString(5, cl.getVille());
			ps.setString(6, cl.getTelephone());
			ps.setInt(7, cl.getIdCl());
			
			// Etape 4-c) et 5 : Envoi de la requete et récuperation du resultat
			int verif = ps.executeUpdate();
			
			return verif;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			// Fermer les flux
			try {
				// Fermer le statement
				if (ps != null) {
					ps.close();
				}

				// Fermer la connexion
				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public int deleteClientDao(int id) {
		try {
			// Etape 1 : Chargement du pilote dans la mémoire
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Etape 2 : Ouvrir une connection à la bd
			cx = DriverManager.getConnection(URL, USER, MDP);

			// Etape 3 : Construire la SQL pour modifier étudiant avec id
			String req = "DELETE FROM clients WHERE id_cl=?"; // Index à chaque point d'interrogation qui commence par 1

			// Etape 4 et 5 : Envoyer la requete SQL à la BD et récupérer le résultat
			// 4-a : Recuperer un objet de type prepareStatement afin d'envoyer la requete
			ps = cx.prepareStatement(req);

			// 4-b : Passage des paramètres de la requete SQL
			ps.setInt(1, id);
			
			// 4-c et 5 : Envoyer la requete concretement et récupérer le résultat
			int verif = ps.executeUpdate(); // Pas d'argument en entrée car la requete est déjà passée

			// Etape 6 : Exploitation du résultat
			return verif;
			
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		} finally {

			// Fermer les flux
			try {
				// Fermer le statement
				if (ps != null) {
					ps.close();
				}

				// Fermer la connexion
				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Client> getAllClientDao() {
		try {
			// Etape 1 : Chargement du pilote dans la mémoire
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Etape 2 : Ouvrir une connection à la bd
			cx = DriverManager.getConnection(URL, USER, MDP);

			// Etape 3 : Construire la SQL pour modifier client avec id
			String req = "SELECT id_cl, nom_cl, prenom_cl, adresse_cl, code_postal_cl, ville_cl, telephone_cl FROM clients"; // Index à chaque point d'interrogation qui commence par 1

			// Etape 4 et 5 : Envoyer la requete SQL à la BD et récupérer le résultat
			// 4-a : Recupération d'un objet de type Prepared Statement
			ps = cx.prepareStatement(req);
			
			// 4-b et 5 : Envoyer la requete concretement et récupérer le résultat
			ResultSet rs = ps.executeQuery();

			// Etape 6 : Exploitation du résultat
			List<Client> listeOut = new ArrayList<>();
			
			// Transformer le ResultSet en list d'étudiant
			while (rs.next()) // next() Moves the cursor forward one row from its current position et retourne un boolean
			{
				// Récupérer les valeurs de l'enregistrment de l'ittération actuelle
				int idOut = rs.getInt("id_cl");
				String nomOut = rs.getString("nom_cl");
				String prenomOut = rs.getString("prenom_cl");
				String adresseOut = rs.getString("adresse_cl");
				int codePostalOut = rs.getInt("code_postal_cl");
				String villeOut = rs.getString("ville_cl");
				String telephoneOut = rs.getString("telephone_cl");
				
				// Instanciation etudiant à partir de ces valeurs
				Client cOut = new Client (idOut, nomOut, prenomOut, adresseOut, codePostalOut, villeOut, telephoneOut);
				
				// Ajouter cet étudiant dans la liste pour ne pas l'écraser pendant l'ittération suivante
				listeOut.add(cOut);
				
				// listeOut.add(new Etudiant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			return listeOut;            
					
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		} finally {

			// Fermer les flux
			try {
				// Fermer le statement
				if (ps != null) {
					ps.close();
				}

				// Fermer la connexion
				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Client getClientByIdDao(int id) {
		try {
			// Etape 1 : Chargement du pilote dans la mémoire
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Etape 2 : Ouvrir une connection à la bd
			cx = DriverManager.getConnection(URL, USER, MDP);

			// Etape 3 : Construire la SQL pour modifier client avec id
			String req = "SELECT * FROM clients WHERE id_cl=?"; // Index à chaque point d'interrogation qui commence par 1

			// Etape 4 et 5 : Envoyer la requete SQL à la BD et récupérer le résultat
			// 4-a : Création d'un objet de type prepared Statement 
			ps = cx.prepareStatement(req);
			
			// 4-b : Assignation des paramètres s'il y en a 
			ps.setInt(1, id);
			
			// 4-c et 5 : Envoyer la requete concretement et récupérer le résultat
			ResultSet resultat = ps.executeQuery();

			// Etape 6 : Exploitation du résultat
			// Déplacer le curseur
			resultat.next(); // A ne pas oublier !!! Une seule ligne donc pas de while
			
			// Lire les valeurs de la ligne
			Client cOut = new Client(resultat.getInt("id_cl"), resultat.getString("nom_cl"), resultat.getString("prenom_cl"), resultat.getString("adresse_cl"), resultat.getInt("code_postal_cl"), resultat.getString("ville_cl"), resultat.getString("telephone_cl"));
			
			// Retourner cet étudiant
			return cOut;            
					
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		} finally {

			// Fermer les flux
			try {
				// Fermer le statement
				if (ps != null) {
					ps.close();
				}

				// Fermer la connexion
				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
		

}
