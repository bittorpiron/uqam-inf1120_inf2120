package ca.uqam.inf1120.examplesetlabos;


/**
 * I N F 1 1 2 0
 *
 * Petit programme qui montre comment on peut manipuler des tableaux à deux dimensions
 * et comment écrire du code qui fonctionne peu importe le nombre de rangées et de
 * colonne du tableau. En effet, le même code fonctionne avec :
 * 
 *      int [][] tabDeuxD = new int [3][4];
 * 
 * et avec un tableau "irrégulier" comme : 
 * 
 *      int tabDeuxD [][] = new int [5][];
 *      tabDeuxD[0] = new int [3];
 *      tabDeuxD[1] = new int [2];
 *      tabDeuxD[2] = new int [5];
 *      tabDeuxD[3] = new int [1];
 *      tabDeuxD[4] = new int [2];
 *      
 *      
 *  Pour voir comment se comporte le programme avec l'un ou l'autre des tableaux, il suffit
 *  de mettre en commentaires le code servant à la définition/création du tableau qu'on ne veut 
 *  pas tester et de ne pas mettre en commentaires le code de définition/création du tableau 
 *  qu'on veut utiliser pour les tests.
 * 
 * @author Céline Descheneaux 
 * @version 2009
 *
 *
 */
 
public class DemoDeuxDime {

    // Autres méthodes s'il y a lieu
    
    public static void main (String[] params) {
        
        //tableau de 3 rangées (lignes) et 4 colonnes
        int [][] tabDeuxD = new int [3][4];
        
        /*int tabDeuxD [][] = new int [5][];
        tabDeuxD[0] = new int [3];
        tabDeuxD[1] = new int [2];
        tabDeuxD[2] = new int [5];
        tabDeuxD[3] = new int [1];
        tabDeuxD[4] = new int [2];
        */
               
        int numeroCase = 0;
        
        //assigner un numéro à chaque case
        for(int ligne = 0; ligne < tabDeuxD.length; ligne++){
            for(int col = 0; col < tabDeuxD[ligne].length; col++){
                tabDeuxD[ligne][col] = numeroCase;
                numeroCase = numeroCase + 1;
            }//for
        }//for
        
        //imprimer le contenu des cases lignes par lignes
        for(int ligne = 0; ligne < tabDeuxD.length; ligne++){
            for(int col = 0; col < tabDeuxD[ligne].length; col++){
                System.out.print(tabDeuxD[ligne][col] + " ");
            }//for
            System.out.println();
        }//for
        
    } // main
    
} // DemoDeuxDime
