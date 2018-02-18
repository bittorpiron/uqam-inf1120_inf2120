package ca.uqam.inf1120.examplesetlabos.test;

import ca.uqam.inf1120.examplesetlabos.Cercle;

/*
 * Programme qui sert à tester la classe Cercle. Il est à noter que les tests qui sont ici
 * ne sont pas exhaustifs et qu'il faut en ajouter d'autres afin qu'ils soient complets...
 * 
 * Version : mars 2009
 */



public class TesterCercle {

    public static void main ( String[] p ) {
        
        Cercle c1 = new Cercle();
        Cercle c2 = new Cercle ( 10, 20, 100 );
        
        System.out.println ( "Le rayon de c1 est " + c1.rayon() ); 
        System.out.println ( "Le rayon de c2 est " + c2.rayon() );
       
        System.out.println ( "La circonference de c1 est " + c1.circonference() ); 
        System.out.println ( "La circonference de c2 est " + c2.circonference() );
        
        c1.setRayon ( 10 );
        c2.setXYrayon ( 2, 3, 50 );
        
        System.out.println ( "Le nouveau rayon de c1 est " + c1.rayon() ); 
        System.out.println ( "Le nouveau rayon de c2 est " + c2.rayon() );
       
        System.out.println ( "La nouvelle circonference de c1 est " + c1.circonference() ); 
        System.out.println ( "La nouvelle circonference de c2 est " + c2.circonference() );
        
    } // main
    
} // TesterCercle
