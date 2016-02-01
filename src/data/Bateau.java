package data;
import java.awt.Point;

public class Bateau {

	/*
	 Attributs de la classe
	 */
	
	private String type;
	private Point posFront;
	private Point posBack;
	
	/*
	 Constructeur de la classe
	 */
	
	public Bateau(String type, Point posFront, Point posBack){
		this.type = type;
		this.posFront = posFront;
		this.posBack = posBack;
	}
	
	/*
	 Getters/Setters de la classe
	 */
	
	public String getType(){
		return this.type;
	}
	
	public Point getPosFront(){
		return this.posFront;
	}
	
	public Point getPosBack(){
		return this.posBack;
	}
}
