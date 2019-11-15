package data.bateau;

import data.composants.Points;
import enumeration.EnumTypeBateau;

public class Torpilleur extends Bateau{
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Points[] tabPoints;
	private boolean touche;
	private EnumTypeBateau typeBateau;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	public Torpilleur(){
		this.tabPoints = new Points[2];
		this.typeBateau = EnumTypeBateau.TORPILLEUR;
	}

	//-----------------
	//	GETTERS/SETTERS
	//-----------------
		
	public Points[] getTabPoints() {
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
