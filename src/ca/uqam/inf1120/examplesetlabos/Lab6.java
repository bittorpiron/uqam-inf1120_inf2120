package ca.uqam.inf1120.examplesetlabos;


/**
 * I N F x 1 2 0
 *
 * D�crivez votre classe Lab6 ici.
 * 
 * @author (votre nom) 
 * @version (une date)
 *
 * (votre code permanent)
 * (votre adresse de courriel)
 */
import java.text.*;  
public class Lab6 {
    
    static final DecimalFormat dec2 = new DecimalFormat ( "0.000000" );

    // Autres m�thodes s'il y a lieu
    public static void afficherMenu (){
            System.out.println("1 : Ajouter"); 
            System.out.println("2 : Soustraire ");
            System.out.println("3 : Multiplier ");
            System.out.println("4 : Diviser ");
            System.out.println("0 : Ce menu");        
    }

    public static void harmonique (int n){
        
        double somme;
        int i;
        
        if ( n < 0){
            System.out.print ( " valeur de n non valide ");
        }else{
            // Calcul de H(n) avec while
        
            somme = 1;
            i = 2;
        
            while ( i <= n ) {
                somme = somme + 1.0 / i;
                i = i + 1;
            }
        
            // Afficher le resultat
        
            System.out.println ( "H(" + n + ") = " + dec2.format (somme));
        }
    }
    
    
    public static void main (String[] params) {
//        int n;
       // afficherMenu();
       
//         System.out.print ( "Entrez un entier positive pour n : ");
//         n = Clavier.lireInt();
//         harmonique(n);

    for (int i = 1 ; i<=10; i++){
        harmonique(i);
    }
        
        
    } // main
    
} // Lab6
