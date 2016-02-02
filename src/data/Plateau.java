package data;

public class Plateau {

	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	private Points[][] lePlateau;
	
	//------------------------
	//  CONSTRUCTEUR
	//------------------------
	public Plateau(int largeur, int longueur){
		this.lePlateau = new Points[largeur][longueur];
	}
	
	//------------------------
	//  METHODES DE LA CLASSE
	//------------------------
	public void initPlateau(){
		
		Points p;
		
		//Mise en forme
		System.out.println("   A  B  C  D  E  F  G  H  I  J");
		for( int i = 1; i <= lePlateau.length; i++ ){
			//On commence à la lettre A, puis on va incrémenter pour créer les Points
			char lettrex = 'A';
			
			//Mise en forme (pour garder un tableau droit en affichage console lors qu'on passe à 2 chiffres)
			if(i < 10){
				System.out.print(i+" ");
			}else{
				System.out.print(i);
			}	
			
			for( int j = 1; j <= lePlateau[0].length; j++ ) {
				//Création d'un point l'abscisse lettrex et d'ordonnée i (numéro de ligne)
				p = new Points(lettrex, i);
				System.out.print("|_|");
				//On incrémente la lettre (char + 1 = lettre suivante)
				lettrex++;
			}
		
		System.out.println(); // retour chariot (changement de ligne du plateau)
		}
	}
}

