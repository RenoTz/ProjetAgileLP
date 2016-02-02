package data;

public class Plateau {

	private int[][] lePlateau;
	
	public Plateau(int largeur, int longueur){
		this.lePlateau = new int[largeur][longueur];
	}
	
	public void initPlateau(){
		int x = 1;
		for(int i = 0; i < lePlateau.length; i++){
		   for(int j = 0; j < lePlateau[0].length; j++){
			   lePlateau[i][j] = x;
		       x++;
		   }
		}
	}
	
}
