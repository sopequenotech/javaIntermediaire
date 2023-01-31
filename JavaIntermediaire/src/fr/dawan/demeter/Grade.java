package fr.dawan.demeter;

import java.util.List;

public class Grade {
	
	private List<StudentClass> classes;

	public List<StudentClass> getClasses() {
		return classes;
	}

	public void setClasses(List<StudentClass> classes) {
		this.classes = classes;
	}

	public int counStudents() {
		int count = 0;
		for(StudentClass classe : classes) {
			count = classe.counStudents();
		}
		
		return count;
	}
	
	

}
