package ca.uqam.inf1120.examplesetlabos.test;

import ca.uqam.inf1120.examplesetlabos.Clavier;
import ca.uqam.inf1120.examplesetlabos.MonExcep;


/**
 * I N F 1 1 2 0
 *
 * Ce programme sert à faire la démonstration du comportement d'un  programme
 * lors de la gestion d'exceptions "maison" et d'exception déjà connue de Java.
 * Il est à noter que ce code n'est là que comme démonstrateur et qu'il y a place
 * à l'amélioration sur le plan efficacité (à vous de trouver :-)
 * 
 * @author (Céline Descheneaux) 
 * @version (10 décembre 2006)
 *
 * 
 * (uqam_inf1120@yahoo.ca)
 */
 
public class TestExceptions2A {

    // Autres méthodes s'il y a lieu
    
    public static void main (String[] params) {
        
        //sentinelle servant à déterminer si la division réelle a été effectuée
        //avec succès avec des valeurs valides
        boolean operationReussie = false;  
        
        //variables servant à contenir les valeurs du dividende, du diviseur 
        //et du résultat de l'opération de division
        double dividende = -1; //initialisation à une valeur bidon pour que ça compile...
        double diviseur = -1;  //initialisation à une valeur bidon pour que ça compile...
        double resultat = -1;  //initialisation à une valeur bidon pour que ça compile...
        
        //boucle servant à la gestion de 2 exceptions (dont 1 "maison") 
        do{
            try{
                System.out.print ("Entrer une valeur pour le dividende : ");
                dividende = Clavier.lireDouble();
                System.out.print ("Entrer une valeur pour le diviseur (différent de 0) : ");
                diviseur = Clavier.lireDouble();
                
                //si le diviseur est 0, lancer une exception
                if (diviseur == 0) {
                    throw new MonExcep("Diviseur = 0 !");
                }//end if
                
                //si on arrive ici, c'est qu'aucune exception n'a été levée
                resultat = dividende/diviseur;
                operationReussie = true;
            } catch (NumberFormatException e){
                System.out.println("Vous devez entrer des NOMBRES\n");
            } catch (MonExcep e){
                System.out.println("Message = " + e.getMessage());
            }
                                          
        }while(!operationReussie);
        
        System.out.println(dividende + "/" + diviseur + " = " + resultat);
        System.out.println("FIN NORMALE DU PROGRAMME");
    
    } // main
    
} // TestExceptions2A
