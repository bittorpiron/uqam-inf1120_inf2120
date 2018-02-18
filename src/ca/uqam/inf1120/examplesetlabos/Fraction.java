package ca.uqam.inf1120.examplesetlabos;


/**
 * I N F x 1 2 0
 *
 * D�crivez votre classe Fraction ici.
 * 
 * @author (votre nom) 
 * @version (une date)
 *
 * (votre code permanent)
 * (votre adresse de courriel)
 */

public class Fraction {

    // variable(s) de classe s'il y a lieu
    
    // variable(s) d'instance s'il y a lieu
    private int numerateur;
    private int denominateur;    
    
    // constructeur(s) s'il y a lieu
    public Fraction(){
        numerateur = 0;
        denominateur = 1;
    }
    
    public Fraction(int numerateur, int denominateur){
        if ( denominateur < 0 ) {
            
                numerateur = mul (numerateur, -1);
                denominateur = mul (denominateur, -1);
                
        }      
        
        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }
    
//    private static int add (int a, int b){
//        return a + b;
//    }
    
    private static int sus (int a, int b){
        return a - b;
    }
    
    private static int mul (int a, int b){
        return a * b;
    }
    
    private static int div (int a, int b){
        return a / b;
    }

    private static int pgdc (int x, int y){
      
      int result;
      
      while(x != 0 && y != 0)
      {
         if(x > y){
             x = sus(x, y);
         }else{
             y = sus(y, x);
         }
      }
      
      if(x != 0){
         result = x;
      }else{
          result = y;
      }   
      
      return result;
    }
    // m�thode(s) de classe s'il y a lieu
    
    // m�thode(s) d'instance s'il y a lieu
    public void simplifier(){
        int in_pgdc;
        if (numerateur < 0){
            in_pgdc = pgdc(mul(numerateur,-1) ,denominateur);
        }else{
            in_pgdc = pgdc(numerateur,denominateur);
        }

        numerateur = div(numerateur,in_pgdc);
        denominateur = div(denominateur,in_pgdc);
        
         System.out.println ("Fraction = " + numerateur + " / " + denominateur );
        
    }
        
    public void aficher(){
        System.out.println ("Fraction = " + numerateur + " / " + denominateur );
    }
} // Fraction
