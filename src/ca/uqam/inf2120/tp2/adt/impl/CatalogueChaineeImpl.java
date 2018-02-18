/**
 * CatalogueChaineeImpl.java
 */
package ca.uqam.inf2120.tp2.adt.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.uqam.inf2120.tp2.adt.Catalogue;
import ca.uqam.inf2120.tp2.adt.NombreCopies;

/**
 * UQAM - Hiver 2014 - INF2120 - Groupe 30 - TP2 (Ismaël Doukouré)
 * 
 * CatalogueChaineeImpl : Implémentation en utilisant une liste chaînée de
 * l’interface Catalogue.
 * 
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-03-30
 * @param <T>
 */
public class CatalogueChaineeImpl<T extends NombreCopies> implements
		Catalogue<T> {

	private Noeud<T> tete; // La référence vers le premier élément du catalogue
	private Noeud<T> iterateur; // La référence vers un itérateur du catalogue

	/**
	 * Constructeur sans arguments de l'implémentation Liste Chaînée pour
	 * Catalogue
	 */
	public CatalogueChaineeImpl() {

		this.vider();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp2.adt.Catalogue#ajouter(ca.uqam.inf2120.tp2.adt.
	 * NombreCopies)
	 */
	@Override
	public boolean ajouter(T elt) {

		boolean ajoute = false;

		// Valider le nouveau élément à ajouter
		if (estValide(elt)) {

			// Si liste vide, ajouter en tant que tête
			if (estVide()) {

				tete = new Noeud<T>(elt);
				ajoute = true;

			} else {

				// Parcourir la liste chaînée
				T eltCourant;
				Noeud<T> noeudCourant = tete;

				while (noeudCourant != null && !ajoute) {

					eltCourant = noeudCourant.getElement();

					// Augmenter le nb. de copies si existe
					if (eltCourant.equals(elt)) {

						eltCourant.augmenter(elt.obtenirNbCopies());
						ajoute = true;

					} else if (noeudCourant.getSuivant() != null) {

						// Avancer le parcours si pas dernier
						noeudCourant = noeudCourant.getSuivant();

					} else {

						// Si dernier, ajouter à la fin
						noeudCourant.setSuivant(new Noeud<T>(elt));
						ajoute = true;

					}
				}
			}
		}

		return ajoute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.tp2.adt.Catalogue#ajouter(ca.uqam.inf2120.tp2.adt.Catalogue
	 * )
	 */
	@Override
	public void ajouter(List<T> liste) {

		// Valider la nouvelle liste
		if (estValide(liste)) {

			for (T elmt : liste) {

				ajouter(elmt);

			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp2.adt.Catalogue#supprimer(ca.uqam.inf2120.tp2.adt.
	 * NombreCopies)
	 */
	@Override
	public boolean supprimer(T elt) {

		boolean supprime = false;

		// Valider la liste et l'élément à supprimer
		if (!estVide() && estValide(elt)) {

			// Parcourir la liste chaînée
			Noeud<T> noeudCourant = tete;
			Noeud<T> noeudPrecedent = null;
			T eltCourant = noeudCourant.getElement();

			while (noeudCourant != null && !supprime) {

				eltCourant = noeudCourant.getElement();

				// Supprimer nb. de copies si trouvé et sortir
				if (eltCourant.equals(elt)) {

					eltCourant.diminuer(elt.obtenirNbCopies());
					supprime = true;

				} else {
					// Avancer le parcours
					noeudPrecedent = noeudCourant;
					noeudCourant = noeudCourant.getSuivant();
				}
			}

			// Retirer de la liste chaînée si nb de copies < 1
			if (supprime && eltCourant.obtenirNbCopies() < 1) {

				// Premier element (pointer la nouvelle tete)
				if (noeudPrecedent == null) {
					// Enlèver l'unique élément de la liste
					if (tete.getElement() == null) {
						tete = null;
					} else {
						tete = tete.getSuivant();
					}

				} else {

					noeudPrecedent.setSuivant(noeudCourant.getSuivant());

				}
			}
		}
		return supprime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.tp2.adt.Catalogue#supprimer(ca.uqam.inf2120.tp2.adt.Catalogue
	 * )
	 */
	@Override
	public List<T> supprimer(List<T> liste) {

		List<T> listeNonSupprimes = new ArrayList<T>();

		// Valider les listes
		if (!estVide() && estValide(liste)) {

			for (T elmt : liste) {

				// Ajouter dans la liste de retour si non enlevé du catalogue
				if (!supprimer(elmt)) {

					listeNonSupprimes.add(elmt);

				}
			}
		}
		// Retourne nul si vide
		if (listeNonSupprimes.isEmpty()) {

			listeNonSupprimes = null;
		}

		return listeNonSupprimes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp2.adt.Catalogue#remplacer(ca.uqam.inf2120.tp2.adt.
	 * NombreCopies, ca.uqam.inf2120.tp2.adt.NombreCopies)
	 */
	@Override
	public boolean remplacer(T eltARemplacer, T nouveauelt) {

		boolean remplace = false;

		// Valider si:
		// ma liste chaînée n'est pas vide
		// "eltARemplacer" existe dans la liste
		// "nouveauElt" n'est pas nul, il n'existe pas déjà dans la liste et son
		// nombre de copies est supérieur à 0

		if (!estVide() && existe(eltARemplacer) && estValide(nouveauelt)
				&& !existe(nouveauelt)) {

			// Parcourir la liste chaînée
			Noeud<T> noeudCourant = tete;

			while (noeudCourant != null && !remplace) {

				// Si l'élément à remplacer est trouvé, sortir
				if (noeudCourant.getElement().equals(eltARemplacer)) {

					noeudCourant.setElement(nouveauelt);
					remplace = true;

				} else {
					// Avancer le parcours
					noeudCourant = noeudCourant.getSuivant();
				}
			}
		}

		return remplace;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.tp2.adt.Catalogue#existe(ca.uqam.inf2120.tp2.adt.NombreCopies
	 * )
	 */
	@Override
	public boolean existe(T elt) {

		boolean eltExiste = false;

		// Valider liste et élément
		if (!estVide() && (elt != null)) {

			// Parcourir la liste chaînée
			Noeud<T> noeudCourant = tete;

			while (noeudCourant != null && !eltExiste) {

				// Trouvé et sortir
				if (noeudCourant.getElement().equals(elt)) {

					eltExiste = true;

				} else {
					// Avancer le parcours
					noeudCourant = noeudCourant.getSuivant();
				}
			}
		}
		return eltExiste;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp2.adt.Catalogue#nbCopies(ca.uqam.inf2120.tp2.adt.
	 * NombreCopies)
	 */
	@Override
	public int nbCopies(T elt) {

		int nbrCopies = 0;

		// Valider la liste et l'élément
		if (!estVide() && estValide(elt)) {

			// Parcourir la liste chaînée
			Noeud<T> noeudCourant = tete;
			T eltCourant;

			// Tous les éléments de la liste ont un nbrCopies > 0
			while (noeudCourant != null && nbrCopies == 0) {

				eltCourant = noeudCourant.getElement();

				// Supprimer nb. de copies si trouvé et sortir
				if (eltCourant.equals(elt)) {

					nbrCopies = eltCourant.obtenirNbCopies();

				} else {
					// Avancer le parcours
					noeudCourant = noeudCourant.getSuivant();
				}
			}
		}

		return nbrCopies;

	}

	/**
	 * Valide l'élément passé ne soit pas nul ou avec un nombre de copies
	 * inférieur à 1
	 * 
	 * @param elt
	 *            élément passé en paramètre
	 * @return vrai si pas nul et avec un nombre de copies supérieur à 1
	 */
	private boolean estValide(T elt) {

		return elt != null && elt.obtenirNbCopies() > 0;
	}

	/**
	 * Valide que la liste passé ne soit pas nul ou vide
	 * 
	 * @param liste
	 *            passé en paramètre
	 * @return vrai si pas nul et pas vide
	 */
	private boolean estValide(List<T> liste) {

		return liste != null && !liste.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp2.adt.Catalogue#nbTotalCopies()
	 */
	@Override
	public int nbTotalCopies() {

		int nbrTotalCopiesDansLaListe = 0;

		Noeud<T> noeudCourant = tete;

		// Parcourir la liste chaînée
		while (noeudCourant != null) {
			nbrTotalCopiesDansLaListe += noeudCourant.getElement()
					.obtenirNbCopies();
			noeudCourant = noeudCourant.getSuivant();
		}

		return nbrTotalCopiesDansLaListe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.tp2.adt.Catalogue#estEgale(ca.uqam.inf2120.tp2.adt.Catalogue
	 * )
	 */
	@Override
	public boolean estEgale(Catalogue<T> liste) {

		boolean egale = false;

		// Si liste nule, ne peuvent pas être égales
		if (liste != null ) {

			// Les deux sont vides, pas besoin de parcourir 
			if (estVide() && liste.estVide()) {

				egale = true;

			} else {
				// Parcourir la liste reçue jusqu'au moment de trover une différence
				egale = true;

				Iterator<T> itListe = liste.iterator();
				while (itListe.hasNext() && egale) {

					// Si l'élément ne se trouvé pas ou il a un nombre différent
					// de copies, alors les liste sont différentes
					if (!estEgale(itListe.next())) {

						egale = false;

					}
				}

				// Vérifier que le Catalogue actuel n'a pas plus d'éléments que
				// celui passé en paramètre
				if (egale) {
					Noeud<T> noeudCourant = tete;
					while (noeudCourant != null && egale) {
						
						if (!liste.existe(noeudCourant
								.getElement())) {

							egale = false;

						} else {

							noeudCourant = noeudCourant.getSuivant();
						}
					}
				}
			}
		}
		return egale;
	}

	/**
	 * Vérifie si l'élément passée existe dans la liste existante et qu'ils
	 * contiennent le même nombre de copies.
	 * 
	 * @param elt
	 *            élément à vérifier
	 * @return vrai si trouvé et même nombre des copies
	 */
	private boolean estEgale(T elt) {

		boolean egale = false;
		boolean trouve = false;

		// Parcourir la liste chaînée
		Noeud<T> noeudCourant = tete;

		while (noeudCourant != null && !trouve) {

			// Sortir si trouvé
			if (noeudCourant.getElement().equals(elt)) {

				trouve = true;

				// Vérifier le nombre de copies
				if (noeudCourant.getElement().obtenirNbCopies() == elt
						.obtenirNbCopies()) {

					egale = true;
				}
			} else {
				// Avancer le parcours
				noeudCourant = noeudCourant.getSuivant();
			}
		}

		return egale;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp2.adt.Catalogue#estVide()
	 */
	@Override
	public boolean estVide() {

		return tete == null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp2.adt.Catalogue#vider()
	 */
	@Override
	public void vider() {

		tete = null;

	}

	/*
	 * Initialise l’itérateur pour pointer vers la tête de la liste
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {

		iterateur = new Noeud<T>(null, tete);
		return this;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {

		return iterateur != null && iterateur.getSuivant() != null;

	}

	/*
	 * La référence vers le nœud suivant peut être nulle il faut vérifier avant
	 * accéder avec hasNext pour éviter NoSuchElementException
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next() {

		iterateur = iterateur.getSuivant();
		return iterateur.getElement();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {

		// Laisser vide

	}
}