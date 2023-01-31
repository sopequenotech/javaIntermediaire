package fr.dawan.telldontask.bad;

public class AccountService {
	
	private AccountRepository repo;
	
	public void withdraw(int id, double amount) {
		Account c = repo.getById(id);
		if(c.getBalance() < amount) {
			throw new IllegalArgumentException("Error: not enough money");
		}
		c.setBalance(c.getBalance() - amount);
		repo.save(c);
	}

}
