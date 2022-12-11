package TestConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conncetionfactory {
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		String driverName = "com.mysql.jdbc.Driver";
		String connectionURL = "jdbc:mysql://202.28.34.205/db63011211066";
		String username = "63011211066";
		String password = "63011211066";

		System.out.println("-------- SQL JDBC Connection Testing ------");

		try {

			Class.forName(driverName);

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your  JDBC Driver?");
			e.printStackTrace();
		}

		Connection connection = null;
		System.out.println("ORACLE JDBC Driver Registered!");

		try {

			connection = DriverManager.getConnection(connectionURL, username, password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

		System.out.println("Connected to database");
		return connection;
	}
}
