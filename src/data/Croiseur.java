package data;

import enumeration.EnumTypeBateau;

public class Croiseur extends Bateau{
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Points[] tabPoints;
	private boolean touche;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------

	public Croiseur(EnumTypeBateau typeBateau) {
		super(typeBateau);
		this.setTabPoints(new Points[4]);
	}
	
	//-----------------
	//	GETTERS/SETTERS
	//-----------------

	public Points[] getTabPoints() {
		return tabPoints;
	}

	public void setTabPoints(Points[] tabPoints) {
		this.tabPoints = tabPoints;
	}

	public boolean isTouche() {
		return touche;
	}

	public void setTouche(boolean touche) {
		this.touche = touche;
	}

}
