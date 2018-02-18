package ca.uqam.inf2120.labos.heritagepolymorhisme;

/**
 * AbonneCable: hérite de la classe Abonne avec un 
 * attribut de plus : nombre de télévisions.
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 *
 */
public class AbonneCable extends Abonne {
	
	// Déclaration des constantes
    // Chaque constante de classe est partagée entre toutes les instances
    // Chaque constante est invariable (final pas modifiable)
    private final static String NOMBRE_TELEVISIONS = "\n Nonbre de télévisions : " ;
	
	private int nbTelevisions;

	/**
	 * Constructeur sans argument.
	 */
	public AbonneCable() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur avec tous les paramètres requis.
	 * 
	 * @param nom
	 * @param numeroCompte
	 * @param adresse
	 * @param solde
	 * @param nbTelevisions
	 */
	public AbonneCable(String nom, long numeroCompte, String adresse,
			float solde, int nbTelevisions) {
		super(nom, numeroCompte, adresse, solde);
		this.nbTelevisions = nbTelevisions;
	}

	/**
	 * Obtenir le nombre de télévisions.
	 * 
	 * @return nbTelevisions
	 */
	public int getNbTelevisions() {
		return nbTelevisions;
	}

	/**
	 * Initialise ou modifie le nombre de télévisions.
	 * 
	 * @param nbTelevisions 
	 */
	public void setNbTelevisions(int nbTelevisions) {
		this.nbTelevisions = nbTelevisions;
	}
	
	/**
	 * Affiche toutes les informations.
	 */
	public void afficher() {
		
		super.afficher();
		System.out.print(NOMBRE_TELEVISIONS + getNbTelevisions());
		
	}
	
		

}
