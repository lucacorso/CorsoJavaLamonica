package diverlotto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

/**
 *
 * @author Domenico
 */
public class JDBCStatementCreateTable1 {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("inserire percorso file");
			// C:/Users/luca/Downloads/estrazionidellotto.csv
			String fileUrl = scanner.nextLine();
			try {
				// createDbUserTable();
				leggiFile(fileUrl);

				i = 20;
			} catch (Exception e) {
				// leggiFile(fileUrl);
				System.out.println("inserire percorso esatto");
			}
		}

	}

	private static void createDbUserTable() throws Exception {

		Connection dbConnection = null;
		Statement statement = null;
		ConnessioneDatabaseProperties Connessione = new ConnessioneDatabaseProperties();
		String tabelle[] = { "BA", "CA", "FI", "GE", "MI", "NA", "PA", "RM", "TO", "VE", "NZ" };
		String num = "1";

		for (int i = 0; i < tabelle.length; i++) {
			// for(int k=1;k<5;i++){

			String createTableSQL = "CREATE TABLE " + tabelle[i] + " ((ESTRAZIONE DATE, "
					+ "CONCORSO INTEGER NOT NULL AUTO_INCREMENT, " + tabelle[i] + "1" + " INTEGER, " + tabelle[i] + "2"
					+ " INTEGER, " + tabelle[i] + "3" + " INTEGER, " + tabelle[i] + "4" + " INTEGER, " + tabelle[i]
					+ "5" + " INTEGER, " + " PRIMARY KEY ( ESTRAZIONE ))";

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
	// }

	public static void leggiFile(String fileUrl) throws Exception {
		List<String> lista = new ArrayList();
		Connection dbConnection = null;
		Statement statement = null;
		ConnessioneDatabaseProperties Connessione = new ConnessioneDatabaseProperties();
		File file = new File(fileUrl);
		FileReader in = new FileReader(file);
		BufferedReader buffereReader = new BufferedReader(in);
		String readLine = buffereReader.readLine();

		CSVReader reader = new CSVReader(buffereReader);
		String linea = readLine;
		while (linea != null) {

			String[] line = linea.split(";");

			// System.out.println(line[1]);
			
			PreparedStatement preparedStatement = null;
			PreparedStatement preparedStatement1 = null;
			for (int i = 0; i < 7; i++){
				
				String createTableSQL = "CREATE TABLE "+line[i+2]
						+ " ("+ line[0] +" DATE, "
						+ line[1] +" INTEGER NOT NULL AUTO_INCREMENT, "
						+ line[i+2] +" INTEGER, " 
						+ line[i+3]
						+ " INTEGER, " + line[i+4] + " INTEGER, " + line[i+5] + " INTEGER, " + line[i+6]
						+ " INTEGER, " + " PRIMARY KEY ( " + line[1]+ " ))";
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
					i=0;
				}
				// String
				// line[]={"BA","CA","FI","GE","MI","NA","PA","RM","TO","VE","NZ"};

				String InsertTableSQL = "INSERT INTO " + line[i] + 
						"(ESTRAZIONE,CONCORSO," + line[0] + "1"
						+ " INTEGER, " + line[i] + "2" + 
						" INTEGER, " + line[i] + "3" 
						+ " INTEGER, " + line[i] + "4"
						+ " INTEGER, " + line[i] + "5" 
						+ ") VALUES" 
						+ "(default,?,?,?,?,?,?,?)";

				dbConnection = DBUtilityConnection.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(InsertTableSQL);

				preparedStatement.setString(1, readLine);
				// preparedStatement.setInt(3, readLine);
				// preparedStatement.setInt(3, readLine);
				preparedStatement.setTimestamp(4, null);
				preparedStatement.executeUpdate();
				System.out.println("Record inserito nella tabella LOTTERIA!");

				readLine = buffereReader.readLine();
			}

			buffereReader.close();
		}
	}
}

// }
