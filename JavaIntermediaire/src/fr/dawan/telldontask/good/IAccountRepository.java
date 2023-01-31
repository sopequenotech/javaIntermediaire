package fr.dawan.telldontask.good;

public interface IAccountRepository {
	
	Account getById(int id);
	void save(Account c);

}
