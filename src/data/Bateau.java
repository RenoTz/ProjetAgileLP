package data;
import java.awt.Point;

import enumeration.EnumTypeBateau;

public class Bateau {

	//-----------------------
	// Attributs de la classe
	//-----------------------
	
	private EnumTypeBateau typeBateau;
	private Point pos;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Bateau(EnumTypeBateau typeBateau, Point pos){
		this.typeBateau = typeBateau;
		this.pos = pos;
	}
	
	//-----------------------------
	// Getters/Setters de la classe
	//-----------------------------
	
	public Point getPos(){
		return this.pos;
	}

	public EnumTypeBateau getTypeBateau() {
		return typeBateau;
	}

}
