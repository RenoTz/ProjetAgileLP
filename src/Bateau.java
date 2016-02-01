import java.awt.Point;

public class Bateau {

	private int longueur;
	private Point pos;
	private String orientation;
	
	
	public Bateau(int longueur, Point pos, String orientation){
		this.longueur = longueur;
		this.pos = pos;
		this.orientation = orientation;
	}
	
	public int getLongueur(){
		return this.longueur;
	}
	
	public Point getPos(){
		return this.pos;
	}
	
	public String getOrientation(){
		return this.orientation;
	}
	
	
	
}
