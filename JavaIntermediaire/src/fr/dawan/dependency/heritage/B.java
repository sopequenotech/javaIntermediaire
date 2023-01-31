package fr.dawan.dependency.heritage;

/*
 * Dependence de type héritage: niveau de couplage le plus fort
 * Pb: toute modification de la classe mère aura une incidence sur les classes filles
 * 
 */

public class B extends A{
	
	public B(int field1, int field2) {
		super(field1, field2);
		// TODO Auto-generated constructor stub
	}
	
}
