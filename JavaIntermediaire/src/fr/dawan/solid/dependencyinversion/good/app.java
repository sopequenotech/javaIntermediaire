package fr.dawan.solid.dependencyinversion.good;

public class app {

	public static void main(String[] args) {
		
		//Injection via le constructeur
		ContactService service = new ContactService(new ContactRepository());
		service.computeContact(1);
		
		//Pour changer de dependence (de repo), on doit instanccier un nouveau service
		service= new ContactService(new ContactFichierRepository());
		service.computeContact(1);
		
		
		//Injection via les params de la méthode
		
		service.computeContact(10, new ContactFichierRepository());
		service.computeContact(10, new ContactRepository());
		
		//Injection via le setteur
		ContactService service2 = new ContactService();
		service2.setRepo(new ContactRepository());
		service2.computeContact(10);
	}
}
