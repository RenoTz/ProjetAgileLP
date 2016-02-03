package data.bateau;

import data.composants.Points;
import enumeration.EnumTypeBateau;
import data.composants.*;

public abstract class Bateau {

	//-----------------------
	// Attributs de la classe
	//-----------------------
	
	private boolean coule;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Bateau() {
	}
	
	//-----------------------------
	// Getters/Setters de la classe
	//-----------------------------

	public boolean isCoule() {
		return coule;
	}

	public void setCoule(boolean coule) {
		this.coule = coule;
	}
	
	public abstract Points[] getTabPoints();
	
	public abstract EnumTypeBateau getTypeBateau();

}
