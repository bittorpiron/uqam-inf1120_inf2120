package ca.uqam.inf2120.exemplesvusenclasse.abr;

import java.util.ArrayList;

/**
 * Quelques méthodes sur l'ABR.
 * 
 * Université du Québec à Montréal INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version Mars 2011 Modifié en Avril 2014
 */
public class ArbreBinaireQuelquesMethodes {

	/**
	 * Parcours préfixe de l'arbre binaire (RGD).
	 * 
	 * @param racine
	 *            La racine de l'ABR
	 */
	public void parcoursPrefixe(NoeudABR<String> racine) {

		if (racine != null) {

			System.out.print(racine.getElement() + " ");
			parcoursPrefixe(racine.getGauche());
			parcoursPrefixe(racine.getDroit());

		}

	}

	/**
	 * Parcours infixe de l'arbre binaire (GRD).
	 * 
	 * @param racine
	 *            La racine de l'ABR
	 */
	public void parcoursInfixe(NoeudABR<String> racine) {

		if (racine != null) {

			parcoursInfixe(racine.getGauche());
			System.out.print(racine.getElement() + " ");
			parcoursInfixe(racine.getDroit());

		}

	}

	/**
	 * Parcours postfixe de l'arbre binaire (GDR).
	 * 
	 * @param racine
	 *            La racine de l'ABR
	 */
	public void parcoursPostfixe(NoeudABR<String> racine) {

		if (racine != null) {

			parcoursPostfixe(racine.getGauche());
			parcoursPostfixe(racine.getDroit());
			System.out.print(racine.getElement() + " ");

		}

	}

	/**
	 * Insérer un élément dans un ABR.
	 * 
	 * @param element
	 *            Élément à insérer
	 * @param racine
	 *            La racine de l'ARB
	 * @return ABR
	 */
	public NoeudABR<String> inserer(String element, NoeudABR<String> racine) {

		// Si l'arbre est null
		if (racine == null) {
			return new NoeudABR<String>(element);
		}

		// Comparer pour décider ou insérer le nouveau élément
		if (element.compareTo(racine.getElement()) < 0) {
			// Insérer le nouveau élément dans le sous-arbre gauche
			racine.setGauche(inserer(element, racine.getGauche()));
		} else if (element.compareTo(racine.getElement()) > 0) {
			// Insérer le nouveau élément dans le sous-arbre gauche
			racine.setDroit(inserer(element, racine.getDroit()));
		}

		return racine;
	}

	/**
	 * Calculer la taille de l'arbre binaire.
	 * 
	 * @param racine
	 *            La racine de l'ABR
	 * @return La taille de l'ABR
	 */
	public int taille(NoeudABR<String> racine) {

		int taille = 0;

		// Si l'arbre n'est pas null
		if (racine != null) {
			taille = 1 + taille(racine.getGauche()) // Sous-arbre gauche
					+ taille(racine.getDroit()); // Sous-arbre droit
		}

		return taille;

	}

	/**
	 * Calculer la hauteur de l'ABR donne par racine.
	 * 
	 * @param racine
	 *            racine La racine de l'ABR
	 * @return la hauteur de l'ABR ou -1 si racine est null.
	 */
	public static int hauteur(NoeudABR<String> racine) {
		int hauteur = -1;

		if (racine != null) {
			hauteur = 1 + Math.max(hauteur(racine.getGauche()),
					hauteur(racine.getDroit()));
		}
		return hauteur;
	}

	public static int nbFeuilles(NoeudABR<String> racine) {
		int reponse = 0;
		if (racine != null) {
			if (racine.getGauche() == null && racine.getDroit() == null) {
				reponse = 1;
			}
			reponse += nbFeuilles(racine.getGauche())
					+ nbFeuilles(racine.getDroit());
		}
		return reponse;
	}

	public static int nbNoeudsSuperieursOuEgaux(NoeudABR<Integer> racine, int n) {
		// on suppose qu'il n'y a pas de doublons dans l'arbre
		int reponse = 0;
		if (racine != null) {
			reponse = nbNoeudsSuperieursOuEgaux(racine.getDroit(), n);
			// il faut aller à droite dans tous les cas
			int direction = -racine.getElement().compareTo(n);
			if (direction <= 0) {
				// n <= racine.info() donc racine.info() est >= n
				++reponse;
			}
			if (direction < 0) {
				// n < racine.info() donc il y a peut-être des noeuds à gauche
				// >= n
				reponse += nbNoeudsSuperieursOuEgaux(racine.getGauche(), n);
			}
		}
		return reponse;
	}

	public static boolean estABR(NoeudABR<String> racine) {
		boolean cEstUnABR = true;
		if (racine != null) {
			String info = racine.getElement();
			if (racine.getGauche() != null) {
				cEstUnABR = info.compareTo(racine.getGauche().getElement()) > 0;
			}
			if (cEstUnABR && racine.getDroit() != null) {
				cEstUnABR = info.compareTo(racine.getDroit().getElement()) < 0;
			}
			if (cEstUnABR) {
				cEstUnABR = estABR(racine.getGauche())
						&& estABR(racine.getDroit());
			}
		}
		return cEstUnABR;
	}

	public static NoeudABR<String> copie(NoeudABR<String> racine) {
		NoeudABR<String> racineCopie = null;
		if (racine != null) {
			racineCopie = new NoeudABR<String>(racine.getElement(), copie(racine.getGauche()),
					copie(racine.getDroit()));
		}
		return racineCopie;
	}

	public static NoeudABR<String> construire(ArrayList<String> parcoursPrefixe) {
		NoeudABR<String> racine = null;
		if (!parcoursPrefixe.isEmpty()) {
			String info = parcoursPrefixe.get(0);
			// repérer les noeuds du sous-arbre gauche
			int i = 1;
			while (i < parcoursPrefixe.size()
					&& parcoursPrefixe.get(i).compareTo(info) < 0) {
				++i;
			}
			ArrayList<String> gauche = new ArrayList<String>();
			gauche.addAll(parcoursPrefixe.subList(1, i));
			ArrayList<String> droite = new ArrayList<String>();
			droite.addAll(parcoursPrefixe.subList(i, parcoursPrefixe.size()));
			racine = new NoeudABR<String>(info, construire(gauche),
					construire(droite));
		}
		return racine;
	}
	
	// Appel de main pour tester les différentes techniques de tri
	public static void main(String[] args) {
		
		ArrayList<String> test= new ArrayList<String>();
		test.add("4");test.add("3");test.add("1");test.add("6");
		test.add("5");test.add("8");test.add("7");test.add("9");
		
		NoeudABR<String> testeur = construire(test);
		System.out.println(hauteur(testeur));
		System.out.println(nbFeuilles(testeur));
		
	}

	
	
}