package data;
import java.awt.Point;

public class Bateau {

	/*
	 Attributs de la classe
	 */
	
	private int longueur;
	private Point pos;
	
	/*
	 Constructeur de la classe
	 */
	
	public Bateau(int longueur, Point pos){
		this.longueur = longueur;
		this.pos = pos;
	}
	
	/*
	 Getters/Setters de la classe
	 */
	
	public int getLongueur(){
		return this.longueur;
	}
	
	public Point getPos(){
		return this.pos;
	}
	
}
