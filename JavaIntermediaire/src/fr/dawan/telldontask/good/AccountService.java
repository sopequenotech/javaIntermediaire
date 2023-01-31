package fr.dawan.telldontask.good;

public class AccountService {
	
	private IAccountRepository repo;
	
	
	public AccountService(IAccountRepository repo) {
		super();
		this.repo = repo;
	}

	/**
	 * 
	 * @param id
	 * @param amount
	 */

	public void withdraw(int id, double amount) {
		Account c = repo.getById(id);
		try {
			c.withdraw(amount); //Dites à vos objets ce qu'ils doivent faire - pas de questions sur leur état
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		repo.save(c);
	}

}
