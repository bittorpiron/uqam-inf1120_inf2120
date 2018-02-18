package ca.uqam.inf2120.labos.classeabstraitejunit;

/**
 * Classe Carre hérite de la classe abstraite FigureGeometrique
 * et redéfinie les méthodes : calculerSurface() et calculerPerimetre()
 * 
 * @author Gloire Lomani / Ismael Doukoure
 * @version Février 2014
 *
 */

public class Carre extends FigureGeometrique{

	private double cote;
	
	/**
	 * Constructeur avec tous les paramètres requis.
	 * 
	 * @param cote
	 */
	public Carre(double cote) {
		super(0.0, 0.0);
		this.cote = cote;
	}
	
	/**
	 * Calcule la surface.
	 */
	public void calculerSurface() {
		surface = cote * cote;
		
	}
	
	/**
	 * Calcule le périmètre.
	 */
	public void calculerPerimetre() {
		perimetre = (cote * 4);		
	}
	
	/**
	 * Obtenir le côté.
	 * 
	 * @return Le côté
	 */
	public double getCote() {
		return cote;
	}
	
	/**
	 * Initialiser ou modifier le côté.
	 * 
	 * @param cote Le côté
	 */
	public void setCote(double cote) {
		this.cote = cote;
	}
}
