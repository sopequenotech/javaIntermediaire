package fr.dawan.poo.polymorphisme;

import java.util.ArrayList;
import java.util.List;

public class app {

	public static void main(String[] args) {

		IPliable i = new Chaise();
		IPliable i2 = new Table();

		// Un objet de type IPliable peut prendre plusieurs formes.
		Object obj = 10;
		Object obj1 = true;
		Object obj2 = "test";

		// Collection polymorphique
		List<IPliable> lst = new ArrayList<>();
		lst.add(new Chaise());
		lst.add(new Table());
		lst.add(new Lit());

		TestPolymorphisme.acheter(new Chaise());
		TestPolymorphisme.acheter(new Table());
		TestPolymorphisme.acheter(new Lit());

		/////////////////////////////////
//		List<A> lstA = new ArrayList<>();
//		List<B> lstB = new ArrayList<>();
//		List<C> lstC = new ArrayList<>();
//		
		List<IVide> myList = new ArrayList<>();
		myList.add(new A());
		myList.add(new B());
		myList.add(new C());
		myList.add(new D());
		
		MyMethod(new A());
		MyMethod(new B());
		MyMethod(new C());
		MyMethod(new D());
		
		

	}

//	public static void methodA(A a) {
//
//	}
//
//	public static void methodB(B b) {
//
//	}
//
//	public static void methodC(C c) {
//
//	}
	
	public static void MyMethod(IVide i) {
		
	}

}
