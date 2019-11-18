package data.bateau;

import data.plateau.Position;
import enumeration.EnumTypeBateau;

public class SousMarin extends Bateau{
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Position[] tabPoints;
	private boolean touche;
	private EnumTypeBateau typeBateau;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	public SousMarin() {
		this.tabPoints = new Position[3];
		this.typeBateau = EnumTypeBateau.SOUS_MARIN;
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
