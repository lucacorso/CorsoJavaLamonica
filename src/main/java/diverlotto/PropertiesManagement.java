/**
 * Dear Maintainer:
 * 
 * When I wrote this code, only I and God knew what it was.
 * Now, only God knows!!!
 * 
 * So, if you are done trying to "optimeze" this routine (and failed), 
 * please increment the following counter as a warning to the next guy:
 * 
 * total_hours_wasted_here: 10
 * 
 */
package diverlotto;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;


/**
 * @author franksisca
 *
 */
public class PropertiesManagement {

	Properties prop;

	/**
	 * @throws IOException
	 * 
	 */
	public PropertiesManagement() {
		// TODO Auto-generated constructor stub
		try {
			prop = new Properties();
			System.out.println("Load properties...");
			InputStream in = PropertiesManagement.class.getClassLoader().getResourceAsStream("application.properties");
			prop.load(in);
			in.close();
			System.out.println("Properties has been loaded!");
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}


	public String getDBConnection() {
		System.out.println("Trying to load " + Constants.DB_CONNECTION + "...");
		if (prop.containsKey(Constants.DB_CONNECTION)) {
			System.out.println(Constants.DB_CONNECTION + " found!");
			return prop.getProperty(Constants.DB_CONNECTION);
		} else {
			System.out.println(Constants.DB_CONNECTION + " not found! Load DEFAULT_VALUE");
			return "NO_DB_CONNECTION";
		}
	}
	public String getDBUsername() {
		System.out.println("Trying to load " + Constants.DB_USERNAME + "...");
		if (prop.containsKey(Constants.DB_USERNAME)) {
			System.out.println(Constants.DB_USERNAME + " found!");
			return prop.getProperty(Constants.DB_USERNAME);
		} else {
			System.out.println(Constants.DB_USERNAME + " not found! Load DEFAULT_VALUE");
			return "root";
		}
	}
	public String getDBPassword() {
		System.out.println("Trying to load " + Constants.DB_PASSWORD+ "...");
		if (prop.containsKey(Constants.DB_PASSWORD)) {
			System.out.println(Constants.DB_PASSWORD + " found!");
			return prop.getProperty(Constants.DB_PASSWORD);
		} else {
			System.out.println(Constants.DB_PASSWORD + " not found! Load DEFAULT_VALUE");
			return "root";
		}
	}
	public String getDBDriver() {
		System.out.println("Trying to load " + Constants.DB_DRIVER + "...");
		if (prop.containsKey(Constants.DB_DRIVER)) {
			System.out.println(Constants.DB_DRIVER + " found!");
			return prop.getProperty(Constants.DB_DRIVER);
		} else {
			System.out.println(Constants.DB_DRIVER + " not found! Load DEFAULT_VALUE");
			return "com.mysql.jdbc.Driver";
		}
	}


}
