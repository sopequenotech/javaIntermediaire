package fr.dawan.solid.loskov.good;

public class app {

	public static void main(String[] args) {
		TransportationDevice parent = new Car();
		parent.startMoving();
		
		parent = new Bicycle();
		parent.startMoving();
		
		//Les objets enfants se comportent comme l'objet parent- Principe de Liskov respecté

	}

}
