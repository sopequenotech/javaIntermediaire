package fr.dawan.demeter;

import java.util.List;

public class StudentClass {
	
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int counStudents() {
		int count = 0;
		for(Student s : students) {
			count ++;
		}
		
		return count;
	}

}
