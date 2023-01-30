package fr.dawan.javafonctionnelle;

@FunctionalInterface
public interface ICalcul {
	
	//Une interface: une pseudo classe abstraite qui ne contient que des singnatures de méthodes
	//Elle peut contenir des méthodes implémentées par defaut et des méthodes static
	
	int add(int a, int b);
	//int multiply(int a, int b); une interface fonctionnelle ne peut contenir qu'une seule méthode non implémentée
	
	default void MethodeDefault() {};
	static void MethodeStatic() {};

}
