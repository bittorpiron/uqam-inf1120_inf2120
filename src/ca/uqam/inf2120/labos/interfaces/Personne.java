package ca.uqam.inf2120.labos.interfaces;



/**
 *  Titre : Notion d'héritage
 * 	Description: Classe Personne représente une personne avec les attributs suivants : 
 *               le nom, le prénom.
 * 	UQAM - INF2120
 * @author Ismael Doukoure
 * @version Septembre 2008
 * Modifié en Janvier 2014
 */
public class Personne {
       
     // Déclaration des constantes
     // Chaque constante de classe est partagée entre toutes les instances
     // Chaque constante est invariable (final pas modifiable)
     private final static String DESCRPTION_PRENOM = "\n Prénom  : " ;
     private final static String DESCRPTION_NOM = "\n Nom     : " ;
     
      // les variables d'instance sont générées pour chaque
     // chaque objet de la classe
     private String prenom ;    // Prénom de la personne
     private String nom ;       // Nom de la personne


     /**
      * Constructeur sans argument. Permet d'initialiser 
      * les attributs aux valeurs par défaut 
      */
     public Personne(){

      }
      
     
     /**
      * Permet d'initialiser les attributs prenom et nom 
      * 
      * @param prenom Prénom de la personne
      * @param nom Nom de la personne
      */
     public Personne(String prenom, String nom){
              this.prenom = prenom;
              this.nom = nom;
      }

     /**
      * Permet d'initialiser ou modifier le prémon
      * 
      * @param prenom Prénom de la personne
      */
      public void setPrenom (String prenom){
        this.prenom = prenom ;
      }

      /**
       * Permet d'initialiser ou modifier le nom
       * 
       * @param nom Nom de la personne
       */
       public void setNom (String nom) {
           this.nom = nom ;
       }

       /**
        * Obtenir le prénom de la personne
        * 
        * @return Le prénom de la personne
        */
        public String getPrenom () {
            return prenom ;
        }

        /**
         * Obtenir le nom de la personne
         * 
         * @return Le nom de la personne
         */
         public String getNom () {
             return nom ;
         }

         /**
          * Obtenir les attributs de l'instance courante(prénom, nom)
          * sous forme de chaîne de caractères
          * 
          * @return le prénom et le nom
          */
          public String toString (){
              return(DESCRPTION_PRENOM + getPrenom() + DESCRPTION_NOM + getNom() );
          }


} //fin de la classe Personne

