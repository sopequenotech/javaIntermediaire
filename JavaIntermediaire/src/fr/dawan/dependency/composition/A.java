package fr.dawan.dependency.composition;

/*
 * Dependence de type composition/agrégation:
 * - Un type appartient à l'autre
 * - Nous impose le fait de connaitre comment instancier l'objet interne b
 * - Ajout de la responsabilité de création et de suppression pour la classe A
 * 
 */
public class A {
	
	private B b;
	
	public A() {
		//A doit connaitre le process de construction de B
		this.b = new B("......");
	}
	
	public void doSomething() {
		if(b == null)
			b = new B(".....");
		b.MethodB();
	}

}
