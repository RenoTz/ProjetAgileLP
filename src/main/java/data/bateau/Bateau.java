package data.bateau;

import data.plateau.Position;
import enumeration.EnumTypeBateau;

public abstract class Bateau {

	//-----------------------
	// Attributs de la classe
	//-----------------------
	
	private boolean coule;
	private boolean place;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Bateau() {
	}
	
	//------------------------
	// METHODES DE LA CLASSE
	//------------------------
	
	public abstract Position[] getTabPoints();
	
	public abstract EnumTypeBateau getTypeBateau();
	
	//-----------------------------
	// Getters/Setters de la classe
	//-----------------------------

	public boolean isCoule() {
		return coule;
	}

	public void setCoule(boolean coule) {
		this.coule = coule;
	}
	
	public boolean isPlace() {
		return place;
	}

	public void setPlace(boolean place) {
		this.place = place;
	}

}
