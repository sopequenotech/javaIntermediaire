package fr.dawan.solid.dependencyinversion.good;

public class ContactService {

	private IContactRepository repo;
	
	//Injection de dependence
	
	//Option1: injection via le constructeur
	//Avantage: on obtient un objet service dans un état stable
	//Inconvénient: impossible de changer de dépendence
	//La plus recommandée en pratique
	
	public ContactService(IContactRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Object computeContact(int id) {
		Contact c = repo.findById(id);
		//Appliquer un traitement sur le contact
		return null;
	}
	
	//Option2: injection de la dependence via les paramètres de la méthode
	//Avantage: possibilité de modifier la dependence en utilisant le mm objet
	//Incovénient: dependence à fournir à chaque appel de la méthode
	
	public Object computeContact(int id, IContactRepository repo) {
		Contact c = repo.findById(id);
		//Appliquer un traitement sur le contact
		return null;
	}


	public ContactService() {
		super();
	}
	//Option3: injection via le setteur
	//Avantage: possibilité de changer de dependence en utilisant le mm service
	//Inconvénient - contrainte: il faut s'assurer que la dependence à bien été injectée via le setteur
	//A ne pas utiliser sauf si on est contraint.
	
	public void setRepo(IContactRepository repo) {
		this.repo = repo;
	}

	
	
	


	
}
