package controleur;
import java.awt.Color;
import java.util.Random;

import services.ActionsBateau;
import data.bateau.Bateau;
import data.composants.Points;
import data.interfaceJeu.Interface;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;


public class Main {
	
	private static Joueur joueur;

	public static Joueur getJoueur() {
		return joueur;
	}

	public static void main(String[] args) {
		
		
		// Creation de l'interface graphique
		Interface interfaceJeu = new Interface();
		
		ActionsBateau actions = new ActionsBateau();
		
		// Creation du joueur
		joueur = new Joueur();
		Joueur adversaire = new Joueur();
		
		// Intialisation de la liste des bateaux des joueurs
		joueur.setListeBateaux(actions.initialiserListeBateaux());
		adversaire.setListeBateaux(actions.initialiserListeBateaux());
		
		// TODO RT : Creation d'une nouvelle partie (fixe temporairement, aleatoire A VENIR !!!)
		// Placement des bateaux du joueur
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.PORTE_AVION, new Points('A', 1), new Points('A', 5));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.CROISEUR, new Points('C', 1), new Points('F', 1));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		
		// Placement des bateaux de l'adversaire	
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.PORTE_AVION, new Points('A', 3), new Points('A', 7));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.CROISEUR, new Points('E', 1), new Points('H', 1));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		
		// Placement des bateaux sur le plateau
		actions.placerLesBateauxSurLePlateau(joueur.getListeBateaux(),interfaceJeu.getPlateauJoueur());
		actions.placerLesBateauxSurLePlateau(adversaire.getListeBateaux(),interfaceJeu.getPlateauAdversaire());
		
			
	}

	public static void verifierSiToutesLesCasesDuBateauSontTouches( Interface interfaceJeu, Joueur joueur) {
		for(Bateau bateau : joueur.getListeBateaux()){
			for(int i = 0; i < interfaceJeu.getPlateauJoueur().getLePlateau().length; i++){
				for(int j = 0; j < interfaceJeu.getPlateauJoueur().getLePlateau().length; j++){
					if((bateau.getTabPoints()[i].getxPos() == interfaceJeu.getPlateauJoueur().getLePlateau()[i][j].getPoint().getxPos()) 
							&& interfaceJeu.getPlateauJoueur().getLePlateau()[i][j].getCouleur().equals(Color.RED)){
						System.out.println("test");
						
					}
				}
			}
		}
	}

}
