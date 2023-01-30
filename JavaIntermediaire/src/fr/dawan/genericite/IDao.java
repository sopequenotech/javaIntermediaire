package fr.dawan.genericite;

import java.util.List;

public interface IDao<T> {
	
	void insert(T obj);
	void delete(T obj);
	void update(T obj);
	List<T> getAll();

}
