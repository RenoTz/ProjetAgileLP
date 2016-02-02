import services.ActionsBateau;
import data.Joueur;
import data.Points;
import data.Plateau;
import data.interfaceJeu.Interface;
import enumeration.EnumTypeBateau;


public class Main {

	public static void main(String[] args) {
		
		// Cr�ation de l'interface graphique
		Interface interfaceJeu = new Interface();
		// TODO RT : � supprimer quand la m�thode de cr�ation d'une partie sera pr�te ////
		ActionsBateau action = new ActionsBateau();
		// Creation du joueur
		Joueur j = new Joueur();
		
		// Intialisation de la liste des bateaux
		j.setListeBateaux(action.initialiserListeBateaux());
		
		// TODO RT : Cr�ation d'une nouvelle partie (fixe temporairement, al�atoire A VENIR !!!)
		// Placement des bateaux
		action.placerBateau(j, EnumTypeBateau.PORTE_AVION, new Points('A', 1), new Points('A', 5));
		action.placerBateau(j, EnumTypeBateau.CROISEUR, new Points('B', 1), new Points('E', 1));
		action.placerBateau(j, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		action.placerBateau(j, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		action.placerBateau(j, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		
		// TODO RT : � supprimer quand la m�thode de cr�ation d'une partie sera pr�te ////
	
		Plateau P = new Plateau(10,10);
		
		
		
		
		
		
		
	}

}
