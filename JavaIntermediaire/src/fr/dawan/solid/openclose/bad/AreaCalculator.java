package fr.dawan.solid.openclose.bad;

/*
 * Open/Close: une classe doit être ouverte à l'extension et fermée à la modification
 * 
 * Ouverte à l'extension - mais elle n'est pas fermée à la modification
 * L'ajout d'une nouvelle classe Triangle implique la modification du code de cette classe
 *  ---- Ajouter une nouvelle méthode
 * 
 * Ne respecte pas le principe de Open/Close
 */

public class AreaCalculator {
	
	public double calculRectangleArea(Rectangle rec) {
		return rec.getWidth() * rec.getLegth();
	}
	
	public double calculCircleArea(Circle c) {
		return Math.PI * Math.pow(c.getRaduis(), 2);
	}
	
	public double calculTriangleArea(Triangle t) {
		return 0;
	}
	

}
