package data;
import java.awt.Point;
import java.util.ArrayList;

import enumeration.EnumTypeBateau;

public class Bateau {

	//-----------------------
	// Attributs de la classe
	//-----------------------
	
	private EnumTypeBateau typeBateau;
	private Point posFront;
	private Point posBack;
	private ArrayList<Point> listePoints;
	private boolean touche;
	private boolean coule;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Bateau(EnumTypeBateau typeBateau) {
		this.typeBateau = typeBateau;
	}
	
	public Bateau(EnumTypeBateau typeBateau, Point posFront, Point posBack){
		this.typeBateau = typeBateau;
		this.posFront = posFront;
		this.posBack = posBack;
		
		
		this.listePoints.add(posFront);
		this.listePoints.add(posBack);
		
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
	
	public ArrayList<Point> getListePoints(){
		return this.listePoints;
	}

	public boolean isTouche() {
		return touche;
	}

	public void setTouche(boolean touche) {
		this.touche = touche;
	}

	public boolean isCoule() {
		return coule;
	}

	public void setCoule(boolean coule) {
		this.coule = coule;
	}
}
