package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
	//define the database properties
	private static String URL ="jdbc:mysql://localhost:3306/servlet_hibernate";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static Connection connection = null;
	
	//get the DB connection
	//define the static method
	public static Connection openConnection() {
		
		//check the connection
		if (connection != null) {
			return connection;
		} else {
			try {
				//load the driver
				Class.forName(DRIVER);
				
				//get the connection
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			//return connection
			return connection;
		}
	}
}
