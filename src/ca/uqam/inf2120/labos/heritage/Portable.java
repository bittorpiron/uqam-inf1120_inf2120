package ca.uqam.inf2120.labos.heritage;

/**
 * 	Classe Portable hérite de la classe Ordinateur avec les attributs supplémentaires suivants : 
 *        poids, dimension, et capacité de la pile.
 *               
 * 	UQAM  - INF2120
 * 
 * @author Gloire Lomani / Ismael Doukoure
 * @version Février 2014
 *
 */
public class Portable extends Ordinateur{
	
	private static final String POIDS = "\nPoids : " ;
	private static final String DIMENSION_ECRAN = "\nDimension écran : " ;
	private static final String CAPACITER_PILE = "\nCapacité Pile : " ;
	
	private double poids;
	private double dimensionEcran;
	private double capacitePile;
	
	/**
	 * Constructeur avec tous les paramètres requis.
	 * 
	 * @param model
	 * @param processeur
	 * @param memoire
	 * @param espaceDisk
	 * @param nbPortsUsb
	 * @param poids
	 * @param dimensionEcran
	 * @param capacitePile
	 */
	public Portable(String model, String processeur, double memoire,
			double espaceDisk, int nbPortsUsb, double poids,
			double dimensionEcran, double capacitePile) {
		super(model, processeur, memoire, espaceDisk, nbPortsUsb);
		this.poids = poids;
		this.dimensionEcran = dimensionEcran;
		this.capacitePile = capacitePile;
	}

	/**
	 * Obtenir le poids.
	 * 
	 * @return Le poids
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * Obtenir la dimension de l'écran.
	 * 
	 * @return La dimension de l'écran
	 */
	public double getDimensionEcran() {
		return dimensionEcran;
	}

	/**
	 * Obtenir la capacité de l'écran.
	 * 
	 * @return La capacité de l'écran
	 */
	public double getCapacitePile() {
		return capacitePile;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.heritage.Ordinateur#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + POIDS + poids + 
				DIMENSION_ECRAN + dimensionEcran +
				CAPACITER_PILE + capacitePile;
	}

	
	
}
