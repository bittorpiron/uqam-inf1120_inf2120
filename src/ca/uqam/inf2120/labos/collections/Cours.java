package ca.uqam.inf2120.labos.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Cours représente un cours donné avec les attributs suivants :
 *    le sigle, le titre, le groupe, le nom de l'enseignant, et la liste des étudiants.
 *    
 * @author Gloire Lomani / Ismael Doukoure
 *
 */
public class Cours {
	
	private String sigle;
	private String titre;
	private int groupe;
	private String nomEnseignant;
	private List<Etudiant> etudiants;

	/**
	 * Constructeur avec les paramètres requis.
	 * 
	 * @param sigle
	 * @param titre
	 * @param groupe
	 * @param nomEnseignant
	 */
	public Cours(String sigle, String titre, int groupe, String nomEnseignant) {
		super();
		this.sigle = sigle;
		this.titre = titre;
		this.groupe = groupe;
		this.nomEnseignant = nomEnseignant;
		
		etudiants = new ArrayList<Etudiant>();
	}
	
	/**
	 * Ajoute un étudiant dans la liste.
	 * 
	 * @param e Un étudiant
	 */
	public void ajouterEtudiant(Etudiant e) {
		if (e != null) {
			etudiants.add(e);
		}
	}
	
	/**
	 * Affiche toutes les informations du cours.
	 */
	public void afficherInfoCours() {
		
		System.out.println("- Sigle : "+ sigle);
		System.out.println("- Titre : "+ titre);
		System.out.println("- Groupe : "+ groupe);
		System.out.println("- Enseignant : "+ nomEnseignant);
		
		System.out.println("\t Liste Etudiants : ");
		
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}
	
	

}














