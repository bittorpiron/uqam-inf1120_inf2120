package ca.uqam.inf2120.labos.heritage.tests;

import ca.uqam.inf2120.labos.heritage.Ordinateur;
import ca.uqam.inf2120.labos.heritage.Portable;
import ca.uqam.inf2120.labos.heritage.Table;

/**
 * 	Description: Classe pour tester Ordinateur et ses sous-classes
 * 
 * 	UQAM - INF2120
 * 
 * @author Gloire Lomani / Ismael Doukoure
 * @version Février 2014

 */
public class ProgrammePrincipal {
	
	private static final String ORDINATEUR = "\nOrdinateur : ";
	private static final String PORTABLE = "\nPortable : ";
	private static final String TABLE = "\nTable : ";
	
	public static void main(String[] args) {
		
		Ordinateur unOrdi = new Ordinateur ("MaxPc-400", "P4-3.2", 500, 500, 4);
		Portable unPortable = new Portable ("MaxPc-500", "P4", 2000, 750, 5, 2.4, 15, 2.5);
		Table uneTable = new Table ("Int6", "P3", 4000, 750, 5, 2, "alu");
		
		
		Ordinateur ordi = new Ordinateur ("MaxPc-400", "P4-3.2", 500, 500, 4);
		Ordinateur portable = new Portable ("MaxPc-500", "P4", 2000, 750, 5, 2.4, 15, 2.5);
		Ordinateur table = new Table ("Int6", "P3", 4000, 750, 5, 2, "alu");
		
		System.out.print("**************************************");
		System.out.println(ORDINATEUR + unOrdi);
		System.out.print("**************************************");
		System.out.println(PORTABLE + unPortable);
		System.out.print("**************************************");
		System.out.println(TABLE + uneTable);
		System.out.print("**************************************");
		
		
		System.out.print("**************************************");
		System.out.println(ORDINATEUR + ordi);
		System.out.print("**************************************");
		System.out.println(PORTABLE + portable);
		System.out.print("**************************************");
		System.out.println(TABLE + table);
		System.out.print("**************************************");
	}

}
