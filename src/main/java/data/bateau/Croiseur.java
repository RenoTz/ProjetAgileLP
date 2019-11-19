package data.bateau;

import data.composants.Points;
import enumeration.EnumTypeBateau;

public class Croiseur extends Bateau{
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Points[] tabPoints;
	private boolean touche;
	private EnumTypeBateau typeBateau;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------

	public Croiseur() {
		this.tabPoints = new Points[4];
		this.typeBateau = EnumTypeBateau.CROISEUR;
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
