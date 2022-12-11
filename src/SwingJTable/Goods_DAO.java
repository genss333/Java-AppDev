package SwingJTable;

import java.util.ArrayList;

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
			System.out.println(goods.toString());
		}
		
		return goods;
	}

}
