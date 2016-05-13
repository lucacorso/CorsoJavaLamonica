package diverlotto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Domenico
 */
public class JDBCStatementCreateTable {
	public static void main(String[] args) throws Exception {
		try {
selectDbUserTable();
			
			
//			createDbUserTable();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}private static void selectDbUserTable() throws Exception {

		Connection dbConnection = null;
		Statement statement = null;
		ConnessioneDatabaseProperties Connessione=new ConnessioneDatabaseProperties();
		
		 String selectTableSQL = "SELECT * FROM CA";
                 

		 
		try {
		
			
			dbConnection =DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(selectTableSQL);

			statement.execute(selectTableSQL);

			System.out.println("è VUOTO");

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	

	private static void createDbUserTable() throws Exception {

		Connection dbConnection = null;
		Statement statement = null;
		ConnessioneDatabaseProperties Connessione = new ConnessioneDatabaseProperties();

		String createTableSQL = "CREATE TABLE IF NOT EXISTS CA" + "(ID INTEGER NOT NULL AUTO_INCREMENT, "
				+ " NOME VARCHAR(255), " + " COGNOME VARCHAR(255), " + " ETA INTEGER, " + " PRIMARY KEY ( id ))";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(createTableSQL);

			statement.execute(createTableSQL);

			System.out.println("Tabella creata con successo!");

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	
}
