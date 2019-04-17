package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Connexion à la base de données */

public class ConnectDB {
	//String url = "jdbc:mysql://localhost:3306/bank";
	String url = "jdbc:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String utilisateur = "root";
	String motDePasse = "Test1234";

	static Connection connexion = null;
	
	public ConnectDB() throws ClassNotFoundException {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

		} catch (SQLException e ) {

			e.printStackTrace();
		} 

	}
	public static Connection initConnection() throws ClassNotFoundException {
		if (connexion == null) {
			new ConnectDB();
		}
		return connexion;
	}

}