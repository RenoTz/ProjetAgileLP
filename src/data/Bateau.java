package data;
import java.awt.Point;

public class Bateau {

	/*
	 Attributs de la classe
	 */
	
	private int longueur;
	private Point posFront;
	private Point posBack;
	
	/*
	 Constructeur de la classe
	 */
	
	public Bateau(int longueur, Point posFront, Point posBack){
		this.longueur = longueur;
		this.posFront = posFront;
		this.posBack = posBack;
	}
	
	/*
	 Getters/Setters de la classe
	 */
	
	public int getLongueur(){
		return this.longueur;
	}
	
	public Point getPosFront(){
		return this.posFront;
	}
	
	public Point getPosBack(){
		return this.posBack;
	}
}
