package controleur;
import java.util.Random;

import services.ActionsBateau;
import utils.FactoryUtils;
import data.composants.Points;
import data.interfaceJeu.Interface;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;


public class Main {

	public static void main(String[] args) {
		
		
		// Creation de l'interface graphique
		Interface interfaceJeu = new Interface();
		
		ActionsBateau actions = new ActionsBateau();
		
		// Creation du joueur
		Joueur joueur = new Joueur();
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
		
		int randomOrientation = new Random().nextInt(2) + 1; //1 Horizontal 2 Vertical

		int xPADebut, xPAFin, yPADebut, yPAFin;
		
		if(randomOrientation == 1){
			//Porte Avion
			xPADebut = new Random().nextInt(5) + 1;
			xPAFin = xPADebut + 4;
			yPADebut = new Random().nextInt(10) + 1;
			yPAFin = yPADebut;
			actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.PORTE_AVION, new Points(FactoryUtils.convertirIntToChar(xPADebut), yPADebut), new Points(FactoryUtils.convertirIntToChar(xPAFin), yPAFin));			
		}else if(randomOrientation == 2){
			xPADebut = new Random().nextInt(10) + 1;
			xPAFin = xPADebut;
			yPADebut = new Random().nextInt(5) + 1;
			yPAFin = yPADebut + 4;
			actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.PORTE_AVION, new Points(FactoryUtils.convertirIntToChar(xPADebut), yPADebut), new Points(FactoryUtils.convertirIntToChar(xPAFin), yPAFin));	
		}
		
		//actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.CROISEUR, new Points('E', 1), new Points('H', 1));
		//actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		//actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		//actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		
		// Placement des bateaux sur le plateau
		actions.placerLesBateauxSurLePlateau(joueur.getListeBateaux(),interfaceJeu.getPlateau());
		actions.placerLesBateauxSurLePlateau(adversaire.getListeBateaux(),interfaceJeu.getPlateauAdversaire());
	}

}
