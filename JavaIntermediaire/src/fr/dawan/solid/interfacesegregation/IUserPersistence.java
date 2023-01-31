package fr.dawan.solid.interfacesegregation;

import java.util.List;

public interface IUserPersistence {

	List<User> getAll();
	void insert(User u);
	void update(User u);
	void delete(User u);
	User findByName(String name);
}
