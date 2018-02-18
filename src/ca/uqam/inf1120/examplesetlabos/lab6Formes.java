package ca.uqam.inf1120.examplesetlabos;


/**
 * I N F x 1 2 0
 *
 * D�crivez votre classe lab6Formes ici.
 * 
 * @author (votre nom) 
 * @version (une date)
 *
 * (votre code permanent)
 * (votre adresse de courriel)
 */
 
public class lab6Formes {

    // Autres m�thodes s'il y a lieu
     public static void afficherNfois ( int nbFois, char carac ) {
        
    /* antecedent : -
     * consequent : Affiche nbFois le caractere carac a la console.
     *              Si nbFois <= 0, la methode n'affiche rien.
     */
    
        for ( int i = 1 ; i <= nbFois ; i = i + 1 ) { 
            System.out.print ( carac );
            //System.out.print ( carac + " ");
        }
        
    } // afficherNfois

    public static void afficherRectangle ( int largeur, int hauteur ) {
        
    /* antecedent : -
     * consequent : Affiche a la console un rectangle de hauteur hauteur et de largeur largeur.
     *              Si largeur <= 0 et/ou hauteur <= 0, la methode mentionne que les parametres
     *              ne sont pas valide puis termine son execution.
     */
    
        if ( largeur <= 0 || hauteur <= 0 ) {
            
            System.out.println ( "*** largeur et/ou hauteur invalide(s)." );
            
        } else {
            
            // Afficher la ligne du haut
            
            afficherNfois ( largeur, '*' );
            System.out.println ();
        
            // Afficher le milieu
            
            for ( int ligne = 2; ligne < hauteur; ligne = ligne + 1 ) {
                afficherNfois ( 1, '*' );
                if ( largeur > 1 ) {
                    afficherNfois ( largeur - 2, ' ' );
                    afficherNfois ( 1, '*' );
                } // if largeur > 1
                System.out.println ();
            } // for
        
            // Afficher la ligne du bas s'il y a lieu ( hauteur > 1 )
            
            if ( hauteur > 1 ) {
                afficherNfois ( largeur, '*' );
                System.out.println ();
            } // if hauteur > 1
            
        } // if largeur et/ou hauteur invalide(s)

    } // afficherRectangle
    
    public static void afficherCarre ( int cote ) {
        
        afficherRectangle(cote,cote);
        
    }
    
    public static void afficherTriangleIsoGauche ( int hauteur ){
        
            afficherNfois ( 1, '*' );
            System.out.println ();
           
            for ( int ligne = 2; ligne < hauteur; ligne = ligne + 1 ) {
                afficherNfois ( 1, '*' );
                if ( hauteur > 2 ) {
                    afficherNfois ( ligne - 2, ' ' );                   
                } // if hauteur > 1
                afficherNfois ( 1, '*' );
                System.out.println ();
            } // for
            
            if ( hauteur > 1 ) {
                afficherNfois ( hauteur, '*' );
            }
            System.out.println ();
    }    
    
    public static void afficherTriangleIsoDroit ( int hauteur ){
        
            afficherNfois(hauteur-1, ' ' );
            afficherNfois ( 1, '*' );
            System.out.println ();
           
            for ( int ligne = 2; ligne < hauteur; ligne = ligne + 1 ) {
                afficherNfois(hauteur-ligne, ' ' );
                afficherNfois ( 1, '*' );                
                if ( hauteur > 2 ) {
                    afficherNfois ( ligne - 2, ' ' );                   
                } // if hauteur > 1
                afficherNfois ( 1, '*' );
                System.out.println ();
            } // for
            
            if ( hauteur > 1 ) {
                afficherNfois ( hauteur, '*' );
            }
            System.out.println ();
    }  
  
        public static void afficherTriangleEqui ( int hauteur ){
        
            afficherNfois(hauteur-1, ' ' );
            afficherNfois ( 1, '*' );
            System.out.println ();
           
            for ( int ligne = 2; ligne < hauteur; ligne = ligne + 1 ) {
                afficherNfois(hauteur-ligne, ' ' );
                afficherNfois ( 1, '*' );
                afficherNfois(((ligne - 1)*2)-1, ' ' );     // (ligne *2) - 3      
                afficherNfois ( 1, '*' );
                System.out.println ();
            } // for
            
            if ( hauteur > 1 ) {
                afficherNfois ( hauteur*2 - 1, '*' );
            }
            System.out.println ();
    }
    
    
    public static void main (String[] params) {
    // Declaration des variables
        
//       int largeur;
        int hauteur;       
        
//         System.out.print ( "Donnez la largeur du rectangle : " );
//         largeur = Clavier.lireInt ();
//         
//         while ( largeur <= 0 ) { // validation de la largeur
//             System.out.println ( "*** La largeur doit etre positive." );
//             System.out.print ( "Donnez la largeur du rectangle : " );
//             largeur = Clavier.lireInt ();
//         } // while
//         
//         System.out.print ( "Donnez la hauteur du rectangle : " );
//         hauteur = Clavier.lireInt ();
//         
//         while ( hauteur <= 0 ) { // validation de la hauteur
//             System.out.println ( "*** La hauteur doit etre positive." );
//             System.out.print ( "Donnez la hauteur du rectangle : " );
//             hauteur = Clavier.lireInt ();
//         } // while
//         
//         afficherRectangle ( largeur, hauteur );
//         
//         System.out.print ( "Donnez la largueur du cote du carre : " );
//         largeur = Clavier.lireInt ();
//         
//         while ( largeur <= 0 ) { // validation de la largeur
//             System.out.println ( "*** La largeur doit etre positive." );
//             System.out.print ( "Donnez la largueur du cote du carre : " );
//             largeur = Clavier.lireInt ();
//         } // while
//         
//         afficherCarre(largeur);
        
        System.out.print ( "Donnez la hauteur des triangles : " );
        hauteur = Clavier.lireInt ();       
        
        while ( hauteur <= 0 ) { // validation de la hauteur
            System.out.println ( "*** La hauteur doit etre positive." );
            System.out.print ( "Donnez la hauteur du rectangle : " );
            hauteur = Clavier.lireInt ();
        } // while
        
//         afficherTriangleIsoGauche ( hauteur );        
//         
//         afficherTriangleIsoDroit ( hauteur );
        
        afficherTriangleEqui ( hauteur );
    } // main
   
} // lab6String
