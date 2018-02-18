/**
 * TestDialog.java
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
 * AffichageVue. Fenêtre pour l’affichage des informations d’un pneu sélectionné
 * dans la liste des pneus. Tous les champs doivent être non éditables (ou non
 * modifiables).
 * 
 * @author Victor Piron PIRV11026606 INF2120 Groupe 30 (Ismaël Doukoure)
 *         piron.victor@courrier.uqam.ca
 * @version 2014-03-30   
 */
public class AffichageVue extends JDialog {

	private static final long serialVersionUID = -5886763387445002503L;
	private JTextField choixSaison;
	private JTextField choixLargeur;
	private JTextField choixHauteur;
	private JTextField choixDiametre;
	private JTextField choixPrix;
	private JTextField choixNbrPneus;
	JButton btnFermer;

	private AffichageControleur controleur;

	/**
	 * Créér la boîte de dialogue.
	 */
	public AffichageVue(GestionnaireInventairePneusControleur parentControleur) {

		initialiserPanneauAffichage();
		controleur = new AffichageControleur(this, parentControleur);
		initialiserPanneauBouton();
	}

	/**
	 * Nordic Pneus (SGI) - Affichage
	 */
	private void initialiserPanneauAffichage() {
		setTitle(ChainesDeTexte.TITRE_AFFICHAGE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());

		// Panneau Infos
		JPanel panneauInfos = new JPanel();
		panneauInfos.setBorder(new TitledBorder(null,
				ChainesDeTexte.TITRE_INFORMATION, TitledBorder.LEFT,
				TitledBorder.TOP, null, null));

		getContentPane().add(panneauInfos, BorderLayout.CENTER);
		panneauInfos.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblSaison = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_SAISON);
		panneauInfos.add(lblSaison);
		choixSaison = new JTextField();
		choixSaison.setEditable(false);
		panneauInfos.add(choixSaison);

		JLabel lblLarguer = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_LARGUEUR);
		panneauInfos.add(lblLarguer);
		choixLargeur = new JTextField();
		choixLargeur.setEditable(false);
		panneauInfos.add(choixLargeur);

		JLabel lblHauteur = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_HAUTEUR);
		panneauInfos.add(lblHauteur);
		choixHauteur = new JTextField();
		choixHauteur.setEditable(false);
		panneauInfos.add(choixHauteur);

		JLabel lblDiametre = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_DIAMETRE);
		panneauInfos.add(lblDiametre);
		choixDiametre = new JTextField();
		choixDiametre.setEditable(false);
		panneauInfos.add(choixDiametre);

		JLabel lblPrix = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_PRIX);
		panneauInfos.add(lblPrix);
		choixPrix = new JTextField();
		choixPrix.setEditable(false);
		panneauInfos.add(choixPrix);

		JLabel lblNbrPneus = new JLabel(ChainesDeTexte.ETIQUETTE_CHOIX_NBR_PNEUS);
		panneauInfos.add(lblNbrPneus);
		choixNbrPneus = new JTextField();
		choixNbrPneus.setEditable(false);
		panneauInfos.add(choixNbrPneus);
	}
	
	/**
	 * Initialise le panneau du bouton "Fermer"
	 */
	private void initialiserPanneauBouton() {
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

		btnFermer = new JButton(ChainesDeTexte.ETIQUETTE_FERMER);
		btnFermer.addActionListener(controleur);
		buttonPane.add(btnFermer);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * @return the btnFermer
	 */
	public JButton getBtnFermer() {
		return btnFermer;
	}

	/**
	 * @return the choixSaison
	 */
	public JTextField getChoixSaison() {
		return choixSaison;
	}

	/**
	 * @return the choixLargeur
	 */
	public JTextField getChoixLargeur() {
		return choixLargeur;
	}

	/**
	 * @return the choixHauteur
	 */
	public JTextField getChoixHauteur() {
		return choixHauteur;
	}

	/**
	 * @return the choixDiametre
	 */
	public JTextField getChoixDiametre() {
		return choixDiametre;
	}

	/**
	 * @return the choixPrix
	 */
	public JTextField getChoixPrix() {
		return choixPrix;
	}

	/**
	 * @return the choixNbrPneus
	 */
	public JTextField getChoixNbrPneus() {
		return choixNbrPneus;
	}
}
