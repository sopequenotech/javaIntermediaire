package fr.dawan.solid.interfacesegregation;

import java.time.LocalDate;
import java.util.List;

public interface IUser {

	List<User> getAll();
	void insert(User u);
	void update(User u);
	void delete(User u);
	LocalDate getDateEmbauche();
	String getContrtType();
}
/*
 * Cette interface liste les besoins de l'équipe persistence + les besoins de l'équipe rh
 * On doit découper cette inteface en petites orientées métier (applicationdu Single Of Responsability)
 * pour les interfaces
 * 
 * 
 */
