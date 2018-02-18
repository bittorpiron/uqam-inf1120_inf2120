package ca.uqam.inf1120.tps;

import ca.uqam.inf1120.examplesetlabos.Clavier;


/**
 * I N F 1 1 2 0  G R O U P E 3 0
 * (Céline Descheneaux)
 *
 * Decrivez votre classe Tp2Gr30 ici.
 * 
 * @author Victor Piron 
 * @version (20-10-2013)
 *
 * PIRV11026606
 * piron.victor@courrier.uqam.ca
 *
 */
 
public class Tp2Gr30 {

    public static final int NO_COEUR = 1;
    public static final int NO_PIQUE = 2;
    public static final int NO_TREFLE = 3;
    public static final int NO_CARREAU = 4;
    
    public static final int NO_ROUGE = 1;
    public static final int NO_NOIRE = 2;
    
    public static final int MAX_COULEUR = 2;
    public static final int MAX_SYMBOLE = 4;
    public static final int MAX_VALEUR = 13;
    
    public static final int NO_CHOIX_COULEUR = 1;
    public static final int NO_CHOIX_SYMBOLE = 2;
    public static final int NO_CHOIX_VALEUR = 3;
    
    public static final String COEUR = "coeur";
    public static final String PIQUE = "pique"; 
    public static final String TREFLE = "trefle"; 
    public static final String CARREAU = "carreau";
    
    public static final String ROUGE = "rouge";
    public static final String NOIRE = "noire";     
    
    public static final String MSG_JOUER = "\nVoulez-vous jouer oui ('O', 'o') ou non ('N', 'n')? : ";
    public static final String MSG_JOUER_ENCORE = "\nVoulez-vous jouer a nouveau oui ('O', 'o') ou non ('N', 'n')? : "; 
    public static final String MSG_ERREUR_REPONSE_NON_VALIDE = "\nErreur, reponse non valide !";
    
    public static final String MSG_DEVINEZ_COULEUR = "DEVINEZ LA COULEUR DE LA CARTE";
    public static final String MSG_DEVINEZ_SYMBOLE = "DEVINEZ LE SYMBOLE DE LA CARTE";
    public static final String MSG_DEVINEZ_VALEUR = "DEVINEZ LA VALEUR DE LA CARTE";
    
    public static final String MSG_ENTREZ_COULEUR = "Entrez la couleur de la carte (rouge, noire) : ";
    public static final String MSG_ENTREZ_SYMBOLE = "Entrez le symbole de la carte (pique, coeur, carreau, trefle) : ";
    public static final String MSG_ENTREZ_VALEUR = "Entrez la valeur de la carte (entier de 1 a 13 inclusivement) : ";
    
    public static final String MSG_FELICITATIONS =  "\n\tFELICITATIONS!\n";
     
    public static final String MSG_ERREUR_CHOIX = "\nERREUR, choix invalide !";
    
    public static final String MSG_DESOLE = "\n\tDESOLE, il ne vous reste plus de chances\n";
 
    public static final String MSG_BONNE_COULEUR = "La bonne couleur est : ";
    public static final String MSG_BON_SYMBOLE = "Le bon symbole est : ";
    public static final String MSG_BONNE_VALEUR = "La bonne valeur est : ";
     
    public static final String MSG_POINTAGE_DIVINATION = "Nombre de points pour cette divination = ";
    public static final String MSG_POINTAGE_TOTALE = "Nombre Totale de points pour la partie = "; 
    public static final String MSG_NBR_CARTES = "\nNombre de cartes tirees : ";
    
    // Autres méthodes
    /**
     * Affiche la preséntation du logiciel.
     */
    public static void presenterLogiciel(){

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------           CHOIX DU TEST DE DIVINATION          ------------------");
        System.out.println("--------   (Programme qui test la faculte de clairvoyance de l'utilisateur)  --------");
        System.out.println("-------------------------------------------------------------------------------------");
     
        System.out.println("\nLe programme propose aux utilisateurs d'essayer de deviner une carte tiree au hasard.\n");
        System.out.println("No CHOIX\tDIVINATION\t\t\t\t\t\t\t\t\tNOMBRE D'ESSAIS");
        System.out.println("   1\t\tLa couleur (noire ou rouge)\t\t\t\t\t1 essai");
        System.out.println("   2\t\tLe symbole (coeur, pique,trefle, carreau)\t2 essais");
        System.out.println("   3\t\tLa valeur (nombre de 1 a 13 inclusivement)\t5 essais");
    
        System.out.println("\nLe nombre des points en jeu pour chaque tirage est egale au nombre d'essais");
        System.out.println("disponible pour le choix du test, et chaque essai rate, enleve un point au");
        System.out.println("pointage de la divination.");        
        System.out.println("Tant que l'utilisateur veut jouer, le programme tire une nouvelle carte.");
        System.out.println("\n-------------------------------------------------------------------------------------");
 
    }//fin afficherPresentation
        
    public static int afficherMenuRetournerChoix(){
        
        int choixMenu=0;
        
        System.out.println("\nCHOIX DU TEST DE DIVINATION");
        System.out.println("1 - Deviner la couleur de la carte");
        System.out.println("2 - Deviner le symbole de la carte");
        System.out.println("3 - Deviner la valeur de la carte");
        
        System.out.print("\nEntrez votre choix (1, 2, ou 3) : ");
        choixMenu=Clavier.lireInt();
        
        while ( choixMenu < NO_CHOIX_COULEUR ||  choixMenu > NO_CHOIX_VALEUR){
            
            System.out.println(MSG_ERREUR_CHOIX);
            System.out.print("Entrez votre choix (1, 2, ou 3) : ");
            
            choixMenu = Clavier.lireInt(); 
        }

        return choixMenu;
        
    }//fin afficherMenuRetournerChoix
      
    public static boolean jouerEncore(String msgJouer){
        
        char repOuiNon;
        boolean reponse = false;
      
        System.out.print(msgJouer);   
        repOuiNon=Character.toUpperCase(Clavier.lireCharLn());  
               
        while ( !( repOuiNon == 'O' || repOuiNon == 'N' ) ){
            
            System.out.println(MSG_ERREUR_REPONSE_NON_VALIDE);        
            System.out.print(msgJouer);
            repOuiNon = Character.toUpperCase(Clavier.lireCharLn());
             
        }//validation
                      
        if (repOuiNon=='O'){
            reponse = true;
        }
        
        return reponse;
    }//fin jouerEncore
    
    /**
     * Retourne un nombre aléatoire compris entre 1 et le nombre reçu en paramètre.
     */
    public static int genererNombre ( int max ){
        return (int)(Math.floor(max * Math.random()) + 1);
    }//fin genererNombre
    
    /**
    * Retourne un nombre aléatoire selon le choix de menu reçu en paramètre.
    */
    
    public static int  genererNombreSelonChoix ( int choixMenu ){
        
        int valMax = 0;
        
        switch (choixMenu){
            case 1:
                    valMax = MAX_COULEUR;
                    break;
                    
            case 2:
                    valMax = MAX_SYMBOLE;
                    break;
                    
            case 3: 
                    valMax = MAX_VALEUR;
                    break;
                    
            default:
                    break;
        }
        
        return genererNombre(valMax);
        
    }//fin genererNombreSelonChoix
    
    /**
     * Retourne le nom du symbole qui correspond au numéro reçu en paramètre.
     */
    public static String retournerNomSymbole(int noSymbole){
        
        String nomSymbole = "";
        
        switch (noSymbole){

               case NO_COEUR :
                                nomSymbole = COEUR;
                                break;
               case NO_PIQUE :
                                nomSymbole = PIQUE;
                                break;
               case NO_TREFLE : 
                                nomSymbole = TREFLE;
                                break;
               case NO_CARREAU :
                                nomSymbole = CARREAU;
                                break; 
               default:
                                break;
        }            
        return nomSymbole;
    }

    /**
     * Retourne le chiffre correspondant au nom du symbole reçu en paramètre.
     * On assume que le nom du symbole a été préalablement validé.
     */
    public static int retournerNumeroSymbole(String symbole){
        
        int noSymbole;
        
        if ( symbole.equals(COEUR) ){
            
            noSymbole = NO_COEUR;
            
        } else if ( symbole.equals(PIQUE) ){
            
            noSymbole = NO_PIQUE;
            
        } else if ( symbole.equals(TREFLE) ){
            
            noSymbole = NO_TREFLE;
            
        } else {
            
            noSymbole = NO_CARREAU;
            
        } 
        
        return noSymbole;
    }
    
    /**
     * Retourne le nom de la couleur qui correspond au numéro reçu en paramètre.
     */
    public static String retournerNomCouleur(int noCouleur){
        
        String nomCouleur;
        
        if (noCouleur == NO_ROUGE ){
        
            nomCouleur = ROUGE;
            
        }else{
            
            nomCouleur = NOIRE;

        }            
        return nomCouleur;
    }

    /**
     * Retourne le chiffre correspondant au nom de la couleur reçu en paramètre.
     * On assume que le nom de la couleur a été préalablement validé.
     */
    public static int retournerNumeroCouleur(String couleur){
        
        int noCouleur;
        
        if ( couleur.equals(ROUGE) ){
            
            noCouleur = NO_ROUGE;
            
        }  else {
            
            noCouleur = NO_NOIRE;
        } 
        
        return noCouleur;        
    }
       
    /**
     * Calcule le nombre d’essais permis selon le paramètre choixMenu.
     * Gére les messages selon le choix de Couleur, Symbole ou Valeur.
     * Démande à l'utilisateur d'entrér sa divination et la compare avec celle la valeur reçue comme paramètre.
     * En cas d'échec, cette demande se répete autant des foix comme le nombre d’essais calculé.
     * Retourne vrai/faux selon le resultat de la divination (après tous les essais) de la divination.
     * 
     * On assume que la valeur de choixMenu a été préalablement validé.
     */
    public static int retournerNombreReponse (int choix){
        
        String choixChaineCaracteres;        
        int choixEntier = 0;
        
        switch ( choix ){
            case NO_CHOIX_COULEUR:                                                                    
                    System.out.println( MSG_DEVINEZ_COULEUR );
                    System.out.print ( MSG_ENTREZ_COULEUR );

                    choixChaineCaracteres = Clavier.lireString().toLowerCase();
                    
                    while ( ! ( choixChaineCaracteres.equalsIgnoreCase( ROUGE ) ||  choixChaineCaracteres.equalsIgnoreCase( NOIRE ) ) ){
                             
                          System.out.println( MSG_ERREUR_CHOIX );
                          System.out.print ( MSG_ENTREZ_COULEUR );
                          choixChaineCaracteres = Clavier.lireString().toLowerCase();  
                               
                    }
                        
                    choixEntier = retournerNumeroCouleur(choixChaineCaracteres);
                                                                                   
                    break;
            
            case NO_CHOIX_SYMBOLE:                                                                    
                    System.out.println( MSG_DEVINEZ_SYMBOLE );
                    System.out.print ( MSG_ENTREZ_SYMBOLE );

                    choixChaineCaracteres = Clavier.lireString().toLowerCase();
                      
                    while ( ! ( choixChaineCaracteres.equalsIgnoreCase( COEUR ) ||  choixChaineCaracteres.equalsIgnoreCase( PIQUE ) 
                            ||  choixChaineCaracteres.equalsIgnoreCase( TREFLE ) ||  choixChaineCaracteres.equalsIgnoreCase( CARREAU ) ) ){
                           
                          System.out.println( MSG_ERREUR_CHOIX );
                          System.out.print ( MSG_ENTREZ_SYMBOLE );
                          choixChaineCaracteres = Clavier.lireString().toLowerCase();  
                               
                    }
                            
                    choixEntier = retournerNumeroSymbole(choixChaineCaracteres);
                                                            
                    break;   
                    
            case NO_CHOIX_VALEUR:                                                                   
                    System.out.println( MSG_DEVINEZ_VALEUR );
                    System.out.print ( MSG_ENTREZ_VALEUR );

                    choixEntier = Clavier.lireInt();
                    
                    while ( ! ( choixEntier > 0 && choixEntier <= 13 ) ){
                                
                               System.out.println( MSG_ERREUR_CHOIX );
                               System.out.print ( MSG_ENTREZ_VALEUR );
                               choixEntier = Clavier.lireInt();                             
                               
                    }                            
                  
                    break;          
                       
            default:
                    break;   
        } // switch (choix)     
    
        return choixEntier;
        
    }
        
    /**
     * Affiche message apres mauvais reponse selon le choixdeMenu
     * 
     * On assume que la valeur de choixMenu a été préalablement validé.
     */
    public static void afficherMsgEchec (int choixMenu, int valeurCarte){
        
        System.out.println( MSG_DESOLE );
                   
        if (choixMenu == NO_CHOIX_COULEUR){

            System.out.println( MSG_BONNE_COULEUR + retournerNomCouleur ( valeurCarte ) );
                       
        }else if (choixMenu == NO_CHOIX_SYMBOLE){

            System.out.println( MSG_BON_SYMBOLE + retournerNomSymbole ( valeurCarte ) );
                            
        }else{
                       
            System.out.println( MSG_BONNE_VALEUR + valeurCarte ); 
            
        }
    }
    
    /**
     * Affiche les resultats à la fin du jeu
     */
    public static void afficherResultats (int nbrCartes, int points){
    
       if ( nbrCartes != 0 ) {
           
           System.out.println( MSG_NBR_CARTES + nbrCartes);
           System.out.println( MSG_POINTAGE_TOTALE + points ); 
           
       }
    }
    
    public static void main (String[] params) {
        
        int compteurCartes=0;
        int pointageTotal=0;   
        String msgJouer = MSG_JOUER;
         
        int choixDuTest ;
        int points;        
        int valeurCarte;
        int nbrEssais; 
        
        presenterLogiciel();        
      
        while( jouerEncore(msgJouer)){

               if (compteurCartes==0){
                   
                   msgJouer = MSG_JOUER_ENCORE;
                   
               }
               
               compteurCartes = compteurCartes + 1; 
           
               choixDuTest = afficherMenuRetournerChoix();         
                         
               valeurCarte = genererNombreSelonChoix(choixDuTest);                                 
               
               nbrEssais = ( choixDuTest - 1 ) * ( choixDuTest -1 ) + 1;
               
               points = 0;
               
               for ( int essai = 0 ;  essai < nbrEssais ; essai ++){
               
                   System.out.println("\nESSAI # " + (essai + 1) + " de " + nbrEssais);       
             
                   if ( valeurCarte == retournerNombreReponse( choixDuTest ) ){
                                                     
                       points = nbrEssais - essai;                      
                       essai = nbrEssais;           // force sortie du boucle                               
                    }
               
               } // for
               
               if ( points > 0){
                           
                   pointageTotal = pointageTotal + points;
                   System.out.println( MSG_FELICITATIONS );                
               
               }else{
                       
                   afficherMsgEchec( choixDuTest, valeurCarte );
        
               }  // if (points > 0)
           
               System.out.println( MSG_POINTAGE_DIVINATION + points);
                
        } // while
        
        afficherResultats(compteurCartes, pointageTotal); 
  
    } // main
    
} // Tp2Gr30
