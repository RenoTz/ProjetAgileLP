package data.bateau;

import data.plateau.Position;
import enumeration.EnumTypeBateau;

public class Torpilleur extends Bateau{
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Position[] tabPoints;
	private boolean touche;
	private EnumTypeBateau typeBateau;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	public Torpilleur(){
		this.tabPoints = new Position[2];
		this.typeBateau = EnumTypeBateau.TORPILLEUR;
	}

	//-----------------
	//	GETTERS/SETTERS
	//-----------------
		
	public Position[] getTabPoints() {
		return tabPoints;
	}

	public boolean isTouche() {
		return touche;
	}

	public void setTouche(boolean touche) {
		this.touche = touche;
	}

	public EnumTypeBateau getTypeBateau() {
		return typeBateau;
	}

}
