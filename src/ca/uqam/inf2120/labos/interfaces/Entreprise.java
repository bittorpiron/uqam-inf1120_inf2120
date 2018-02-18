package ca.uqam.inf2120.labos.interfaces;

/**
 * Entreprise : Interface définissant les services de gestion
 * des employés d'une entreprise. 
 *  
 * Université du  Québec à Montréal
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version 13 février 2014
 * 
 */
public interface Entreprise {

	/**
	 * Ajouter un employé dans la liste. Aucun ajout ne doit 
	 * �tre fait si l'employ� existe déjà dans la liste.
	 * 
	 * @param emp Employé à ajouter.
	 */
	public void ajouterEmploye(Employe emp);
	
	/**
	 * V�rifier s'il existe un employé dans la liste avec
	 * le matricule pass� en paramètre.
	 * 
	 * @param matricule Matricule de l'employé
	 * @return true si l'employé existe, sinon false.
	 */
	public boolean existe(String matricule);
	
	/**
	 * Supprimer un employé de la liste. 
	 * 
	 * @param emp Employé à supprimer
	 * @return true si l'employé est supprimé, sinon false.
	 */
	public boolean supprimer(Employe emp);


	/**
	 * Retourner un tableau contenant tous les employés. si la
	 * liste des employés est vide, retourner une valeur nulle. 
	 * 
	 * @return tableau des employés. 
	 */
	public Employe[] obtenirEmployes();
	
	
    /**
     * Chercher un employé dans la liste selon le matricule.
     * Retourner une valeur nulle si l'employé n'est pas trouvé.
     * 
     * @param matricule Le matricule de l'employé à chercher.
     * @return Employe l'employé trouvé.
     */
	public Employe chercherEmploye(String matricule);

}
