/**
 * 
 */
package ca.uqam.inf2120.labos.heritagepolymorhisme;

/**
 * Abonne: regroupe les informations communes des abonnés
 * de la compagnie Internet & TV Pour Tous.
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 *
 */
public abstract class Abonne {
	
	// Déclaration des constantes
    // Chaque constante de classe est partagée entre toutes les instances
    // Chaque constante est invariable (final pas modifiable)
    private final static String NOM = "\n Nom et prénom : " ;
    private final static String NUMERO_COMPTE = "\n Numéro de compte : " ;
    private final static String ADRESSE = "\n Adresse  : " ;
    private final static String SOLDE = "\n Solde : " ;
	
	// Attributs d'instance
	private String nom;
	private long numeroCompte;
	private String adresse;
	private float solde;
	
	/**
	 * Constructeur par défaut.
	 */
	public Abonne() {
		
	}

	/**
	 * Constructeur avec les paramètres requis.
	 * 
	 * @param nom
	 * @param numeroCompte
	 * @param adresse
	 * @param solde
	 */
	public Abonne(String nom, long numeroCompte, String adresse, float solde) {
		super();
		this.nom = nom;
		this.numeroCompte = numeroCompte;
		this.adresse = adresse;
		this.solde = solde;
	}

	/**
	 * Obtenir le nom.
	 * 
	 * @return Le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Initialise ou modifie le nom.
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Obtenir le numéro de compte.
	 * 
	 * @return Le numeroCompte
	 */
	public long getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * Initialise ou modifie le numéro de compte.
	 * 
	 * @param numeroCompte
	 */
	public void setNumeroCompte(long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	/**
	 * Obtenir l'adresse.
	 * 
	 * @return L'adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Initialise ou modifie l'adresse.
	 * 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Obtenir le solde.
	 * 
	 * @return Le solde
	 */
	public float getSolde() {
		return solde;
	}

	/**
	 * Intialise ou modifie le solde.
	 * 
	 * @param solde
	 */
	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	/**
	 * Affiche toutes les informations.
	 */
	public void afficher() {
		
		System.out.print(NOM + getNom() 
				   		  + ADRESSE + getAdresse()
				   		  + NUMERO_COMPTE + getNumeroCompte()
				          + SOLDE + getSolde());
		
	}
	

}
