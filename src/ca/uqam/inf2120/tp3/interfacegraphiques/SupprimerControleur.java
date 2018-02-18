package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uqam.inf2120.tp3.modele.GestionnaireInventairePneus;
import ca.uqam.inf2120.tp3.modele.Pneu;

/**
 * SupprimerControleur: Le controleur (Controller) de la fen�tre SupprimerVue
 * pour le pattern MVC
 * 
 * @author Victor Piron PIRV11026606 INF2120 Groupe 30 (Isma�l Doukoure)
 *         piron_mardones.victor@courrier.uqam.ca
 * @version 2014-04-20
 * 
 */

public class SupprimerControleur implements ActionListener {

	private SupprimerVue vue;
	private GestionnaireInventairePneusControleur parentControleur;
	private GestionnaireInventairePneus modele;

	public SupprimerControleur(SupprimerVue vue,
			GestionnaireInventairePneusControleur parentControleur) {
		this.modele = parentControleur.getModele();
		this.parentControleur = parentControleur;
		this.vue = vue;

		initialiserLaVue();

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {

		// Obtenir la source de l'�v�nement.
		String command = event.getActionCommand();

		if (command == ChainesDeTexte.ETIQUETTE_SUPPRIMER) {
			String messageError = "";
			try {
				if (Integer.parseInt(vue.getChoixNbrPneus().getText()) <= 0) {

					messageError += ChainesDeTexte.MESSAGE_ERREUR_NBR_PNEUS;
				}

			} catch (Exception e) {

				messageError += ChainesDeTexte.MESSAGE_ERREUR_NBR_PNEUS;
			}

			if (messageError.isEmpty()) {
				GestionnaireInventairePneusVue parentVue = parentControleur
						.getVue();

				Pneu old = parentControleur.getListe().get(
						parentVue.getTableResultats().getSelectedRow());
				construirePneuASupprimer(old);
				modele.supprimerPneu(construirePneuASupprimer(old));

				parentControleur.recherchePneus(false);
			} else {
				parentControleur.getVue().showMessageInfo(messageError);
			}

		}
		vue.dispose();
	}

	/**
	 * Changer la vue avec la description el le nbr de pneus de la sélection
	 */
	private void initialiserLaVue() {

		int ligne = parentControleur.getVue().getTableResultats()
				.getSelectedRow();
		String descriptionPneu = (String) parentControleur.getVue()
				.getTableResultats().getModel().getValueAt(ligne, 0);

		vue.getChoixDescription().setText(descriptionPneu);
		vue.getChoixNbrPneus().setText(
				(String) parentControleur.getVue().getTableResultats()
						.getModel().getValueAt(ligne, 2));
	}

	/**
	 * @param pneu � supprimer
	 * @return 
	 */
	private Pneu construirePneuASupprimer(Pneu pneu) {

		int nbrPneusSupprimer = Integer.parseInt(vue.getChoixNbrPneus()
				.getText());
		
		Pneu pneauSupprimer = new Pneu(pneu.getIdentifiant(), nbrPneusSupprimer);		
		//initialise string for pneu.equals 
		pneauSupprimer.setSaison("");

		return pneauSupprimer;
	}
}
