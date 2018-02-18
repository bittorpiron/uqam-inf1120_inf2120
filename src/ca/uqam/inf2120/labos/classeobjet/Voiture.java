package ca.uqam.inf2120.labos.classeobjet;

/**
 * Voiture représente une voiture avec les attributs: la couleur, la marque, le
 * nombre de portes et l'année de fabrication.
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 * 
 */
public class Voiture {

	/*
	 * Les variables d'instance sont générées pour chaque chaque objet de la
	 * classe
	 */
	private String marque; // Marque de la voiture
	private String couleur; // Couleur de la voiture
	private int anneeFabrication; // Année de fabrication de la voiture
	private int nombrePortes; // Nombre de portes de la voiture

	private final String MARQUE = "\n Marque\t\t: ";
	private final String COULEUR = "\n Couleur\t\t: ";
	private final String ANNEE_FABRICATION = "\n Année de Fabrication    : ";
	private final String NOMBRE_PORTE = "\n Nombre de portes\t : ";
	private final String PORTES = " portes ";

	// constructeur de classe
	public Voiture(String marque, String couleur, int anneeFabrication,
			int pNombrePortes) {
		setMarque(marque);
		this.couleur = couleur;
		this.anneeFabrication = anneeFabrication;
		nombrePortes = pNombrePortes;
	}

	/**
	 * Permet d'initialiser ou modifier la marque.
	 * 
	 * @param marque
	 *            La marque de la voiture
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * Permet d'initialiser ou modifier la couleur.
	 * 
	 * @param couleur
	 *            La couleur de la voiture
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/**
	 * Permet d'initialiser ou modifier l'année de fabrication.
	 * 
	 * @param anneeFabrication
	 */
	public void setAnneeFabrication(int anneeFabrication) {
		this.anneeFabrication = anneeFabrication;
	}

	/**
	 * Permet d'initialiser ou modifier le nombre de portes.
	 * 
	 * @param nombrePortes
	 *            Nombre de portes de voiture
	 */
	public void setNombrePortes(int nombrePortes) {
		this.nombrePortes = nombrePortes;
	}

	/**
	 * Permet d'obtenir la marque.
	 * 
	 * @return marque Marque de voiture
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * Permet d'obtenir la couleur.
	 * 
	 * @return Couleur de la voiture
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * Permet d'obtenir l'année de fabrication.
	 * 
	 * @return Année de fabrication
	 */
	public int getAnneeFabrication() {
		return anneeFabrication;
	}

	/**
	 * Permet d'obtenir le nombre de portes.
	 * 
	 * @return Nombre de portes
	 */
	public int getNombrePortes() {
		return nombrePortes;
	}

	/**
	 * Affiche toutes les informations d'une voiture.
	 * 
	 */
	public void afficher() {

		System.out.println(MARQUE + marque + COULEUR + couleur
				+ ANNEE_FABRICATION + anneeFabrication + NOMBRE_PORTE
				+ nombrePortes + PORTES);
	}

} // Voiture

