package ca.uqam.inf2120.exemplesvusenclasse.tda;

/**
 * Interface Pile<T> contenant des éléments de type T.
 * 
 * @author Ismael Doukoure
 * @version 2008-01-22
 * Modifié le 08 février 2014
 */
public interface Pile<T> {
	
	/**
     * Ajoute e au sommet de la pile.
     * 
     * @param e l'élément à ajouter.
     */
      public void empiler(T e);
     
     /**
      * Retire l'élément du sommet de la pile.
      * 
      * return L'élément retiré.
      * @throws ExceptionPileVide Si la pile est vide.
      */
      public T depiler() throws PileVideException;
     
     /**
      * Retourne vrai si et seulement si la pile est vide.
      * 
      * @return true si la pile, sinon false.
      */
      public boolean estVide();
      
    
      /**
       * Retorune le nombre d'éléments dans la pile.
       * 
       * @return Le nombre d'éléments.
       */
       public int taille();
    
       /**
        * Retourne l'élément au sommet de la pile sans le retirer.
        * 
        * @return L'élément au sommet.
        * @throws ExceptionPileVide Si la pile est vide.
        */    
        public T sommet()  throws PileVideException;
    
    
}
