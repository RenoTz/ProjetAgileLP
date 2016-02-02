package data;

public class Plateau {

	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	private int[][] lePlateau;
	
	//------------------------
	//  CONSTRUCTEUR
	//------------------------
	public Plateau(int largeur, int longueur){
		this.lePlateau = new int[largeur][longueur];
	}
	
	//------------------------
	//  METHODES DE LA CLASSE
	//------------------------
	public void initPlateau(){
		char lettre = 'A';
		System.out.println("  1  2  3  4  5  6  7  8  9  10");
		for( int i = 0; i < lePlateau.length; i++ ){
			System.out.print(lettre);
			for( int j = 0; j < lePlateau[0].length; j++ ) {
				System.out.print("|_|");
			}
		  System.out.println(); // retour chariot (changement de ligne du plateau)
		  lettre++;
		}
	}
}

