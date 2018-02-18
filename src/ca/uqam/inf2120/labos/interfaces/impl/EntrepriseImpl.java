package ca.uqam.inf2120.labos.interfaces.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.uqam.inf2120.labos.interfaces.Employe;
import ca.uqam.inf2120.labos.interfaces.Entreprise;

/**
 * EntrepriseImpl : implèmente l'interface Entreprise.
 * 
 * @author Ismael Doukoure
 * @version Février 2014 
 * 
 */
public class EntrepriseImpl implements Entreprise {

	List<Employe> liste;

	/**
	 * Constructeur par défaut.
	 */
	public EntrepriseImpl() {
		liste = new ArrayList<Employe>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.labos.interfaces.Entreprise#ajouterEmploye(ca.uqam.inf2120
	 * .labos.interfaces.Employe)
	 */
	@Override
	public void ajouterEmploye(Employe emp) {

		if (emp != null && !existe(emp.getMatricule())) {
			liste.add(emp);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.labos.interfaces.Entreprise#existe(java.lang.String)
	 */
	@Override
	public boolean existe(String matricule) {

		boolean existe = false;

		if (matricule != null) {

			Employe e;
			Iterator<Employe> it = liste.iterator();
			while (it.hasNext() && !existe) {
				e = it.next();
				if (e.getMatricule().equals(matricule)) {
					existe = true;
				}
			}
		}

		return existe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.labos.interfaces.Entreprise#supprimer(ca.uqam.inf2120
	 * .labos.interfaces.Employe)
	 */
	@Override
	public boolean supprimer(Employe emp) {

		boolean estSupprimer = false;

		if (emp != null) {
			estSupprimer = liste.remove(emp);
		}

		return estSupprimer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.labos.interfaces.Entreprise#obtenirEmployes()
	 */
	@Override
	public Employe[] obtenirEmployes() {

		int nbElts = liste.size();
		Employe[] tab = new Employe[nbElts];

		for (int i = 0; i < nbElts; i++) {
			tab[i] = liste.get(i);
		}

		return tab;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.labos.interfaces.Entreprise#chercherEmploye(java.lang
	 * .String)
	 */
	@Override
	public Employe chercherEmploye(String matricule) {
		
		Employe emp = null;
		if (matricule != null) {

			Iterator<Employe> it = liste.iterator();
			while (it.hasNext() && emp == null) {
				Employe e = it.next();
				if (e.getMatricule().equals(matricule)) {
					emp = e;
				}
			}
		}
		
		return emp;
	}

}
