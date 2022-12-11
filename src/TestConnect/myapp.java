package TestConnect;

import java.sql.Connection;
import java.sql.SQLException;


public class myapp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Conncetionfactory connDB = new Conncetionfactory();
		Connection con = connDB.getConnection();
	}
}
