package fr.dawan.reflexion;

public class Employe extends Object{
	
	private String nom;
	private String prenom;
	
	public Employe() {
		
		this.nom = "Dawan";
		this.prenom = "Jehann";
	}

	public Employe(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void identite() {
		System.out.println(nom+" "+prenom);
	}

}
