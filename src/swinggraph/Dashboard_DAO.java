package swinggraph;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class Dashboard_DAO {
	public static Vector<DashBar> BarChart()throws SQLException, ClassNotFoundException {
		System.out.println("BARCHART");
		Vector<DashBar > dashboard = new Vector();
		try {
			String sql = "SELECT SUM(total) total , product_id FROM cart GROUP BY product_id";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) { 
					int id = rs.getInt("product_id");
					int total = rs.getInt("total");
					DashBar das = new DashBar(id, 0, total);
					System.out.println(das.toString());
					dashboard.add(das);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid plate");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dashboard;
	}
	
	public static Vector<DashBar> LineChart()throws SQLException, ClassNotFoundException {
		System.out.println("LINECHART");
		Vector<DashBar > dashboard = new Vector();
		try {
			String sql = "SELECT SUM(quantity) quantity , product_id FROM cart GROUP BY product_id";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) { 
					int id = rs.getInt("product_id");
					int qty = rs.getInt("quantity");
					DashBar das = new DashBar(id, qty, 0);
					System.out.println(das.toString());
					dashboard.add(das);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid plate");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dashboard;
	}

}
