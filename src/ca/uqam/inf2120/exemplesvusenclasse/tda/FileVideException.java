package ca.uqam.inf2120.exemplesvusenclasse.tda;

/**
 * Classe pour gérer les exceptions lors
 * de la gestion de la file 
 * 
 * @author Ismael Doukoure
 * @version 2008-01-27
 */
@SuppressWarnings("serial")
public class FileVideException extends RuntimeException {

	/**
	 * Constructeur sans argument
	 */	
	public FileVideException() {
        super();
    }
	
	/**
	 * Permet d'initialiser le message
	 * @param message Message à afficher
	 */
	public FileVideException(String message) {
        super(message);
    }


}
