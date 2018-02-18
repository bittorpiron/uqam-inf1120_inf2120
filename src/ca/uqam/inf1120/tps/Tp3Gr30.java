package ca.uqam.inf1120.tps;


/**
 * I N F 1 1 2 0  G R O U P E 3 0
 * (Celine Descheneaux)
 *
 * Decrivez votre classe Tp3Gr30 ici.
 * Logiciel de gestion des commandes de construction de chalets.
 * Cette logiciel utilise la classe Chalet, conçue en premiere partie du TP3.
 * 
 * @author Victor Piron 
 * @version 14-12-2013
 * PIRV11026606
 * piron.victor@courrier.uqam.ca
 *
 */

import java.io.*; //pour l'utilisation des classes associees a la gestion de fichiers

import ca.uqam.inf1120.examplesetlabos.Clavier;

public class Tp3Gr30 {

    public static final String MSG_CHOIX =  "\nEntrez votre choix: ";  
    public static final String MSG_ERREUR = "\nERREUR, entree non valide !";
    public static final String MSG_AUCUN_CHALET_COMMANDE =  "\nIl n'y a aucun chalet dans la commande actuelle.";
    public static final String MSG_INFORMATIONS_DU_CHALET =  "\nInformations du Chalet:";
    public static final String MSG_INFORMATIONS_DES_CHALETS =  "\nInformations des Chalets:";    
    public static final String MSG_CHALET_PAS_TROUVEE = "\nPas de chalet avec ce numero dans la commande actuelle.";
    public static final String MSG_CHALET_PAS_TROUVEE_CRITERE = "\nAucun chalet ne repond pas au critere recherche ( $1 ).";
    public static final String MSG_ENTREZ_NBRE_CHALET = "\nVeuillez entrer le numero du chalet a $1 ( maximun $2 ): ";
    
    public static final String MSG_INVALIDE_CHALET_FINI = "\nAction Invalide: Le chalet est deja fini.";
    
    public static final String MSG_SAISIR_PLANCHER = "\nType de Plancher : ";
    public static final String MSG_SAISIR_EXTERIEUR ="\nCouleur Exterieure: ";
    public static final String MSG_SAISIR_ARMOIRES = "\nType d'Armoires: ";
    public static final String MSG_SAISIR_FENETRES ="\nType de Fenetres: ";
    public static final String MSG_SAISIR_NBR_CHAMBRES ="\nNombre de Chambres ( $1 a $2 ): ";
    public static final String MSG_SAISIR_MODELE ="\nModele (maximun $1 caracteres): ";
    public static final String MSG_SAISIR_FOYER = "\nAvec Foyer ( O/o/n/N) ? : ";
    public static final String MSG_SAISIR_ENTER = "\nAppuyez sur ENTER pour continuer...";
    
    public static final int MAX_CHALET = 15;
    public static final int MAX_CHALET_AFFICHES = 2;    
    
    public static final int CHOIX_PASSER_UNE_COMMANDE = 1;
    public static final int CHOIX_METTRE_EN_CHANTIER = 2;
    public static final int CHOIX_TERMINER = 3;
    public static final int CHOIX_SUPPRIMER = 4;
    public static final int CHOIX_AFFICHER_TOUS = 5;
    public static final int CHOIX_RECHERCHER = 6;
    public static final int CHOIX_EFFECTUER_DES_MODIFICATIONS = 7;
    public static final int CHOIX_QUITTER = 8;
    public static final int CHOIX_PRESENTATION = 9;

    public static final char CHOIX_RECHERCHE_NUMERO = 'A';
    public static final char CHOIX_RECHERCHE_MODELE = 'B';
    public static final char CHOIX_RECHERCHE_AVEC_FOYER = 'C';
    public static final char CHOIX_RECHERCHE_SANS_FOYER = 'D';
    public static final char CHOIX_RECHERCHE_NOMBRE_CHAMBRES = 'E';
    public static final char CHOIX_RECHERCHE_COLEUR_EXTERIEUR = 'F';
    public static final char CHOIX_RECHERCHE_EN_CONSTRUCTION = 'G';
    public static final char CHOIX_RECHERCHE_TERMINE = 'H';
    public static final char CHOIX_RECHERCHE_EN_ATTENTE = 'I';
    public static final char CHOIX_RECHERCHE_RETOURNER = 'J';
         
    public static final char CHOIX_MODIFICATION_ARMOIRES = 'A';
    public static final char CHOIX_MODIFICATION_EXTERIEURE = 'B';
    public static final char CHOIX_MODIFICATION_FENETRES = 'C';
    public static final char CHOIX_MODIFICATION_PLANCHER = 'D';
    public static final char CHOIX_MODIFICATION_RETOURNER = 'E';
    public static final char ENTRER_NBR_CHAMBRES = 'F';
    
    public static final String ACTION_METTRE_EN_CHANTIER =  "mettre en chantier"; 
    public static final String ACTION_RECHERCHER =  "rechercher"; 
    public static final String ACTION_TERMINER =  "terminer"; 
    public static final String ACTION_MODIFIER =  "modifier"; 
    public static final String ACTION_SUPPRIMER =  "supprimer";     
            
    public static final char OUI = 'O';
    public static final char NON = 'N';
    
    public static final String NOMME_DU_FICHIER =  "C:/Users/Victor/workspace/uqam_2014/Resources/CommandesChalets.txt";  
  
    // Autres methodes s'il y a lieu
    /**
     * Affiche la preséntation du logiciel.
     */
    public static void presenterLogiciel(){

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("---------------------           GESTION DES COMMANDES          --------------------");
        System.out.println("-------   ( Logiciel de gestion des commandes de construction de chalets )  -------");
        System.out.println("-----------------------------------------------------------------------------------");
     
        System.out.println("\nLe programme fonctionne a base de menus. ");
        System.out.println("Prototype qui contient une partie des fonctions necessaires");
        System.out.println("a la gestion des commandes de chalets.");
        System.out.println("\n----------------------------------------------------------------------------------");
 
    }//fin afficherPresentation
    
    /**
     * Affiche le Menu Principal et retourne la saisie du numero de choix.
     */
    public static int afficherMenu(){
        
        int choixMenu=0;
        
        System.out.println("\nMENU PRINCIPAL:");
        System.out.println("1 - PASSER UNE COMMANDE");
        System.out.println("2 - METTRE EN CHANTIER UN CHALET");
        System.out.println("3 - TERMINER LA CONSTRUCTION D'UN CHALET");
        System.out.println("4 - SUPPRIMER UN CHALET EN COMMANDE");
        System.out.println("5 - AFFICHER TOUS LES CHALETS COMMANDES");
        System.out.println("6 - RECHERCHER SELON CERTAINS CRITERES");
        System.out.println("7 - EFFECTUER DES MODIFICATIONS");
        System.out.println("8 - QUITTER LE LOGICIEL");
        System.out.println("9 - PRESENTATION DU LOGICIEL");

        choixMenu = saisirEtValiderEntier( MSG_CHOIX ,CHOIX_PASSER_UNE_COMMANDE, CHOIX_PRESENTATION);
                                                        
        return choixMenu;
        
    }//fin afficherMenu
    
    /**
     * Affiche selon le choix de menu, le sub-menu correspondant.
     * Seulement les menus de Recherche et Modification ont des sub-menus.
     * Retourne la saisie du choix (charactere).
     */
    public static char afficherSousMenu(int choixMenu) {
        
        char choixSubMenu;
        
        if ( choixMenu == CHOIX_RECHERCHER ) {
        
            System.out.println("\nRECHERCHE:");
            System.out.println("A - PAR NUMERO");
            System.out.println("B - PAR MODELE");
            System.out.println("C - CHALET(S) AVEC FOYER");
            System.out.println("D - CHALET(S) SANS FOYER");
            System.out.println("E - PAR NOMBRE DE CHAMBRES");
            System.out.println("F - PAR COLEUR EXTERIEUR");
            System.out.println("G - CHALET(S) EN CONSTRUCTION");
            System.out.println("H - CHALET(S) TERMINE(S)");
            System.out.println("I - COMANDES EN ATTENTE");
            System.out.println("J - RETOURNER AU MENU PRINCIPAL");
         
            choixSubMenu = saisirEtValiderCharactere( MSG_CHOIX , CHOIX_RECHERCHE_NUMERO, CHOIX_RECHERCHE_RETOURNER);
                        
        } else {
            
            System.out.println("\nEFFECTUER DES MODIFICATIONS:");
            System.out.println("A - CHANGER LE TYPE D'ARMOIRES");
            System.out.println("B - CHANGER LA COLEUR EXTERIEURE");
            System.out.println("C - CHANGER LE TYPE DE FENETRES");
            System.out.println("D - CHANGER LE TYPE DE PLANCHER");
            System.out.println("E - RETOURNER AU MENU PRINCIPAL");
         
            choixSubMenu = saisirEtValiderCharactere(MSG_CHOIX, CHOIX_MODIFICATION_ARMOIRES, CHOIX_MODIFICATION_RETOURNER);          
            
        }          
    
        return choixSubMenu;            
        
    }
    
    /**
     * Saisie et validation d'un en charactere entre deux valeurs permis.
     */
    public static char saisirEtValiderCharactere ( String msg, char min, char max) {
        
        char monChoixSubmenu;

        System.out.print ( msg );
        monChoixSubmenu = Character.toUpperCase(Clavier.lireCharLn());

        while ( monChoixSubmenu < min || monChoixSubmenu > max ){
                                    
              System.out.println( MSG_ERREUR );
              System.out.print ( msg );
              monChoixSubmenu = Character.toUpperCase(Clavier.lireCharLn());  
                    
        }   
        
        return monChoixSubmenu;
        
    }
    
    /**
     * Saisie et validadtion d'un entiere entre deux valeurs permis.
     */
    public static int saisirEtValiderEntier ( String msg, int min, int max) {
        
        //sentinelle servant a determiner la saisies d'une valeur valide
        boolean operationReussie = false; 
        
        int monEntier=0;
        
        do{
            
            try{
                
                System.out.print ( msg );
                monEntier = Clavier.lireInt();
             
                while ( monEntier < min || monEntier > max ){
                                    
                    System.out.println( MSG_ERREUR );
                    System.out.print ( msg );
                    monEntier = Clavier.lireInt();  
                    
                }    
                     
                operationReussie = true; 
                
            }catch (NumberFormatException e){
                
                System.out.println( MSG_ERREUR );
                
            }                     

        }while (!operationReussie);
        
        return monEntier;
        
    }

    /**
     * Genere les differents SubMenus et la saisie pour le choix de submenu passe en parametre entre deux valeurs entiers.
     * Les choix posibles: NbreChambres, 
     */
    public static int saisirOptionNumerique ( String msg, char choix, int min, int max ){
        
        int monChoix; 
        //String [] tableauChoix;        

        System.out.println(msg);
        
        if ( choix != ENTRER_NBR_CHAMBRES ){
            
            for (int i = min; i <= max; i++){
                
                 System.out.print(i + " - ");
                 
                 if (choix == CHOIX_MODIFICATION_PLANCHER ){
                     System.out.println(Chalet.plancher(i));
                 }else if (choix == CHOIX_MODIFICATION_EXTERIEURE ){
                     System.out.println(Chalet.exterieur(i));
                 }else if (choix == CHOIX_MODIFICATION_FENETRES ){
                     System.out.println(Chalet.fenetre(i));
                 }else if (choix == CHOIX_MODIFICATION_ARMOIRES ){
                     System.out.println(Chalet.armoire(i));
                 }       
          
            }  
        }        
        
        monChoix = saisirEtValiderEntier(MSG_CHOIX , min, max);        
        return monChoix;
        
    }
        
    /**
     * Genere les differents SubMenus et la saisie pour le choix de modele (chaine de caracteres) avec un max de caracters.
     */
    public static String saisirChaineCaracteres (String msg, int maxCaracteres){
        
        String reponse;
     
        System.out.print( msg );
        reponse = Clavier.lireString();

        while (   reponse.length() > maxCaracteres ){
                                    
              System.out.println( MSG_ERREUR );
              System.out.print ( msg );
              reponse = Clavier.lireString();  
                    
        }   
        
        return reponse;
        
    }
    
    public static boolean saisirOuiNon (String msg){
        
        boolean reponse = false;
        char repOuiNon;
        
        System.out.print(msg); 
        repOuiNon=Character.toUpperCase(Clavier.lireCharLn());  
               
        while ( !( repOuiNon == OUI || repOuiNon == NON ) ){
            
            System.out.println(MSG_ERREUR);        
            System.out.print(msg);
            repOuiNon = Character.toUpperCase(Clavier.lireCharLn());
             
        }//validation
                      
        if (repOuiNon==OUI){
            reponse = true;
        }
        
        return reponse;        
        
    }  
    
    /** 
     * Cette méthode gere les choix des options pour ajouter un nouveau chalet dans le tableau des commandes
     * a la position (deja validee) recue en parametre
     */
    public static void ajouterChalet ( Chalet [] commandes, int index ){ 
      
         int plancher;
         int exterieur;
         int armoire;
         int fenetre;
         int nbreChambres;
         String modele;
         boolean avecFoyer;        
 
         plancher = saisirOptionNumerique (MSG_SAISIR_PLANCHER ,CHOIX_MODIFICATION_PLANCHER, Chalet.MIN_PLANCHERS,  Chalet.MAX_PLANCHERS); 
         exterieur = saisirOptionNumerique (MSG_SAISIR_EXTERIEUR, CHOIX_MODIFICATION_EXTERIEURE, Chalet.MIN_EXTERIEURS,  Chalet.MAX_EXTERIEURS);
         armoire = saisirOptionNumerique (MSG_SAISIR_ARMOIRES, CHOIX_MODIFICATION_ARMOIRES, Chalet.MIN_ARMOIRES,  Chalet.MAX_ARMOIRES);
         fenetre = saisirOptionNumerique (MSG_SAISIR_FENETRES, CHOIX_MODIFICATION_FENETRES, Chalet.MIN_FENETRES,  Chalet.MAX_FENETRES);
         nbreChambres = saisirOptionNumerique ((MSG_SAISIR_NBR_CHAMBRES.replace("$1", "" + Chalet.MIN_CHAMBRES)).replace("$2","" + Chalet.MAX_CHAMBRES),ENTRER_NBR_CHAMBRES, Chalet.MIN_CHAMBRES,  Chalet.MAX_CHAMBRES );
         modele =  saisirChaineCaracteres (MSG_SAISIR_MODELE.replace("$1", "" + Chalet.MAX_NBR_CARACTERES_NOM_MODELE ), Chalet.MAX_NBR_CARACTERES_NOM_MODELE);
         avecFoyer = saisirOuiNon(MSG_SAISIR_FOYER);   
         
         commandes[index] = new Chalet( plancher, exterieur, armoire, fenetre, nbreChambres, modele, avecFoyer );

    }
    
    /** 
     * Cette méthode gere la demande a l'utilisateur d'un numero de chalet a la position (deja validee) recue en parametre
     * action posible: rechercher, modifier, mettre en chantier, terminer, supprimer
     */
    public static int saisirEtValiderChalet ( int nbrChaletsCommades, String action, Chalet [] commandes ){
        
          int indexChalet = -1;
        
          if ( nbrChaletsCommades > 0 ){
              
              int chaletId = saisirEtValiderEntier ( (MSG_ENTREZ_NBRE_CHALET.replace("$1", action)).replace("$2", "" + Chalet.getNbrChalets()), 1, Chalet.getNbrChalets());          
              indexChalet = chercherChaletParNumero (commandes, nbrChaletsCommades, chaletId);              
              
              if (indexChalet == -1 ){
              
                  System.out.println(MSG_CHALET_PAS_TROUVEE);
                  
              }
                    
          }else{

              System.out.println(MSG_AUCUN_CHALET_COMMANDE);
               
          }             
         
          return indexChalet;
          
    }    

    
    /** 
     * Cette méthode retourne la position du chalet dans le tableau
     *  ou -1 si le chalet n'existe pas...
     */ 
    public static int chercherChaletParNumero ( Chalet [] commandes, int nbrChaletsCommades, int numero ) {
        
        int indexChalet = -1;
        
        for ( int index=0 ;  index < nbrChaletsCommades  ; index++ ){
        
            if ( commandes[index]!=null && commandes[index].getNoChalet() == numero){
           
                indexChalet = index;
                
            }
            
        }
        
        return indexChalet;
        
    }

    /** 
     * Cette méthode gere la mise en chantier du chalet passe en parametre.
     * On n'est pas suppose de recevoir des chalets null, mais on protege au cas ou.
     * Seulement si le chalet est n'est pas en construction ou pas fini.
     * 
     */
    public static void mettreEnChantier ( Chalet chalet ){ 
        
        if ( chalet != null ){
        
            if ( chalet.isEnConstruction() ){
                
                System.out.println ("\nAction Invalide: Le chalet est deja en construction.");
                
            }else if ( chalet.isFini() ){
                
                System.out.println (MSG_INVALIDE_CHALET_FINI);
                
            }else{
                
                System.out.println (MSG_INFORMATIONS_DU_CHALET + chalet.toString());
                
                if ( saisirOuiNon ("\nVeuillez confirmer la mise en chantier du chalet (o/O/n/N) ? :") ){                  
                    
                     chalet.setEnConstruction(true);
                     System.out.println ("\nLa mise en chantier a ete correctement effectuee.");
                    
                }else{
                
                      System.out.println ("\nLa mise en chantier a ete annulee.");
                
                }               
                
            }      
        
        }       
        
    }
            
    /** 
     * Cette méthode gere l'action de terminer un chalet passe en parametre.
     * On n'est pas suppose de recevoir des chalets null, mais on protege au cas ou.
     * Seulement si le chalet est en construction ou pas fini.
     * 
     */
    public static void terminer ( Chalet chalet ){ 
        
        if ( chalet != null ){
        
            if ( ! chalet.isEnConstruction() ){
                
                if ( chalet.isFini() ){
                
                   System.out.println (MSG_INVALIDE_CHALET_FINI);
               
                }else{
                   
                   System.out.println ("\nAction Invalide: Le chalet n'est pas encore en construction.");
               
               }          
                            
            }else{
                
                System.out.println (MSG_INFORMATIONS_DU_CHALET + chalet.toString());
                
                if ( saisirOuiNon ("\nVeuillez confirmer la terminaison du chalet (o/O/n/N) ? :") ){                  
                    
                     chalet.setFini(true);
                     System.out.println ("\nLa terminaison du chalet a ete realise avec succes.");
                    
                }else{
                
                      System.out.println ("\nLa terminaison du chalet a ete annulee.");
                
                }               
                
            }      
        
        }     
        
    }
    
    /** 
     * Cette méthode gere la supression d'un chalet en commande.
     * On n'est pas suppose de recevoir des chalets null, mais on protege au cas ou.
     * Seulement si le chalet n'est pas en construction ou pas fini.
     */
    public static void supprimer ( Chalet [] commandes, int index ){ 
        
        Chalet chaletASupprimmer = commandes[index];
        
        if ( chaletASupprimmer != null ){
        
            if ( chaletASupprimmer.isEnConstruction() || chaletASupprimmer.isFini() ){
                
                System.out.println ("\nAction Invalide: Impossible de supprimer un chalet en construction ou qui est fini.");
                
            }else {
                
                System.out.println (MSG_INFORMATIONS_DU_CHALET + chaletASupprimmer.toString());
                
                if ( saisirOuiNon ("\nVeuillez confirmer la supression du chalet (o/O/n/N) ? :") ){                  
                    
                    //Decalage d'un place des chalets situes apres le supprime 
                   
                    for (int i= index ; i < MAX_CHALET ; i++){
                    
                        if ( i != MAX_CHALET -1 ){
                        
                            commandes[i] = commandes[i+1];
                            
                            //Forcer la sortie quand il n'y aura plus des chalets a decaler
                            if (commandes[i] == null){
                                
                                i = MAX_CHALET;
                                
                            }
                        
                        //le derniere sera remplace par un Chalet null
                        }else{
                            
                            commandes[i] = null;
                            
                        }                        
                    
                    }
                   
                    System.out.println ("\nLe chalet a ete correctement supprime.");
                    
                }else{
                
                      System.out.println ("\nAucune modification n'a pas ete effectuee.");
                
                }               
                
            }      
        
        }       
    }
    
    /** 
     * Cette méthode affiche les chalets qui se trovent dans le table de commandes.
     * On ne recoit pas tableaux vides.
     */   
    public static void afficherChaletsEnCommande( Chalet [] commande ){
    
        int compteurChalets = 0;
        int nbrChaletsTrouves = 0;
        //boolean conditionPasse = true;        
       
        if ( commande.length > 1 && commande[1] != null ){
        
            System.out.println (MSG_INFORMATIONS_DES_CHALETS);
        
        }else{
        
            System.out.println (MSG_INFORMATIONS_DU_CHALET);
            
        }    

        for (int i= 0 ; i < MAX_CHALET ; i++){                                  
                                    
             if (commande[i] != null ){
                
                  System.out.println ("\n" + commande[i].toString());
                  compteurChalets = compteurChalets + 1;
                  nbrChaletsTrouves = nbrChaletsTrouves + 1;
                      
             }else{
                  //Forcer la sortie quand il n'y a plus des chalets a decaler                    
                  i = MAX_CHALET;
                                
             }                      
                      
             if (compteurChalets == MAX_CHALET_AFFICHES){

                  pauserEcran();                                      
                  compteurChalets = 0;
             }
                      
        }   
        
    }
    
    /** 
     * Cette méthode retourne un tableau avec le resultat d'un filtre sur le tableau recu en parametre.
     * Les differents criteres de recherche dependent du typeDeRecherche selectionne.
     */   
    public static Chalet [] filtrerCondition(Chalet [] commande, char typeDeRecherche, int valeurEntier, String valeurChaine){        
 
        Chalet [] commandeFiltree = new Chalet [MAX_CHALET];
        int indexFiltre = 0;
        
        for (int i= 0 ; i < MAX_CHALET ; i++){                                  
                                    
             if (commande[i] != null ){
                 
                 if ( (typeDeRecherche == CHOIX_RECHERCHE_MODELE && (commande[i].getModele()).equalsIgnoreCase(valeurChaine)) ||
                      (typeDeRecherche == CHOIX_RECHERCHE_AVEC_FOYER &&  commande[i].isAvecFoyer()) ||
                      (typeDeRecherche == CHOIX_RECHERCHE_SANS_FOYER &&  !commande[i].isAvecFoyer()) ||
                      (typeDeRecherche == CHOIX_RECHERCHE_NOMBRE_CHAMBRES && ( commande[i].getNbreChambres() == valeurEntier ) ||
                      (typeDeRecherche == CHOIX_RECHERCHE_COLEUR_EXTERIEUR &&  ( commande[i].getExterieur() == valeurEntier )) ||
                      (typeDeRecherche == CHOIX_RECHERCHE_EN_CONSTRUCTION && commande[i].isEnConstruction()) ||
                      (typeDeRecherche == CHOIX_RECHERCHE_TERMINE && commande[i].isFini()) ||
                      (typeDeRecherche == CHOIX_RECHERCHE_EN_ATTENTE && !( commande[i].isEnConstruction() || commande[i].isFini() ))) ){                         
        
                       commandeFiltree[indexFiltre]=commande[i];
                       indexFiltre = indexFiltre + 1;
                          
                 }           
                                    
             }else{
                  //Forcer la sortie quand il n'y a plus des chalets a decaler                    
                  i = MAX_CHALET;
                  
             }       
             
        }       
     
        return commandeFiltree;
    
    }  
    
    /** 
     * Cette methode gere les menus et saisies pour les recherches selon le critere choisie (choixSubmenu).
     * On n'est pas supposes d'arriver ici avec une table de commande vide.
     */
    public static  void rechercher (int nbrChaletsCommades, char choixSubmenu, Chalet [] commande){   
        
        int entierSaisie;
        String chaineSaisie;
        //char caractereSaisie;
        //int nbrChaletsTrouvees=0;
        Chalet [] commandeFiltree = new Chalet [MAX_CHALET];
        
        if ( choixSubmenu == CHOIX_RECHERCHE_NUMERO ) {
                
            int saisieEntier = saisirEtValiderChalet(nbrChaletsCommades , ACTION_RECHERCHER, commande );
                
            if ( saisieEntier != -1 ){
                            
                System.out.println (MSG_INFORMATIONS_DU_CHALET + commande[saisieEntier].toString());
                                  
            }              
        
        }else{
            
            if ( choixSubmenu ==  CHOIX_RECHERCHE_MODELE){
       
                chaineSaisie = saisirChaineCaracteres (MSG_SAISIR_MODELE.replace("$1", "" + Chalet.MAX_NBR_CARACTERES_NOM_MODELE ), Chalet.MAX_NBR_CARACTERES_NOM_MODELE);        
                commandeFiltree = filtrerCondition(commande, choixSubmenu, 0, chaineSaisie );
                
            }else if ( choixSubmenu ==  CHOIX_RECHERCHE_NOMBRE_CHAMBRES){
                
                entierSaisie = saisirOptionNumerique ((MSG_SAISIR_NBR_CHAMBRES.replace("$1", "" + Chalet.MIN_CHAMBRES)).replace("$2","" + Chalet.MAX_CHAMBRES),ENTRER_NBR_CHAMBRES, Chalet.MIN_CHAMBRES,  Chalet.MAX_CHAMBRES );
                commandeFiltree = filtrerCondition(commande, choixSubmenu, entierSaisie, null );                 
                        
            }else if ( choixSubmenu ==  CHOIX_RECHERCHE_COLEUR_EXTERIEUR){
                
                entierSaisie = saisirOptionNumerique (MSG_SAISIR_EXTERIEUR, CHOIX_MODIFICATION_EXTERIEURE, Chalet.MIN_EXTERIEURS,  Chalet.MAX_EXTERIEURS);
                commandeFiltree = filtrerCondition(commande, choixSubmenu, entierSaisie, null );
                    
            }else {
            
               //Pas de question pour les Avec/Sans Foyer, en construction, termines ou en attente
                commandeFiltree =  filtrerCondition(commande, choixSubmenu, 0, null );
                
            }
            
            if ( commandeFiltree[0] != null ){
                
                afficherChaletsEnCommande(commandeFiltree);
                
            }else{
            
                System.out.println(MSG_CHALET_PAS_TROUVEE_CRITERE.replace("$1", "" + choixSubmenu));
            
            }    
            
        }        
        
    }
    
    /** 
     * Cette methode gere gere les menus et saisies pour les modifications selon l'option choisie (choixSubmenu).
     * On n'est pas supposes d'arriver ici avec une table de commande vide.
     */
    public static  void modifier (int nbrChaletsCommades, char choixSubmenu, Chalet [] commande){  
        
        int chaletId = saisirEtValiderChalet(nbrChaletsCommades , ACTION_MODIFIER, commande );
        int nouveauChoix=0;
                
        if ( chaletId != -1 ){                            
       
              if ( commande[chaletId].isEnConstruction() || commande[chaletId].isFini() ){
                        
                     System.out.println("\nAction Invalide: Impossible de modifier un chalet qui est en construction ou qui est fini.");
                        
              }else{
                       
                     switch(choixSubmenu){
                                case CHOIX_MODIFICATION_ARMOIRES:
                                    System.out.println(MSG_SAISIR_ARMOIRES + Chalet.armoire(commande[chaletId].getArmoire()));                            
                                    nouveauChoix = saisirOptionNumerique (MSG_SAISIR_ARMOIRES, choixSubmenu, Chalet.MIN_ARMOIRES,  Chalet.MAX_ARMOIRES);
                                    break;
                                case CHOIX_MODIFICATION_EXTERIEURE:
                                    System.out.println(MSG_SAISIR_EXTERIEUR + Chalet.exterieur(commande[chaletId].getExterieur()));                            
                                    nouveauChoix = saisirOptionNumerique (MSG_SAISIR_EXTERIEUR, choixSubmenu, Chalet.MIN_EXTERIEURS,  Chalet.MAX_EXTERIEURS);
                                    break;
                                case CHOIX_MODIFICATION_FENETRES:
                                    System.out.println(MSG_SAISIR_FENETRES + Chalet.fenetre(commande[chaletId].getFenetre()));                            
                                    nouveauChoix = saisirOptionNumerique (MSG_SAISIR_FENETRES, choixSubmenu, Chalet.MIN_FENETRES,  Chalet.MAX_FENETRES);
                                    break;                     
                                case CHOIX_MODIFICATION_PLANCHER:
                                    System.out.println(MSG_SAISIR_PLANCHER + Chalet.plancher(commande[chaletId].getPlancher()));                            
                                    nouveauChoix = saisirOptionNumerique (MSG_SAISIR_PLANCHER, choixSubmenu, Chalet.MIN_PLANCHERS,  Chalet.MAX_PLANCHERS);
                                    break;     
                                default:
                                    break;
                            }

                     confirmerModification(choixSubmenu, commande[chaletId], nouveauChoix);
 
              }         
                     
        }
        
    }
    
    /** 
     * Cette methode gere les modification a faire dans le chalet, selon le type de modification(choixSubmenu).
     */
    public static  void confirmerModification (char choixSubmenu, Chalet chalet, int nouveauChoix){
        
        if ( saisirOuiNon ("\nVeuillez confirmer la modification (o/O/n/N) ? :") ){ 
            
            if (choixSubmenu== CHOIX_MODIFICATION_ARMOIRES){
                
                chalet.setArmoire(nouveauChoix);
            
            }else if (choixSubmenu== CHOIX_MODIFICATION_EXTERIEURE){
                
                chalet.setExterieur(nouveauChoix);
                
            }else if (choixSubmenu== CHOIX_MODIFICATION_FENETRES){
            
                chalet.setFenetre(nouveauChoix);
                
            }else{
                
                 chalet.setPlancher(nouveauChoix);
                 
            }
            
        }else{
                              
            System.out.println("\nModification annulee");  
                   
        }
        
    }
    
    /** 
     * Cette méthode gere l'arrete du deffilement d'ecran.
     */
    public static void pauserEcran (){
           
        System.out.println (MSG_SAISIR_ENTER);
        Clavier.lireFinLigne();   
        
    }
    
    /** 
     * Cette methode gere la sauvegarde en fichier de l'etat des chalets en commande.
     */
    public static void stockerDansFichier ( Chalet [] commande ){
        
        FileWriter ficCommandesChalets;       //lien logique entre le fichier physique et le programme                               
        PrintWriter ecrivainCommandesChalets; //Future "crayon" pour lire dans un fichier
        
        try{
            
            ficCommandesChalets = new FileWriter(NOMME_DU_FICHIER);                
            //association du "crayon" avec le fichier. Si le fichier existe deja, il est ecrase
            ecrivainCommandesChalets = new PrintWriter(ficCommandesChalets);
        
            if ( commande[0] == null ){
            
                    ecrivainCommandesChalets.println (MSG_AUCUN_CHALET_COMMANDE);
            
            }else{
               
                    ecrivainCommandesChalets.println (MSG_INFORMATIONS_DES_CHALETS);
                    
                    for (int i= 0 ; i < MAX_CHALET ; i++){                                  
                                    
                        if (commande[i] != null ){
                           //ligne vide entre chalets
                           ecrivainCommandesChalets.println ();
                           String [] commandeParLigne = commande[i].toString().split("\n");
                           
                           for ( int ligne =0; ligne < commandeParLigne.length; ligne++){
                               ecrivainCommandesChalets.println(commandeParLigne[ligne]);
                           }
                      
                        }else{
                            //Forcer la sortie quand il n'y a plus des chalets a decaler                    
                            i = MAX_CHALET;
                                
                        }    
                    
                    }
                     
            }   
                
            //Fermeture du fichiers
            ecrivainCommandesChalets.close();
                 
        //gestion des exceptions    
        }catch (FileNotFoundException e){
               System.out.print("Erreur! Fichier de lecture inexisitant!");
        }catch (IOException e){
               System.out.print("Erreur d'entree/sortie");
        }//fin try...catch

    }
    
    public static void main (String[] params) {        
    
        Chalet [] commande = new Chalet [MAX_CHALET];
        int nbrChaletsCommades = 0;
        
        int choixMenu;
        char choixSubMenu;
        int indexChaletSelectionne;     
        
        presenterLogiciel();
        
        choixMenu = afficherMenu();
        
        //Gere les choix du Menu Principal
        while (choixMenu != CHOIX_QUITTER ){          
            
            switch ( choixMenu ) {
                
                   case CHOIX_PASSER_UNE_COMMANDE:     
                   
                        if ( nbrChaletsCommades < MAX_CHALET ){
                        
                            ajouterChalet(commande, nbrChaletsCommades);
                            nbrChaletsCommades = nbrChaletsCommades + 1 ;
                            System.out.println("L'ajout du chalet a ete fait avec succes.");
                            
                        }else{
                            
                            System.out.println("Le cahier de commandes est plein, nous n'aceptons plus des comandes.");
                            
                        }
                        
                        break;
                        
                   case CHOIX_METTRE_EN_CHANTIER:

                        indexChaletSelectionne = saisirEtValiderChalet(nbrChaletsCommades, ACTION_METTRE_EN_CHANTIER, commande );
                 
                        if ( indexChaletSelectionne != -1 ){
                            
                            mettreEnChantier(commande[indexChaletSelectionne]);
                                  
                        }                    
                        
                        break;                
                        
                   case CHOIX_TERMINER:
                        
                        indexChaletSelectionne = saisirEtValiderChalet(nbrChaletsCommades, ACTION_TERMINER, commande );
                 
                        if ( indexChaletSelectionne != -1 ){
                            
                            terminer(commande[indexChaletSelectionne]);
                                  
                        }  
                        
                        break;                 
                        
                   case CHOIX_SUPPRIMER:
                   
                        indexChaletSelectionne = saisirEtValiderChalet(nbrChaletsCommades, ACTION_SUPPRIMER, commande );
                 
                        if ( indexChaletSelectionne != -1 ){
                            
                            supprimer(commande, indexChaletSelectionne);
                            nbrChaletsCommades = nbrChaletsCommades - 1 ;
                                  
                        }  
                        break;   
                        
                   case CHOIX_AFFICHER_TOUS:
                        if  (commande[0] == null) { 
        
                            System.out.println (MSG_AUCUN_CHALET_COMMANDE);
        
                        }else{
            
                             afficherChaletsEnCommande(commande);      
        
                        }                    
                        
                        break;  
                        
                   case CHOIX_RECHERCHER:
                   
                        if (nbrChaletsCommades > 0){
                        
                           choixSubMenu = afficherSousMenu(choixMenu);
                           
                           while (choixSubMenu != CHOIX_RECHERCHE_RETOURNER ){
                               
                               rechercher(nbrChaletsCommades, choixSubMenu, commande) ;
                               choixSubMenu = afficherSousMenu(choixMenu);
                            
                           }                       
                        
                        }else{

                            System.out.println(MSG_AUCUN_CHALET_COMMANDE);
               
                        }       

                        break;     
                        
                   case CHOIX_EFFECTUER_DES_MODIFICATIONS:
                                      
                        if (nbrChaletsCommades > 0){
                            
                            choixSubMenu = afficherSousMenu(choixMenu);
                            
                            while (choixSubMenu != CHOIX_MODIFICATION_RETOURNER ){
                            
                               modifier(nbrChaletsCommades, choixSubMenu, commande) ;
                               choixSubMenu = afficherSousMenu(choixMenu);
                         
                            }
                            
                        }else{

                            System.out.println(MSG_AUCUN_CHALET_COMMANDE);
               
                        } 
                        
                        break;    
                        
                   case CHOIX_PRESENTATION:
                   
                        presenterLogiciel();
                        pauserEcran();
                       
                        break;   
                        
                   default:
                        break;   
            }            
            
            choixMenu = afficherMenu();
            
        }

        stockerDansFichier(commande);
        
    } // main
    
} // Tp3Gr30
