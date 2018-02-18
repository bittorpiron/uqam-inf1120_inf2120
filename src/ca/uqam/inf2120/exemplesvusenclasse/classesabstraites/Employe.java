package ca.uqam.inf2120.exemplesvusenclasse.classesabstraites;


/**
 *  Titre : Classes abstraites
 * 	Description: Classe Employe représente un employé avec les attributs suivants : 
 *               le nom, le prénom, le matricule, le salaire.
 * 	UQAM - INF2120
 * @author Ismael Doukoure
 * @version Septembre 2008
 * Modifié en Janvier 2014
 */
public class Employe extends Personne {
    
    // Déclaration des constantes
    // Chaque constante de classe est partagée entre toutes les instances
    // Chaque constante est invariable (final pas modifiable)
     private final static String DESCRPTION_MATRICULE = "\n Matricule  : " ;
     private final static String DESCRPTION_SALAIRE = "\n Salaire      : " ;

     // les variables d'instance sont générées pour chaque
     // chaque objet de la classe
     private String matricule ;   // Matricule de l'employé
     private float salaire;   // Salaire de l'employé

     /**
      * Constructeur sans argument.
      * Crée un objet en initialisant les attributs 
      * aux valeurs par défaut 
      */
     public Employe() {
    	 
     }
     
     
     /**
      * Permet d'initialiser les attributs prenom, nom,
      * matricule et salaire  
      * 
      * @param prenom Prénom de l'employé
      * @param nom Nom de l'employé
      * @param matricule Matricule de l'employé
      * @param salaire Salaire de l'employé
      */
     public Employe(String prenom, String nom, 
                    String matricule, float salaire){
              super(prenom,nom);
              this.matricule = matricule;
              this.salaire = salaire;
     }

     /**
      * Permet d'initialiser ou modifier le matricule
      * 
      * @param matricule
      */
      public void setMatricule (String matricule) {
        this.matricule = matricule;
      }
      
      /**
       * Permet d'initialiser ou modifier le salaire
       * 
       * @param salaire
       */
       public void setSalaire (float salaire) {
           this.salaire = salaire;
      }

      /**
       * Obtenir le matricule
       * 
       * @return le matricule
       */
       public String getMatricule (){
           return matricule;
       }

       /**
        * Obtenir le salaire
        * 
        * @return le salaire
        */
        public float getSalaire () {
            return salaire ;
        }

        /**
         * Retourne tous les attributs de l'instance courante dans une 
         * chaîne de caractères
         * 
         * @return prénom, nom, matricule et salaire
         */
         public String toString () {
             return (super.toString()
                    + DESCRPTION_MATRICULE + getMatricule() 
                    + DESCRPTION_SALAIRE + getSalaire());
         }


 		@Override
 		public String obtenirDescription() {
 			
 			return " Je suis un employé";
 		}
          
}  //fin de la classe Employe
