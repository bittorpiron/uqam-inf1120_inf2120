/**
 * TestSurcharge.java
 */
package ca.uqam.inf2120.exemplesvusenclasse.heritage.surchargeA;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-02
 */
public class TestSurcharge {

	public static void main(String[] args) {
		Object o = null;
		Personne pers = new Personne();
		pers.equals(o);
		pers.toString();
		Employe emp = new Employe();
		emp.equals(o);
		emp.toString();
		Enseignant ens = new Enseignant();
		ens.equals(o);
		ens.toString();
		pers = emp;
		pers.equals(o);
		pers.toString();
		pers = ens;
		pers.equals(o);
		pers.toString();

	}
}