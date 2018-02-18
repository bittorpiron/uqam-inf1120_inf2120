package ca.uqam.inf2120.labos.classeabstraitejunit;


/**
 *  Titre : Classes abstraite
 * 	Description: Classe FigureGeometrique représente une 
 *               une figure géométrique avec les attributs suivants : 
 *               la surface, le perimetre.
 * 	UQAM - INF2120
 * @author Ismael Doukoure
 * @version juin 2009
 * Modifié en Janvier 2014
 */
public abstract class FigureGeometrique {
	
	// Déclaration des variables
	protected double surface;
	protected double perimetre;
	
	// Constructeur
	public FigureGeometrique(double surface, double perimetre) {
		super();
		this.surface = surface;
		this.perimetre = perimetre;
	}
	
	/**
	 * Obtenir la surface
	 * @return La surface
	 */
	public double getSurface() {
		return surface;
	}

	/**
	 * Obtenir le périmètre
	 * @return Le perimetre
	 */
	public double getPerimetre() {
		return perimetre;
	}

	/**
	 * Calculer la surface de la figure géometrique. 
	 * La surface calculée sera affectée à l'attribut surface dans la méthode.
	 */
    public abstract void calculerSurface();
    
    /**
	 * Calculer la surface de la figure géometrique. 
	 * Le périmètre calculé sera affecté à l'attribut perimetre dans la méthode.
	 */
    public abstract void calculerPerimetre();


}
