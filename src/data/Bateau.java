package data;
import java.awt.Point;

import enumeration.EnumTypeBateau;

public class Bateau {

	//-----------------------
	// Attributs de la classe
	//-----------------------
	
	private EnumTypeBateau typeBateau;
	private Point posFront;
	private Point posBack;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Bateau(EnumTypeBateau typeBateau, Point posFront, Point posBack){
		this.typeBateau = typeBateau;
		this.posFront = posFront;
		this.posBack = posBack;
	}
	
	//-----------------------------
	// Getters/Setters de la classe
	//-----------------------------
	
	public Point getPosFront(){
		return this.posFront;
	}

	public EnumTypeBateau getTypeBateau() {
		return typeBateau;
	}

	public Point getPosBack(){
		return this.posBack;
	}
}
