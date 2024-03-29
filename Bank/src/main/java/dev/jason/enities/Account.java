package dev.jason.enities;

public class Account {

	// Data Members
	private String name;
	private float balance;
	private int userid;
	private int id;

	// CTOR
	public Account() {};
	public Account(String accountname, float accountbalance, int userid) {
		this.setName(accountname);
		this.setBalance(accountbalance);
		this.setUserid(userid);
	}
	
	// Getter and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		if (balance < 0) 
			this.balance = 0.0f;
		else
			this.balance = balance;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance + ", userid="
				+ userid + ", id=" + id + "]";
	}

	
}
