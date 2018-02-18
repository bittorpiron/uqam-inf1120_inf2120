package ca.uqam.inf2120.exemplesvusenclasse.tda.impl.tests;

/**
* <p>Title: Livre</p>
* <p>Description: Contient les informations d'un livre</p>
* <p>Copyright: Copyright (c) 2008</p>
* <p>Company: UQAM</p>
* @author Ismael Doukoure
* @version 1.0
*/
public class Livre {
	
	// Déclaration des constantes
    // Chaque constante de classe est partagée entre toutes les instances
    // Chaque constante est invariable (final pas modifiable)
    private final static String NUMERO_ISBN =  "\n Numéro ISBN : " ;
    private final static String NOM_LIVRE = "\n Nom du livre : " ;
    private final static String AUTEUR_LIVRE = "\n Auteur du livre : " ;
    private final static String NOMBRE_PAGES = "\n Nombre de pages : " ;
    
     // les variables d'instance sont générées pour chaque
    // chaque objet de la classe
    private String numeroIsbn ;   // Numéro ISBN du livre
    private String nom ;    	  // Nom du livre
    private String auteur ;       // Auteur du livre
    private int nombrePages;      // Nombre de pages

    /**
     * Constructeur sans argument. Permet d'initialiser 
     * les attributs aux valeurs par défaut 
     */
     public Livre(){
     }
     
  /**
   * Permet d'initialiser les attributs du livre
   * @param numeroIsbn Numéro ISBN du livre
   * @param nom Nom du livre
   * @param auteur Auteur du livre
   * @param nombrePages Nombre de pages
   */
    public Livre(String numeroIsbn, String nom, String auteur, int nombrePages){ 
    		 setNumeroIsbn(numeroIsbn);
             setNom(nom) ;
             setAuteur(auteur) ;
             setNombrePages(nombrePages);
    }

   
    /*********************************************************************
     * Permet d'initialiser ou modifier le numéro ISBN
     * @param numeroIsbn Numéro ISBN du livre
     **********************************************************************/
	public void setNumeroIsbn(String numeroIsbn) {
		this.numeroIsbn = numeroIsbn;
	}

    /*********************************************************************
     * Permet d'initialiser ou modifier le nom
     * @param nom Nom du livre
     **********************************************************************/
     public void setNom (String nom) {
         this.nom = nom ;
     }

    /*********************************************************************
     * Permet d'initialiser ou modifier l'auteur
     * @param auteur Auteur du livre
     **********************************************************************/
     public void setAuteur (String auteur){
       this.auteur = auteur ;
     }

     /*********************************************************************
      * Permet d'initialiser ou modifier le nombre de pages
      * @param nombrePages Nombre de pages du livre
      **********************************************************************/
      public void setNombrePages (int nombrePages) {
          this.nombrePages = nombrePages ;
      }

      /*********************************************************************
       * Obtenir le numéro ISBN du livre
       * @return Le numéro ISBN du livre
       **********************************************************************/
       public String getNumeroIsbn() {
    	   return numeroIsbn;
  	   }
      
      /*********************************************************************
       * Obtenir le nom du livre
       * @return Le nom du livre
       **********************************************************************/
       public String getNom () {
           return nom ;
       }
       
      /*********************************************************************
       * Obtenir l'auteur du livre.
       * @return L'auteur du livre
       **********************************************************************/
       public String getAuteur () {
           return auteur ;
       }

       /*********************************************************************
        * Obtenir le nombre de pages du livre
        * @return Le nombre de pages du livres
        **********************************************************************/
        public int getNombrePages () {
            return nombrePages ;
        }

        /************************************************************************
         * Obtenir les attributs de l'instance courante(numéro ISBN, nom, auteur, 
         * nombre de pages)
         * @return le nom, l'auteur et le nombre de pages
         ***********************************************************************/
         public String toString (){
             return(NUMERO_ISBN + getNumeroIsbn()
            		+ NOM_LIVRE + getNom() 
            		+ AUTEUR_LIVRE + getAuteur()
            		+ NOMBRE_PAGES + getNombrePages());
         }


}

