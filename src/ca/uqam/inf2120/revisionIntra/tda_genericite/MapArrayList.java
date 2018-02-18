/**
 * MapArrayList.java
 */
package ca.uqam.inf2120.revisionIntra.tda_genericite;

import java.util.ArrayList;

/**
 * <p>
 * Implementation de l'interface TDAMap :
 * </p>
 * <ul>
 * <li>Les associations cle/valeur ne sont pas ordonnees dans un TDAMap.</li>
 * <li>Un TDAMap ne peut pas contenir deux fois la meme cle.</li>
 * <li>A chaque cle, on ne peut associer qu'une seule valeur.</li>
 * <li>A deux cles différentes, on peut associer la meme valeur <br/>
 * (il peut y avoir des doublons de valeurs, mais pas de clés).</li>
 * <li>Une cle ne peut pas etre null.</li>
 * <li>Une valeur associee a une cle ne peut pas etre null.</li>
 * </ul>
 * 
 * <p>
 * Note : La methode equals de la classe K est utilisee pour determiner si une
 * cle est deja presente dans le TDAMap (est egale a une cle dans le TDAMap).
 * </p>
 * 
 * @author Melanie Lord
 * @version Automne 2013
 * @param <K>
 *            le type des cles maintenues par ce TDAMap
 * @param <V>
 *            le type des valeurs associees aux cles de ce TDAMap
 */
public class MapArrayList<K, V> implements TDAMap<K, V> {

	// liste de paires (associations) cle -> valeur
	private ArrayList<Paire<K, V>> map;

	/**
	 * Construit un nouveau TDAMap vide (sans aucune cle ni valeur).
	 */
	public MapArrayList() {
		map = new ArrayList<Paire<K, V>>();
	}

	/**
	 * Retourne le nombre d'associations cle/valeur dans ce TDAMap.
	 * 
	 * @return le nombre d'associations cle/valeur dans ce TDAMap.
	 */
	public int taille() {
		return map.size();
	}

	/**
	 * Retourne vrai si ce TDAMap est vide, faux sinon.
	 * 
	 * @return vrai si ce TDAMap est vide, faux sinon.
	 */
	public boolean estVide() {
		return map.isEmpty();
	}

	/**
	 * Supprime toutes les associations cle/valeur de ce TDAMap. Apres l'appel
	 * de cette methode, estVide() retourne vrai.
	 */
	public void vider() {
		map.clear();
	}

	/**
	 * Retourne la valeur associee a la cle donnee dans ce TDAMap. Si la cle
	 * donnee n'existe pas, retourne la valeur null.
	 * 
	 * @param cle la cle de la valeur qu'on veut obtenir.
	 * @return la valeur associee a la cle donnee dans ce TDAMap.
	 * @throws NullPointerException
	 *             si cle est null.
	 */
	public V obtenir(K cle) {
		V valeur = null;
		int i = 0;
		if (cle == null) {
			throw new NullPointerException();
		}
		// Parcourir la liste de paires cle/valeur pour trouver la paire ayant
		// la cle recherchee.
		while (i < map.size() && !map.get(i).getItem1().equals(cle)) {
			i++;
		}
		if (i < map.size()) {
			valeur = map.get(i).getItem2();
		}
		return valeur;
	}

	/**
	 * Ajoute a ce TDAMap l'association cle -> valeur donnee en parametre, si
	 * cle n'existe pas deja dans ce TDAMap.
	 * 
	 * @param cle
	 *            la cle a laquelle correspond valeur
	 * @param valeur
	 *            la valeur qui correspond a cle
	 * @return vrai si l'association cle/valeur a ete ajoutee, faux sinon.
	 * @throws NullPointerException
	 *             si cle ou valeur sont null.
	 */
	public boolean ajouter(K cle, V valeur) {
		boolean ajout = false;
		if (valeur == null) {
			throw new NullPointerException();
		}
		// ici, c'est contientCle qui levera une NullPointerException si cle est
		// null.
		if (!contientCle(cle)) {
			map.add(new Paire<K, V>(cle, valeur));
			ajout = true;
		}
		return ajout;
	}

	/**
	 * Retourne vrai si ce TDAMap contient la cle donnee, faux sinon.
	 * 
	 * @param cle
	 *            la cle dont on teste l'existence.
	 * @return vrai si ce TDAMap contient la cle donnee, faux sinon.
	 * @throws NullPointerException
	 *             si cle est null.
	 */
	public boolean contientCle(K cle) {
		int i = 0;
		if (cle == null) {
			throw new NullPointerException();
		}
		// Parcourir la liste de paires cle/valeur pour trouver la paire ayant
		// la cle recherchee.
		while (i < map.size() && !map.get(i).getItem1().equals(cle)) {
			i++;
		}
		return i < map.size();
	}

	/**
	 * Retourne vrai si ce TDAMap contient au moins une valeur egale a la valeur
	 * donnee, faux sinon.
	 * 
	 * @param valeur
	 *            la valeur dont on teste l'existence.
	 * @return vrai si ce TDAMap contient la valeur donnee, faux sinon.
	 * @throws NullPointerException
	 *             si valeur est null.
	 */
	public boolean contientValeur(V valeur) {
		int i = 0;
		if (valeur == null) {
			throw new NullPointerException();
		}
		// Parcourir la liste de paires cle/valeur pour trouver une paire ayant
		// la valeur recherchee.
		while (i < map.size() && !map.get(i).getItem2().equals(valeur)) {
			i++;
		}
		return i < map.size();
	}

	/**
	 * Supprime de ce TDAMap l'association cle/valeur pour la cle donnee, si
	 * elle existe, et retourne la valeur associee a la cle donnee. Si la cle
	 * donnee n'existe pas, retourne null.
	 * 
	 * @param cle
	 *            la cle de l'association cle/valeur qu'on veut retirer de ce
	 *            TDAMap.
	 * @return la valeur associee a la cle donnee, si cette association existait
	 *         avant la suppression, null sinon.
	 * @throws NullPointerException
	 *             si cle est null.
	 */
	public V supprimer(K cle) {
		V valeur = null;
		int i = 0;
		if (cle == null) {
			throw new NullPointerException();
		}
		// Parcourir la liste de paires cle/valeur pour trouver la paire ayant
		// la cle recherchee.
		while (i < map.size() && !map.get(i).getItem1().equals(cle)) {
			i++;
		}
		if (i < map.size()) {
			valeur = map.remove(i).getItem2();
		}
		return valeur;
	}

	/**
	 * Retourne une chaine de caracteres representant ce TDAMap. La chaine doit
	 * etre forme comme suit : - une association cle/valeur par ligne - chaque
	 * association cle/valeur indiquee comme suit : cle --> valeur
	 * 
	 * @return ne chaine de caracteres representant ce TDAMap.
	 */
	public String toString() {
		String s = "";
		if (map.isEmpty()) {
			s = "VIDE";
		} else {
			for (Paire<K, V> p : map) {
				s = s + p.getItem1() + " --> " + p.getItem2() + "\n";
			}
		}
		return s;
	}

}
