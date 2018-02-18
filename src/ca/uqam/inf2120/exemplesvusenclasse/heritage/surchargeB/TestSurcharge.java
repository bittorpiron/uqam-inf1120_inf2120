/**
 * TestSurcharge.java
 */
package ca.uqam.inf2120.exemplesvusenclasse.heritage.surchargeB;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-02
 */
public class TestSurcharge {

	public static void main(String[] args) {
		Personne pers = new Personne();
		Employe emp = new Employe();
		Enseignant ens = new Enseignant();
		ens.valider(ens);
		ens.valider(emp);
		ens.valider(pers);
		}

}
