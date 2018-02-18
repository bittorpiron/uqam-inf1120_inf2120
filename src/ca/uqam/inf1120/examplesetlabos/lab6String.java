package ca.uqam.inf1120.examplesetlabos;


/**
 * I N F x 1 2 0
 *
 * D�crivez votre classe lab6String ici.
 * 
 * @author (votre nom) 
 * @version (une date)
 *
 * (votre code permanent)
 * (votre adresse de courriel)
 */
 
public class lab6String {

    // Autres m�thodes s'il y a lieu
     public static boolean  commenceMayuscule (String msg) {
//         boolean oui = false;
         return msg.charAt(0)>= 'A' && msg.charAt(0)<='Z';
     } // commenceMayuscule 
    
    
    public static int compteurSpaces (String msg) {
    int nrsSpaces =0;
      for (int index = 0; index < msg.length(); index++ ){
          if ( msg.charAt(index)==' '){
              nrsSpaces = nrsSpaces + 1;
            }    
        }
    return nrsSpaces;
    } // compteurSpaces   
    
    public static String enleveEMinuscule (String msg) {
    String nouvelleChaine="";
      for (int index = 0; index < msg.length(); index++ ){
          if ( msg.charAt(index)!='e'){
              nouvelleChaine = nouvelleChaine +  msg.charAt(index);
            }    
        }
    return nouvelleChaine;
    } // enleveEMinuscule  
    
    public static boolean compareDeuxChaines (String msg1, String msg2) {
    String trouves="";
      for (int index2 = 0; index2 < msg2.length(); index2++ ){          
          for (int index1 = 0; index1 < msg1.length(); index1++ ){
              if (msg1.charAt(index1) == msg2.charAt(index2)){
                  trouves = trouves + msg1.charAt(index1);
                  String newMsg1 = msg1.substring(index1+1);               
                  index1 = msg1.length();//force sortie
                  msg1 = newMsg1;
              } 
          }     
      }
    return msg2.equals(trouves);
    } // compareDeuxChaines  
    
    public static void main (String[] params) {
    
    } // main
    
} // lab6Stri
