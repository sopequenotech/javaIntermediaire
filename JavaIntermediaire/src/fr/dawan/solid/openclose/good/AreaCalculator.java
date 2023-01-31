package fr.dawan.solid.openclose.good;

/*
 * Classe qui respecte le Open/Close
 * Solution: utilisation du polymorphisme
 * 
 * 
 */
public class AreaCalculator {

	public double areaCalculator(IForme forme) {
		return forme.calculArea();
	}
}
