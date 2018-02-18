package ca.uqam.inf2120.tp2.adt.impl;

/**
 * Titre : Liste Chaînée 
 * Description: La classe Noeud représente l'unité de base
 * d'une liste chaînée.
 * 
 * UQAM - INF2120
 * 
 * @author Ismael Doukoure
 * @version Mars 2008 
 * Modifié le 12 Mars 2014
 */
public class Noeud<T> {
    private T element;          // référence de l'information contenu dans le noeud
    private Noeud<T> suivant;   // référence vers le noeud suivant
    
    
    /**
     * Création d'un objet Noeud à vide
     * les champs element et suivant seront initialisés à null 
     */ 
     public Noeud () {
        this (null, null); // appel d'un autre constructeur
    } 
     

    /**
     * Création d'un objet Noeud
     * La référence vers l'élément paramètre est initialisée
     * @param element référence de  dans le noeud 
     */
    public Noeud (T element) {
        this (element, null); // appel d'un autre constructeur
    } 
 
    
    /**
     * Creation d'un objet Noeud
     * La référence vers l'élément paramètre est initialisée
     * @param element référence vers l'objet qui sera stocké dans le noeud 
     * @param suivant référence vers le noeud suivant
     */    
    public Noeud (T element, Noeud<T> suivant) {
        this.element = element;
        this.suivant = suivant;
    }
    
    /**
     * Obtenir la référence vers l'élément contenu dans le noeud
     * @return reference vers l'objet element
     */
    public T getElement () {
        return element;    
    } 
    
    /**
     * Obtenir la référence du noeud suivant
     * @return reference vers le noeud suivant, peut être nulle
     */
    public Noeud<T> getSuivant () {
        return suivant;
        
    }   
 
    /**
     * Permet d'initialiser ou modifier le noeud suivant
     * @param la référence vers le noeud 
     */
    public void setSuivant (Noeud<T> unNoeud) {
        suivant = unNoeud;
    } 
    
    /**
     * Permet d'initialiser ou modifier l'élément
     * @param element reference vers l'élément
     */
    public void setElement (T element) {
        this.element = element;
        
    }
               
} // Noeud
