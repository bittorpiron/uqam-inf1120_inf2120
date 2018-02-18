package ca.uqam.inf1120.tps;


/**
 * INF1120 Groupe 30
 * Céline Descheneaux
 *
 *
 * Tp1Gr30.
 * Logiciel de gestion des commandes pour Le restaurant « Pepere Ronni ».
 * Version de demonstration.
 * 
 * 
 * Calcul des prix des pizzas en fonction des options choisies par les clients.
 * Les choix offerts sont:
 * - Taille 
 * - Nombre des garnitures
 * - Garmitures 
 * - Extras (fromage, pepperoni)
 * 
 * Le programme affiche alors les prix unitaire après la composition de chaque pizza.
 * 
 * Le programme termine après une réponse négative à la question de commande d'une pizza
 * en affichant certaines statistiques.
 * 
 * Si l'utilisateur donne une réponse négative dès le départ,le programme se termine avec
 * une message du genre « Au Revoir » et aucune statistique n'est affichée.
 * Statistiques de fin de programme:
 * - le nombre total de pizzas traitées (tous formats confondus)
 * - combien de fois on a demandé 0 garniture supplémentaire.
 * - combien de fois on a demandé 2 garnitures supplémentaires
 * - combien de fois on a demandé un extra fromage
 * - combien de fois on a demandé un extra pepperoni
 * 
 * 
 * @author PIRON, Victor 
 * @version 19-10-2013
 * 
 * PIRV11026606
 * piron.victor@courrier.uqam.ca
 * 
 */

import java.text.*;

import ca.uqam.inf1120.examplesetlabos.Clavier;
 
public class Tp1Gr30 {
       
    public static final double PRIX_PETITE = 12.85;
    public static final double PRIX_MOYENNE = 17.85;
    public static final double PRIX_GROSSE = 22.25;
    
    public static final double PRIX_PIMENTS = 0.75;
    public static final double PRIX_OIGNONS = 0.50;
    public static final double PRIX_BACON = 1.65;
    public static final double PRIX_CHAMPIGNONS = 1.00;
    public static final double PRIX_VIANDE_FUMEE = 2.00;
    public static final double PRIX_OLIVES = 0.85;
    
    public static final double PRIX_EXTRA_FROMAGE = 1.75;
    public static final double PRIX_EXTRA_PEPPERONI = 1.50;
    
    public static DecimalFormat dec2 = new DecimalFormat ( "0.00" );

    // Autres m�thodes s'il y a lieu
        
    public static void main (String[] params) {
                 
        int cptPizzas = 0;
        int cptZeroGarnitures = 0;
        int cptDeuxGarnitures = 0;
        int cptExtraFromage = 0;
        int cptExtraPepperoni = 0;
        char repOuiNon;
        int choixMenu;
        int choixMenuPrev;
        int nbrDeGarnitures;
        double prixPizza;
        
        System.out.println("*********************************************************************************");
        System.out.println("*                       Logiciel de gestion des commandes                       *");
        System.out.println("*********************************************************************************");
        System.out.println("* Version de demonstration:                                                     *");
        System.out.println("* Calcul des prix des pizzas en fonction des options choisies par les clients.  *");
        System.out.println("*********************************************************************************");
        System.out.println();
                
        System.out.print("Voulez-vous commander une pizza? ('o', 'O', 'n', ou 'N') : ");        
        repOuiNon=Character.toUpperCase(Clavier.lireCharLn());       
        
        while ( !( repOuiNon == 'O' || repOuiNon == 'N' ) ){
            
            System.out.println("Erreur, choix non valide. ");        
            System.out.print("Voulez-vous commander une pizza? ('o', 'O', 'n', ou 'N') : ");
            repOuiNon = Character.toUpperCase(Clavier.lireCharLn());
            System.out.println();
            
        }//validation
        
        while ( repOuiNon == 'O' ){                     
         
            System.out.println();
            System.out.println("CHOIX DES TAILLES\n");
            System.out.println("1 – Petite");
            System.out.println("2 - Moyenne");
            System.out.println("3 - Grosse");
            System.out.println();

            System.out.print("Entrez votre choix (1, 2 ou 3) : ");
            
            choixMenu = Clavier.lireInt();
            System.out.println();            
            
            while ( choixMenu > 3 || choixMenu < 1 ){
                
                System.out.println("Erreur, le numero doit etre entre 1 et 3 inclusivement");        
                System.out.print("Entrez votre choix (1, 2 ou 3) : ");
                choixMenu = Clavier.lireInt();
                System.out.println();
                
            }//validation
            
            if ( choixMenu == 1 ){
                
                prixPizza = PRIX_PETITE;
                
            }else if(choixMenu == 2){
                
                prixPizza = PRIX_MOYENNE;
                
            }else{
                
                prixPizza = PRIX_GROSSE;
                
            }
            
            System.out.print("Entrez le nombre de garnitures supplémentaires  (0, 1 ou 2) : ");
            nbrDeGarnitures = Clavier.lireInt(); 
            System.out.println("");
            
            while ( nbrDeGarnitures > 2 || nbrDeGarnitures < 0 ){
                
                System.out.println("Erreur, le numero doit etre entre 0 et 2 inclusivement");        
                System.out.print("Entrez votre choix (0, 1 ou 2) : ");
                nbrDeGarnitures = Clavier.lireInt();
                System.out.println();
                
            }//validation
                                                     
            if( nbrDeGarnitures == 0 ){
                
                cptZeroGarnitures = cptZeroGarnitures + 1;                

            }else{
                                           
                System.out.println("CHOIX DES GARNITURES\n");
                System.out.println("1 – Piments");
                System.out.println("2 - Oignons");
                System.out.println("3 - Bacon");
                System.out.println("4 – Champignons");
                System.out.println("5 - Viande fumee");
                System.out.println("6 - Olives");
                System.out.println();
                
                choixMenuPrev = 0;
                
                for ( int garniture = 1; garniture <= nbrDeGarnitures; garniture++ ){
                    
                    if (garniture == 1){
                        
                        System.out.print("Entrez votre choix (1, 2, 3, 4, 5, ou 6) : ");
                        
                    }else{
                        
                        cptDeuxGarnitures = cptDeuxGarnitures + 1;                    
                        System.out.print("Entrez votre deuxieme choix (1, 2, 3, 4, 5, ou 6) : ");
                        
                    }                    
                    
                    choixMenu = Clavier.lireInt();
                    System.out.println("");
                                        
                    if (garniture == 1){
                        
                        while (choixMenu < 1 || choixMenu > 6 ){
                            
                            System.out.println("Erreur, le numero doit etre entre 1 et 6 inclusivement");        
                            System.out.print("Entrez votre choix 1, 2, 3, 4, 5, ou 6) : ");
                            choixMenu = Clavier.lireInt();
                            System.out.println("");
                            
                        }//validation un choix
                        
                        choixMenuPrev = choixMenu;
                        
                    }else{
                        
                        while (choixMenu < 1 || choixMenu > 6 || choixMenu == choixMenuPrev){
                            
                            if(choixMenu == choixMenuPrev){                        
                                
                                 System.out.println("Erreur, vous avez deja choisi cette garniture");
                                 
                            }else{
                                
                                System.out.println("Erreur, le numero doit etre entre 1 et 6 inclusivement");
                                
                            }
                                
                            System.out.print("Entrez votre deuxieme choix (1, 2, 3, 4, 5, ou 6) : ");
                            choixMenu = Clavier.lireInt();
                            System.out.println("");
                            
                        }//validation deuxieme choix
                        
                    } // validation                 
                    
                    switch (choixMenu){  
                        
                        case 1 :
                            prixPizza = prixPizza + PRIX_PIMENTS;
                            break;
                            
                        case 2 :   
                            prixPizza = prixPizza + PRIX_OIGNONS;
                            break;
                            
                        case 3 :
                            prixPizza = prixPizza + PRIX_BACON;
                            break;
                            
                        case 4 :   
                            prixPizza = prixPizza + PRIX_CHAMPIGNONS;
                            break;
                            
                        case 5 :
                            prixPizza = prixPizza + PRIX_VIANDE_FUMEE;
                            break;
                            
                        case 6 :   
                            prixPizza = prixPizza + PRIX_OLIVES; 
                            break;
                            
                        default:
                            break;
                            
                    }  
                    
                } 
                
            } 
            
            System.out.print("Voulez-vous commander un extra fromage? ('o', 'O', 'n', ou 'N') : ");        
            repOuiNon=Character.toUpperCase(Clavier.lireCharLn());
            System.out.println();
            
            while ( !( repOuiNon == 'O' || repOuiNon == 'N' ) ){
                
                System.out.println("Erreur... ");        
                System.out.print("Voulez-vous commander un extra fromage? ('o', 'O', 'n', ou 'N') : ");
                repOuiNon=Character.toUpperCase(Clavier.lireCharLn());
                System.out.println();
                
            }//validation
            
            if (repOuiNon == 'O' ){
                
                prixPizza = prixPizza + PRIX_EXTRA_FROMAGE;
                cptExtraFromage = cptExtraFromage + 1;
                
            }
            
            System.out.print("Voulez-vous commander un extra pepperoni? ('o', 'O', 'n', ou 'N') : ");        
            repOuiNon=Character.toUpperCase(Clavier.lireCharLn());
            System.out.println();
            
            while ( !( repOuiNon == 'O' || repOuiNon == 'N' ) ){
                
                System.out.println("Erreur... ");        
                System.out.print("Voulez-vous commander un extra pepperoni? ('o', 'O', 'n', ou 'N') : ");
                repOuiNon=Character.toUpperCase(Clavier.lireCharLn());
                System.out.println("");
                
            }//validation
                  
            if ( repOuiNon == 'O' ){
                
                prixPizza = prixPizza + PRIX_EXTRA_PEPPERONI;
                cptExtraPepperoni = cptExtraPepperoni + 1;
                
            }

            cptPizzas = cptPizzas + 1;
            
            System.out.println("Prix total de la pizza : " + (dec2.format(prixPizza)) + " $" );
            System.out.println();
                        
            System.out.print("Voulez-vous commander une nouvelle pizza? ('o', 'O', 'n', ou 'N') : ");        
            repOuiNon=Character.toUpperCase(Clavier.lireCharLn());   
            
            while ( !(repOuiNon == 'O' || repOuiNon == 'N' ) ){
                
                System.out.println("Erreur, choix non valide");        
                System.out.print("Voulez-vous commander une nouvelle pizza? ('o', 'O', 'n', ou 'N') : ");
                repOuiNon=Character.toUpperCase(Clavier.lireCharLn());
                System.out.println();
                
            }//validation      
            
        }// repOuiNon nouvelle pizza
        
        System.out.println();
        
        if (cptPizzas == 0){            
            
            System.out.println("Au revoir");
            
        } else{
            
            System.out.println("Nombre total de pizzas traitées (tous formats confondus) : " + cptPizzas);
            System.out.println("Nombre de fois qu'on a demande 0 garniture supplementaire : " + cptZeroGarnitures);
            System.out.println("Nombre de fois qu'on a demande 2 garnitures supplémentaires : " + cptDeuxGarnitures);
            System.out.println("Nombre de fois qu'on a demande un extra fromage : " + cptExtraFromage);
            System.out.print("Nombre de fois qu'on a demande un extra pepperoni : " + cptExtraPepperoni);
            
        }
        
    } // main
    
} // Tp1Gr30
