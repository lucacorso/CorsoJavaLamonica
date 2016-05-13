package diverlotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilityConnection {
	public static Connection getDBConnection() throws Exception {
		PropertiesManagement propertiesManagement = new PropertiesManagement();
		Connection dbConnection = null;

		try {

			Class.forName(propertiesManagement.getDBDriver());

		} catch (ClassNotFoundException e) {
			throw new Exception(e.getMessage());
		}

		try {

			dbConnection = DriverManager.getConnection(
					propertiesManagement.getDBConnection(), 
					propertiesManagement.getDBUsername(), 
					propertiesManagement.getDBPassword());
			return dbConnection;

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
