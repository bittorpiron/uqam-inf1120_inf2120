/**
 * CatalogueImpl.java
 */
package ca.uqam.inf2120.tp1.adt.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ca.uqam.inf2120.tp1.adt.Catalogue;
import ca.uqam.inf2120.tp1.adt.IndiceHorsBornesException;
import ca.uqam.inf2120.tp1.adt.NombreCopies;

/**
 * Implémentation de l’interface Catalogue<T> en utilisant la classe ArrayList.
 * Voir l'interface Catalogue.java pour information les services déclarés
 * 
 * @author Victor Piron PIRV11026606 INF2120 Groupe 30 (Ismaël Doukouré)
 *         piron.victor@courrier.uqam.ca
 * @version 2014-03-05
 * 
 */
public class CatalogueImpl<T extends NombreCopies> implements Catalogue<T> {

	// Liste dans laquelle les éléments du catalogue sont gardés.
	private List<T> liste;

	/**
	 * Constructeur sans arguments de l'implémentation de type ArrayList pour
	 * Catalogue
	 */
	public CatalogueImpl() {
		liste = new ArrayList<T>();
	}

	/*
	 * Ajoute un élément au catalogue. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#ajouter(ca.uqam.inf2120.tp1.adt.
	 * NombreCopies)
	 */
	@Override
	public boolean ajouter(T elt) {

		boolean ajoute = false;

		// valider le nouveau element à ajouter
		if (elt != null && elt.obtenirNbCopies() > 0) {

			T e;
			ListIterator<T> it = iterateur();

			// augmenter nbr copies si existe
			while (it.hasNext() && !ajoute) {
				e = it.next();

				if (elt.equals(e)) {

					e.augmenter(elt.obtenirNbCopies());
					ajoute = true;

				}
			}

			// ajouter si nouveau
			if (!ajoute) {

				liste.add(elt);
				ajoute = true;

			}
		}

		return ajoute;
	}

	/*
	 * Ajoute une liste d'élemets au catalogue. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#ajouter(java.util.List)
	 */
	@Override
	public void ajouter(List<T> liste) {

		// valider la nouvelle liste
		if (liste != null && !liste.isEmpty()) {

			for (T elmt : liste) {

				ajouter(elmt);

			}
		}
	}

	/*
	 * Enlève un élément du catalogue. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#supprimer(ca.uqam.inf2120.tp1.adt.
	 * NombreCopies)
	 */
	@Override
	public boolean supprimer(T elt) {

		boolean supprime = false;

		// valider l'élément (nbr des copies>0)
		if (elt != null && elt.obtenirNbCopies() > 0) {

			T e;
			ListIterator<T> it = iterateur();

			// supprimer nbr copies si existe
			while (it.hasNext() && !supprime) {
				e = it.next();

				if (elt.equals(e)) {

					supprime = true;

					e.diminuer(elt.obtenirNbCopies());

					// retirer de la liste si nbr de copies < 1
					if (e.obtenirNbCopies() < 1) {

						liste.remove(e);

					}

				}
			}
		}

		return supprime;
	}

	/*
	 * Enlève les éléments du catalogue contenus dans une liste. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#supprimer(java.util.List)
	 */
	@Override
	public List<T> supprimer(List<T> liste) {

		List<T> listeNonSupprimes = new ArrayList<T>();

		if (liste != null && !liste.isEmpty()) {

			for (T elmt : liste) {

				// ajouter dans la liste de retour si non enlevé du catalogue
				if (!supprimer(elmt)) {

					listeNonSupprimes.add(elmt);

				}
			}
		}
		// retourne nul si vide
		if (listeNonSupprimes.isEmpty()) {

			listeNonSupprimes = null;

		}

		return listeNonSupprimes;
	}

	/*
	 * Remplace un élément du catalogue par un autre. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#remplacer(ca.uqam.inf2120.tp1.adt.
	 * NombreCopies, ca.uqam.inf2120.tp1.adt.NombreCopies)
	 */
	@Override
	public boolean remplacer(T eltARemplacer, T nouveauelt) {

		boolean remplace = false;

		if (liste != null && !liste.isEmpty()) {

			// valider le remplacement: l'élément à remplacer existe dans la
			// liste
			// le nouveau élément n'est pas nulle, a un nombre de copies plus
			// grande que zéro et il n'est pas déjà dans la liste
			if (liste.contains(eltARemplacer) && nouveauelt != null
					&& nouveauelt.obtenirNbCopies() > 0
					&& !liste.contains(nouveauelt)) {

				liste.set(liste.indexOf(eltARemplacer), nouveauelt);
				remplace = true;

			}
		}

		return remplace;
	}

	/*
	 * Retourne l'élément qui se trouve à l'indice passé en paramètre ou lance
	 * une exception quand l'indice est hors des limites. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#element(int)
	 */
	@Override
	public T element(int indice) throws IndiceHorsBornesException {

		if (indice < 0 || indice > liste.size()-1) {

			throw new IndiceHorsBornesException(
					"L'indice est négatif ou supérieur au nombre d'éléments dans la liste.");

		} else {

			return liste.get(indice);
		}
	}

	/*
	 * Retourne une liste d'éléments du catalogue dont le nombre de copies <=
	 * "nbCopie" ou une liste vide s'il n'y a pas d'éléments. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#elements(int)
	 */
	@Override
	public List<T> elements(int nbCopie) {

		List<T> listeRetourne = new ArrayList<T>();

		// Tous les elements de la liste ont au moins une copie
		if (nbCopie > 0) {

			T elementDansLaListe;
			ListIterator<T> it = iterateur();
			while (it.hasNext()) {

				elementDansLaListe = it.next();
				if (elementDansLaListe.obtenirNbCopies() <= nbCopie) {
					listeRetourne.add(elementDansLaListe);
				}
			}
		}

		return listeRetourne;
	}

	/*
	 * Obtenir le nbr des copies d'un élément dans le catalogue. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#nbCopies(ca.uqam.inf2120.tp1.adt.
	 * NombreCopies)
	 */
	@Override
	public int nbCopies(T elt) {

		int nbrCopiesDansLaListe = 0;

		// valider l'élément
		if (elt != null && liste.contains(elt)) {

			// il existe seulement une fois dans la liste
			int indiceElement = liste.indexOf(elt);
			nbrCopiesDansLaListe = liste.get(indiceElement).obtenirNbCopies();
		}

		return nbrCopiesDansLaListe;
	}

	/*
	 * Retourne le nombre total des copies dans le catalogue. Par définition,
	 * les éléments du catalogue ne seront jamais nuls ou avec un nombre
	 * inferieur des copies que 1. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#nbTotalCopies()
	 */
	@Override
	public int nbTotalCopies() {

		int nbrTotalCopiesDansLaListe = 0;

		for (T elmt : liste) {

			nbrTotalCopiesDansLaListe += elmt.obtenirNbCopies();
		}

		return nbrTotalCopiesDansLaListe;
	}

	/*
	 * Vrai quand les deux catalogues sont égaux (même nombre d'éléments et des
	 * copies) Voir:
	 * 
	 * @see
	 * ca.uqam.inf2120.tp1.adt.Catalogue#estEgale(ca.uqam.inf2120.tp1.adt.Catalogue
	 * )
	 */
	@Override
	public boolean estEgale(Catalogue<T> liste) {

		boolean egale = false;
		boolean trouve = false;

		if (liste != null) {

			egale = true;
			T elmCatalogue;
			T elmNouveau;
			ListIterator<T> it = iterateur();

			// sortir des que le nbr des copies est différent
			while (it.hasNext() && egale) {

				elmCatalogue = it.next();

				// iterateur sur le nouveau catalogue
				ListIterator<T> itListeAVerifier = liste.iterateur();
				trouve = false;
				// sortir des que l'élément a été trouvé
				while (itListeAVerifier.hasNext() && !trouve) {

					elmNouveau = itListeAVerifier.next();

					// sortir des que l'élément existe dans le nouveau Catalogue
					// et le nbr des copies est différent
					if (elmCatalogue.equals(elmNouveau)) {

						trouve = true;
						if (elmCatalogue.obtenirNbCopies() != elmNouveau
								.obtenirNbCopies()) {

							egale = false;
						}
					}
				}
				if (!trouve){
					egale = false;
				}
			}
		} 

		return egale;
	}

	/*
	 * Vrai quand le catalogue est vide. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#estVide()
	 */
	@Override
	public boolean estVide() {

		return liste.isEmpty();

	}

	/*
	 * Retourne un iterateur sur notre catalogue. Voir:
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Catalogue#iterateur()
	 */
	@Override
	public ListIterator<T> iterateur() {
		ListIterator<T> it = liste.listIterator();
		return it;
	}
}
