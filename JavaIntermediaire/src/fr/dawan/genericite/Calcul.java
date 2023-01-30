package fr.dawan.genericite;

/*On peut ajouter des contraintes au type T: Calcul<T extends Produit> - T classe enfant de Produit
/											: Calcul<T super Produit> - T classe parent de Produit
/											: Calcul<T extends IProduit> - T classe qui implémente IProduit

 */

public class Calcul<T> {

	public T a;
	public T b;
	
	public void swap() {
		T c = a;
		a = b;
		b = c;
	}
}
