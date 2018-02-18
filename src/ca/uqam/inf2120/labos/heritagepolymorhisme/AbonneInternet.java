package ca.uqam.inf2120.labos.heritagepolymorhisme;

/**
 * AbonneInternet: hérite de la classe Abonne avec un 
 * attribut de plus : adresse de courriel
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 *
 */
public class AbonneInternet extends Abonne {
	
	// Déclaration des constantes
    // Chaque constante de classe est partagée entre toutes les instances
    // Chaque constante est invariable (final pas modifiable)
    private final static String ADRESSE_COURRIEL = "\n Adresse Courriel : " ;
	
	private String adresseCourriel;

	/**
	 * Constructeur sans argument.
	 */
	public AbonneInternet() {
		
	}

	/**
	 * Constructeur avec les paramètres requis.
	 * 
	 * @param nom
	 * @param numeroCompte
	 * @param adresse
	 * @param solde
	 * @param adresseCourriel
	 */
	public AbonneInternet(String nom, long numeroCompte, String adresse,
			float solde, String adresseCourriel) {
		super(nom, numeroCompte, adresse, solde);
		this.adresseCourriel = adresseCourriel;
	}

	/**
	 * Obtenir l'adresse courriel.
	 * 
	 * @return adresseCourriel
	 */
	public String getAdresseCourriel() {
		return adresseCourriel;
	}

	/**
	 * Initialise ou modifie l'adresse courriel.
	 * 
	 * @param adresseCourriel 
	 */
	public void setAdresseCourriel(String adresseCourriel) {
		this.adresseCourriel = adresseCourriel;
	}
	
	/**
	 * Affiche toutes les informations.
	 */
	public void afficher() {
		
		super.afficher();
		System.out.print(ADRESSE_COURRIEL + getAdresseCourriel());
		
	}
	
}
