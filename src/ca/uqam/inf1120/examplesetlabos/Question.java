package ca.uqam.inf1120.examplesetlabos;


/**
 * I N F 1 1 2 0
 *
 * D�crivez votre classe Question ici.
 * 
 * @author (votre nom) 
 * @version (une date)
 *
 * (votre code permanent)
 * (votre adresse de courriel)
 */
 
public class Question { // 1
public static void main ( String[] args ) { // 2
final double TAUX_TPS = 0.07 ;// 3
final double TAUX_TVQ = 0.075; // 4
double achat; // montant des achats effectués // 5
double montantTps; // montant calculé de TPS // 6
double montantTvq; // montant calculé de TVQ // 7
double total; // total des achats et des taxes // 8
System.out.println ("VENTE - Calculer les taxes de vente et le grand total" );// 9
System.out.println (); // 10
System.out.print ("Entrer le montant des achats : "); // 11
achat = Clavier.lireDouble(); // 12
if (! ((achat == 0.0) || (achat < 0.0)) ) { // 13
// bloc des calculs // 14
montantTps = achat * TAUX_TPS; // 15
montantTvq = (achat + montantTps) * TAUX_TVQ; // 16
total = achat + montantTps + montantTvq; // 17
System.out.println (); // 18
System.out.println ("Le montant des achats : " + achat); // 19
System.out.println ("Le montant de la TPS : " + montantTps); // 20
System.out.println ("Le montant de la TVQ : " + montantTvq); // 21
System.out.println ("Le montant total : " + total); // 22
}else { // 23
System.out.println ("Le montant des achats est nul ou négatif."); // 24
} // 25
}
}
