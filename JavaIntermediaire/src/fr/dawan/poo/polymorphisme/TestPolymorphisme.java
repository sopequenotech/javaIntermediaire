package fr.dawan.poo.polymorphisme;

public class TestPolymorphisme {
	
	//Mise en place du polymorphisme dans une méthode
	
	//Polymorphisme par sous-typage
	
	public static void acheter(IPliable p) {
		p.deplier();
		p.plier();
	}
	
	//Polymorphisme Ad-Hoc: à éviter - nécessite un contrôle + un cast
	
	public static void acheter(Object obj) {
		
		if(obj instanceof IPliable) {
			IPliable i = (IPliable) obj;
			i.deplier();
			i.plier();
		}
	}
	
	//Polymorphisme par paramètre générique avec conditions sur le type générique
	public static <T extends IPliable> void acheterGen(T t) {
		t.deplier();
		t.plier();
	}

}
