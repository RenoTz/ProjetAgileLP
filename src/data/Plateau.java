package data;

public class Plateau {

	private int[][] lePlateau = new int[10][10];
	
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
