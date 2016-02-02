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
		int cpt = 1;
		System.out.println("   A  B  C  D  E  F  G  H  I  J");
		for( int i = 0; i < lePlateau.length; i++ ){
			if(cpt < 10){
				System.out.print(cpt+" ");
			}else{
				System.out.print(cpt);
			}
			
		  for( int j = 0; j < lePlateau[0].length; j++ ) {
			  System.out.print("|_|");
		  }
		  System.out.println(); // retour chariot (changement de ligne du plateau)
		  cpt++;
		}
	}
}

