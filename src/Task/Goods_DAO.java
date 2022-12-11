package Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jtablemodel.Ex12Car;
import jtablemodel.Ex12ConnectionFactory;

public class Goods_DAO {
	
	public ArrayList<Goods> viewGoodssArrays() {
		System.out.println("View goods");
		ArrayList<Goods> goods = null;
		
		Object[][] data = {
				
			    {new Integer(1),"Coke can", new Double(15.0), new Integer(0), new Double(0.0)},
			    
			    {new Integer(2),"Fanta 1.5 Litre",new Double(25.0), new Integer(0), new Double(0.0)},
			    
			    {new Integer(3),"Soap Parrot",new Double(20.0), new Integer(0), new Double(0.0)},
			    
			    {new Integer(4),"Orange Jam",new Double(35.0), new Integer(0), new Double(0.0)},
			    
		        };
		
		goods = new ArrayList<Goods>();
		
		for(Object[] row : data) {
			
			int id = ((Integer)row[0]).intValue();
			String name = ((String)row[1].toString());
			double price = ((Double)row[2]).doubleValue();
			int qty = ((Integer)row[3]).intValue();
			double amount = ((Double)row[4]).doubleValue();
			Goods good = new Goods(id, name, price,qty,amount);
			goods.add(good);
			System.out.println(good.toString());
		}
		
		return goods;
	}
	
	public ArrayList<Goods> viewGoods() {
		System.out.println("View goods");
		ArrayList<Goods> goods = null;
		
		try {
			String viewSql = "SELECT * FROM test";
			System.out.println("selectSql:" + viewSql);
			
			goods = new ArrayList<Goods>();

			Ex12ConnectionFactory connDB = new Ex12ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("goods");
					double price = rs.getDouble("price");
					int qty = rs.getInt("quantity");
					double amount = rs.getDouble("amount");
					Goods good = new Goods(id, name, price,qty,amount);
					goods.add(good);
					System.out.println(good.toString());
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return goods;
	}
	
	public void editGoods(Goods goods) {
		System.out.println("Edit goods");
		try {
			String updateSql = "UPDATE `test` SET `quantity` = "+goods.qty+", `amount` = "+goods.amount+" WHERE `test`.`id` ="+goods.id+"";
			System.out.println("updateSql:" + updateSql);

			Ex12ConnectionFactory connDB = new Ex12ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Goods updated successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deletegoods(int id) {
		
		System.out.println("Delete goods");
		try {
			String deleteSql = "DELETE FROM test WHERE id="+id+"";
			System.out.println("DeleteSql: "+deleteSql);
			Ex12ConnectionFactory connDB = new Ex12ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(deleteSql);
				stmnt.close();
				con.close();
				System.out.println("Goods delete successfully.");
			}
			
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
