package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uqam.inf2120.tp3.modele.GestionnaireInventairePneus;
import ca.uqam.inf2120.tp3.modele.Pneu;

/**
 * AjoutModificationControleur: Le controleur (Controller) de la fenêtre AjoutModificationVue pou le Pattern MVC
 * 
 * @author Victor Piron PIRV11026606 INF2120 Groupe 30 (Ismaël Doukoure)
 *         piron.victor@courrier.uqam.ca
 * @version 2014-03-30 
 */

public class AjoutModificationControleur implements ActionListener {

	private GestionnaireInventairePneus modele;
	private AjoutModificationVue vue;
	private GestionnaireInventairePneusVue parentVue;
	private GestionnaireInventairePneusControleur parentControleur;

	public AjoutModificationControleur(AjoutModificationVue vue) {
		this.vue = vue;
		parentControleur = vue.getParentControleur();
		modele = parentControleur.getModele();
		parentVue = parentControleur.getVue();
	}

	/* Implementation de l'interface
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {

		// Obtenir la commande de l'événement.
		String command = event.getActionCommand();

		// Ajouter un nouveau pneau
		if (command.contentEquals(ChainesDeTexte.ETIQUETTE_AJOUTER)) {
			String message = estValidePneu();
			if (estValidePneu().isEmpty()) {

				modele.ajouterPneu(contruitNouveauPneau());
				//sans message d'erreur pour la recherche
				parentControleur.recherchePneus(false);
				vue.dispose();

			} else {
				//erreur dans les valeurs saisis
				parentVue.showMessageInfo(message);

			}
		} else if (command.contentEquals(ChainesDeTexte.ETIQUETTE_MODIFIER)) {

			// Modifier un pneu existant
			String message = estValidePneu();
			if (message.isEmpty()) {

				Pneu old = parentControleur.getListe().get(
						parentVue.getTableResultats().getSelectedRow());

				modele.modifierPneu(modifierPneau(old));
				
				//sans message d'erreur pour la recherche
				parentControleur.recherchePneus(false);
				vue.dispose();

			} else {
				//erreur dans les valeurs saisis
				parentVue.showMessageInfo(message);
				if (message.contains(ChainesDeTexte.MESSAGE_ERREUR_NBR_PNEUS)) {
					vue.getChoixNbrPneus().setText("");
				}

			}

		} else {

			vue.dispose();
		}

	}

	/**
	 * @return pneu construit à partir des informations de la vue
	 */
	private Pneu contruitNouveauPneau() {

		String saison = vue.getRdbtnEte().isSelected() ? ChainesDeTexte.ETIQUETTE_SAISON_ETE
				: ChainesDeTexte.ETIQUETTE_SAISON_HIVER;
		int diametreRoue = Integer.parseInt((String) vue.getComboBoxDiametre()
				.getSelectedItem());
		int largeur = Integer.parseInt((String) vue.getComboBoxLargueur()
				.getSelectedItem());
		int hauteur = Integer.parseInt((String) vue.getComboBoxHauteur()
				.getSelectedItem());
		float prix = Float.parseFloat(vue.getChoixPrix().getText()
				.replace(",", "."));
		int nombrePneus = Integer.parseInt(vue.getChoixNbrPneus().getText());

		return new Pneu(diametreRoue, largeur, hauteur, saison, prix,
				nombrePneus);
	}

	/**
	 * @param pneu  à modifier
	 * @return pneu construit à partir des informations saisis et avec
	 *         l'idéntifiant ce celui dans la liste
	 */
	private Pneu modifierPneau(Pneu pneu) {

		Pneu modifiePneu = contruitNouveauPneau();
		modifiePneu.setIdentifiant(pneu.getIdentifiant());

		return modifiePneu;
	}

	/**
	 * @return message d'erreur si les valeur entrées ne sont pas valides
	 */
	public String estValidePneu() {
		String pasValide = "";
		try {
			if (Integer.parseInt(vue.getChoixNbrPneus().getText()) <= 0 ) {

				pasValide += ChainesDeTexte.MESSAGE_ERREUR_NBR_PNEUS;
			}

		} catch (Exception e) {

			pasValide += ChainesDeTexte.MESSAGE_ERREUR_NBR_PNEUS;
		}
		try {
			if (Float
					.parseFloat(vue.getChoixPrix().getText().replace(",", ".")) <= 0 || Float
					.parseFloat(vue.getChoixPrix().getText().replace(",", ".")) >= Float.MAX_VALUE ) {

				pasValide += (pasValide.isEmpty() ? "" : "\n")
						+ ChainesDeTexte.MESSAGE_ERREUR_PRIX;

			}

		} catch (Exception e) {

			pasValide += (pasValide.isEmpty() ? "" : "\n")
					+ ChainesDeTexte.MESSAGE_ERREUR_PRIX;

		}

		return pasValide;
	}

}
