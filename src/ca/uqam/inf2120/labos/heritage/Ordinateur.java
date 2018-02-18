package ca.uqam.inf2120.labos.heritage;

/**
 * 	Classe Ordinateur représente un ordinateur avec les attributs suivants : 
 *        modele, processeur, memoire, espace Disque, et nombre de ports USB.
 *               
 * 	UQAM  - INF2120
 * 
 * @author Gloire Lomani / Ismael Doukoure
 * @version Février 2014
 *
 */
public class Ordinateur {
	
	private static final String MODEL = "\nModele : " ;
	private static final String PROCESSEUR = "\nProcesseur : " ;
	private static final String MEMOIRE = "\nMemoire : " ;
	private static final String ESPACE_DISQUE = "\nEspace Disque : " ;
	private static final String NB_PORT_USB = "\nNombre Port Usb : " ;
	
	private String model;
	private String processeur;
	private double memoire;
	private double espaceDisk;
	private int nbPortsUsb;
	
	
	/**
	 * Constructeur avec tous les paramètres requis.
	 * 
	 * @param model
	 * @param processeur 
	 * @param memoire
	 * @param espaceDisk
	 * @param nbPortsUsb
	 */
	public Ordinateur(String model, String processeur, double memoire,
			double espaceDisk, int nbPortsUsb) {
		super();
		this.model = model;
		this.processeur = processeur;
		this.memoire = memoire;
		this.espaceDisk = espaceDisk;
		this.nbPortsUsb = nbPortsUsb;
	}


   /**
    * Obtenir le modèle.
    * 
    * @return Le modèle
    */
	public String getModel() {
		return model;
	}


   /**
    * Obtenir le processeur.
    * 
    * @return Le processeur
    */
	public String getProcesseur() {
		return processeur;
	}


	/**
	 * Obtenir la quantité de mémoire.
	 * 
	 * @return L'espace mémoire
	 */
	public double getMemoire() {
		return memoire;
	}


	/**
	 * Obtenir l'espace disque.
	 * 
	 * @return L'espace disque
	 */
	public double getEspaceDisk() {
		return espaceDisk;
	}


	/**
	 * Obtenir le nombre de ports USB.
	 * 
	 * @return Le nombre de ports USB
	 */
	public int getNbPortsUsb() {
		return nbPortsUsb;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MODEL + model + " " + PROCESSEUR + processeur +
				MEMOIRE + memoire + " " + ESPACE_DISQUE + espaceDisk +
				NB_PORT_USB + nbPortsUsb;
	}
	
	
	
	

}
