package fr.dawan.dependency.relation;

/*
 * Dépendence de type relation: le niveau le plus faible de couplage
 * Couplage limité dans le temps => réduite à l'exécution de la methodB - B utilise de manière
 * temporaire l'objet A
 * 
 */

public class B {
	
	//Pas d'attribut de type A
	
	public void methodB(A a) {
		a.methodA();
	}

}
