package data.bateau;

import data.composants.Points;
import enumeration.EnumTypeBateau;

public class SousMarin extends Bateau{
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Points[] tabPoints;
	private boolean touche;
	private EnumTypeBateau typeBateau;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	public SousMarin() {
		this.tabPoints = new Points[3];
		this.typeBateau = EnumTypeBateau.SOUS_MARIN;
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
