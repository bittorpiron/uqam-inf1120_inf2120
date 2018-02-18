package ca.uqam.inf1120.examplesetlabos;

/*
 * Classe qui contient les méthodes de base afin de créer de "cercles". Il est à noter que ces cercles
 * ne sont pas représentés graphiquement. Cette classe ne sert qu'à définir les attributs de bas
 * niveau d'un cercle i.e. les coordonnées x et y ainsi que le rayon.
 * 
 * 
 * Version : Mars 2011
 * 
 * 
 */


public class Cercle3 {

    //----------   P a r t i e   p u b l i q u e   ----------//

    // Constructeurs
   
    public Cercle3 () {
        //Appel du constructeur à 3 paramètres
        this(0, 0, 0);
    } // Constructeur de Cercle
    
    public Cercle3 ( int x, int y, int r ) {
        this.x = x;
        this.y = y;
        rayon = r;
    } // Constructeur de Cercle
    
    // Observateurs (getters)
    
    public int getX () {
        return x;
    } 

    public int getY () {
        return y;
    } 
    
    public int getRayon () {    
        return rayon;
    } 
    
    // Modificateurs (setters)
    
    public void setX (int coorx) {
        x = coorx;
    } 
    
    public void setY (int coory) {
        y = coory;
    }

    //modifie la valeur du rayon UNIQUEMENT si la valeur reçue en paramètre
    //est positive.
    public void setRayon (int rayon) {
        if(estPositif(rayon)){
            this.rayon = rayon; // ici, this est obligatoire car rayon designe le parametre et non la variable d'instance rayon
        }
    } 

    public void setXY (int coorx, int coory) {
        setX ( coorx ); // ou x = coorx
        setY ( coory ); // ou y = coory
    } 
    
    public void setXYrayon (int coorx, int coory, int r) {
        setXY ( coorx, coory );
        setRayon ( r );
    } 
    
    // autres méthodes utilitaires
    public double circonference () {
        return 2 * Math.PI * rayon;
    } 
    
    public double surface () {
        return Math.PI * rayon * rayon;
    } 
    
    //Retourne un nouveau Celcle3 ayant les même caractéristiques
    //que l'instance courante
    public Cercle3 cloner () {
        
        return new Cercle3(x, y, rayon);
        
    }

    public String toString(){
        
        return "X = " + x + "\nY = " + y + "\nRayon = " + rayon;
    }

    //----------   P a r t i e   p r i v e e   ----------//
    
    
    // ------- Méthodes privées servant au fonctionnement INTERNE 
    //---------de la classe et/ou de ses instances
    private static boolean estPositif(int r){
        return r == Math.abs(r);
    }
    
    // variables d'instance
    
    private int x;     // coordonnee x du centre du cercle
    private int y;     // coordonnee y du centre du cercle
    private int rayon; // rayon du cercle
    
} // Cercle3