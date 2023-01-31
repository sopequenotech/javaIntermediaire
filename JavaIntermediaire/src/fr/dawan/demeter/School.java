package fr.dawan.demeter;

import java.util.List;

/*Demeter:
 * Une méthode d'une classe doit utiliser:
 * - ses paramètres
 * - ses variables
 * - les attributs de la classe
 * 
 * Une classe ne doit interagir qu'avec ses classe amies
 * 
 */

public class School {
	
	private List<Grade> grades;

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	//Méthode qui renvoie le nombre total de Student
	
	//Ne respecte pas Demeter - Elle fait appel à des classes étrangères
	
	public int countStudents() {
		int count = 0;
		for(Grade grade : grades) {
			for(StudentClass classe : grade.getClasses()) {
				for(Student s : classe.getStudents()) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public int countStudents2() {
		int count = 0;
		for(Grade grade : grades) {
			count = grade.counStudents();
		}
		
		return count;
	}

}
