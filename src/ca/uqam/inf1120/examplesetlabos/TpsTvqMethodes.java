package ca.uqam.inf1120.examplesetlabos;

/*  -------------------
 *  TpsTvqMethodes.java
 *  -------------------
 *
 * Ce programme lit des montants d'argent.  Pour chacun, il affiche le montant
 * de la tps et le montant de la tvq.  A la fin, il affichera le total des
 * montants, de la tps, de la tvq et le grand total.
 *
 * ----------------------------------------------------------------------------
 * Auteur : Louise Laforest (laforest.louise@uqam.ca)
 * Date de creation (en Ada)  : 2 janvier 1998
 *    traduction en Java      : 2 octobre 2003
 *    modifi� le              : 30 septembre 2004
 *    modifi� le              : 9 octobre 2008 par C�line Descheneaux
 * ----------------------------------------------------------------------------
 */


import java.text.*; // pour utiliser DecimalFormat pour l'affichage de nombres r�els

public class TpsTvqMethodes {

    // D�clarations de constantes
  
    static final double TAUX_TPS = 0.07;     // 7 %
    static final double TAUX_TVQ = 0.06;    // 6 %

    static final DecimalFormat dec2 = new DecimalFormat ( "0.00" ); // pour l'affichage de r�els avec un format d�termin�
    
    // M�thodes
  
    static void presenterLogiciel () {
    
        System.out.print   ( "\n\n\n" );  //saut de 3 lignes
        System.out.println ( "Ce programme calcule, pour une suite de montants saisis, la tps" );
        System.out.println ( "et la tvq de chacun des montants, puis les montants totaux de"); 
        System.out.println ( "tps et de tvq, le total des montants et enfin le grand total.  \n" );
        System.out.print   ( "La tps est de " );
        System.out.print   ( dec2.format ( TAUX_TPS * 100.0 ) );
        System.out.print   ( " % et la tvq est de " );
        System.out.print   ( dec2.format ( TAUX_TVQ * 100.0 ) );
        System.out.print   ( " %.\n\n\n" );  //saut de 3 lignes
        
    } // end presenterLogiciel
    
    static void afficherMontantEtTaxes ( double montant, double tps, double tvq ) {
    
        System.out.print   ( "Montant           : " );
        System.out.println ( dec2.format ( montant ) );
        System.out.print   ( "Montant de la tps : " );
        System.out.println ( dec2.format ( tps ) );
        System.out.print   ( "Montant de la tvq : " );
        System.out.println ( dec2.format ( tvq ) );
        
    }// end afficherMontantEtTaxes
    
    static void afficherTotalFacture ( double montant, double tps, double tvq ) {
        
        System.out.print   ( "\n\nTotal de la facture : " );
        System.out.println ( dec2.format ( montant ) );
        System.out.print   ( "Total de la tps :     " );
        System.out.println ( dec2.format ( tps ) );
        System.out.print   ( "Total de la tvq :     " );
        System.out.println ( dec2.format ( tvq ) );
        System.out.print   ( "Grand total :         " ); 
        System.out.println ( dec2.format ( montant + tps + tvq ) );

    }//end afficherTotalFacture
    
    static double lireEtValiderMontant (){
        
        //variable locale
        double montant; //contiendra le montant valid� � retourner

        System.out.print ( "Veuillez entrer un montant (0 pour terminer) : " );
        montant = Clavier.lireDouble();

        while ( montant < 0 ) {
            // montant saisi non valide
            System.out.println ( "*** Le montant doit �tre plus grand ou �gal � 0." );
            System.out.print ( "Veuillez entrer un montant : " );
            montant = Clavier.lireDouble();
        }//end while ( montantLu < 0 )
        
        return montant;
        
    }//end lireEtValiderMontant

    public static void main ( String [] args ) { // main
  
        // D�clarations de variables
    
        double          montantLu;            // montant saisi
        double          tps;                  // tps sur le montant saisi
        double          tvq;                  // tvq sur le montant saisi
        double          montantTotal;         // total courant des montants saisis
        double          tpsTotale;            // total de la tps
        double          tvqTotale;            // total de la tvq
     
 
        // Initialisations
        
        montantTotal = 0;
        
        // Pr�sentation du logiciel
		
        presenterLogiciel ();
    
        // Saisie d'un montant      
        montantLu = lireEtValiderMontant();

    
        while ( montantLu != 0 ) { // boucle principale
    
            // calcul des taxes
            montantTotal = montantTotal + montantLu; 
            tps = montantLu * TAUX_TPS;
            tvq = ( montantLu + tps ) * TAUX_TVQ;
                
            afficherMontantEtTaxes ( montantLu, tps, tvq );
                      
            montantLu = lireEtValiderMontant();

        } // end while ( montantLu != 0 )
    
        // Calcul des taxes totales ainsi que du grand total
    
        tpsTotale = montantTotal * TAUX_TPS;
        tvqTotale = ( montantTotal + tpsTotale ) * TAUX_TVQ;
    
        // Affichage de la facture
    
        afficherTotalFacture ( montantTotal, tpsTotale, tvqTotale );
        
        // ou bien :
        // afficherTotalFacture ( montantTotal, montantTotal * TAUX_TPS, ( montantTotal + montantTotal * TAUX_TPS ) * TAUX_TVQ );
        // � ce moment l�, les deux variables tpsTotale et tvqTotale deviennent inutiles.
		
    } // main
  
} // TpsTvq2methode
