/**
 * Test.java
 */
package ca.uqam.inf2120.revisionIntra.tda_genericite;

/**
 * @author Victor Piron PIRV11026606 INF2120 Groupe 30 (Ismaël Doukoure)
 *         piron.victor@courrier.uqam.ca
 * @version 2014-03-07
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TDAMap avec cles de type Integer et valeurs de type String
		TDAMap<Integer, String> map = new MapArrayList<Integer, String>();
		System.out.println("------------------------");
		System.out.println("TESTS DANS MAP VIDE");
		System.out.println("------------------------");
		System.out.println(map.estVide() + " (true)");
		System.out.println((map.taille() == 0) + " (true)");
		map.vider();
		System.out.println(map.estVide() + " (true)");
		System.out.println((map.taille() == 0) + " (true)");
		System.out.println(map.obtenir(2) + " (null)");
		System.out.println((map.contientCle(2)) + " (false)");
		System.out.println((map.contientValeur("bettrave")) + " (false)");
		System.out.println(map.supprimer(2) + " (null)");
		System.out.println(map + " (VIDE)");
		System.out.println("------------------------");
		System.out.println("TESTS AVEC PARAM NULL");
		System.out.println("------------------------");
		try {
			map.obtenir(null);
			System.out
					.println("ERREUR... Devrait lever une NullPointerException.");
		} catch (NullPointerException npe) {
			System.out.println("OK... NullPointerException.");
		}
		try {
			map.ajouter(null, "toto");
			System.out
					.println("ERREUR... Devrait lever une NullPointerException.");
		} catch (NullPointerException npe) {
			System.out.println("OK... NullPointerException.");
		}
		try {
			map.ajouter(1, null);
			System.out
					.println("ERREUR... Devrait lever une NullPointerException.");
		} catch (NullPointerException npe) {
			System.out.println("OK... NullPointerException.");
		}
		try {
			map.contientCle(null);
			System.out
					.println("ERREUR... Devrait lever une NullPointerException.");
		} catch (NullPointerException npe) {
			System.out.println("OK... NullPointerException.");
		}
		try {
			map.contientValeur(null);
			System.out
					.println("ERREUR... Devrait lever une NullPointerException.");
		} catch (NullPointerException npe) {
			System.out.println("OK... NullPointerException.");
		}
		try {
			map.supprimer(null);
			System.out
					.println("ERREUR... Devrait lever une NullPointerException.");
		} catch (NullPointerException npe) {
			System.out.println("OK... NullPointerException.");
		}
		System.out.println("------------------------");
		System.out.println("TESTS AJOUTER");
		System.out.println("------------------------");
		map.ajouter(1, "banane");
		System.out.println(map.taille() + " (1)");
		System.out.println(map.estVide() + " (false)");
		System.out.println(map + "\t1 --> banane");
		System.out.println(map.ajouter(2, "tomate") + " (true)");
		System.out.println(map.ajouter(6, "pomme") + " (true)");
		System.out.println(map.ajouter(4, "celeri") + " (true)");
		System.out.println(map.ajouter(9, "patate") + " (true)");
		System.out.println(map.ajouter(5, "tomate") + " (true)");
		System.out.println(map.ajouter(2, "piment") + " (false)");
		System.out.println(map.ajouter(1, "piment") + " (false)");
		System.out.println(map.ajouter(5, "piment") + " (false)");
		System.out.println(map.ajouter(9, "piment") + " (false)");
		System.out.println(map.taille() + " (6)");
		System.out.println(map.estVide() + " (false)");
		System.out.println(map + "\t1 --> banane");
		System.out.println("\t2 --> tomate");
		System.out.println("\t6 --> pomme");
		System.out.println("\t4 --> celeri");
		System.out.println("\t9 --> patate");
		System.out.println("\t5 --> tomate");
		map.ajouter(10, "piment");
		map.ajouter(23, "raisins");
		map.ajouter(3, "raisins");
		System.out.println("\nMAP FINAL :\n" + map);
		System.out.println("------------------------");
		System.out.println("TESTS CONTIENT CLE");
		System.out.println("------------------------");
		System.out.println(map.contientCle(1) + " (true)");
		System.out.println(map.contientCle(23) + " (true)");
		System.out.println(map.contientCle(5) + " (true)");
		System.out.println(map.contientCle(7) + " (false)");
		System.out.println("------------------------");
		System.out.println("TESTS CONTIENT VALEUR");
		System.out.println("------------------------");
		System.out.println(map.contientValeur("banane") + " (true)");
		System.out.println(map.contientValeur("raisins") + " (true)");
		System.out.println(map.contientValeur("pomme") + " (true)");
		System.out.println(map.contientValeur("citron") + " (false)");
		System.out.println("------------------------");
		System.out.println("TESTS OBTENIR");
		System.out.println("------------------------");
		System.out.println(map.obtenir(1) + " (banane)");
		System.out.println(map.obtenir(3) + " (raisins)");
		System.out.println(map.obtenir(4) + " (celeri)");
		System.out.println(map.obtenir(9) + " (patate)");
		System.out.println(map.obtenir(7) + " (null)");
		System.out.println(map.obtenir(0) + " (null)");
		System.out.println("------------------------");
		System.out.println("TESTS SUPPRIMER");
		System.out.println("------------------------");
		System.out.println(map.supprimer(4) + " (celeri)");
		System.out.println(map.supprimer(1) + " (banane)");
		System.out.println(map.supprimer(3) + " (raisins)");
		System.out.println(map.supprimer(3) + " (null)");
		System.out.println(map.supprimer(24) + " (null)");
		System.out.println(map.supprimer(0) + " (null)");
		System.out.println(map.contientCle(4) + " (false)");
		System.out.println(map.contientValeur("celeri") + " (false)");
		System.out.println(map.contientCle(1) + " (false)");
		System.out.println(map.contientValeur("banane") + " (false)");
		System.out.println(map.contientCle(3) + " (false)");
		System.out.println(map.contientValeur("raisins") + " (true)");
		System.out.println("------------------------");
		System.out.println("TESTS VIDER");
		System.out.println("------------------------");
		System.out.println("MAP AVANT VIDER : ");
		System.out.println(map.taille() + " (6)");
		System.out.println(map);
		map.vider();
		System.out.println("MAP APRES VIDER :");
		System.out.println(map.taille() + " (0)");
		System.out.println(map);
	}

}
