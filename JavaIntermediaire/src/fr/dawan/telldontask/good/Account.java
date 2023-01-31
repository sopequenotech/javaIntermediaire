package fr.dawan.telldontask.good;

public class Account {
	private int id;
	private double balances;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balances;
	}
	public void setBalance(double balance) {
		this.balances = balance;
	}
	public void withdraw(double amount) throws IllegalAccessException {
		if(balances < amount)
			throw new IllegalAccessException();
		balances -= amount;
		
	}
	
}
