package fr.dawan.solid.dependencyinversion.bad;

public class ContactService {

	//Méthode qui applique un traitement sur un objet contact
	public Object computeContact(int id) {
		ContactRepository repo = new ContactRepository();
		 Contact c = repo.findById(id);
		 
		 //Traiter le contact
		 
		 return null;
	}
}
//Code sans dépendence