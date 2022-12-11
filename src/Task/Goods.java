package Task;

public class Goods {
	
	int id;
	String gname;
	double price;
	int qty;
	double amount;
	public Goods(int id, String gname, double price, int qty, double amount) {
		super();
		this.id = id;
		this.gname = gname;
		this.price = price;
		this.qty = qty;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", gname=" + gname + ", price=" + price + ", qty=" + qty + ", amount=" + amount
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
