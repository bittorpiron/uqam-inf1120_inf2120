package ca.uqam.inf2120.exemplesvusenclasse.heritage;


/**
 *  Titre : Notion d'héritage
 * 	Description: Classe Enseignant représente un enseignant avec les attributs suivants : 
 *               le nom, le prénom, le matricule, le salaire, et le nombre de cours donnés.
 * 	UQAM - INF2120
 * @author Ismael Doukoure
 * @version Septembre 2008
 * Modifié en Janvier 2014
 */
public class Enseignant extends Employe {
    
    // Déclaration des constantes
    // Chaque constante de classe est partagée entre toutes les instances
    // Chaque constante est invariable (final pas modifiable)
     private final static String DESCRPTION_NOMBRE_COURS_DONNES = "\n Nombre de cours données : " ;

     // les variables d'instance sont générées pour chaque
     // chaque objet de la classe
     private int nombreCoursDonnes;   // salaire du Prof


     /**
      * Constructeur sans argument. Crée un objet en
      *  initialisant les attributs aux valeurs par défaut 
      */
     public Enseignant(){
    	 
     }
     
     
     /**
      * Permet d'initialiser les attributs prenom, nom,
      * matricule, salaire et  nombreCoursDonnes
      * 
       * @param prenom Prénom de l'enseignant
      *  @param nom Nom de l'enseignant
      *  @param matricule Matricule de l'enseignant
      *  @param salaire Salaire de l'enseignant
      *  @param nombreCoursDonnes Nombre de cours donnés par l'enseignant
      *  
      */
     public Enseignant(String prenom, String nom, 
             String matricule, float salaire, int nombreCoursDonnes) {    
    	 super(prenom,nom, matricule, salaire);
         this.nombreCoursDonnes = nombreCoursDonnes;
     }

     /**
      * Permet d'initialiser ou modifier le nombre de cours donnés
      * 
      * @param nombreCoursDonnes 
      */
      public void setNombreCoursDonnes (int nombreCoursDonnes){
        this.nombreCoursDonnes = nombreCoursDonnes ;
      }
      
      /**
       * Obtenir le nombre de cours donnés
       * 
       * @param nombreCoursDonnes 
       */
       public int getNombreCoursDonnes (){
         return nombreCoursDonnes ;
       }

    
       /**
        * Retourne tous les attributs de l'objet sous forme de
        * chaîne de caractères
        *  
        * @return prénom, nom, matricule, salaire et nombre de cours donnés
        */
        public String toString () {
            return (super.toString() + 
            		DESCRPTION_NOMBRE_COURS_DONNES + getNombreCoursDonnes());
        }

}//fin de la classe Enseignant

