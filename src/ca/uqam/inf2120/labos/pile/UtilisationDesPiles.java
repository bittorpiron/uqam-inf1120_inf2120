package ca.uqam.inf2120.labos.pile;

import ca.uqam.inf2120.labos.pile.tda.Pile;
import ca.uqam.inf2120.labos.pile.tda.impl.PileArrayListImpl;


/**
 * 	Utilisation des services de manipulation de Pile<T>.
 *               
 * 	UQAM  - INF2120
 * 
 * @author Gloire Lomani / Ismael Doukoure
 * @version Février 2014
 *
 */
public class UtilisationDesPiles {

	/**
	 * En utilisant les services de manipulation de Pile<T> vus en classe 
	 * et son implémentation en ArrayList (PileArrayListImpl<T>), écrire la méthode 
	 * supprimer qui reçoit en paramètres une pile de String, et un élément de type 
	 * String, et supprime l’élément de la pile.
	 *  - La méthode doit retourner la nouvelle pile obtenue après la suppression.
	 *  - Si l’élément à supprimer n’existe pas, la nouvelle pile retournée sera la même que 
	 *    celle passée en paramètre.
	 *  - Aucun doublon dans la pile passée en paramètre.
	 *  - La pile passée en paramètre doit rester inchangée après l’appel.
	 *  
	 * @param pile La pile dans laquelle la suppression doit se faire.
	 * @param s L'élément à supprimer.
	 * 
	 * @return La pile à retourner après suppression.
	 */
	public static Pile<String> supprimer(Pile<String> pile, String s) {
		
		Pile<String> pileRetour = null;

		if (pile != null && !pile.estVide() && s != null && !s.trim().isEmpty()) {

			Pile<String> temp = new PileArrayListImpl<String>();
			pileRetour = new PileArrayListImpl<String>();
			Pile<String> clone = new PileArrayListImpl<String>();
			String eltCourant;

			while (!pile.estVide()) {
				
				eltCourant = pile.depiler();
				clone.empiler(eltCourant);

				if (!eltCourant.equals(s)) {
					temp.empiler(eltCourant);
				} 

			}

			while (!temp.estVide()) {
				pileRetour.empiler(temp.depiler());
			}

			while (!clone.estVide()) {
				pile.empiler(clone.depiler());
			}
		}

		return pileRetour;

	}
	
	
	/**
	 * Tester la méthode supprimer.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Pile<String> pile = new PileArrayListImpl<String>();
		pile.empiler("A");
		pile.empiler("B");
		pile.empiler("C");
		pile.empiler("D");
		
		Pile<String> retour = supprimer(pile, "B");
		

		System.out.print("Pile Initial : ");
		while(!pile.estVide()) {
			System.out.print(pile.depiler() + " ");
		}
		
		System.out.print("\n\nPile retour : ");
		while(!retour.estVide()) {
			System.out.print(retour.depiler() + " ");
		}
		
		
	}

}
