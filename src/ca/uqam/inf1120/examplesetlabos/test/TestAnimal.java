package ca.uqam.inf1120.examplesetlabos.test;

import ca.uqam.inf1120.examplesetlabos.Animal;


/**
 * I N F 1 1 2 0  G R O U P E 3 0
 * (C�line Descheneaux)
 *
 * D�crivez votre classe yy ici.
 * 
 * @author Victor Piron 
 * @version (une date)
 *
 * PIRV11026606
 * piron.victor@courrier.uqam.ca
 *
 */
 
public class TestAnimal{

    // Autres m�thodes s'il y a lieu
    
    public static void afficheAnimal (Animal animal){
    
        System.out.println( "Nom          : " + animal.getNom() );
        System.out.println( "Sorte        : " + animal.getSorte() );
        System.out.println( "Race         : " + animal.getRace() );
        System.out.println( "Proprietaire : " + animal.getProprietaire() ); 
    
    }
    
    public static void main (String[] params) {
        System.out.println("Test 1");   
        Animal myMinu = new Animal();
        myMinu.afficher();
        
        System.out.println("Test 2");
        myMinu.nom = "choupette";
        myMinu.sorte = 1;
        myMinu.race = "domestique";
        myMinu.proprietaire = "Louise";
        
        myMinu.afficher();
        
        System.out.println("Test 3");
        Animal myVide = new Animal();
        myVide.afficher();
        
        System.out.println("Test 4");
        Animal  myConstructor = new Animal("lazaro",2,"persian","Catherine");
        myConstructor.afficher();
        
        System.out.println("Test 5");
        afficheAnimal(myConstructor);
        
        System.out.println("Test 6");
        myConstructor.setNom("Dashel");
        myConstructor.afficher();
        
        
    } // main
    
} // yy
