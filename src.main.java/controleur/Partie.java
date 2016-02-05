package controleur;

import services.ActionsBateau;
import data.composants.Points;
import data.interfaceJeu.Interface;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;

public class Partie {
	
	private Interface interfaceJeu;
	private static Joueur joueur;
	private static Joueur adversaire;
	private ActionsBateau actions;
	
	public Partie(){
		this.actions = new ActionsBateau();
		this.initialiserLesJoueurs();
		this.interfaceJeu = new Interface(joueur,adversaire);
		this.initialiserLaListeDesBateaux();
		this.assignerLesCoordonneesAuxBateaux();
		this.placerLesBateauxSurLesPlateaux();
	}
	
	public void initialiserLesJoueurs(){
		// Creation du joueur 1
		joueur = new Joueur();
		joueur.setNom("Gérard");
		joueur.setEnTrainDeJouer(true);
		// Creation du joueur 2
		adversaire = new Joueur();
		adversaire.setNom("Bobby");
	}
	
	private void initialiserLaListeDesBateaux() {
		joueur.setListeBateaux(actions.initialiserListeBateaux());
		adversaire.setListeBateaux(actions.initialiserListeBateaux());
	}
	
	private void assignerLesCoordonneesAuxBateaux() {
		// On assigne les coordonnées des bateaux du joueur
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.PORTE_AVION, new Points('A', 3), new Points('A', 7));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.CROISEUR, new Points('C', 1), new Points('F', 1));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		// On assigne les coordonnées des bateaux de l'adversaire	
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.PORTE_AVION, new Points('B', 4), new Points('B', 8));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.CROISEUR, new Points('E', 1), new Points('H', 1));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('F', 3), new Points('F', 5));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.SOUS_MARIN, new Points('D', 5), new Points('F', 5));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.TORPILLEUR, new Points('J', 2), new Points('J', 3));
	}
	
	private void placerLesBateauxSurLesPlateaux() {
		actions.placerLesBateauxSurLePlateau(joueur.getListeBateaux(),interfaceJeu.getPlateauJoueur());
		actions.placerLesBateauxSurLePlateau(adversaire.getListeBateaux(),interfaceJeu.getPlateauAdversaire());
	}

}
