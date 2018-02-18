package ca.uqam.inf1120.examplesetlabos.test;

import ca.uqam.inf1120.examplesetlabos.Clavier;


/**
 * I N F 1 1 2 0
 *
 * Ce programme sert à faire la démonstration du comportement d'un  programme
 * lors de la gestion d'exceptions. Dans ce programme, nous lançons "manuellement"
 * ArithmeticException lorsqu'il y a une division réelle par 0 (on se souvient que
 * la division réelle par 0 en java ne génère pas d'exception...).
 * 
 * Il est à noter que ce code n'est là que comme démonstrateur et qu'il y a place
 * à l'amélioration sur le plan efficacité (à vous de trouver :-)
 * 
 * @author (Céline Descheneaux) 
 * @version (10 décembre 2006)
 * @revision (30 novembre 2007)
 *
 * 
 * (uqam_inf1120@yahoo.ca)
 */
 
public class TestExceptions {

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
        
        //boucle servant à la gestion de 2 exceptions (dont 1 qui est volontairement lancée) 
        do{
            try{
                System.out.print ("Entrer une valeur pour le dividende : ");
                dividende = Clavier.lireDouble();
                System.out.print ("Entrer une valeur pour le diviseur (différent de 0) : ");
                diviseur = Clavier.lireDouble();
                
                //Comme la division réelle par 0 ne génère pas d'exception en java, 
                //nous lançons nous-même une exception si le diviseur est 0
                if (diviseur == 0) {
                    throw new ArithmeticException("Diviseur = 0 !");
                }//end if
                
                //si on arrive ici, c'est qu'aucune exception n'a été levée
                resultat = dividende/diviseur;
                operationReussie = true;
            } catch (NumberFormatException e){
                System.out.println("Vous devez entrer des NOMBRES\n");
            } catch (ArithmeticException e){
                System.out.println("MESSAGE = " + e.getMessage());
            }
                                          
        }while(!operationReussie);
        
        System.out.println(dividende + "/" + diviseur + " = " + resultat);
        System.out.println("FIN NORMALE DU PROGRAMME");
    
    } // main
    
} // TestExceptions
