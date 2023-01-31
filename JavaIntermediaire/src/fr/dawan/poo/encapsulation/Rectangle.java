package fr.dawan.poo.encapsulation;

/*
 * L'accès aux attributs d'une classe objet, passe obligatoirement par les getteur/setteur
 * La modification de l'état d'un objet doit se faire via ses méthodes - 
 * L'objet est responsable de son état
 * Une classe doit masquer au maximum sa structure interne.
 * 
 * Remplacer les get/set par des méthodes orientées métier.
 */

public class Rectangle {

	//Les attributs représentent l'état de l'objet
	private double hauteur;
	private double lagreur;

	private double getHauteur() {
		return hauteur;
	}

	private void setHauteur(double hauteur) throws IllegalAccessException {
		if(hauteur <= 0)
			throw new IllegalAccessException("Hauteur doit être positive.");
		this.hauteur = hauteur;
	}

	private double getLagreur() {
		return lagreur;
	}

	private void setLagreur(double lagreur) {
		this.lagreur = lagreur;
	}

	public Rectangle(double hauteur, double lagreur) throws IllegalAccessException {
		super();
		setHauteur(hauteur);
		setLagreur(lagreur);
	}
	
	public void Redim(double hauteur, double largeur) throws IllegalAccessException {
		setHauteur(hauteur);
		setLagreur(largeur);
	}

	//A ne définir qu'en cas de besoin: des librairies externes qui exige un construteur par defaut
	public Rectangle() {
		super();
	}
	

}
