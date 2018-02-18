/**
 * NordicPneuSGI.java
 */
package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ca.uqam.inf2120.tp3.modele.Pneu;

/**
 * GestionnaireInventairePneusVue. Fenêtre principal pour l'interface graphique
 * du Système de Gestion d' Inventaire de pneus.
 * 
 * @author Victor Piron PIRV11026606 INF2120 Groupe 30 (Ismaël Doukoure)
 *         piron_mardones.victor@courrier.uqam.ca
 * @version 2014-04-20
 * 
 * 
 */
public class GestionnaireInventairePneusVue extends JFrame {

	private static final long serialVersionUID = -661372543280356906L;
	private GestionnaireInventairePneusControleur controleur = new GestionnaireInventairePneusControleur(
			this);

	// Panneau Type de Recherche
	private JPanel panneauTypeRecherche;
	private ButtonGroup groupeBoutonsTypeRecherche;
	private JRadioButton rdbtnDiametre;
	private JRadioButton rdbtnNombreInferieur;
	private JRadioButton rdbtnTous;
	private JRadioButton rdbtnNombreSuperieur;

	// Panneau Recherche Hiver/Été
	private JPanel panneauSelectionSaison;
	private JCheckBox chckbxHiver;
	private JCheckBox chckbxEte;

	// Panneau Recherche
	private JPanel panneauRechercher;
	private JTextField textRechercher;
	private JButton boutonRechercher;

	// Panneau Affichage des Resultats
	private JPanel panneauTableResultats;
	private JTable tableResultats;

	// Panneau Boutons
	private JPanel panneauBoutons;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnAfficher;
	private JButton btnFermer;

	/**
	 * Lancer l'application
	 */
	public static void main(String[] args) {

		GestionnaireInventairePneusVue fenetreClient = new GestionnaireInventairePneusVue();
		fenetreClient.setVisible(true);
	}

	/**
	 * Initialiser l'application.
	 */
	public GestionnaireInventairePneusVue() {
		initialiser();
	}

	/**
	 * Initialiser le contenue de la frame.
	 */
	private void initialiser() {

		setTitle(ChainesDeTexte.TITRE_FENETRE_PRINCIPALE);
		setBounds(100, 100, 600, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 10));

		panneauTypeRecherche = new JPanel();
		getContentPane().add(
				initialiserPanneauTypeRecherche(panneauTypeRecherche));

		panneauSelectionSaison = new JPanel();
		getContentPane().add(
				initialiserPanneauSelectionSaison(panneauSelectionSaison));

		panneauRechercher = new JPanel();
		getContentPane().add(initialiserPanneauRecherche(panneauRechercher));

		panneauTableResultats = new JPanel();
		getContentPane().add(
				initialiserPanneauTableResultats(panneauTableResultats));

		panneauBoutons = new JPanel();
		getContentPane().add(initialiserPanneauBoutons(panneauBoutons));

	}

	/**
	 * @param panneau
	 */
	private JPanel initialiserPanneauTypeRecherche(JPanel panneau) {
		panneau.setBounds(100, 100, 600, 75);
		panneau.setLayout(new GridLayout(2, 2, 1, 1));
		panneau.setBorder(new TitledBorder(null,
				ChainesDeTexte.TITRE_PANNEAU_TYPE_DE_RECHERCHE, TitledBorder.LEFT,
				TitledBorder.TOP, null, null));

		// Création du groupe des radio boutons
		groupeBoutonsTypeRecherche = new ButtonGroup();

		rdbtnDiametre = new JRadioButton(ChainesDeTexte.ETIQUETTE_DIAMETRE);
		rdbtnDiametre.setSelected(true);
		rdbtnNombreInferieur = new JRadioButton(
				ChainesDeTexte.ETIQUETTE_NOMBRE_INFERIEUR);
		rdbtnTous = new JRadioButton(ChainesDeTexte.ETIQUETTE_TOUS);
		rdbtnNombreSuperieur = new JRadioButton(
				ChainesDeTexte.ETIQUETTE_NOMBRE_SUPERIEUR);

		// Ajout des radio boutons au groupe pour
		// permettre un choix exclusif.
		groupeBoutonsTypeRecherche.add(rdbtnDiametre);
		groupeBoutonsTypeRecherche.add(rdbtnNombreInferieur);
		groupeBoutonsTypeRecherche.add(rdbtnTous);
		groupeBoutonsTypeRecherche.add(rdbtnNombreSuperieur);
		
		rdbtnDiametre.addActionListener(controleur);
		rdbtnNombreInferieur.addActionListener(controleur);
		rdbtnNombreSuperieur.addActionListener(controleur);
		rdbtnTous.addActionListener(controleur);

		panneau.add(rdbtnDiametre);
		panneau.add(rdbtnNombreInferieur);
		panneau.add(rdbtnTous);
		panneau.add(rdbtnNombreSuperieur);

		return panneau;
	}

	/**
	 * @param panneau
	 */
	private JPanel initialiserPanneauSelectionSaison(JPanel panneau) {
		panneau.setBounds(100, 100, 600, 75);
		panneau.setLayout(new GridLayout(1, 2, 1, 1));
		panneau.setBorder(new TitledBorder(null,
				ChainesDeTexte.TITRE_PANNEAU_SELECTION_SAISON, TitledBorder.LEFT,
				TitledBorder.TOP, null, null));

		chckbxHiver = new JCheckBox(ChainesDeTexte.ETIQUETTE_SAISON_HIVER);

		chckbxHiver.setSelected(true);
		panneau.add(chckbxHiver);

		chckbxEte = new JCheckBox(ChainesDeTexte.ETIQUETTE_SAISON_ETE);
		panneau.add(chckbxEte);

		return panneau;
	}

	/**
	 * @param panneau
	 */
	private JPanel initialiserPanneauRecherche(JPanel panneau) {
		
		panneau.setBounds(100, 100, 600, 50);
		panneau.setBorder(new TitledBorder(null,
				"", TitledBorder.LEFT,
				TitledBorder.TOP, null, null));
		textRechercher = new JTextField();
		textRechercher.setColumns(20);

		panneau.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		panneau.add(textRechercher);

		boutonRechercher = new JButton(ChainesDeTexte.ETIQUETTE_RECHERCHER);
		boutonRechercher.addActionListener(controleur);
		
		panneau.add(boutonRechercher);

		return panneau;
	}

	/**
	 * @param panneau
	 */
	private JPanel initialiserPanneauTableResultats(JPanel panneau) {

		panneau.setVisible(false);
		panneau.setBounds(0, 0, 600, 250);

		tableResultats = new JTable(null, ChainesDeTexte.ENTETE_TABLEAU);
		tableResultats.setRowSelectionAllowed(true);

		tableResultats.setModel(new DefaultTableModel(null,
				ChainesDeTexte.ENTETE_TABLEAU) {
			private static final long serialVersionUID = 5500409053966709325L;
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		panneau.setLayout(new BorderLayout(0, 0));
		tableResultats.setEnabled(true);
		tableResultats.getSelectionModel().addListSelectionListener(controleur);

		JScrollPane scrollPane = new JScrollPane(tableResultats);
		panneau.add(scrollPane);

		return panneau;
	}

	// Rafraichir la table
	public void mettreAJourTableResultats(List<Pneu> listeResultatRecherche) {

		if (listeResultatRecherche != null && !listeResultatRecherche.isEmpty()) {

			Pneu monPneu;
			String mesDonnees[][] = new String[listeResultatRecherche.size()][3];

			for (int index = 0; index < listeResultatRecherche.size(); index++) {

				monPneu = listeResultatRecherche.get(index);
				mesDonnees[index][0] = monPneu.construireDecription();
				mesDonnees[index][1] = String.format("%.2f", monPneu.getPrix());
				mesDonnees[index][2] = String
						.valueOf(monPneu.obtenirNbCopies());
			}

			tableResultats.setModel(new DefaultTableModel(mesDonnees,
					ChainesDeTexte.ENTETE_TABLEAU) {
				private static final long serialVersionUID = 2639236265666260219L;
				boolean[] columnEditables = new boolean[] { false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tableResultats.getColumnModel().getColumn(0).setPreferredWidth(300);
			tableResultats.getColumnModel().getColumn(1).setPreferredWidth(100);
			tableResultats.getColumnModel().getColumn(2).setPreferredWidth(150);
			tableResultats.setRowSelectionInterval(0, 0);
			panneauTableResultats.setVisible(true);
			

		} else {
			panneauTableResultats.setVisible(false);
			permettreSelectionBoutons(false);
		}
	}

	/**
	 * @param panneau
	 */
	private JPanel initialiserPanneauBoutons(JPanel panneau) {
		
		panneau.setBounds(100, 100, 600, 75);
		panneau.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 35));

		btnAjouter = new JButton(ChainesDeTexte.ETIQUETTE_AJOUTER);
		btnAjouter.addActionListener(controleur);
		panneau.add(btnAjouter);

		btnModifier = new JButton(ChainesDeTexte.ETIQUETTE_MODIFIER);
		btnModifier.addActionListener(controleur);
		panneau.add(btnModifier);

		btnSupprimer = new JButton(ChainesDeTexte.ETIQUETTE_SUPPRIMER);
		btnSupprimer.addActionListener(controleur);
		panneau.add(btnSupprimer);

		btnAfficher = new JButton(ChainesDeTexte.ETIQUETTE_AFFICHER);
		btnAfficher.addActionListener(controleur);
		panneau.add(btnAfficher);

		btnFermer = new JButton(ChainesDeTexte.ETIQUETTE_FERMER);
		btnFermer.addActionListener(controleur);
		panneau.add(btnFermer);

		permettreSelectionBoutons(false);

		return panneau;
	}

	/**
	 * Changer la visibilité des boutons "Modifier", "Supprimer", "Afficher"
	 * @param estPermis
	 */
	protected void permettreSelectionBoutons(boolean estPermis) {

		btnModifier.setEnabled(estPermis);
		btnSupprimer.setEnabled(estPermis);
		btnAfficher.setEnabled(estPermis);

	}

	/**
	 * @return the rdbtnNombreSuperieur
	 */
	public JRadioButton getRdbtnNombreSuperieur() {
		return rdbtnNombreSuperieur;
	}

	/**
	 * @param rdbtnNombreSuperieur
	 *            the rdbtnNombreSuperieur to set
	 */
	public void setRdbtnNombreSuperieur(JRadioButton rdbtnNombreSuperieur) {
		this.rdbtnNombreSuperieur = rdbtnNombreSuperieur;
	}

	/**
	 * @return the rdbtnDiametre
	 */
	public JRadioButton getRdbtnDiametre() {
		return rdbtnDiametre;
	}

	/**
	 * @param rdbtnDiametre
	 *            the rdbtnDiametre to set
	 */
	public void setRdbtnDiametre(JRadioButton rdbtnDiametre) {
		this.rdbtnDiametre = rdbtnDiametre;
	}

	/**
	 * @return the rdbtnNombreInferieur
	 */
	public JRadioButton getRdbtnNombreInferieur() {
		return rdbtnNombreInferieur;
	}

	/**
	 * @param rdbtnNombreInferieur
	 *            the rdbtnNombreInferieur to set
	 */
	public void setRdbtnNombreInferieur(JRadioButton rdbtnNombreInferieur) {
		this.rdbtnNombreInferieur = rdbtnNombreInferieur;
	}

	/**
	 * @return the rdbtnTous
	 */
	public JRadioButton getRdbtnTous() {
		return rdbtnTous;
	}

	/**
	 * @param rdbtnTous
	 *            the rdbtnTous to set
	 */
	public void setRdbtnTous(JRadioButton rdbtnTous) {
		this.rdbtnTous = rdbtnTous;
	}

	/**
	 * @return the chckbxHiver
	 */
	public JCheckBox getChckbxHiver() {
		return chckbxHiver;
	}

	/**
	 * @param chckbxHiver
	 *            the chckbxHiver to set
	 */
	public void setChckbxHiver(JCheckBox chckbxHiver) {
		this.chckbxHiver = chckbxHiver;
	}

	/**
	 * @return the chckbxEte
	 */
	public JCheckBox getChckbxEte() {
		return chckbxEte;
	}

	/**
	 * @param chckbxEte
	 *            the chckbxEte to set
	 */
	public void setChckbxEte(JCheckBox chckbxEte) {
		this.chckbxEte = chckbxEte;
	}

	/**
	 * @return the boutonRechercher
	 */
	public JButton getBoutonRechercher() {
		return boutonRechercher;
	}

	/**
	 * @param boutonRechercher
	 *            the boutonRechercher to set
	 */
	public void setBoutonRechercher(JButton boutonRechercher) {
		this.boutonRechercher = boutonRechercher;
	}

	/**
	 * @return the textRechercher
	 */
	public JTextField getTextRechercher() {
		return textRechercher;
	}

	/**
	 * @param textRechercher
	 *            the textRechercher to set
	 */
	public void setTextRechercher(JTextField textRechercher) {
		this.textRechercher = textRechercher;
	}

	/**
	 * @return the btnAjouter
	 */
	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	/**
	 * @param btnAjouter
	 *            the btnAjouter to set
	 */
	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	/**
	 * @return the btnModifier
	 */
	public JButton getBtnModifier() {
		return btnModifier;
	}

	/**
	 * @param btnModifier
	 *            the btnModifier to set
	 */
	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	/**
	 * @return the btnSupprimer
	 */
	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	/**
	 * @param btnSupprimer
	 *            the btnSupprimer to set
	 */
	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	/**
	 * @return the btnAfficher
	 */
	public JButton getBtnAfficher() {
		return btnAfficher;
	}

	/**
	 * @param btnAfficher
	 *            the btnAfficher to set
	 */
	public void setBtnAfficher(JButton btnAfficher) {
		this.btnAfficher = btnAfficher;
	}

	/**
	 * @return the btnFermer
	 */
	public JButton getBtnFermer() {
		return btnFermer;
	}

	/**
	 * @param btnFermer
	 *            the btnFermer to set
	 */
	public void setBtnFermer(JButton btnFermer) {
		this.btnFermer = btnFermer;
	}

	/**
	 * @return the tableResultats
	 */
	public JTable getTableResultats() {
		return tableResultats;
	}

	/**
	 * @param tableResultats
	 *            the tableResultats to set
	 */
	public void setTableResultats(JTable tableResultats) {
		this.tableResultats = tableResultats;
	}

	/**
	 * @param choixNbrPneus
	 *            the choixNbrPneus to set
	 */
	public void showMessageInfo(String messageText) {

		// Afficher un message d'information
		Object[] options = { ChainesDeTexte.ETIQUETTE_FERMER };
		JOptionPane.showOptionDialog(null, messageText,
				ChainesDeTexte.PANNEAU_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	}

}
