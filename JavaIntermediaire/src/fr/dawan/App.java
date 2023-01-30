package fr.dawan;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.dawan.genericite.Calcul;
import fr.dawan.genericite.Produit;
import fr.dawan.genericite.SerialTool;
import fr.dawan.genericite.Test;
import fr.dawan.javafonctionnelle.ICalcul;
import fr.dawan.javafonctionnelle.MyCalcul;
import fr.dawan.javafonctionnelle.MyClasse;
import fr.dawan.reflexion.Employe;

enum Genre {
	MASCULIN, FEMININ
}

class Personne {
	private String nom;
	private Genre genre;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Personne(String nom, Genre genre) {
		super();
		this.nom = nom;
		this.genre = genre;
	}

	public Personne() {
		super();
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", genre=" + genre + "]";
	}

}

public class App {

	public static void main(String... args) throws Exception {
		// Généricité:

		System.out.println("*****************GENERICITE************");

		Calcul<Integer> cal = new Calcul<>();
		cal.a = 10;
		cal.b = 20;
		cal.swap();

		Calcul<String> cal2 = new Calcul<>();
		cal2.a = "test";
		cal2.b = "test2";
		cal2.swap();

		Test t = new Test();
		t.Methode1();

		Test.Methode2();

		List<Produit> lst = new ArrayList<>();
		lst.add(new Produit(1, "PC Dell", 1500));
		lst.add(new Produit(2, "Ecran HP", 120));

		SerialTool.ExportXML(lst, "produits.xml");

		List<Produit> list = SerialTool.ImportXML("produits.xml");

		for (Produit p : list) {
			System.out.println(p.getDescription());
		}

		System.out.println("******************Reflexion******************");
		// Reflection - Introspection: mécanisme qui permet de découvrir des types et
		// d'invoquer
		// leur membres à l'exécution

		// 1- Récupérer le type de la classe
		Class<Employe> classEmp = Employe.class;

		System.out.println(">>> Méthodes de la classe Employe:");

		Method[] methods = classEmp.getMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
		}

		System.out.println(">>> Attributs de la classe Employe:");
		Field[] fields = classEmp.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName());
		}

		System.out.println(">>> Appel de la méthode Identite:");

		Method identiteMethode = classEmp.getMethod("identite", null); // méthode d'instance

		// Instancier la classe Employe en utilisant la reflection
		Employe e = classEmp.getDeclaredConstructor().newInstance(); // Utilisation du constructeur par defaut

		identiteMethode.invoke(e, null);

		Constructor<Employe> construtor = classEmp.getDeclaredConstructor(String.class, String.class);

		Employe e2 = construtor.newInstance("new name", " new prenom");

		System.out.println(">>> Rappel de la méthode identité:");
		identiteMethode.invoke(e2, null);

		System.out.println(">>>> Sérialisation CSV:");

		SerialTool.ExportCSV(lst, "produits.csv");
		List<Produit> prodCSV = SerialTool.ImportCSV("produits.csv", Produit.class);
		for (Produit p : prodCSV) {
			System.out.println(p.getDescription());
		}

		System.out.println(">>>>> Programmation fonctionnelle:");
		
		List<Personne> personnes = new ArrayList<>();
		personnes.add(new Personne("marc", Genre.MASCULIN));
		personnes.add(new Personne("mathilde", Genre.FEMININ));
		personnes.add(new Personne("jean", Genre.MASCULIN));
		personnes.add(new Personne("juliette", Genre.FEMININ));
		
		//Récupérer les personnes de sexe féminins:
		//approche impérative: on doit dire au compilateur ce qu'il doit faire et comment le faire
		
		System.out.println("Approche impérative:");
		List<Personne> feminins = new ArrayList<>();
		
		for(Personne p : personnes) {
			if(p.getGenre().equals(Genre.FEMININ)) {
				feminins.add(p);
			}
		}
		
		for(Personne p:feminins) {
			System.out.println(p.getNom());
		}
		
		//approche déclarative: on doit dire au compilateur ce qu'on souhaite obtenir sans lui dire comment 
		//le faire
		
		System.out.println("Approche déclarative:");
		personnes.stream()
		.filter(p -> p.getGenre().equals(Genre.FEMININ))
		.collect(Collectors.toList())
		.forEach(System.out::println);

		//Programmation fonctionnelle repose sur l'utilisation d'interfaces fonctionnelles.
		//Une interface fonctionnelle est une interface qui ne contient qu'une méthode à implémenter
		//Le package java.util.fonction contient toutes les interfaces fonctionnelles fournies depuis la 
		//version 1.8 de Java
		
		//Comment instancier une interface?
		
		//Option1: utiliser une classe qui implémente l'interface - classe concrète
		
		ICalcul ical = new MyCalcul();
		ical.add(10, 20);
		
		//Option2: utiliser une classe anonyme - très utilisée dans Android - les Threads
		
		ICalcul ical2 = new ICalcul() {
			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
		};
		ical2.add(10, 20);
		
		//Option3: utiliser les expressions Lambda : méthode anonyme
		
		ICalcul ical3 = (x,y) -> x+y;
		
		//Option4: method réference - faire réference à une méthode qui respecte la signature de la méthode abstraite
		//définie dans l'interface fonctionnelle
		
		MyClasse myClasse = new MyClasse();
		ICalcul ical4 = myClasse::InstanceMethode; //réference vers une méthode qui respecte la signature de la méthode abstraite
		
		ICalcul ical5 = MyClasse::StaticMethode;
		
		MyClasse.MyMethode(new ICalcul() {
			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return 15 ;
			}
		});

	}

}
