package ca.uqam.inf1120.examplesetlabos;


/**
 * Permet de dessiner des figures geometriques simples a la console.
 * 
 * @author Louise Laforest 
 * @version 2004-10-09
 */

public class Dessiner {

    public static void afficherNfois ( int nbFois, char carac ) {
        
    /* antecedent : -
     * consequent : Affiche nbFois le caractere carac a la console.
     *              Si nbFois <= 0, la methode n'affiche rien.
     */
    
        for ( int i = 1 ; i <= nbFois ; i = i + 1 ) {
            System.out.print ( carac );
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
    
    public static void main ( String [] parametres ) {
        
    /* antecedent : -
     * consequent : Permet de tester la methode afficherRectangle.  La methode valide
     *              la hauteur et la largeur avant d'appeler la methode afficherRectangle.
     *              Avec BlueJ on peut aussi tester les differentes methodes en les appelant 
     *              en utilisant le bouton de droite comme on fait avec la methode main.
     */

        // Declaration des variables
        
        int largeur;
        int hauteur;
        
        //
        
        System.out.print ( "Donnez la largeur du rectangle : " );
        largeur = Clavier.lireInt ();
        
        while ( largeur <= 0 ) { // validation de la largeur
            System.out.println ( "*** La largeur doit etre positive." );
            System.out.print ( "Donnez la largeur du rectangle : " );
            largeur = Clavier.lireInt ();
        } // while
        
        System.out.print ( "Donnez la hauteur du rectangle : " );
        hauteur = Clavier.lireInt ();
        
        while ( hauteur <= 0 ) { // validation de la hauteur
            System.out.println ( "*** La hauteur doit etre positive." );
            System.out.print ( "Donnez la hauteur du rectangle : " );
            hauteur = Clavier.lireInt ();
        } // while
        
        afficherRectangle ( largeur, hauteur );
        
    } // main

} // Dessiner
