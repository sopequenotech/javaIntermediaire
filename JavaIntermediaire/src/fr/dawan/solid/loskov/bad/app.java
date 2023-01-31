package fr.dawan.solid.loskov.bad;

public class app {

	public static void main(String[] args) {
		//Liskov Substitution: concerne l'héritage
		// Si un objet A se comporte comme un Objet B, alors A hérite de B
		//Liskov: les objets enfants sont substituables aux objets parents
		

		TransportationDevice parent = new TransportationDevice();
		parent.startEngine();
		
		parent = new Car();
		parent.startEngine(); //car se comporte comme parent, alors car hérite de parent
		
		parent = new Bicycle();
		parent.startEngine(); 
		//pas de moteur dans une Bicycle - Bicycle ne se comporte pas comme l'objet parent - héritage non justifié
		//Bicycle ne peut pas hériter de la classe TransportationDevice
		//Violation du principe de Liskov
		
		
	}

}
