package fr.dawan.dependency.association;

/*
 * Dépendence de type Association:
 * - A n'a pas besoin de connaitre le process de création de l'objet B
 * - Moins de responsabilités pour la classe A
 * 
 */

public class A {
	
	private B b;
	
	public A(B b) {
		this.b = b;
	}
	
	public void method1() {
		//Pas besoin de vérifier si b est instancié - A n'est pas responsable de son cycle de vie
		b.method1();
	}

}
