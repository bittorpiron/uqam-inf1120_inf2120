package ca.uqam.inf1120.examplesetlabos;


/**
 * I N F 1 1 2 0
 *
 * Petit programme qui lit le contenu d'un fichier d'inventaire (appelé Inventaire.txt)
 * qui contient des informations sur la quantité et le poids unitaire de chacun des
 * produits en magasin. Le fichier respecte le format suivant:
 * 
 *          __________________________
 *          |nom du produit 1        |
 *          |quantité                |
 *          |poids unitaire          |
 *          |nom du produit 2        |
 *          |quantité                |
 *          |poids unitaire          |
 *          |nom du produit 1        |
 *          |quantité                |
 *          |poids unitaire          |
 *          etc.
 *          etc.
 *          etc.
 *          etc.
 *          |________________________|
 *          
 * Il y a donc une seule information par ligne et les informations d'un produit tiennent 
 * sur 3 lignes (voir aussi fichier Inventaire.txt).
 * 
 * Le programme contruit un nouveau fichier (appelé Poids.txt) qui contient le nom de chacun
 * des produits en inventaire suivit du poids TOTAL des unités de ce produit (somme du poids
 * unitaires de chacune des unités du produit).
 * 
 * Tout le code est écrit dans la méthode main et les exceptions FileNotFoundException et
 * IOException sont gérées dans le main. Il est à noté que, si l'une ou l'autre de ces 
 * exceptions est levée, un message descriptif est affiché et le programme se termine. 
 * 
 * @author Céline Deschenaaux
 * @version Automne 2009
 *
 * 
 */
 
import java.io.*; //pour l'utilisation des classes associées à la gestion de fichiers

public class GestionInventaire {

    
    
    public static void main (String[] params) {
        
        FileReader ficInventaire; //servira de lien logique entre le fichier physique
                                  //et le programme
                                  
        BufferedReader lecteurInv;//Futures "lunettes" pour lire dans un fichier
        
        FileWriter ficPoids;   //servira de lien logique entre le fichier physique
                               //et le programme
                               
        PrintWriter ecrivainPoids;//Future "crayon" pour lire dans un fichier
        
        
        //Variables qui contiendront les informations sur un produit
        String nomProd;
        int qte;
        int poidsUnitaire;
        
        try{
                //création du lien logique...
                ficInventaire = new FileReader ("C:/Users/Victor/workspace/uqam_2014/Resources/Inventaire.txt");
                
                //association des "lunettes" avec le fichier
                lecteurInv = new BufferedReader(ficInventaire);
                
                //création du lien logique...
                ficPoids = new FileWriter("C:/Users/Victor/workspace/uqam_2014/Resources/Poids.txt");
                
                //association du "crayon" avec le fichier. Si le fichier existe déja`,
                //il est écrasé
                ecrivainPoids = new PrintWriter(ficPoids);
                
                while(lecteurInv.ready()){
                    //Lecture des information sur un produit
                    nomProd = lecteurInv.readLine().trim();
                    qte = Integer.parseInt(lecteurInv.readLine().trim());
                    poidsUnitaire = Integer.parseInt(lecteurInv.readLine().trim());
                    
                    //Écriture dansle fichier des poids
                    ecrivainPoids.println("Nom : " + nomProd);
                    ecrivainPoids.println("Poids total : " + qte * poidsUnitaire);
                    
                }//fin while
                
                //Fermeture des fichiers
                lecteurInv.close();
                ecrivainPoids.close();
            
            //gestion des exceptions    
            }catch (FileNotFoundException e){
                System.out.print("Erreur! Fichier de lecture inexisitant!");
            }catch (IOException e){
                System.out.print("Erreur d'entrée/sortie");
            }//fin try...catch
        
    } // main
    
} // GestionInventaire
