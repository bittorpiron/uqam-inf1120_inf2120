package ca.uqam.inf2120.tp2.adt;

import java.util.Iterator;
import java.util.List;


/**
 * UQAM - Hiver 2014 - INF2120 - Groupe 30 - TP2 
 * 
 * ListeAdt : Cette interface définit les services d'une liste dans laquelle 
 * un élément peut apparaitre plusieurs fois. Le nombre de fois qu'un élément
 * apparait dans la liste est appelé nombre de copie et supporté par l'interface
 * NombreCopie. Le nombre de copies de tout élément présent dans la liste doit
 * être supérieur à 0.    
 *    
 * @author Ismael Doukoure
 * @version 12 mars 2014
 */
public interface Catalogue<T extends NombreCopies> extends Iterable<T>, Iterator<T>{

	/**
     * Ajoute "elt" dans la liste s'il n'existe pas, sinon, augmente son nombre de
     * copie (nombre de copies de "elt" dans la liste  + nombre de copies de "elt"
     * passé en paramètre). Aucun ajout si "elt" est nul ou son nombre de copie 
     * est inférieur à 1. L'élément est ajouté à la fin de la liste.
     * 
     * @param elt L'élément à ajouter
     * @return true si "elt" est ajouté, sinon false.
     */
     public boolean ajouter(T elt);
    
     /**
      * Ajoute tous les éléments de la liste passée en paramètre dans la liste existante.
      * Si l'élément à ajouter existe déjà dans la liste courante, son nombre de copie est
      * augmenté (nombre de copies de l'élément dans la liste courante  + nombre de copies de
      * l'élément de la liste passée en paramètre). Les éléments sont ajoutés à la fin de 
      * la liste.
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
      * (nombre de copies de "elt" dans la liste  - nombre de copies de "elt" passé en
      * paramètre). L'élément doit être retiré de la liste si son nombre de copies après
      * diminution est inférieur à 1. Aucune suppression si "elt" est nul, s'il n'existe 
      * pas dans la liste ou son nombre de copies est inférieur à 1. 
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
      * vérifie si l'élément passé en paramètre existe dans la liste.
      * 
      * @param elt L'élément dont l'existence doit être vérifiée.
      * @return true si "elt" existe, sinon false
      */
      public boolean existe(T elt);
      
    /**
     * Retourne le nombre de copies de "elt" dans la liste existante.
     * 
     * @param elt L'élement dont le nombre de copies doit être retourné
     * @return Le nombre de copies
     */
     public int nbCopies(T elt);
     
     /**
      * Retourne le nombre total de copies de tous les éléments dans la liste existante.
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
     * vide la liste en supprimant tous les élements de la liste.
     */
     public void vider();
     
     /* INFORMATIONS IMPORTANTES : Étant donné que ListeAdt hérite des interfaces
      * Iterable<T>, Iterator<T>, vous devez définir toutes les méthodes qui sont
      * déclarées dans ces interfaces (SAUF la méthode remove de l'interface Iterator<T>)
      * dans votre classe ListeAdtImpl qui implémente l'interface ListeAdt. Voir
      * ci-dessous pour les détails :
      *
      *
      * Iterable<T>
      * Cette interface contient une seule méthode "public Iterator<T> iterator()"
      * qui retourne un iterator sur la liste courante. Vous devez implanter cette
      * methode dans votre classe
      *
      *
      * Iterator<T>
      * Cette interface contient trois méthodes:
      *
      *   - public boolean hasNext() : Vérifie s'il y a un élément à partir de la
      *     position courante dans la liste
      *
      *   - public T next() : Retourner l'élément à la position courante et
      *     repositionne le curseur (l'itérateur) sur l'élément suivant.
      *
      *   - public void remove () : À NE PAS DÉFINIR. Donc cette méthode sera vide avec
      *     juste les accolades ouvrante et fermante.
      *
      */
    
}


