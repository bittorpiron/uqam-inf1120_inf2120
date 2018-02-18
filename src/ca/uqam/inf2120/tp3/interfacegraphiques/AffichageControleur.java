package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uqam.inf2120.tp3.modele.Pneu;

/**
 * AffichageControleur: Le controleur (Controller) de la fenêtre AffichageVu
 * 
 * @author Victor Piron PIRV11026606 INF2120 Groupe 30 (Ismaël Doukoure)
 *         piron.victor@courrier.uqam.ca
 * @version 2014-03-30 
 * 
 */

public class AffichageControleur implements ActionListener {

	private AffichageVue vue;
	private GestionnaireInventairePneusControleur parentControleur;

	public AffichageControleur(AffichageVue vueAffichage,
			GestionnaireInventairePneusControleur parentControleur) {
		this.parentControleur = parentControleur;
		this.vue = vueAffichage;

		initialiserValeurs();

	}
	
	/* Implementation de l'interface
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {

		// Obtenir la source de l'événement.
		Object source = event.getSource();

		if (source == vue.getBtnFermer()) {

			vue.dispose();

		}
	}
	
	/**
	 * Initialise la vue avec les valeurs dans la table du pneau selectionné
	 */
	private void initialiserValeurs() {		
		
		int indexPneauSelectionne = parentControleur.getVue().getTableResultats()
				.getSelectedRow();
		
		//Pneu selectionné
		Pneu pneau = parentControleur.getListe().get(indexPneauSelectionne);		
		
		vue.getChoixSaison().setText(pneau.getSaison());
		vue.getChoixLargeur().setText(String.valueOf(pneau.getLargeur()));
		vue.getChoixHauteur().setText(String.valueOf(pneau.getHauteur()));
		vue.getChoixDiametre().setText(String.valueOf(pneau.getDiametreRoue()));
		vue.getChoixPrix().setText(String.format("%.2f", pneau.getPrix()));		
		vue.getChoixNbrPneus().setText(String.valueOf(pneau.obtenirNbCopies()));
	}

}
