package data;

import data.interfaceJeu.Case;

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
				  Case casePlateau = new Case(new Points((char) ('A' + j), i + 1));
				  lePlateau[i][j] = casePlateau;
			  }
		}
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
}

