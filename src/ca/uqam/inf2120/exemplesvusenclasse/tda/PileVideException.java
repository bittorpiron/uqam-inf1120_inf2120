package ca.uqam.inf2120.exemplesvusenclasse.tda;

/**
 * Classe pour gérer les exceptions lors
 * de la gestion de la file 
 * 
 * @author Ismael Doukoure
 * @version 2008-01-27
 * Modifié le 08 février 2014
 */
@SuppressWarnings("serial")
public class PileVideException extends RuntimeException {

	/**
	 * Constructeur sans argument
	 */	
	public PileVideException() {
        super();
    }
	
	/**
	 * Permet d'initialiser le message
	 * @param message Message à afficher
	 */
	public PileVideException(String message) {
        super(message);
    }


}
