package ca.uqam.inf1120.examplesetlabos;

class Labo2_1 {

    public static void main ( String [] params ) {
    
      int nbSecondesInit;  // nombre de secondes initial
      int nbSecondes;       // nombre de secondes apres calculs
      int nbMinutes;        // nombre de secondes apres calculs
      int nbHeures;         // nombre de secondes apres calculs
      
      nbSecondesInit = 0;
      nbMinutes = nbSecondesInit / 60;
      nbSecondes = nbSecondesInit % 60;
      nbHeures = nbMinutes / 60;
      nbMinutes = nbMinutes % 60;
      
      System.out.println ( nbSecondesInit + " secondes = " + nbHeures + " heure(s) + "
                                                        + nbMinutes + " minute(s) + "
                                                        + nbSecondes + " seconde(s)." );
                                                        
      nbSecondesInit = 23;
      nbMinutes = nbSecondesInit / 60;
      nbSecondes = nbSecondesInit % 60;
      nbHeures = nbMinutes / 60;
      nbMinutes = nbMinutes % 60;
      
      System.out.println ( nbSecondesInit + " secondes = " + nbHeures + " heure(s) + "
                                                        + nbMinutes + " minute(s) + "
                                                        + nbSecondes + " seconde(s)." );
                                                        
      nbSecondesInit = 2489;
      nbMinutes = nbSecondesInit / 60;
      nbSecondes = nbSecondesInit % 60;
      nbHeures = nbMinutes / 60;
      nbMinutes = nbMinutes % 60;
      
      System.out.println ( nbSecondesInit + " secondes = " + nbHeures + " heure(s) + "
                                                        + nbMinutes + " minute(s) + "
                                                        + nbSecondes + " seconde(s)." );
                                                        
      nbSecondesInit = 11842;
      nbMinutes = nbSecondesInit / 60;
      nbSecondes = nbSecondesInit % 60;
      nbHeures = nbMinutes / 60;
      nbMinutes = nbMinutes % 60;
      
      System.out.println ( nbSecondesInit + " secondes = " + nbHeures + " heure(s) + "
                                                        + nbMinutes + " minute(s) + "
                                                        + nbSecondes + " seconde(s)." );
                                                        
      nbSecondesInit = 90777;
      nbMinutes = nbSecondesInit / 60;
      nbSecondes = nbSecondesInit % 60;
      nbHeures = nbMinutes / 60;
      nbMinutes = nbMinutes % 60;
      
      System.out.println ( nbSecondesInit + " secondes = " + nbHeures + " heure(s) + "
                                                        + nbMinutes + " minute(s) + "
                                                        + nbSecondes + " seconde(s)." );
                                                        
    } // main
    
} // Labo2_1