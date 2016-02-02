import services.ActionsBateau;
import data.Joueur;
import data.Points;

import data.Plateau;
import data.bateau.Bateau;
import enumeration.EnumTypeBateau;


public class Main {

	public static void main(String[] args) {
		
		// TODO RT : à supprimer quand la méthode de création d'une partie sera prête ////
		ActionsBateau action = new ActionsBateau();
		// Creation du joueur
		Joueur j = new Joueur();
		
		// Intialisation de la liste des bateaux
		j.setListeBateaux(action.initialiserListeBateaux());
		
		// Placement des bateaux
		action.placerBateau(j, EnumTypeBateau.PORTE_AVION, new Points('A', 1), new Points('A', 5));
		action.placerBateau(j, EnumTypeBateau.CROISEUR, new Points('B', 1), new Points('E', 1));
		
		// TODO RT : à supprimer quand la méthode de création d'une partie sera prête ////
	
		Plateau P = new Plateau(10,10);
		
		P.initPlateau();
		
	}

}
