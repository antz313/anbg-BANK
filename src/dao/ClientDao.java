package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import appli.model.Operations;
import appli.model.Comptes;
import appli.model.Count;
import appli.model.Person;
import appli.model.Region;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class ClientDao {

	public ClientDao() {
		
	}
	
	public ObservableList<Person> recupClient() {
		ObservableList<Person> listeClients = FXCollections.observableArrayList();
		 	try {
		 		Connection connexion = ConnectDB.initConnection();
		 		Statement state = connexion.createStatement();
		 		ResultSet resultat = state.executeQuery("SELECT * FROM clients");
		 		while (resultat.next()) {
		 			Person unClient = new Person(resultat.getInt("id_client"),resultat.getString("nom_client"),resultat.getString("prenom_client"),resultat.getString("adresse"),resultat.getString("ville"), resultat.getString("tel"), resultat.getString("email"));
		 		listeClients.add(unClient);
		 		}
		 	}
		 	catch (SQLException e) {
		 		e.printStackTrace();
		 		listeClients = null;
		 		return listeClients;
		 	} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return listeClients;
	}
	public ObservableList<Person> trouveClient() throws ClassNotFoundException {
		ObservableList<Person> listeClients2 = FXCollections.observableArrayList();
		 	try {
		 		Connection connexion = ConnectDB.initConnection();
		 		Statement state = connexion.createStatement();
		 		ResultSet resultat2 = state.executeQuery("SELECT * FROM clients WHERE nom_client LIKE '%%'");
		 		while (resultat2.next()) {
		 			Person unClient2 = new Person(resultat2.getInt("id_client"), resultat2.getString("nom_client"),resultat2.getString("prenom_client"),resultat2.getString("adresse"),resultat2.getString("ville"), resultat2.getString("tel"), resultat2.getString("email"));
		 		
		 			listeClients2.add(unClient2);
		 		}
		 	}
		 	catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		 
		return listeClients2;
	}
	public ObservableList<Comptes> recupComptes() {
		ObservableList<Comptes> listeComptes = FXCollections.observableArrayList();
		 	try {
		 		Connection connexion = ConnectDB.initConnection();
		 		Statement state = connexion.createStatement();
		 		ResultSet resultat3 = state.executeQuery("SELECT * FROM comptes");
		 		while (resultat3.next()) {
		 			Comptes unCompte = new Comptes(resultat3.getInt("id_compte"),resultat3.getString("proprietaire"),resultat3.getString("date_creation"),resultat3.getDouble("solde"),resultat3.getInt("limite_retrait"),resultat3.getString("num_compte"));
		 		listeComptes.add(unCompte);
		 		}
		 	}
		 	catch (SQLException e) {
		 		e.printStackTrace();
		 		listeComptes = null;
		 		return listeComptes;
		 	} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return listeComptes;
	}
	
	public ObservableList<Comptes> trouveComptes() throws ClassNotFoundException {
		ObservableList<Comptes> listeComptes = FXCollections.observableArrayList();
		 	try {
		 		Connection connexion = ConnectDB.initConnection();
		 		Statement state = connexion.createStatement();
		 		ResultSet resultatCpte = state.executeQuery("SELECT * FROM comptes WHERE id_compte LIKE '%%'");
		 		while (resultatCpte.next()) {
		 			Comptes unCompte = new Comptes(resultatCpte.getInt("id_compte"),resultatCpte.getString("proprietaire"),resultatCpte.getString("date_creation"),resultatCpte.getDouble("solde"),resultatCpte.getInt("limite_retrait"), resultatCpte.getString("num_compte"));

		 			listeComptes.add(unCompte);
		 		}
		 	}
		 	catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		 
		return listeComptes;
	}

	public ObservableList<Operations> recupOperations() {
		ObservableList<Operations> listeOpe = FXCollections.observableArrayList();
		try {
			Connection connexion = ConnectDB.initConnection();
			Statement state = connexion.createStatement();
			ResultSet resultatOpe = state.executeQuery("SELECT * FROM operations");
			while (resultatOpe.next()) {
			Operations uneOperation = new Operations(resultatOpe.getInt("id_operation"), resultatOpe.getInt("debit_credit"), resultatOpe.getDouble("montant"), resultatOpe.getString("date_operation"),resultatOpe.getInt("id_compte"));
				listeOpe.add(uneOperation);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			listeOpe = null;
			return listeOpe;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeOpe;
	}
	
		
	public ObservableList<Count> trouveRegion(int departement) {
		ObservableList<Count> listeRegion = FXCollections.observableArrayList();
		
		int dpt = departement;
		try {
			Connection connexion = ConnectDB.initConnection();
			Statement state = connexion.createStatement();
			ResultSet resultatRegion = state.executeQuery("SELECT r.ville,t.nom_type,COUNT(c.id_type) as nbre FROM region as r, comptes as c, typecompte as t WHERE c.id_region = r.id_region AND c.id_type = t.id_type AND r.departement = '"+dpt+"'");
			while (resultatRegion.next()) {
			Count uneRegion = new Count(resultatRegion.getString("ville"), resultatRegion.getString("nom_type"), resultatRegion.getInt("nbre"));
				listeRegion.add(uneRegion);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			listeRegion = null;
			return listeRegion;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeRegion;
	}
	
	
	public Operations addOperation(String id_Compte, int type_Ope, String montant_Ope) {
		
		int idCompte = Integer.parseInt(id_Compte);
		int typeOpe = type_Ope;
		Double montantOpe = Double.parseDouble(montant_Ope);
		long millis = System.currentTimeMillis();
		Date dateCrea = new java.sql.Date(millis);
		try {
			Connection connexion = ConnectDB.initConnection();
			ObservableList<Comptes> tabComptes = recupComptes();
			for (Comptes Cpt: tabComptes) {
				if (idCompte == Cpt.getIdCompte()) {		
					if (typeOpe == 0) { 
						Double calcul = Cpt.getSolde() - montantOpe;	
						Statement state = connexion.createStatement();
							 		
						PreparedStatement opeAdd = connexion.prepareStatement("INSERT INTO `operations`(`id_operation`,`debit_credit`, `montant`, `date_operation`, `id_compte`) VALUES ( NULL, ?, ?, ?, ?)");	 	
						opeAdd.setInt(1, typeOpe);
						opeAdd.setDouble(2, montantOpe);
				 		opeAdd.setDate(3, dateCrea);
				 		opeAdd.setInt(4, idCompte);
				 		opeAdd.executeUpdate();
				 		
			            PreparedStatement opeDebit= connexion.prepareStatement("UPDATE `comptes` SET `solde` = ? WHERE `comptes`.`id_compte` = ?");
				 		opeDebit.setDouble(1, calcul);
				 		opeDebit.setInt(2, Cpt.getIdCompte());
			            opeDebit.executeUpdate();
					
					}else if(typeOpe == 1) {
						Statement state = connexion.createStatement();
						Double calcul2 = Cpt.getSolde() + montantOpe;
						
						PreparedStatement opeAdd = connexion.prepareStatement("INSERT INTO `operations`(`id_operation`,`debit_credit`, `montant`, `date_operation`, `id_compte`) VALUES ( NULL, ?, ?, ?, ?)");	 	
						opeAdd.setInt(1, typeOpe);
						opeAdd.setDouble(2, montantOpe);
				 		opeAdd.setDate(3, dateCrea);
				 		opeAdd.setInt(4, idCompte);
				 		opeAdd.executeUpdate();
				 		
			            PreparedStatement opeDebit= connexion.prepareStatement("UPDATE `comptes` SET `solde` = ? WHERE `comptes`.`id_compte` = ?");
				 		opeDebit.setDouble(1, calcul2);
				 		opeDebit.setInt(2, Cpt.getIdCompte());
			            opeDebit.executeUpdate();
					}
				}
			}
		}catch(Exception e) {		
		}						
		return null;		
		}
}
