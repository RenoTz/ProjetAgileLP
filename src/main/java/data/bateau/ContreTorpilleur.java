package data.bateau;

import data.plateau.Position;
import enumeration.EnumTypeBateau;

public class ContreTorpilleur extends Bateau{
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Position[] tabPoints;
	private boolean touche;
	private EnumTypeBateau typeBateau;

	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	public ContreTorpilleur() {
		this.tabPoints = new Position[3];
		this.typeBateau = EnumTypeBateau.CONTRE_TORPILLEUR;
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
