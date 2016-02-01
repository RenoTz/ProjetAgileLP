package data;
import java.awt.Point;

public class Bateau {

	private int longueur;
	private Point pos;
	
	
	public Bateau(int longueur, Point pos){
		this.longueur = longueur;
		this.pos = pos;
	}
	
	public int getLongueur(){
		return this.longueur;
	}
	
	public Point getPos(){
		return this.pos;
	}
	
}
