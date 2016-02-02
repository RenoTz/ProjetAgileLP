package data.interfaceJeu;

import data.composants.Case;
import data.composants.Points;

public class Plateau {

	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private static Case[][] lePlateau;
	
	//------------------------
	//  CONSTRUCTEUR
	//------------------------
	public Plateau(int largeur, int longueur){
		this.setLePlateau(new Case[largeur][longueur]);
		initPlateau();
	}
	
	//------------------------
	//  METHODES DE LA CLASSE
	//------------------------

	private static void initPlateau(){
		for( int i = 0; i < lePlateau.length; i++ ){
			for( int j = 0; j < lePlateau.length; j++ ) {
				  Case casePlateau = new Case(new Points((char) ('A' + i), j + 1));
				  lePlateau[i][j] = casePlateau;
			  }
		}
		
		log();
	}

	//-----------------
	//	GETTERS/SETTERS
	//-----------------

	public Case[][] getLePlateau() {
		return lePlateau;
	}

	public void setLePlateau(Case[][] lePlateau) {
		Plateau.lePlateau = lePlateau;
	}
	
	public static void log() {
		// TODO : affichage plateau dans console -> TEMPORAIRE
		for( int i = 0; i < lePlateau.length; i++ ){
			for( int j = 0; j < lePlateau.length; j++ ) {
				  System.out.print("["+lePlateau[i][j].getPoint().getxPos()+lePlateau[i][j].getPoint().getyPos()+"]");
			}	
			System.out.println("\n");
		}
	}
}

