package ca.uqam.inf2120.tp1.adt;

/**
 * Classe pour gérer l'exception liée à un indice 
 * hors bornes d'un tableau.
 * 
 * @author Ismael Doukoure
 * @version 12 février 2014
 */
@SuppressWarnings("serial")
public class IndiceHorsBornesException extends RuntimeException{
	
	/**
	 * Constructeur sans argument
	 */	
	public IndiceHorsBornesException() {
        super();
    }
	
	/**
	 * Permet d'initialiser le message
	 * @param message Message à afficher
	 */
	public IndiceHorsBornesException(String message) {
        super(message);
    }

}

