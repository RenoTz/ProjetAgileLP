package controleur;

import javax.swing.JOptionPane;

import services.ActionsBateau;
import data.composants.Points;
import data.interfaceJeu.Interface;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;

public class Partie {
	
	//------------
	//  ATTRIBUTS 
	//------------

	private Interface interfaceJeu;
	private static Joueur joueur;
	private static Joueur adversaire;
	private ActionsBateau actions;
	private static boolean start;
	private String nomJoueur;
	private String nomAdversaire;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------

	public Partie(){
		this.actions = new ActionsBateau();
		this.initialiserLesJoueurs();
		this.initialiserLaListeDesBateaux();
		this.interfaceJeu = new Interface(joueur,adversaire);
		setStart(false);
		JOptionPane.showMessageDialog(null, "Veuillez placer votre " + joueur.getListeBateaux().get(0).getTypeBateau().toString());
	}
	
	//------------------------------
	// METHODES SPECIFIQUES PRIVEES
	//------------------------------
	
	private void initialiserLesJoueurs(){
		// Creation du joueur 1
		joueur = new Joueur();
		joueur.setNom(JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 1 :"));
		joueur.setEnTrainDeJouer(true);
		// Creation du joueur 2
		adversaire = new Joueur();
		adversaire.setNom(JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 2 :"));
	}
	
	private void initialiserLaListeDesBateaux() {
		joueur.setListeBateaux(actions.initialiserListeBateaux());
		adversaire.setListeBateaux(actions.initialiserListeBateaux());
	}
	
	public static boolean isStart() {
		return start;
	}

	public static void setStart(boolean start) {
		Partie.start = start;
	}

}
