/**
 * 
 */
package diverlotto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultButtonModel;

/**
 * @author franksisca
 *
 */
public class ReadTableName {

	private static final String CR = "\n";
	private static final String LINE = ",";
	private static final Object INTEGER = " INTEGER NOT NULL ";
	private static final Object KEY = " PRIMARY KEY ";
	private static final Object VAR = " VARCHAR(255) ";
	private static final Object DAT = " DATE ";

	public static void main(String[] args) throws Exception {

//		List<String> leggiFile = leggiFile(ReadTableName.class.getResource("/estrazionidellotto.csv").getPath());
//
//		String firstRow = leggiFile.get(0);
//		String[] splitRow = firstRow.split(";");
		//createTableScript(splitRow);
		// stampo un campo della riga
		// System.out.println(splitRow[4].toString());

//		String otherRow = "";
//		for (int i = 1; i < leggiFile.size(); i++) {
//
//			otherRow = leggiFile.get(i);
//			if (!otherRow.isEmpty()) {
//
//				String[] splitOtheRow = otherRow.split(";");
//
//				insertimento(splitOtheRow, splitRow);
//
//				for (String elem : splitOtheRow) {
//					//
//					System.out.print(elem + " ");
//				}
//
//				System.out.println("");
			
		
		
	

		for (int i = 0; i < 2000; i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("--------------------DIVERLOTTO----------------");
			System.out.println("cosa vuoi fare?");
			System.out.println("1-Crea tabella");
			System.out.println("2-Inserisci tabella");
			System.out.println("3-Dato un numero, verificare per ogni tabella da quanto tempo non viene estratto");
			System.out.println("4-il numero col maggior ritardo di estrazione per ogni singola tabella");
			System.out.println("5-dati due numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione");
			System.out.println("6-dati quattro numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione");
			System.out.println("7-dati cinque numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione");
			System.out.println("8-Giocare scommessa");
			System.out.println("9-dati due numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione");
		
			System.out.println("10-Esci");
          
			
			
			
			int scelta = scanner.nextInt();
			switch (scelta) {
			case 1:
				List<String> leggiFile = leggiFile(ReadTableName.class.getResource("/estrazionidellotto.csv").getPath());

				String firstRow = leggiFile.get(0);
				String[] splitRow = firstRow.split(";");
				createTableScript(splitRow);
				System.out.println("per tornare al menu:1");
				System.out.println("per chiudere applicazione: 9");
				Scanner scanner4 = new Scanner(System.in);
				int scelta1 = scanner4.nextInt();
				if (scelta1 == 1) {
					break;
				} else {
					i = 2000;
					
					break;
				}
			case 2:
				List<String> leggiFile1 = leggiFile(ReadTableName.class.getResource("/estrazionidellotto.csv").getPath());
				String firstRow1 = leggiFile1.get(0);
				String[] splitRow1 = firstRow1.split(";");
				
				String otherRow1 = "";
				for (int k = 1; k < leggiFile1.size(); k++) {

					otherRow1 = leggiFile1.get(k);
					if (!otherRow1.isEmpty()) {

						String[] splitOtheRow1 = otherRow1.split(";");

						insertimento(splitOtheRow1, splitRow1);

						for (String elem : splitOtheRow1) {
							//
							System.out.print(elem + " ");
						}

						System.out.println("");

					}
					System.out.println("per tornare al menu:1");
					System.out.println("per chiudere applicazione: 9");
				Scanner scanner5 = new Scanner(System.in);
				int scelta2 = scanner5.nextInt();
				if (scelta2 == 1) {
					break;
				} else {
					k = 2000;
					break;
				}
				}
			case 3:
				List<String> leggiFile2 = leggiFile(ReadTableName.class.getResource("/estrazionidellotto.csv").getPath());
				String firstRow2 = leggiFile2.get(0);
				String[] splitRow2 = firstRow2.split(";");
				
				String otherRow2 = "";
				for (int m = 1; m < leggiFile2.size(); m++) {

					otherRow2 = leggiFile2.get(m);
					if (!otherRow2.isEmpty()) {

						String[] splitOtheRow2 = otherRow2.split(";");

						controlloEstr(splitOtheRow2, splitRow2);

						for (String elem : splitOtheRow2) {
							//
							System.out.print(elem + " ");
						}

						System.out.println("");

					}
				
				
				System.out.println("per tornare al menu:1");
				System.out.println("per chiudere applicazione: 9");
				Scanner scanner6 = new Scanner(System.in);
				int scelta3 = scanner6.nextInt();
				if (scelta3 == 1) {
					break;
				} else {
					i = 2000;
					break;
				}
				}
			
			case 10:
				System.out.println("SEI SICURO DI VOLER USCIRE???");
				System.out.println("per tornare al menu:1");
				System.out.println("per chiudere applicazione: 9");
				Scanner scanner7 = new Scanner(System.in);
				int scelta4 = scanner7.nextInt();
				if (scelta4 == 1) {

					break;
				
			} else {
				i = 2000;
		break;
			}
			}
		}			
			System.out.println("ARRIVEDERCI!!!!!");
	

}
	/**
	 * @param splitRow
	 * @throws Exception
	 */
	private static void createTableScript(String[] splitRow) throws Exception {
		Connection dbConnection = null;
		Statement statement = null;
		ConnessioneDatabaseProperties Connessione = new ConnessioneDatabaseProperties();

		String[] onlyTableName = Arrays.copyOfRange(splitRow, 2, splitRow.length);
		for (int i = 5; i <= onlyTableName.length; i += 5) {
			createSingleTableStatemente(splitRow[0], splitRow[1], Arrays.copyOfRange(onlyTableName, i - 5, i));
			// inserimentoTabella(splitRow[0], splitRow[1],
			// Arrays.copyOfRange(onlyTableName, i - 5, i));
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();

		}

	}

	/**
	 * @param string
	 * @param string2
	 * @param copyOfRange
	 * @throws Exception
	 */
	private static void createSingleTableStatemente(String firstColumn, String secondColumn, String[] parameters)
			throws Exception {
		Connection dbConnection = null;
		Statement statement = null;

		ConnessioneDatabaseProperties Connessione = new ConnessioneDatabaseProperties();
		// `

		StringBuilder script = new StringBuilder("CREATE TABLE IF NOT EXISTS `").append(parameters[0].substring(0, 2))
				.append("`" + CR).append("(").append(CR).append(firstColumn).append(DAT).append(LINE).append(CR)
				.append(secondColumn).append(INTEGER).append(LINE).append(CR);
		for (int i = 0; i < parameters.length; i++) {
			script.append(parameters[i]).append(INTEGER).append(LINE).append(CR);
		}
		script.append(KEY).append("(").append(firstColumn).append("))").append(CR);
		System.out.println(script);
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();
			statement.execute(script.toString());
			System.out.println("tabella creata!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void inserimentoTabella(String firstColumn, String secondColumn, String[] parameters, String nome)
			throws Exception {
		Connection dbConnection = null;
		Statement statement = null;

		SimpleDateFormat sd =new SimpleDateFormat("dd/MM/yyyy");
       Date data=sd.parse(firstColumn);	
       Timestamp timestamp=new java.sql.Timestamp(data.getTime());
      
       firstColumn=timestamp.toString();
		firstColumn=firstColumn.substring(0, 10);
       
		StringBuilder script = new StringBuilder("INSERT INTO `").append(nome).append("`").append("VALUES").append("(")
				.append("\"").append(firstColumn).append("\"").append(LINE).append(secondColumn).append(LINE);
		for (int i = 0; i < parameters.length; i++) {
			if (i == (parameters.length) - 1) {
				script.append(parameters[i]);
			} else {
				script.append(parameters[i]).append(LINE);
			}
		}
		script.append(");");
		System.out.println(script);

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();

			statement.execute(script.toString());

			System.out.println("CAMPI CREATI!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	private static void insertimento(String[] splitOtheRow, String[] splitRow) throws Exception {
		Connection dbConnection = null;
		Statement statement = null;

		String[] onlyTableName = Arrays.copyOfRange(splitOtheRow, 2, splitOtheRow.length);
		for (int i = 5; i <= onlyTableName.length; i += 5) {
			inserimentoTabella(splitOtheRow[0], splitOtheRow[1], Arrays.copyOfRange(onlyTableName, i - 5, i),
					splitRow[i].substring(0, 2));
            
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();
		}
		}

		private static void controlloEstr(String[] splitOtheRow, String[] splitRow) throws Exception {
//			Connection dbConnection = null;
//			Statement statement = null;

			String[] onlyTableName = Arrays.copyOfRange(splitOtheRow, 2, splitOtheRow.length);
			for (int i = 5; i <= onlyTableName.length; i += 5) {

				controlloEstrazione(splitRow[0], splitOtheRow[1], Arrays.copyOfRange(onlyTableName, i - 5, i),
						splitRow[i].substring(0, 2));
	            
//				dbConnection = DBUtilityConnection.getDBConnection();
//				statement = dbConnection.createStatement();

			}
	
	
		}

	private static List<String> leggiFile(String fileUrl) throws FileNotFoundException, IOException {
		List<String> lista = new ArrayList<String>();
		File file = new File(fileUrl);
		FileReader in = new FileReader(file);
		BufferedReader buffereReader = new BufferedReader(in);
		String readLine = buffereReader.readLine();
		while (readLine != null) {
			lista.add(readLine);
			readLine = buffereReader.readLine();

		}
		buffereReader.close();

		return lista;
	}
public static void controlloEstrazione(String firstColumn, String secondColumn, String[] parameters, String nome) throws Exception{
	Scanner k=new Scanner(System.in);
	Connection dbConnection = null;
	Statement statement = null;


	System.out.println("inserisci numero");
	int numero=k.nextInt();
	int n=1;
//	dbConnection = DBUtilityConnection.getDBConnection();
//	statement = dbConnection.createStatement();
	StringBuilder script = new StringBuilder("SELECT * FROM `").append(nome).append("`").append("WHERE ");
			for (int i = 0; i < parameters.length; i++) {
				script.append(nome+(n++));
				script.append("=");
	            script.append(numero);
				if (i == (parameters.length) - 1) {
					
					//script.append(parameters[i]);
					
				} else {
					script.append(" || ");
				}
			}
			script.append(" ORDER BY ").append(firstColumn).append(" desc limit 1");
			script.append(";");
			System.out.println(script);

			
			
			try {
				dbConnection = DBUtilityConnection.getDBConnection();
				statement = dbConnection.createStatement();
                 
				//System.out.println(statement.execute(script.toString()));
			
				//ResultSet executeQuery= statement.executeQuery("SELECT * FROM `BA` WHERE BA1=56 OR BA2=56 OR BA3=56 OR BA4=56 OR BA5=56;");
				ResultSet executeQuery= statement.executeQuery(script.toString());
				
				while(executeQuery.next()){
			//	System.out.println("ciao");
				  Date data1=executeQuery.getDate(1);
					
				  //int concorso=executeQuery.getInt(2);
//					int eta1=executeQuery.getInt(3);
//					int eta2=executeQuery.getInt(4);
//					int eta3=executeQuery.getInt(5);
//					int eta4=executeQuery.getInt(6);
//					int eta5=executeQuery.getInt(7);
					System.out.println(data1);
					
		
					
				

				
		
			}
				System.out.println("select eseguita!");
			}catch (SQLException e) {
				System.err.println(e.getMessage());
			}

			finally {
				if (statement != null) {
					statement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
			}
	
}
}
