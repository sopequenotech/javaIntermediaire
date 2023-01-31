package fr.dawan.solid.singleofresponsability;

public class Employe {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employe(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
//	public void save(Employe e) {
//		//insértion en BDD
//	}
//	
//	public void delete(Employe e) {
//		//Suppression en BDD
//	}
	
//	public boolean hasPromotion() {
//		
//		//logic
//		return false;
//	}
	
	//Pb: classe avec plusieurs responsabilités - ne respect pas le Single Of Responsability
	/*
	 * Le code au sein d'une classe ne doit avoir qu'une seule responsabilité, qu'un seul type de tâche à effectuer
	 * Si vous prenez conscience que 2 tâches différentes sont effectuées, posez vous la question
	 * de savoir si vous devez scinder votre classe en 2.
	 * 
	 * Ce principe s'applique aux: packages, classes, méthodes
	 * Intérêt:
	 * - Meilleure organisation du code
	 * - Faible couplage
	 * - debug / testabilité
	 */

}
