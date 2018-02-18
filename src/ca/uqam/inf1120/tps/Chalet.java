package ca.uqam.inf1120.tps;

/**
 * I N F 1 1 2 0 - g r o u p e 30 - AUT2013 - T P 3 - P1 (Celine Descheneaux)
 * 
 * Victor Piron PIRV11026606 piron.victor@courrier.uqam.ca 14-12-2013
 * 
 * 
 * Classe servant a creer des instances de chalet. Chaque chalet a un certain
 * nombre d'attributs qui sont decrits plus bas.
 * 
 * Un numero d’identification unique propre a chaque chalet (nombre entier
 * positif >= 1). Le numero d'identification automatiquement genere lors de sa
 * creation.
 * 
 * Un nombre de chambres (entier entre 1 et 3 inclusivement). Par defaut, le
 * nombre de chambres est 2. Un booleen pour indiquer si le chalet possede un
 * foyer a bois ou non. Valeur par defaut : false. Un booleen pour indiquer si
 * le chalet est en construction ou non. Valeur par defaut : false. Un booleen
 * pour indiquer si le chalet fini ou non. Valeur par defaut : false. Le nom du
 * modèle. Chaîne de caractère de longueur 30 ou moins. Valeur par défaut :
 * "".
 * 
 * Le type de fenêtres. Un entier. (0 = Coulissante, 1 = Guillotine, 2 =
 * Manivelle). La valeur par défaut est 1. Le type de plancher, un entier. (0 =
 * Chêne, 1 = Erable 2 = Flottant, 3 = Tuile). Valeur par défaut = 2. La
 * couleur extérieure. Un entier. (0 = Blanc, 1 = Bleu, 2 = Gris, 3 = Jaune, 4
 * = Rouge, 5 = Vert). La valeur par défaut est 5. Le type d'armoire de
 * cuisine, un entier. (0 = Chêne, 1 = Erable 2 = Mélamine, 3 = Pin). Valeur
 * par défaut = 2.
 * 
 * 
 * La classe comporte un certain nombre de constantes de classe et doit
 * permettre de conserver/consulter le nombre total de chalets qui ont ete
 * crees.
 * 
 **/

public class Chalet {

	// Constantes
	private static final String[] FENETRES = { "Coulissante", "Guillotine",
			"Manivelle" };
	private static final String[] PLANCHERS = { "Chene", "Erable", "Flottant",
			"Tuile" };
	private static final String[] EXTERIEURS = { "Blanc", "Bleu", "Gris",
			"Jaune", "Rouge", "Vert" };
	private static final String[] ARMOIRES = { "Chene", "Erable", "Melamine",
			"Pin" };

	public static final int MAX_EXTERIEURS = EXTERIEURS.length - 1;
	public static final int MAX_PLANCHERS = PLANCHERS.length - 1;
	public static final int MAX_FENETRES = FENETRES.length - 1;
	public static final int MAX_ARMOIRES = ARMOIRES.length - 1;
	public static final int MIN_FENETRES = 0;
	public static final int MIN_CHAMBRES = 1;
	public static final int DEFAUT_PLANCHER = 2;

	// Constantes publiques a ajouter...
	public static final int MIN_PLANCHERS = 0;
	public static final int MIN_EXTERIEURS = 0;
	public static final int MIN_ARMOIRES = 0;
	public static final int DEFAUT_CHAMBRES = 2;
	public static final int DEFAUT_FENETRES = 1;
	public static final int DEFAUT_EXTERIEURS = 5;
	public static final int DEFAUT_ARMOIRES = 2;
	public static final String DEFAUT_MODELE = "";
	public static final int MAX_CHAMBRES = 3;
	public static final int MAX_NBR_CARACTERES_NOM_MODELE = 30;

	public static final boolean DEFAUT_FOYER = false;
	public static final boolean DEFAUT_EN_CONSTRUCTION = false;
	public static final boolean DEFAUT_FINI = false;

	public static final int AUCUN_CHALET = 0;

	public static final String VRAI = "Vrai";
	public static final String FAUX = "Faux";

	// /////////////////////////////////////////////////////////////////////////////////////
	// Methodes utilitaires de CLASSE //
	// /////////////////////////////////////////////////////////////////////////////////////

	/*************************************************************************************
	 * Retourne la chaine de caractères correspondant a un numero de type de
	 * plancher recu en parametre. Si le numero ne correspond pas à un plancher
	 * existant, la methode retourne la chaine vide ("").
	 **************************************************************************************/
	public static String plancher(int no) {

		String typePlancher = "";

		if (no >= MIN_PLANCHERS && no <= MAX_PLANCHERS) {

			typePlancher = PLANCHERS[no];

		}

		return typePlancher;
	}

	/**************************************************************************************
	 * Retourne la chaine de caractères correspondant a un numero d'exterieur
	 * recu en parametre. Si le numero ne correspond pas à un exterieur
	 * existant, la methode retourne la chaine vide ("").
	 ***************************************************************************************/
	public static String exterieur(int no) {

		String typeExterieur = "";

		if (no >= MIN_EXTERIEURS && no <= MAX_EXTERIEURS) {

			typeExterieur = EXTERIEURS[no];

		}

		return typeExterieur;
	}

	/**************************************************************************************
	 * Retourne la chaine de caractères correspondant a un numero de type
	 * fenetres recu en parametre. Si le numero ne correspond pas à un type de
	 * fenetres existant, la methode retourne la chaine vide ("").
	 ***************************************************************************************/
	public static String fenetre(int no) {

		String typeFenetre = "";

		if (no >= MIN_FENETRES && no <= MAX_FENETRES) {

			typeFenetre = FENETRES[no];

		}

		return typeFenetre;
	}

	/**************************************************************************************
	 * Retourne la chaine de caractères correspondant a un numero de type
	 * d'armoires recu en parametre. Si le numero ne correspond pas à un type
	 * d'armoire existant, la methode retourne la chaine vide ("").
	 ***************************************************************************************/
	public static String armoire(int no) {

		String typeArmoire = "";

		if (no >= MIN_ARMOIRES && no <= MAX_ARMOIRES) {

			typeArmoire = ARMOIRES[no];

		}

		return typeArmoire;
	}

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTEURS //
	// /////////////////////////////////////////////////////////////

	/***********************************************************************************************
	 * Cree un chalet dont tous les attributs sont aux valeurs par defaut. Le
	 * numero de chalet est attribue automatiquement par le constructeur (les
	 * numeros debutent a 1).
	 ***********************************************************************************************/
	public Chalet() {

		nbrChalets = nbrChalets + 1;
		noChalet = nbrChalets;

	}

	/*******************************************************************************************
	 * Cree un chalet avec les donnees passees en parametre.
	 * 
	 * Lorsqu'une valeur passee en parametre ne fait pas partie des valeurs
	 * permises, la valeur par defaut est attribuee automatiquement a l'attribut
	 * correspondant.
	 * 
	 * Le numero est attribue automatiquement par le constructeur. Les numeros
	 * debutent a 1. Un chalet n'est pas, lors de sa creation, fini ni en
	 * construction.
	 * 
	 *******************************************************************************************/
	public Chalet(int plancher, int exterieur, int armoire, int fenetre,
			int chambres, String modele, boolean foyer) {

		// les modificateurs valident les valeurs permises
		setPlancher(plancher);
		setExterieur(exterieur);
		setArmoire(armoire);
		setFenetre(fenetre);
		setNbreChambres(chambres);
		setModele(modele);

		avecFoyer = foyer;

		nbrChalets = nbrChalets + 1;
		noChalet = nbrChalets;

	}

	// /////////////////////////////////////////////////////////////////////////////////////
	// Observateur (getter) de CLASSE //
	// /////////////////////////////////////////////////////////////////////////////////////

	public static int getNbrChalets() {

		return nbrChalets;

	}

	// /////////////////////////////////////////////////////////////////////////////////////
	// 10 Observateurs (getters) d'INSTANCE //
	// //
	// IMPORTANT : les observateurs pour le plancher, les armoires et
	// l'exterieur et //
	// / les fenetres ne DOIVENT PAS retourner des CHAINES DE CARACTERES. //
	// Vos observateurs doivent suivre la convention getNomVariable //
	// (ou isNomVariable pour les booleens). //
	// /////////////////////////////////////////////////////////////////////////////////////

	/*******************************************************************************
	 * Observe le numero attribue par le constructeur pour le chalet.
	 *******************************************************************************/
	public int getNoChalet() {

		return noChalet;

	}

	/*******************************************************************************
	 * Observe la sorte de plancher du chalet.
	 *******************************************************************************/
	public int getPlancher() {

		return plancher;

	}

	/*******************************************************************************
	 * Observe la sorte d'exterieur du chalet.
	 *******************************************************************************/
	public int getExterieur() {

		return exterieur;

	}

	/*******************************************************************************
	 * Observe la sorte d'armoires du chalet.
	 *******************************************************************************/
	public int getArmoire() {

		return armoire;

	}

	/*******************************************************************************
	 * Observe la sorte de fenetres du chalet.
	 *******************************************************************************/
	public int getFenetre() {

		return fenetre;

	}

	/*******************************************************************************
	 * Observe le nombre de chambres du chalet.
	 ******************************************************************************/
	public int getNbreChambres() {

		return nbreChambres;

	}

	/*******************************************************************************
	 * Observe le modele du chalet.
	 *******************************************************************************/
	public String getModele() {

		return modele;

	}

	/*******************************************************************************
	 * Observe si le chalet est avec un foyer ou non.
	 *******************************************************************************/
	public boolean isAvecFoyer() {

		return avecFoyer;

	}

	/*******************************************************************************
	 * Observe si le chalet est fini ou non.
	 *******************************************************************************/
	public boolean isFini() {

		return fini;

	}

	/*******************************************************************************
	 * Observe si le chalet est en construction ou non.
	 *******************************************************************************/
	public boolean isEnConstruction() {

		return enConstruction;

	}

	// /////////////////////////////////////////////////////////////////////////////////////
	// 9 Modificateurs (setters) d'INSTANCE //
	// //
	// IMPORTANT : Vos modificateurs doivent suivre la convention setNomVariable
	// //
	// /////////////////////////////////////////////////////////////////////////////////////

	/*******************************************************************************
	 * Modifie si le chalet est avec un foyer ou non. Aucune modification n'est
	 * effectuee et aucun message d'erreur ne sera affiche si le chalet est fini
	 * ou en construction.
	 *******************************************************************************/
	public void setAvecFoyer(boolean f) {

		if (!(fini || enConstruction)) {

			avecFoyer = f;

		}

	}

	/******************************************************************************
	 * Modifie si le chalet est en construction ou non. Aucune modification
	 * n'est effectuee et aucun message 'erreur ne sera affiche si le chalet est
	 * fini ou s'il est deja en construction.
	 ******************************************************************************/
	public void setEnConstruction(boolean c) {

		if (!(fini || enConstruction)) {

			enConstruction = c;

		}

	}

	/******************************************************************************
	 * Modifie si le chalet est en fini ou non. Aucune modification n'est
	 * effectuee et aucun message d'erreur ne sera affiche si le chalet est deja
	 * fini ou s'il n'est pas en construction. Remarque : Un chalet qui
	 * "devient" fini n'est plus en construction...
	 ******************************************************************************/
	public void setFini(boolean f) {

		if (!(fini || !enConstruction)) {

			fini = f;
			enConstruction = !f;

		}

	}

	/******************************************************************************
	 * Modifie la sorte de plancher du chalet. Si la sorte de plancher fournie
	 * n'est pas parmi les valeurs permises, aucune modification n'est effectuee
	 * et aucun message d'erreur ne sera affiche.
	 ******************************************************************************/
	public void setPlancher(int p) {

		if (!(p < MIN_PLANCHERS || p > MAX_PLANCHERS)) {

			plancher = p;

		}

	}

	/*******************************************************************************
	 * Modifie la sorte de fenetres du chalet. Si la sorte de fenetre fournie
	 * n'est pas parmi les valeurs permises, aucune modification n'est effectuee
	 * et aucun message d'erreur ne sera affiche.
	 *******************************************************************************/
	public void setFenetre(int f) {

		if (!(f < MIN_FENETRES || f > MAX_FENETRES)) {

			fenetre = f;

		}

	}

	/******************************************************************************
	 * Modifie la sorte d'exterieur du chalet. Si la sorte d'exterieur fournie
	 * n'est pas parmi les valeurs permises, aucune modification n'est effectuee
	 * et aucun message d'erreur ne sera affiche.
	 ******************************************************************************/
	public void setExterieur(int e) {

		if (!(e < MIN_EXTERIEURS || e > MAX_EXTERIEURS)) {

			exterieur = e;

		}

	}

	/******************************************************************************
	 * Modifie la sorte d'armoires du chalet. Si la sorte d'armoires fournie
	 * n'est pas parmi les valeurs permises, aucune modification n'est effectuee
	 * et aucun message d'erreur ne sera affiche.
	 ******************************************************************************/
	public void setArmoire(int a) {

		if (!(a < MIN_ARMOIRES || a > MAX_ARMOIRES)) {

			armoire = a;

		}

	}

	/*****************************************************************************
	 * Modifie le nombre de chambres du chalet. Si le nombre de chambres fourni
	 * n'est pas parmi les valeurs permises, aucune modification n'est effectuee
	 * et aucun message d'erreur ne sera affiche.
	 ******************************************************************************/
	public void setNbreChambres(int nC) {

		if (!(nC < MIN_CHAMBRES || nC > MAX_CHAMBRES)) {

			nbreChambres = nC;

		}

	}

	/******************************************************************************
	 * Modifie le modele du chalet. Si le modele fourni a la valeur null ou que
	 * sa longueur depasse la longueur permise, aucune modification n'est
	 * effectuee et aucun message d'erreur ne sera affiche.
	 ******************************************************************************/
	public void setModele(String m) {

		if (!(m == null || m.length() > MAX_NBR_CARACTERES_NOM_MODELE)) {

			modele = m;

		}

	}

	// /////////////////////////////////////////////////////////////////////////////////////
	// Methodes utilitaires d'instance //
	// /////////////////////////////////////////////////////////////////////////////////////

	/******************************************************************************
	 * Retourne un chalet dont les caractéristiques sont les memes que celles
	 * du chalet courant exceptions faites des attributs enConstruction et fini
	 * du nouveau chalet qui sont automatiquement false et de son numero
	 * d'identification qui est genere automatiquement lors de sa creation.
	 ******************************************************************************/
	public Chalet cloner() {

		return new Chalet(plancher, exterieur, armoire, fenetre, nbreChambres,
				modele, avecFoyer);

	}

	/******************************************************************************
	 * Retourne une chaine de caracteres qui correspond aux caracteristiques du
	 * chalet.
	 ******************************************************************************/
	public String toString() {

		String description = "No Chalet: " + noChalet + "\nPlancher: "
				+ plancher + " ( " + plancher(plancher) + " ) "
				+ "\nArmoires: " + armoire + " ( " + armoire(armoire) + " ) "
				+ "\nCouleur Exterieur: " + exterieur + " ( "
				+ exterieur(exterieur) + " ) " + "\nFenetres: " + fenetre
				+ " ( " + fenetre(fenetre) + " ) " + "\nNbr Chambres: "
				+ nbreChambres + "\nModele: " + modele + "\nAvec Foyer?: "
				+ toVraiFauxString(avecFoyer) + "\nFini?: "
				+ toVraiFauxString(fini) + "\nEn Construction?: "
				+ toVraiFauxString(enConstruction);
		return description;

	}

	public String toVraiFauxString(boolean value) {

		String result = FAUX;

		if (value) {

			result = VRAI;

		}

		return result;
	}

	// variable de classe (pour usage interne : servira lors de la generation
	// du numero distinct donne a chaque chalet cree)

	private static int nbrChalets = AUCUN_CHALET;

	// Variables d'instance

	private int noChalet;
	private int plancher = DEFAUT_PLANCHER;
	private int exterieur = DEFAUT_EXTERIEURS;
	private int armoire = DEFAUT_ARMOIRES;
	private int fenetre = DEFAUT_FENETRES;
	private int nbreChambres = DEFAUT_CHAMBRES;
	private String modele = DEFAUT_MODELE;
	private boolean avecFoyer = DEFAUT_FOYER;
	private boolean fini = DEFAUT_FINI;
	private boolean enConstruction = DEFAUT_EN_CONSTRUCTION;

} // Chalet

