package ca.uqam.inf2120.labos.heritage;

/**
 * 	Classe Table hérite de la classe Ordinateur avec les attributs supplémentaires suivants : 
 *        nombre de fentes, et style de boitier.
 *               
 * 	UQAM  - INF2120
 * 
 * @author Gloire Lomani / Ismael Doukoure
 * @version Février 2014
 *
 */
public class Table extends Ordinateur{
	
	private static final String NOMBRE_FENTES = "\nNombres Fentes : " ;
	private static final String STYLE_BOITIER = "\nStyle Boitier : " ;
	
	private int nbFentesExp;
	private String styleBoitier;
	
	
	/**
	 * Constructeur avec tous les paramètres requis.
	 * 
	 * @param model
	 * @param processeur
	 * @param memoire
	 * @param espaceDisk
	 * @param nbPortsUsb
	 * @param nbFentesExp
	 * @param styleBoitier
	 */
	public Table(String model, String processeur, double memoire,
			double espaceDisk, int nbPortsUsb, int nbFentesExp,
			String styleBoitier) {
		super(model, processeur, memoire, espaceDisk, nbPortsUsb);
		this.nbFentesExp = nbFentesExp;
		this.styleBoitier = styleBoitier;
	}

	/**
	 * Obtenir le nombre de fentes
	 * 
	 * @return Le nombre de fentes
	 */
	public int getNbFentesExp() {
		return nbFentesExp;
	}


	/**
	 * Obtenir le style de boitier.
	 * 
	 * @return Le style de boitier
	 */
	public String getStyleBoitier() {
		return styleBoitier;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.heritage.Ordinateur#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + NOMBRE_FENTES + nbFentesExp + 
				STYLE_BOITIER + styleBoitier;
	}
	
	
	

}
