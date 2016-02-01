package data;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enumeration.EnumTypeBateau;

public class Bateau {

	//-----------------------
	// Attributs de la classe
	//-----------------------
	
	private EnumTypeBateau typeBateau;
	private Point posFront;
	private Point posBack;
	private List<Points> listePoints;
	private boolean touche;
	private boolean coule;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Bateau(EnumTypeBateau typeBateau) {
		this.typeBateau = typeBateau;
		setListePoints(new ArrayList<Points>());
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

	public List<Points> getListePoints() {
		return listePoints;
	}

	public void setListePoints(List<Points> listePoints) {
		this.listePoints = listePoints;
	}
}
