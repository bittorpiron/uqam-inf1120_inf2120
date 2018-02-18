package ca.uqam.inf1120.examplesetlabos;

/**
 * I N F x 1 2 0
 *
 * Décrivez votre classe Version2 ici.
 * 
 * @author (votre nom) 
 * @version (une date)
 *
 * (votre code permanent)
 * (votre adresse de courriel)
 */

 
public class Version2 {

    // Autres méthodes s'il y a lieu    
    public static void main (String[] params) {
       int secs;
	   int minutes;
	   int heures;
       int jours;
       
       System.out.print("Entrez un nombre des secondes à transformer: ");
       secs = Clavier.lireInt(); 
	   
	   while (secs !=0 ){
                    if (secs < 0){
                        System.out.println("Un nombre POSITIF de secondes!");
                    }else{
					
						minutes = secs / 60;
						secs = secs % 60;
						heures = minutes / 60;
						minutes = minutes % 60;
						jours = heures / 24;
						heures = heures % 24;
                        System.out.println(jours + " jours, " + heures + " heures, " + minutes + " minutes et " + secs + " secondes."); 
                    }                        
                  
               System.out.print("Entrez un nombre des secondes à transformer: ");
               secs = Clavier.lireInt();
       } 
    } // main
    
} // Version2

