package controleur;

import javax.swing.JOptionPane;

import services.ActionsBateau;
import data.interfaceJeu.Interface;
import data.joueur.Joueur;

public class Partie {

	// ------------
	// ATTRIBUTS
	// ------------

	private final Interface interfaceJeu;
	private static Joueur joueur;
	private static Joueur adversaire;
	private final ActionsBateau actions;
	private static boolean start;

	// ---------------
	// CONSTRUCTEUR
	// ---------------

	public Partie() {
		this.actions = new ActionsBateau();
		this.initialiserLesJoueurs();
		this.initialiserLaListeDesBateaux();
		this.interfaceJeu = new Interface(joueur, adversaire);
		setStart(false);
		interfaceJeu.getLabelConsole().setText("VEUILLEZ PLACER VOTRE " + joueur.getListeBateaux().get(0).getTypeBateau().toString());
	}

	// ------------------------------
	// METHODES SPECIFIQUES PRIVEES
	// ------------------------------

	private void initialiserLesJoueurs() {
		// Creation du joueur 1
		joueur = new Joueur();
		joueur.setNom(JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 1 :", "Joueur 1"));
		joueur.setEnTrainDeJouer(true);
		// Creation du joueur 2
		adversaire = new Joueur();
		adversaire.setNom(JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 2 :", "Joueur 2"));
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
