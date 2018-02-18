package ca.uqam.inf2120.exemplesvusenclasse.techniquesrecherche;

import java.util.Arrays;


/**
 * RechercheSequentielle.
 * 
 * Université du Québec à Montréal 
 * 
 * INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version Avril 2008 
 * Modifié en Avril 2014
 * 
 */
public class RechercheSequentielle<T extends Comparable<T>> {
	
	/**
	 * Recherche séquentielle dans un tableau non ordonné.
	 * @param tableau Tableau d'éléments
	 * @param valeurRecherche Valeur recherchée
	 * @return Positon de l'élément recherché ou -1 si non trouvé
	 */
	public int rechercheSeqNonOrdonnee(T tableau[], T valeurRecherche ) {

		int position  = -1;
		for( int i = 0 ; i < tableau.length && position == -1 ; i++ ) {
			if( tableau[i].compareTo(valeurRecherche) == 0) {
				position =  i; 
			}
				
		}
		
		return position;
   }
	
	/**
	 * Recherche séquentielle dans un tableau ordonné.
	 * @param tableau Tableau d'éléments
	 * @param valeurRecherche Valeur recherchée
	 * @return Positon de l'élément recherché ou -1 si non trouvé
	 */
	public int rechercheSeqOrdonnee (T tableau[], T valeurRecherche ) {

		int position  = -1;
		boolean existePas = false;
		
		for( int i = 0 ; i < tableau.length && position == -1 && !existePas ; i++ ) {
			if(tableau[i].compareTo(valeurRecherche) == 0 ) {
				position  = i; 
			} else if(tableau[i].compareTo(valeurRecherche)  >  0) {
				existePas = true; 
			}
			
		}
		
		return position;
   } 
	

	public static void main(String[] args) {
		
		Integer[] tableauDesordonne = {2,5,10,4,7,1,8,3,6,9};
		Integer[] tableauOrdonne =  {1,2,3,4,5,6,7,8,9,10};
		
		RechercheSequentielle<Integer> rechercheSequentielle = new RechercheSequentielle<Integer>();
		
		System.out.print(Arrays.asList(tableauOrdonne));
		System.out.print(Arrays.asList(tableauDesordonne));

		System.out.println();
		System.out.println();
		System.out.println("Indice est " + rechercheSequentielle.rechercheSeqNonOrdonnee(tableauDesordonne, 8));
		System.out.println("Indice est " + rechercheSequentielle.rechercheSeqOrdonnee(tableauOrdonne, 8));
		
	}


}
