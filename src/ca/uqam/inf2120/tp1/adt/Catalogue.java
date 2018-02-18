package ca.uqam.inf2120.tp1.adt;

import java.util.List;
import java.util.ListIterator;



/**
 * UQAM - Hiver 2014 - INF2120 - Groupe 30 - TP1 
 * 
 * ListeAdt : Cette interface définit les services d'une liste dans laquelle 
 * un élément peut apparaitre plusieurs fois. Le nombre de fois qu'un élément
 * apparait dans la liste est appelé nombre de copie et supporté par l'interface
 * NombreCopie. Le nombre de copies de tout élément présent dans la liste doit
 * être supérieur à 0.    
 *    
 * @author Ismael Doukoure
 * @version 12 février 2014
 */
public interface Catalogue<T extends NombreCopies> {

	/**
     * Ajoute "elt" dans la liste s'il n'existe pas, sinon, augmente son nombre de
     * copie (nombre de copies de "elt" dans la liste courante  + nombre de copies de "elt"
     * passé en paramètre). "elt" doit être ajouté à la fin de la liste. Aucun ajout si 
     * "elt" est nul ou son nombre de copie est inférieur à 1. 
     * 
     * @param elt L'élément à ajouter
     * @return true si "elt" est ajouté, sinon false.
     */
     public boolean ajouter(T elt);
    
    /**
     * Ajoute tous les éléments de la liste passée en paramètre dans la liste existante.
     * Si l'élément à ajouter existe déjà dans la liste courante, son nombre de copie est
     * augmenté (nombre de copies de l'élément dans la liste courante  + nombre de copies de
     * l'élément de la liste passée en paramètre). 
     * 
     * Aucun ajout :
     *   - si la liste est vide ou nulle.
     *   - si l'élément est nul ou son nombre de copie est inférieur à 1.
     *   
     * @param liste La liste dont les éléments doivent être ajoutés
     */
     public void ajouter(List<T> liste);
    
         
     /**
      * Supprime "elt" dans la liste existante en diminuant son nombre de copies
      * (nombre de copies de "elt" dans la liste courante  - nombre de copies de "elt" passé en
      * paramètre). L'élément doit être retiré de la liste si son nombre de copies après
      * diminution est inférieur à 1. 
      * 
      * Aucune suppression si "elt" est nul, s'il n'existe pas dans la liste ou son nombre 
      * de copies est inférieur à 1. 
      * 
      * @param elt L'élément à supprimer
      * @return Vrai si l'élément est supprimé, sinon faux 
      */
      public boolean supprimer(T elt);
    
     /**
      * Supprime tous les éléments de la liste passée en paramètre dans la liste existante
      * en diminuant leur nombre de copies (nombre de copies de "elt" dans la liste 
      * existante - nombre de copies de "elt" de la liste passée en paramètre). L'élément
      * doit être retiré de la liste existante si son nombre de copies après diminution est
      * inférieur à 1. Tous les éléments non supprimés de la liste passée en paramètre sont
      * retournés dans une autre liste (ArrayList).
      * 
      * @param liste La liste dont les éléments doivent être supprimés
      * @return La liste des éléments non supprimés, nul si tous les éléments sont supprimés.
      */
      public List<T> supprimer(List<T> liste);
    
    /**
     * Remplace "eltARemplacer" dans la liste existante par "nouveauElt". 
     * Aucun remplacement ne doit être fait :
     *   - si "eltARemplacer" n'existe pas dans la liste
     *   - si "nouveauElt" est nul, s'il existe déjà dans la liste ou son nombre de copies est
     *     inférieur à 1. 
     * 
     * @param eltARemplacer L'élement de la liste à remplacer
     * @param nouveauElt Le nouveau élément
     * @return Vrai si le remplacement est fait, sinon faux
     */
     public boolean remplacer(T eltARemplacer, T nouveauelt);
    
     /**
      * Retourne l'élément qui se trouve à l'indice passé en paramètre.
      * 
      * @param indice ou l'élement à retourner se trouve
      * @throws IndiceHorsBornesException si l'indice est négatif ou supérieur
      *         au nombre d'éléments dans la liste.
      * @return L'élément retourné
      */
      public T element(int indice) throws IndiceHorsBornesException;
      
      
      /**
       * Retourne tous les éléments de la liste courante dont le nombre de 
       * copies <= "nbCopie".
       * 
       * @param nbCopie Le nombre de copies
       * @return La liste des éléments dont le nombre de copies <= "nbCopie"
       */
       public List<T> elements(int nbCopie);
      
      
    /**
     * Retourne le nombre de copies de "elt" dans la liste existante.
     * 
     * @param elt L'élement dont le nombre de copies doit être retourné
     * @return Le nombre de copies
     */
     public int nbCopies(T elt);
     

     /**
      * Retourne le nombre total de copies de tous les éléments dans la liste existante.
      * (nbCopie[elt1] + nbCopie[elt2] +...+nbCopie[eltn])
      * 
      * @return Le nombre total de copies
      */
      public int nbTotalCopies();
    
    /**
     * Vérifie si la liste passée en paramètre contient les mêmes éléments (même nombre
     * de copies) que la liste existante.
     *          
     * @param liste  La liste dont l'existence des éléments doit être vérifiée
     * @return Vrai si les deux (2) listes sont égales, sinon faux
     */
     public boolean estEgale(Catalogue<T> liste);
    
	 /**
     * Vérifie si la liste existante est vide.
     * 
     * @return Vrai si la liste est vide, sinon faux
     */
     public boolean estVide();
     
    
     /**
      * Retourne un itérateur sur la liste courante.
      *
      * @return Itérateur sur la liste courante.
      */
     public ListIterator<T> iterateur();
    
    
}


