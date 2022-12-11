package SwingJTable;

import java.util.ArrayList;

public class Main {
	
	Jmenu menu;
	
	public void viewgoods(){
		Goods_DAO dao = new Goods_DAO();
		ArrayList<Goods> goods = dao.viewGoodssArrays();
		menu.view.setForm(goods);
	}
	
	Main(){
		menu = new Jmenu(this);
		menu.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Main();
	}

}
