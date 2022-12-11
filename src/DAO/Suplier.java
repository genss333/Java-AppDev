package DAO;

public class Suplier {
	int id;
	String name;
	String address;
	String tel;
	String email;
	
	
	public Suplier (int id,String name,String address,String tel,String email) {
		this.id=id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		
	}
	
	@Override
	public String toString() {
		return "Suplier [id=" + id + ", name=" + name + ", address=" + address + ", tel=" + tel + ", email=" + email
				+ "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
