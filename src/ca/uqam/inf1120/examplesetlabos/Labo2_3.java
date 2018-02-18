package ca.uqam.inf1120.examplesetlabos;

class Labo2_3 {

    public static void main ( String [] params ) {
    
      int nbSecondesInit; // nombre de secondes initial
      int nbSecondes;      // nombre de secondes apres calculs
      int nbMinutes;       // nombre de minutes apres calculs
      int nbHeures;        // nombre de heures apres calculs
      int nbJours;         // nombre de jours apres calculs
      
      System.out.print ( "Entrez un nombre de secondes (0 pour terminer) : " );
      nbSecondesInit = Clavier.lireInt();
      
      while ( nbSecondesInit != 0 ) {
          if ( nbSecondesInit < 0 ) {
              System.out.println ( "Le nombre doit etre positif." );
          } else {
              nbMinutes = nbSecondesInit / 60;
              nbSecondes = nbSecondesInit % 60;
              nbHeures = nbMinutes / 60;
              nbMinutes = nbMinutes % 60;
              nbJours = nbHeures / 24;
              nbHeures = nbHeures % 24;
      
              System.out.println ( nbSecondesInit + " secondes = "
                                         + nbJours + " jour(s) + "
                                         + nbHeures + " heure(s) + "
                                         + nbMinutes + " minute(s) + "
                                         + nbSecondes + " seconde(s)." );
          } // if
          System.out.print ( "Entrez un nombre de secondes (0 pour terminer) : " );
          nbSecondesInit = Clavier.lireInt();
      } // while                                                        
    } // main
    
} // Labo2_3