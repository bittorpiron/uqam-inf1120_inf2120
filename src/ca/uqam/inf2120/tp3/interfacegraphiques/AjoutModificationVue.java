/**
 * TestDialog.java
 */
package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import ca.uqam.inf2120.tp3.modele.Pneu;

/**
 * AjoutModificationVue. Fenêtre unique qui permet d'ajouter un nouveau pneau ou de
 * modifier les informations d’un pneu sélectionné dans la liste des pneus.
 * L'unique différence étant l'initialisation des valeurs pour la modification.
 * 
 * Lors de la modification, tous les valeurs du pneu sélectionné peuvent être
 * modifiées. Les règles de validation des champs "Prix" et "Nombre de pneus"
 * sont les mêmes que celles lors de l'ajout d'un pneu.
 * 
 * @author Victor Piron PIRV11026606 INF2120 Groupe 30 (Ismaël Doukoure)
 *         piron.victor@courrier.uqam.ca
 * @version 2014-03-30
 */
public class AjoutModificationVue extends JDialog {

	private static final long serialVersionUID = 876762255416218506L;
	private JRadioButton rdbtnEte;
	private JRadioButton rdbtnHiver;
	private JComboBox<JLabel> comboBoxLargeur;
	private JComboBox<JLabel> comboBoxHauteur;
	private JComboBox<JLabel> comboBoxDiametre;
	private JTextField choixPrix;
	private JTextField choixNbrPneus;

	private AjoutModificationControleur controleur;
	private GestionnaireInventairePneusControleur parentControleur;

	/**
	 * Créér la boîte de dialogue.
	 */
	public AjoutModificationVue(
			GestionnaireInventairePneusControleur parentController,
			Object source) {
		
		this.parentControleur = parentController;
		controleur = new AjoutModificationControleur(this);
		initialiserPanneaux(source);
	}

	/**
	 * Initialiser les panneaux. Selon la source on peux être en "Modifier" ou "Ajouter"
	 */
	private void initialiserPanneaux(Object source) {

		boolean estAjouter = (source == parentControleur.getVue()
				.getBtnAjouter());

		setTitle(source == parentControleur.getVue().getBtnAjouter() ? ChainesDeTexte.TITRE_AJOUT
				: ChainesDeTexte.TITRE_MODIFICATION);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());

		initialiserPanneauSaisie(estAjouter);

		initialiserBoutons(estAjouter);
	}

	/**
	 * @param estAjouter
	 *            faux si on doit afficher information du pneau à modifier
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void initialiserPanneauSaisie(boolean estAjouter) {

		JPanel panneauSaisie = new JPanel();
		panneauSaisie.setBorder(new TitledBorder(null,
				ChainesDeTexte.TITRE_INFORMATION, TitledBorder.LEFT,
				TitledBorder.TOP, null, null));

		getContentPane().add(panneauSaisie, BorderLayout.CENTER);
		panneauSaisie.setLayout(new GridLayout(0, 2, 0, 0));

		// Création du groupe des radio boutons
		ButtonGroup groupeBoutonsSaison = new ButtonGroup();

		rdbtnHiver = new JRadioButton(ChainesDeTexte.ETIQUETTE_SAISON_HIVER);
		rdbtnHiver.setSelected(true);
		rdbtnEte = new JRadioButton(ChainesDeTexte.ETIQUETTE_SAISON_ETE);

		// Ajout des radio boutons au groupe pour
		// permettre un choix exclusif.
		groupeBoutonsSaison.add(rdbtnHiver);
		groupeBoutonsSaison.add(rdbtnEte);
		panneauSaisie.add(rdbtnHiver);
		panneauSaisie.add(rdbtnEte);

		//
		JLabel lblLargueurs = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_LARGUEUR);
		panneauSaisie.add(lblLargueurs);

		comboBoxLargeur = new JComboBox<JLabel>();
		comboBoxLargeur.setEditable(false);
		comboBoxLargeur
				.setModel(new DefaultComboBoxModel(ChainesDeTexte.LARGUEURS));
		panneauSaisie.add(comboBoxLargeur);

		//
		JLabel lblHauteur = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_HAUTEUR);
		panneauSaisie.add(lblHauteur);

		comboBoxHauteur = new JComboBox<JLabel>();
		comboBoxHauteur.setEditable(false);
		comboBoxHauteur.setModel(new DefaultComboBoxModel(ChainesDeTexte.HAUTEURS));
		panneauSaisie.add(comboBoxHauteur);

		//
		JLabel lblDiametre = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_DIAMETRE);
		panneauSaisie.add(lblDiametre);

		comboBoxDiametre = new JComboBox<JLabel>();
		comboBoxDiametre.setEditable(false);
		comboBoxDiametre
				.setModel(new DefaultComboBoxModel(ChainesDeTexte.DIAMETRES));
		panneauSaisie.add(comboBoxDiametre);

		//
		JLabel lblPrix = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_PRIX);
		panneauSaisie.add(lblPrix);

		choixPrix = new JTextField();
		panneauSaisie.add(choixPrix);
		choixPrix.setColumns(10);

		//
		JLabel lblNbrPneus = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_NBR_PNEUS);
		panneauSaisie.add(lblNbrPneus);

		choixNbrPneus = new JTextField();
		panneauSaisie.add(choixNbrPneus);
		choixNbrPneus.setColumns(10);

		if (!estAjouter) {
			initialiserInformationPneau();
		}

	}
	
	/**
	 * Charger les éléments de la fenêtre avec l'information du pneu selectionné dans la table
	 */
	private void initialiserInformationPneau() {	
		
		int indexPneauSelectionne = parentControleur.getVue().getTableResultats()
				.getSelectedRow();
		
		//Pneu selectionné
		Pneu pneau = parentControleur.getListe().get(indexPneauSelectionne);
		
		if (pneau.getSaison().contentEquals(ChainesDeTexte.ETIQUETTE_SAISON_ETE)) {
			rdbtnEte.setSelected(true);
		} else {
			rdbtnHiver.setSelected(true);
		}
		comboBoxLargeur.getModel().setSelectedItem(String.valueOf(pneau.getLargeur()));
		comboBoxHauteur.getModel().setSelectedItem(String.valueOf(pneau.getHauteur()));
		comboBoxDiametre.getModel().setSelectedItem(String.valueOf(pneau.getDiametreRoue()));
		choixPrix.setText(String.format("%.2f", pneau.getPrix()));		
		choixNbrPneus.setText(String.valueOf(pneau.obtenirNbCopies()));
	}
	
	/**
	 * @param estAjouter
	 *            vrai si bouton doit afficher "Ajouter" sinon "Modifier"
	 * */
	private void initialiserBoutons(boolean estAjouter) {

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton okButton;

		if (estAjouter) {
			okButton = new JButton(ChainesDeTexte.ETIQUETTE_AJOUTER);
			okButton.setActionCommand(ChainesDeTexte.ETIQUETTE_AJOUTER);
		} else {
			okButton = new JButton(ChainesDeTexte.ETIQUETTE_MODIFIER);
			okButton.setActionCommand(ChainesDeTexte.ETIQUETTE_MODIFIER);
		}
		okButton.addActionListener(controleur);
		buttonPane.add(okButton);

		JButton cancelButton = new JButton(ChainesDeTexte.ETIQUETTE_ANNULER);
		cancelButton.setActionCommand(ChainesDeTexte.ETIQUETTE_ANNULER);
		cancelButton.addActionListener(controleur);
		buttonPane.add(cancelButton);
		
		getRootPane().setDefaultButton(okButton);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * @return the rdbtnEte
	 */
	public JRadioButton getRdbtnEte() {
		return rdbtnEte;
	}

	/**
	 * @return the parentControleur
	 */
	public GestionnaireInventairePneusControleur getParentControleur() {
		return parentControleur;
	}

	/**
	 * @param rdbtnEte
	 *            the rdbtnEte to set
	 */
	public void setRdbtnEte(JRadioButton rdbtnEte) {
		this.rdbtnEte = rdbtnEte;
	}

	/**
	 * @return the rdbtnHiver
	 */
	public JRadioButton getRdbtnHiver() {
		return rdbtnHiver;
	}

	/**
	 * @param rdbtnHiver
	 *            the rdbtnHiver to set
	 */
	public void setRdbtnHiver(JRadioButton rdbtnHiver) {
		this.rdbtnHiver = rdbtnHiver;
	}

	/**
	 * @return the comboBoxLargueur
	 */
	public JComboBox<JLabel> getComboBoxLargueur() {
		return comboBoxLargeur;
	}

	/**
	 * @param comboBoxLargueur
	 *            the comboBoxLargueur to set
	 */
	public void setComboBoxLargueur(JComboBox<JLabel> comboBoxLargueur) {
		this.comboBoxLargeur = comboBoxLargueur;
	}

	/**
	 * @return the comboBoxHauteur
	 */
	public JComboBox<JLabel> getComboBoxHauteur() {
		return comboBoxHauteur;
	}

	/**
	 * @param comboBoxHauteur
	 *            the comboBoxHauteur to set
	 */
	public void setComboBoxHauteur(JComboBox<JLabel> comboBoxHauteur) {
		this.comboBoxHauteur = comboBoxHauteur;
	}

	/**
	 * @return the comboBoxDiametre
	 */
	public JComboBox<JLabel> getComboBoxDiametre() {
		return comboBoxDiametre;
	}

	/**
	 * @param comboBoxDiametre
	 *            the comboBoxDiametre to set
	 */
	public void setComboBoxDiametre(JComboBox<JLabel> comboBoxDiametre) {
		this.comboBoxDiametre = comboBoxDiametre;
	}

	/**
	 * @return the choixPrix
	 */
	public JTextField getChoixPrix() {
		return choixPrix;
	}

	/**
	 * @param choixPrix
	 *            the choixPrix to set
	 */
	public void setChoixPrix(JTextField choixPrix) {
		this.choixPrix = choixPrix;
	}

	/**
	 * @return the choixNbrPneus
	 */
	public JTextField getChoixNbrPneus() {
		return choixNbrPneus;
	}

	/**
	 * @param choixNbrPneus
	 *            the choixNbrPneus to set
	 */
	public void setChoixNbrPneus(JTextField choixNbrPneus) {
		this.choixNbrPneus = choixNbrPneus;
	}
}