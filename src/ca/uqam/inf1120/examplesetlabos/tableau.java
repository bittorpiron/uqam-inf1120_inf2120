package ca.uqam.inf1120.examplesetlabos;


/**
 * I N F 1 1 2 0  G R O U P E 3 0
 * (Celine Descheneaux)
 *
 * Decrivez votre classe tableau ici.
 * 
 * @author Victor Piron 
 * @version (une date)
 *
 * PIRV11026606
 * piron.victor@courrier.uqam.ca
 *
 */
 
public class tableau {

    // Autres m�thodes s'il y a lieu
    
    public static void main (String[] params) {
        
        System.out.println ( "Test a" ); 
        double[] tab1 = new double [ 10 ]; 
        System.out.println ( tab1 [ 0 ] ); 

        System.out.println ( "Test b" ); 
// //  int[] tab2 = new int [ 10 ]; 
// //  System.out.println ( tab2 [ 10 ] ); 

        System.out.println ( "Test c" );
// double[] tab3 = new int [ 10 ]; 
//  System.out.println ( tab3 [ 0 ] ); 

        System.out.println ( "Test d" ); 
// int[ 5 ] tab4 = new int [ 5 ]; 
//  System.out.println ( tab4 [ 0 ] ); 

        System.out.println ( "Test e" );
// int[] tab5; 
//  System.out.println ( tab5 [ 0 ] ); 
 
        System.out.println ( "Test f" );
// int[] tab6; 
//  System.out.println ( tab6.length ); 

      System.out.println ( "Test g " );
      String[] tab7 = new String [ 3 ]; 
      tab7[0] = "Bonjour"; 
      tab7[1] = "Allo"; 
      for ( int i = 0; i < tab7.length; i++ ) { 
          System.out.println ( tab7[i] ); 
      }
      
       System.out.println ( "Test h " );
// // String[] tab8 = new String [ 6 ]; 
// //  tab8[0] = "Bonjour"; 
// //  tab8[1] = "Allo"; 
// //  tab8[3] = ""; 
// //  tab8[4] = "\ntable\n"; 
// //  
// //  for ( int i = 0; i < tab8.length; i++ ) { 
// //  System.out.println ( tab8[i].length() ); 
// //  } 

       System.out.println ( "Test i " );
       String[] tab9 = new String [ 4 ]; 
       tab9[0] = "Bonjour"; 
       tab9[1] = "Allo"; 
       tab9[3] = tab9[1] + " " + tab9[0]; 
 
       for ( int i = 0; i < tab9.length; i++ ) { 
           System.out.println ( tab9 [ i ] ); 
        } 

    } // main
    
} // tableau
