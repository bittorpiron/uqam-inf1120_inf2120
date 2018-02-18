package ca.uqam.inf1120.examplesetlabos;

/*
  * 
 */


public class Animal {
   
    public String nom;
    public int sorte;     
    public String race; 
    public String proprietaire;
    
    public Animal() {
        
        nom = "";
        sorte = 0;
        race = "";
        proprietaire = "";
    
    
    }   
    
    public Animal(String inNom, int inSorte, String inRace , String inProprietaire) {
        
        nom = inNom;
        sorte = inSorte;
        race = inRace;
        proprietaire = inProprietaire;
    
    
    }
    
    public void afficher(){
    
        System.out.println("Nom: " + nom +
                           " Sorte: " + sorte +
                           " Race: " + race +
                           " Propietaire: " + proprietaire);
        
    }  
    
    public String getNom(){
    
        return nom;
        
    }
    
    public int getSorte(){
    
        return sorte;
        
    }
    
    public String getRace(){
    
        return race;
        
    }
    
    public String getProprietaire(){
    
        return proprietaire;
        
    }
    
    public void setNom(String inNom){
    
        nom = inNom; 
        
    }
} 