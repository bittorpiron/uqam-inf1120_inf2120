package ca.uqam.inf1120.examplesetlabos;


/**
 * I N F x 1 2 0
 *
 * D�crivez votre classe SecToJour ici.
 * 
 * @author (votre nom) 
 * @version (une date)
 *
 * (votre code permanent)
 * (votre adresse de courriel)
 */
// import java.io.*;
public class SecToJour {

    // Autres m�thodes s'il y a lieu    
    public static void main (String[] params) {
       final int SECS_PAR_JOUR = 60*60*24;
       final int SECS_PAR_HEURE = 60*60;
       final int SECS_PAR_MIN = 60;       
       int secs = -1;
       
        do{
            System.out.print("Entrez un caracter: ");
            Clavier.lireCharLn();
            
            
            System.out.print("Entrez un nombre des secondes à transformer: ");
            secs = Clavier.lireInt();
               if (secs != 0){
                    if (secs < 0){
                        System.out.println("Un nombre POSITIF de secondes!");
                    }else{
                        Integer jours = secs / SECS_PAR_JOUR;
                        secs = secs % SECS_PAR_JOUR;
                        Integer heures = secs / SECS_PAR_HEURE;
                        secs = secs % SECS_PAR_HEURE;
                        Integer minutes = secs / SECS_PAR_MIN;
                        secs = secs % SECS_PAR_MIN;
                        
                        System.out.println(jours + " jours, " + heures + " heures, " + minutes + " minutes et " + secs + " secondes."); 
                    }                        
               }           
        } while (secs != 0)   ; 
    } // main
    
} // SecToJour
