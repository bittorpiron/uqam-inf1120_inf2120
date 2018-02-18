package ca.uqam.inf2120.labos.classeobjet;

/**
 * Classe Livre représente un livre avec les attributs suivants: 
 * 		  Auteur et titre.
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 * 
 */
public class Livre {

	// Déclaration des constantes
	// Chaque constante de classe est partagée entre toutes les instances
	// Chaque constante est invariable (final pas modifiable)
	private final static String TITRE_LIVRE = "\n Titre du livre : ";
	private final static String AUTEUR_LIVRE = "\n Auteur du livre : ";

	// les variables d'instance sont générées pour chaque
	// chaque objet de la classe
	private String titre; // Titre du livre
	private String auteur; // Auteur du livre

	/**
	 * Constructeur sans argument. Permet d'initialiser les attributs aux
	 * valeurs par défaut
	 */
	public Livre() {
	}

	/**
	 * Permet d'initialiser les attributs du livre
	 * 
	 * @param nom
	 *            Titre du livre
	 * @param auteur
	 *            Auteur du livre
	 */
	public Livre(String titre, String auteur) {
		setTitre(titre);
		setAuteur(auteur);

	}

	/**
	 * Permet d'initialiser ou modifier le titre
	 * 
	 * @param titre
	 *            Titre du livre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Permet d'initialiser ou modifier l'auteur.
	 * 
	 * @param auteur
	 *            Auteur du livre
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**
	 * Obtenir le titre du livre.
	 * 
	 * @return Le titre du livre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Obtenir l'auteur du livre.
	 * 
	 * @return L'auteur du livre
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * Afficher les informations du livre.
	 */
	public void afficher() {
		System.out.println(TITRE_LIVRE + getTitre() + AUTEUR_LIVRE
				+ getAuteur());
	}

}
