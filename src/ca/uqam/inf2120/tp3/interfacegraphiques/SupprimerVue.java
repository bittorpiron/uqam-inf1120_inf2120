/**
 * SupprimerDialogVu.java
 */
package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author Victor Piron PIRV11026606 INF2120 Groupe 30 (Ismaël Doukoure)
 *         piron.victor@courrier.uqam.ca
 * @version 2014-03-30
 */
public class SupprimerVue extends JDialog {

	private static final long serialVersionUID = -4656699768961653670L;
	private JTextField choixDescription;
	private JTextField choixNbrPneus;
	private SupprimerControleur controleur;

	/**
	 * Create the dialog.
	 */
	public SupprimerVue(GestionnaireInventairePneusControleur parentControleur) {
		initialiserPanneauInformations();	
		controleur = new SupprimerControleur(this, parentControleur);
		initialiserPanneauBoutons();
	}

	/**
	 * Initialiser le panneau des informations du pneau
	 */
	private void initialiserPanneauInformations() {
		setTitle(ChainesDeTexte.TITRE_SUPPRESSION);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(new BorderLayout());

		//Panneau Infos
		JPanel panneauInfos = new JPanel();
		panneauInfos.setBorder(new TitledBorder(null,
				ChainesDeTexte.TITRE_INFORMATION, TitledBorder.LEFT,
				TitledBorder.TOP, null, null));

		getContentPane().add(panneauInfos, BorderLayout.CENTER);
		panneauInfos.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblDescription = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_DESCRIPTION);
		panneauInfos.add(lblDescription);
		choixDescription = new JTextField();
		choixDescription.setEditable(false);
		panneauInfos.add(choixDescription);
		
		JLabel lblNbrPneus = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_NBR_PNEUS);
		panneauInfos.add(lblNbrPneus);
		choixNbrPneus = new JTextField();
		choixNbrPneus.setEditable(true);
		panneauInfos.add(choixNbrPneus);			
	}

	/**
	 * Initialiser le panneau des boutons
	 */
	private void initialiserPanneauBoutons() {
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnSupprimer = new JButton(ChainesDeTexte.ETIQUETTE_SUPPRIMER);
		btnSupprimer.setActionCommand(ChainesDeTexte.ETIQUETTE_SUPPRIMER);
		btnSupprimer.addActionListener(controleur);
		buttonPane.add(btnSupprimer);				

		JButton btnAnnuler = new JButton(ChainesDeTexte.ETIQUETTE_ANNULER);
		btnAnnuler.setActionCommand(ChainesDeTexte.ETIQUETTE_ANNULER);
		btnAnnuler.addActionListener(controleur);
		buttonPane.add(btnAnnuler);

		getRootPane().setDefaultButton(btnSupprimer);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * @return the choixDescription
	 */
	public JTextField getChoixDescription() {
		return choixDescription;
	}

	/**
	 * @return the choixNbrPneus
	 */
	public JTextField getChoixNbrPneus() {
		return choixNbrPneus;
	}
}
