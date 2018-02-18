package ca.uqam.inf2120.exemplesvusenclasse.classobjet;

/**
 *  Titre : Retour sur le concept de classe
 * 	Description: Classe Personne représente une personne avec les attributs
 * 	suivants : le nom, le prénom et l'âge.
 * 	UQAM - INF2120
 * @author Ismael Doukoure
 * @version Janvier 2014
 */

public class Personne {

	// Déclaration des constantes
	// Chaque constante de classe est partagée entre toutes les instances
	// Chaque constante est invariable (final pas modifiable)
	final static String DESCRPTION_PRENOM = "\n Prénom  : ";
	final static String DESCRPTION_NOM = "\n Nom     : ";
	final static String DESCRPTION_AGE = "\n Äge     : ";
	final static String DESCRPTION_NB_PERSONNES_CREES = "\n Nombre de personnes créées : ";
	
	private static int nbPersonnesCreees = 0;
	
	// les variables d'instance sont générées pour chaque
	// chaque objet de la classe
	private String nom; // Nom de la personne
	private String prenom; // Prénom de la personne
	private int age;

	/**
	 * Constructeur sans argument. Permet d'initialiser les attributs aux
	 * valeurs par défaut
	 */
	public Personne() {
		nbPersonnesCreees++;

	}

	
	/**
	 * Permet d'initialiser les attributs prénom, et nom
	 * 
	 * @param prenom Prénom de la personne
	 * @param nom Nom de la personne
	 */
	public Personne(String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		nbPersonnesCreees++;
	}

	/**
	 * Permet d'initialiser ou modifier le nom
	 * 
	 * @param nom
	 *            Nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Permet d'initialiser ou modifier le prémon
	 * 
	 * @param prenom Prénom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Permet d'initialiser ou modifier l'âge
	 * 
	 * @param age Âge de la personne
	 */
	public void setPrenom(int age) {
		this.age = age;
	}

	/**
	 * Obtenir le prénom de la personne.
	 * 
	 * @return Le prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Obtenir le nom de la personne.
	 * 
	 * @return Le nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Obtenir l'âge de la personne.
	 * 
	 * @return L'âge de la personne
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Obtenir les attributs de l'instance courante(prénom, nom, age)
	 * 
	 * @return le prénom et le nom
	 */
	public String toString() {
		return (DESCRPTION_PRENOM + getPrenom() + DESCRPTION_NOM + getNom()
				+ DESCRPTION_AGE + getAge() + DESCRPTION_NB_PERSONNES_CREES + nbPersonnesCreees );
	}
	
	/**
	 * Afficher les informations de l'instance courante(prénom, nom, age) et la variable
	 * de classe n
	 * 
	 */
	public void afficher() {
		System.out.print(this);
	}

} // fin de la classe Personne

