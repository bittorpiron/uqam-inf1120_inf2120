import java.text.DecimalFormat;

/**
 * Reclamation.java
 */

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2015-01-24
 */
public class Reclamation {
	
    int numeroReclamation=0;
    int numeroSoin=0;
    String date;
    double montant;
 
    static final DecimalFormat dec2 = new DecimalFormat ( "0.00" );
    
	/**
	 * @return the id
	 */
	public int getId() {
		return numeroReclamation;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.numeroReclamation = id;
	}
	/**
	 * @return the nombreSoin
	 */
	public int getNombreSoin() {
		return numeroSoin;
	}
	/**
	 * @param nombreSoin the nombreSoin to set
	 */
	public void setNombreSoin(int nombreSoin) {
		this.numeroSoin = nombreSoin;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

    
}
