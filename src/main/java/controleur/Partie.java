package controleur;

import javax.swing.JOptionPane;

import data.interfaceJeu.Interface;
import data.joueur.Joueur;
import services.ActionsBateau;

public class Partie {

	// ------------
	// ATTRIBUTS
	// ------------

	private final Interface interfaceJeu;
	private Joueur joueur;
	private Joueur adversaire;
	private final ActionsBateau actions;
	private static boolean start;

	// ---------------
	// CONSTRUCTEUR
	// ---------------

	public Partie() {
		this.actions = new ActionsBateau();
		this.initialiserLesJoueurs();
		this.initialiserLaListeDesBateaux();
		this.interfaceJeu = new Interface(this.joueur, this.adversaire);
		setStart(false);
		this.interfaceJeu.getLabelConsole().setText("VEUILLEZ PLACER VOTRE " + this.joueur.getListeBateaux().get(0).getTypeBateau().toString());
	}

	// ------------------------------
	// METHODES SPECIFIQUES PRIVEES
	// ------------------------------

	private void initialiserLesJoueurs() {
		// Creation du joueur 1
		this.joueur = new Joueur();
		this.joueur.setNom(JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 1 :", "Joueur 1"));
		this.joueur.setEnTrainDeJouer(true);
		// Creation du joueur 2
		this.adversaire = new Joueur();
		this.adversaire.setNom(JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 2 :", "Joueur 2"));
	}

	private void initialiserLaListeDesBateaux() {
		this.joueur.setListeBateaux(this.actions.initialiserBateaux());
		this.adversaire.setListeBateaux(this.actions.initialiserBateaux());
	}

	public static boolean isStart() {
		return start;
	}

	public static void setStart(final boolean start) {
		Partie.start = start;
	}

}
