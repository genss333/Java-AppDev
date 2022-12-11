package DAO;

public class DashBar {
	int good_id;
	int qty;
	int total;
	public DashBar(int good_id, int qty, int total) {
		super();
		this.good_id = good_id;
		this.qty = qty;
		this.total = total;
	}
	public int getGood_id() {
		return good_id;
	}
	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "DashBar [good_id=" + good_id + ", qty=" + qty + ", total=" + total + "]";
	}
	

}
