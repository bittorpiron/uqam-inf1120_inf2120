package ca.uqam.inf2120.tp3.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ca.uqam.inf2120.tp1.adt.Catalogue;
import ca.uqam.inf2120.tp1.adt.impl.CatalogueImpl;

/**
 * UQAM - Hiver 2014 - INF2120 - Groupe 30 - TP3
 * 
 * Classe GestionnaireInventairePneus : contient les services de gestion de
 * l'inventaire de pneus de NORDIC PNEUS.
 * 
 * @author Ismael Doukoure
 * 
 *         Complété par : Victor Piron PIRV11026606
 *         piron_mardones.victor@courrier.uqam.ca
 * 
 * @version 1er avril 2014
 */
public class GestionnaireInventairePneus {

	static private String ETE = "Été";
	static private String HIVER = "Hiver";

	// Le catalogue de pneus
	Catalogue<Pneu> catalogue;

	/**
	 * Constructeur sans argument qui crée un catalogue vide de pneus.
	 */
	public GestionnaireInventairePneus() {
		catalogue = new CatalogueImpl<Pneu>();
	}

	/**
	 * Ajouter un pneu dans l'inventaire.
	 * 
	 * @param unPneu
	 *            Le pneu à ajouter
	 */
	public void ajouterPneu(Pneu unPneu) {
		catalogue.ajouter(unPneu);
	}

	/**
	 * Trouver le pneu selon l'identifiant dans l'inventaire et modifier le pneu
	 * selon les informations du pneu passé en paramètre.
	 * 
	 * @param unPneu
	 *            Le pneu à modifier
	 */
	public void modifierPneu(Pneu unPneu) {

		Pneu monPneu;
		boolean trouve = false;
		ListIterator<Pneu> it = catalogue.iterateur();
		while (it.hasNext() && !trouve) {
			monPneu = it.next();
			if (monPneu.getIdentifiant() == unPneu.getIdentifiant()) {
				remplacerPneu(monPneu, unPneu);
			}
		}
	}

	/**
	 * @param originale
	 * @param nouveau
	 */
	public void remplacerPneu(Pneu originale, Pneu nouveau) {

		// Copier les attributs du nouveau Pneau dans celui du même Identifiant
		originale.setDiametreRoue(nouveau.getDiametreRoue());
		originale.setHauteur(nouveau.getHauteur());
		originale.setLargeur(nouveau.getLargeur());
		originale.setNombrePneus(nouveau.obtenirNbCopies());
		originale.setPrix(nouveau.getPrix());
		originale.setSaison(nouveau.getSaison());

	}

	/**
	 * Rechercher tous les pneus dont le diametre est égal au diamètre passé en
	 * paramètre et la saison est égale à la saison passée en paramètre.
	 * 
	 * @param diametre
	 *            Le diamètre du pneu recherché.
	 * @param saison
	 *            dont les valeurs possibles: 1 = Hiver, 2 = Été, 3 = Hiver et
	 *            Été
	 * @return Le tableau Liste (ArrayList) des pneus qui répondent au critère
	 *         de recherche.
	 */
	public List<Pneu> rechercherParDiametre(int diametre, int saison) {

		Pneu monPneu;
		List<Pneu> pneusTrouves = new ArrayList<Pneu>();

		ListIterator<Pneu> it = catalogue.iterateur();
		while (it.hasNext()) {
			monPneu = it.next();
			if (estEgaleDiametre(diametre, saison, monPneu)) {
				pneusTrouves.add(monPneu);
			}
		}
		return pneusTrouves;

	}

	/**
	 * @param diametre
	 *            Le diamètre du pneu recherché.
	 * @param saison
	 *            dont les valeurs possibles: 1 = Hiver, 2 = Été, 3 = Hiver et
	 *            Été
	 * @return vrai si diametre et saison(s) recherche(s) égales
	 */
	private boolean estEgaleDiametre(int diametre, int saison, Pneu monPneu) {
		return (monPneu.getDiametreRoue() == diametre)
				&& ((monPneu.getSaison().contentEquals(ETE) && saison > 1) || (monPneu
						.getSaison().contentEquals(HIVER) && (saison % 2 == 1)));

	}

	/**
	 * Rechercher tous les pneus selon une saison (ou les saisons) et dont le
	 * nombre de pneus est :
	 * 
	 * a) supérieur au paramètre "nombrePneus" si le paramètre "plusPetitOuEgal"
	 * est faux. b) inférieur ou égal au paramètre "nombrePneus" si le paramètre
	 * "plusPetitOuEgal" est vrai.
	 * 
	 * @param nombrePneus
	 *            Le nombre de pneus
	 * @param plusPetitOuEgal
	 *            Le flag qui indique le type de recherche selon le nombre de
	 *            pneus.
	 * @param saison
	 *            dont les valeurs possibles: 1 = Hiver, 2 = Été, 3 = Hiver et
	 *            Été
	 * @return Le tableau Liste (ArrayList) des pneus qui répondent au critère
	 *         de recherche.
	 */
	public List<Pneu> rechercherParNombre(int nombrePneus,
			boolean plusPetitOuEgal, int saison) {
		Pneu monPneau;
		List<Pneu> pneusTrouves = new ArrayList<Pneu>();

		ListIterator<Pneu> it = catalogue.iterateur();
		int nbrPneus = 0;
		while (it.hasNext()) {
			monPneau = it.next();
			nbrPneus = monPneau.obtenirNbCopies();
			if (((plusPetitOuEgal && nbrPneus <= nombrePneus) || (!plusPetitOuEgal && nbrPneus > nombrePneus))
					&& ((monPneau.getSaison().contentEquals(HIVER) && saison % 2 == 1) || (monPneau
							.getSaison().contentEquals(ETE) && saison > 1))) {

				pneusTrouves.add(monPneau);
			}
		}

		return pneusTrouves;

	}

	/**
	 * Rechercher tous les pneus selon la saison ou les saisons.
	 * 
	 * @param saison
	 *            dont les valeurs possibles: 1 = Hiver, 2 = Été, 3 = Hiver et
	 *            Été
	 * @return Le tableau Liste (ArrayList) des pneus qui répondent au critère
	 *         de recherche.
	 */
	public List<Pneu> rechercherTousLesPneus(int saison) {

		Pneu monPneau;
		List<Pneu> pneusTrouves = new ArrayList<Pneu>();

		ListIterator<Pneu> it = catalogue.iterateur();
		while (it.hasNext()) {
			monPneau = it.next();
			if (saison == 3) {

				pneusTrouves.add(monPneau);

			} else if ((monPneau.getSaison().contentEquals(HIVER) && saison == 1)
					|| (monPneau.getSaison().contentEquals(ETE) && saison == 2)) {

				pneusTrouves.add(monPneau);

			}
		}
		return pneusTrouves;

	}

	/**
	 * Supprime un pneu en diminuant le nombre et/ ou en le supprimer
	 * physiquement si le nombre de copies est <= 0.
	 * 
	 * @param unPneu
	 *            Le pneu à supprimer.
	 * @return Vrai si la suppression a été faite, sinon faux.
	 */
	public boolean supprimerPneu(Pneu unPneu) {

		return catalogue.supprimer(unPneu);
	}

}
