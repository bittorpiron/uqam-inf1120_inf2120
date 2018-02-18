/**
 * 
 */
package ca.uqam.inf2120.labos.heritagepolymorhisme;

/**
 * AbonneIllico: hérite de la classe AbonneCable avec un 
 * attribut de plus : nombre d'appareils Illico.
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 *
 */
public class AbonneIllico extends AbonneCable {
	
	// Déclaration des constantes
    // Chaque constante de classe est partagée entre toutes les instances
    // Chaque constante est invariable (final pas modifiable)
    private final static String NOMBRE_APPAREILS_ILLICO = "\n Nonbre d'appareils Illico : " ;

	// Attribut d'instance
	private int nombreAppareilsIllico;
	
	/**
	 * Constructeur sans argument
	 */
	public AbonneIllico() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur avec tous les 
	 * @param nom
	 * @param numeroCompte
	 * @param adresse
	 * @param solde
	 * @param nbTelevisions
	 * @param nombreAppareilsIllico
	 */
	public AbonneIllico(String nom, long numeroCompte, String adresse,
			float solde, int nbTelevisions, int nombreAppareilsIllico) {
		super(nom, numeroCompte, adresse, solde, nbTelevisions);
		this.nombreAppareilsIllico = nombreAppareilsIllico;
	}

	/**
	 * Obtenir le nombre d'appareils Illico.
	 * 
	 * @return nombreAppareilsIllico
	 */
	public int getNombreAppareilsIllico() {
		return nombreAppareilsIllico;
	}

	/**
	 * Initialise ou modifie le nombre d'Appareils Illico.
	 * 
	 * @param nombreAppareilsIllico
	 */
	public void setNombreAppareilsIllico(int nombreAppareilsIllico) {
		this.nombreAppareilsIllico = nombreAppareilsIllico;
	}
	
	
	/**
	 * Affiche toutes les informations.
	 */
	public void afficher() {
		
		super.afficher();
		System.out.print(NOMBRE_APPAREILS_ILLICO + getNombreAppareilsIllico());
		
	}

}
