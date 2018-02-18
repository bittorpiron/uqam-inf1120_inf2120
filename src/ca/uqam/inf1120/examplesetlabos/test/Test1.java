package ca.uqam.inf1120.examplesetlabos.test;


/**
 * I N F 1 1 2 0
 *
 * Décrivez votre classe Test1 ici.
 * 
 * @author (votre nom) 
 * @version (une date)
 *
 * (votre code permanent)
 * (votre adresse de courriel)
 */
 
public class Test1 {

    // Autres mï¿½thodes s'il y a lieu
    
    public static void main (String[] params) {
       //int secs;
	   int minutes;
	   int heures;
       int jours;
       
       int[] testCases={0, 23, 2489, 11842, 90777 };
       
       for (int secs : testCases){
       
      System.out.print( secs );     
       minutes = secs / 60;
	   secs = secs % 60;
	   heures = minutes / 60;
	   minutes = minutes % 60;
	   jours = heures / 24;
	   heures = heures % 24;
	   System.out.println(  " : " + jours + " jours, " + heures + " heures, " + minutes + " minutes et " + secs + " secondes.");           
       }       
    } // main
    
} // Test1
